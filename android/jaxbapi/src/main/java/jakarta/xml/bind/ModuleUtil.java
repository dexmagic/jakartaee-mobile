/*
 * Copyright (c) 2017, 2022 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package jakarta.xml.bind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Propagates openness of Jakarta XML Binding annotated classes packages to Jakarta XML Binding impl module.
 *
 * @author Roman Grigoriadi
 */
class ModuleUtil {

    private static final Logger LOGGER = Logger.getLogger("jakarta.xml.bind");

    /**
     * Resolves classes from context path.
     * Only one class per package is needed to access its {@link java.lang.Module}
     */
    static Class<?>[] getClassesFromContextPath(String contextPath, ClassLoader classLoader) throws JAXBException {
        List<Class<?>> classes = new ArrayList<>();
        if (contextPath == null || contextPath.isEmpty()){
            return classes.toArray(new Class<?>[]{});
        }

        String [] tokens = contextPath.split(":");
        for (String pkg : tokens){

            // look for ObjectFactory and load it
            try {
                final Class<?> o = classLoader.loadClass(pkg+".ObjectFactory");
                classes.add(o);
                continue;
            } catch (ClassNotFoundException e) {
                // not necessarily an error
            }

            // look for jaxb.index and load the list of classes
            try {
                final Class<?> firstByJaxbIndex = findFirstByJaxbIndex(pkg, classLoader);
                if (firstByJaxbIndex != null) {
                    classes.add(firstByJaxbIndex);
                }
            } catch (IOException e) {
                throw new JAXBException(e);
            }
        }

        if (LOGGER.isLoggable(Level.FINE)) {
            LOGGER.log(Level.FINE, "Resolved classes from context path: {0}", classes);
        }
        return classes.toArray(new Class<?>[]{});
    }

    /**
     * Find first class in package by {@code jaxb.index} file.
     */
    static Class<?> findFirstByJaxbIndex(String pkg, ClassLoader classLoader) throws IOException, JAXBException {
        final String resource = pkg.replace('.', '/') + "/jaxb.index";
        final InputStream resourceAsStream = classLoader.getResourceAsStream(resource);

        if (resourceAsStream == null) {
            return null;
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(resourceAsStream, "UTF-8"))) {
            String className = in.readLine();
            while (className != null) {
                className = className.trim();
                if (className.startsWith("#") || (className.length() == 0)) {
                    className = in.readLine();
                    continue;
                }

                try {
                    return classLoader.loadClass(pkg + '.' + className);
                } catch (ClassNotFoundException e) {
                    throw new JAXBException(Messages.format(Messages.ERROR_LOAD_CLASS, className, pkg), e);
                }

            }
        }
        return null;
    }

    /**
     * Not used on Android
     */
    public static void delegateAddOpensToImplModule(Class<?>[] classes, Class<?> factorySPI) throws JAXBException {
        throw new UnsupportedOperationException("not supported on Android.");
    }

}
