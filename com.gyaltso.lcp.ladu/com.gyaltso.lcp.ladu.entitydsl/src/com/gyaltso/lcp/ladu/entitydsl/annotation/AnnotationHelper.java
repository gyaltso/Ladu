/*******************************************************************************
 * Copyright (C) 2020, 2021 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package com.gyaltso.lcp.ladu.entitydsl.annotation;

import java.util.Optional;

import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;

import com.gyaltso.lcp.ladu.entitydsl.entityDsl.AnnotatedElement;

/**
 * @author Neeraj Bhusare - Initial contribution and API.
 *
 */
public class AnnotationHelper {

	public static String getSimpleName(XAnnotation annotation) {
		return annotation.getAnnotationType().getSimpleName();
	}

	@SuppressWarnings("rawtypes")
	public static Optional<JvmAnnotationReference> getAnnotation(JvmField field, Class clazz) {
		return field.getAnnotations().stream() //
				.filter(annotation -> annotation.getAnnotation().getIdentifier().equals(clazz.getName())) //
				.findFirst();
	}
	
	@SuppressWarnings("rawtypes")
	public static Optional<XAnnotation> getAnnotation(AnnotatedElement element, Class clazz) {
		return element.getAnnotations().stream() //
				.filter(annotation -> annotation.getAnnotationType().getIdentifier().equals(clazz.getName())) //
				.findFirst();
	}
}
