package jp.co.flm.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.flm.common.exception.BusinessException;
import jp.co.flm.entity.Employee;
import jp.co.flm.form.EmployeeIdForm;
import jp.co.flm.service.SearchEmpService;

/**
 * 従業員検索Controller
 * @author FLM
 * @version 2.0.0 2024/02/4　　Spring Boot 3.2.2
 */
@Controller
public class SearchEmpController {

	/** 従業員検索Service */
	private SearchEmpService searchEmpService;

	/** コンストラクターインジェクション */
	@Autowired
	public SearchEmpController(SearchEmpService searchEmpService) {
		this.searchEmpService = searchEmpService;
	}

	/**
	 * 例題一覧画面→従業員検索画面に対応するHandlerメソッド
	 * マッピングするHTTPメソッド： GET
	 * マッピングするURL： /search
	 * @param model {@link Model}オブジェクト
	 * @return 従業員検索画面（retrieve-input.html）
	 */
	@GetMapping("/search")
	public String search(Model model) {

		// フォームオブジェクトをModelに設定
		model.addAttribute("employeeIdForm", new EmployeeIdForm());

		// 次画面名（retrieve-input.html）を返却する
		return "retrieve-input";
	}

	/**
	 * 従業員検索画面→従業員検索結果画面に対応するHandlerメソッド
	 * マッピングするHTTPメソッド： GET
	 * マッピングするURL： /retrieveEmployee
	 * @param employeeId 従業員ID
	 * @param model {@link Model}オブジェクト
	 * @return 従業員検索結果画面（retrieve-employee.html）
	 */
	@GetMapping(value = "/retrieveEmployee", params = "employeeId")
	public String retrieveEmployee(	@Validated EmployeeIdForm employeeIdForm,
									BindingResult result,
									Model model) {

		// リクエストパラメーターの入力チェック
		if (result.hasErrors()) {
			// 次画面名（retrieve-input.html）を返却する
			return "retrieve-input";
		}

		Integer employeeId = employeeIdForm.getEmployeeId();

		// Employeeオブジェクトの検索
		Employee employee = searchEmpService.getEmployee(employeeId);

		// Modelに情報を設定
		model.addAttribute("employee", employee);

		// 次画面名（retrieve-employee.html）を返却する
		return "retrieve-employee";
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
		return "retrieve-input";
	}

}
