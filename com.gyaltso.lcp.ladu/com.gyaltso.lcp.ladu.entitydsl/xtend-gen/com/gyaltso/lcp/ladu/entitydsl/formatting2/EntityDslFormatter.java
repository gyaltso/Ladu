/**
 * Copyright (C) 2020, 2021 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package com.gyaltso.lcp.ladu.entitydsl.formatting2;

import com.google.inject.Inject;
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.AnnotatedElement;
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.Definition;
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.EEnum;
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity;
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslPackage;
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.Literal;
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.Model;
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.Property;
import com.gyaltso.lcp.ladu.entitydsl.services.EntityDslGrammarAccess;
import java.util.Arrays;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.annotations.formatting2.XbaseWithAnnotationsFormatter;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

/**
 * @author Neeraj Bhusare - Initial contribution and API
 */
@SuppressWarnings("all")
public class EntityDslFormatter extends XbaseWithAnnotationsFormatter {
  @Inject
  @Extension
  private EntityDslGrammarAccess _entityDslGrammarAccess;
  
  protected void _format(final Definition definition, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.setNewLines(1);
    };
    document.append(this.textRegionExtensions.regionFor(definition).feature(EntityDslPackage.Literals.DEFINITION__NAME), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(definition).feature(EntityDslPackage.Literals.DEFINITION__NAME), _function_1);
    document.<XImportSection>format(definition.getImportSection());
    EList<Model> _models = definition.getModels();
    for (final Model model : _models) {
      document.<Model>format(model);
    }
  }
  
  protected void _format(final Entity entity, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.setNewLines(2);
    };
    document.<Entity>append(entity, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.setNewLines(2);
    };
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(
      document.append(this.textRegionExtensions.regionFor(entity).keyword("{"), _function_1), 
      this.textRegionExtensions.regionFor(entity).keyword("}"), _function_2);
    document.<JvmParameterizedTypeReference>format(entity.getSuperType());
    EList<XAnnotation> _annotations = entity.getAnnotations();
    for (final XAnnotation xAnnotation : _annotations) {
      document.<XAnnotation>format(xAnnotation);
    }
    EList<AnnotatedElement> _properties = entity.getProperties();
    for (final AnnotatedElement annotatedElement : _properties) {
      document.<AnnotatedElement>format(annotatedElement);
    }
  }
  
  protected void _format(final Property property, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.setNewLines(2);
    };
    document.<Property>append(property, _function);
    EList<XAnnotation> _annotations = property.getAnnotations();
    for (final XAnnotation xAnnotation : _annotations) {
      document.<XAnnotation>format(xAnnotation);
    }
  }
  
  protected void _format(final EEnum eEnum, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.setNewLines(2);
    };
    document.<EEnum>append(eEnum, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.setNewLines(2);
    };
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(
      document.append(this.textRegionExtensions.regionFor(eEnum).keyword("{"), _function_1), 
      this.textRegionExtensions.regionFor(eEnum).keyword("}"), _function_2);
    EList<Literal> _literals = eEnum.getLiterals();
    for (final Literal literal : _literals) {
      document.<Literal>format(literal);
    }
  }
  
  protected void _format(final Literal literal, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.setNewLines(1);
    };
    document.<Literal>append(literal, _function);
  }
  
  @Override
  protected void _format(final XAnnotation ann, @Extension final IFormattableDocument document) {
    super._format(ann, document);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.setNewLines(1);
    };
    document.<XAnnotation>append(ann, _function);
    XExpression _value = ann.getValue();
    final XListLiteral childAnnotatsion = ((XListLiteral) _value);
    if ((childAnnotatsion != null)) {
      final Consumer<XExpression> _function_1 = (XExpression it) -> {
        final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
          it_1.setNewLines(1);
        };
        document.<XExpression>append(it, _function_2);
      };
      childAnnotatsion.getElements().forEach(_function_1);
    }
  }
  
  @Override
  public void format(final Object entity, final IFormattableDocument document) {
    if (entity instanceof JvmTypeParameter) {
      _format((JvmTypeParameter)entity, document);
      return;
    } else if (entity instanceof Entity) {
      _format((Entity)entity, document);
      return;
    } else if (entity instanceof Property) {
      _format((Property)entity, document);
      return;
    } else if (entity instanceof JvmFormalParameter) {
      _format((JvmFormalParameter)entity, document);
      return;
    } else if (entity instanceof XtextResource) {
      _format((XtextResource)entity, document);
      return;
    } else if (entity instanceof XAssignment) {
      _format((XAssignment)entity, document);
      return;
    } else if (entity instanceof XBinaryOperation) {
      _format((XBinaryOperation)entity, document);
      return;
    } else if (entity instanceof XDoWhileExpression) {
      _format((XDoWhileExpression)entity, document);
      return;
    } else if (entity instanceof XFeatureCall) {
      _format((XFeatureCall)entity, document);
      return;
    } else if (entity instanceof XMemberFeatureCall) {
      _format((XMemberFeatureCall)entity, document);
      return;
    } else if (entity instanceof XPostfixOperation) {
      _format((XPostfixOperation)entity, document);
      return;
    } else if (entity instanceof XWhileExpression) {
      _format((XWhileExpression)entity, document);
      return;
    } else if (entity instanceof XFunctionTypeRef) {
      _format((XFunctionTypeRef)entity, document);
      return;
    } else if (entity instanceof EEnum) {
      _format((EEnum)entity, document);
      return;
    } else if (entity instanceof JvmGenericArrayTypeReference) {
      _format((JvmGenericArrayTypeReference)entity, document);
      return;
    } else if (entity instanceof JvmParameterizedTypeReference) {
      _format((JvmParameterizedTypeReference)entity, document);
      return;
    } else if (entity instanceof JvmWildcardTypeReference) {
      _format((JvmWildcardTypeReference)entity, document);
      return;
    } else if (entity instanceof XBasicForLoopExpression) {
      _format((XBasicForLoopExpression)entity, document);
      return;
    } else if (entity instanceof XBlockExpression) {
      _format((XBlockExpression)entity, document);
      return;
    } else if (entity instanceof XCastedExpression) {
      _format((XCastedExpression)entity, document);
      return;
    } else if (entity instanceof XClosure) {
      _format((XClosure)entity, document);
      return;
    } else if (entity instanceof XCollectionLiteral) {
      _format((XCollectionLiteral)entity, document);
      return;
    } else if (entity instanceof XConstructorCall) {
      _format((XConstructorCall)entity, document);
      return;
    } else if (entity instanceof XForLoopExpression) {
      _format((XForLoopExpression)entity, document);
      return;
    } else if (entity instanceof XIfExpression) {
      _format((XIfExpression)entity, document);
      return;
    } else if (entity instanceof XInstanceOfExpression) {
      _format((XInstanceOfExpression)entity, document);
      return;
    } else if (entity instanceof XReturnExpression) {
      _format((XReturnExpression)entity, document);
      return;
    } else if (entity instanceof XSwitchExpression) {
      _format((XSwitchExpression)entity, document);
      return;
    } else if (entity instanceof XSynchronizedExpression) {
      _format((XSynchronizedExpression)entity, document);
      return;
    } else if (entity instanceof XThrowExpression) {
      _format((XThrowExpression)entity, document);
      return;
    } else if (entity instanceof XTryCatchFinallyExpression) {
      _format((XTryCatchFinallyExpression)entity, document);
      return;
    } else if (entity instanceof XTypeLiteral) {
      _format((XTypeLiteral)entity, document);
      return;
    } else if (entity instanceof XVariableDeclaration) {
      _format((XVariableDeclaration)entity, document);
      return;
    } else if (entity instanceof XAnnotation) {
      _format((XAnnotation)entity, document);
      return;
    } else if (entity instanceof Definition) {
      _format((Definition)entity, document);
      return;
    } else if (entity instanceof Literal) {
      _format((Literal)entity, document);
      return;
    } else if (entity instanceof JvmTypeConstraint) {
      _format((JvmTypeConstraint)entity, document);
      return;
    } else if (entity instanceof XExpression) {
      _format((XExpression)entity, document);
      return;
    } else if (entity instanceof XImportDeclaration) {
      _format((XImportDeclaration)entity, document);
      return;
    } else if (entity instanceof XImportSection) {
      _format((XImportSection)entity, document);
      return;
    } else if (entity instanceof EObject) {
      _format((EObject)entity, document);
      return;
    } else if (entity == null) {
      _format((Void)null, document);
      return;
    } else if (entity != null) {
      _format(entity, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(entity, document).toString());
    }
  }
}
