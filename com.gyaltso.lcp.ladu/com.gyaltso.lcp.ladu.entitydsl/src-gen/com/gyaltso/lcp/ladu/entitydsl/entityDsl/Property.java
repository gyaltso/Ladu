/**
 * Copyright (C) 2020, 2021 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package com.gyaltso.lcp.ladu.entitydsl.entityDsl;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Property#isArray <em>Array</em>}</li>
 *   <li>{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Property#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslPackage#getProperty()
 * @model
 * @generated
 */
public interface Property extends AnnotatedElement
{
  /**
   * Returns the value of the '<em><b>Array</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Array</em>' attribute.
   * @see #setArray(boolean)
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslPackage#getProperty_Array()
   * @model
   * @generated
   */
  boolean isArray();

  /**
   * Sets the value of the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Property#isArray <em>Array</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Array</em>' attribute.
   * @see #isArray()
   * @generated
   */
  void setArray(boolean value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(JvmParameterizedTypeReference)
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslPackage#getProperty_Type()
   * @model containment="true"
   * @generated
   */
  JvmParameterizedTypeReference getType();

  /**
   * Sets the value of the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Property#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(JvmParameterizedTypeReference value);

} // Property
