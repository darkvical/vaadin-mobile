package com.vical.ui;

import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickEvent;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickListener;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;

@SuppressWarnings("serial")
public class MenuView extends NavigationView implements NavigationButtonClickListener {

	private static final String ID_NAVEGAR = "id_navegar"; 
    public MenuView() {
        setCaption("Menu");
        final VerticalComponentGroup content = new VerticalComponentGroup();
        NavigationButton btnNavegar = new NavigationButton("Registro");
        btnNavegar.setId(ID_NAVEGAR);
        btnNavegar.addClickListener(this);
        content.addComponent(btnNavegar);
        setContent(content);
    }

	@Override
	public void buttonClick(NavigationButtonClickEvent event) {
		if(event.getComponent().getId().equals(ID_NAVEGAR)){
			getNavigationManager().navigateTo(new RegistroView());
		}
	}
}