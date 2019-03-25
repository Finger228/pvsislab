package labwork2.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import labwork2.controller.AddStudentController;
import labwork2.model.*;

public class AddStudentWindow {

	public void showWindow(Display display, Shell shell, Table table) {

		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    
		Shell addStudentWindow = new Shell(shell);
		addStudentWindow.setLayout(gridLayout);
		addStudentWindow.setSize(240, 224);
	    
	    GridData gridDataButton = new GridData();
	    gridDataButton.horizontalAlignment = GridData.FILL;
		
		Label surnameLabel = new Label(addStudentWindow, SWT.NONE);
        Text surnameText = new Text(addStudentWindow, SWT.FILL);
        surnameLabel.setText("�������: ");
        
        Label nameLabel = new Label(addStudentWindow, SWT.NONE);
        Text nameText = new Text(addStudentWindow, SWT.NONE);
        nameLabel.setText("���: ");
        
		Label patronymicLabel = new Label(addStudentWindow, SWT.NONE);
        Text patronymicText = new Text(addStudentWindow, SWT.NONE);
		patronymicLabel.setText("��������: ");

		Label courseLabel = new Label(addStudentWindow, SWT.NONE);
        Text courseText = new Text(addStudentWindow, SWT.NONE);
		courseLabel.setText("����: ");

		Label groupLabel = new Label(addStudentWindow, SWT.NONE);
        Text groupText = new Text(addStudentWindow, SWT.NONE);
		groupLabel.setText("������: ");

		Label worksMaxLabel = new Label(addStudentWindow, SWT.NONE);
        Text worksMaxText = new Text(addStudentWindow, SWT.NONE);
		worksMaxLabel.setText("����� �����: ");

		Label worksMadeLabel = new Label(addStudentWindow, SWT.NONE);
        Text worksMadeText = new Text(addStudentWindow, SWT.NONE);
		worksMadeLabel.setText("����� �������: ");

		Label progLanguageLabel = new Label(addStudentWindow, SWT.NONE);
        Text progLanguageText = new Text(addStudentWindow, SWT.NONE);
		progLanguageLabel.setText("���� ����������������: ");
		
		Button addStudentButton = new Button(addStudentWindow, SWT.PUSH);
		Button cancelButton = new Button(addStudentWindow, SWT.PUSH);
		addStudentButton.setLayoutData(gridDataButton);
		addStudentButton.setText("Add student");
		cancelButton.setLayoutData(gridDataButton);
		cancelButton.setText("Cancel");
				
		addStudentButton.addSelectionListener (new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				StudentFullName studentFullName = new StudentFullName(surnameText.getText(), nameText.getText(), patronymicText.getText());
				StudentCourse studentCourse = new StudentCourse(Integer.parseInt(courseText.getText()));
				StudentGroup studentGroup = new StudentGroup(groupText.getText());
				StudentWorks StudentWorks = new StudentWorks(Integer.parseInt(worksMaxText.getText()), Integer.parseInt(worksMadeText.getText()));
				ProgLanguage ProgLanguage = new ProgLanguage(progLanguageText.getText());
				Student student = new Student(studentFullName, studentCourse, studentGroup, StudentWorks, ProgLanguage);
				new AddStudentController().addStudentInTable(student, table);
			}
		});
		
		addStudentWindow.open();
	}
}
