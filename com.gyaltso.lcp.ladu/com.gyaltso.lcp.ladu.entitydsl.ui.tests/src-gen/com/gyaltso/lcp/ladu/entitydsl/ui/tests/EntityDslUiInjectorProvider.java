/*******************************************************************************
 * Copyright (C) 2020, 2021 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package com.gyaltso.lcp.ladu.entitydsl.ui.tests;

import com.google.inject.Injector;
import com.gyaltso.lcp.ladu.entitydsl.ui.internal.EntitydslActivator;
import org.eclipse.xtext.testing.IInjectorProvider;

public class EntityDslUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return EntitydslActivator.getInstance().getInjector("com.gyaltso.lcp.ladu.entitydsl.EntityDsl");
	}

}
