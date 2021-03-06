package labwork1.ppvis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ThirdComposite {

	public void createComposite(Shell shell) {
		Composite composite = null;
		GridLayout gridlayout = new GridLayout();	
		composite = new Composite(shell, SWT.BORDER);
		composite.setLayout(gridlayout);
		
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.horizontalSpan = 2;
		
		Text text = new Text(composite, SWT.BORDER);
		text.setLayoutData(gridData);
		
		Button buttonChoise = new Button(composite, SWT.PUSH | SWT.CENTER);		
		buttonChoise.setText("choise");
		buttonChoise.setLayoutData(gridData);
	    
		Group group = new Group(composite, SWT.NONE);
		group.setLayout(new RowLayout(SWT.HORIZONTAL));		
	    Button button1 = new Button(group, SWT.RADIO);		
		button1.setText("1");
		Button button2 = new Button(group, SWT.RADIO);		
		button2.setText("2");
		Button button3 = new Button(group, SWT.RADIO);		
		button3.setText("3");
		
		buttonChoise.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {				
				String input = text.getText();
				if (input.equals(button1.getText())) {					
					button1.setSelection(true);	
					button2.setSelection(false);	
					button3.setSelection(false);
				} else if (input.equals(button2.getText())) { 
					button1.setSelection(false);	
					button2.setSelection(true);	
					button3.setSelection(false);
				} else if (input.equals(button3.getText())) {
					button1.setSelection(false);	
					button2.setSelection(false);	
					button3.setSelection(true);					
				} else {
					MessageBox messagebox = new MessageBox(shell);
					messagebox.setMessage("Miss");
					messagebox.open();
				}
			}
		});
	}
}
