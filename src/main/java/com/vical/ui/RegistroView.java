package com.vical.ui;

import com.vaadin.addon.touchkit.ui.DatePicker;
import com.vaadin.addon.touchkit.ui.EmailField;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.NumberField;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vical.domain.Persona;
import com.vical.service.IPersonaService;
import com.vical.service.impl.PersonaServiceImpl;

@SuppressWarnings("serial")
public class RegistroView extends NavigationView implements ClickListener {

	private static final String ID_SUBMIT = "id_submit";
//	@Autowired
	private IPersonaService personaService = new PersonaServiceImpl();
	
    public RegistroView() {
//    	Inject.inject(this);
        setCaption("Registro");
        final VerticalComponentGroup content = new VerticalComponentGroup();

        final TextField nameField = new TextField("Nombre");
        nameField.setInputPrompt("Ingrese su nombre");
        content.addComponent(nameField);

        final DatePicker dateField = new DatePicker("Fecha de nacimiento");
        content.addComponent(dateField);

        final EmailField emailField = new EmailField("e-mail");
        emailField.setInputPrompt("Ingrese su correo");
        content.addComponent(emailField);
        
        final NumberField telefono = new NumberField("Telefono");
        telefono.setInputPrompt("Ingrese su telefono");
        content.addComponent(telefono);
        
        final Button submitButton = new Button("Submit");
        submitButton.setId(ID_SUBMIT);
        submitButton.addClickListener(this);
        
        setContent(new CssLayout(content, submitButton));
    }

	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().getId().equals(ID_SUBMIT)){
			guardarPersona();
			getNavigationManager().navigateTo(getPreviousComponent());
			Notification.show("Gracias");
		}
	}

	private void guardarPersona() {
		Persona persona = new Persona();
		persona.setCodigo("jaja");
		personaService.crearPersona(persona);
	}
}