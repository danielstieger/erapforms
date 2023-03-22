package org.modellwerkstatt.erapforms;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.application.AbstractEntryPoint;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class VO3 extends AbstractEntryPoint {

    public void createContents( Composite parent ) {
        parent.getDisplay().setData( RWT.MNEMONIC_ACTIVATOR, "CTRL" );
        parent.getShell().setData(RWT.ACTIVE_KEYS, new String[]{"CTRL+X", "ESC", "d"});

        DateTime calendar = new DateTime (parent,  SWT.BORDER | SWT.DROP_DOWN | SWT.DATE |SWT.MEDIUM);

        Text t = new Text(parent, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
        t.setLayoutData(new GridData(GridData.FILL_BOTH));
        t.setText("USE CRTL for a MNEMONIC demo ... ");

        parent.getShell().addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                t.setText("KEY " + keyEvent);
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });

        Button calenderInDialog = new Button(parent, SWT.BORDER);
        calenderInDialog.setText("&E Open Calendar");

        calenderInDialog.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                Shell dialog = new Shell(parent.getShell(), SWT.APPLICATION_MODAL);
                dialog.setData(RWT.ACTIVE_KEYS, new String[]{"CTRL+X", "ESC"});
                dialog.addKeyListener(new KeyListener() {
                    @Override
                    public void keyPressed(KeyEvent keyEvent) {

                    }

                    @Override
                    public void keyReleased(KeyEvent keyEvent) {

                    }
                });

                dialog.setMinimumSize(parent.getShell().getSize().x - 200, 0);
                dialog.setLocation(100, 0);

                dialog.setLayout(new GridLayout(1, false));

                DateTime d = new DateTime (dialog, SWT.CALENDAR | SWT.BORDER);
                d.addSelectionListener(new SelectionAdapter() {
                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        dialog.close();
                    }
                });

                Button closeButton = new Button(dialog, SWT.NONE);
                closeButton.setText("&E Close");
                closeButton.addSelectionListener(new SelectionAdapter() {
                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        dialog.close();
                    }
                });

                dialog.pack();
                dialog.open();
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent selectionEvent) {

            }
        });




    }
}