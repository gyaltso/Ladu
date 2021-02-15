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

import org.eclipse.xtext.xtype.XImportSection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Definition#getName <em>Name</em>}</li>
 *   <li>{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Definition#getImportSection <em>Import Section</em>}</li>
 *   <li>{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Definition#getModels <em>Models</em>}</li>
 * </ul>
 *
 * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslPackage#getDefinition()
 * @model
 * @generated
 */
public interface Definition extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslPackage#getDefinition_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Definition#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Import Section</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import Section</em>' containment reference.
   * @see #setImportSection(XImportSection)
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslPackage#getDefinition_ImportSection()
   * @model containment="true"
   * @generated
   */
  XImportSection getImportSection();

  /**
   * Sets the value of the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Definition#getImportSection <em>Import Section</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Import Section</em>' containment reference.
   * @see #getImportSection()
   * @generated
   */
  void setImportSection(XImportSection value);

  /**
   * Returns the value of the '<em><b>Models</b></em>' containment reference list.
   * The list contents are of type {@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Model}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Models</em>' containment reference list.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslPackage#getDefinition_Models()
   * @model containment="true"
   * @generated
   */
  EList<Model> getModels();

} // Definition
