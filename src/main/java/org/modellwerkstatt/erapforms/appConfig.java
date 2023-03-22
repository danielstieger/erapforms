package org.modellwerkstatt.erapforms;

import org.eclipse.rap.rwt.application.Application;
import org.eclipse.rap.rwt.application.ApplicationConfiguration;

public class appConfig implements ApplicationConfiguration {

    public void configure( Application application ) {
        application.addEntryPoint( "/erapforms", VO1.class, null );
        application.addEntryPoint( "/vo2", VO2.class, null );
    }

}
