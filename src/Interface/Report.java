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
import javax.swing.border.LineBorder;

import Core.Student;
import Core.CAPE;
import System.App;

import java.util.ArrayList;

import java.awt.Component;
import javax.swing.JTextArea;

public class Report {

	private JFrame frmSixthFormApplication;
	private JTextField txtStudent;
	private App controller;
	private MainScreen parent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report window = new Report(new MainScreen());
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
	
	
	public Report(MainScreen parent) {
		//this.controller = controller;
		initialize();
		this.parent = parent;
		this.controller = parent.getController();
		frmSixthFormApplication.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSixthFormApplication = new JFrame();
		frmSixthFormApplication.setTitle("Sixth Form Application Processing System");
		frmSixthFormApplication.setResizable(false);
		frmSixthFormApplication.getContentPane().setBackground(new Color(0, 139, 139));
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frmSixthFormApplication.setBounds(0, 0,797,611);
		frmSixthFormApplication.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SAPS");
		lblNewLabel.setBounds(0, 0, 112, 68);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Rage Italic", Font.BOLD, 35));
		frmSixthFormApplication.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.text);
		tabbedPane.setBounds(0,91,791,756);
		tabbedPane.setFont(new Font("Agency FB", Font.PLAIN, 11));
		frmSixthFormApplication.getContentPane().add(tabbedPane);
		tabbedPane.setFont(new Font("Agency FB", Font.PLAIN, 11));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Class Report", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Select class to view from the list:");
		lblNewLabel_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_2.setFont(new Font("Corbel", Font.BOLD, 18));
		lblNewLabel_2.setBounds(49, 120, 191, 38);
		panel_1.add(lblNewLabel_2);
		
		//Search by Subject Area
				JPanel panel_4 = new JPanel();
				panel_4.setBorder(new LineBorder(new Color(0, 139, 139)));
				panel_4.setForeground(Color.WHITE);
				panel_4.setBackground(new Color(255, 255, 255));
				panel_4.setBounds(312, 0, 470, 460);
				panel_1.add(panel_4);
				panel_4.setLayout(null);
				
				JLabel lblSubject = new JLabel("Subject: ");
				lblSubject.setBounds(19, 11, 447, 39);
				lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
				lblSubject.setFont(new Font("Corbel", Font.BOLD, 30));
				lblSubject.setForeground(new Color(0, 139, 139));
				panel_4.add(lblSubject);
				
				JLabel lblAcceptedStudents = new JLabel("Accepted Students");
				lblAcceptedStudents.setBounds(19, 75, 131, 17);
				lblAcceptedStudents.setFont(new Font("Corbel", Font.BOLD, 14));
				lblAcceptedStudents.setForeground(new Color(0, 0, 0));
				panel_4.add(lblAcceptedStudents);
				
				JTextArea acceptedStudentsArea = new JTextArea();
				acceptedStudentsArea.setEditable(false);
				acceptedStudentsArea.setBounds(19, 103, 441, 87);
				panel_4.add(acceptedStudentsArea);
				
				JLabel lblConflictingStudents = new JLabel("Conflicting Students");
				lblConflictingStudents.setBounds(19, 201, 131, 17);
				lblConflictingStudents.setFont(new Font("Corbel", Font.BOLD, 14));
				lblConflictingStudents.setForeground(new Color(0, 0, 0));
				panel_4.add(lblConflictingStudents);
				
				JLabel lblAlternativeStudents = new JLabel("Alternative Students");
				lblAlternativeStudents.setBounds(19, 329, 131, 17);
				lblAlternativeStudents.setFont(new Font("Corbel", Font.BOLD, 14));
				lblAlternativeStudents.setForeground(new Color(0, 0, 0));
				panel_4.add(lblAlternativeStudents);
				
				
				JTextArea conflictingStudentsArea = new JTextArea();
				conflictingStudentsArea.setEditable(false);
				conflictingStudentsArea.setBounds(19, 229, 441, 89);
				panel_4.add(conflictingStudentsArea);
				
				JTextArea alternativeStudentsArea = new JTextArea();
				alternativeStudentsArea.setEditable(false);
				alternativeStudentsArea.setBounds(19, 357, 441, 91);
				panel_4.add(alternativeStudentsArea);
				//End search by students area
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setForeground(new Color(0, 128, 128));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JLabel lbl_combo_selection = new JLabel("");
				lbl_combo_selection.setHorizontalAlignment(SwingConstants.CENTER);
				lbl_combo_selection.setFont(new Font("Agency FB", Font.BOLD, 23));
				lbl_combo_selection.setBounds(507, 225, 232, 31);
				panel_1.add(lbl_combo_selection);
				
				String value=(String)comboBox.getSelectedItem();
				
				if (value.equals(comboBox.getSelectedItem())){
					String accepted_students = "", conflicting_students="", alternate_students="";
					lbl_combo_selection.setText(value);
					
					lblSubject.setText(null);
					acceptedStudentsArea.setText(null);
					conflictingStudentsArea.setText(null);
					alternativeStudentsArea.setText(null);
					
					
					CAPE cape = controller.searchSubjects(value.toUpperCase());
					ArrayList<String> acceptedStudents = null, conflictingStudents = null, alternateStudents = null;
					try{
						acceptedStudents = cape.getAccepted();
						conflictingStudents = cape.getConflicts();
						alternateStudents = cape.getAlternates();
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(new JFrame(), "No class data found", "Dialog",
						        JOptionPane.ERROR_MESSAGE);
					}
					
					
					
					if(acceptedStudents != null) {
						for(String str : acceptedStudents) {
							accepted_students.concat(str+"\n ");
						}
					}
					
					if(conflictingStudents != null) {
						for(String str : conflictingStudents) {
							conflicting_students.concat(str+"\n ");
						}
					}
						
					if(alternateStudents != null) {
						for(String str : alternateStudents) {
							alternate_students.concat(str+"\n ");	
						}
					}
					
					lblSubject.setText(value);
					acceptedStudentsArea.append(accepted_students);
					conflictingStudentsArea.append(conflicting_students);
					alternativeStudentsArea.append(alternate_students);
					
					value = null;
					
				}
			}
		});
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Corbel", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"None", "ACCOUNTING", "ANIMATION & GAME DESIGN", "AGRICULTURAL SCIENCE", "APPLIED MATHEMATICS", "ART AND DESIGN", "BIOLOGY", "BUILDING AND MECHANICAL ENGINEERING DRAWING", "CARIBBEAN STUDIES", "CHEMISTRY", "COMMUNICATION STUDIES", "COMPUTER SCIENCE", "DIGITAL MEDIA", "ELECTRICAL AND ELECTRONIC ENGINEERING TECHNOLOGY", "ECONOMICS", "ENTREPRENEURSHIP", "ENVIRONMENTAL SCIENCE", "FINANCIAL SERVICES STUDIES", "FOOD AND NUTRITION", "FRENCH", "GEOGRAPHY", "GREEN ENGINEERING", "HISTORY", "INFORMATION TECHNOLOGY", "INTEGRATED MATHEMATICS", "LAW", "LITERATURES IN ENGLISH", "LOGISTICS AND SUPPLY CHAIN OPERATIONS", 
				"MANAGEMENT OF BUSINESS", "PERFORMING ARTS", "PHYSICS", "PHYSICAL EDUCATION AND SPORT", "PURE MATHEMATICS", "SOCIOLOGY", "SPANISH", "TOURISM"}));
		comboBox.setBounds(22, 149, 241, 38);
		panel_1.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		tabbedPane.addTab("Student Report", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Search for a student by full name:");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Corbel", Font.BOLD, 18));
		lblNewLabel_1.setBounds(58, 60, 194, 32);
		panel.add(lblNewLabel_1);
		
		//Results Panel Area
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 128, 128)));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(312, 0, 472, 462);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(19, 11, 447, 39);
		lblName.setForeground(new Color(0, 128, 128));
		lblName.setFont(new Font("Corbel", Font.BOLD, 30));
		panel_2.add(lblName);
		
		JLabel lblAccepted = new JLabel("Accepted:");
		lblAccepted.setBounds(19, 75, 60, 17);
		lblAccepted.setForeground(new Color(0, 0, 0));
		lblAccepted.setFont(new Font("Corbel", Font.BOLD, 14));
		panel_2.add(lblAccepted);
		
		JTextArea conflictingTxtArea = new JTextArea();
		conflictingTxtArea.setEditable(false);
		conflictingTxtArea.setBounds(19, 229, 441, 89);
		panel_2.add(conflictingTxtArea);
		
		JTextArea acceptedTxtArea = new JTextArea();
		acceptedTxtArea.setEditable(false);
		acceptedTxtArea.setBounds(19, 103, 441, 87);
		acceptedTxtArea.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_2.add(acceptedTxtArea);
		
		JLabel lblConflicting = new JLabel("Conflicting:");
		lblConflicting.setBounds(19, 201, 70, 17);
		lblConflicting.setForeground(new Color(0, 0, 0));
		lblConflicting.setFont(new Font("Corbel", Font.BOLD, 14));
		panel_2.add(lblConflicting);
		
		JTextArea alternativeTxtArea = new JTextArea();
		alternativeTxtArea.setEditable(false);
		alternativeTxtArea.setBounds(19, 357, 441, 91);
		panel_2.add(alternativeTxtArea);
		
		JLabel lblAlternative = new JLabel("Alternative:");
		lblAlternative.setBounds(19, 329, 71, 17);
		lblAlternative.setForeground(new Color(0, 0, 0));
		lblAlternative.setFont(new Font("Corbel", Font.BOLD, 14));
		panel_2.add(lblAlternative);
		//close all students panel area
		
		//All students panel area
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(312, 0, 470, 460);
		panel.add(panel_3);
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new LineBorder(new Color(0, 139, 139)));
		panel_3.setLayout(null);
				
		JLabel lblAllStudentsResults = new JLabel("All Students Results");
		lblAllStudentsResults.setForeground(new Color(0, 128, 128));
		lblAllStudentsResults.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllStudentsResults.setFont(new Font("Corbel", Font.BOLD, 30));
		lblAllStudentsResults.setBounds(19, 11, 447, 39);
		panel_3.add(lblAllStudentsResults);
				
		JTextArea allStudentsTxtArea = new JTextArea();
		allStudentsTxtArea.setEditable(false);
		allStudentsTxtArea.setBounds(19, 80, 447, 350);
		panel_3.add(allStudentsTxtArea);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setBackground(new Color(220, 220, 220));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String accepted = "", conflicts="", alternate="";
				
				panel_3.setVisible(false);
				allStudentsTxtArea.setText(null);
				
				if(txtStudent.getText().equals("")) {
					panel_2.setVisible(true);
					lblName.setText("Name: ");
					JOptionPane.showMessageDialog(new JFrame(), "Enter a name to search!!", "Dialog",
					        JOptionPane.ERROR_MESSAGE);
				}
				else {
					panel_2.setVisible(true);
					lblName.setText("");
					acceptedTxtArea.setText(null);
					conflictingTxtArea.setText(null);
					alternativeTxtArea.setText(null);
					
					Student student = controller.searchStudents(txtStudent.getText().toLowerCase());
					ArrayList<String> acceptedSubjects = null, conflictingSubjects = null, alternateSubjects = null;
					
					try {
						acceptedSubjects = student.getAccepted();
						conflictingSubjects = student.getConflicts();
						alternateSubjects = student.getAlternates();
					}
					catch(Exception e2) {
						JOptionPane.showMessageDialog(new JFrame(), "No students data found", "Dialog",
						        JOptionPane.ERROR_MESSAGE);
					}
					
					if(acceptedSubjects != null) {
						for(String str : acceptedSubjects) {
							accepted.concat(str+"\n ");
						}
					}
					
					if(acceptedSubjects != null) {
						for(String str : conflictingSubjects) {
							conflicts.concat(str+"\n ");
						}
					}
					
					if(alternateSubjects != null) {
						for(String str : acceptedSubjects) {
							alternate.concat(str+"\n ");
						}
					}
					
					lblName.setText(txtStudent.getText());
					acceptedTxtArea.append(accepted);
					conflictingTxtArea.append(conflicts);
					alternativeTxtArea.append(alternate);
				}
			}
		});
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 18));
		btnNewButton.setBounds(26, 133, 89, 32);
		panel.add(btnNewButton);
		

		JButton btnViewAllStudents = new JButton("View all students");
		btnViewAllStudents.setForeground(new Color(0, 128, 128));
		btnViewAllStudents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//viewAllStudents(scrollPane);
				panel_2.setVisible(false);
				lblName.setText("");
				acceptedTxtArea.setText(null);
				conflictingTxtArea.setText(null);
				alternativeTxtArea.setText(null);
				
				panel_3.setVisible(true);
				allStudentsTxtArea.setText(null);
				
				ArrayList<Student> students = null;
				try {
					students = controller.getStudents(); 
				}
				catch(Exception e3) {
					JOptionPane.showMessageDialog(new JFrame(), "Students data not found", "Dialog",
					        JOptionPane.ERROR_MESSAGE);
				}
				
				if(students != null) {
					for(Student stu : students) {
						String subjects = "";
						ArrayList<String> classes = null;
						classes = stu.getAccepted();
						if(classes != null) {
							for(String str : classes) {
								subjects.concat(str + " ");
							}
						}
						String student_info = "";
						student_info = stu.getFullName()+ " | " + subjects +"\n ";
						allStudentsTxtArea.append(student_info);
					}
				}
			}
		});
		btnViewAllStudents.setBackground(new Color(220, 220, 220));
		btnViewAllStudents.setFont(new Font("Agency FB", Font.BOLD, 18));
		btnViewAllStudents.setBounds(125, 133, 157, 32);
		panel.add(btnViewAllStudents);
		
		txtStudent = new JTextField();
		txtStudent.setFont(new Font("Corbel", Font.BOLD, 18));
		txtStudent.setBounds(26, 90, 256, 32);
		panel.add(txtStudent);
		txtStudent.setColumns(10);
		//End Results Panel Area
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setForeground(new Color(0, 139, 139));
		btnNewButton_1.setBackground(SystemColor.text);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmSixthFormApplication.dispose();
				//Login exit = new Login(controller);
				Login.main(null);
				
				
			}
			
		});
		btnNewButton_1.setBounds(699, 11, 82, 32);
		frmSixthFormApplication.getContentPane().add(btnNewButton_1);
		
		JButton btnHome = new JButton("Home");
		btnHome.setForeground(new Color(0, 139, 139));
		btnHome.setBackground(new Color(255, 255, 255));
		btnHome.setBounds(600, 11, 82, 32);
		frmSixthFormApplication.getContentPane().add(btnHome);
		
		
		
		
		
		
		frmSixthFormApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
	
	
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}