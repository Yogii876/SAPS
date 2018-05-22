package Interface;

import java.awt.EventQueue;
import System.*;
import Core.*;

import javax.swing.ButtonGroup;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class MainReport {

	private JFrame rpFrame;
	private JTable table_1;
	private JTextField textField;
	private App controller;
	private JScrollPane scrollPane;
	private JPanel panel;
	private MainScreen parent;
	JLabel nameLbl;
	JLabel secLbl;
	Object[][] iRow;
	Object[] iCol;

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
	
	private void alignText(JTable tb) {
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tb.setDefaultRenderer(Object.class, centerRenderer);
		table_1.setShowVerticalLines(false);
		table_1.setShowHorizontalLines(false);
		table_1.setBorder(null);
		table_1.setFillsViewportHeight(true);
		table_1.setForeground(new Color(0, 0, 0));
		table_1.setFont(new Font("Corbel", Font.PLAIN, 14));
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setBackground(new Color(255, 255, 255));
		scrollPane = new JScrollPane(table_1);
		//scrollPane.add(table_1);
		scrollPane.setBounds(20, 103, 1174, 407);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_1.addMouseListener(new MouseAdapter()  {
			 public void mouseClicked(MouseEvent e)
			 {
				System.out.println("Went here");
				int row=table_1.rowAtPoint(e.getPoint());
				System.out.println("Didn't fail");
				int col= table_1.columnAtPoint(e.getPoint());
				String name = table_1.getValueAt(row,0).toString();
				String colName = (table_1.getColumnName(col)).toLowerCase();
				CAPE c = controller.searchSubjects(name.toLowerCase());
				System.out.println(name);
				if (c != null) {
					subSearched(c, colName);
				 }
				else {
					Student s = controller.searchStudents(name.toLowerCase());
					if (s != null) {
						searchedStud(s);
					 }
				 }
				}
			 }
		);
	}
	
	private void refreshPanel() {
		panel.revalidate();
		panel.repaint();
	}

	/**
	 * Create the application.
	 */
	public MainReport(MainScreen parent, Object[][] rowData) {
		initialize(rowData);
		this.parent = parent;
		this.controller = parent.getController();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void subSearched(CAPE c, String column) {
		 List<Object[]> info = new ArrayList<Object[]>();
		 Map<Student, StatusMsg> reasons = c.getReasons();
		 Set set = reasons.entrySet();
		 String[] colData = {};
		 boolean hasSec = c.getSecondary() != null;
		 boolean hasTer = c.getTertiary() != null;
		 if (hasTer) {
		     Iterator iterator = set.iterator();
		     while (iterator.hasNext()) {
		    	 Map.Entry ent = (Map.Entry) iterator.next();
				 Student s = (Student) ent.getKey();
				 StatusMsg msg = (StatusMsg) ent.getValue();
				 Map<String, String> preInfo = s.getPreReqInfo(c);
				 String pGrade = preInfo.get("primary");
				 String sGrade = preInfo.get("secondary");
				 String tGrade= preInfo.get("tertiary");
				 Object [] temp = {s.toString(), pGrade, sGrade, tGrade, Integer.toString(msg.getPoints()), msg.getStatus(), msg.getMsg()};
				 String[] col = { "Student", (c.getPrimary()).toUpperCase(), (c.getSecondary()).toUpperCase(), (c.getTertiary()).toUpperCase(), "Points", "Status", "Reason"
					};
				 colData = col;
				 info.add(temp);
				}
		 }
		 else if (hasSec) {
			 Iterator iterator = set.iterator();
		     while (iterator.hasNext()) {
		    	 Map.Entry ent = (Map.Entry) iterator.next();
				 Student s = (Student) ent.getKey();
				 StatusMsg msg = (StatusMsg) ent.getValue();
				 Map<String, String> preInfo = s.getPreReqInfo(c);
				 String pGrade = preInfo.get("primary");
				 String sGrade = preInfo.get("secondary");
				 Object [] temp = {s.toString(), pGrade, sGrade, Integer.toString(msg.getPoints()), msg.getStatus(), msg.getMsg()};
				 String[] col = { "Student", (c.getPrimary()).toUpperCase(), (c.getSecondary()).toUpperCase(), "Points", "Status", "Reason"
					};
				 colData = col;
				 info.add(temp);
			 }
		 }
		 else {
			 Iterator iterator = set.iterator();
		     while (iterator.hasNext()) {
		    	 Map.Entry ent = (Map.Entry) iterator.next();
				 Student s = (Student) ent.getKey();
				 StatusMsg msg = (StatusMsg) ent.getValue();
				 Map<String, String> preInfo = s.getPreReqInfo(c);
				 String pGrade = preInfo.get("primary");
				 Object [] temp = {s.toString(), pGrade, Integer.toString(msg.getPoints()), msg.getStatus(), msg.getMsg()};
				 String[] col = { "Student", (c.getPrimary()).toUpperCase(), "Points", "Status", "Reason"
					};
				 colData = col;
				 info.add(temp);
			 }
		 }
		Object[][] data = new Object[info.size()][];
		data = info.toArray(data);
		panel.remove(scrollPane);
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(data,colData) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		alignText(table_1);
		panel.remove(nameLbl);
		nameLbl = new JLabel("Cape " + (c.toString()).toUpperCase() + " Information");
		nameLbl.setForeground(Color.WHITE);
		nameLbl.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 26));
		nameLbl.setBounds(22, 43, 350, 36);
		panel.add(nameLbl);
		
		panel.remove(secLbl);
		if (c.getMax() != -1)	secLbl = new JLabel("Class Size: " + Integer.toString(c.getMax()));
		else secLbl = new JLabel("No Limit On Class Size");
		secLbl.setForeground(Color.WHITE);
		secLbl.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 13));
		secLbl.setBounds(20, 78, 404, 14);
		panel.add(secLbl);
		panel.add(scrollPane);
		refreshPanel();
	}
	
	private void searchedStud(Student s) {
		List<Object[]> info = new ArrayList<Object[]>();
		for (Map.Entry<CAPE, StatusMsg> rns : s.getReasons().entrySet()) {
			Object [] temp = {rns.getKey().toString(), rns.getValue().getStatus(), rns.getValue().getMsg()};
			info.add(temp);
			}
		Object[][] data = new Object[info.size()][];
		data = info.toArray(data);
		String[] col = {
				"Course", "Status", "Reason"};
		
		panel.remove(scrollPane);
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(data,col) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		alignText(table_1);
		panel.remove(nameLbl);
		nameLbl = new JLabel(s.toString());
		nameLbl.setForeground(Color.WHITE);
		nameLbl.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 26));
		nameLbl.setBounds(22, 43, 350, 36);
		panel.add(nameLbl);
		
		panel.remove(secLbl);
		String choices = "Choices: ";
		for (String ch: s.getChoices()) {
			choices = choices + ch + "   ";
		}
		secLbl = new JLabel(choices);
		secLbl.setForeground(Color.WHITE);
		secLbl.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 13));
		secLbl.setBounds(20, 78, 404, 14);
		panel.add(secLbl);
		panel.add(scrollPane);
		refreshPanel();
	}
		
	

	
	private void initialize(Object[][] rData) {
		rpFrame = new JFrame();
		rpFrame.setBounds(100, 100, 759, 472);
		rpFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		rpFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				controller.resetMappings();
				parent.setVisible(true);
				rpFrame.dispose();
			}
		});

		String[] columnNames = {"Name", "Applied", "Met Requirements", "Class Maximum", "Accepted", "Pending", "Rejected"}; 
		this.iRow = rData;
		this.iCol = columnNames;
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(0, 128, 128));
		panel.setLayout(null);
		
		rpFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainReport.class.getResource("/img/saps-logo.png")));
		rpFrame.setResizable(false);
		rpFrame.setTitle("SAPS");
		rpFrame.getContentPane().add(panel, BorderLayout.CENTER);
		JTable table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(rData,columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		table_1.setShowVerticalLines(false);
		table_1.setShowHorizontalLines(false);
		table_1.setBorder(null);
		table_1.setFillsViewportHeight(true);
		table_1.setForeground(new Color(0, 0, 0));
		table_1.setFont(new Font("Corbel", Font.PLAIN, 14));
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setBackground(new Color(255, 255, 255));

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table_1.setDefaultRenderer(Object.class, centerRenderer);
		scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(20, 103, 1174, 407);
		panel.add(scrollPane);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_1.addMouseListener(new MouseAdapter()  {
			 public void mouseClicked(MouseEvent e)
			 {
				try {
					int row=table_1.rowAtPoint(e.getPoint());
					int col= table_1.columnAtPoint(e.getPoint());
					String name = table_1.getValueAt(row,0).toString();
					String colName = (table_1.getColumnName(col)).toLowerCase();
					CAPE c = controller.searchSubjects(name.toLowerCase());
					System.out.println(name);
					if (c != null) {
						subSearched(c, colName);
					 }
					else {
						Student s = controller.searchStudents(name.toLowerCase());
						if (s != null) {
							searchedStud(s);
						 }
					 }
				}
				catch (Exception ex) {
				}
			 }
		}
		);			
		JRadioButton studBtn = new JRadioButton("Student");
		studBtn.setFont(new Font("Corbel", Font.PLAIN, 10));
		studBtn.setToolTipText("Search By Student Name Eg. \"John Brown\"");
		studBtn.setForeground(new Color(255, 255, 255));
		studBtn.setBackground(new Color(0, 128, 128));
		studBtn.setSelected(true);
		studBtn.setBounds(1072, 52, 63, 23);
		panel.add(studBtn);
		
		JRadioButton subBtn = new JRadioButton("Subject");
		subBtn.setFont(new Font("Corbel", Font.PLAIN, 10));
		subBtn.setToolTipText("Search by subject name. Eg. \"Pure Mathematics\"");
		subBtn.setBackground(new Color(0, 128, 128));
		subBtn.setForeground(new Color(255, 255, 255));
		subBtn.setBounds(1137, 52, 61, 23);
		panel.add(subBtn);
		
		ButtonGroup bG = new ButtonGroup();
		bG.add(studBtn);
		bG.add(subBtn);
		
		textField = new JTextField();
		textField.setFont(new Font("Corbel", Font.ITALIC, 14));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (studBtn.isSelected()) {
					Student stu = controller.searchStudents(textField.getText().toLowerCase());
					if (stu != null) {
						searchedStud(stu); 
					}
					else {
						JOptionPane.showMessageDialog(null, "Student Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					CAPE cape = controller.searchSubjects(textField.getText().toLowerCase());
					if (cape != null) {
						subSearched(cape, "");
					}
					else {
						JOptionPane.showMessageDialog(null, "Subject Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				textField.setText("");
			}
		});
		
		JLabel lblEnterName = new JLabel("Enter Name:");
		lblEnterName.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 17));
		lblEnterName.setForeground(new Color(255, 255, 255));
		lblEnterName.setBounds(927, 25, 98, 20);
		panel.add(lblEnterName);
		textField.setBounds(1025, 25, 169, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		lblEnterName.setLabelFor(textField);
		
		JLabel lblSaps = new JLabel("SAPS Report");
		lblSaps.setForeground(new Color(255, 255, 255));
		lblSaps.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaps.setFont(new Font("Calisto MT", Font.BOLD | Font.ITALIC, 33));
		lblSaps.setBounds(452, 6, 243, 44);
		panel.add(lblSaps);
		
		nameLbl = new JLabel("");
		nameLbl.setForeground(Color.WHITE);
		nameLbl.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 26));
		nameLbl.setBounds(22, 43, 350, 36);
		panel.add(nameLbl);
		
		secLbl = new JLabel("");
		secLbl.setForeground(Color.WHITE);
		secLbl.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 13));
		secLbl.setBounds(20, 78, 404, 14);
		panel.add(secLbl);
		
		JButton home = new JButton("Home");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				returnHome();
			}
		});
		home.setFont(new Font("Corbel", Font.BOLD, 12));
		home.setBounds(23, 6, 89, 23);
		panel.add(home);
		rpFrame.setSize(1218,569);
		rpFrame.setVisible(true);
		
	}
	
	private void returnHome() {
		panel.remove(scrollPane);
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(iRow,iCol) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		alignText(table_1);
		panel.remove(nameLbl);
		nameLbl = new JLabel("");
		nameLbl.setForeground(Color.WHITE);
		nameLbl.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 26));
		nameLbl.setBounds(22, 43, 350, 36);
		panel.add(nameLbl);
		
		panel.remove(secLbl);
		secLbl = new JLabel("");
		secLbl.setForeground(Color.WHITE);
		secLbl.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 13));
		secLbl.setBounds(20, 78, 404, 14);
		panel.add(secLbl);
		panel.add(scrollPane);
		refreshPanel();
	}
}
