/**
 * Copyright (C) 2020, 2021 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package com.gyaltso.lcp.ladu.entitydsl.entityDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Layout#getInlines <em>Inlines</em>}</li>
 * </ul>
 *
 * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslPackage#getLayout()
 * @model
 * @generated
 */
public interface Layout extends EObject
{
  /**
   * Returns the value of the '<em><b>Inlines</b></em>' containment reference list.
   * The list contents are of type {@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Inline}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inlines</em>' containment reference list.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslPackage#getLayout_Inlines()
   * @model containment="true"
   * @generated
   */
  EList<Inline> getInlines();

} // Layout
