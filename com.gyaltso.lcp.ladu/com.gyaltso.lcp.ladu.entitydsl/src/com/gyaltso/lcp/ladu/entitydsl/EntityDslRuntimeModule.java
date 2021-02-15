/*******************************************************************************
 * Copyright (C) 2020, 2021 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package com.gyaltso.lcp.ladu.entitydsl;

import com.gyaltso.lcp.ladu.entitydsl.scoping.EntityDslGlobalScopeProvider;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class EntityDslRuntimeModule extends AbstractEntityDslRuntimeModule {

	@Override
	public void configureIScopeProviderDelegate(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider.class)
				.annotatedWith(com.google.inject.name.Names
						.named("org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider.delegate"))
				.to(EntityDslGlobalScopeProvider.class);
	}

}
