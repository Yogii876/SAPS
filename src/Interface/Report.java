package Interface;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;

import Core.Student;
import System.App;

import javax.swing.JFileChooser;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import javax.swing.JTextArea; 

public class Report {

<<<<<<< HEAD
	private JFrame frame;
=======
	private JFrame frmSixthFormApplication;
>>>>>>> working
	private JTextField txtStudent;
	private static App app;
	private MainScreen mainscreen;
	private JTextField txtStudentName;
	private JTextField subjectNameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report window = new Report();
					window.frmSixthFormApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Report() {
		//this.app = app;
		initialize();
		frmSixthFormApplication.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSixthFormApplication = new JFrame();
		frmSixthFormApplication.setTitle("Sixth Form Application Processing System");
		frmSixthFormApplication.setIconImage(Toolkit.getDefaultToolkit().getImage(Report.class.getResource("/img/saps-logo.png")));
		frmSixthFormApplication.setAlwaysOnTop(true);
		frmSixthFormApplication.setResizable(false);
		frmSixthFormApplication.getContentPane().setBackground(SystemColor.textHighlight);
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frmSixthFormApplication.setBounds(0, 0,screen.width,screen.height - 30);
		frmSixthFormApplication.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SAPS");
		lblNewLabel.setBounds(0, 0, 209, 79);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Rage Italic", Font.BOLD, 35));
		frmSixthFormApplication.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.text);
		tabbedPane.setBounds(0,90,1366,756);
		tabbedPane.setFont(new Font("Agency FB", Font.PLAIN, 11));
<<<<<<< HEAD
		frame.getContentPane().add(tabbedPane);
=======
		frmSixthFormApplication.getContentPane().add(tabbedPane);
>>>>>>> working
		tabbedPane.setFont(new Font("Agency FB", Font.PLAIN, 11));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Class Report", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Select class to view from the list:");
		lblNewLabel_2.setFont(new Font("Agency FB", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(405, 91, 191, 38);
		panel_1.add(lblNewLabel_2);
		
		//Search by Subject Area
				JPanel panel_4 = new JPanel();
				panel_4.setBounds(257, 224, 768, 375);
				panel_1.add(panel_4);
				SpringLayout sl_panel_4 = new SpringLayout();
				panel_4.setLayout(sl_panel_4);
				
				JLabel lblSubject = new JLabel("Subject: ");
				sl_panel_4.putConstraint(SpringLayout.NORTH, lblSubject, 10, SpringLayout.NORTH, panel_4);
				sl_panel_4.putConstraint(SpringLayout.WEST, lblSubject, 10, SpringLayout.WEST, panel_4);
				panel_4.add(lblSubject);
				
				subjectNameField = new JTextField();
				sl_panel_4.putConstraint(SpringLayout.NORTH, subjectNameField, 10, SpringLayout.NORTH, panel_4);
				sl_panel_4.putConstraint(SpringLayout.WEST, subjectNameField, 6, SpringLayout.EAST, lblSubject);
				sl_panel_4.putConstraint(SpringLayout.EAST, subjectNameField, 436, SpringLayout.EAST, lblSubject);
				panel_4.add(subjectNameField);
				subjectNameField.setColumns(10);
				
				JLabel lblAcceptedStudents = new JLabel("Accepted Students");
				sl_panel_4.putConstraint(SpringLayout.NORTH, lblAcceptedStudents, 21, SpringLayout.SOUTH, subjectNameField);
				sl_panel_4.putConstraint(SpringLayout.WEST, lblAcceptedStudents, 0, SpringLayout.WEST, lblSubject);
				panel_4.add(lblAcceptedStudents);
				
				JTextArea acceptedStudentsArea = new JTextArea();
<<<<<<< HEAD
=======
				acceptedStudentsArea.setEditable(false);
>>>>>>> working
				sl_panel_4.putConstraint(SpringLayout.NORTH, acceptedStudentsArea, 6, SpringLayout.SOUTH, lblAcceptedStudents);
				sl_panel_4.putConstraint(SpringLayout.WEST, acceptedStudentsArea, 0, SpringLayout.WEST, lblSubject);
				sl_panel_4.putConstraint(SpringLayout.EAST, acceptedStudentsArea, 202, SpringLayout.WEST, lblSubject);
				panel_4.add(acceptedStudentsArea);
				
				JLabel lblConflictingStudents = new JLabel("Conflicting Students");
				sl_panel_4.putConstraint(SpringLayout.NORTH, lblConflictingStudents, 0, SpringLayout.NORTH, lblAcceptedStudents);
				sl_panel_4.putConstraint(SpringLayout.WEST, lblConflictingStudents, 130, SpringLayout.EAST, lblAcceptedStudents);
				panel_4.add(lblConflictingStudents);
				
				JLabel lblAlternativeStudents = new JLabel("Alternative Students");
				sl_panel_4.putConstraint(SpringLayout.NORTH, lblAlternativeStudents, 0, SpringLayout.NORTH, lblAcceptedStudents);
				sl_panel_4.putConstraint(SpringLayout.WEST, lblAlternativeStudents, 144, SpringLayout.EAST, lblConflictingStudents);
				panel_4.add(lblAlternativeStudents);
				
				
				JTextArea conflictingStudentsArea = new JTextArea();
				sl_panel_4.putConstraint(SpringLayout.NORTH, conflictingStudentsArea, 3, SpringLayout.SOUTH, lblConflictingStudents);
				sl_panel_4.putConstraint(SpringLayout.WEST, conflictingStudentsArea, 19, SpringLayout.EAST, acceptedStudentsArea);
				sl_panel_4.putConstraint(SpringLayout.EAST, conflictingStudentsArea, 221, SpringLayout.EAST, acceptedStudentsArea);
				panel_4.add(conflictingStudentsArea);
				
				JTextArea alternativeStudentsArea = new JTextArea();
				sl_panel_4.putConstraint(SpringLayout.NORTH, alternativeStudentsArea, 6, SpringLayout.SOUTH, lblAlternativeStudents);
				sl_panel_4.putConstraint(SpringLayout.WEST, alternativeStudentsArea, 38, SpringLayout.EAST, conflictingStudentsArea);
				sl_panel_4.putConstraint(SpringLayout.EAST, alternativeStudentsArea, 240, SpringLayout.EAST, conflictingStudentsArea);
				panel_4.add(alternativeStudentsArea);
				//End search by students area
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JLabel lbl_combo_selection = new JLabel("");
				lbl_combo_selection.setHorizontalAlignment(SwingConstants.CENTER);
				lbl_combo_selection.setFont(new Font("Agency FB", Font.BOLD, 23));
				lbl_combo_selection.setBounds(507, 225, 232, 31);
				panel_1.add(lbl_combo_selection);
				
				String value=(String)comboBox.getSelectedItem();
				
				if (value.equals(comboBox.getSelectedItem())){
					String accepted = "James Hardy\n John Brown\n Daniel Dawson\n Karishma Mirpuri", conflicts ="Sajay Bailey-Management", alternatives="Ricardo Anderson\n Topaz Grant\n Patrice Ewin\n Carla Brown";
					lbl_combo_selection.setText(value);
					
					subjectNameField.setText(null);
					acceptedStudentsArea.setText(null);
					conflictingStudentsArea.setText(null);
					alternativeStudentsArea.setText(null);
					
					subjectNameField.setText(value);
					acceptedStudentsArea.append(accepted);
					conflictingStudentsArea.append(conflicts);
					alternativeStudentsArea.append(alternatives);
					
					value = null;
					
				}
			}
		});
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Agency FB", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "Chemistry", "Pure Mathematics", "Add Mathematics", "Biology", "Physics", "Computer Science"}));
		comboBox.setBounds(628, 91, 241, 38);
		panel_1.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		tabbedPane.addTab("Student Report", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Search for a student by full name:");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(244, 101, 194, 32);
		panel.add(lblNewLabel_1);
		
		//Results Panel Area
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(244, 200, 770, 213);
		panel.add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JLabel lblName = new JLabel("Name: ");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblName, 13, SpringLayout.NORTH, panel_2);
		panel_2.add(lblName);
		
		txtStudentName = new JTextField();
		sl_panel_2.putConstraint(SpringLayout.EAST, lblName, -31, SpringLayout.WEST, txtStudentName);
		sl_panel_2.putConstraint(SpringLayout.NORTH, txtStudentName, -3, SpringLayout.NORTH, lblName);
		sl_panel_2.putConstraint(SpringLayout.WEST, txtStudentName, 75, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, txtStudentName, -28, SpringLayout.EAST, panel_2);
		panel_2.add(txtStudentName);
		txtStudentName.setColumns(10);
		
		JLabel lblAccepted = new JLabel("Accepted:");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblAccepted, 15, SpringLayout.SOUTH, lblName);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblAccepted, 0, SpringLayout.WEST, lblName);
		panel_2.add(lblAccepted);
		
		JTextArea acceptedTxtArea = new JTextArea();
		sl_panel_2.putConstraint(SpringLayout.NORTH, acceptedTxtArea, 0, SpringLayout.NORTH, lblAccepted);
		sl_panel_2.putConstraint(SpringLayout.WEST, acceptedTxtArea, 6, SpringLayout.EAST, lblAccepted);
		acceptedTxtArea.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_2.add(acceptedTxtArea);
		
		JLabel lblConflicting = new JLabel("Conflicting:");
		sl_panel_2.putConstraint(SpringLayout.EAST, lblConflicting, -467, SpringLayout.EAST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, acceptedTxtArea, -16, SpringLayout.WEST, lblConflicting);
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblConflicting, 0, SpringLayout.NORTH, lblAccepted);
		panel_2.add(lblConflicting);
		
		JLabel lblAlternative = new JLabel("Alternative:");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblAlternative, 0, SpringLayout.NORTH, lblAccepted);
		sl_panel_2.putConstraint(SpringLayout.EAST, lblAlternative, -191, SpringLayout.EAST, panel_2);
		panel_2.add(lblAlternative);
		
		JTextArea conflictingTxtArea = new JTextArea();
		sl_panel_2.putConstraint(SpringLayout.NORTH, conflictingTxtArea, 0, SpringLayout.NORTH, acceptedTxtArea);
		sl_panel_2.putConstraint(SpringLayout.WEST, conflictingTxtArea, 6, SpringLayout.EAST, lblConflicting);
		sl_panel_2.putConstraint(SpringLayout.EAST, conflictingTxtArea, -27, SpringLayout.WEST, lblAlternative);
		panel_2.add(conflictingTxtArea);
		
		JTextArea alternativeTxtArea = new JTextArea();
		sl_panel_2.putConstraint(SpringLayout.NORTH, alternativeTxtArea, 0, SpringLayout.NORTH, acceptedTxtArea);
		sl_panel_2.putConstraint(SpringLayout.WEST, alternativeTxtArea, 6, SpringLayout.EAST, lblAlternative);
		sl_panel_2.putConstraint(SpringLayout.EAST, alternativeTxtArea, -2, SpringLayout.EAST, txtStudentName);
		panel_2.add(alternativeTxtArea);
		//End Results Panel Area
		
		//All students panel area
		JPanel panel_3 = new JPanel();
		panel_3.setVisible(false);
		panel_3.setBounds(244, 200, 770, 213);
		panel.add(panel_3);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		JTextArea allStudentsTxtArea = new JTextArea();
		sl_panel_3.putConstraint(SpringLayout.NORTH, allStudentsTxtArea, 35, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, allStudentsTxtArea, 42, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, allStudentsTxtArea, -52, SpringLayout.EAST, panel_3);
		panel_3.add(allStudentsTxtArea);
		//close all students panel area
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String accepted = "", conflicts="", alternate="";
				
				panel_3.setVisible(false);
				allStudentsTxtArea.setText(null);
				
				if(txtStudent.getText().equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "Enter a name to search!!", "Dialog",
					        JOptionPane.ERROR_MESSAGE);
				}
				else {
					panel_2.setVisible(true);
					txtStudentName.setText("");
					acceptedTxtArea.setText(null);
					conflictingTxtArea.setText(null);
					alternativeTxtArea.setText(null);
					
					Student student = app.searchStudents(txtStudentName.getText());
					
					ArrayList<String> acceptedSubjects = student.getAccepted();
					ArrayList<String> conflictingSubjects = student.getConflicts();
					ArrayList<String> alternateSubjects = student.getAlternates();
					
					for(String str : acceptedSubjects) {
						accepted.concat(str+" ");
					}
					
					for(String str : conflictingSubjects) {
						conflicts.concat(str+" ");
					}
					
					for(String str : alternateSubjects) {
						alternate.concat(str+" ");	
					}
					
					txtStudentName.setText("Daniel Dawson");
					acceptedTxtArea.append(accepted);
					conflictingTxtArea.append(conflicts);
					alternativeTxtArea.append(alternate);
				}
			}
		});
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 18));
		btnNewButton.setBounds(751, 101, 89, 32);
		panel.add(btnNewButton);
		

		JButton btnViewAllStudents = new JButton("View all students");
		btnViewAllStudents.setForeground(SystemColor.text);
		btnViewAllStudents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//viewAllStudents(scrollPane);
				panel_2.setVisible(false);
				txtStudentName.setText("");
				acceptedTxtArea.setText(null);
				conflictingTxtArea.setText(null);
				alternativeTxtArea.setText(null);
				
				panel_3.setVisible(true);
				allStudentsTxtArea.setText(null);
				
				ArrayList<Student> students = app.getStudents(); 
				
				for(Student stu : students) {
					String subjects = "";
					ArrayList<String> classes = stu.getAccepted();
					for(String str : classes) {
						subjects.concat(str + " ");
					}
					JLabel student_info = new JLabel(stu.getFullName()+ " | " + subjects);
					student_info.setFont(new Font("Agency FB", Font.PLAIN, 18));
					student_info.setBounds(244, 101, 194, 32);
					allStudentsTxtArea.add(student_info);
				}
				
				for(int i =0; i<10; i++) {
					allStudentsTxtArea.append(" Yohan Brown: Mathematics, Computer Science, Physics, Communication Studies, Pure Science\n");
				}
			}
		});
		btnViewAllStudents.setBackground(SystemColor.textHighlight);
		btnViewAllStudents.setFont(new Font("Agency FB", Font.BOLD, 18));
		btnViewAllStudents.setBounds(857, 101, 157, 32);
		panel.add(btnViewAllStudents);
		
		txtStudent = new JTextField();
		txtStudent.setFont(new Font("Agency FB", Font.PLAIN, 18));
		txtStudent.setBounds(444, 101, 297, 32);
		panel.add(txtStudent);
		txtStudent.setColumns(10);
		
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setForeground(SystemColor.textHighlight);
		btnNewButton_1.setBackground(SystemColor.text);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
<<<<<<< HEAD
				frame.dispose();
=======
				frmSixthFormApplication.dispose();
>>>>>>> working
				//Login exit = new Login(app);
				Login.main(null);
				
				
			}
			
		});
		btnNewButton_1.setBounds(1258, 55, 82, 32);
		frmSixthFormApplication.getContentPane().add(btnNewButton_1);
		
		JButton btnHome = new JButton("Home");
		btnHome.setForeground(SystemColor.textHighlight);
		btnHome.setBackground(SystemColor.text);
		btnHome.setBounds(1167, 55, 82, 32);
		frmSixthFormApplication.getContentPane().add(btnHome);
		frmSixthFormApplication.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

<<<<<<< HEAD
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
	
=======
	}	
>>>>>>> working
	
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}