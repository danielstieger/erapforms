package org.modellwerkstatt.erapforms;

import org.eclipse.rap.rwt.application.AbstractEntryPoint;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;

import java.util.Arrays;


public class VO1 extends AbstractEntryPoint {


    public Table createTable(Composite parent) {

        Table table = new Table(parent, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
        table.setLinesVisible (true);
        table.setHeaderVisible (true);

        GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
        data.heightHint = 200;
        table.setLayoutData(data);
        table.setLayout(new FillLayout());


        String[] titles = {"Pos 1", "Pos 2", "?", "Description", "DAN", "In Folder", "Location"};
        for (String title : titles) {
            TableColumn column = new TableColumn(table, SWT.NONE);
            column.setText (title);
            column.setWidth(200);
         }


        return table;
    }

    public void createData(Table table, int basis, String txt, int cnt) {
        int count = cnt;

        table.removeAll();

        for (int i=0; i<count; i++) {
            TableItem item = new TableItem (table, SWT.NONE);
            item.setText (0, "" + (basis + i));
            item.setText (1, txt + i);
            item.setText (2, "!");
            item.setText (3, "this stuff behaves the way I expect");
            item.setText (4, "almost everywhere");
            item.setText (5, "some.folder");
            item.setText (6, "line " + i + " in nowhere");
        }

        /* for (int i=0; i < table.getColumnCount(); i++) {
            table.getColumn (i).pack ();
        } */

    }

    public void createContents( Composite parent ) {

        // (1) Selection Listener & second Table with changes 100
        // (2) Table Lazyloading
        // (3) Prompt Dialog

        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 1;
        parent.setLayout(gridLayout);

        Table t1 = createTable(parent);
        createData(t1, 0, "", 1500);

        Table t2 = createTable(parent);
        Text area = new Text(parent, SWT.MULTI | SWT.FILL);
        area.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        t1.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                String string = event.detail == SWT.CHECK ? "Checked" : "Selected";
                int[] sel = t1.getSelectionIndices();
                area.setText(event.item + " " + string + " @ "+ event.index + " " + event.start + " / " + Arrays.toString(sel));


                if (sel.length > 0) {
                    createData(t2, sel[0], "" + sel[0] + "0", 40);
                    area.setText(event.item + " " + string + " @ "+ event.index + " " + event.start + " / " + Arrays.toString(sel) + " created DATA!");

                } else {
                    t2.clearAll();

                }

            }
        });

    }
}