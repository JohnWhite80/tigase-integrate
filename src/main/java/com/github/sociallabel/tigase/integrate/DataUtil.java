package com.github.sociallabel.tigase.integrate;

import java.nio.charset.Charset;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class DataUtil {
	
	public static String WEB_SERVER_ADDRESS = "http://127.0.0.1:8080/server/api/";
	
	private static RestTemplate formTemplate = new RestTemplate();
	
	static {
		FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
	    formConverter.setCharset(Charset.forName("UTF8"));
	    formTemplate.getMessageConverters().add(formConverter);
	    formTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		formTemplate.getMessageConverters().add(new StringHttpMessageConverter());
	}

	public static <T> ResponseEntity<T> postJson(String url, Object data, Class<T> type,  Object... uriVariables){					
		return formTemplate.postForEntity(url, data, type, uriVariables);
	}

}
