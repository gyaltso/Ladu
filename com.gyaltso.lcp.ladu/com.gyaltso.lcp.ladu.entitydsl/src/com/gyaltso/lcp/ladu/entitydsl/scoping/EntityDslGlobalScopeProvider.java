/*******************************************************************************
 * Copyright (C) 2020 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package com.gyaltso.lcp.ladu.entitydsl.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider;

import com.gyaltso.lcp.ladu.entitydsl.entityDsl.Definition;

/**
 * @author Neeraj Bhusare - Initial contribution and API
 *
 */
public class EntityDslGlobalScopeProvider extends XImportSectionNamespaceScopeProvider {

	public static final QualifiedName JAVAX_PERSISTANCE = QualifiedName.create("javax", "persistence");
	public static final QualifiedName SPRINGFW_WEB_ANNOTATION = QualifiedName.create( //
			"org", "springframework", "web", "bind", "annotation");
	public static final QualifiedName SPRINGFW_FORMAT_ANNOTATION = QualifiedName.create( //
			"org", "springframework", "format", "annotation");
	public static final QualifiedName FASTERXML_JACKSON_ANNOTATION = QualifiedName.create( //
			"com", "fasterxml", "jackson", "annotation");
	public static final QualifiedName JAVA_SQL = QualifiedName.create("java", "sql");
	public static final QualifiedName JAVA_MATH = QualifiedName.create("java", "math");
	public static final QualifiedName LOCAL_DATE_TIME_ANNOTATION = QualifiedName.create("java", "time");

	@Override
	protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		List<ImportNormalizer> result = super.getImplicitImports(ignoreCase);

		result.add(doCreateImportNormalizer(JAVAX_PERSISTANCE, true, false));
		result.add(doCreateImportNormalizer(JAVA_SQL, true, false));
		result.add(doCreateImportNormalizer(JAVA_MATH, true, false));
		result.add(doCreateImportNormalizer(LOCAL_DATE_TIME_ANNOTATION, true, false));

		result.add(doCreateImportNormalizer(SPRINGFW_WEB_ANNOTATION, true, false));
		result.add(doCreateImportNormalizer(SPRINGFW_FORMAT_ANNOTATION, true, false));

		result.add(doCreateImportNormalizer(FASTERXML_JACKSON_ANNOTATION, true, false));
		return result;
	}

	@Override
	protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(EObject context, boolean ignoreCase) {
		List<ImportNormalizer> importNormalizers = new ArrayList<>();
		importNormalizers.addAll(super.internalGetImportedNamespaceResolvers(context, ignoreCase));
		if (context instanceof Definition) {
			String packageName = ((Definition) context).getName();
			importNormalizers.add(createImportedNamespaceResolver(packageName + ".*", ignoreCase));
		}
		return importNormalizers;
	}
}
