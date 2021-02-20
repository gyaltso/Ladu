/*******************************************************************************
 * Copyright (C) 2020, 2021 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package com.gyaltso.lcp.ladu.entitydsl.formatting2

import com.google.inject.Inject
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.Definition
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.EEnum
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.Entity
import com.gyaltso.lcp.ladu.entitydsl.entityDsl.Literal
import com.gyaltso.lcp.ladu.entitydsl.services.EntityDslGrammarAccess
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.xbase.XListLiteral
import org.eclipse.xtext.xbase.annotations.formatting2.XbaseWithAnnotationsFormatter
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation

import static com.gyaltso.lcp.ladu.entitydsl.entityDsl.EntityDslPackage.Literals.*

/**
 * @author Neeraj Bhusare - Initial contribution and API
 *
 */
class EntityDslFormatter extends XbaseWithAnnotationsFormatter {

	@Inject extension EntityDslGrammarAccess

	def dispatch void format(Definition definition, extension IFormattableDocument document) {
		definition.regionFor.feature(DEFINITION__NAME).append[newLines = 1]
		definition.regionFor.feature(DEFINITION__NAME).surround[oneSpace]

		definition.importSection.format
		for (model : definition.models) {
			model.format
		}
	}

	def dispatch void format(Entity entity, extension IFormattableDocument document) {
		entity.append[newLines = 2]

		interior(
			entity.regionFor.keyword('{').append[newLines = 2],
			entity.regionFor.keyword('}'),
			[indent]
		)

		entity.superType.format

		for (xAnnotation : entity.annotations) {
			xAnnotation.format
		}

		for (annotatedElement : entity.properties) {
			annotatedElement.format
		}
	}

	def dispatch void format(com.gyaltso.lcp.ladu.entitydsl.entityDsl.Property property, extension IFormattableDocument document) {
		property.append[newLines = 2]

		for (xAnnotation : property.annotations) {
			xAnnotation.format
		}
	}

	def dispatch void format(EEnum eEnum, extension IFormattableDocument document) {
		eEnum.append[newLines = 2]

		interior(
			eEnum.regionFor.keyword('{').append[newLines = 2],
			eEnum.regionFor.keyword('}'),
			[indent]
		)

		for (literal : eEnum.literals) {
			literal.format
		}
	}

	def dispatch void format(Literal literal, extension IFormattableDocument document) {
		literal.append[newLines = 1]
	}

	override protected _format(XAnnotation ann, extension IFormattableDocument document) {
		super._format(ann, document)
		ann.append[newLines = 1]

		val childAnnotatsion = ann.value as XListLiteral
		if (childAnnotatsion !== null) {
			childAnnotatsion.elements.forEach [
				append[newLines = 1]
			]
		}

	}
}
