package com.vical.ui.util;

import org.apache.commons.lang3.StringUtils;

import com.vaadin.addon.touchkit.ui.NavigationManager;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Popover;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.VerticalLayout;
import com.vical.domain.Persona;

public class DetallePersona extends Popover {
	private static final long serialVersionUID = -954386005852977617L;
	private Persona persona;
	private VerticalLayout lytCotenendor;
	private NavigationView content;
	
	public DetallePersona() {
		construir();		
	}
	
	private void construir() {
		setWidth("50%");
		setHeight("50%");		
		lytCotenendor = new VerticalLayout();
		content = new NavigationView(lytCotenendor);
		setContent(content);
	}

	@Override
	public void attach() {
		super.attach();
		if(persona != null){
			lytCotenendor.addComponent(CreateComponent.crateLabel(
								StringUtils.join(new String[]{persona.getNombre(), persona.getPaterno(), 
										persona.getMaterno()}, " "), FontAwesome.USER));
			lytCotenendor.addComponent(CreateComponent.crateLabel(persona.getEmail(), FontAwesome.INBOX));
			lytCotenendor.addComponent(CreateComponent.crateLabel(persona.getTelefono(), FontAwesome.PHONE));
		}		
	}
	
	public void open(NavigationManager navigationManager){
		showRelativeTo(navigationManager);
	}
	public Persona getPersona() { return persona; }
	public void setPersona(Persona persona) { this.persona = persona; }	
}
