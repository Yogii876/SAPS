import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.JButton;

public class Preferences {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Preferences window = new Preferences();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Preferences() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		frame.setBounds(300, 300, 800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCapePreferences = DefaultComponentFactory.getInstance().createTitle("CAPE Preferences");
		lblCapePreferences.setBounds(0, 0, 782, 16);
		frame.getContentPane().add(lblCapePreferences);
		
		JLabel lblNewLabel = new JLabel("Select subject for which you want to set pre-requisites");
		lblNewLabel.setBounds(0, 13, 566, 16);
		frame.getContentPane().add(lblNewLabel);
		
		String[] cape_subjs = {"ACCOUNTING", "ANIMATION & GAME DESIGN", "AGRICULTURAL SCIENCE", "APPLIED MATHEMATICS", "ART AND DESIGN", "BIOLOGY", "BUILDING AND MECHANICAL ENGINEERING DRAWING", "CARIBBEAN STUDIES", "CHEMISTRY", "COMMUNICATION STUDIES", "COMPUTER SCIENCE", "DIGITAL MEDIA", "ELECTRICAL AND ELECTRONIC ENGINEERING TECHNOLOGY", "ECONOMICS", "ENTREPRENEURSHIP", "ENVIRONMENTAL SCIENCE", "FINANCIAL SERVICES STUDIES", "FOOD AND NUTRITION", "FRENCH", "GEOGRAPHY", "GREEN ENGINEERING", "HISTORY", "INFORMATION TECHNOLOGY", "INTEGRATED MATHEMATICS", "LAW", "LITERATURES IN ENGLISH", "LOGISTICS AND SUPPLY CHAIN OPERATIONS", "MANAGEMENT OF BUSINESS", "PERFORMING ARTS", "PHYSICS", "PHYSICAL EDUCATION AND SPORT", "PURE MATHEMATICS", "SOCIOLOGY", "SPANISH", "TOURISM"};
		JComboBox comboBox_1 = new JComboBox(cape_subjs);
		comboBox_1.setBounds(0, 42, 309, 22);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblSelectPrimaryPrerequisite = new JLabel("Select primary pre-requisite");
		lblSelectPrimaryPrerequisite.setBounds(10, 77, 182, 16);
		frame.getContentPane().add(lblSelectPrimaryPrerequisite);
		
		String[] csec_subjs = {"ADDITIONAL MATHEMATICS", "AGRICULTURAL SCIENCE", "BIOLOGY", "CARIBBEAN HISTORY", "CHEMISTRY", "ECONOMICS", "ELECTRONIC DOCUMENT PREPARATION AND MANAGEMENT", "ENGLISH A", "ENGLISH B", "FAMILY AND RESOURCE MANAGEMENT", "FOOD, NUTRITION AND HEALTH", "FRENCH", "GEOGRAPHY", "HOME ECONOMICS", "HUMAN AND SOCIAL BIOLOGY", "INDUSTRIAL TECHNOLOGY", "INFORMATION TECHNOLOGY", "INTEGRATED SCIENCE", "MATHEMATICS", "MUSIC", "OFFICE ADMINISTRATION", "PHYSICAL EDUCATION AND SPORT", "PHYSICS", "PORTUGUESE", "PRINCIPLES OF ACCOUNTS", "PRINCIPLES OF BUSINESS", "RELIGIOUS EDUCATION", "SOCIAL STUDIES", "SPANISH", "TECHNICAL DRAWING", "TEXTILES, CLOTHING AND FASHION", "THEATRE ARTS", "VISUAL ARTS"};
		JComboBox comboBox = new JComboBox(csec_subjs);
		comboBox.setBounds(190, 74, 195, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblSelectSecondaryPrerequisite = new JLabel("Select secondary pre-requisite");
		lblSelectSecondaryPrerequisite.setBounds(12, 109, 180, 16);
		frame.getContentPane().add(lblSelectSecondaryPrerequisite);
		
		JComboBox comboBox_2 = new JComboBox(csec_subjs);
		comboBox_2.setBounds(190, 106, 195, 22);
		frame.getContentPane().add(comboBox_2);
		
		JLabel lblSelectTernaryPrerequisite = new JLabel("Select ternary pre-requisite");
		lblSelectTernaryPrerequisite.setBounds(12, 144, 166, 16);
		frame.getContentPane().add(lblSelectTernaryPrerequisite);
		
		JComboBox comboBox_3 = new JComboBox(csec_subjs);
		comboBox_3.setBounds(190, 144, 195, 22);
		frame.getContentPane().add(comboBox_3);
		
		JButton btnSubmit = new JButton("Submit!");
		btnSubmit.setBounds(124, 274, 97, 25);
		frame.getContentPane().add(btnSubmit);

	}
}