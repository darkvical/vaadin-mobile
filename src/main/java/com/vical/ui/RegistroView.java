package com.vical.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.addon.touchkit.ui.DatePicker;
import com.vaadin.addon.touchkit.ui.EmailField;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.NumberField;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vical.domain.Persona;
import com.vical.service.IPersonaService;
import com.vical.util.Inject;

public class RegistroView extends NavigationView implements ClickListener {
	
	private static final long serialVersionUID = -4231118444522862067L;

	private static final String ID_SUBMIT = "id_submit";
	
	private VerticalComponentGroup content;
	private TextField nameField;
	private TextField paternoField;
	private TextField maternoField;
	private DatePicker dateField;
	private EmailField emailField;
	private NumberField telefonoField;
	
	@Autowired
	private IPersonaService personaService;
	
    public RegistroView() {
    	Inject.inject(this);
    	cargaFormulario();        
    }

	private void cargaFormulario() {
		setCaption("Registro");
		content = new VerticalComponentGroup();
		
        nameField = new TextField("Nombre");
        nameField.setInputPrompt("Ingrese su nombre");
        content.addComponent(nameField);
        
        paternoField = new TextField("Apellido paterno");
        paternoField.setInputPrompt("Ingrese su apellido paterno");
        content.addComponent(paternoField);
        
        maternoField = new TextField("Apellido materno");
        maternoField.setInputPrompt("Ingrese su apellido materno");
        content.addComponent(maternoField);

        dateField = new DatePicker("Fecha de nacimiento");
        content.addComponent(dateField);

        emailField = new EmailField("e-mail");
        emailField.setInputPrompt("Ingrese su correo");
        content.addComponent(emailField);
        
        telefonoField = new NumberField("Telefono");
        telefonoField.setInputPrompt("Ingrese su telefono");
        content.addComponent(telefonoField);
        
        Button submitButton = new Button("Submit");
        submitButton.setId(ID_SUBMIT);
        submitButton.addClickListener(this);
        
        setContent(new CssLayout(content, submitButton));
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().getId().equals(ID_SUBMIT)){
			guardarPersona();
			getNavigationManager().navigateBack();
//			getNavigationManager().navigateTo(getPreviousComponent());
//			Notification.show("Gracias");
		}
	}

	private void guardarPersona() {
		Persona persona = new Persona();
//		persona.setCodigo(.getValue());
		persona.setNombre(nameField.getValue());
		persona.setPaterno(paternoField.getValue());
		persona.setMaterno(maternoField.getValue());
		persona.setFechaNacimiento(dateField.getValue());
		persona.setEmail(emailField.getValue());
		persona.setTelefono(telefonoField.getValue());
		personaService.crearPersona(persona);
	}
}