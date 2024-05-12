package jp.co.flm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * トップコントローラー
 * @author FLM
 * @version 2.0.0 2024/02/4　　Spring Boot 3.2.2
 */
@Controller
public class TopController {

	@GetMapping("/")
	public String handler() {
		// 次画面名（top.html）を返却する
		return "top";
	}

}
