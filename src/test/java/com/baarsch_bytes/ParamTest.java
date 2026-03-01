package com.baarsch_bytes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ParameterizedTest
@CsvSource({
        "39.9, true, false",    // trainingHours, testPassed, expectedResult
        "40.0, true, true",
        "50, false, false"
})
public @interface ParamTest {
}
