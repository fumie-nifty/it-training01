/**
 * EmployeeManagementConfiguration.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package jp.co.flm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * コンフィグレーションクラス
 * @author FLM
 * @version 2.0.0 2024/02/4　　Spring Boot 3.2.2
 */
@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class EmployeeManagementConfiguration {

	/**
	 * ResourceBundleMessageSourceのBean定義
	 * @return {@code ResourceBundleMessageSource}
	 */
	@Bean
	ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource
			= new ResourceBundleMessageSource();
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setBasenames("EmployeeManagement-messages");
		return messageSource;
	}

}
