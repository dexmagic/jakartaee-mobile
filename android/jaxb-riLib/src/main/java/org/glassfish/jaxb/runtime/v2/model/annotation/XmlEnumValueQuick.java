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
import jakarta.xml.bind.annotation.XmlEnumValue;
import org.glassfish.jaxb.core.v2.model.annotation.Locatable;


/**
 * <p><b>Auto-generated, do not edit.</b></p>
 * 
 */
final class XmlEnumValueQuick
    extends Quick
    implements XmlEnumValue
{

    private final XmlEnumValue core;

    public XmlEnumValueQuick(Locatable upstream, XmlEnumValue core) {
        super(upstream);
        this.core = core;
    }

    @Override
    protected Annotation getAnnotation() {
        return core;
    }

    @Override
    protected Quick newInstance(Locatable upstream, Annotation core) {
        return new XmlEnumValueQuick(upstream, ((XmlEnumValue) core));
    }

    @Override
    public Class<XmlEnumValue> annotationType() {
        return XmlEnumValue.class;
    }

    @Override
    public String value() {
        return core.value();
    }

}
