package com.mycom.more.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mycom.more.common.TestInterceptor;

@Configuration//xml 설정을 대신 <-servlet-context.xml 내용을 대신 대체, interceptor외에 다른 많은 설정 가능
public class WebMvcConfig implements WebMvcConfigurer{
	//interceptor 대한 정책
	//interceptor 객체 DI
	
	@Autowired
	private TestInterceptor testInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(testInterceptor)
				.addPathPatterns("/users/**")
				.excludePathPatterns("/login/**");
	}

	
}


//interface는 추상메소드만으로 구성, 바디를 가지는 default 메소드를 가질 수 없었음
//interface에 가령 20개의 추상 메소드가 있으면 그럼 implements하는 클래스는 딱 2개만 구현하고 싶은데 20개 다 구현해야 함
//이게 불편해서 api에서 자주 사용되는 interface에 대해 ...Adaptor를 제공
//..Adaptor클래스는 interface의 20개 메소드를 모두 구현(빈 바디)
// A interface를 implements하는 것이 아니고, extends AAdaptor 해서 2개만 overriding하면 되도록
// AAdaptor implements A로 구현