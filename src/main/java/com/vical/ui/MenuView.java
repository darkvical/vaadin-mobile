package com.vical.ui;

import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickEvent;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickListener;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;

@SuppressWarnings("serial")
public class MenuView extends NavigationView implements NavigationButtonClickListener {

	private static final String ID_REGISTRO = "id_registrar";
	private static final String ID_LISTADO = "id_listado";
    public MenuView() {
        setCaption("Menu");
        final VerticalComponentGroup content = new VerticalComponentGroup();
        NavigationButton btnRegistro = new NavigationButton("Registro");
        btnRegistro.setId(ID_REGISTRO);
        btnRegistro.addClickListener(this);
        
        NavigationButton btnListado = new NavigationButton("Listado");
        btnListado.setId(ID_LISTADO);
        btnListado.addClickListener(this);
        
        content.addComponent(btnRegistro);
        content.addComponent(btnListado);
        setContent(content);
    }

	@Override
	public void buttonClick(NavigationButtonClickEvent event) {
		if(event.getComponent().getId().equals(ID_REGISTRO)){
			getNavigationManager().navigateTo(new RegistroView());
		} else if(event.getComponent().getId().equals(ID_LISTADO)){
			getNavigationManager().navigateTo(new ListadoView());
		}
	}
}