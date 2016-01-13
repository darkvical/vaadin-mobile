package com.vical.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

public abstract class Inject {

	static ApplicationContext applicationContext;

	public static void inject(Object object) {
		AutowireCapableBeanFactory beanFactory = getApplicationContext()
				.getAutowireCapableBeanFactory();
		beanFactory.autowireBeanProperties(object,
				AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);
	}
	
	private static ApplicationContext getApplicationContext() {
		if (applicationContext == null) {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.currentRequestAttributes();
			HttpServletRequest request = requestAttributes.getRequest();
			HttpSession session = request.getSession(false);
			applicationContext = WebApplicationContextUtils
					.getRequiredWebApplicationContext(session
							.getServletContext());
		}
		return applicationContext;
	}

	public static void injectScheduler(Object object,
			ApplicationContext schedulerContext) {
		if (applicationContext == null) {
			applicationContext = schedulerContext;
		}
		AutowireCapableBeanFactory beanFactory = applicationContext
				.getAutowireCapableBeanFactory();
		beanFactory.autowireBeanProperties(object,
				AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);
	}
	
	public static <T> T getBean(Class<T> type) {
		return getBean(type, getApplicationContext());
	}
	
	private static <T> T getBean(Class<T> type,
			ApplicationContext applicationContext) {
		AutowireCapableBeanFactory beanFactory = applicationContext
				.getAutowireCapableBeanFactory();
		return beanFactory.getBean(type);
	}
	
	public static String getPropertie(String key) {
		PropertiesFactoryBean propertiesFactory = getBean(PropertiesFactoryBean.class);
		try {
			return propertiesFactory.getObject().getProperty(key);
		} catch (IOException e) {
			return StringUtils.EMPTY;
		}
	}
	
}
