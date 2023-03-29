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

        DateTime calendar = new DateTime (parent,  SWT.BORDER | SWT.DROP_DOWN | SWT.DATE |SWT.MEDIUM);

        Text t = new Text(parent, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
        t.setLayoutData(new GridData(GridData.FILL_BOTH));
        t.setText("USE CRTL for a MNEMONIC demo ...  or crtl+x ESC or d to check for hotkey handling");

        parent.getDisplay().setData(RWT.ACTIVE_KEYS, new String[]{"CTRL+X", "ESC", "d"});;
        parent.getDisplay().addFilter(SWT.KeyUp, new Listener() {
            @Override
            public void handleEvent(Event event) {
                t.setText("EventFilter() KEY " + event);
            }
        });

        parent.getShell().setData(RWT.ACTIVE_KEYS, new String[]{"CTRL+X", "ESC", "d"});
        parent.getShell().addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                t.setText("KeyListener() KEY " + keyEvent);
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });

        Button openDialog = new Button(parent, SWT.BORDER);
        openDialog.setText("&E Open Calendar");

        openDialog.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                Shell dialog = new Shell(parent.getShell(), SWT.APPLICATION_MODAL);

                dialog.setMinimumSize(parent.getShell().getSize().x - 200, 0);
                dialog.setLocation(100, 0);
                dialog.setLayout(new GridLayout(1, false));

                Text t = new Text(dialog, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
                GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, true);
                gridData.heightHint = 5 * t.getLineHeight();
                t.setLayoutData(gridData);
                t.setText("1\n2\n3\n4\n5\n");

                Button closeButton = new Button(dialog, SWT.NONE);
                closeButton.setText("&E Close");
                closeButton.addSelectionListener(new SelectionAdapter() {
                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        dialog.close();
                    }
                });

                dialog.setData(RWT.CANCEL_KEYS, new String[]{"ESC"});
                dialog.setData(RWT.ACTIVE_KEYS, new String[]{"CTRL+X"});
                dialog.addKeyListener(new KeyListener() {
                    @Override
                    public void keyPressed(KeyEvent keyEvent) {
                        t.setText("Key Event here " + keyEvent) ;
                        keyEvent.doit = false;
                    }

                    @Override
                    public void keyReleased(KeyEvent keyEvent) {

                    }
                });

                dialog.addListener(SWT.Close, new Listener()
                {
                    public void handleEvent(Event event)
                    {
                        t.setText("This was the dialog.listener()");
                        event.doit = false;
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