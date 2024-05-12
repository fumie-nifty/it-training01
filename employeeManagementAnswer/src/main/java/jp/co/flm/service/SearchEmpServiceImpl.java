package jp.co.flm.service;

import org.springframework.stereotype.Service;

import jp.co.flm.common.exception.BusinessException;
import jp.co.flm.entity.Employee;
import jp.co.flm.mapper.EmployeeMapper;

/**
 * 従業員検索Serviceの実装クラス
 * @author FLM
 * @version 2.0.0 2024/02/4　　Spring Boot 3.2.2
 */
@Service
public class SearchEmpServiceImpl implements SearchEmpService {

	/** Mapper */
	private EmployeeMapper employeeMapper;

	/** コンストラクターインジェクション */
	public SearchEmpServiceImpl(EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
	}

	/**
	 * @see jp.co.flm.service.SearchEmpService#getEmployee(java.lang.Integer)
	 */
	@Override
	public Employee getEmployee(Integer employeeId) {
		//戻り値を用の変数の初期化
		Employee employee =null;

		// Mapperのメソッド呼び出し
		employee = employeeMapper.findOne(employeeId);

		// 検索結果が存在しない場合
		if (employee == null) {
			// 業務エラーを明示的に発生させる（エラーメッセージ[BIZERR301]）
			throw new BusinessException("該当する従業員情報がありません。");
		}

		//employeeを返却
		return employee;
	}


}
