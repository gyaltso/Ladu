/**
 * Copyright (C) 2020, 2021 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package com.gyaltso.lcp.ladu.entitydsl.entityDsl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslFactory
 * @model kind="package"
 * @generated
 */
public interface EntityDslPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "entityDsl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.gyaltso.com/lcp/ladu/entitydsl/EntityDsl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "entityDsl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EntityDslPackage eINSTANCE = com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityDslPackageImpl.init();

  /**
   * The meta object id for the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.DefinitionImpl <em>Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.DefinitionImpl
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityDslPackageImpl#getDefinition()
   * @generated
   */
  int DEFINITION = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__NAME = 0;

  /**
   * The feature id for the '<em><b>Import Section</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__IMPORT_SECTION = 1;

  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__MODELS = 2;

  /**
   * The number of structural features of the '<em>Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.ModelImpl
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityDslPackageImpl#getModel()
   * @generated
   */
  int MODEL = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NAME = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.AnnotatedElementImpl <em>Annotated Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.AnnotatedElementImpl
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityDslPackageImpl#getAnnotatedElement()
   * @generated
   */
  int ANNOTATED_ELEMENT = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATED_ELEMENT__NAME = MODEL__NAME;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATED_ELEMENT__ANNOTATIONS = MODEL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Annotated Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATED_ELEMENT_FEATURE_COUNT = MODEL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EEnumImpl <em>EEnum</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EEnumImpl
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityDslPackageImpl#getEEnum()
   * @generated
   */
  int EENUM = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EENUM__NAME = MODEL__NAME;

  /**
   * The feature id for the '<em><b>Literals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EENUM__LITERALS = MODEL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>EEnum</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EENUM_FEATURE_COUNT = MODEL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.LiteralImpl
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityDslPackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL__NAME = 0;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.LayoutImpl <em>Layout</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.LayoutImpl
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityDslPackageImpl#getLayout()
   * @generated
   */
  int LAYOUT = 5;

  /**
   * The feature id for the '<em><b>Inlines</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYOUT__INLINES = 0;

  /**
   * The number of structural features of the '<em>Layout</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LAYOUT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.InlineImpl <em>Inline</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.InlineImpl
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityDslPackageImpl#getInline()
   * @generated
   */
  int INLINE = 6;

  /**
   * The feature id for the '<em><b>Properties</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE__PROPERTIES = 0;

  /**
   * The number of structural features of the '<em>Inline</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityImpl <em>Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityImpl
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityDslPackageImpl#getEntity()
   * @generated
   */
  int ENTITY = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__NAME = ANNOTATED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__ANNOTATIONS = ANNOTATED_ELEMENT__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Master</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__MASTER = ANNOTATED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Super Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__SUPER_TYPE = ANNOTATED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__PROPERTIES = ANNOTATED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Layout</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__LAYOUT = ANNOTATED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_FEATURE_COUNT = ANNOTATED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.PropertyImpl <em>Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.PropertyImpl
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityDslPackageImpl#getProperty()
   * @generated
   */
  int PROPERTY = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__NAME = ANNOTATED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__ANNOTATIONS = ANNOTATED_ELEMENT__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Array</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__ARRAY = ANNOTATED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__TYPE = ANNOTATED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_FEATURE_COUNT = ANNOTATED_ELEMENT_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Definition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Definition</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Definition
   * @generated
   */
  EClass getDefinition();

  /**
   * Returns the meta object for the attribute '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Definition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Definition#getName()
   * @see #getDefinition()
   * @generated
   */
  EAttribute getDefinition_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Definition#getImportSection <em>Import Section</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Import Section</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Definition#getImportSection()
   * @see #getDefinition()
   * @generated
   */
  EReference getDefinition_ImportSection();

  /**
   * Returns the meta object for the containment reference list '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Definition#getModels <em>Models</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Models</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Definition#getModels()
   * @see #getDefinition()
   * @generated
   */
  EReference getDefinition_Models();

  /**
   * Returns the meta object for class '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Model#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Model#getName()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Name();

  /**
   * Returns the meta object for class '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.AnnotatedElement <em>Annotated Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotated Element</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.AnnotatedElement
   * @generated
   */
  EClass getAnnotatedElement();

  /**
   * Returns the meta object for the containment reference list '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.AnnotatedElement#getAnnotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotations</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.AnnotatedElement#getAnnotations()
   * @see #getAnnotatedElement()
   * @generated
   */
  EReference getAnnotatedElement_Annotations();

  /**
   * Returns the meta object for class '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.EEnum <em>EEnum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EEnum</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.EEnum
   * @generated
   */
  EClass getEEnum();

  /**
   * Returns the meta object for the containment reference list '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.EEnum#getLiterals <em>Literals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Literals</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.EEnum#getLiterals()
   * @see #getEEnum()
   * @generated
   */
  EReference getEEnum_Literals();

  /**
   * Returns the meta object for class '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for the attribute '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Literal#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Literal#getName()
   * @see #getLiteral()
   * @generated
   */
  EAttribute getLiteral_Name();

  /**
   * Returns the meta object for class '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Layout <em>Layout</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Layout</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Layout
   * @generated
   */
  EClass getLayout();

  /**
   * Returns the meta object for the containment reference list '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Layout#getInlines <em>Inlines</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Inlines</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Layout#getInlines()
   * @see #getLayout()
   * @generated
   */
  EReference getLayout_Inlines();

  /**
   * Returns the meta object for class '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Inline <em>Inline</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inline</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Inline
   * @generated
   */
  EClass getInline();

  /**
   * Returns the meta object for the reference list '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Inline#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Properties</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Inline#getProperties()
   * @see #getInline()
   * @generated
   */
  EReference getInline_Properties();

  /**
   * Returns the meta object for class '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity <em>Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entity</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity
   * @generated
   */
  EClass getEntity();

  /**
   * Returns the meta object for the attribute '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity#isMaster <em>Master</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Master</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity#isMaster()
   * @see #getEntity()
   * @generated
   */
  EAttribute getEntity_Master();

  /**
   * Returns the meta object for the containment reference '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity#getSuperType <em>Super Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Super Type</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity#getSuperType()
   * @see #getEntity()
   * @generated
   */
  EReference getEntity_SuperType();

  /**
   * Returns the meta object for the containment reference list '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Properties</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity#getProperties()
   * @see #getEntity()
   * @generated
   */
  EReference getEntity_Properties();

  /**
   * Returns the meta object for the containment reference '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity#getLayout <em>Layout</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Layout</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity#getLayout()
   * @see #getEntity()
   * @generated
   */
  EReference getEntity_Layout();

  /**
   * Returns the meta object for class '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Property <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Property
   * @generated
   */
  EClass getProperty();

  /**
   * Returns the meta object for the attribute '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Property#isArray <em>Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Array</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Property#isArray()
   * @see #getProperty()
   * @generated
   */
  EAttribute getProperty_Array();

  /**
   * Returns the meta object for the containment reference '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.Property#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.Property#getType()
   * @see #getProperty()
   * @generated
   */
  EReference getProperty_Type();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  EntityDslFactory getEntityDslFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.DefinitionImpl <em>Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.DefinitionImpl
     * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityDslPackageImpl#getDefinition()
     * @generated
     */
    EClass DEFINITION = eINSTANCE.getDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEFINITION__NAME = eINSTANCE.getDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Import Section</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINITION__IMPORT_SECTION = eINSTANCE.getDefinition_ImportSection();

    /**
     * The meta object literal for the '<em><b>Models</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINITION__MODELS = eINSTANCE.getDefinition_Models();

    /**
     * The meta object literal for the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.ModelImpl
     * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityDslPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

    /**
     * The meta object literal for the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.AnnotatedElementImpl <em>Annotated Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.AnnotatedElementImpl
     * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityDslPackageImpl#getAnnotatedElement()
     * @generated
     */
    EClass ANNOTATED_ELEMENT = eINSTANCE.getAnnotatedElement();

    /**
     * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATED_ELEMENT__ANNOTATIONS = eINSTANCE.getAnnotatedElement_Annotations();

    /**
     * The meta object literal for the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EEnumImpl <em>EEnum</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EEnumImpl
     * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityDslPackageImpl#getEEnum()
     * @generated
     */
    EClass EENUM = eINSTANCE.getEEnum();

    /**
     * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EENUM__LITERALS = eINSTANCE.getEEnum_Literals();

    /**
     * The meta object literal for the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.LiteralImpl
     * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityDslPackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL__NAME = eINSTANCE.getLiteral_Name();

    /**
     * The meta object literal for the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.LayoutImpl <em>Layout</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.LayoutImpl
     * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityDslPackageImpl#getLayout()
     * @generated
     */
    EClass LAYOUT = eINSTANCE.getLayout();

    /**
     * The meta object literal for the '<em><b>Inlines</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LAYOUT__INLINES = eINSTANCE.getLayout_Inlines();

    /**
     * The meta object literal for the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.InlineImpl <em>Inline</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.InlineImpl
     * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityDslPackageImpl#getInline()
     * @generated
     */
    EClass INLINE = eINSTANCE.getInline();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INLINE__PROPERTIES = eINSTANCE.getInline_Properties();

    /**
     * The meta object literal for the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityImpl <em>Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityImpl
     * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityDslPackageImpl#getEntity()
     * @generated
     */
    EClass ENTITY = eINSTANCE.getEntity();

    /**
     * The meta object literal for the '<em><b>Master</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENTITY__MASTER = eINSTANCE.getEntity_Master();

    /**
     * The meta object literal for the '<em><b>Super Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTITY__SUPER_TYPE = eINSTANCE.getEntity_SuperType();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTITY__PROPERTIES = eINSTANCE.getEntity_Properties();

    /**
     * The meta object literal for the '<em><b>Layout</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTITY__LAYOUT = eINSTANCE.getEntity_Layout();

    /**
     * The meta object literal for the '{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.PropertyImpl <em>Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.PropertyImpl
     * @see com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityDslPackageImpl#getProperty()
     * @generated
     */
    EClass PROPERTY = eINSTANCE.getProperty();

    /**
     * The meta object literal for the '<em><b>Array</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY__ARRAY = eINSTANCE.getProperty_Array();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY__TYPE = eINSTANCE.getProperty_Type();

  }

} //EntityDslPackage
