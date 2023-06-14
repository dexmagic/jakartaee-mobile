/*
 * Copyright (c) 2023 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */


package org.glassfish.jaxb.runtime.v2.model.annotation;

import java.lang.annotation.Annotation;
import jakarta.xml.bind.annotation.XmlType;
import org.glassfish.jaxb.core.v2.model.annotation.Locatable;


/**
 * <p><b>Auto-generated, do not edit.</b></p>
 * 
 */
final class XmlTypeQuick
    extends Quick
    implements XmlType
{

    private final XmlType core;

    public XmlTypeQuick(Locatable upstream, XmlType core) {
        super(upstream);
        this.core = core;
    }

    @Override
    protected Annotation getAnnotation() {
        return core;
    }

    @Override
    protected Quick newInstance(Locatable upstream, Annotation core) {
        return new XmlTypeQuick(upstream, ((XmlType) core));
    }

    @Override
    public Class<XmlType> annotationType() {
        return XmlType.class;
    }

    @Override
    public Class factoryClass() {
        return core.factoryClass();
    }

    @Override
    public String factoryMethod() {
        return core.factoryMethod();
    }

    @Override
    public String name() {
        return core.name();
    }

    @Override
    public String namespace() {
        return core.namespace();
    }

    @Override
    public String[] propOrder() {
        return core.propOrder();
    }

}
