/*******************************************************************************
 * Copyright (C) 2020, 2021 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package com.gyaltso.lcp.ladu.entitydsl.ui;

import com.google.inject.Injector;
import com.gyaltso.lcp.ladu.entitydsl.ui.internal.EntitydslActivator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class EntityDslExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Platform.getBundle(EntitydslActivator.PLUGIN_ID);
	}
	
	@Override
	protected Injector getInjector() {
		EntitydslActivator activator = EntitydslActivator.getInstance();
		return activator != null ? activator.getInjector(EntitydslActivator.COM_GYALTSO_LCP_LADU_ENTITYDSL_ENTITYDSL) : null;
	}

}
