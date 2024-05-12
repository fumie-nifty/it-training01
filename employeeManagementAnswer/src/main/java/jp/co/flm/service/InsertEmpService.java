package jp.co.flm.service;

import jp.co.flm.entity.Employee;

/**
 * 従業員登録Service インターフェイス
 * @author FLM
 * @version 2.0.0 2024/02/4　　Spring Boot 3.2.2
 */
public interface InsertEmpService {

	/**
	 * 従業員情報の確認をする
	 * @param employee 従業員情報
	 * @return employee 従業員情報
	 */
	public Employee confirmEmployee(Employee employee) ;

	/**
	 * 従業員情報の登録をする
	 * @param employee 従業員情報
	 */
	public void registEmployee(Employee employee) ;

}
