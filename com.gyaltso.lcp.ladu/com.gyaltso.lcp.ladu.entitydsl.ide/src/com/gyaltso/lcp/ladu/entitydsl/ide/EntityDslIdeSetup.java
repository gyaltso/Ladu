/*******************************************************************************
 * Copyright (C) 2020, 2021 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package com.gyaltso.lcp.ladu.entitydsl.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.gyaltso.lcp.ladu.entitydsl.EntityDslRuntimeModule;
import com.gyaltso.lcp.ladu.entitydsl.EntityDslStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class EntityDslIdeSetup extends EntityDslStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new EntityDslRuntimeModule(), new EntityDslIdeModule()));
	}
	
}
