package jp.co.flm.common.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * ControllerAdvice
 * システムエラーハンドラー
 * @author FLM
 * @version 2.0.0 2024/02/4　　Spring Boot 3.2.2
 */
@ControllerAdvice
public class SystemExceptionHandler {

	/**
	 * システム例外（SystemException・DataAccessException）をハンドリングする
	 */
	@ExceptionHandler({ SystemException.class, DataAccessException.class })
	public String handleError(Exception e,Model model) {
		e.printStackTrace();
		model.addAttribute("message", "システムエラーです。システム管理者に連絡してください。");
		return "error";
	}

	/**
	 * HttpSessionRequiredException発生時にエラー画面を表示する
	 * レスポンスステータスコード： HttpStatus.REQUEST_TIMEOUT
	 * ハンドリングする例外クラス： HttpSessionRequiredException.class
	 * @param e {@link HttpSessionRequiredException}オブジェクト
	 * @param model {@link Model}オブジェクト
	 * @return エラー画面（error.html）
	 */
	@ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
	@ExceptionHandler(HttpSessionRequiredException.class)
	public String handleError(HttpSessionRequiredException e, Model model) {

		model.addAttribute("message", "セッションが無効になりました。再度操作をやりなおしてください。");

		// 次画面名（error.html）を返却する
		return "error";
	}


}

