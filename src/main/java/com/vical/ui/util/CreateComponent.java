package com.vical.ui.util;

import org.apache.commons.lang3.StringUtils;

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;

public class CreateComponent {

	public static Label crateLabel(String etiqueta){
		Label lblEnvio = new Label(StringUtils.EMPTY); 
		if(StringUtils.isNotBlank(etiqueta)){
			lblEnvio.setValue(etiqueta);
		}
		return lblEnvio;
	}
	
	public static Label crateLabel(String etiqueta, FontAwesome fontAwesome){
		Label lblEnvio = new Label(StringUtils.EMPTY);
		lblEnvio.setContentMode(ContentMode.HTML);
		if(StringUtils.isNotBlank(etiqueta)){
			lblEnvio.setValue("<font color='#0079C1'><b>" + fontAwesome.getHtml() + "</b></font>" + etiqueta);
		}
		return lblEnvio;
	}
}
