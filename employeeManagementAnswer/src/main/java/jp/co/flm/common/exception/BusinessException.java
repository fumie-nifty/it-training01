package jp.co.flm.common.exception;

/**
 * 業務例外クラス
 * @author FLM
 * @version 2.0.0 2024/02/4　　Spring Boot 3.2.2
 */
public class BusinessException extends RuntimeException{

	public BusinessException(String message) {
		super(message);
	}

}
