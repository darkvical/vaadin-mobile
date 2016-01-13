package com.vical;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import org.springframework.web.context.ContextLoaderListener;

@WebListener
public class MobVicContextLoader extends ContextLoaderListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		event.getServletContext().setInitParameter("contextConfigLocation", "classpath:spring/applicationContext.xml");
		super.contextInitialized(event);
	}
}
