package org.modellwerkstatt.erapforms;

import org.eclipse.rap.rwt.service.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

public class ResLoader implements ResourceLoader {



    @Override
    public InputStream getResourceAsStream(String s) throws IOException {
        return ResourceLoader.class.getResourceAsStream(s);
    }
}
