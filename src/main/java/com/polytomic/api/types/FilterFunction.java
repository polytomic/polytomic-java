/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.polytomic.api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FilterFunction {
    EQUALITY("Equality"),

    INEQUALITY("Inequality"),

    IS_NULL("IsNull"),

    IS_NOT_NULL("IsNotNull"),

    TRUE("True"),

    FALSE("False"),

    ON_OR_AFTER("OnOrAfter"),

    ON_OR_BEFORE("OnOrBefore"),

    GREATER_THAN("GreaterThan"),

    GREATER_THAN_EQUAL("GreaterThanEqual"),

    LESS_THAN("LessThan"),

    LESS_THAN_EQUAL("LessThanEqual"),

    STRING_CONTAINS("StringContains"),

    STRING_ENDS_WITH("StringEndsWith"),

    STRING_DOES_NOT_CONTAIN("StringDoesNotContain"),

    STRING_DOES_NOT_END_WITH("StringDoesNotEndWith"),

    STRING_ONE_OF("StringOneOf"),

    STRING_NOT_ONE_OF("StringNotOneOf"),

    BETWEEN("Between"),

    ARRAY_CONTAINS("ArrayContains"),

    ARRAY_DOES_NOT_CONTAIN("ArrayDoesNotContain"),

    IN_THE_LAST("InTheLast"),

    RELATIVE_ON_OR_BEFORE("RelativeOnOrBefore"),

    RELATIVE_ON_OR_AFTER("RelativeOnOrAfter"),

    STRING_LIKE("StringLike"),

    STRING_NOT_LIKE("StringNotLike"),

    STRING_MATCHES_TRIMMED("StringMatchesTrimmed");

    private final String value;

    FilterFunction(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}
