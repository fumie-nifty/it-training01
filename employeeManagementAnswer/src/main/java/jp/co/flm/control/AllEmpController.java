package jp.co.flm.control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.flm.common.exception.BusinessException;
import jp.co.flm.entity.Employee;
import jp.co.flm.form.EmployeeIdForm;
import jp.co.flm.service.AllEmpService;

/**
 * 従業員一覧コントローラー
 * @author FLM
 * @version 2.0.0 2024/02/4　　Spring Boot 3.2.2
 */
@Controller
public class AllEmpController {

	/** 従業員検索Service */
	private AllEmpService allEmpService;

	/** コンストラクターインジェクション */
	public AllEmpController(AllEmpService allEmpService) {
		this.allEmpService = allEmpService;
	}

	/**
	 * 例題一覧画面→従業員一覧検索結果画面に対応するHandlerメソッド
	 * マッピングするHTTPメソッド： GET
	 * マッピングするURL： /retrieveAllEmployee
	 * @param model {@link Model}オブジェクト
	 * @return 従業員一覧検索結果画面（retrieve-input.html）
	 */
	@GetMapping("/retrieveAllEmployee")
	public String retrieveAllEmployee(Model model) {

		// Serviceの呼び出し
		List<Employee> employeeList = allEmpService.getAllEmployee();

		// Modelに情報を設定
		model.addAttribute("employeeList", employeeList);

		// 次画面名（retrieve-list.html）を返却する
		return "retrieve-list";
	}

	/**
	 * 業務例外のハンドリング
	 * ハンドリングする例外クラス： BusinessException.class
	 */
	@ExceptionHandler(BusinessException.class)
	public String catchBizException(Model model, Exception e) {

		// エラーメッセージをModelに設定
		model.addAttribute("message", e.getMessage());

		// フォームオブジェクトをModelに設定
		model.addAttribute("employeeIdForm", new EmployeeIdForm());

		// 次画面名（retrieve-list.html）を返却する
		return "retrieve-list";
	}

}
