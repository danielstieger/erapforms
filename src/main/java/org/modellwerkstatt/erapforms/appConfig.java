package org.modellwerkstatt.erapforms;

import org.eclipse.rap.rwt.application.Application;
import org.eclipse.rap.rwt.application.ApplicationConfiguration;
import org.eclipse.rap.rwt.client.WebClient;

import java.util.HashMap;
import java.util.Map;

public class appConfig implements ApplicationConfiguration {



    public void configure( Application application ) {

        application.addStyleSheet( "org.eclipse.rap.design.example.business.theme",
                "/rwt-resources/themes/business.css",
                new ResLoader());

        Map<String, String> businessTemplate = new HashMap<String, String>();
        businessTemplate.put( WebClient.PAGE_TITLE, "Voruntersuchung" );
        businessTemplate.put( WebClient.THEME_ID, "org.eclipse.rap.design.example.business.theme" );

        application.addEntryPoint( "/vo2", VO1.class, businessTemplate);


        Map<String, String> properties = new HashMap<String, String>();
        properties.put( WebClient.PAGE_TITLE, "Voruntersuchung 1" );
        /* properties.put( WebClient.PAGE_OVERFLOW, "scrollY" ); */
        properties.put( WebClient.BODY_HTML, "<big>modellwerkstatt.org<big>" );
        /* properties.put( WebClient.FAVICON, "icons/favicon.png" ); */
        /* properties.put( WebClient.THEME_ID, "MyCustomTheme" ); */

        application.addEntryPoint( "/vo1", VO1.class, properties );

        application.addEntryPoint("/vo3", VO3.class, properties);



    }

}
