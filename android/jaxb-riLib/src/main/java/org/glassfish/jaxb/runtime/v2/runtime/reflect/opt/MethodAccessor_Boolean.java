/*
 * Copyright (c) 1997, 2022 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package org.glassfish.jaxb.runtime.v2.runtime.reflect.opt;

import org.glassfish.jaxb.runtime.v2.runtime.reflect.Accessor;

/**
 * Template {@link Accessor} for boolean getter/setter.
 * <p><b>
 *     Auto-generated, do not edit.
 * </b></p>
 * <p>
 *     All the MethodAccessors are generated from <code>MethodAccessor_Byte</code>
 * </p>
 * @author Kohsuke Kawaguchi
 */
public class MethodAccessor_Boolean<B> extends Accessor<B, Boolean> {
    public MethodAccessor_Boolean() {
        super(Boolean.class);
    }

    @Override
    public Boolean get(B bean) {
        return ((Bean)bean).get_boolean();
    }

    @Override
    public void set(B bean, Boolean value) {
        ((Bean)bean).set_boolean( value==null ? Const.default_value_boolean : value );
    }
}
