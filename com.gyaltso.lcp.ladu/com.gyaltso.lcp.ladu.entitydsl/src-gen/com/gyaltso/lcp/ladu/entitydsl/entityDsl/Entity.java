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

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity#isMaster <em>Master</em>}</li>
 *   <li>{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity#getLayout <em>Layout</em>}</li>
 * </ul>
 *
 * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslPackage#getEntity()
 * @model
 * @generated
 */
public interface Entity extends AnnotatedElement
{
  /**
   * Returns the value of the '<em><b>Master</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Master</em>' attribute.
   * @see #setMaster(boolean)
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslPackage#getEntity_Master()
   * @model
   * @generated
   */
  boolean isMaster();

  /**
   * Sets the value of the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity#isMaster <em>Master</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Master</em>' attribute.
   * @see #isMaster()
   * @generated
   */
  void setMaster(boolean value);

  /**
   * Returns the value of the '<em><b>Super Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Type</em>' containment reference.
   * @see #setSuperType(JvmParameterizedTypeReference)
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslPackage#getEntity_SuperType()
   * @model containment="true"
   * @generated
   */
  JvmParameterizedTypeReference getSuperType();

  /**
   * Sets the value of the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity#getSuperType <em>Super Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Type</em>' containment reference.
   * @see #getSuperType()
   * @generated
   */
  void setSuperType(JvmParameterizedTypeReference value);

  /**
   * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
   * The list contents are of type {@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.AnnotatedElement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' containment reference list.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslPackage#getEntity_Properties()
   * @model containment="true"
   * @generated
   */
  EList<AnnotatedElement> getProperties();

  /**
   * Returns the value of the '<em><b>Layout</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Layout</em>' containment reference.
   * @see #setLayout(Layout)
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslPackage#getEntity_Layout()
   * @model containment="true"
   * @generated
   */
  Layout getLayout();

  /**
   * Sets the value of the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity#getLayout <em>Layout</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Layout</em>' containment reference.
   * @see #getLayout()
   * @generated
   */
  void setLayout(Layout value);

} // Entity
