package com.vical.ui;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Table;
import com.vical.domain.Persona;
import com.vical.service.IPersonaService;
import com.vical.ui.util.DetallePersona;
import com.vical.util.Inject;

public class ListadoView extends NavigationView implements ItemClickListener {
	private static final long serialVersionUID = 7400419620793246413L;
	
	private Table tblPersona;
	@Autowired
	private IPersonaService personaService;
	
	public ListadoView() {
		Inject.inject(this);
		cargarFormulario();
		cargarTabla();
	}

	private void cargarTabla() {
		Query query = new Query();
		List<Persona> personas = personaService.listarPersonas(query);		
		for (Persona persona : personas) {
			tblPersona.addItem(new Object[]{persona.getNombre(), persona.getPaterno(), persona.getMaterno()}, persona);
		}
	}

	private void cargarFormulario() {
		setCaption("Personas");
		tblPersona = new Table();
		tblPersona.setWidth("100%");
		tblPersona.addContainerProperty("nombre", String.class, StringUtils.EMPTY);
		tblPersona.addContainerProperty("paterno", String.class, StringUtils.EMPTY);
		tblPersona.addContainerProperty("materno", String.class, StringUtils.EMPTY);
		tblPersona.setVisibleColumns("nombre", "paterno", "materno");
		tblPersona.addItemClickListener(this);
		setContent(new CssLayout(tblPersona));		
	}

	@Override
	public void itemClick(ItemClickEvent event) {
		if(event.getSource().equals(tblPersona)){
			abrirDetalle(event.getItemId());
		}
	}

	private void abrirDetalle(Object itemId) {
		Persona persona = (Persona) itemId;
		DetallePersona detallePersona = new DetallePersona();
		detallePersona.setPersona(persona);
		detallePersona.open(getNavigationManager());
	}
}