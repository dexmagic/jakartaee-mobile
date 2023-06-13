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
 * Template {@link Accessor} for long fields.
 * <p><b>
 *     Auto-generated, do not edit.
 * </b></p>
 * <p>
 *     All the FieldAccessors are generated from <code>FieldAccessor_Byte</code>
 * </p>
 * @author Kohsuke Kawaguchi
 */
public class FieldAccessor_Long<B> extends Accessor<B, Long> {
    public FieldAccessor_Long() {
        super(Long.class);
    }

    @Override
    public Long get(B bean) {
        return ((Bean)bean).f_long;
    }

    @Override
    public void set(B bean, Long value) {
        ((Bean)bean).f_long = value==null ? Const.default_value_long : value;
    }
}
