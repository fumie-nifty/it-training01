package jp.co.flm.service;


import java.util.ArrayList;

import org.springframework.stereotype.Service;

import jp.co.flm.common.exception.BusinessException;
import jp.co.flm.entity.Employee;
import jp.co.flm.mapper.EmployeeMapper;

/**
 * 従業員登録Serviceの実装クラス
 * @author FLM
 * @version 2.0.0 2024/02/4　　Spring Boot 3.2.2
 */
@Service
public class InsertEmpServiceImpl implements InsertEmpService {

	/** Mapper */
	private EmployeeMapper employeeMapper;

	/** コンストラクターインジェクション */
	public InsertEmpServiceImpl(EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
	}

	/**
	 * @see InsertEmpService#registEmployee(Employee)
	 */
	@Override
	public void registEmployee(Employee employee) {

		// Mapperのメソッド呼び出し
		employeeMapper.save(employee);

	}

	/**
	 * @see jp.co.flm.service.InsertEmpService#confirmEmployee(jp.co.flm.entity.Employee)
	 */
	@Override
	public Employee confirmEmployee(Employee employee) {
		ArrayList<String> sectionList = new ArrayList<>();
		sectionList.add("研修部");
		sectionList.add("開発部");
		sectionList.add("営業部");

			if(!sectionList.contains(employee.getSection())) {
				throw new BusinessException("部署名は、「研修部・開発部・営業部」のいずれかを入力してください。");
			}

		return employee;
	}
}
