/**
 * DuumyDataAccessException.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package jp.co.flm.test.util;

import org.springframework.dao.DataAccessException;

/**
 * @author FLM
 * @version 2.0.0 2024/02/4　　Spring Boot 3.2.2
 */
public class DummyDataAccessException extends DataAccessException {

	public DummyDataAccessException() {
		super(null);
	}
}
