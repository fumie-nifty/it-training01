package jp.co.flm.service;

import jp.co.flm.entity.Employee;

/**
 * 従業員検索Service インターフェイス
 * @author FLM
 * @version 2.0.0 2024/02/4　　Spring Boot 3.2.2
 */
public interface SearchEmpService {

	/**
	 * 従業員IDに一致する従業員情報の取得をする
	 * @param employeeId 従業員情報ID
	 * @return employee 従業員情報
	 */
	public Employee getEmployee(Integer employeeId);

}
