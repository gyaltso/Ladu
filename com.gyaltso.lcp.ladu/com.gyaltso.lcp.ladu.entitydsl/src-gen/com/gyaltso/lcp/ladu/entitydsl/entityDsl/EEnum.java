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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EEnum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.EEnum#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslPackage#getEEnum()
 * @model
 * @generated
 */
public interface EEnum extends Model
{
  /**
   * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
   * The list contents are of type {@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Literal}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literals</em>' containment reference list.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslPackage#getEEnum_Literals()
   * @model containment="true"
   * @generated
   */
  EList<Literal> getLiterals();

} // EEnum
