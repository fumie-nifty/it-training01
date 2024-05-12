package jp.co.flm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.flm.common.exception.BusinessException;
import jp.co.flm.entity.Employee;
import jp.co.flm.mapper.EmployeeMapper;

/**
 * 従業員一覧Serviceの実装クラス
 * @author FLM
 * @version 2.0.0 2024/02/4　　Spring Boot 3.2.2
 */
@Service
public class AllEmpServiceImpl implements AllEmpService {

	/** Mapper */
	private EmployeeMapper employeeMapper;

	/** コンストラクターインジェクション */
	public AllEmpServiceImpl(EmployeeMapper employeeMapper) {

		this.employeeMapper = employeeMapper;

	}

	/**
	 * @see jp.co.flm.service.AllEmpService#getAllEmployee()
	 */
	@Override
	public List<Employee> getAllEmployee() {

		// Mapperのメソッド呼び出し
		List<Employee> employeeList = employeeMapper.findAll();

		// 検索結果が存在しない場合
		if(employeeList.isEmpty()) {
			throw new BusinessException("該当する従業員情報がありません。");
		}

		//employeeListを返却
		return employeeList;

	}

}
