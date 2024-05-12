package jp.co.flm.service;

import java.util.List;

import jp.co.flm.entity.Employee;

/**
 * 従業員一覧Service インターフェイス
 * @author FLM
 * @version 2.0.0 2024/02/4　　Spring Boot 3.2.2
 */
public interface AllEmpService {

	/**
	 * 従業員情報一覧を取得する
	 * @return employee 従業員情報一覧
	 */
	public List<Employee> getAllEmployee();

}
