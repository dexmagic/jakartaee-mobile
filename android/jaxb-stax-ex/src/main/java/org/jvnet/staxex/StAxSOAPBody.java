/*
 * Copyright (c) 2013, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */
package org.jvnet.staxex;

import android.xml.stream.XMLStreamException;
import android.xml.stream.XMLStreamReader;
import android.xml.stream.XMLStreamWriter;

import javax.xml.namespace.QName;

/**
 * A StAxSOAPBody is a SOAPBody that allows to be loaded from a StAX style
 * payload.
 *
 * @author shih-chang.chen@oracle.com
 */
public interface StAxSOAPBody {

    /**
     * The StAxSOAPBody represents the StAX source of SOAPBody payload.
     */
    public static interface Payload {

        /**
         * Retrieve payload qname without materializing its contents
         *
         * @return qname
         */
        public QName getPayloadQName();

        public XMLStreamReader readPayload() throws XMLStreamException;

        public void writePayloadTo(XMLStreamWriter writer) throws XMLStreamException;

        /**
         * Retrieve payload attribute value without materializing its contents
         *
         * @param localName attribute local name
         * @return payload attribute value
         * @throws XMLStreamException for errors
         */
        public String getPayloadAttributeValue(String localName) throws XMLStreamException;

        /**
         * Retrieve payload attribute value without materializing its contents
         *
         * @param qName attribute QName
         * @return payload attribute value
         * @throws XMLStreamException for errors
         */
        public String getPayloadAttributeValue(QName qName) throws XMLStreamException;

        public void materialize() throws XMLStreamException;
    }

    public void setPayload(Payload src) throws XMLStreamException;

    public Payload getPayload() throws XMLStreamException;

    public boolean hasStaxPayload();
}
