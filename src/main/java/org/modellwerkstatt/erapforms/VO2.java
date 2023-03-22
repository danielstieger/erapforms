package org.modellwerkstatt.erapforms;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.application.AbstractEntryPoint;
import org.eclipse.rap.rwt.client.service.ExitConfirmation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class VO2 extends AbstractEntryPoint {

    @Override
    protected void createContents(Composite composite) {

        Text text = new Text(composite, SWT.BORDER);
        text.setText("HELLO WORLD");

        ExitConfirmation service = RWT.getClient().getService( ExitConfirmation.class );
        service.setMessage( "Do you really wanna leave the party?" );

    }
}
