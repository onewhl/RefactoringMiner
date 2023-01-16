package org.refactoringminer.astDiff.matchers;

import com.intellij.psi.JavaTokenType;

public class Constants {
	// PSI node type labels
	public static final String ASSIGNMENT = "PsiAssignmentExpression";
	public static final String METHOD_INVOCATION = "PsiMethodCallExpression";
	public static final String METHOD_DECLARATION = "PsiMethod";
	public static final String TRY_STATEMENT = "PsiTryStatement";
	public static final String CATCH_CLAUSE = "PsiCatchSection";
	public static final String BLOCK = "PsiCodeBlock";
	public static final String VARIABLE_DECLARATION_FRAGMENT = "PsiLocalVariable";
	public static final String FIELD_DECLARATION = "PsiField";
	public static final String ACCESS_MODIFIER = "PsiModifier";
	public static final String PACKAGE_DECLARATION = "PsiPackageStatement";
	public static final String ANONYMOUS_CLASS_DECLARATION = "PsiAnonymousClass";
	public static final String LABELED_STATEMENT = "PsiLabeledStatement";
	public static final String SIMPLE_NAME = "PsiIdentifier";
	public static final String VARIABLE_DECLARATION_STATEMENT = "PsiLocalVariable";
	public static final String EXPRESSION_STATEMENT = "PsiExpression";
	public static final String MODIFIER = "PsiModifier";
	public static final String IMPORT_DECLARATION = "PsiImportList";
	public static final String PRIMITIVE_TYPE = "PsiPrimitiveType";
	public static final String TYPE_DECLARATION = "PsiClass";
	public static final String ENUM_DECLARATION = "PsiEnumConstant";

	// PSI node property labels
	/**
	 * 	See {@link JavaTokenType#EQ}.
	 */
	public static final String ASSIGNMENT_OPERATOR = "PsiJavaToken";
	public static final String TYPE_DECLARATION_KIND = "TYPE_DECLARATION_KIND";

	// Keyword labels
	public static final String TRANSIENT = "transient";
	public static final String VOLATILE = "volatile";
	public static final String SYNCHRONIZED = "synchronized";
	public static final String ABSTRACT = "abstract";
	public static final String FINAL = "final";
	public static final String STATIC = "static";
	public static final String EQUAL_OPERATOR = "=";

}
