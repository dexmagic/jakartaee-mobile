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
import jakarta.xml.bind.annotation.XmlElementWrapper;
import org.glassfish.jaxb.core.v2.model.annotation.Locatable;


/**
 * <p><b>Auto-generated, do not edit.</b></p>
 * 
 */
final class XmlElementWrapperQuick
    extends Quick
    implements XmlElementWrapper
{

    private final XmlElementWrapper core;

    public XmlElementWrapperQuick(Locatable upstream, XmlElementWrapper core) {
        super(upstream);
        this.core = core;
    }

    @Override
    protected Annotation getAnnotation() {
        return core;
    }

    @Override
    protected Quick newInstance(Locatable upstream, Annotation core) {
        return new XmlElementWrapperQuick(upstream, ((XmlElementWrapper) core));
    }

    @Override
    public Class<XmlElementWrapper> annotationType() {
        return XmlElementWrapper.class;
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
    public boolean nillable() {
        return core.nillable();
    }

    @Override
    public boolean required() {
        return core.required();
    }

}
