package Interface;

import java.awt.EventQueue;
import System.*;
import Core.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
//import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class MainReport {

	private JFrame rpFrame;
	private JTable table_1;
	private JTextField textField;
	private App controller;
	private JScrollPane scrollPane;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Object[][] data = {
							{"Mary", "Campione", 
							"Snowboarding", new Integer(5), new Boolean(false), new Integer(12), new Integer(100)},
							{"Alison", "Huml", 
							"Rowing", new Integer(3), new Boolean(true), new Integer(12), new Integer(100)},
							{"Kathy", "Walrath",
							"Chasing toddlers", new Integer(2), new Boolean(false), new Integer(12), new Integer(100)},
							{"Mark", "Andrews",
							"Speed reading", new Integer(20), new Boolean(true), new Integer(12), new Integer(100)},
							{"Angela", "Lih",
							"Teaching high school", new Integer(4), new Boolean(false), new Integer(12), new Integer(100)}
							};
					MainReport window = new MainReport(new MainScreen(), data);
					window.rpFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainReport(MainScreen parent, Object[][] rowData) {
		initialize(rowData);
		this.controller = parent.getController();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void updateTable(Object[][] row, Object[] col) {
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(row,col) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(150);
		table_1.getColumnModel().getColumn(0).setMinWidth(150);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(95);
		table_1.getColumnModel().getColumn(1).setMinWidth(95);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(107);
		table_1.getColumnModel().getColumn(2).setMinWidth(95);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(95);
		table_1.getColumnModel().getColumn(3).setMinWidth(95);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(65);
		table_1.getColumnModel().getColumn(4).setMinWidth(65);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(200);
		table_1.getColumnModel().getColumn(5).setMinWidth(200);
		table_1.setShowVerticalLines(false);
		table_1.setShowHorizontalLines(false);
		table_1.setBorder(null);
		table_1.setFillsViewportHeight(true);
		table_1.setForeground(new Color(0, 0, 0));
		table_1.setFont(new Font("Corbel", Font.PLAIN, 14));
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setBackground(new Color(255, 255, 255));
		panel.remove(scrollPane);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(1, 109, 685, 257);
		scrollPane.add(table_1);
		scrollPane.setViewportView(table_1);
		panel.add(scrollPane);
		panel.repaint();
	}
	
	private void initialize(Object[][] rData) {
		rpFrame = new JFrame();
		rpFrame.setBounds(100, 100, 759, 472);
		rpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		String[] columnNames = {"Name", "Class Maximum", "Met Requirements", "Applied", "Accepted", "Pending", "Rejected"}; 
		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(486, 33, 169, 20);
		panel.add(textField);
		textField.setColumns(10);
		rpFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			}
		});
		rpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rpFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainReport.class.getResource("/img/saps-logo.png")));
		rpFrame.setResizable(false);
		rpFrame.setTitle("SAPS");
		rpFrame.getContentPane().add(panel, BorderLayout.CENTER);
	
	/**
		Object[][] rowData = {
				{"Mary", "Campione", 
				"Snowboarding", new Integer(5), new Boolean(false), new Integer(12), new Integer(100)},
				{"Alison", "Huml", 
				"Rowing", new Integer(3), new Boolean(true), new Integer(12), new Integer(100)},
				{"Kathy", "Walrath",
				"Chasing toddlers", new Integer(2), new Boolean(false), new Integer(12), new Integer(100)},
				{"Mark", "Andrews",
				"Speed reading", new Integer(20), new Boolean(true), new Integer(12), new Integer(100)},
				{"Angela", "Lih",
				"Teaching high school", new Integer(4), new Boolean(false), new Integer(12), new Integer(100)}
				};**/
		table_1 = new JTable(rData, columnNames);
		


		table_1.setModel(new DefaultTableModel(
			rData,
			new String[] {
				"Name", "Class Maximum", "Met Requirements", "Applied", "Accepted", "Pending", "Rejected"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(117);
		table_1.getColumnModel().getColumn(0).setMinWidth(117);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(95);
		table_1.getColumnModel().getColumn(1).setMinWidth(95);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(107);
		table_1.getColumnModel().getColumn(2).setMinWidth(107);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(61);
		table_1.getColumnModel().getColumn(3).setMinWidth(50);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(61);
		table_1.getColumnModel().getColumn(4).setMinWidth(60);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(60);
		table_1.getColumnModel().getColumn(5).setMinWidth(60);
		table_1.getColumnModel().getColumn(6).setPreferredWidth(60);
		table_1.getColumnModel().getColumn(6).setMinWidth(60);
		table_1.setShowVerticalLines(false);
		table_1.setShowHorizontalLines(false);
		table_1.setBorder(null);
		table_1.setFillsViewportHeight(true);
		table_1.setForeground(new Color(0, 0, 0));
		table_1.setFont(new Font("Corbel", Font.PLAIN, 14));
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setBackground(new Color(255, 255, 255));
		scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(1, 109, 685, 257);
		panel.add(scrollPane);
		
		
		JRadioButton rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setToolTipText("Search By Student Name Eg. \"John Brown\"");
		rdbtnStudent.setForeground(new Color(255, 255, 255));
		rdbtnStudent.setBackground(new Color(0, 128, 128));
		rdbtnStudent.setSelected(true);
		rdbtnStudent.setBounds(496, 60, 63, 23);
		panel.add(rdbtnStudent);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Subject");
		rdbtnNewRadioButton.setToolTipText("Search by subject name. Eg. \"Pure Mathematics\"");
		rdbtnNewRadioButton.setBackground(new Color(0, 128, 128));
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBounds(569, 60, 61, 23);
		panel.add(rdbtnNewRadioButton);
		
		JLabel lblEnterName = new JLabel("Enter Name:");
		lblEnterName.setFont(new Font("Corbel", Font.PLAIN, 17));
		lblEnterName.setForeground(new Color(255, 255, 255));
		lblEnterName.setLabelFor(textField);
		lblEnterName.setBounds(392, 33, 98, 20);
		panel.add(lblEnterName);
		
		JLabel lblSaps = new JLabel("SAPS Report");
		lblSaps.setForeground(new Color(255, 255, 255));
		lblSaps.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaps.setFont(new Font("Calisto MT", Font.PLAIN, 33));
		lblSaps.setBounds(10, -4, 210, 79);
		panel.add(lblSaps);
		rpFrame.setSize(692,460);
		rpFrame.setVisible(true);
		
		
		
		
		table_1.addMouseListener(new java.awt.event.MouseAdapter()  {
			 public void mouseClicked(java.awt.event.MouseEvent e)
			 {
				 int row=table_1.rowAtPoint(e.getPoint());
				 //int col= table.columnAtPoint(e.getPoint());
				 //JOptionPane.showMessageDialog(null,” Value in the cell clicked :”+ ” ” +table.getValueAt(row,col).toString());
				 System.out.println(row);
				 String name = table_1.getValueAt(row,0).toString();
				 CAPE c = controller.searchSubjects(name.toLowerCase());
				 System.out.println(name);
				 if (c != null) {
					 System.out.println(c);
					 List<Object[]> info = new ArrayList<Object[]>();
					 for (Student s : c.getAcceptedStudents()) {
						 Map<String, Integer> preInfo = s.getPreReqInfo(c);
						 String pGrade = (preInfo.get("primary")).toString();
						 String sGrade = (preInfo.get("secondary")).toString();
						 String tGrade= (preInfo.get("tertiary")).toString();
						 Object [] temp = {s.toString(), pGrade, sGrade, tGrade, "Accepted", "Because I said so"};
						 info.add(temp);
						}
						Object[][] data = new Object[info.size()][];
						data = info.toArray(data);
						String[] col = {
								"Student", c.getPrimary(), c.getSecondary(), c.getTertiary(), "Status", "Reason"
							};
						updateTable(data, col);
				 }
				 else {
					 Student s = controller.searchStudents(name.toLowerCase());
					 if (s != null) {
						 List<Object[]> info = new ArrayList<Object[]>();
						 for (CAPE ca : s.getAcceptedFor()) {
							 Object [] temp = {ca.toString(), "Accepted", "No Reason Added as Yet"};
							 info.add(temp);
							}
						 for (CAPE ca : s.getAlternateSubs()) {
							 Object [] temp = {ca.toString(), "Pending", "Alternate Student"};
							 info.add(temp);
							}
						 for (CAPE ca : s.getConflictsSubs()) {
							 Object [] temp = {ca.toString(), "Pending", "Has AntiRequisite"};
							 info.add(temp);
							}
							Object[][] data = new Object[info.size()][];
							data = info.toArray(data);
							String[] col = {
									"Course", "Status", "Reason"};
							updateTable(data, col);
						 
					 }
				 }
				 
				 //System.out.println(” Value in the cell clicked :”+ ” ” +table.getValueAt(row,col).toString());
				 }
			 }
		 );
		
	}
	
	
}
