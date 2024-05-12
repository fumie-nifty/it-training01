package jp.co.flm.form;

import java.io.Serializable;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 従業員ID入力フォーム
 * @author FLM
 * @version 2.0.0 2024/02/4　　Spring Boot 3.2.2
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeIdForm implements Serializable {

	@Min(100000)
	@Max(999999)
	@NotNull
	private Integer employeeId;

}

