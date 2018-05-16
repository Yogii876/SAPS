package Interface;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Dimension;
import System.App;

public class Preferences {

	public static JFrame prefFrame;
	private App controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Preferences window = new Preferences(new App());
					window.prefFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Preferences(App app) {
		initialize();
		prefFrame.setVisible(true);
		this.controller = app;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		prefFrame = new JFrame();
		prefFrame.setResizable(false);
		prefFrame.getContentPane().setBackground(new Color(255, 255, 255));
		prefFrame.getContentPane().setForeground(Color.WHITE);
		prefFrame.setBounds(257, 133, 679, 427);
		prefFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		prefFrame.getContentPane().setLayout(null);
		
		JLabel lblCapePreferences = DefaultComponentFactory.getInstance().createTitle("CAPE Preferences");
		lblCapePreferences.setFont(new Font("Agency FB", Font.BOLD, 39));
		lblCapePreferences.setBounds(12, 13, 782, 29);
		prefFrame.getContentPane().add(lblCapePreferences);
		
		JLabel lblNewLabel = new JLabel("Select subject for which you want to set pre-requisites and anti-requisites.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(12, 55, 636, 16);
		prefFrame.getContentPane().add(lblNewLabel);
		
		String[] cape_subjs = {"ACCOUNTING", "ANIMATION & GAME DESIGN", "AGRICULTURAL SCIENCE", "APPLIED MATHEMATICS", "ART AND DESIGN", "BIOLOGY", "BUILDING AND MECHANICAL ENGINEERING DRAWING", "CARIBBEAN STUDIES", "CHEMISTRY", "COMMUNICATION STUDIES", "COMPUTER SCIENCE", "DIGITAL MEDIA", "ELECTRICAL AND ELECTRONIC ENGINEERING TECHNOLOGY", "ECONOMICS", "ENTREPRENEURSHIP", "ENVIRONMENTAL SCIENCE", "FINANCIAL SERVICES STUDIES", "FOOD AND NUTRITION", "FRENCH", "GEOGRAPHY", "GREEN ENGINEERING", "HISTORY", "INFORMATION TECHNOLOGY", "INTEGRATED MATHEMATICS", "LAW", "LITERATURES IN ENGLISH", "LOGISTICS AND SUPPLY CHAIN OPERATIONS", "MANAGEMENT OF BUSINESS", "PERFORMING ARTS", "PHYSICS", "PHYSICAL EDUCATION AND SPORT", "PURE MATHEMATICS", "SOCIOLOGY", "SPANISH", "TOURISM"};
		String[] cape_subjs2 = {"NONE", "ACCOUNTING", "ANIMATION & GAME DESIGN", "AGRICULTURAL SCIENCE", "APPLIED MATHEMATICS", "ART AND DESIGN", "BIOLOGY", "BUILDING AND MECHANICAL ENGINEERING DRAWING", "CARIBBEAN STUDIES", "CHEMISTRY", "COMMUNICATION STUDIES", "COMPUTER SCIENCE", "DIGITAL MEDIA", "ELECTRICAL AND ELECTRONIC ENGINEERING TECHNOLOGY", "ECONOMICS", "ENTREPRENEURSHIP", "ENVIRONMENTAL SCIENCE", "FINANCIAL SERVICES STUDIES", "FOOD AND NUTRITION", "FRENCH", "GEOGRAPHY", "GREEN ENGINEERING", "HISTORY", "INFORMATION TECHNOLOGY", "INTEGRATED MATHEMATICS", "LAW", "LITERATURES IN ENGLISH", "LOGISTICS AND SUPPLY CHAIN OPERATIONS", "MANAGEMENT OF BUSINESS", "PERFORMING ARTS", "PHYSICS", "PHYSICAL EDUCATION AND SPORT", "PURE MATHEMATICS", "SOCIOLOGY", "SPANISH", "TOURISM"};
		JComboBox comboBox_1 = new JComboBox(cape_subjs);
		comboBox_1.setBounds(163, 82, 309, 22);
		prefFrame.getContentPane().add(comboBox_1);
		
		JLabel lblSelectPrimaryPrerequisite = new JLabel("Select primary pre-requisite");
		lblSelectPrimaryPrerequisite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectPrimaryPrerequisite.setBounds(28, 137, 182, 16);
		prefFrame.getContentPane().add(lblSelectPrimaryPrerequisite);
		
		String[] csec_subjs = {"NONE", "ADDITIONAL MATHEMATICS", "AGRICULTURAL SCIENCE", "BIOLOGY", "CARIBBEAN HISTORY", "CHEMISTRY", "ECONOMICS", "ELECTRONIC DOCUMENT PREPARATION AND MANAGEMENT", "ENGLISH A", "ENGLISH B", "FAMILY AND RESOURCE MANAGEMENT", "FOOD, NUTRITION AND HEALTH", "FRENCH", "GEOGRAPHY", "HOME ECONOMICS", "HUMAN AND SOCIAL BIOLOGY", "INDUSTRIAL TECHNOLOGY", "INFORMATION TECHNOLOGY", "INTEGRATED SCIENCE", "MATHEMATICS", "MUSIC", "OFFICE ADMINISTRATION", "PHYSICAL EDUCATION AND SPORT", "PHYSICS", "PORTUGUESE", "PRINCIPLES OF ACCOUNTS", "PRINCIPLES OF BUSINESS", "RELIGIOUS EDUCATION", "SOCIAL STUDIES", "SPANISH", "TECHNICAL DRAWING", "TEXTILES, CLOTHING AND FASHION", "THEATRE ARTS", "VISUAL ARTS"};
		JComboBox comboBox = new JComboBox(csec_subjs);
		comboBox.setBounds(468, 121, 195, 22);
		prefFrame.getContentPane().add(comboBox);
		
		JLabel lblSelectSecondaryPrerequisite = new JLabel("Select secondary pre-requisite");
		lblSelectSecondaryPrerequisite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectSecondaryPrerequisite.setBounds(28, 164, 217, 16);
		prefFrame.getContentPane().add(lblSelectSecondaryPrerequisite);
		
		JComboBox comboBox_2 = new JComboBox(csec_subjs);
		comboBox_2.setBounds(468, 271, 195, 22);
		prefFrame.getContentPane().add(comboBox_2);
		
		JLabel lblSelectTernaryPrerequisite = new JLabel("Select ternary pre-requisite");
		lblSelectTernaryPrerequisite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectTernaryPrerequisite.setBounds(28, 191, 166, 16);
		prefFrame.getContentPane().add(lblSelectTernaryPrerequisite);
		
		JComboBox comboBox_3 = new JComboBox(csec_subjs);
		comboBox_3.setBounds(468, 154, 195, 22);
		prefFrame.getContentPane().add(comboBox_3);
		
		JLabel lblSelectAntirequisite = new JLabel("Select anti-requisite 1");
		lblSelectAntirequisite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectAntirequisite.setBounds(28, 247, 166, 16);
		prefFrame.getContentPane().add(lblSelectAntirequisite);
		
		JLabel lblSelectAntirequisite_1 = new JLabel("Select anti-requisite 2");
		lblSelectAntirequisite_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectAntirequisite_1.setBounds(28, 283, 166, 16);
		prefFrame.getContentPane().add(lblSelectAntirequisite_1);
		
		JLabel lblSelectAntirequisite_2 = new JLabel("Select anti-requisite 3");
		lblSelectAntirequisite_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectAntirequisite_2.setBounds(28, 310, 166, 16);
		prefFrame.getContentPane().add(lblSelectAntirequisite_2);
		
		JComboBox comboBox_4 = new JComboBox(cape_subjs2);
		comboBox_4.setBounds(468, 190, 195, 22);
		prefFrame.getContentPane().add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox(cape_subjs2);
		comboBox_5.setBounds(468, 236, 195, 22);
		prefFrame.getContentPane().add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox(cape_subjs2);
		comboBox_6.setBounds(468, 304, 195, 22);
		prefFrame.getContentPane().add(comboBox_6);
		
		JButton btnSubmit = new JButton("Add");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name, pReq, sReq, tReq, anti1, anti2, anti3;
				name = (String)comboBox_1.getSelectedItem();
				pReq = (String)comboBox.getSelectedItem();
				sReq = (String)comboBox_2.getSelectedItem();
				tReq = (String)comboBox_3.getSelectedItem();
				anti1 = (String)comboBox_4.getSelectedItem();
				anti2 = (String)comboBox_5.getSelectedItem();
				anti3 = (String)comboBox_6.getSelectedItem();
				
				

				
				controller.populateSubjects(name, pReq, sReq, tReq, maxStud);
				
			}
		});
		btnSubmit.setBounds(441, 362, 97, 25);
		prefFrame.getContentPane().add(btnSubmit);
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setBounds(548, 363, 97, 25);
		prefFrame.getContentPane().add(btnCancel);		

	}
}