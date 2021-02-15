/**
 * Copyright (C) 2020, 2021 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl;

import com.gyaltso.lcp.ladu.entitydsl.entityDsl.AnnotatedElement;
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity;
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslPackage;
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.Layout;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityImpl#isMaster <em>Master</em>}</li>
 *   <li>{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityImpl#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.gyaltso.lcp.ladu.entitydsl.entityDsl.impl.EntityImpl#getLayout <em>Layout</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntityImpl extends AnnotatedElementImpl implements Entity
{
  /**
   * The default value of the '{@link #isMaster() <em>Master</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMaster()
   * @generated
   * @ordered
   */
  protected static final boolean MASTER_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isMaster() <em>Master</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMaster()
   * @generated
   * @ordered
   */
  protected boolean master = MASTER_EDEFAULT;

  /**
   * The cached value of the '{@link #getSuperType() <em>Super Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperType()
   * @generated
   * @ordered
   */
  protected JvmParameterizedTypeReference superType;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected EList<AnnotatedElement> properties;

  /**
   * The cached value of the '{@link #getLayout() <em>Layout</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLayout()
   * @generated
   * @ordered
   */
  protected Layout layout;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EntityImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return EntityDslPackage.Literals.ENTITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isMaster()
  {
    return master;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setMaster(boolean newMaster)
  {
    boolean oldMaster = master;
    master = newMaster;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EntityDslPackage.ENTITY__MASTER, oldMaster, master));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JvmParameterizedTypeReference getSuperType()
  {
    return superType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSuperType(JvmParameterizedTypeReference newSuperType, NotificationChain msgs)
  {
    JvmParameterizedTypeReference oldSuperType = superType;
    superType = newSuperType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EntityDslPackage.ENTITY__SUPER_TYPE, oldSuperType, newSuperType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSuperType(JvmParameterizedTypeReference newSuperType)
  {
    if (newSuperType != superType)
    {
      NotificationChain msgs = null;
      if (superType != null)
        msgs = ((InternalEObject)superType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EntityDslPackage.ENTITY__SUPER_TYPE, null, msgs);
      if (newSuperType != null)
        msgs = ((InternalEObject)newSuperType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EntityDslPackage.ENTITY__SUPER_TYPE, null, msgs);
      msgs = basicSetSuperType(newSuperType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EntityDslPackage.ENTITY__SUPER_TYPE, newSuperType, newSuperType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AnnotatedElement> getProperties()
  {
    if (properties == null)
    {
      properties = new EObjectContainmentEList<AnnotatedElement>(AnnotatedElement.class, this, EntityDslPackage.ENTITY__PROPERTIES);
    }
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Layout getLayout()
  {
    return layout;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLayout(Layout newLayout, NotificationChain msgs)
  {
    Layout oldLayout = layout;
    layout = newLayout;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EntityDslPackage.ENTITY__LAYOUT, oldLayout, newLayout);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLayout(Layout newLayout)
  {
    if (newLayout != layout)
    {
      NotificationChain msgs = null;
      if (layout != null)
        msgs = ((InternalEObject)layout).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EntityDslPackage.ENTITY__LAYOUT, null, msgs);
      if (newLayout != null)
        msgs = ((InternalEObject)newLayout).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EntityDslPackage.ENTITY__LAYOUT, null, msgs);
      msgs = basicSetLayout(newLayout, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EntityDslPackage.ENTITY__LAYOUT, newLayout, newLayout));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case EntityDslPackage.ENTITY__SUPER_TYPE:
        return basicSetSuperType(null, msgs);
      case EntityDslPackage.ENTITY__PROPERTIES:
        return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
      case EntityDslPackage.ENTITY__LAYOUT:
        return basicSetLayout(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case EntityDslPackage.ENTITY__MASTER:
        return isMaster();
      case EntityDslPackage.ENTITY__SUPER_TYPE:
        return getSuperType();
      case EntityDslPackage.ENTITY__PROPERTIES:
        return getProperties();
      case EntityDslPackage.ENTITY__LAYOUT:
        return getLayout();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case EntityDslPackage.ENTITY__MASTER:
        setMaster((Boolean)newValue);
        return;
      case EntityDslPackage.ENTITY__SUPER_TYPE:
        setSuperType((JvmParameterizedTypeReference)newValue);
        return;
      case EntityDslPackage.ENTITY__PROPERTIES:
        getProperties().clear();
        getProperties().addAll((Collection<? extends AnnotatedElement>)newValue);
        return;
      case EntityDslPackage.ENTITY__LAYOUT:
        setLayout((Layout)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case EntityDslPackage.ENTITY__MASTER:
        setMaster(MASTER_EDEFAULT);
        return;
      case EntityDslPackage.ENTITY__SUPER_TYPE:
        setSuperType((JvmParameterizedTypeReference)null);
        return;
      case EntityDslPackage.ENTITY__PROPERTIES:
        getProperties().clear();
        return;
      case EntityDslPackage.ENTITY__LAYOUT:
        setLayout((Layout)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case EntityDslPackage.ENTITY__MASTER:
        return master != MASTER_EDEFAULT;
      case EntityDslPackage.ENTITY__SUPER_TYPE:
        return superType != null;
      case EntityDslPackage.ENTITY__PROPERTIES:
        return properties != null && !properties.isEmpty();
      case EntityDslPackage.ENTITY__LAYOUT:
        return layout != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (master: ");
    result.append(master);
    result.append(')');
    return result.toString();
  }

} //EntityImpl
