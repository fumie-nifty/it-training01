/**
 * EmployeeMapper_AllTest.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package jp.co.flm.mapper;

import org.junit.platform.suite.api.SelectClasses;

import org.junit.platform.suite.api.Suite;

/**
 * @author FLM
 * @version 2.0.0 2024/02/4　　Spring Boot 3.2.2
 */

@Suite
@SelectClasses({
	EmployeeMapperFindOneTest.class,
	EmployeeMapperSaveTest.class,
	EmployeeMapperFindAllTest.class
	})
public class EmployeeMapper_AllTest {}
