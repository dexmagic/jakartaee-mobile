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
import jakarta.xml.bind.annotation.XmlAnyElement;
import org.glassfish.jaxb.core.v2.model.annotation.Locatable;


/**
 * <p><b>Auto-generated, do not edit.</b></p>
 * 
 */
final class XmlAnyElementQuick
    extends Quick
    implements XmlAnyElement
{

    private final XmlAnyElement core;

    public XmlAnyElementQuick(Locatable upstream, XmlAnyElement core) {
        super(upstream);
        this.core = core;
    }

    @Override
    protected Annotation getAnnotation() {
        return core;
    }

    @Override
    protected Quick newInstance(Locatable upstream, Annotation core) {
        return new XmlAnyElementQuick(upstream, ((XmlAnyElement) core));
    }

    @Override
    public Class<XmlAnyElement> annotationType() {
        return XmlAnyElement.class;
    }

    @Override
    public boolean lax() {
        return core.lax();
    }

    @Override
    public Class value() {
        return core.value();
    }

}
