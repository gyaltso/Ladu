/*******************************************************************************
 * Copyright (C) 2020, 2021 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package com.gyaltso.lcp.ladu.entitydsl.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;

@Singleton
public class EntityDslGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {
	
	public class DefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "com.gyaltso.lcp.ladu.entitydsl.EntityDsl.Definition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPackageKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameQualifiedNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Assignment cImportSectionAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cImportSectionXImportSectionParserRuleCall_2_0 = (RuleCall)cImportSectionAssignment_2.eContents().get(0);
		private final Assignment cModelsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cModelsModelParserRuleCall_3_0 = (RuleCall)cModelsAssignment_3.eContents().get(0);
		
		//Definition:
		//	'package' name=QualifiedName
		//	importSection=XImportSection?
		//	models+=Model*;
		@Override public ParserRule getRule() { return rule; }
		
		//'package' name=QualifiedName importSection=XImportSection? models+=Model*
		public Group getGroup() { return cGroup; }
		
		//'package'
		public Keyword getPackageKeyword_0() { return cPackageKeyword_0; }
		
		//name=QualifiedName
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//QualifiedName
		public RuleCall getNameQualifiedNameParserRuleCall_1_0() { return cNameQualifiedNameParserRuleCall_1_0; }
		
		//importSection=XImportSection?
		public Assignment getImportSectionAssignment_2() { return cImportSectionAssignment_2; }
		
		//XImportSection
		public RuleCall getImportSectionXImportSectionParserRuleCall_2_0() { return cImportSectionXImportSectionParserRuleCall_2_0; }
		
		//models+=Model*
		public Assignment getModelsAssignment_3() { return cModelsAssignment_3; }
		
		//Model
		public RuleCall getModelsModelParserRuleCall_3_0() { return cModelsModelParserRuleCall_3_0; }
	}
	public class ModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "com.gyaltso.lcp.ladu.entitydsl.EntityDsl.Model");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cEntityParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cEEnumParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//Model:
		//	Entity | EEnum;
		@Override public ParserRule getRule() { return rule; }
		
		//Entity | EEnum
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Entity
		public RuleCall getEntityParserRuleCall_0() { return cEntityParserRuleCall_0; }
		
		//EEnum
		public RuleCall getEEnumParserRuleCall_1() { return cEEnumParserRuleCall_1; }
	}
	public class EntityElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "com.gyaltso.lcp.ladu.entitydsl.EntityDsl.Entity");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cEntityAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cAnnotationsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cAnnotationsXAnnotationParserRuleCall_1_0 = (RuleCall)cAnnotationsAssignment_1.eContents().get(0);
		private final Assignment cMasterAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Keyword cMasterMasterKeyword_2_0 = (Keyword)cMasterAssignment_2.eContents().get(0);
		private final Keyword cEntityKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cNameAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cNameValidIDParserRuleCall_4_0 = (RuleCall)cNameAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cExtendsKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cSuperTypeAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cSuperTypeJvmParameterizedTypeReferenceParserRuleCall_5_1_0 = (RuleCall)cSuperTypeAssignment_5_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cPropertiesAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cPropertiesPropertyParserRuleCall_7_0 = (RuleCall)cPropertiesAssignment_7.eContents().get(0);
		private final Assignment cLayoutAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final RuleCall cLayoutLayoutParserRuleCall_8_0 = (RuleCall)cLayoutAssignment_8.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_9 = (Keyword)cGroup.eContents().get(9);
		
		//Entity AnnotatedElement:
		//	{Entity} annotations+=XAnnotation*
		//	master?='master'? 'entity' name=ValidID ('extends' superType=JvmParameterizedTypeReference)? '{'
		//	properties+=Property*
		//	layout=Layout?
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//{Entity} annotations+=XAnnotation* master?='master'? 'entity' name=ValidID ('extends'
		//superType=JvmParameterizedTypeReference)? '{' properties+=Property* layout=Layout? '}'
		public Group getGroup() { return cGroup; }
		
		//{Entity}
		public Action getEntityAction_0() { return cEntityAction_0; }
		
		//annotations+=XAnnotation*
		public Assignment getAnnotationsAssignment_1() { return cAnnotationsAssignment_1; }
		
		//XAnnotation
		public RuleCall getAnnotationsXAnnotationParserRuleCall_1_0() { return cAnnotationsXAnnotationParserRuleCall_1_0; }
		
		//master?='master'?
		public Assignment getMasterAssignment_2() { return cMasterAssignment_2; }
		
		//'master'
		public Keyword getMasterMasterKeyword_2_0() { return cMasterMasterKeyword_2_0; }
		
		//'entity'
		public Keyword getEntityKeyword_3() { return cEntityKeyword_3; }
		
		//name=ValidID
		public Assignment getNameAssignment_4() { return cNameAssignment_4; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_4_0() { return cNameValidIDParserRuleCall_4_0; }
		
		//('extends' superType=JvmParameterizedTypeReference)?
		public Group getGroup_5() { return cGroup_5; }
		
		//'extends'
		public Keyword getExtendsKeyword_5_0() { return cExtendsKeyword_5_0; }
		
		//superType=JvmParameterizedTypeReference
		public Assignment getSuperTypeAssignment_5_1() { return cSuperTypeAssignment_5_1; }
		
		//JvmParameterizedTypeReference
		public RuleCall getSuperTypeJvmParameterizedTypeReferenceParserRuleCall_5_1_0() { return cSuperTypeJvmParameterizedTypeReferenceParserRuleCall_5_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_6() { return cLeftCurlyBracketKeyword_6; }
		
		//properties+=Property*
		public Assignment getPropertiesAssignment_7() { return cPropertiesAssignment_7; }
		
		//Property
		public RuleCall getPropertiesPropertyParserRuleCall_7_0() { return cPropertiesPropertyParserRuleCall_7_0; }
		
		//layout=Layout?
		public Assignment getLayoutAssignment_8() { return cLayoutAssignment_8; }
		
		//Layout
		public RuleCall getLayoutLayoutParserRuleCall_8_0() { return cLayoutLayoutParserRuleCall_8_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_9() { return cRightCurlyBracketKeyword_9; }
	}
	public class PropertyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "com.gyaltso.lcp.ladu.entitydsl.EntityDsl.Property");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cPropertyAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cAnnotationsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cAnnotationsXAnnotationParserRuleCall_1_0 = (RuleCall)cAnnotationsAssignment_1.eContents().get(0);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameValidIDParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Assignment cArrayAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final Keyword cArrayAsteriskKeyword_3_0 = (Keyword)cArrayAssignment_3.eContents().get(0);
		private final Assignment cTypeAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cTypeJvmParameterizedTypeReferenceParserRuleCall_4_0 = (RuleCall)cTypeAssignment_4.eContents().get(0);
		
		//Property AnnotatedElement:
		//	{Property} annotations+=XAnnotation*
		//	name=ValidID array?='*'? type=JvmParameterizedTypeReference;
		@Override public ParserRule getRule() { return rule; }
		
		//{Property} annotations+=XAnnotation* name=ValidID array?='*'? type=JvmParameterizedTypeReference
		public Group getGroup() { return cGroup; }
		
		//{Property}
		public Action getPropertyAction_0() { return cPropertyAction_0; }
		
		//annotations+=XAnnotation*
		public Assignment getAnnotationsAssignment_1() { return cAnnotationsAssignment_1; }
		
		//XAnnotation
		public RuleCall getAnnotationsXAnnotationParserRuleCall_1_0() { return cAnnotationsXAnnotationParserRuleCall_1_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_2_0() { return cNameValidIDParserRuleCall_2_0; }
		
		//array?='*'?
		public Assignment getArrayAssignment_3() { return cArrayAssignment_3; }
		
		//'*'
		public Keyword getArrayAsteriskKeyword_3_0() { return cArrayAsteriskKeyword_3_0; }
		
		//type=JvmParameterizedTypeReference
		public Assignment getTypeAssignment_4() { return cTypeAssignment_4; }
		
		//JvmParameterizedTypeReference
		public RuleCall getTypeJvmParameterizedTypeReferenceParserRuleCall_4_0() { return cTypeJvmParameterizedTypeReferenceParserRuleCall_4_0; }
	}
	public class EEnumElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "com.gyaltso.lcp.ladu.entitydsl.EntityDsl.EEnum");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cEnumKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameValidIDParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cLiteralsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cLiteralsLiteralParserRuleCall_3_0 = (RuleCall)cLiteralsAssignment_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//EEnum:
		//	'enum' name=ValidID '{'
		//	literals+=Literal*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'enum' name=ValidID '{' literals+=Literal* '}'
		public Group getGroup() { return cGroup; }
		
		//'enum'
		public Keyword getEnumKeyword_0() { return cEnumKeyword_0; }
		
		//name=ValidID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_1_0() { return cNameValidIDParserRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//literals+=Literal*
		public Assignment getLiteralsAssignment_3() { return cLiteralsAssignment_3; }
		
		//Literal
		public RuleCall getLiteralsLiteralParserRuleCall_3_0() { return cLiteralsLiteralParserRuleCall_3_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}
	public class LiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "com.gyaltso.lcp.ladu.entitydsl.EntityDsl.Literal");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cNameValidIDParserRuleCall_0 = (RuleCall)cNameAssignment.eContents().get(0);
		
		//Literal:
		//	name=ValidID;
		@Override public ParserRule getRule() { return rule; }
		
		//name=ValidID
		public Assignment getNameAssignment() { return cNameAssignment; }
		
		//ValidID
		public RuleCall getNameValidIDParserRuleCall_0() { return cNameValidIDParserRuleCall_0; }
	}
	public class LayoutElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "com.gyaltso.lcp.ladu.entitydsl.EntityDsl.Layout");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cLayoutAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLayoutKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cInlinesAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cInlinesInlineParserRuleCall_3_0 = (RuleCall)cInlinesAssignment_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//Layout:
		//	{Layout}
		//	'layout' '{'
		//	inlines+=Inline*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//{Layout} 'layout' '{' inlines+=Inline* '}'
		public Group getGroup() { return cGroup; }
		
		//{Layout}
		public Action getLayoutAction_0() { return cLayoutAction_0; }
		
		//'layout'
		public Keyword getLayoutKeyword_1() { return cLayoutKeyword_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//inlines+=Inline*
		public Assignment getInlinesAssignment_3() { return cInlinesAssignment_3; }
		
		//Inline
		public RuleCall getInlinesInlineParserRuleCall_3_0() { return cInlinesInlineParserRuleCall_3_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}
	public class InlineElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "com.gyaltso.lcp.ladu.entitydsl.EntityDsl.Inline");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cInlineKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cPropertiesAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cPropertiesPropertyCrossReference_1_0 = (CrossReference)cPropertiesAssignment_1.eContents().get(0);
		private final RuleCall cPropertiesPropertyIDTerminalRuleCall_1_0_1 = (RuleCall)cPropertiesPropertyCrossReference_1_0.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cCommaKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cPropertiesAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final CrossReference cPropertiesPropertyCrossReference_2_1_0 = (CrossReference)cPropertiesAssignment_2_1.eContents().get(0);
		private final RuleCall cPropertiesPropertyIDTerminalRuleCall_2_1_0_1 = (RuleCall)cPropertiesPropertyCrossReference_2_1_0.eContents().get(1);
		
		//Inline:
		//	'inline' properties+=[Property] (',' properties+=[Property])*;
		@Override public ParserRule getRule() { return rule; }
		
		//'inline' properties+=[Property] (',' properties+=[Property])*
		public Group getGroup() { return cGroup; }
		
		//'inline'
		public Keyword getInlineKeyword_0() { return cInlineKeyword_0; }
		
		//properties+=[Property]
		public Assignment getPropertiesAssignment_1() { return cPropertiesAssignment_1; }
		
		//[Property]
		public CrossReference getPropertiesPropertyCrossReference_1_0() { return cPropertiesPropertyCrossReference_1_0; }
		
		//ID
		public RuleCall getPropertiesPropertyIDTerminalRuleCall_1_0_1() { return cPropertiesPropertyIDTerminalRuleCall_1_0_1; }
		
		//(',' properties+=[Property])*
		public Group getGroup_2() { return cGroup_2; }
		
		//','
		public Keyword getCommaKeyword_2_0() { return cCommaKeyword_2_0; }
		
		//properties+=[Property]
		public Assignment getPropertiesAssignment_2_1() { return cPropertiesAssignment_2_1; }
		
		//[Property]
		public CrossReference getPropertiesPropertyCrossReference_2_1_0() { return cPropertiesPropertyCrossReference_2_1_0; }
		
		//ID
		public RuleCall getPropertiesPropertyIDTerminalRuleCall_2_1_0_1() { return cPropertiesPropertyIDTerminalRuleCall_2_1_0_1; }
	}
	
	
	private final DefinitionElements pDefinition;
	private final ModelElements pModel;
	private final EntityElements pEntity;
	private final PropertyElements pProperty;
	private final EEnumElements pEEnum;
	private final LiteralElements pLiteral;
	private final LayoutElements pLayout;
	private final InlineElements pInline;
	
	private final Grammar grammar;
	
	private final XbaseWithAnnotationsGrammarAccess gaXbaseWithAnnotations;
	
	private final XbaseGrammarAccess gaXbase;
	
	private final XtypeGrammarAccess gaXtype;

	@Inject
	public EntityDslGrammarAccess(GrammarProvider grammarProvider,
			XbaseWithAnnotationsGrammarAccess gaXbaseWithAnnotations,
			XbaseGrammarAccess gaXbase,
			XtypeGrammarAccess gaXtype) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaXbaseWithAnnotations = gaXbaseWithAnnotations;
		this.gaXbase = gaXbase;
		this.gaXtype = gaXtype;
		this.pDefinition = new DefinitionElements();
		this.pModel = new ModelElements();
		this.pEntity = new EntityElements();
		this.pProperty = new PropertyElements();
		this.pEEnum = new EEnumElements();
		this.pLiteral = new LiteralElements();
		this.pLayout = new LayoutElements();
		this.pInline = new InlineElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("com.gyaltso.lcp.ladu.entitydsl.EntityDsl".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public XbaseWithAnnotationsGrammarAccess getXbaseWithAnnotationsGrammarAccess() {
		return gaXbaseWithAnnotations;
	}
	
	public XbaseGrammarAccess getXbaseGrammarAccess() {
		return gaXbase;
	}
	
	public XtypeGrammarAccess getXtypeGrammarAccess() {
		return gaXtype;
	}

	
	//Definition:
	//	'package' name=QualifiedName
	//	importSection=XImportSection?
	//	models+=Model*;
	public DefinitionElements getDefinitionAccess() {
		return pDefinition;
	}
	
	public ParserRule getDefinitionRule() {
		return getDefinitionAccess().getRule();
	}
	
	//Model:
	//	Entity | EEnum;
	public ModelElements getModelAccess() {
		return pModel;
	}
	
	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}
	
	//Entity AnnotatedElement:
	//	{Entity} annotations+=XAnnotation*
	//	master?='master'? 'entity' name=ValidID ('extends' superType=JvmParameterizedTypeReference)? '{'
	//	properties+=Property*
	//	layout=Layout?
	//	'}';
	public EntityElements getEntityAccess() {
		return pEntity;
	}
	
	public ParserRule getEntityRule() {
		return getEntityAccess().getRule();
	}
	
	//Property AnnotatedElement:
	//	{Property} annotations+=XAnnotation*
	//	name=ValidID array?='*'? type=JvmParameterizedTypeReference;
	public PropertyElements getPropertyAccess() {
		return pProperty;
	}
	
	public ParserRule getPropertyRule() {
		return getPropertyAccess().getRule();
	}
	
	//EEnum:
	//	'enum' name=ValidID '{'
	//	literals+=Literal*
	//	'}';
	public EEnumElements getEEnumAccess() {
		return pEEnum;
	}
	
	public ParserRule getEEnumRule() {
		return getEEnumAccess().getRule();
	}
	
	//Literal:
	//	name=ValidID;
	public LiteralElements getLiteralAccess() {
		return pLiteral;
	}
	
	public ParserRule getLiteralRule() {
		return getLiteralAccess().getRule();
	}
	
	//Layout:
	//	{Layout}
	//	'layout' '{'
	//	inlines+=Inline*
	//	'}';
	public LayoutElements getLayoutAccess() {
		return pLayout;
	}
	
	public ParserRule getLayoutRule() {
		return getLayoutAccess().getRule();
	}
	
	//Inline:
	//	'inline' properties+=[Property] (',' properties+=[Property])*;
	public InlineElements getInlineAccess() {
		return pInline;
	}
	
	public ParserRule getInlineRule() {
		return getInlineAccess().getRule();
	}
	
	//XAnnotation:
	//	{XAnnotation}
	//	'@' annotationType=[types::JvmAnnotationType|QualifiedName] (=> '(' (elementValuePairs+=XAnnotationElementValuePair
	//	(',' elementValuePairs+=XAnnotationElementValuePair)*
	//	| value=XAnnotationElementValueOrCommaList)?
	//	')')?;
	public XbaseWithAnnotationsGrammarAccess.XAnnotationElements getXAnnotationAccess() {
		return gaXbaseWithAnnotations.getXAnnotationAccess();
	}
	
	public ParserRule getXAnnotationRule() {
		return getXAnnotationAccess().getRule();
	}
	
	//XAnnotationElementValuePair:
	//	=> (element=[types::JvmOperation|ValidID] '=') value=XAnnotationElementValue;
	public XbaseWithAnnotationsGrammarAccess.XAnnotationElementValuePairElements getXAnnotationElementValuePairAccess() {
		return gaXbaseWithAnnotations.getXAnnotationElementValuePairAccess();
	}
	
	public ParserRule getXAnnotationElementValuePairRule() {
		return getXAnnotationElementValuePairAccess().getRule();
	}
	
	//XAnnotationElementValueOrCommaList xbase::XExpression:
	//	=> ({xbase::XListLiteral} '#' '[') (elements+=XAnnotationOrExpression (',' elements+=XAnnotationOrExpression)*)? ']'
	//	| XAnnotationOrExpression ({xbase::XListLiteral.elements+=current} (',' elements+=XAnnotationOrExpression)+)?;
	public XbaseWithAnnotationsGrammarAccess.XAnnotationElementValueOrCommaListElements getXAnnotationElementValueOrCommaListAccess() {
		return gaXbaseWithAnnotations.getXAnnotationElementValueOrCommaListAccess();
	}
	
	public ParserRule getXAnnotationElementValueOrCommaListRule() {
		return getXAnnotationElementValueOrCommaListAccess().getRule();
	}
	
	//XAnnotationElementValue xbase::XExpression:
	//	=> ({xbase::XListLiteral} '#' '[') (elements+=XAnnotationOrExpression (',' elements+=XAnnotationOrExpression)*)? ']'
	//	| XAnnotationOrExpression;
	public XbaseWithAnnotationsGrammarAccess.XAnnotationElementValueElements getXAnnotationElementValueAccess() {
		return gaXbaseWithAnnotations.getXAnnotationElementValueAccess();
	}
	
	public ParserRule getXAnnotationElementValueRule() {
		return getXAnnotationElementValueAccess().getRule();
	}
	
	//XAnnotationOrExpression xbase::XExpression:
	//	XAnnotation | XExpression;
	public XbaseWithAnnotationsGrammarAccess.XAnnotationOrExpressionElements getXAnnotationOrExpressionAccess() {
		return gaXbaseWithAnnotations.getXAnnotationOrExpressionAccess();
	}
	
	public ParserRule getXAnnotationOrExpressionRule() {
		return getXAnnotationOrExpressionAccess().getRule();
	}
	
	//XExpression:
	//	XAssignment;
	public XbaseGrammarAccess.XExpressionElements getXExpressionAccess() {
		return gaXbase.getXExpressionAccess();
	}
	
	public ParserRule getXExpressionRule() {
		return getXExpressionAccess().getRule();
	}
	
	//XAssignment XExpression:
	//	{XAssignment} feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign value=XAssignment | XOrExpression
	//	(=> ({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMultiAssign])
	//	rightOperand=XAssignment)?;
	public XbaseGrammarAccess.XAssignmentElements getXAssignmentAccess() {
		return gaXbase.getXAssignmentAccess();
	}
	
	public ParserRule getXAssignmentRule() {
		return getXAssignmentAccess().getRule();
	}
	
	//OpSingleAssign:
	//	'=';
	public XbaseGrammarAccess.OpSingleAssignElements getOpSingleAssignAccess() {
		return gaXbase.getOpSingleAssignAccess();
	}
	
	public ParserRule getOpSingleAssignRule() {
		return getOpSingleAssignAccess().getRule();
	}
	
	//OpMultiAssign:
	//	'+=' | '-=' | '*=' | '/=' | '%=' |
	//	'<' '<' '=' |
	//	'>' '>'? '>=';
	public XbaseGrammarAccess.OpMultiAssignElements getOpMultiAssignAccess() {
		return gaXbase.getOpMultiAssignAccess();
	}
	
	public ParserRule getOpMultiAssignRule() {
		return getOpMultiAssignAccess().getRule();
	}
	
	//XOrExpression XExpression:
	//	XAndExpression (=> ({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpOr])
	//	rightOperand=XAndExpression)*;
	public XbaseGrammarAccess.XOrExpressionElements getXOrExpressionAccess() {
		return gaXbase.getXOrExpressionAccess();
	}
	
	public ParserRule getXOrExpressionRule() {
		return getXOrExpressionAccess().getRule();
	}
	
	//OpOr:
	//	'||';
	public XbaseGrammarAccess.OpOrElements getOpOrAccess() {
		return gaXbase.getOpOrAccess();
	}
	
	public ParserRule getOpOrRule() {
		return getOpOrAccess().getRule();
	}
	
	//XAndExpression XExpression:
	//	XEqualityExpression (=> ({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpAnd])
	//	rightOperand=XEqualityExpression)*;
	public XbaseGrammarAccess.XAndExpressionElements getXAndExpressionAccess() {
		return gaXbase.getXAndExpressionAccess();
	}
	
	public ParserRule getXAndExpressionRule() {
		return getXAndExpressionAccess().getRule();
	}
	
	//OpAnd:
	//	'&&';
	public XbaseGrammarAccess.OpAndElements getOpAndAccess() {
		return gaXbase.getOpAndAccess();
	}
	
	public ParserRule getOpAndRule() {
		return getOpAndAccess().getRule();
	}
	
	//XEqualityExpression XExpression:
	//	XRelationalExpression (=> ({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpEquality])
	//	rightOperand=XRelationalExpression)*;
	public XbaseGrammarAccess.XEqualityExpressionElements getXEqualityExpressionAccess() {
		return gaXbase.getXEqualityExpressionAccess();
	}
	
	public ParserRule getXEqualityExpressionRule() {
		return getXEqualityExpressionAccess().getRule();
	}
	
	//OpEquality:
	//	'==' | '!=' | '===' | '!==';
	public XbaseGrammarAccess.OpEqualityElements getOpEqualityAccess() {
		return gaXbase.getOpEqualityAccess();
	}
	
	public ParserRule getOpEqualityRule() {
		return getOpEqualityAccess().getRule();
	}
	
	//XRelationalExpression XExpression:
	//	XOtherOperatorExpression (=> ({XInstanceOfExpression.expression=current} 'instanceof') type=JvmTypeReference |
	//	=> ({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpCompare])
	//	rightOperand=XOtherOperatorExpression)*;
	public XbaseGrammarAccess.XRelationalExpressionElements getXRelationalExpressionAccess() {
		return gaXbase.getXRelationalExpressionAccess();
	}
	
	public ParserRule getXRelationalExpressionRule() {
		return getXRelationalExpressionAccess().getRule();
	}
	
	//OpCompare:
	//	'>=' | '<' '=' | '>' | '<';
	public XbaseGrammarAccess.OpCompareElements getOpCompareAccess() {
		return gaXbase.getOpCompareAccess();
	}
	
	public ParserRule getOpCompareRule() {
		return getOpCompareAccess().getRule();
	}
	
	//XOtherOperatorExpression XExpression:
	//	XAdditiveExpression (=> ({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpOther])
	//	rightOperand=XAdditiveExpression)*;
	public XbaseGrammarAccess.XOtherOperatorExpressionElements getXOtherOperatorExpressionAccess() {
		return gaXbase.getXOtherOperatorExpressionAccess();
	}
	
	public ParserRule getXOtherOperatorExpressionRule() {
		return getXOtherOperatorExpressionAccess().getRule();
	}
	
	//OpOther:
	//	'->'
	//	| '..<'
	//	| '>' '..'
	//	| '..'
	//	| '=>'
	//	| '>' (=> ('>' '>') | '>') | '<' (=> ('<' '<') | '<' | '=>') | '<>'
	//	| '?:';
	public XbaseGrammarAccess.OpOtherElements getOpOtherAccess() {
		return gaXbase.getOpOtherAccess();
	}
	
	public ParserRule getOpOtherRule() {
		return getOpOtherAccess().getRule();
	}
	
	//XAdditiveExpression XExpression:
	//	XMultiplicativeExpression (=> ({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpAdd])
	//	rightOperand=XMultiplicativeExpression)*;
	public XbaseGrammarAccess.XAdditiveExpressionElements getXAdditiveExpressionAccess() {
		return gaXbase.getXAdditiveExpressionAccess();
	}
	
	public ParserRule getXAdditiveExpressionRule() {
		return getXAdditiveExpressionAccess().getRule();
	}
	
	//OpAdd:
	//	'+' | '-';
	public XbaseGrammarAccess.OpAddElements getOpAddAccess() {
		return gaXbase.getOpAddAccess();
	}
	
	public ParserRule getOpAddRule() {
		return getOpAddAccess().getRule();
	}
	
	//XMultiplicativeExpression XExpression:
	//	XUnaryOperation (=> ({XBinaryOperation.leftOperand=current} feature=[types::JvmIdentifiableElement|OpMulti])
	//	rightOperand=XUnaryOperation)*;
	public XbaseGrammarAccess.XMultiplicativeExpressionElements getXMultiplicativeExpressionAccess() {
		return gaXbase.getXMultiplicativeExpressionAccess();
	}
	
	public ParserRule getXMultiplicativeExpressionRule() {
		return getXMultiplicativeExpressionAccess().getRule();
	}
	
	//OpMulti:
	//	'*' | '**' | '/' | '%';
	public XbaseGrammarAccess.OpMultiElements getOpMultiAccess() {
		return gaXbase.getOpMultiAccess();
	}
	
	public ParserRule getOpMultiRule() {
		return getOpMultiAccess().getRule();
	}
	
	//XUnaryOperation XExpression:
	//	{XUnaryOperation} feature=[types::JvmIdentifiableElement|OpUnary] operand=XUnaryOperation
	//	| XCastedExpression;
	public XbaseGrammarAccess.XUnaryOperationElements getXUnaryOperationAccess() {
		return gaXbase.getXUnaryOperationAccess();
	}
	
	public ParserRule getXUnaryOperationRule() {
		return getXUnaryOperationAccess().getRule();
	}
	
	//OpUnary:
	//	"!" | "-" | "+";
	public XbaseGrammarAccess.OpUnaryElements getOpUnaryAccess() {
		return gaXbase.getOpUnaryAccess();
	}
	
	public ParserRule getOpUnaryRule() {
		return getOpUnaryAccess().getRule();
	}
	
	//XCastedExpression XExpression:
	//	XPostfixOperation (=> ({XCastedExpression.target=current} 'as') type=JvmTypeReference)*;
	public XbaseGrammarAccess.XCastedExpressionElements getXCastedExpressionAccess() {
		return gaXbase.getXCastedExpressionAccess();
	}
	
	public ParserRule getXCastedExpressionRule() {
		return getXCastedExpressionAccess().getRule();
	}
	
	//XPostfixOperation XExpression:
	//	XMemberFeatureCall => ({XPostfixOperation.operand=current} feature=[types::JvmIdentifiableElement|OpPostfix])?;
	public XbaseGrammarAccess.XPostfixOperationElements getXPostfixOperationAccess() {
		return gaXbase.getXPostfixOperationAccess();
	}
	
	public ParserRule getXPostfixOperationRule() {
		return getXPostfixOperationAccess().getRule();
	}
	
	//OpPostfix:
	//	"++" | "--";
	public XbaseGrammarAccess.OpPostfixElements getOpPostfixAccess() {
		return gaXbase.getOpPostfixAccess();
	}
	
	public ParserRule getOpPostfixRule() {
		return getOpPostfixAccess().getRule();
	}
	
	//XMemberFeatureCall XExpression:
	//	XPrimaryExpression (=> ({XAssignment.assignable=current} ('.' | explicitStatic?="::")
	//	feature=[types::JvmIdentifiableElement|FeatureCallID] OpSingleAssign) value=XAssignment
	//	| => ({XMemberFeatureCall.memberCallTarget=current} ("." | nullSafe?="?." | explicitStatic?="::")) ('<'
	//	typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
	//	feature=[types::JvmIdentifiableElement|IdOrSuper] (=> explicitOperationCall?='(' (memberCallArguments+=XShortClosure
	//	| memberCallArguments+=XExpression (',' memberCallArguments+=XExpression)*)?
	//	')')?
	//	memberCallArguments+=XClosure?)*;
	public XbaseGrammarAccess.XMemberFeatureCallElements getXMemberFeatureCallAccess() {
		return gaXbase.getXMemberFeatureCallAccess();
	}
	
	public ParserRule getXMemberFeatureCallRule() {
		return getXMemberFeatureCallAccess().getRule();
	}
	
	//XPrimaryExpression XExpression:
	//	XConstructorCall | XBlockExpression | XSwitchExpression | XSynchronizedExpression | XFeatureCall | XLiteral |
	//	XIfExpression | XForLoopExpression | XBasicForLoopExpression | XWhileExpression | XDoWhileExpression |
	//	XThrowExpression | XReturnExpression | XTryCatchFinallyExpression | XParenthesizedExpression;
	public XbaseGrammarAccess.XPrimaryExpressionElements getXPrimaryExpressionAccess() {
		return gaXbase.getXPrimaryExpressionAccess();
	}
	
	public ParserRule getXPrimaryExpressionRule() {
		return getXPrimaryExpressionAccess().getRule();
	}
	
	//XLiteral XExpression:
	//	XCollectionLiteral | XClosure | XBooleanLiteral | XNumberLiteral | XNullLiteral | XStringLiteral | XTypeLiteral;
	public XbaseGrammarAccess.XLiteralElements getXLiteralAccess() {
		return gaXbase.getXLiteralAccess();
	}
	
	public ParserRule getXLiteralRule() {
		return getXLiteralAccess().getRule();
	}
	
	//XCollectionLiteral:
	//	XSetLiteral | XListLiteral;
	public XbaseGrammarAccess.XCollectionLiteralElements getXCollectionLiteralAccess() {
		return gaXbase.getXCollectionLiteralAccess();
	}
	
	public ParserRule getXCollectionLiteralRule() {
		return getXCollectionLiteralAccess().getRule();
	}
	
	//XSetLiteral:
	//	{XSetLiteral} '#' '{' (elements+=XExpression (',' elements+=XExpression)*)? '}';
	public XbaseGrammarAccess.XSetLiteralElements getXSetLiteralAccess() {
		return gaXbase.getXSetLiteralAccess();
	}
	
	public ParserRule getXSetLiteralRule() {
		return getXSetLiteralAccess().getRule();
	}
	
	//XListLiteral:
	//	{XListLiteral} '#' '[' (elements+=XExpression (',' elements+=XExpression)*)? ']';
	public XbaseGrammarAccess.XListLiteralElements getXListLiteralAccess() {
		return gaXbase.getXListLiteralAccess();
	}
	
	public ParserRule getXListLiteralRule() {
		return getXListLiteralAccess().getRule();
	}
	
	//XClosure XExpression:
	//	=> ({XClosure}
	//	'[')
	//	=> ((declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)?
	//	explicitSyntax?='|')?
	//	expression=XExpressionInClosure
	//	']';
	public XbaseGrammarAccess.XClosureElements getXClosureAccess() {
		return gaXbase.getXClosureAccess();
	}
	
	public ParserRule getXClosureRule() {
		return getXClosureAccess().getRule();
	}
	
	//XExpressionInClosure XExpression:
	//	{XBlockExpression} (expressions+=XExpressionOrVarDeclaration ';'?)*;
	public XbaseGrammarAccess.XExpressionInClosureElements getXExpressionInClosureAccess() {
		return gaXbase.getXExpressionInClosureAccess();
	}
	
	public ParserRule getXExpressionInClosureRule() {
		return getXExpressionInClosureAccess().getRule();
	}
	
	//XShortClosure XExpression:
	//	=> ({XClosure} (declaredFormalParameters+=JvmFormalParameter (',' declaredFormalParameters+=JvmFormalParameter)*)?
	//	explicitSyntax?='|') expression=XExpression;
	public XbaseGrammarAccess.XShortClosureElements getXShortClosureAccess() {
		return gaXbase.getXShortClosureAccess();
	}
	
	public ParserRule getXShortClosureRule() {
		return getXShortClosureAccess().getRule();
	}
	
	//XParenthesizedExpression XExpression:
	//	'(' XExpression ')';
	public XbaseGrammarAccess.XParenthesizedExpressionElements getXParenthesizedExpressionAccess() {
		return gaXbase.getXParenthesizedExpressionAccess();
	}
	
	public ParserRule getXParenthesizedExpressionRule() {
		return getXParenthesizedExpressionAccess().getRule();
	}
	
	//XIfExpression XExpression:
	//	{XIfExpression}
	//	'if' '(' if=XExpression ')'
	//	then=XExpression (=> 'else' else=XExpression)?;
	public XbaseGrammarAccess.XIfExpressionElements getXIfExpressionAccess() {
		return gaXbase.getXIfExpressionAccess();
	}
	
	public ParserRule getXIfExpressionRule() {
		return getXIfExpressionAccess().getRule();
	}
	
	//XSwitchExpression XExpression:
	//	{XSwitchExpression}
	//	'switch' (=> ('(' declaredParam=JvmFormalParameter ':') switch=XExpression ')'
	//	| => (declaredParam=JvmFormalParameter ':')? switch=XExpression) '{'
	//	cases+=XCasePart* ('default' ':' default=XExpression)?
	//	'}';
	public XbaseGrammarAccess.XSwitchExpressionElements getXSwitchExpressionAccess() {
		return gaXbase.getXSwitchExpressionAccess();
	}
	
	public ParserRule getXSwitchExpressionRule() {
		return getXSwitchExpressionAccess().getRule();
	}
	
	//XCasePart:
	//	{XCasePart} typeGuard=JvmTypeReference? ('case' case=XExpression)? (':' then=XExpression | fallThrough?=',');
	public XbaseGrammarAccess.XCasePartElements getXCasePartAccess() {
		return gaXbase.getXCasePartAccess();
	}
	
	public ParserRule getXCasePartRule() {
		return getXCasePartAccess().getRule();
	}
	
	//XForLoopExpression XExpression:
	//	=> ({XForLoopExpression}
	//	'for' '(' declaredParam=JvmFormalParameter ':') forExpression=XExpression ')'
	//	eachExpression=XExpression;
	public XbaseGrammarAccess.XForLoopExpressionElements getXForLoopExpressionAccess() {
		return gaXbase.getXForLoopExpressionAccess();
	}
	
	public ParserRule getXForLoopExpressionRule() {
		return getXForLoopExpressionAccess().getRule();
	}
	
	//XBasicForLoopExpression XExpression:
	//	{XBasicForLoopExpression}
	//	'for' '(' (initExpressions+=XExpressionOrVarDeclaration (',' initExpressions+=XExpressionOrVarDeclaration)*)? ';'
	//	expression=XExpression? ';' (updateExpressions+=XExpression (',' updateExpressions+=XExpression)*)? ')'
	//	eachExpression=XExpression;
	public XbaseGrammarAccess.XBasicForLoopExpressionElements getXBasicForLoopExpressionAccess() {
		return gaXbase.getXBasicForLoopExpressionAccess();
	}
	
	public ParserRule getXBasicForLoopExpressionRule() {
		return getXBasicForLoopExpressionAccess().getRule();
	}
	
	//XWhileExpression XExpression:
	//	{XWhileExpression}
	//	'while' '(' predicate=XExpression ')'
	//	body=XExpression;
	public XbaseGrammarAccess.XWhileExpressionElements getXWhileExpressionAccess() {
		return gaXbase.getXWhileExpressionAccess();
	}
	
	public ParserRule getXWhileExpressionRule() {
		return getXWhileExpressionAccess().getRule();
	}
	
	//XDoWhileExpression XExpression:
	//	{XDoWhileExpression}
	//	'do'
	//	body=XExpression
	//	'while' '(' predicate=XExpression ')';
	public XbaseGrammarAccess.XDoWhileExpressionElements getXDoWhileExpressionAccess() {
		return gaXbase.getXDoWhileExpressionAccess();
	}
	
	public ParserRule getXDoWhileExpressionRule() {
		return getXDoWhileExpressionAccess().getRule();
	}
	
	//XBlockExpression XExpression:
	//	{XBlockExpression}
	//	'{' (expressions+=XExpressionOrVarDeclaration ';'?)*
	//	'}';
	public XbaseGrammarAccess.XBlockExpressionElements getXBlockExpressionAccess() {
		return gaXbase.getXBlockExpressionAccess();
	}
	
	public ParserRule getXBlockExpressionRule() {
		return getXBlockExpressionAccess().getRule();
	}
	
	//XExpressionOrVarDeclaration XExpression:
	//	XVariableDeclaration | XExpression;
	public XbaseGrammarAccess.XExpressionOrVarDeclarationElements getXExpressionOrVarDeclarationAccess() {
		return gaXbase.getXExpressionOrVarDeclarationAccess();
	}
	
	public ParserRule getXExpressionOrVarDeclarationRule() {
		return getXExpressionOrVarDeclarationAccess().getRule();
	}
	
	//XVariableDeclaration XExpression:
	//	{XVariableDeclaration} (writeable?='var' | 'val') (=> (type=JvmTypeReference name=ValidID) | name=ValidID) ('='
	//	right=XExpression)?;
	public XbaseGrammarAccess.XVariableDeclarationElements getXVariableDeclarationAccess() {
		return gaXbase.getXVariableDeclarationAccess();
	}
	
	public ParserRule getXVariableDeclarationRule() {
		return getXVariableDeclarationAccess().getRule();
	}
	
	//JvmFormalParameter types::JvmFormalParameter:
	//	parameterType=JvmTypeReference? name=ValidID;
	public XbaseGrammarAccess.JvmFormalParameterElements getJvmFormalParameterAccess() {
		return gaXbase.getJvmFormalParameterAccess();
	}
	
	public ParserRule getJvmFormalParameterRule() {
		return getJvmFormalParameterAccess().getRule();
	}
	
	//FullJvmFormalParameter types::JvmFormalParameter:
	//	parameterType=JvmTypeReference name=ValidID;
	public XbaseGrammarAccess.FullJvmFormalParameterElements getFullJvmFormalParameterAccess() {
		return gaXbase.getFullJvmFormalParameterAccess();
	}
	
	public ParserRule getFullJvmFormalParameterRule() {
		return getFullJvmFormalParameterAccess().getRule();
	}
	
	//XFeatureCall XExpression:
	//	{XFeatureCall} ('<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>')?
	//	feature=[types::JvmIdentifiableElement|IdOrSuper] (=> explicitOperationCall?='(' (featureCallArguments+=XShortClosure
	//	| featureCallArguments+=XExpression (',' featureCallArguments+=XExpression)*)?
	//	')')?
	//	featureCallArguments+=XClosure?;
	public XbaseGrammarAccess.XFeatureCallElements getXFeatureCallAccess() {
		return gaXbase.getXFeatureCallAccess();
	}
	
	public ParserRule getXFeatureCallRule() {
		return getXFeatureCallAccess().getRule();
	}
	
	//FeatureCallID:
	//	ValidID | 'extends' | 'static' | 'import' | 'extension';
	public XbaseGrammarAccess.FeatureCallIDElements getFeatureCallIDAccess() {
		return gaXbase.getFeatureCallIDAccess();
	}
	
	public ParserRule getFeatureCallIDRule() {
		return getFeatureCallIDAccess().getRule();
	}
	
	//IdOrSuper:
	//	FeatureCallID | 'super';
	public XbaseGrammarAccess.IdOrSuperElements getIdOrSuperAccess() {
		return gaXbase.getIdOrSuperAccess();
	}
	
	public ParserRule getIdOrSuperRule() {
		return getIdOrSuperAccess().getRule();
	}
	
	//XConstructorCall XExpression:
	//	{XConstructorCall}
	//	'new' constructor=[types::JvmConstructor|QualifiedName] (=> '<' typeArguments+=JvmArgumentTypeReference (','
	//	typeArguments+=JvmArgumentTypeReference)* '>')? (=> explicitConstructorCall?='(' (arguments+=XShortClosure
	//	| arguments+=XExpression (',' arguments+=XExpression)*)?
	//	')')?
	//	arguments+=XClosure?;
	public XbaseGrammarAccess.XConstructorCallElements getXConstructorCallAccess() {
		return gaXbase.getXConstructorCallAccess();
	}
	
	public ParserRule getXConstructorCallRule() {
		return getXConstructorCallAccess().getRule();
	}
	
	//XBooleanLiteral XExpression:
	//	{XBooleanLiteral} ('false' | isTrue?='true');
	public XbaseGrammarAccess.XBooleanLiteralElements getXBooleanLiteralAccess() {
		return gaXbase.getXBooleanLiteralAccess();
	}
	
	public ParserRule getXBooleanLiteralRule() {
		return getXBooleanLiteralAccess().getRule();
	}
	
	//XNullLiteral XExpression:
	//	{XNullLiteral} 'null';
	public XbaseGrammarAccess.XNullLiteralElements getXNullLiteralAccess() {
		return gaXbase.getXNullLiteralAccess();
	}
	
	public ParserRule getXNullLiteralRule() {
		return getXNullLiteralAccess().getRule();
	}
	
	//XNumberLiteral XExpression:
	//	{XNumberLiteral} value=Number;
	public XbaseGrammarAccess.XNumberLiteralElements getXNumberLiteralAccess() {
		return gaXbase.getXNumberLiteralAccess();
	}
	
	public ParserRule getXNumberLiteralRule() {
		return getXNumberLiteralAccess().getRule();
	}
	
	//XStringLiteral XExpression:
	//	{XStringLiteral} value=STRING;
	public XbaseGrammarAccess.XStringLiteralElements getXStringLiteralAccess() {
		return gaXbase.getXStringLiteralAccess();
	}
	
	public ParserRule getXStringLiteralRule() {
		return getXStringLiteralAccess().getRule();
	}
	
	//XTypeLiteral XExpression:
	//	{XTypeLiteral} 'typeof' '(' type=[types::JvmType|QualifiedName] arrayDimensions+=ArrayBrackets* ')';
	public XbaseGrammarAccess.XTypeLiteralElements getXTypeLiteralAccess() {
		return gaXbase.getXTypeLiteralAccess();
	}
	
	public ParserRule getXTypeLiteralRule() {
		return getXTypeLiteralAccess().getRule();
	}
	
	//XThrowExpression XExpression:
	//	{XThrowExpression} 'throw' expression=XExpression;
	public XbaseGrammarAccess.XThrowExpressionElements getXThrowExpressionAccess() {
		return gaXbase.getXThrowExpressionAccess();
	}
	
	public ParserRule getXThrowExpressionRule() {
		return getXThrowExpressionAccess().getRule();
	}
	
	//XReturnExpression XExpression:
	//	{XReturnExpression} 'return' -> expression=XExpression?;
	public XbaseGrammarAccess.XReturnExpressionElements getXReturnExpressionAccess() {
		return gaXbase.getXReturnExpressionAccess();
	}
	
	public ParserRule getXReturnExpressionRule() {
		return getXReturnExpressionAccess().getRule();
	}
	
	//XTryCatchFinallyExpression XExpression:
	//	{XTryCatchFinallyExpression}
	//	'try'
	//	expression=XExpression (catchClauses+=XCatchClause+ (=> 'finally' finallyExpression=XExpression)?
	//	| 'finally' finallyExpression=XExpression);
	public XbaseGrammarAccess.XTryCatchFinallyExpressionElements getXTryCatchFinallyExpressionAccess() {
		return gaXbase.getXTryCatchFinallyExpressionAccess();
	}
	
	public ParserRule getXTryCatchFinallyExpressionRule() {
		return getXTryCatchFinallyExpressionAccess().getRule();
	}
	
	//XSynchronizedExpression XExpression:
	//	=> ({XSynchronizedExpression}
	//	'synchronized' '(') param=XExpression ')' expression=XExpression;
	public XbaseGrammarAccess.XSynchronizedExpressionElements getXSynchronizedExpressionAccess() {
		return gaXbase.getXSynchronizedExpressionAccess();
	}
	
	public ParserRule getXSynchronizedExpressionRule() {
		return getXSynchronizedExpressionAccess().getRule();
	}
	
	//XCatchClause:
	//	=> 'catch' '(' declaredParam=FullJvmFormalParameter ')' expression=XExpression;
	public XbaseGrammarAccess.XCatchClauseElements getXCatchClauseAccess() {
		return gaXbase.getXCatchClauseAccess();
	}
	
	public ParserRule getXCatchClauseRule() {
		return getXCatchClauseAccess().getRule();
	}
	
	//@Override
	//QualifiedName:
	//	ValidID (=> '.' ValidID)*;
	public XbaseGrammarAccess.QualifiedNameElements getQualifiedNameAccess() {
		return gaXbase.getQualifiedNameAccess();
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}
	
	//Number hidden():
	//	HEX | (INT | DECIMAL) ('.' (INT | DECIMAL))?;
	public XbaseGrammarAccess.NumberElements getNumberAccess() {
		return gaXbase.getNumberAccess();
	}
	
	public ParserRule getNumberRule() {
		return getNumberAccess().getRule();
	}
	
	///**
	// * Dummy rule, for "better" downwards compatibility, since GrammarAccess generates non-static inner classes,
	// * which makes downstream grammars break on classloading, when a rule is removed.
	// */
	//StaticQualifier:
	//	(ValidID '::')+;
	public XbaseGrammarAccess.StaticQualifierElements getStaticQualifierAccess() {
		return gaXbase.getStaticQualifierAccess();
	}
	
	public ParserRule getStaticQualifierRule() {
		return getStaticQualifierAccess().getRule();
	}
	
	//terminal HEX:
	//	('0x' | '0X') ('0'..'9' | 'a'..'f' | 'A'..'F' | '_')+ ('#' (('b' | 'B') ('i' | 'I') | ('l' | 'L')))?;
	public TerminalRule getHEXRule() {
		return gaXbase.getHEXRule();
	}
	
	//terminal INT returns ecore::EInt:
	//	'0'..'9' ('0'..'9' | '_')*;
	public TerminalRule getINTRule() {
		return gaXbase.getINTRule();
	}
	
	//terminal DECIMAL:
	//	INT (('e' | 'E') ('+' | '-')? INT)? (('b' | 'B') ('i' | 'I' | 'd' | 'D') | ('l' | 'L' | 'd' | 'D' | 'f' | 'F'))?;
	public TerminalRule getDECIMALRule() {
		return gaXbase.getDECIMALRule();
	}
	
	//JvmTypeReference:
	//	JvmParameterizedTypeReference => ({JvmGenericArrayTypeReference.componentType=current} ArrayBrackets)*
	//	| XFunctionTypeRef;
	public XtypeGrammarAccess.JvmTypeReferenceElements getJvmTypeReferenceAccess() {
		return gaXtype.getJvmTypeReferenceAccess();
	}
	
	public ParserRule getJvmTypeReferenceRule() {
		return getJvmTypeReferenceAccess().getRule();
	}
	
	//ArrayBrackets:
	//	'[' ']';
	public XtypeGrammarAccess.ArrayBracketsElements getArrayBracketsAccess() {
		return gaXtype.getArrayBracketsAccess();
	}
	
	public ParserRule getArrayBracketsRule() {
		return getArrayBracketsAccess().getRule();
	}
	
	//XFunctionTypeRef:
	//	('(' (paramTypes+=JvmTypeReference (',' paramTypes+=JvmTypeReference)*)? ')')? '=>' returnType=JvmTypeReference;
	public XtypeGrammarAccess.XFunctionTypeRefElements getXFunctionTypeRefAccess() {
		return gaXtype.getXFunctionTypeRefAccess();
	}
	
	public ParserRule getXFunctionTypeRefRule() {
		return getXFunctionTypeRefAccess().getRule();
	}
	
	//JvmParameterizedTypeReference:
	//	type=[JvmType|super::QualifiedName] (=> '<' arguments+=JvmArgumentTypeReference (','
	//	arguments+=JvmArgumentTypeReference)* '>' (=> ({JvmInnerTypeReference.outer=current} '.') type=[JvmType|ValidID] (=>
	//	'<' arguments+=JvmArgumentTypeReference (',' arguments+=JvmArgumentTypeReference)* '>')?)*)?;
	public XtypeGrammarAccess.JvmParameterizedTypeReferenceElements getJvmParameterizedTypeReferenceAccess() {
		return gaXtype.getJvmParameterizedTypeReferenceAccess();
	}
	
	public ParserRule getJvmParameterizedTypeReferenceRule() {
		return getJvmParameterizedTypeReferenceAccess().getRule();
	}
	
	//JvmArgumentTypeReference JvmTypeReference:
	//	JvmTypeReference | JvmWildcardTypeReference;
	public XtypeGrammarAccess.JvmArgumentTypeReferenceElements getJvmArgumentTypeReferenceAccess() {
		return gaXtype.getJvmArgumentTypeReferenceAccess();
	}
	
	public ParserRule getJvmArgumentTypeReferenceRule() {
		return getJvmArgumentTypeReferenceAccess().getRule();
	}
	
	//JvmWildcardTypeReference:
	//	{JvmWildcardTypeReference} '?' (constraints+=JvmUpperBound constraints+=JvmUpperBoundAnded*
	//	| constraints+=JvmLowerBound constraints+=JvmLowerBoundAnded*)?;
	public XtypeGrammarAccess.JvmWildcardTypeReferenceElements getJvmWildcardTypeReferenceAccess() {
		return gaXtype.getJvmWildcardTypeReferenceAccess();
	}
	
	public ParserRule getJvmWildcardTypeReferenceRule() {
		return getJvmWildcardTypeReferenceAccess().getRule();
	}
	
	//JvmUpperBound:
	//	'extends' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmUpperBoundElements getJvmUpperBoundAccess() {
		return gaXtype.getJvmUpperBoundAccess();
	}
	
	public ParserRule getJvmUpperBoundRule() {
		return getJvmUpperBoundAccess().getRule();
	}
	
	//JvmUpperBoundAnded JvmUpperBound:
	//	'&' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmUpperBoundAndedElements getJvmUpperBoundAndedAccess() {
		return gaXtype.getJvmUpperBoundAndedAccess();
	}
	
	public ParserRule getJvmUpperBoundAndedRule() {
		return getJvmUpperBoundAndedAccess().getRule();
	}
	
	//JvmLowerBound:
	//	'super' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmLowerBoundElements getJvmLowerBoundAccess() {
		return gaXtype.getJvmLowerBoundAccess();
	}
	
	public ParserRule getJvmLowerBoundRule() {
		return getJvmLowerBoundAccess().getRule();
	}
	
	//JvmLowerBoundAnded JvmLowerBound:
	//	'&' typeReference=JvmTypeReference;
	public XtypeGrammarAccess.JvmLowerBoundAndedElements getJvmLowerBoundAndedAccess() {
		return gaXtype.getJvmLowerBoundAndedAccess();
	}
	
	public ParserRule getJvmLowerBoundAndedRule() {
		return getJvmLowerBoundAndedAccess().getRule();
	}
	
	//JvmTypeParameter:
	//	name=ValidID (constraints+=JvmUpperBound constraints+=JvmUpperBoundAnded*)?;
	public XtypeGrammarAccess.JvmTypeParameterElements getJvmTypeParameterAccess() {
		return gaXtype.getJvmTypeParameterAccess();
	}
	
	public ParserRule getJvmTypeParameterRule() {
		return getJvmTypeParameterAccess().getRule();
	}
	
	//QualifiedNameWithWildcard:
	//	super::QualifiedName '.' '*';
	public XtypeGrammarAccess.QualifiedNameWithWildcardElements getQualifiedNameWithWildcardAccess() {
		return gaXtype.getQualifiedNameWithWildcardAccess();
	}
	
	public ParserRule getQualifiedNameWithWildcardRule() {
		return getQualifiedNameWithWildcardAccess().getRule();
	}
	
	//ValidID:
	//	ID;
	public XtypeGrammarAccess.ValidIDElements getValidIDAccess() {
		return gaXtype.getValidIDAccess();
	}
	
	public ParserRule getValidIDRule() {
		return getValidIDAccess().getRule();
	}
	
	//XImportSection:
	//	importDeclarations+=XImportDeclaration+;
	public XtypeGrammarAccess.XImportSectionElements getXImportSectionAccess() {
		return gaXtype.getXImportSectionAccess();
	}
	
	public ParserRule getXImportSectionRule() {
		return getXImportSectionAccess().getRule();
	}
	
	//XImportDeclaration:
	//	'import' (static?='static' extension?='extension'? importedType=[JvmDeclaredType|QualifiedNameInStaticImport]
	//	(wildcard?='*' | memberName=ValidID) | importedType=[JvmDeclaredType|super::QualifiedName] |
	//	importedNamespace=QualifiedNameWithWildcard) ';'?;
	public XtypeGrammarAccess.XImportDeclarationElements getXImportDeclarationAccess() {
		return gaXtype.getXImportDeclarationAccess();
	}
	
	public ParserRule getXImportDeclarationRule() {
		return getXImportDeclarationAccess().getRule();
	}
	
	//QualifiedNameInStaticImport:
	//	(ValidID '.')+;
	public XtypeGrammarAccess.QualifiedNameInStaticImportElements getQualifiedNameInStaticImportAccess() {
		return gaXtype.getQualifiedNameInStaticImportAccess();
	}
	
	public ParserRule getQualifiedNameInStaticImportRule() {
		return getQualifiedNameInStaticImportAccess().getRule();
	}
	
	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '$' | '_') ('a'..'z' | 'A'..'Z' | '$' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaXtype.getIDRule();
	}
	
	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"'? |
	//	"'" ('\\' . | !('\\' | "'"))* "'"?;
	public TerminalRule getSTRINGRule() {
		return gaXtype.getSTRINGRule();
	}
	
	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return gaXtype.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaXtype.getSL_COMMENTRule();
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaXtype.getWSRule();
	}
	
	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaXtype.getANY_OTHERRule();
	}
}
