package com.cjw.datasource;

import java.lang.annotation.*;

/**
 * @author MSI
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DS {
    String value() default "db1";
}