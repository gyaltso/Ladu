/*******************************************************************************
 * Copyright (C) 2020, 2021 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package com.gyaltso.lcp.ladu.entitydsl;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class EntityDslStandaloneSetup extends EntityDslStandaloneSetupGenerated {

	public static void doSetup() {
		new EntityDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
