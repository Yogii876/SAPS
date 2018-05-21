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
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JLabel;
//import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	
	private void subSearched(CAPE c, String column) {
		 List<Object[]> info = new ArrayList<Object[]>();
		 Set<Entry<Student, StatusMsg>> entires = c.getReasons().entrySet();
		 String[] colData = {};
		 boolean hasSec = c.getSecondary() != null;
		 boolean hasTer = c.getTertiary() != null;
		 if (hasTer) {
			 for(Entry<Student,StatusMsg> ent: entires) {
				 Student s = ent.getKey();
				 Map<String, String> preInfo = s.getPreReqInfo(c);
				 String pGrade = preInfo.get("primary");
				 String sGrade = preInfo.get("secondary");
				 String tGrade= preInfo.get("tertiary");
				 StatusMsg msg = ent.getValue();
				 Object [] temp = {s.toString(), pGrade, sGrade, tGrade, msg.getStatus(), msg.getMsg()};
				 String[] col = { "Student", c.getPrimary(), c.getSecondary(), c.getTertiary(), "Status", "Reason"
					};
				 colData = col;
				 info.add(temp);
				}
		 }
		 else if (hasSec) {
			 for(Entry<Student,StatusMsg> ent: entires) {
				 Student s = ent.getKey();
				 Map<String, String> preInfo = s.getPreReqInfo(c);
				 String pGrade = preInfo.get("primary");
				 String sGrade = preInfo.get("secondary");
				 StatusMsg msg = ent.getValue();
				 Object [] temp = {s.toString(), pGrade, sGrade, msg.getStatus(), msg.getMsg()};
				 String[] col = { "Student", c.getPrimary(), c.getSecondary(), "Status", "Reason"
					};
				 colData = col;
				 info.add(temp);
			 }
		 }
		 else {
			 for(Entry<Student,StatusMsg> ent: entires) {
				 Student s = ent.getKey();
				 Map<String, String> preInfo = s.getPreReqInfo(c);
				 String pGrade = preInfo.get("primary");
				 StatusMsg msg = ent.getValue();
				 Object [] temp = {s.toString(), pGrade, msg.getStatus(), msg.getMsg()};
				 String[] col = { "Student", c.getPrimary(), "Status", "Reason"
					};
				 colData = col;
				 info.add(temp);
			 }
		 }
		Object[][] data = new Object[info.size()][];
		data = info.toArray(data);
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(data,colData) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		System.out.println("Went here");
		table_1.setShowVerticalLines(false);
		table_1.setShowHorizontalLines(false);
		table_1.setBorder(null);
		table_1.setFillsViewportHeight(true);
		table_1.setForeground(new Color(0, 0, 0));
		table_1.setFont(new Font("Corbel", Font.PLAIN, 14));
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setBackground(new Color(255, 255, 255));
		scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(0, 103, 1204, 407);
		panel.add(scrollPane);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		panel.add(scrollPane);
		panel.revalidate();
		panel.repaint();
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
	}
	
	MouseAdapter listener = new MouseAdapter()  {
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
			System.out.println("Went here");
			table_1.setShowVerticalLines(false);
			table_1.setShowHorizontalLines(false);
			table_1.setBorder(null);
			table_1.setFillsViewportHeight(true);
			table_1.setForeground(new Color(0, 0, 0));
			table_1.setFont(new Font("Corbel", Font.PLAIN, 14));
			table_1.setSurrendersFocusOnKeystroke(true);
			table_1.setBackground(new Color(255, 255, 255));
			scrollPane = new JScrollPane(table_1);
			scrollPane.setBounds(0, 103, 1204, 407);
			panel.add(scrollPane);
			table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			panel.add(scrollPane);
			panel.revalidate();
			panel.repaint();
			table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		 }
		 };	

	
	private void initialize(Object[][] rData) {
		rpFrame = new JFrame();
		rpFrame.setBounds(100, 100, 759, 472);
		rpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		String[] columnNames = {"Name", "Class Maximum", "Met Requirements", "Applied", "Accepted", "Pending", "Rejected"}; 
		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setLayout(null);
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
		//defaultTable(rData, columnNames);
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
		//((DefaultTableCellRenderer) table_1.getTableHeader().getDefaultRenderer().getClass()).setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table_1.setDefaultRenderer(String.class, centerRenderer);
		scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(20, 103, 1174, 407);
		panel.add(scrollPane);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_1.addMouseListener(listener);			
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
						//TODO write sumn here
						//JOptionPane();
					}
				}
				else {
					CAPE cape = controller.searchSubjects(textField.getText().toLowerCase());
					if (cape != null) {
						subSearched(cape, "");
					}
					else {
						//TODO write sumn here
						//JOptionPane();
					}
				}
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
		
		JLabel nameLbl = new JLabel("Yohan Brown");
		nameLbl.setForeground(Color.WHITE);
		nameLbl.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 26));
		nameLbl.setBounds(22, 43, 350, 36);
		panel.add(nameLbl);
		
		JLabel secLbl = new JLabel("Chose: Physics, Chemistry, Pure Mathematics");
		secLbl.setForeground(Color.WHITE);
		secLbl.setFont(new Font("Corbel", Font.BOLD | Font.ITALIC, 13));
		secLbl.setBounds(20, 78, 404, 14);
		panel.add(secLbl);
		rpFrame.setSize(1218,569);
		rpFrame.setVisible(true);
		
	}
}
