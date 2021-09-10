package com.example.lottery.service;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Retention(RUNTIME)
@Target({ TYPE, FIELD, PARAMETER })
@Qualifier
public @interface ServiceQuality {
	QualityLevel value();
}
