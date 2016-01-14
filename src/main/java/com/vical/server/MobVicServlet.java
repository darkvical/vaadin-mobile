package com.vical.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.vaadin.addon.touchkit.server.TouchKitServlet;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vical.MobVicTouchKitUI;

@SuppressWarnings("serial")
@WebServlet("/*")
@VaadinServletConfiguration(productionMode = false,ui = MobVicTouchKitUI.class)
public class MobVicServlet extends TouchKitServlet {

    private MobVicUIProvider uiProvider = new MobVicUIProvider();

    @Override
    protected void servletInitialized() throws ServletException {
        super.servletInitialized();
        getService().addSessionInitListener(new SessionInitListener() {
            @Override
            public void sessionInit(SessionInitEvent event) throws ServiceException {
                event.getSession().addUIProvider(uiProvider);
            }
        });
    }
}