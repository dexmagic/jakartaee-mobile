/*
 * Copyright (c) 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package org.glassfish.jaxb.core;

// Not available until API 34.
// import java.lang.StackWalker;

/**
 * Utils for stack trace analysis in Java 9+.
 *
 * @author Philippe Marschall
 */
final class StackHelper {
    private StackHelper() {}   // no instanciation

    /**
     * Returns the name of the calling class of the second method in the call chain of this method.
     *
     * @return the name of the caller class
     * @throws SecurityException in case a security manager is installed that
     *                           prevents stack introspection
     */
    static String getCallerClassName() {
        throw new UnsupportedOperationException("not available until Android API 34");
/*
       return StackWalker.getInstance()
                .walk(frames ->
                        frames.map(StackFrame::getClassName)
                                .skip(2L)
                                .findFirst()
                                .get());
*/
    }
}