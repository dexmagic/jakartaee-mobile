/*
 * Copyright (c) 2010, 2022 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package org.jvnet.staxex;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * {@link DataHandler} extended to offer better buffer management
 * in a streaming environment.
 *
 * <p>
 * {@link DataHandler} is used commonly as a data format across
 * multiple systems (such as JAXB/WS.) Unfortunately, {@link DataHandler}
 * has the semantics of "read as many times as you want", so this makes
 * it difficult for involving parties to handle a BLOB in a streaming fashion.
 *
 * <p>
 * {@link StreamingDataHandler} solves this problem by offering methods
 * that enable faster bulk "consume once" read operation.
 *
 * @author Jitendra Kotamraju
 */
public abstract class StreamingDataHandler extends DataHandler implements Closeable {
    
    private String hrefCid;
    
    public StreamingDataHandler(Object o, String s) {
        super(o, s);
    }

    public StreamingDataHandler(URL url) {
        super(url);
    }

    public StreamingDataHandler(DataSource dataSource) {
        super(dataSource);
    }

    /**
     * Works like {@link #getInputStream()} except that this method
     * can be invoked only once.
     *
     * <p>
     * This is used as a signal from the caller that there will
     * be no further {@link #getInputStream()} invocation nor
     * {@code readOnce()} invocation on this object (which would
     * result in {@link IOException}.)
     *
     * <p>
     * When {@link DataHandler} is backed by a streaming BLOB
     * (such as an attachment in a web service read from the network),
     * this allows the callee to avoid unnecessary buffering.
     *
     * <p>
     * Note that it is legal to call {@link #getInputStream()}
     * multiple times and then call {@code readOnce()} afterward.
     * Streams created such a way can be read in any order &mdash;
     * there's no requirement that streams created earlier must be read
     * first.
     *
     * @return
     *      always non-null. Represents the content of this BLOB.
     *      The returned stream is generally not buffered, so for
     *      better performance read in a big batch or wrap this into
     *      {@link BufferedInputStream}.
     * @throws IOException
     *      if any i/o error
     */
    public abstract InputStream readOnce() throws IOException;

    /**
     * Obtains the BLOB into a specified file.
     *
     * <p>
     * Semantically, this method is roughly equivalent to the following
     * code, except that the actual implementation is likely to be a lot faster.
     *
     * <pre>
     * InputStream i = getInputStream();
     * OutputStream o = new FileOutputStream(dst);
     * int ch;
     * while((ch=i.read())!=-1)  o.write(ch);
     * i.close();
     * o.close();
     * </pre>
     *
     * <p>
     * The main motivation behind this method is that often
     * {@link DataHandler} that reads data from a streaming source
     * will use a temporary file as a data store to hold data
     * (think of commons-fileupload.) In such case this method
     * can be as fast as calling {@link File#renameTo(File)}.
     *
     * <p>
     * This method shouldn't be called when there are any
     * open streams.
     *
     * <p>
     * After this method is invoked, {@link #readOnce()} and
     * {@link #getInputStream()} will simply open the destination
     * file you've specified as an argument. So if you further
     * move the file or delete this file, those methods will
     * behave in undefined fashion. For a simliar reason,
     * calling this method multiple times will cause
     * undefined behavior.  
     * @throws IOException for errors
     */
    public abstract void moveTo(File dst) throws IOException;

    /**
     * Releases any resources associated with this DataHandler.
     * (such as an attachment in a web service read from a temp
     * file will be deleted.) After calling this method, it is
     * illegal to call any other methods.
     * @throws IOException for errors
     */
    @Override
    public abstract void close() throws IOException;

    public String getHrefCid() {
        return hrefCid;
    }

    public void setHrefCid(final String cid) {
        this.hrefCid = cid;
    }
}

