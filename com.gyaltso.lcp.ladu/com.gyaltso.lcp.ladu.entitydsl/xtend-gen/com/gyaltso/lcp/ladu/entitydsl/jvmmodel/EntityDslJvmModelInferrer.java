/**
 * Copyright (C) 2020, 2021 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package com.gyaltso.lcp.ladu.entitydsl.jvmmodel;

import com.google.inject.Inject;
import com.gyaltso.lcp.ladu.entitydsl.annotation.AnnotationHelper;
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.AnnotatedElement;
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.Definition;
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.EEnum;
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity;
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.Literal;
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.Model;
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.Property;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import javax.persistence.Id;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Neeraj Bhusare - Initial contribution and API
 */
@SuppressWarnings("all")
public class EntityDslJvmModelInferrer extends AbstractModelInferrer {
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  @Extension
  private IJvmModelAssociations _iJvmModelAssociations;
  
  protected void _infer(final Definition definition, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    final Consumer<Model> _function = (Model it) -> {
      boolean _matched = false;
      if (it instanceof Entity) {
        _matched=true;
        final JvmGenericType entity = this.createEntity(((Entity)it));
        acceptor.<JvmGenericType>accept(entity);
        final JvmGenericType repository = this.createRepository(((Entity)it), this._typeReferenceBuilder.typeRef(entity));
        acceptor.<JvmGenericType>accept(repository);
        final JvmGenericType service = this.createService(((Entity)it), this._typeReferenceBuilder.typeRef(entity), this._typeReferenceBuilder.typeRef(repository));
        acceptor.<JvmGenericType>accept(service);
        acceptor.<JvmGenericType>accept(this.createController(((Entity)it), this._typeReferenceBuilder.typeRef(entity), this._typeReferenceBuilder.typeRef(service)));
      }
      if (!_matched) {
        if (it instanceof EEnum) {
          _matched=true;
          final JvmEnumerationType eEnum = this.createEnum(((EEnum)it));
          acceptor.<JvmEnumerationType>accept(eEnum);
        }
      }
    };
    definition.getModels().forEach(_function);
    acceptor.<JvmGenericType>accept(this.createMainApplication(definition));
  }
  
  private JvmGenericType createMainApplication(final Definition definition) {
    final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(SpringBootApplication.class.getName());
      this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      EList<JvmAnnotationReference> _annotations_1 = it.getAnnotations();
      JvmAnnotationReference _annotationRef_1 = this._annotationTypesBuilder.annotationRef(EntityScan.class.getName(), this._iQualifiedNameProvider.getFullyQualifiedName(definition).toString());
      this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations_1, _annotationRef_1);
      EList<JvmAnnotationReference> _annotations_2 = it.getAnnotations();
      String _name = EnableJpaRepositories.class.getName();
      StringConcatenation _builder = new StringConcatenation();
      QualifiedName _append = this._iQualifiedNameProvider.getFullyQualifiedName(definition).append("repositories");
      _builder.append(_append);
      JvmAnnotationReference _annotationRef_2 = this._annotationTypesBuilder.annotationRef(_name, _builder.toString());
      this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations_2, _annotationRef_2);
      EList<JvmAnnotationReference> _annotations_3 = it.getAnnotations();
      String _name_1 = ComponentScan.class.getName();
      String _string = this._iQualifiedNameProvider.getFullyQualifiedName(definition).toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      QualifiedName _append_1 = this._iQualifiedNameProvider.getFullyQualifiedName(definition).append("main");
      _builder_1.append(_append_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      QualifiedName _append_2 = this._iQualifiedNameProvider.getFullyQualifiedName(definition).append("controllers");
      _builder_2.append(_append_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      QualifiedName _append_3 = this._iQualifiedNameProvider.getFullyQualifiedName(definition).append("services");
      _builder_3.append(_append_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      QualifiedName _append_4 = this._iQualifiedNameProvider.getFullyQualifiedName(definition).append("repositories");
      _builder_4.append(_append_4);
      JvmAnnotationReference _annotationRef_3 = this._annotationTypesBuilder.annotationRef(_name_1, _string, _builder_1.toString(), _builder_2.toString(), _builder_3.toString(), _builder_4.toString());
      this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations_3, _annotationRef_3);
      EList<JvmMember> _members = it.getMembers();
      final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
        it_1.setStatic(true);
        EList<JvmFormalParameter> _parameters = it_1.getParameters();
        JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(definition, "args", this._jvmTypesBuilder.addArrayTypeDimension(this._typeReferenceBuilder.typeRef(String.class)));
        this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("org.springframework.boot.SpringApplication.run(MainApplication.class, args);");
          }
        };
        this._jvmTypesBuilder.setBody(it_1, _client);
      };
      JvmOperation _method = this._jvmTypesBuilder.toMethod(definition, "main", this._typeReferenceBuilder.typeRef(void.class), _function_1);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
    };
    return this._jvmTypesBuilder.toClass(definition, this._iQualifiedNameProvider.getFullyQualifiedName(definition).append("main").append("MainApplication"), _function);
  }
  
  private JvmGenericType createService(final Entity entity, final JvmTypeReference entityTypeRef, final JvmTypeReference repository) {
    JvmGenericType _xblockexpression = null;
    {
      final EObject pkg = EcoreUtil.getRootContainer(entity);
      QualifiedName _append = this._iQualifiedNameProvider.getFullyQualifiedName(pkg).append("services");
      String _name = entity.getName();
      String _plus = (_name + "Service");
      final String serviceName = _append.append(_plus).toString();
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        StringConcatenation _builder = new StringConcatenation();
        String _name_1 = entity.getName();
        _builder.append(_name_1);
        _builder.append(" Service");
        this._jvmTypesBuilder.setDocumentation(it, _builder.toString());
        EList<JvmAnnotationReference> _annotations = it.getAnnotations();
        JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Component.class.getName());
        this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
        EList<JvmMember> _members = it.getMembers();
        JvmField _field = this._jvmTypesBuilder.toField(entity, "repository", repository);
        final Procedure1<JvmField> _function_1 = (JvmField it_1) -> {
          EList<JvmAnnotationReference> _annotations_1 = it_1.getAnnotations();
          JvmAnnotationReference _annotationRef_1 = this._annotationTypesBuilder.annotationRef(Autowired.class.getName());
          this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations_1, _annotationRef_1);
          it_1.setVisibility(JvmVisibility.PUBLIC);
        };
        JvmField _doubleArrow = ObjectExtensions.<JvmField>operator_doubleArrow(_field, _function_1);
        this._jvmTypesBuilder.<JvmMember>operator_add(_members, _doubleArrow);
        EList<JvmMember> _members_1 = it.getMembers();
        final Procedure1<JvmOperation> _function_2 = (JvmOperation it_1) -> {
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("List<");
              String _name = entity.getName();
              _builder.append(_name);
              _builder.append("> ");
              String _firstLower = StringExtensions.toFirstLower(entity.getName());
              _builder.append(_firstLower);
              _builder.append("List = new java.util.ArrayList<>();");
              _builder.newLineIfNotEmpty();
              _builder.append("java.util.Iterator<");
              String _name_1 = entity.getName();
              _builder.append(_name_1);
              _builder.append("> iterator = repository.findAll().iterator();");
              _builder.newLineIfNotEmpty();
              _builder.append("while (iterator.hasNext()) {");
              _builder.newLine();
              _builder.append("        ");
              String _firstLower_1 = StringExtensions.toFirstLower(entity.getName());
              _builder.append(_firstLower_1, "        ");
              _builder.append("List.add(iterator.next());");
              _builder.newLineIfNotEmpty();
              _builder.append("    ");
              _builder.append("}");
              _builder.newLine();
              _builder.append("return ");
              String _firstLower_2 = StringExtensions.toFirstLower(entity.getName());
              _builder.append(_firstLower_2);
              _builder.append("List;");
            }
          };
          this._jvmTypesBuilder.setBody(it_1, _client);
        };
        JvmOperation _method = this._jvmTypesBuilder.toMethod(entity, "findAll", this._typeReferenceBuilder.typeRef(List.class, entityTypeRef), _function_2);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method);
        EList<JvmMember> _members_2 = it.getMembers();
        final Procedure1<JvmOperation> _function_3 = (JvmOperation it_1) -> {
          EList<JvmFormalParameter> _parameters = it_1.getParameters();
          StringConcatenation _builder_1 = new StringConcatenation();
          String _firstLower = StringExtensions.toFirstLower(entity.getName());
          _builder_1.append(_firstLower);
          _builder_1.append("Id");
          JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(entity, _builder_1.toString(), this._typeReferenceBuilder.typeRef(Long.class));
          this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("return repository.findById(");
              String _firstLower = StringExtensions.toFirstLower(entity.getName());
              _builder.append(_firstLower);
              _builder.append("Id);");
            }
          };
          this._jvmTypesBuilder.setBody(it_1, _client);
        };
        JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(entity, "findById", this._typeReferenceBuilder.typeRef(Optional.class, entityTypeRef), _function_3);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _method_1);
        EList<JvmMember> _members_3 = it.getMembers();
        final Procedure1<JvmOperation> _function_4 = (JvmOperation it_1) -> {
          EList<JvmFormalParameter> _parameters = it_1.getParameters();
          JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(entity, StringExtensions.toFirstLower(entity.getName()), this.getPrimaryJavaElementTypeRef(entity));
          this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("repository.save(");
              String _firstLower = StringExtensions.toFirstLower(entity.getName());
              _builder.append(_firstLower);
              _builder.append(");");
            }
          };
          this._jvmTypesBuilder.setBody(it_1, _client);
        };
        JvmOperation _method_2 = this._jvmTypesBuilder.toMethod(entity, "create", this._typeReferenceBuilder.typeRef(void.class), _function_4);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_3, _method_2);
        EList<JvmMember> _members_4 = it.getMembers();
        final Procedure1<JvmOperation> _function_5 = (JvmOperation it_1) -> {
          EList<JvmFormalParameter> _parameters = it_1.getParameters();
          JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(entity, StringExtensions.toFirstLower(entity.getName()), this.getPrimaryJavaElementTypeRef(entity));
          this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("repository.delete(");
              String _firstLower = StringExtensions.toFirstLower(entity.getName());
              _builder.append(_firstLower);
              _builder.append(");");
            }
          };
          this._jvmTypesBuilder.setBody(it_1, _client);
        };
        JvmOperation _method_3 = this._jvmTypesBuilder.toMethod(entity, "delete", this._typeReferenceBuilder.typeRef(void.class), _function_5);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_4, _method_3);
        EList<JvmMember> _members_5 = it.getMembers();
        final Procedure1<JvmOperation> _function_6 = (JvmOperation it_1) -> {
          EList<JvmFormalParameter> _parameters = it_1.getParameters();
          StringConcatenation _builder_1 = new StringConcatenation();
          String _firstLower = StringExtensions.toFirstLower(entity.getName());
          _builder_1.append(_firstLower);
          _builder_1.append("Id");
          JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(entity, _builder_1.toString(), this._typeReferenceBuilder.typeRef(Long.class));
          this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("repository.deleteById(");
              String _firstLower = StringExtensions.toFirstLower(entity.getName());
              _builder.append(_firstLower);
              _builder.append("Id);");
            }
          };
          this._jvmTypesBuilder.setBody(it_1, _client);
        };
        JvmOperation _method_4 = this._jvmTypesBuilder.toMethod(entity, "deleteById", this._typeReferenceBuilder.typeRef(void.class), _function_6);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_5, _method_4);
      };
      _xblockexpression = this._jvmTypesBuilder.toClass(entity, serviceName, _function);
    }
    return _xblockexpression;
  }
  
  private JvmGenericType createRepository(final Entity entity, final JvmTypeReference entityTypeRef) {
    JvmGenericType _xblockexpression = null;
    {
      final EObject pkg = EcoreUtil.getRootContainer(entity);
      QualifiedName _append = this._iQualifiedNameProvider.getFullyQualifiedName(pkg).append("repositories");
      String _name = entity.getName();
      String _plus = (_name + "Repository");
      final String repoName = _append.append(_plus).toString();
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmAnnotationReference> _annotations = it.getAnnotations();
        JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(Repository.class.getName());
        this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
        EList<JvmTypeReference> _superTypes = it.getSuperTypes();
        JvmTypeReference _typeRef = this._typeReferenceBuilder.typeRef(CrudRepository.class.getName(), entityTypeRef, this._typeReferenceBuilder.typeRef(Long.class));
        this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _typeRef);
      };
      _xblockexpression = this._jvmTypesBuilder.toInterface(entity, repoName, _function);
    }
    return _xblockexpression;
  }
  
  private JvmGenericType createEntity(final Entity entity) {
    final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
      EList<JvmAnnotationReference> _annotations = it.getAnnotations();
      JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(javax.persistence.Entity.class.getName());
      this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
      final Function1<AnnotatedElement, Property> _function_1 = (AnnotatedElement it_1) -> {
        return ((Property) it_1);
      };
      final Consumer<Property> _function_2 = (Property property) -> {
        JvmTypeReference _xifexpression = null;
        boolean _isArray = property.isArray();
        if (_isArray) {
          _xifexpression = this._jvmTypesBuilder.addArrayTypeDimension(property.getType());
        } else {
          _xifexpression = property.getType();
        }
        final JvmTypeReference type = _xifexpression;
        EList<JvmMember> _members = it.getMembers();
        JvmField _field = this._jvmTypesBuilder.toField(property, property.getName(), type);
        final Procedure1<JvmField> _function_3 = (JvmField it_1) -> {
          this._jvmTypesBuilder.addAnnotations(it_1, property.getAnnotations());
        };
        JvmField _doubleArrow = ObjectExtensions.<JvmField>operator_doubleArrow(_field, _function_3);
        this._jvmTypesBuilder.<JvmMember>operator_add(_members, _doubleArrow);
        EList<JvmMember> _members_1 = it.getMembers();
        JvmOperation _getter = this._jvmTypesBuilder.toGetter(property, property.getName(), type);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _getter);
        EList<JvmMember> _members_2 = it.getMembers();
        JvmOperation _setter = this._jvmTypesBuilder.toSetter(property, property.getName(), type);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _setter);
      };
      ListExtensions.<AnnotatedElement, Property>map(entity.getProperties(), _function_1).forEach(_function_2);
      EList<JvmMember> _members = it.getMembers();
      JvmOperation _toStringMethod = this._jvmTypesBuilder.toToStringMethod(entity, it);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _toStringMethod);
      JvmParameterizedTypeReference _superType = entity.getSuperType();
      boolean _tripleNotEquals = (_superType != null);
      if (_tripleNotEquals) {
        EList<JvmTypeReference> _superTypes = it.getSuperTypes();
        JvmParameterizedTypeReference _superType_1 = entity.getSuperType();
        this._jvmTypesBuilder.<JvmParameterizedTypeReference>operator_add(_superTypes, _superType_1);
      }
    };
    return this._jvmTypesBuilder.toClass(entity, this._iQualifiedNameProvider.getFullyQualifiedName(entity), _function);
  }
  
  private JvmEnumerationType createEnum(final EEnum eenum) {
    final Procedure1<JvmEnumerationType> _function = (JvmEnumerationType it) -> {
      final Consumer<Literal> _function_1 = (Literal literal) -> {
        EList<JvmMember> _members = it.getMembers();
        JvmEnumerationLiteral _enumerationLiteral = this._jvmTypesBuilder.toEnumerationLiteral(literal, literal.getName());
        this._jvmTypesBuilder.<JvmEnumerationLiteral>operator_add(_members, _enumerationLiteral);
      };
      eenum.getLiterals().forEach(_function_1);
    };
    return this._jvmTypesBuilder.toEnumerationType(eenum, this.getfullyQualifiedNameStr(eenum), _function);
  }
  
  private JvmGenericType createController(final Entity entity, final JvmTypeReference entityTypeRef, final JvmTypeReference serviceJvmTypeRef) {
    JvmGenericType _xblockexpression = null;
    {
      final EObject pkg = EcoreUtil.getRootContainer(entity);
      QualifiedName _append = this._iQualifiedNameProvider.getFullyQualifiedName(pkg).append("controllers");
      String _name = entity.getName();
      String _plus = (_name + "Controller");
      final QualifiedName controllerName = _append.append(_plus);
      final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
        EList<JvmAnnotationReference> _annotations = it.getAnnotations();
        JvmAnnotationReference _annotationRef = this._annotationTypesBuilder.annotationRef(RestController.class.getName());
        this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotationRef);
        final Optional<XAnnotation> rmAnnotation = AnnotationHelper.getAnnotation(entity, RequestMapping.class);
        boolean _isPresent = rmAnnotation.isPresent();
        boolean _not = (!_isPresent);
        if (_not) {
          EList<JvmAnnotationReference> _annotations_1 = it.getAnnotations();
          String _name_1 = RequestMapping.class.getName();
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("/");
          String _lowerCase = entity.getName().toLowerCase();
          _builder.append(_lowerCase);
          _builder.append("s");
          JvmAnnotationReference _annotationRef_1 = this._annotationTypesBuilder.annotationRef(_name_1, _builder.toString());
          this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations_1, _annotationRef_1);
        }
        this._jvmTypesBuilder.addAnnotations(it, entity.getAnnotations());
        EList<JvmMember> _members = it.getMembers();
        JvmField _field = this._jvmTypesBuilder.toField(entity, "service", serviceJvmTypeRef);
        final Procedure1<JvmField> _function_1 = (JvmField it_1) -> {
          EList<JvmAnnotationReference> _annotations_2 = it_1.getAnnotations();
          JvmAnnotationReference _annotationRef_2 = this._annotationTypesBuilder.annotationRef(Autowired.class.getName());
          this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations_2, _annotationRef_2);
          it_1.setVisibility(JvmVisibility.PUBLIC);
        };
        JvmField _doubleArrow = ObjectExtensions.<JvmField>operator_doubleArrow(_field, _function_1);
        this._jvmTypesBuilder.<JvmMember>operator_add(_members, _doubleArrow);
        EList<JvmMember> _members_1 = it.getMembers();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("getAll");
        final Procedure1<JvmOperation> _function_2 = (JvmOperation it_1) -> {
          EList<JvmAnnotationReference> _annotations_2 = it_1.getAnnotations();
          JvmAnnotationReference _annotationRef_2 = this._annotationTypesBuilder.annotationRef(GetMapping.class.getName());
          this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations_2, _annotationRef_2);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("return service.findAll();");
            }
          };
          this._jvmTypesBuilder.setBody(it_1, _client);
        };
        JvmOperation _method = this._jvmTypesBuilder.toMethod(entity, _builder_1.toString(), this._typeReferenceBuilder.typeRef(List.class, entityTypeRef), _function_2);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method);
        EList<JvmMember> _members_2 = it.getMembers();
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("get");
        final Procedure1<JvmOperation> _function_3 = (JvmOperation it_1) -> {
          EList<JvmAnnotationReference> _annotations_2 = it_1.getAnnotations();
          String _name_2 = GetMapping.class.getName();
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("/{");
          String _firstLower = StringExtensions.toFirstLower(entity.getName());
          _builder_3.append(_firstLower);
          _builder_3.append("Id}");
          JvmAnnotationReference _annotationRef_2 = this._annotationTypesBuilder.annotationRef(_name_2, _builder_3.toString());
          this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations_2, _annotationRef_2);
          EList<JvmFormalParameter> _parameters = it_1.getParameters();
          StringConcatenation _builder_4 = new StringConcatenation();
          String _firstLower_1 = StringExtensions.toFirstLower(entity.getName());
          _builder_4.append(_firstLower_1);
          _builder_4.append("Id");
          JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(entity, _builder_4.toString(), this._typeReferenceBuilder.typeRef(Long.class));
          final Procedure1<JvmFormalParameter> _function_4 = (JvmFormalParameter it_2) -> {
            EList<JvmAnnotationReference> _annotations_3 = it_2.getAnnotations();
            JvmAnnotationReference _annotationRef_3 = this._annotationTypesBuilder.annotationRef(PathVariable.class.getName());
            this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations_3, _annotationRef_3);
          };
          JvmFormalParameter _doubleArrow_1 = ObjectExtensions.<JvmFormalParameter>operator_doubleArrow(_parameter, _function_4);
          this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _doubleArrow_1);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("Optional<");
              String _name = entity.getName();
              _builder.append(_name);
              _builder.append("> ");
              String _firstLower = StringExtensions.toFirstLower(entity.getName());
              _builder.append(_firstLower);
              _builder.append(" = service.findById(");
              String _firstLower_1 = StringExtensions.toFirstLower(entity.getName());
              _builder.append(_firstLower_1);
              _builder.append("Id);");
              _builder.newLineIfNotEmpty();
              _builder.append("return ");
              String _firstLower_2 = StringExtensions.toFirstLower(entity.getName());
              _builder.append(_firstLower_2);
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          };
          this._jvmTypesBuilder.setBody(it_1, _client);
        };
        JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(entity, _builder_2.toString(), this._typeReferenceBuilder.typeRef(Optional.class, entityTypeRef), _function_3);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _method_1);
        EList<JvmMember> _members_3 = it.getMembers();
        final Procedure1<JvmOperation> _function_4 = (JvmOperation it_1) -> {
          EList<JvmAnnotationReference> _annotations_2 = it_1.getAnnotations();
          JvmAnnotationReference _annotationRef_2 = this._annotationTypesBuilder.annotationRef(PostMapping.class.getName());
          this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations_2, _annotationRef_2);
          EList<JvmFormalParameter> _parameters = it_1.getParameters();
          JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(entity, StringExtensions.toFirstLower(entity.getName()), entityTypeRef);
          final Procedure1<JvmFormalParameter> _function_5 = (JvmFormalParameter it_2) -> {
            EList<JvmAnnotationReference> _annotations_3 = it_2.getAnnotations();
            JvmAnnotationReference _annotationRef_3 = this._annotationTypesBuilder.annotationRef(RequestBody.class.getName());
            this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations_3, _annotationRef_3);
          };
          JvmFormalParameter _doubleArrow_1 = ObjectExtensions.<JvmFormalParameter>operator_doubleArrow(_parameter, _function_5);
          this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _doubleArrow_1);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("service.create(");
              String _firstLower = StringExtensions.toFirstLower(entity.getName());
              _builder.append(_firstLower);
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              _builder.append("return ");
              String _firstLower_1 = StringExtensions.toFirstLower(entity.getName());
              _builder.append(_firstLower_1);
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          };
          this._jvmTypesBuilder.setBody(it_1, _client);
        };
        JvmOperation _method_2 = this._jvmTypesBuilder.toMethod(entity, "create", entityTypeRef, _function_4);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_3, _method_2);
        EList<JvmMember> _members_4 = it.getMembers();
        final Procedure1<JvmOperation> _function_5 = (JvmOperation it_1) -> {
          EList<JvmAnnotationReference> _annotations_2 = it_1.getAnnotations();
          String _name_2 = PutMapping.class.getName();
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("/{");
          String _firstLower = StringExtensions.toFirstLower(entity.getName());
          _builder_3.append(_firstLower);
          _builder_3.append("Id}");
          JvmAnnotationReference _annotationRef_2 = this._annotationTypesBuilder.annotationRef(_name_2, _builder_3.toString());
          this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations_2, _annotationRef_2);
          EList<JvmFormalParameter> _parameters = it_1.getParameters();
          JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(entity, StringExtensions.toFirstLower(entity.getName()), entityTypeRef);
          final Procedure1<JvmFormalParameter> _function_6 = (JvmFormalParameter it_2) -> {
            EList<JvmAnnotationReference> _annotations_3 = it_2.getAnnotations();
            JvmAnnotationReference _annotationRef_3 = this._annotationTypesBuilder.annotationRef(PathVariable.class.getName());
            this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations_3, _annotationRef_3);
          };
          JvmFormalParameter _doubleArrow_1 = ObjectExtensions.<JvmFormalParameter>operator_doubleArrow(_parameter, _function_6);
          this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _doubleArrow_1);
          EList<JvmFormalParameter> _parameters_1 = it_1.getParameters();
          StringConcatenation _builder_4 = new StringConcatenation();
          String _firstLower_1 = StringExtensions.toFirstLower(entity.getName());
          _builder_4.append(_firstLower_1);
          _builder_4.append("Id");
          JvmFormalParameter _parameter_1 = this._jvmTypesBuilder.toParameter(entity, _builder_4.toString(), this._typeReferenceBuilder.typeRef(Long.class));
          final Procedure1<JvmFormalParameter> _function_7 = (JvmFormalParameter it_2) -> {
            EList<JvmAnnotationReference> _annotations_3 = it_2.getAnnotations();
            JvmAnnotationReference _annotationRef_3 = this._annotationTypesBuilder.annotationRef(PathVariable.class.getName());
            this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations_3, _annotationRef_3);
          };
          JvmFormalParameter _doubleArrow_2 = ObjectExtensions.<JvmFormalParameter>operator_doubleArrow(_parameter_1, _function_7);
          this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _doubleArrow_2);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("Optional<");
              String _name = entity.getName();
              _builder.append(_name);
              _builder.append("> optional = get(");
              String _firstLower = StringExtensions.toFirstLower(entity.getName());
              _builder.append(_firstLower);
              _builder.append("Id);");
              _builder.newLineIfNotEmpty();
              _builder.append("if (optional.isPresent()) {");
              _builder.newLine();
              _builder.append("\t");
              String _name_1 = entity.getName();
              _builder.append(_name_1, "\t");
              _builder.append(" old");
              String _name_2 = entity.getName();
              _builder.append(_name_2, "\t");
              _builder.append(" = optional.get();");
              _builder.newLineIfNotEmpty();
              {
                final Function1<AnnotatedElement, Property> _function = (AnnotatedElement it_2) -> {
                  return ((Property) it_2);
                };
                List<Property> _map = ListExtensions.<AnnotatedElement, Property>map(entity.getProperties(), _function);
                for(final Property prop : _map) {
                  {
                    final Function1<XAnnotation, String> _function_1 = (XAnnotation it_2) -> {
                      return it_2.getAnnotationType().getQualifiedName();
                    };
                    boolean _contains = ListExtensions.<XAnnotation, String>map(prop.getAnnotations(), _function_1).contains(Id.class.getName());
                    boolean _not = (!_contains);
                    if (_not) {
                      _builder.append("\t");
                      _builder.append("old");
                      String _name_3 = entity.getName();
                      _builder.append(_name_3, "\t");
                      _builder.append(".set");
                      String _firstUpper = StringExtensions.toFirstUpper(prop.getName());
                      _builder.append(_firstUpper, "\t");
                      _builder.append("(");
                      String _firstLower_1 = StringExtensions.toFirstLower(entity.getName());
                      _builder.append(_firstLower_1, "\t");
                      _builder.append(".get");
                      String _firstUpper_1 = StringExtensions.toFirstUpper(prop.getName());
                      _builder.append(_firstUpper_1, "\t");
                      _builder.append("());");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                }
              }
              _builder.append("\t");
              _builder.append("return Optional.of(old");
              String _name_4 = entity.getName();
              _builder.append(_name_4, "\t");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
              _builder.append("return Optional.empty();");
              _builder.newLine();
            }
          };
          this._jvmTypesBuilder.setBody(it_1, _client);
        };
        JvmOperation _method_3 = this._jvmTypesBuilder.toMethod(entity, "update", this._typeReferenceBuilder.typeRef(Optional.class, entityTypeRef), _function_5);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_4, _method_3);
        EList<JvmMember> _members_5 = it.getMembers();
        final Procedure1<JvmOperation> _function_6 = (JvmOperation it_1) -> {
          EList<JvmAnnotationReference> _annotations_2 = it_1.getAnnotations();
          JvmAnnotationReference _annotationRef_2 = this._annotationTypesBuilder.annotationRef(DeleteMapping.class.getName());
          this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations_2, _annotationRef_2);
          EList<JvmFormalParameter> _parameters = it_1.getParameters();
          JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(entity, StringExtensions.toFirstLower(entity.getName()), entityTypeRef);
          final Procedure1<JvmFormalParameter> _function_7 = (JvmFormalParameter it_2) -> {
            EList<JvmAnnotationReference> _annotations_3 = it_2.getAnnotations();
            JvmAnnotationReference _annotationRef_3 = this._annotationTypesBuilder.annotationRef(RequestBody.class.getName());
            this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations_3, _annotationRef_3);
          };
          JvmFormalParameter _doubleArrow_1 = ObjectExtensions.<JvmFormalParameter>operator_doubleArrow(_parameter, _function_7);
          this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _doubleArrow_1);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("service.delete(");
              String _firstLower = StringExtensions.toFirstLower(entity.getName());
              _builder.append(_firstLower);
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          };
          this._jvmTypesBuilder.setBody(it_1, _client);
        };
        JvmOperation _method_4 = this._jvmTypesBuilder.toMethod(entity, "delete", this._typeReferenceBuilder.typeRef(void.class), _function_6);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_5, _method_4);
        EList<JvmMember> _members_6 = it.getMembers();
        final Procedure1<JvmOperation> _function_7 = (JvmOperation it_1) -> {
          EList<JvmAnnotationReference> _annotations_2 = it_1.getAnnotations();
          String _name_2 = DeleteMapping.class.getName();
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("/{");
          String _firstLower = StringExtensions.toFirstLower(entity.getName());
          _builder_3.append(_firstLower);
          _builder_3.append("Id}");
          JvmAnnotationReference _annotationRef_2 = this._annotationTypesBuilder.annotationRef(_name_2, _builder_3.toString());
          this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations_2, _annotationRef_2);
          EList<JvmFormalParameter> _parameters = it_1.getParameters();
          StringConcatenation _builder_4 = new StringConcatenation();
          String _firstLower_1 = StringExtensions.toFirstLower(entity.getName());
          _builder_4.append(_firstLower_1);
          _builder_4.append("Id");
          JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(entity, _builder_4.toString(), this._typeReferenceBuilder.typeRef(Long.class));
          final Procedure1<JvmFormalParameter> _function_8 = (JvmFormalParameter it_2) -> {
            EList<JvmAnnotationReference> _annotations_3 = it_2.getAnnotations();
            JvmAnnotationReference _annotationRef_3 = this._annotationTypesBuilder.annotationRef(PathVariable.class.getName());
            this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations_3, _annotationRef_3);
          };
          JvmFormalParameter _doubleArrow_1 = ObjectExtensions.<JvmFormalParameter>operator_doubleArrow(_parameter, _function_8);
          this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _doubleArrow_1);
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("service.deleteById(");
              String _firstLower = StringExtensions.toFirstLower(entity.getName());
              _builder.append(_firstLower);
              _builder.append("Id);");
              _builder.newLineIfNotEmpty();
            }
          };
          this._jvmTypesBuilder.setBody(it_1, _client);
        };
        JvmOperation _method_5 = this._jvmTypesBuilder.toMethod(entity, "delete", this._typeReferenceBuilder.typeRef(void.class), _function_7);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members_6, _method_5);
      };
      _xblockexpression = this._jvmTypesBuilder.toClass(entity, controllerName, _function);
    }
    return _xblockexpression;
  }
  
  private JvmTypeReference getPrimaryJavaElementTypeRef(final EObject eObject) {
    EObject _primaryJvmElement = this._iJvmModelAssociations.getPrimaryJvmElement(eObject);
    return this._typeReferenceBuilder.typeRef(((JvmGenericType) _primaryJvmElement));
  }
  
  private String getfullyQualifiedNameStr(final EObject eObject) {
    return this._iQualifiedNameProvider.getFullyQualifiedName(eObject).toString();
  }
  
  public void infer(final EObject definition, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    if (definition instanceof Definition) {
      _infer((Definition)definition, acceptor, isPreIndexingPhase);
      return;
    } else if (definition != null) {
      _infer(definition, acceptor, isPreIndexingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(definition, acceptor, isPreIndexingPhase).toString());
    }
  }
}
