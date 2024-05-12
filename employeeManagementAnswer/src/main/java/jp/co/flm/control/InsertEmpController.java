package jp.co.flm.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jp.co.flm.common.exception.BusinessException;
import jp.co.flm.entity.Employee;
import jp.co.flm.form.EmployeeForm;
import jp.co.flm.service.InsertEmpService;

/**
 * 従業員登録Controller
 * @author FLM
 * @version 2.0.0 2024/02/4　　Spring Boot 3.2.2
 */
@SessionAttributes(names = "employee")
@Controller
public class InsertEmpController {

	/** Service */
	InsertEmpService insertEmpService;

	/** コンストラクターインジェクション */
	public InsertEmpController(InsertEmpService insertEmpService) {
		this.insertEmpService = insertEmpService;
	}

	/**
	 * 例題一覧画面（トップ）から従業員登録画面への遷移
	 * @return /insert-input
	 */
	@GetMapping("/inputInsert")
	public String inputInsert(Model model) {

		// フォームオブジェクトをModelに設定
		model.addAttribute("employeeForm", new EmployeeForm());

		// 次画面名（insert-input.html）を返却する
		return "insert-input";
	}

	/**
	 * 従業員登録確認画面を表示する
	 */
	@PostMapping("/confirmInsert")
	public String confirmInsert(@Validated EmployeeForm employeeForm,
			BindingResult result,Model model) {

		// 次の画面のHTMLを格納、初期値としてinsert-inputを格納
		String page = "insert-input";

		// 入力チェック
		if (result.hasErrors()) {
			// 従業員登録画面（insert-input）を返却する
			return page;
		}

		Employee employee = new Employee(employeeForm.getEmployeeId(),
										employeeForm.getEmployeeName(),
										employeeForm.getSection(),
										employeeForm.getPhone());
		try {
			// Serviceの呼び出し
			insertEmpService.confirmEmployee(employee);

			// Modelに情報を設定
			model.addAttribute("employee", employee);

			// 次の画面insert-confirmを格納
			page = "insert-confirm";

		}catch(BusinessException e) {
			model.addAttribute("message", e.getMessage());
		}

		// 次画面名を返却する
		return page;
	}

	/**
	 * 従業員登録結果画面を表示する
	 */
	@GetMapping("/commitInsert")
	public String commitInsert(@ModelAttribute("employee") Employee employee,
													Model model,
													SessionStatus status) {

		// Serviceの呼び出し
		insertEmpService.registEmployee (employee);

		//セッションからフォームオブジェクトの削除
		status.setComplete();

		// 次画面名（insert-complete.html）を返却する
		return "insert-complete";
	}

	/**
	 * 従業員登録画面へ戻る
	 */
	@GetMapping("/reviseInput")
	public String reviseInput(@ModelAttribute("employee") Employee employee,Model model) {

		//セッションの従業員情報をもとにフォームオブジェクトを生成
		EmployeeForm employeeForm = new EmployeeForm();
		employeeForm.setEmployeeId(employee.getEmployeeId());
		employeeForm.setEmployeeName(employee.getEmployeeName());
		employeeForm.setSection(employee.getSection());
		employeeForm.setPhone(employee.getPhone());

		// フォームオブジェクトをModelに設定
		model.addAttribute("employeeForm", employeeForm);

		// 次画面名（insert-input.html）を返却する
		return "insert-input";
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
		model.addAttribute("employeeForm", new EmployeeForm());

		// 次画面名（insert-input.html）を返却する
		return "insert-input";
	}

}
