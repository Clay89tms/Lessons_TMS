package org.tms.dz33.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,ElementType.TYPE, ElementType.FIELD,ElementType.LOCAL_VARIABLE,ElementType.MODULE,ElementType.PACKAGE,ElementType.PARAMETER,ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
@Retention(RetentionPolicy.CLASS)
public @interface MyBenchmark {

}
