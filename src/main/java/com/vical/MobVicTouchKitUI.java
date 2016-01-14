package com.vical;

import com.vaadin.addon.touchkit.annotations.CacheManifestEnabled;
import com.vaadin.addon.touchkit.annotations.OfflineModeEnabled;
import com.vaadin.addon.touchkit.extensions.OfflineMode;
import com.vaadin.addon.touchkit.ui.NavigationManager;
import com.vaadin.addon.touchkit.ui.TabBarView;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.UI;
import com.vical.gwt.client.MobVicPersistToServerRpc;
import com.vical.ui.MenuView;

/**
 * The UI's "main" class
 */
@SuppressWarnings("serial")
@Widgetset("com.vical.gwt.MobVicWidgetSet")
@Theme("vicaltheme")
// Cache static application files so as the application can be started
// and run even when the network is down.
@CacheManifestEnabled
// Switch to the OfflineMode client UI when the server is unreachable
@OfflineModeEnabled
// Make the server retain UI state whenever the browser reloads the app
@PreserveOnRefresh
public class MobVicTouchKitUI extends UI {

    @SuppressWarnings("unused")
	private final MobVicPersistToServerRpc serverRpc = new MobVicPersistToServerRpc() {
        @Override
        public void persistToServer() {
            // TODO this method is called from client side to store offline data
        }
    };

    @Override
    protected void init(VaadinRequest request) {
        final TabBarView tabBarView = new TabBarView();
        final NavigationManager navigationManager = new NavigationManager();
        navigationManager.setCaption("Administración");
        navigationManager.setCurrentComponent(new MenuView());
        
        Tab tabInicio;
        tabInicio = tabBarView.addTab(navigationManager);
        tabInicio.setIcon(FontAwesome.BOOK);
//        tabInicio = tabBarView.addTab(new Label("Tab 2"), "Tab 2");
//        tabInicio.setIcon(FontAwesome.AMBULANCE);
//        tabInicio = tabBarView.addTab(new Label("Tab 3"), "Tab 3");
//        tabInicio.setIcon(FontAwesome.DOWNLOAD);
        setContent(tabBarView);

        // Use of the OfflineMode connector is optional.
        OfflineMode offlineMode = new OfflineMode();
        offlineMode.extend(this);
        // Maintain the session when the browser app closes.
        offlineMode.setPersistentSessionCookie(true);
        // Define the timeout in secs to wait when a server request is sent
        // before falling back to offline mode.
        offlineMode.setOfflineModeTimeout(15);
    }
}

