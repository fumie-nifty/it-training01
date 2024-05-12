package jp.co.flm.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 従業員情報クラス
 * @author FLM
 * @version 2.0.0 2024/02/4　　Spring Boot 3.2.2
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

	private int employeeId;

	private String employeeName;

	private String section;

	private String phone;
}