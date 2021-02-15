/*******************************************************************************
 * Copyright (C) 2020, 2021 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package com.gyaltso.lcp.ladu.entitydsl.jvmmodel

import com.google.inject.Inject
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.Definition
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.EEnum
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.Property
import java.util.List
import java.util.Optional
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

import static extension com.gyaltso.lcp.ladu.entitydsl.annotation.AnnotationHelper.*
import org.springframework.stereotype.Repository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PutMapping
import javax.persistence.Id
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.context.annotation.ComponentScan

/**
 * @author Neeraj Bhusare - Initial contribution and API
 * 
 */
class EntityDslJvmModelInferrer extends AbstractModelInferrer {

	@Inject extension JvmTypesBuilder
	@Inject extension IQualifiedNameProvider
	@Inject extension IJvmModelAssociations

	def dispatch void infer(Definition definition, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
		definition.models.forEach [
			switch it {
				Entity: {
					// Entity
					val entity = createEntity()
					acceptor.accept(entity)

					// Repository
					val repository = createRepository(entity.typeRef)
					acceptor.accept(repository)

					// Service
					val service = createService(entity.typeRef, repository.typeRef())
					acceptor.accept(service)

					// Controller
					acceptor.accept(createController(entity.typeRef, service.typeRef()))
				}
				EEnum: {
					val eEnum = createEnum()
					acceptor.accept(eEnum)
				}
			}
		]

		// Main app
		acceptor.accept(createMainApplication(definition))
	}

	private def createMainApplication(Definition definition) {
		definition.toClass(definition.fullyQualifiedName.append("main").append("MainApplication")) [
			annotations += annotationRef(SpringBootApplication.name)
			annotations += annotationRef(EntityScan.name, definition.fullyQualifiedName.toString)
			annotations +=
				annotationRef(EnableJpaRepositories.name, '''«definition.fullyQualifiedName.append("repositories")»''')
			annotations += annotationRef(
				ComponentScan.name, //
				definition.fullyQualifiedName.toString,
				'''«definition.fullyQualifiedName.append("main")»''', //
				'''«definition.fullyQualifiedName.append("controllers")»''', //
				'''«definition.fullyQualifiedName.append("services")»''',
				'''«definition.fullyQualifiedName.append("repositories")»''' //
			)
			members += definition.toMethod('main', typeRef(void)) [
				static = true
				parameters += definition.toParameter('args', typeRef(String).addArrayTypeDimension)
				body = '''org.springframework.boot.SpringApplication.run(MainApplication.class, args);'''
			]
		]
	}

	private def createService(Entity entity, JvmTypeReference entityTypeRef, JvmTypeReference repository) {
		val pkg = EcoreUtil.getRootContainer(entity)
		val serviceName = pkg.fullyQualifiedName.append("services").append(entity.name + "Service").toString

		entity.toClass(serviceName) [
			documentation = '''«entity.name» Service'''
			annotations += annotationRef(Component.name)

			members += entity.toField("repository", repository) => [
				annotations += annotationRef(Autowired.name)
				visibility = JvmVisibility.PUBLIC
			]

			members += entity.toMethod("findAll", typeRef(List, entityTypeRef)) [
				body = '''
				List<«entity.name»> «entity.name.toFirstLower»List = new java.util.ArrayList<>();
				java.util.Iterator<«entity.name»> iterator = repository.findAll().iterator();
				while (iterator.hasNext()) {
				        «entity.name.toFirstLower»List.add(iterator.next());
				    }
				return «entity.name.toFirstLower»List;'''
			]

			members += entity.toMethod("findById", typeRef(Optional, entityTypeRef)) [
				parameters += entity.toParameter('''«entity.name.toFirstLower»Id''', typeRef(Long))
				body = '''return repository.findById(«entity.name.toFirstLower»Id);'''
			]

			members += entity.toMethod("create", typeRef(void)) [
				parameters += entity.toParameter(entity.name.toFirstLower, entity.getPrimaryJavaElementTypeRef)
				body = '''repository.save(«entity.name.toFirstLower»);'''
			]

			members += entity.toMethod("delete", typeRef(void)) [
				parameters += entity.toParameter(entity.name.toFirstLower, entity.getPrimaryJavaElementTypeRef)
				body = '''repository.delete(«entity.name.toFirstLower»);'''
			]

			members += entity.toMethod("deleteById", typeRef(void)) [
				parameters += entity.toParameter('''«entity.name.toFirstLower»Id''', typeRef(Long))
				body = '''repository.deleteById(«entity.name.toFirstLower»Id);'''
			]

		]
	}

	private def createRepository(Entity entity, JvmTypeReference entityTypeRef) {
		val pkg = EcoreUtil.getRootContainer(entity)
		val repoName = pkg.fullyQualifiedName.append("repositories").append(entity.name + "Repository").toString
		entity.toInterface(repoName) [
			annotations += annotationRef(Repository.name)
			superTypes += typeRef(CrudRepository.name, entityTypeRef, Long.typeRef())

		]
	}

	private def createEntity(Entity entity) {
		entity.toClass(entity.fullyQualifiedName) [
			annotations += annotationRef(javax.persistence.Entity.name)

			entity.properties.map[it as Property].forEach [ property |
				val type = property.isArray ? property.type.addArrayTypeDimension : property.type
				members += property.toField(property.name, type) => [
					addAnnotations(property.annotations)
				]
				members += property.toGetter(property.name, type)
				members += property.toSetter(property.name, type)
			]

			members += entity.toToStringMethod(it)
			
			if (entity.superType !== null) {
				superTypes += entity.superType
			}
		]
	}

	private def createEnum(EEnum eenum) {
		eenum.toEnumerationType(getfullyQualifiedNameStr(eenum)) [
			eenum.literals.forEach [ literal |
				members += literal.toEnumerationLiteral(literal.name)
			]
		]
	}

	private def createController(Entity entity, JvmTypeReference entityTypeRef, JvmTypeReference serviceJvmTypeRef) {
		val pkg = EcoreUtil.getRootContainer(entity)
		val controllerName = pkg.fullyQualifiedName.append("controllers").append(entity.name + "Controller")

		entity.toClass(controllerName) [
			annotations += annotationRef(RestController.name)
			val rmAnnotation = entity.getAnnotation(RequestMapping)
			if (!rmAnnotation.isPresent) {
				annotations += annotationRef(RequestMapping.name, '''/«entity.name.toLowerCase»s''')
			}
			addAnnotations(entity.annotations)

			// Variable declaration
			members += entity.toField("service", serviceJvmTypeRef) => [
				annotations += annotationRef(Autowired.name)
				visibility = JvmVisibility.PUBLIC
			]

			// RequestMapping methods
			members += entity.toMethod('''getAll''', typeRef(List, entityTypeRef)) [
				annotations += annotationRef(GetMapping.name)
				body = '''return service.findAll();'''
			]

			members += entity.toMethod('''get''', typeRef(Optional, entityTypeRef)) [
				annotations += annotationRef(GetMapping.name, '''/{«entity.name.toFirstLower»Id}''')
				parameters += entity.toParameter('''«entity.name.toFirstLower»Id''', typeRef(Long)) => [
					annotations += annotationRef(PathVariable.name)
				]
				body = '''
					Optional<«entity.name»> «entity.name.toFirstLower» = service.findById(«entity.name.toFirstLower»Id);
					return «entity.name.toFirstLower»;
				'''
			]

			members += entity.toMethod("create", entityTypeRef) [
				annotations += annotationRef(PostMapping.name)
				parameters += entity.toParameter(entity.name.toFirstLower, entityTypeRef) => [
					annotations += annotationRef(RequestBody.name)
				]
				body = '''
					service.create(«entity.name.toFirstLower»);
					return «entity.name.toFirstLower»;
				'''
			]

			members += entity.toMethod("update", typeRef(Optional, entityTypeRef)) [
				annotations += annotationRef(PutMapping.name, '''/{«entity.name.toFirstLower»Id}''')
				parameters += entity.toParameter(entity.name.toFirstLower, entityTypeRef) => [
					annotations += annotationRef(PathVariable.name)
				]
				parameters += entity.toParameter('''«entity.name.toFirstLower»Id''', typeRef(Long)) => [
					annotations += annotationRef(PathVariable.name)
				]

				body = '''
					Optional<«entity.name»> optional = get(«entity.name.toFirstLower»Id);
					if (optional.isPresent()) {
						«entity.name» old«entity.name» = optional.get();
						«FOR Property prop : entity.properties.map[it as Property]»
							«IF !prop.annotations.map[it.annotationType.qualifiedName].contains(Id.name)»
								old«entity.name».set«prop.name.toFirstUpper»(«entity.name.toFirstLower».get«prop.name.toFirstUpper»());
							«ENDIF»
						«ENDFOR»
						return Optional.of(old«entity.name»);
					}
					return Optional.empty();
				'''
			]

			members += entity.toMethod("delete", typeRef(void)) [
				annotations += annotationRef(DeleteMapping.name)
				parameters += entity.toParameter(entity.name.toFirstLower, entityTypeRef) => [
					annotations += annotationRef(RequestBody.name)
				]
				body = '''
					service.delete(«entity.name.toFirstLower»);
				'''
			]

			members += entity.toMethod("delete", typeRef(void)) [
				annotations += annotationRef(DeleteMapping.name, '''/{«entity.name.toFirstLower»Id}''')
				parameters += entity.toParameter('''«entity.name.toFirstLower»Id''', typeRef(Long)) => [
					annotations += annotationRef(PathVariable.name)
				]
				body = '''
					service.deleteById(«entity.name.toFirstLower»Id);
				'''
			]
		]
	}

	private def getPrimaryJavaElementTypeRef(EObject eObject) {
		return (eObject.getPrimaryJvmElement as JvmGenericType).typeRef()
	}

	private def getfullyQualifiedNameStr(EObject eObject) {
		return eObject.fullyQualifiedName.toString
	}
}
