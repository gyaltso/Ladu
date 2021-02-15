/*******************************************************************************
 * Copyright (C) 2020, 2021 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package com.gyaltso.lcp.ladu.entitydsl.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.gyaltso.lcp.ladu.entitydsl.ide.contentassist.antlr.internal.InternalEntityDslParser;
import com.gyaltso.lcp.ladu.entitydsl.services.EntityDslGrammarAccess;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class EntityDslParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(EntityDslGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, EntityDslGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getModelAccess().getAlternatives(), "rule__Model__Alternatives");
			builder.put(grammarAccess.getXAnnotationAccess().getAlternatives_3_1(), "rule__XAnnotation__Alternatives_3_1");
			builder.put(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getAlternatives(), "rule__XAnnotationElementValueOrCommaList__Alternatives");
			builder.put(grammarAccess.getXAnnotationElementValueAccess().getAlternatives(), "rule__XAnnotationElementValue__Alternatives");
			builder.put(grammarAccess.getXAnnotationOrExpressionAccess().getAlternatives(), "rule__XAnnotationOrExpression__Alternatives");
			builder.put(grammarAccess.getXAssignmentAccess().getAlternatives(), "rule__XAssignment__Alternatives");
			builder.put(grammarAccess.getOpMultiAssignAccess().getAlternatives(), "rule__OpMultiAssign__Alternatives");
			builder.put(grammarAccess.getOpEqualityAccess().getAlternatives(), "rule__OpEquality__Alternatives");
			builder.put(grammarAccess.getXRelationalExpressionAccess().getAlternatives_1(), "rule__XRelationalExpression__Alternatives_1");
			builder.put(grammarAccess.getOpCompareAccess().getAlternatives(), "rule__OpCompare__Alternatives");
			builder.put(grammarAccess.getOpOtherAccess().getAlternatives(), "rule__OpOther__Alternatives");
			builder.put(grammarAccess.getOpOtherAccess().getAlternatives_5_1(), "rule__OpOther__Alternatives_5_1");
			builder.put(grammarAccess.getOpOtherAccess().getAlternatives_6_1(), "rule__OpOther__Alternatives_6_1");
			builder.put(grammarAccess.getOpAddAccess().getAlternatives(), "rule__OpAdd__Alternatives");
			builder.put(grammarAccess.getOpMultiAccess().getAlternatives(), "rule__OpMulti__Alternatives");
			builder.put(grammarAccess.getXUnaryOperationAccess().getAlternatives(), "rule__XUnaryOperation__Alternatives");
			builder.put(grammarAccess.getOpUnaryAccess().getAlternatives(), "rule__OpUnary__Alternatives");
			builder.put(grammarAccess.getOpPostfixAccess().getAlternatives(), "rule__OpPostfix__Alternatives");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getAlternatives_1(), "rule__XMemberFeatureCall__Alternatives_1");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getAlternatives_1_0_0_0_1(), "rule__XMemberFeatureCall__Alternatives_1_0_0_0_1");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getAlternatives_1_1_0_0_1(), "rule__XMemberFeatureCall__Alternatives_1_1_0_0_1");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getAlternatives_1_1_3_1(), "rule__XMemberFeatureCall__Alternatives_1_1_3_1");
			builder.put(grammarAccess.getXPrimaryExpressionAccess().getAlternatives(), "rule__XPrimaryExpression__Alternatives");
			builder.put(grammarAccess.getXLiteralAccess().getAlternatives(), "rule__XLiteral__Alternatives");
			builder.put(grammarAccess.getXCollectionLiteralAccess().getAlternatives(), "rule__XCollectionLiteral__Alternatives");
			builder.put(grammarAccess.getXSwitchExpressionAccess().getAlternatives_2(), "rule__XSwitchExpression__Alternatives_2");
			builder.put(grammarAccess.getXCasePartAccess().getAlternatives_3(), "rule__XCasePart__Alternatives_3");
			builder.put(grammarAccess.getXExpressionOrVarDeclarationAccess().getAlternatives(), "rule__XExpressionOrVarDeclaration__Alternatives");
			builder.put(grammarAccess.getXVariableDeclarationAccess().getAlternatives_1(), "rule__XVariableDeclaration__Alternatives_1");
			builder.put(grammarAccess.getXVariableDeclarationAccess().getAlternatives_2(), "rule__XVariableDeclaration__Alternatives_2");
			builder.put(grammarAccess.getXFeatureCallAccess().getAlternatives_3_1(), "rule__XFeatureCall__Alternatives_3_1");
			builder.put(grammarAccess.getFeatureCallIDAccess().getAlternatives(), "rule__FeatureCallID__Alternatives");
			builder.put(grammarAccess.getIdOrSuperAccess().getAlternatives(), "rule__IdOrSuper__Alternatives");
			builder.put(grammarAccess.getXConstructorCallAccess().getAlternatives_4_1(), "rule__XConstructorCall__Alternatives_4_1");
			builder.put(grammarAccess.getXBooleanLiteralAccess().getAlternatives_1(), "rule__XBooleanLiteral__Alternatives_1");
			builder.put(grammarAccess.getXTryCatchFinallyExpressionAccess().getAlternatives_3(), "rule__XTryCatchFinallyExpression__Alternatives_3");
			builder.put(grammarAccess.getNumberAccess().getAlternatives(), "rule__Number__Alternatives");
			builder.put(grammarAccess.getNumberAccess().getAlternatives_1_0(), "rule__Number__Alternatives_1_0");
			builder.put(grammarAccess.getNumberAccess().getAlternatives_1_1_1(), "rule__Number__Alternatives_1_1_1");
			builder.put(grammarAccess.getJvmTypeReferenceAccess().getAlternatives(), "rule__JvmTypeReference__Alternatives");
			builder.put(grammarAccess.getJvmArgumentTypeReferenceAccess().getAlternatives(), "rule__JvmArgumentTypeReference__Alternatives");
			builder.put(grammarAccess.getJvmWildcardTypeReferenceAccess().getAlternatives_2(), "rule__JvmWildcardTypeReference__Alternatives_2");
			builder.put(grammarAccess.getXImportDeclarationAccess().getAlternatives_1(), "rule__XImportDeclaration__Alternatives_1");
			builder.put(grammarAccess.getXImportDeclarationAccess().getAlternatives_1_0_3(), "rule__XImportDeclaration__Alternatives_1_0_3");
			builder.put(grammarAccess.getDefinitionAccess().getGroup(), "rule__Definition__Group__0");
			builder.put(grammarAccess.getEntityAccess().getGroup(), "rule__Entity__Group__0");
			builder.put(grammarAccess.getEntityAccess().getGroup_5(), "rule__Entity__Group_5__0");
			builder.put(grammarAccess.getPropertyAccess().getGroup(), "rule__Property__Group__0");
			builder.put(grammarAccess.getEEnumAccess().getGroup(), "rule__EEnum__Group__0");
			builder.put(grammarAccess.getLayoutAccess().getGroup(), "rule__Layout__Group__0");
			builder.put(grammarAccess.getInlineAccess().getGroup(), "rule__Inline__Group__0");
			builder.put(grammarAccess.getInlineAccess().getGroup_2(), "rule__Inline__Group_2__0");
			builder.put(grammarAccess.getXAnnotationAccess().getGroup(), "rule__XAnnotation__Group__0");
			builder.put(grammarAccess.getXAnnotationAccess().getGroup_3(), "rule__XAnnotation__Group_3__0");
			builder.put(grammarAccess.getXAnnotationAccess().getGroup_3_1_0(), "rule__XAnnotation__Group_3_1_0__0");
			builder.put(grammarAccess.getXAnnotationAccess().getGroup_3_1_0_1(), "rule__XAnnotation__Group_3_1_0_1__0");
			builder.put(grammarAccess.getXAnnotationElementValuePairAccess().getGroup(), "rule__XAnnotationElementValuePair__Group__0");
			builder.put(grammarAccess.getXAnnotationElementValuePairAccess().getGroup_0(), "rule__XAnnotationElementValuePair__Group_0__0");
			builder.put(grammarAccess.getXAnnotationElementValuePairAccess().getGroup_0_0(), "rule__XAnnotationElementValuePair__Group_0_0__0");
			builder.put(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_0(), "rule__XAnnotationElementValueOrCommaList__Group_0__0");
			builder.put(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_0_0(), "rule__XAnnotationElementValueOrCommaList__Group_0_0__0");
			builder.put(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_0_0_0(), "rule__XAnnotationElementValueOrCommaList__Group_0_0_0__0");
			builder.put(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_0_1(), "rule__XAnnotationElementValueOrCommaList__Group_0_1__0");
			builder.put(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_0_1_1(), "rule__XAnnotationElementValueOrCommaList__Group_0_1_1__0");
			builder.put(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_1(), "rule__XAnnotationElementValueOrCommaList__Group_1__0");
			builder.put(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_1_1(), "rule__XAnnotationElementValueOrCommaList__Group_1_1__0");
			builder.put(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getGroup_1_1_1(), "rule__XAnnotationElementValueOrCommaList__Group_1_1_1__0");
			builder.put(grammarAccess.getXAnnotationElementValueAccess().getGroup_0(), "rule__XAnnotationElementValue__Group_0__0");
			builder.put(grammarAccess.getXAnnotationElementValueAccess().getGroup_0_0(), "rule__XAnnotationElementValue__Group_0_0__0");
			builder.put(grammarAccess.getXAnnotationElementValueAccess().getGroup_0_0_0(), "rule__XAnnotationElementValue__Group_0_0_0__0");
			builder.put(grammarAccess.getXAnnotationElementValueAccess().getGroup_0_1(), "rule__XAnnotationElementValue__Group_0_1__0");
			builder.put(grammarAccess.getXAnnotationElementValueAccess().getGroup_0_1_1(), "rule__XAnnotationElementValue__Group_0_1_1__0");
			builder.put(grammarAccess.getXAssignmentAccess().getGroup_0(), "rule__XAssignment__Group_0__0");
			builder.put(grammarAccess.getXAssignmentAccess().getGroup_1(), "rule__XAssignment__Group_1__0");
			builder.put(grammarAccess.getXAssignmentAccess().getGroup_1_1(), "rule__XAssignment__Group_1_1__0");
			builder.put(grammarAccess.getXAssignmentAccess().getGroup_1_1_0(), "rule__XAssignment__Group_1_1_0__0");
			builder.put(grammarAccess.getXAssignmentAccess().getGroup_1_1_0_0(), "rule__XAssignment__Group_1_1_0_0__0");
			builder.put(grammarAccess.getOpMultiAssignAccess().getGroup_5(), "rule__OpMultiAssign__Group_5__0");
			builder.put(grammarAccess.getOpMultiAssignAccess().getGroup_6(), "rule__OpMultiAssign__Group_6__0");
			builder.put(grammarAccess.getXOrExpressionAccess().getGroup(), "rule__XOrExpression__Group__0");
			builder.put(grammarAccess.getXOrExpressionAccess().getGroup_1(), "rule__XOrExpression__Group_1__0");
			builder.put(grammarAccess.getXOrExpressionAccess().getGroup_1_0(), "rule__XOrExpression__Group_1_0__0");
			builder.put(grammarAccess.getXOrExpressionAccess().getGroup_1_0_0(), "rule__XOrExpression__Group_1_0_0__0");
			builder.put(grammarAccess.getXAndExpressionAccess().getGroup(), "rule__XAndExpression__Group__0");
			builder.put(grammarAccess.getXAndExpressionAccess().getGroup_1(), "rule__XAndExpression__Group_1__0");
			builder.put(grammarAccess.getXAndExpressionAccess().getGroup_1_0(), "rule__XAndExpression__Group_1_0__0");
			builder.put(grammarAccess.getXAndExpressionAccess().getGroup_1_0_0(), "rule__XAndExpression__Group_1_0_0__0");
			builder.put(grammarAccess.getXEqualityExpressionAccess().getGroup(), "rule__XEqualityExpression__Group__0");
			builder.put(grammarAccess.getXEqualityExpressionAccess().getGroup_1(), "rule__XEqualityExpression__Group_1__0");
			builder.put(grammarAccess.getXEqualityExpressionAccess().getGroup_1_0(), "rule__XEqualityExpression__Group_1_0__0");
			builder.put(grammarAccess.getXEqualityExpressionAccess().getGroup_1_0_0(), "rule__XEqualityExpression__Group_1_0_0__0");
			builder.put(grammarAccess.getXRelationalExpressionAccess().getGroup(), "rule__XRelationalExpression__Group__0");
			builder.put(grammarAccess.getXRelationalExpressionAccess().getGroup_1_0(), "rule__XRelationalExpression__Group_1_0__0");
			builder.put(grammarAccess.getXRelationalExpressionAccess().getGroup_1_0_0(), "rule__XRelationalExpression__Group_1_0_0__0");
			builder.put(grammarAccess.getXRelationalExpressionAccess().getGroup_1_0_0_0(), "rule__XRelationalExpression__Group_1_0_0_0__0");
			builder.put(grammarAccess.getXRelationalExpressionAccess().getGroup_1_1(), "rule__XRelationalExpression__Group_1_1__0");
			builder.put(grammarAccess.getXRelationalExpressionAccess().getGroup_1_1_0(), "rule__XRelationalExpression__Group_1_1_0__0");
			builder.put(grammarAccess.getXRelationalExpressionAccess().getGroup_1_1_0_0(), "rule__XRelationalExpression__Group_1_1_0_0__0");
			builder.put(grammarAccess.getOpCompareAccess().getGroup_1(), "rule__OpCompare__Group_1__0");
			builder.put(grammarAccess.getXOtherOperatorExpressionAccess().getGroup(), "rule__XOtherOperatorExpression__Group__0");
			builder.put(grammarAccess.getXOtherOperatorExpressionAccess().getGroup_1(), "rule__XOtherOperatorExpression__Group_1__0");
			builder.put(grammarAccess.getXOtherOperatorExpressionAccess().getGroup_1_0(), "rule__XOtherOperatorExpression__Group_1_0__0");
			builder.put(grammarAccess.getXOtherOperatorExpressionAccess().getGroup_1_0_0(), "rule__XOtherOperatorExpression__Group_1_0_0__0");
			builder.put(grammarAccess.getOpOtherAccess().getGroup_2(), "rule__OpOther__Group_2__0");
			builder.put(grammarAccess.getOpOtherAccess().getGroup_5(), "rule__OpOther__Group_5__0");
			builder.put(grammarAccess.getOpOtherAccess().getGroup_5_1_0(), "rule__OpOther__Group_5_1_0__0");
			builder.put(grammarAccess.getOpOtherAccess().getGroup_5_1_0_0(), "rule__OpOther__Group_5_1_0_0__0");
			builder.put(grammarAccess.getOpOtherAccess().getGroup_6(), "rule__OpOther__Group_6__0");
			builder.put(grammarAccess.getOpOtherAccess().getGroup_6_1_0(), "rule__OpOther__Group_6_1_0__0");
			builder.put(grammarAccess.getOpOtherAccess().getGroup_6_1_0_0(), "rule__OpOther__Group_6_1_0_0__0");
			builder.put(grammarAccess.getXAdditiveExpressionAccess().getGroup(), "rule__XAdditiveExpression__Group__0");
			builder.put(grammarAccess.getXAdditiveExpressionAccess().getGroup_1(), "rule__XAdditiveExpression__Group_1__0");
			builder.put(grammarAccess.getXAdditiveExpressionAccess().getGroup_1_0(), "rule__XAdditiveExpression__Group_1_0__0");
			builder.put(grammarAccess.getXAdditiveExpressionAccess().getGroup_1_0_0(), "rule__XAdditiveExpression__Group_1_0_0__0");
			builder.put(grammarAccess.getXMultiplicativeExpressionAccess().getGroup(), "rule__XMultiplicativeExpression__Group__0");
			builder.put(grammarAccess.getXMultiplicativeExpressionAccess().getGroup_1(), "rule__XMultiplicativeExpression__Group_1__0");
			builder.put(grammarAccess.getXMultiplicativeExpressionAccess().getGroup_1_0(), "rule__XMultiplicativeExpression__Group_1_0__0");
			builder.put(grammarAccess.getXMultiplicativeExpressionAccess().getGroup_1_0_0(), "rule__XMultiplicativeExpression__Group_1_0_0__0");
			builder.put(grammarAccess.getXUnaryOperationAccess().getGroup_0(), "rule__XUnaryOperation__Group_0__0");
			builder.put(grammarAccess.getXCastedExpressionAccess().getGroup(), "rule__XCastedExpression__Group__0");
			builder.put(grammarAccess.getXCastedExpressionAccess().getGroup_1(), "rule__XCastedExpression__Group_1__0");
			builder.put(grammarAccess.getXCastedExpressionAccess().getGroup_1_0(), "rule__XCastedExpression__Group_1_0__0");
			builder.put(grammarAccess.getXCastedExpressionAccess().getGroup_1_0_0(), "rule__XCastedExpression__Group_1_0_0__0");
			builder.put(grammarAccess.getXPostfixOperationAccess().getGroup(), "rule__XPostfixOperation__Group__0");
			builder.put(grammarAccess.getXPostfixOperationAccess().getGroup_1(), "rule__XPostfixOperation__Group_1__0");
			builder.put(grammarAccess.getXPostfixOperationAccess().getGroup_1_0(), "rule__XPostfixOperation__Group_1_0__0");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getGroup(), "rule__XMemberFeatureCall__Group__0");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_0(), "rule__XMemberFeatureCall__Group_1_0__0");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_0_0(), "rule__XMemberFeatureCall__Group_1_0_0__0");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_0_0_0(), "rule__XMemberFeatureCall__Group_1_0_0_0__0");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1(), "rule__XMemberFeatureCall__Group_1_1__0");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_0(), "rule__XMemberFeatureCall__Group_1_1_0__0");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_0_0(), "rule__XMemberFeatureCall__Group_1_1_0_0__0");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_1(), "rule__XMemberFeatureCall__Group_1_1_1__0");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_1_2(), "rule__XMemberFeatureCall__Group_1_1_1_2__0");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_3(), "rule__XMemberFeatureCall__Group_1_1_3__0");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_3_1_1(), "rule__XMemberFeatureCall__Group_1_1_3_1_1__0");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getGroup_1_1_3_1_1_1(), "rule__XMemberFeatureCall__Group_1_1_3_1_1_1__0");
			builder.put(grammarAccess.getXSetLiteralAccess().getGroup(), "rule__XSetLiteral__Group__0");
			builder.put(grammarAccess.getXSetLiteralAccess().getGroup_3(), "rule__XSetLiteral__Group_3__0");
			builder.put(grammarAccess.getXSetLiteralAccess().getGroup_3_1(), "rule__XSetLiteral__Group_3_1__0");
			builder.put(grammarAccess.getXListLiteralAccess().getGroup(), "rule__XListLiteral__Group__0");
			builder.put(grammarAccess.getXListLiteralAccess().getGroup_3(), "rule__XListLiteral__Group_3__0");
			builder.put(grammarAccess.getXListLiteralAccess().getGroup_3_1(), "rule__XListLiteral__Group_3_1__0");
			builder.put(grammarAccess.getXClosureAccess().getGroup(), "rule__XClosure__Group__0");
			builder.put(grammarAccess.getXClosureAccess().getGroup_0(), "rule__XClosure__Group_0__0");
			builder.put(grammarAccess.getXClosureAccess().getGroup_0_0(), "rule__XClosure__Group_0_0__0");
			builder.put(grammarAccess.getXClosureAccess().getGroup_1(), "rule__XClosure__Group_1__0");
			builder.put(grammarAccess.getXClosureAccess().getGroup_1_0(), "rule__XClosure__Group_1_0__0");
			builder.put(grammarAccess.getXClosureAccess().getGroup_1_0_0(), "rule__XClosure__Group_1_0_0__0");
			builder.put(grammarAccess.getXClosureAccess().getGroup_1_0_0_1(), "rule__XClosure__Group_1_0_0_1__0");
			builder.put(grammarAccess.getXExpressionInClosureAccess().getGroup(), "rule__XExpressionInClosure__Group__0");
			builder.put(grammarAccess.getXExpressionInClosureAccess().getGroup_1(), "rule__XExpressionInClosure__Group_1__0");
			builder.put(grammarAccess.getXShortClosureAccess().getGroup(), "rule__XShortClosure__Group__0");
			builder.put(grammarAccess.getXShortClosureAccess().getGroup_0(), "rule__XShortClosure__Group_0__0");
			builder.put(grammarAccess.getXShortClosureAccess().getGroup_0_0(), "rule__XShortClosure__Group_0_0__0");
			builder.put(grammarAccess.getXShortClosureAccess().getGroup_0_0_1(), "rule__XShortClosure__Group_0_0_1__0");
			builder.put(grammarAccess.getXShortClosureAccess().getGroup_0_0_1_1(), "rule__XShortClosure__Group_0_0_1_1__0");
			builder.put(grammarAccess.getXParenthesizedExpressionAccess().getGroup(), "rule__XParenthesizedExpression__Group__0");
			builder.put(grammarAccess.getXIfExpressionAccess().getGroup(), "rule__XIfExpression__Group__0");
			builder.put(grammarAccess.getXIfExpressionAccess().getGroup_6(), "rule__XIfExpression__Group_6__0");
			builder.put(grammarAccess.getXSwitchExpressionAccess().getGroup(), "rule__XSwitchExpression__Group__0");
			builder.put(grammarAccess.getXSwitchExpressionAccess().getGroup_2_0(), "rule__XSwitchExpression__Group_2_0__0");
			builder.put(grammarAccess.getXSwitchExpressionAccess().getGroup_2_0_0(), "rule__XSwitchExpression__Group_2_0_0__0");
			builder.put(grammarAccess.getXSwitchExpressionAccess().getGroup_2_0_0_0(), "rule__XSwitchExpression__Group_2_0_0_0__0");
			builder.put(grammarAccess.getXSwitchExpressionAccess().getGroup_2_1(), "rule__XSwitchExpression__Group_2_1__0");
			builder.put(grammarAccess.getXSwitchExpressionAccess().getGroup_2_1_0(), "rule__XSwitchExpression__Group_2_1_0__0");
			builder.put(grammarAccess.getXSwitchExpressionAccess().getGroup_2_1_0_0(), "rule__XSwitchExpression__Group_2_1_0_0__0");
			builder.put(grammarAccess.getXSwitchExpressionAccess().getGroup_5(), "rule__XSwitchExpression__Group_5__0");
			builder.put(grammarAccess.getXCasePartAccess().getGroup(), "rule__XCasePart__Group__0");
			builder.put(grammarAccess.getXCasePartAccess().getGroup_2(), "rule__XCasePart__Group_2__0");
			builder.put(grammarAccess.getXCasePartAccess().getGroup_3_0(), "rule__XCasePart__Group_3_0__0");
			builder.put(grammarAccess.getXForLoopExpressionAccess().getGroup(), "rule__XForLoopExpression__Group__0");
			builder.put(grammarAccess.getXForLoopExpressionAccess().getGroup_0(), "rule__XForLoopExpression__Group_0__0");
			builder.put(grammarAccess.getXForLoopExpressionAccess().getGroup_0_0(), "rule__XForLoopExpression__Group_0_0__0");
			builder.put(grammarAccess.getXBasicForLoopExpressionAccess().getGroup(), "rule__XBasicForLoopExpression__Group__0");
			builder.put(grammarAccess.getXBasicForLoopExpressionAccess().getGroup_3(), "rule__XBasicForLoopExpression__Group_3__0");
			builder.put(grammarAccess.getXBasicForLoopExpressionAccess().getGroup_3_1(), "rule__XBasicForLoopExpression__Group_3_1__0");
			builder.put(grammarAccess.getXBasicForLoopExpressionAccess().getGroup_7(), "rule__XBasicForLoopExpression__Group_7__0");
			builder.put(grammarAccess.getXBasicForLoopExpressionAccess().getGroup_7_1(), "rule__XBasicForLoopExpression__Group_7_1__0");
			builder.put(grammarAccess.getXWhileExpressionAccess().getGroup(), "rule__XWhileExpression__Group__0");
			builder.put(grammarAccess.getXDoWhileExpressionAccess().getGroup(), "rule__XDoWhileExpression__Group__0");
			builder.put(grammarAccess.getXBlockExpressionAccess().getGroup(), "rule__XBlockExpression__Group__0");
			builder.put(grammarAccess.getXBlockExpressionAccess().getGroup_2(), "rule__XBlockExpression__Group_2__0");
			builder.put(grammarAccess.getXVariableDeclarationAccess().getGroup(), "rule__XVariableDeclaration__Group__0");
			builder.put(grammarAccess.getXVariableDeclarationAccess().getGroup_2_0(), "rule__XVariableDeclaration__Group_2_0__0");
			builder.put(grammarAccess.getXVariableDeclarationAccess().getGroup_2_0_0(), "rule__XVariableDeclaration__Group_2_0_0__0");
			builder.put(grammarAccess.getXVariableDeclarationAccess().getGroup_3(), "rule__XVariableDeclaration__Group_3__0");
			builder.put(grammarAccess.getJvmFormalParameterAccess().getGroup(), "rule__JvmFormalParameter__Group__0");
			builder.put(grammarAccess.getFullJvmFormalParameterAccess().getGroup(), "rule__FullJvmFormalParameter__Group__0");
			builder.put(grammarAccess.getXFeatureCallAccess().getGroup(), "rule__XFeatureCall__Group__0");
			builder.put(grammarAccess.getXFeatureCallAccess().getGroup_1(), "rule__XFeatureCall__Group_1__0");
			builder.put(grammarAccess.getXFeatureCallAccess().getGroup_1_2(), "rule__XFeatureCall__Group_1_2__0");
			builder.put(grammarAccess.getXFeatureCallAccess().getGroup_3(), "rule__XFeatureCall__Group_3__0");
			builder.put(grammarAccess.getXFeatureCallAccess().getGroup_3_1_1(), "rule__XFeatureCall__Group_3_1_1__0");
			builder.put(grammarAccess.getXFeatureCallAccess().getGroup_3_1_1_1(), "rule__XFeatureCall__Group_3_1_1_1__0");
			builder.put(grammarAccess.getXConstructorCallAccess().getGroup(), "rule__XConstructorCall__Group__0");
			builder.put(grammarAccess.getXConstructorCallAccess().getGroup_3(), "rule__XConstructorCall__Group_3__0");
			builder.put(grammarAccess.getXConstructorCallAccess().getGroup_3_2(), "rule__XConstructorCall__Group_3_2__0");
			builder.put(grammarAccess.getXConstructorCallAccess().getGroup_4(), "rule__XConstructorCall__Group_4__0");
			builder.put(grammarAccess.getXConstructorCallAccess().getGroup_4_1_1(), "rule__XConstructorCall__Group_4_1_1__0");
			builder.put(grammarAccess.getXConstructorCallAccess().getGroup_4_1_1_1(), "rule__XConstructorCall__Group_4_1_1_1__0");
			builder.put(grammarAccess.getXBooleanLiteralAccess().getGroup(), "rule__XBooleanLiteral__Group__0");
			builder.put(grammarAccess.getXNullLiteralAccess().getGroup(), "rule__XNullLiteral__Group__0");
			builder.put(grammarAccess.getXNumberLiteralAccess().getGroup(), "rule__XNumberLiteral__Group__0");
			builder.put(grammarAccess.getXStringLiteralAccess().getGroup(), "rule__XStringLiteral__Group__0");
			builder.put(grammarAccess.getXTypeLiteralAccess().getGroup(), "rule__XTypeLiteral__Group__0");
			builder.put(grammarAccess.getXThrowExpressionAccess().getGroup(), "rule__XThrowExpression__Group__0");
			builder.put(grammarAccess.getXReturnExpressionAccess().getGroup(), "rule__XReturnExpression__Group__0");
			builder.put(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup(), "rule__XTryCatchFinallyExpression__Group__0");
			builder.put(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_3_0(), "rule__XTryCatchFinallyExpression__Group_3_0__0");
			builder.put(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_3_0_1(), "rule__XTryCatchFinallyExpression__Group_3_0_1__0");
			builder.put(grammarAccess.getXTryCatchFinallyExpressionAccess().getGroup_3_1(), "rule__XTryCatchFinallyExpression__Group_3_1__0");
			builder.put(grammarAccess.getXSynchronizedExpressionAccess().getGroup(), "rule__XSynchronizedExpression__Group__0");
			builder.put(grammarAccess.getXSynchronizedExpressionAccess().getGroup_0(), "rule__XSynchronizedExpression__Group_0__0");
			builder.put(grammarAccess.getXSynchronizedExpressionAccess().getGroup_0_0(), "rule__XSynchronizedExpression__Group_0_0__0");
			builder.put(grammarAccess.getXCatchClauseAccess().getGroup(), "rule__XCatchClause__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			builder.put(grammarAccess.getNumberAccess().getGroup_1(), "rule__Number__Group_1__0");
			builder.put(grammarAccess.getNumberAccess().getGroup_1_1(), "rule__Number__Group_1_1__0");
			builder.put(grammarAccess.getStaticQualifierAccess().getGroup(), "rule__StaticQualifier__Group__0");
			builder.put(grammarAccess.getJvmTypeReferenceAccess().getGroup_0(), "rule__JvmTypeReference__Group_0__0");
			builder.put(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1(), "rule__JvmTypeReference__Group_0_1__0");
			builder.put(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1_0(), "rule__JvmTypeReference__Group_0_1_0__0");
			builder.put(grammarAccess.getArrayBracketsAccess().getGroup(), "rule__ArrayBrackets__Group__0");
			builder.put(grammarAccess.getXFunctionTypeRefAccess().getGroup(), "rule__XFunctionTypeRef__Group__0");
			builder.put(grammarAccess.getXFunctionTypeRefAccess().getGroup_0(), "rule__XFunctionTypeRef__Group_0__0");
			builder.put(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1(), "rule__XFunctionTypeRef__Group_0_1__0");
			builder.put(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1_1(), "rule__XFunctionTypeRef__Group_0_1_1__0");
			builder.put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup(), "rule__JvmParameterizedTypeReference__Group__0");
			builder.put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1(), "rule__JvmParameterizedTypeReference__Group_1__0");
			builder.put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_2(), "rule__JvmParameterizedTypeReference__Group_1_2__0");
			builder.put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4(), "rule__JvmParameterizedTypeReference__Group_1_4__0");
			builder.put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0(), "rule__JvmParameterizedTypeReference__Group_1_4_0__0");
			builder.put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0_0(), "rule__JvmParameterizedTypeReference__Group_1_4_0_0__0");
			builder.put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2(), "rule__JvmParameterizedTypeReference__Group_1_4_2__0");
			builder.put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2_2(), "rule__JvmParameterizedTypeReference__Group_1_4_2_2__0");
			builder.put(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup(), "rule__JvmWildcardTypeReference__Group__0");
			builder.put(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup_2_0(), "rule__JvmWildcardTypeReference__Group_2_0__0");
			builder.put(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup_2_1(), "rule__JvmWildcardTypeReference__Group_2_1__0");
			builder.put(grammarAccess.getJvmUpperBoundAccess().getGroup(), "rule__JvmUpperBound__Group__0");
			builder.put(grammarAccess.getJvmUpperBoundAndedAccess().getGroup(), "rule__JvmUpperBoundAnded__Group__0");
			builder.put(grammarAccess.getJvmLowerBoundAccess().getGroup(), "rule__JvmLowerBound__Group__0");
			builder.put(grammarAccess.getJvmLowerBoundAndedAccess().getGroup(), "rule__JvmLowerBoundAnded__Group__0");
			builder.put(grammarAccess.getJvmTypeParameterAccess().getGroup(), "rule__JvmTypeParameter__Group__0");
			builder.put(grammarAccess.getJvmTypeParameterAccess().getGroup_1(), "rule__JvmTypeParameter__Group_1__0");
			builder.put(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup(), "rule__QualifiedNameWithWildcard__Group__0");
			builder.put(grammarAccess.getXImportDeclarationAccess().getGroup(), "rule__XImportDeclaration__Group__0");
			builder.put(grammarAccess.getXImportDeclarationAccess().getGroup_1_0(), "rule__XImportDeclaration__Group_1_0__0");
			builder.put(grammarAccess.getQualifiedNameInStaticImportAccess().getGroup(), "rule__QualifiedNameInStaticImport__Group__0");
			builder.put(grammarAccess.getDefinitionAccess().getNameAssignment_1(), "rule__Definition__NameAssignment_1");
			builder.put(grammarAccess.getDefinitionAccess().getImportSectionAssignment_2(), "rule__Definition__ImportSectionAssignment_2");
			builder.put(grammarAccess.getDefinitionAccess().getModelsAssignment_3(), "rule__Definition__ModelsAssignment_3");
			builder.put(grammarAccess.getEntityAccess().getAnnotationsAssignment_1(), "rule__Entity__AnnotationsAssignment_1");
			builder.put(grammarAccess.getEntityAccess().getMasterAssignment_2(), "rule__Entity__MasterAssignment_2");
			builder.put(grammarAccess.getEntityAccess().getNameAssignment_4(), "rule__Entity__NameAssignment_4");
			builder.put(grammarAccess.getEntityAccess().getSuperTypeAssignment_5_1(), "rule__Entity__SuperTypeAssignment_5_1");
			builder.put(grammarAccess.getEntityAccess().getPropertiesAssignment_7(), "rule__Entity__PropertiesAssignment_7");
			builder.put(grammarAccess.getEntityAccess().getLayoutAssignment_8(), "rule__Entity__LayoutAssignment_8");
			builder.put(grammarAccess.getPropertyAccess().getAnnotationsAssignment_1(), "rule__Property__AnnotationsAssignment_1");
			builder.put(grammarAccess.getPropertyAccess().getNameAssignment_2(), "rule__Property__NameAssignment_2");
			builder.put(grammarAccess.getPropertyAccess().getArrayAssignment_3(), "rule__Property__ArrayAssignment_3");
			builder.put(grammarAccess.getPropertyAccess().getTypeAssignment_4(), "rule__Property__TypeAssignment_4");
			builder.put(grammarAccess.getEEnumAccess().getNameAssignment_1(), "rule__EEnum__NameAssignment_1");
			builder.put(grammarAccess.getEEnumAccess().getLiteralsAssignment_3(), "rule__EEnum__LiteralsAssignment_3");
			builder.put(grammarAccess.getLiteralAccess().getNameAssignment(), "rule__Literal__NameAssignment");
			builder.put(grammarAccess.getLayoutAccess().getInlinesAssignment_3(), "rule__Layout__InlinesAssignment_3");
			builder.put(grammarAccess.getInlineAccess().getPropertiesAssignment_1(), "rule__Inline__PropertiesAssignment_1");
			builder.put(grammarAccess.getInlineAccess().getPropertiesAssignment_2_1(), "rule__Inline__PropertiesAssignment_2_1");
			builder.put(grammarAccess.getXAnnotationAccess().getAnnotationTypeAssignment_2(), "rule__XAnnotation__AnnotationTypeAssignment_2");
			builder.put(grammarAccess.getXAnnotationAccess().getElementValuePairsAssignment_3_1_0_0(), "rule__XAnnotation__ElementValuePairsAssignment_3_1_0_0");
			builder.put(grammarAccess.getXAnnotationAccess().getElementValuePairsAssignment_3_1_0_1_1(), "rule__XAnnotation__ElementValuePairsAssignment_3_1_0_1_1");
			builder.put(grammarAccess.getXAnnotationAccess().getValueAssignment_3_1_1(), "rule__XAnnotation__ValueAssignment_3_1_1");
			builder.put(grammarAccess.getXAnnotationElementValuePairAccess().getElementAssignment_0_0_0(), "rule__XAnnotationElementValuePair__ElementAssignment_0_0_0");
			builder.put(grammarAccess.getXAnnotationElementValuePairAccess().getValueAssignment_1(), "rule__XAnnotationElementValuePair__ValueAssignment_1");
			builder.put(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsAssignment_0_1_0(), "rule__XAnnotationElementValueOrCommaList__ElementsAssignment_0_1_0");
			builder.put(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsAssignment_0_1_1_1(), "rule__XAnnotationElementValueOrCommaList__ElementsAssignment_0_1_1_1");
			builder.put(grammarAccess.getXAnnotationElementValueOrCommaListAccess().getElementsAssignment_1_1_1_1(), "rule__XAnnotationElementValueOrCommaList__ElementsAssignment_1_1_1_1");
			builder.put(grammarAccess.getXAnnotationElementValueAccess().getElementsAssignment_0_1_0(), "rule__XAnnotationElementValue__ElementsAssignment_0_1_0");
			builder.put(grammarAccess.getXAnnotationElementValueAccess().getElementsAssignment_0_1_1_1(), "rule__XAnnotationElementValue__ElementsAssignment_0_1_1_1");
			builder.put(grammarAccess.getXAssignmentAccess().getFeatureAssignment_0_1(), "rule__XAssignment__FeatureAssignment_0_1");
			builder.put(grammarAccess.getXAssignmentAccess().getValueAssignment_0_3(), "rule__XAssignment__ValueAssignment_0_3");
			builder.put(grammarAccess.getXAssignmentAccess().getFeatureAssignment_1_1_0_0_1(), "rule__XAssignment__FeatureAssignment_1_1_0_0_1");
			builder.put(grammarAccess.getXAssignmentAccess().getRightOperandAssignment_1_1_1(), "rule__XAssignment__RightOperandAssignment_1_1_1");
			builder.put(grammarAccess.getXOrExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__XOrExpression__FeatureAssignment_1_0_0_1");
			builder.put(grammarAccess.getXOrExpressionAccess().getRightOperandAssignment_1_1(), "rule__XOrExpression__RightOperandAssignment_1_1");
			builder.put(grammarAccess.getXAndExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__XAndExpression__FeatureAssignment_1_0_0_1");
			builder.put(grammarAccess.getXAndExpressionAccess().getRightOperandAssignment_1_1(), "rule__XAndExpression__RightOperandAssignment_1_1");
			builder.put(grammarAccess.getXEqualityExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__XEqualityExpression__FeatureAssignment_1_0_0_1");
			builder.put(grammarAccess.getXEqualityExpressionAccess().getRightOperandAssignment_1_1(), "rule__XEqualityExpression__RightOperandAssignment_1_1");
			builder.put(grammarAccess.getXRelationalExpressionAccess().getTypeAssignment_1_0_1(), "rule__XRelationalExpression__TypeAssignment_1_0_1");
			builder.put(grammarAccess.getXRelationalExpressionAccess().getFeatureAssignment_1_1_0_0_1(), "rule__XRelationalExpression__FeatureAssignment_1_1_0_0_1");
			builder.put(grammarAccess.getXRelationalExpressionAccess().getRightOperandAssignment_1_1_1(), "rule__XRelationalExpression__RightOperandAssignment_1_1_1");
			builder.put(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__XOtherOperatorExpression__FeatureAssignment_1_0_0_1");
			builder.put(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandAssignment_1_1(), "rule__XOtherOperatorExpression__RightOperandAssignment_1_1");
			builder.put(grammarAccess.getXAdditiveExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__XAdditiveExpression__FeatureAssignment_1_0_0_1");
			builder.put(grammarAccess.getXAdditiveExpressionAccess().getRightOperandAssignment_1_1(), "rule__XAdditiveExpression__RightOperandAssignment_1_1");
			builder.put(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__XMultiplicativeExpression__FeatureAssignment_1_0_0_1");
			builder.put(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandAssignment_1_1(), "rule__XMultiplicativeExpression__RightOperandAssignment_1_1");
			builder.put(grammarAccess.getXUnaryOperationAccess().getFeatureAssignment_0_1(), "rule__XUnaryOperation__FeatureAssignment_0_1");
			builder.put(grammarAccess.getXUnaryOperationAccess().getOperandAssignment_0_2(), "rule__XUnaryOperation__OperandAssignment_0_2");
			builder.put(grammarAccess.getXCastedExpressionAccess().getTypeAssignment_1_1(), "rule__XCastedExpression__TypeAssignment_1_1");
			builder.put(grammarAccess.getXPostfixOperationAccess().getFeatureAssignment_1_0_1(), "rule__XPostfixOperation__FeatureAssignment_1_0_1");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticAssignment_1_0_0_0_1_1(), "rule__XMemberFeatureCall__ExplicitStaticAssignment_1_0_0_0_1_1");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getFeatureAssignment_1_0_0_0_2(), "rule__XMemberFeatureCall__FeatureAssignment_1_0_0_0_2");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getValueAssignment_1_0_1(), "rule__XMemberFeatureCall__ValueAssignment_1_0_1");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getNullSafeAssignment_1_1_0_0_1_1(), "rule__XMemberFeatureCall__NullSafeAssignment_1_1_0_0_1_1");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticAssignment_1_1_0_0_1_2(), "rule__XMemberFeatureCall__ExplicitStaticAssignment_1_1_0_0_1_2");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsAssignment_1_1_1_1(), "rule__XMemberFeatureCall__TypeArgumentsAssignment_1_1_1_1");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsAssignment_1_1_1_2_1(), "rule__XMemberFeatureCall__TypeArgumentsAssignment_1_1_1_2_1");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getFeatureAssignment_1_1_2(), "rule__XMemberFeatureCall__FeatureAssignment_1_1_2");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallAssignment_1_1_3_0(), "rule__XMemberFeatureCall__ExplicitOperationCallAssignment_1_1_3_0");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsAssignment_1_1_3_1_0(), "rule__XMemberFeatureCall__MemberCallArgumentsAssignment_1_1_3_1_0");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsAssignment_1_1_3_1_1_0(), "rule__XMemberFeatureCall__MemberCallArgumentsAssignment_1_1_3_1_1_0");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsAssignment_1_1_3_1_1_1_1(), "rule__XMemberFeatureCall__MemberCallArgumentsAssignment_1_1_3_1_1_1_1");
			builder.put(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsAssignment_1_1_4(), "rule__XMemberFeatureCall__MemberCallArgumentsAssignment_1_1_4");
			builder.put(grammarAccess.getXSetLiteralAccess().getElementsAssignment_3_0(), "rule__XSetLiteral__ElementsAssignment_3_0");
			builder.put(grammarAccess.getXSetLiteralAccess().getElementsAssignment_3_1_1(), "rule__XSetLiteral__ElementsAssignment_3_1_1");
			builder.put(grammarAccess.getXListLiteralAccess().getElementsAssignment_3_0(), "rule__XListLiteral__ElementsAssignment_3_0");
			builder.put(grammarAccess.getXListLiteralAccess().getElementsAssignment_3_1_1(), "rule__XListLiteral__ElementsAssignment_3_1_1");
			builder.put(grammarAccess.getXClosureAccess().getDeclaredFormalParametersAssignment_1_0_0_0(), "rule__XClosure__DeclaredFormalParametersAssignment_1_0_0_0");
			builder.put(grammarAccess.getXClosureAccess().getDeclaredFormalParametersAssignment_1_0_0_1_1(), "rule__XClosure__DeclaredFormalParametersAssignment_1_0_0_1_1");
			builder.put(grammarAccess.getXClosureAccess().getExplicitSyntaxAssignment_1_0_1(), "rule__XClosure__ExplicitSyntaxAssignment_1_0_1");
			builder.put(grammarAccess.getXClosureAccess().getExpressionAssignment_2(), "rule__XClosure__ExpressionAssignment_2");
			builder.put(grammarAccess.getXExpressionInClosureAccess().getExpressionsAssignment_1_0(), "rule__XExpressionInClosure__ExpressionsAssignment_1_0");
			builder.put(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersAssignment_0_0_1_0(), "rule__XShortClosure__DeclaredFormalParametersAssignment_0_0_1_0");
			builder.put(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersAssignment_0_0_1_1_1(), "rule__XShortClosure__DeclaredFormalParametersAssignment_0_0_1_1_1");
			builder.put(grammarAccess.getXShortClosureAccess().getExplicitSyntaxAssignment_0_0_2(), "rule__XShortClosure__ExplicitSyntaxAssignment_0_0_2");
			builder.put(grammarAccess.getXShortClosureAccess().getExpressionAssignment_1(), "rule__XShortClosure__ExpressionAssignment_1");
			builder.put(grammarAccess.getXIfExpressionAccess().getIfAssignment_3(), "rule__XIfExpression__IfAssignment_3");
			builder.put(grammarAccess.getXIfExpressionAccess().getThenAssignment_5(), "rule__XIfExpression__ThenAssignment_5");
			builder.put(grammarAccess.getXIfExpressionAccess().getElseAssignment_6_1(), "rule__XIfExpression__ElseAssignment_6_1");
			builder.put(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamAssignment_2_0_0_0_1(), "rule__XSwitchExpression__DeclaredParamAssignment_2_0_0_0_1");
			builder.put(grammarAccess.getXSwitchExpressionAccess().getSwitchAssignment_2_0_1(), "rule__XSwitchExpression__SwitchAssignment_2_0_1");
			builder.put(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamAssignment_2_1_0_0_0(), "rule__XSwitchExpression__DeclaredParamAssignment_2_1_0_0_0");
			builder.put(grammarAccess.getXSwitchExpressionAccess().getSwitchAssignment_2_1_1(), "rule__XSwitchExpression__SwitchAssignment_2_1_1");
			builder.put(grammarAccess.getXSwitchExpressionAccess().getCasesAssignment_4(), "rule__XSwitchExpression__CasesAssignment_4");
			builder.put(grammarAccess.getXSwitchExpressionAccess().getDefaultAssignment_5_2(), "rule__XSwitchExpression__DefaultAssignment_5_2");
			builder.put(grammarAccess.getXCasePartAccess().getTypeGuardAssignment_1(), "rule__XCasePart__TypeGuardAssignment_1");
			builder.put(grammarAccess.getXCasePartAccess().getCaseAssignment_2_1(), "rule__XCasePart__CaseAssignment_2_1");
			builder.put(grammarAccess.getXCasePartAccess().getThenAssignment_3_0_1(), "rule__XCasePart__ThenAssignment_3_0_1");
			builder.put(grammarAccess.getXCasePartAccess().getFallThroughAssignment_3_1(), "rule__XCasePart__FallThroughAssignment_3_1");
			builder.put(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamAssignment_0_0_3(), "rule__XForLoopExpression__DeclaredParamAssignment_0_0_3");
			builder.put(grammarAccess.getXForLoopExpressionAccess().getForExpressionAssignment_1(), "rule__XForLoopExpression__ForExpressionAssignment_1");
			builder.put(grammarAccess.getXForLoopExpressionAccess().getEachExpressionAssignment_3(), "rule__XForLoopExpression__EachExpressionAssignment_3");
			builder.put(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsAssignment_3_0(), "rule__XBasicForLoopExpression__InitExpressionsAssignment_3_0");
			builder.put(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsAssignment_3_1_1(), "rule__XBasicForLoopExpression__InitExpressionsAssignment_3_1_1");
			builder.put(grammarAccess.getXBasicForLoopExpressionAccess().getExpressionAssignment_5(), "rule__XBasicForLoopExpression__ExpressionAssignment_5");
			builder.put(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsAssignment_7_0(), "rule__XBasicForLoopExpression__UpdateExpressionsAssignment_7_0");
			builder.put(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsAssignment_7_1_1(), "rule__XBasicForLoopExpression__UpdateExpressionsAssignment_7_1_1");
			builder.put(grammarAccess.getXBasicForLoopExpressionAccess().getEachExpressionAssignment_9(), "rule__XBasicForLoopExpression__EachExpressionAssignment_9");
			builder.put(grammarAccess.getXWhileExpressionAccess().getPredicateAssignment_3(), "rule__XWhileExpression__PredicateAssignment_3");
			builder.put(grammarAccess.getXWhileExpressionAccess().getBodyAssignment_5(), "rule__XWhileExpression__BodyAssignment_5");
			builder.put(grammarAccess.getXDoWhileExpressionAccess().getBodyAssignment_2(), "rule__XDoWhileExpression__BodyAssignment_2");
			builder.put(grammarAccess.getXDoWhileExpressionAccess().getPredicateAssignment_5(), "rule__XDoWhileExpression__PredicateAssignment_5");
			builder.put(grammarAccess.getXBlockExpressionAccess().getExpressionsAssignment_2_0(), "rule__XBlockExpression__ExpressionsAssignment_2_0");
			builder.put(grammarAccess.getXVariableDeclarationAccess().getWriteableAssignment_1_0(), "rule__XVariableDeclaration__WriteableAssignment_1_0");
			builder.put(grammarAccess.getXVariableDeclarationAccess().getTypeAssignment_2_0_0_0(), "rule__XVariableDeclaration__TypeAssignment_2_0_0_0");
			builder.put(grammarAccess.getXVariableDeclarationAccess().getNameAssignment_2_0_0_1(), "rule__XVariableDeclaration__NameAssignment_2_0_0_1");
			builder.put(grammarAccess.getXVariableDeclarationAccess().getNameAssignment_2_1(), "rule__XVariableDeclaration__NameAssignment_2_1");
			builder.put(grammarAccess.getXVariableDeclarationAccess().getRightAssignment_3_1(), "rule__XVariableDeclaration__RightAssignment_3_1");
			builder.put(grammarAccess.getJvmFormalParameterAccess().getParameterTypeAssignment_0(), "rule__JvmFormalParameter__ParameterTypeAssignment_0");
			builder.put(grammarAccess.getJvmFormalParameterAccess().getNameAssignment_1(), "rule__JvmFormalParameter__NameAssignment_1");
			builder.put(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeAssignment_0(), "rule__FullJvmFormalParameter__ParameterTypeAssignment_0");
			builder.put(grammarAccess.getFullJvmFormalParameterAccess().getNameAssignment_1(), "rule__FullJvmFormalParameter__NameAssignment_1");
			builder.put(grammarAccess.getXFeatureCallAccess().getTypeArgumentsAssignment_1_1(), "rule__XFeatureCall__TypeArgumentsAssignment_1_1");
			builder.put(grammarAccess.getXFeatureCallAccess().getTypeArgumentsAssignment_1_2_1(), "rule__XFeatureCall__TypeArgumentsAssignment_1_2_1");
			builder.put(grammarAccess.getXFeatureCallAccess().getFeatureAssignment_2(), "rule__XFeatureCall__FeatureAssignment_2");
			builder.put(grammarAccess.getXFeatureCallAccess().getExplicitOperationCallAssignment_3_0(), "rule__XFeatureCall__ExplicitOperationCallAssignment_3_0");
			builder.put(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsAssignment_3_1_0(), "rule__XFeatureCall__FeatureCallArgumentsAssignment_3_1_0");
			builder.put(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsAssignment_3_1_1_0(), "rule__XFeatureCall__FeatureCallArgumentsAssignment_3_1_1_0");
			builder.put(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsAssignment_3_1_1_1_1(), "rule__XFeatureCall__FeatureCallArgumentsAssignment_3_1_1_1_1");
			builder.put(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsAssignment_4(), "rule__XFeatureCall__FeatureCallArgumentsAssignment_4");
			builder.put(grammarAccess.getXConstructorCallAccess().getConstructorAssignment_2(), "rule__XConstructorCall__ConstructorAssignment_2");
			builder.put(grammarAccess.getXConstructorCallAccess().getTypeArgumentsAssignment_3_1(), "rule__XConstructorCall__TypeArgumentsAssignment_3_1");
			builder.put(grammarAccess.getXConstructorCallAccess().getTypeArgumentsAssignment_3_2_1(), "rule__XConstructorCall__TypeArgumentsAssignment_3_2_1");
			builder.put(grammarAccess.getXConstructorCallAccess().getExplicitConstructorCallAssignment_4_0(), "rule__XConstructorCall__ExplicitConstructorCallAssignment_4_0");
			builder.put(grammarAccess.getXConstructorCallAccess().getArgumentsAssignment_4_1_0(), "rule__XConstructorCall__ArgumentsAssignment_4_1_0");
			builder.put(grammarAccess.getXConstructorCallAccess().getArgumentsAssignment_4_1_1_0(), "rule__XConstructorCall__ArgumentsAssignment_4_1_1_0");
			builder.put(grammarAccess.getXConstructorCallAccess().getArgumentsAssignment_4_1_1_1_1(), "rule__XConstructorCall__ArgumentsAssignment_4_1_1_1_1");
			builder.put(grammarAccess.getXConstructorCallAccess().getArgumentsAssignment_5(), "rule__XConstructorCall__ArgumentsAssignment_5");
			builder.put(grammarAccess.getXBooleanLiteralAccess().getIsTrueAssignment_1_1(), "rule__XBooleanLiteral__IsTrueAssignment_1_1");
			builder.put(grammarAccess.getXNumberLiteralAccess().getValueAssignment_1(), "rule__XNumberLiteral__ValueAssignment_1");
			builder.put(grammarAccess.getXStringLiteralAccess().getValueAssignment_1(), "rule__XStringLiteral__ValueAssignment_1");
			builder.put(grammarAccess.getXTypeLiteralAccess().getTypeAssignment_3(), "rule__XTypeLiteral__TypeAssignment_3");
			builder.put(grammarAccess.getXTypeLiteralAccess().getArrayDimensionsAssignment_4(), "rule__XTypeLiteral__ArrayDimensionsAssignment_4");
			builder.put(grammarAccess.getXThrowExpressionAccess().getExpressionAssignment_2(), "rule__XThrowExpression__ExpressionAssignment_2");
			builder.put(grammarAccess.getXReturnExpressionAccess().getExpressionAssignment_2(), "rule__XReturnExpression__ExpressionAssignment_2");
			builder.put(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionAssignment_2(), "rule__XTryCatchFinallyExpression__ExpressionAssignment_2");
			builder.put(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesAssignment_3_0_0(), "rule__XTryCatchFinallyExpression__CatchClausesAssignment_3_0_0");
			builder.put(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionAssignment_3_0_1_1(), "rule__XTryCatchFinallyExpression__FinallyExpressionAssignment_3_0_1_1");
			builder.put(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionAssignment_3_1_1(), "rule__XTryCatchFinallyExpression__FinallyExpressionAssignment_3_1_1");
			builder.put(grammarAccess.getXSynchronizedExpressionAccess().getParamAssignment_1(), "rule__XSynchronizedExpression__ParamAssignment_1");
			builder.put(grammarAccess.getXSynchronizedExpressionAccess().getExpressionAssignment_3(), "rule__XSynchronizedExpression__ExpressionAssignment_3");
			builder.put(grammarAccess.getXCatchClauseAccess().getDeclaredParamAssignment_2(), "rule__XCatchClause__DeclaredParamAssignment_2");
			builder.put(grammarAccess.getXCatchClauseAccess().getExpressionAssignment_4(), "rule__XCatchClause__ExpressionAssignment_4");
			builder.put(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_0(), "rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0");
			builder.put(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_1_1(), "rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1");
			builder.put(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeAssignment_2(), "rule__XFunctionTypeRef__ReturnTypeAssignment_2");
			builder.put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_0(), "rule__JvmParameterizedTypeReference__TypeAssignment_0");
			builder.put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_1(), "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1");
			builder.put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_2_1(), "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1");
			builder.put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_1_4_1(), "rule__JvmParameterizedTypeReference__TypeAssignment_1_4_1");
			builder.put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_1(), "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_1");
			builder.put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_2_1(), "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_2_1");
			builder.put(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_0(), "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_0");
			builder.put(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_1(), "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_1");
			builder.put(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_0(), "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_0");
			builder.put(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_1(), "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_1");
			builder.put(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceAssignment_1(), "rule__JvmUpperBound__TypeReferenceAssignment_1");
			builder.put(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceAssignment_1(), "rule__JvmUpperBoundAnded__TypeReferenceAssignment_1");
			builder.put(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceAssignment_1(), "rule__JvmLowerBound__TypeReferenceAssignment_1");
			builder.put(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceAssignment_1(), "rule__JvmLowerBoundAnded__TypeReferenceAssignment_1");
			builder.put(grammarAccess.getJvmTypeParameterAccess().getNameAssignment_0(), "rule__JvmTypeParameter__NameAssignment_0");
			builder.put(grammarAccess.getJvmTypeParameterAccess().getConstraintsAssignment_1_0(), "rule__JvmTypeParameter__ConstraintsAssignment_1_0");
			builder.put(grammarAccess.getJvmTypeParameterAccess().getConstraintsAssignment_1_1(), "rule__JvmTypeParameter__ConstraintsAssignment_1_1");
			builder.put(grammarAccess.getXImportSectionAccess().getImportDeclarationsAssignment(), "rule__XImportSection__ImportDeclarationsAssignment");
			builder.put(grammarAccess.getXImportDeclarationAccess().getStaticAssignment_1_0_0(), "rule__XImportDeclaration__StaticAssignment_1_0_0");
			builder.put(grammarAccess.getXImportDeclarationAccess().getExtensionAssignment_1_0_1(), "rule__XImportDeclaration__ExtensionAssignment_1_0_1");
			builder.put(grammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_0_2(), "rule__XImportDeclaration__ImportedTypeAssignment_1_0_2");
			builder.put(grammarAccess.getXImportDeclarationAccess().getWildcardAssignment_1_0_3_0(), "rule__XImportDeclaration__WildcardAssignment_1_0_3_0");
			builder.put(grammarAccess.getXImportDeclarationAccess().getMemberNameAssignment_1_0_3_1(), "rule__XImportDeclaration__MemberNameAssignment_1_0_3_1");
			builder.put(grammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_1(), "rule__XImportDeclaration__ImportedTypeAssignment_1_1");
			builder.put(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceAssignment_1_2(), "rule__XImportDeclaration__ImportedNamespaceAssignment_1_2");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private EntityDslGrammarAccess grammarAccess;

	@Override
	protected InternalEntityDslParser createParser() {
		InternalEntityDslParser result = new InternalEntityDslParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public EntityDslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(EntityDslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}