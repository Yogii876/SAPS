package Interface;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;

import System.App;

import javax.swing.JFileChooser;
import java.io.File; 

public class Report {

	private JFrame frame;
	private JTextField textField;
	private static App app;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report window = new Report();
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
	public Report() {
		//this.app = app;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(0, 0,screen.width,screen.height - 30);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SAPS");
		lblNewLabel.setBounds(0, 0, 112, 68);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Rage Italic", Font.BOLD, 35));
		frame.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.text);
		tabbedPane.setBounds(0,90,screen.width,screen.height -29);
		tabbedPane.setFont(new Font("Agency FB", Font.PLAIN, 11));
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		tabbedPane.addTab("Student Report", null, panel, null);
		tabbedPane.setFont(new Font("Agency FB", Font.PLAIN, 11));
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Search for a student by full name:");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(244, 101, 194, 32);
		panel.add(lblNewLabel_1);
		
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				
			}
		});
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 18));
		btnNewButton.setBounds(751, 101, 89, 32);
		panel.add(btnNewButton);
		
		JButton btnViewAllStudents = new JButton("View all students");
		btnViewAllStudents.setForeground(SystemColor.text);
		btnViewAllStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnViewAllStudents.setBackground(SystemColor.textHighlight);
		btnViewAllStudents.setFont(new Font("Agency FB", Font.BOLD, 18));
		btnViewAllStudents.setBounds(857, 101, 157, 32);
		panel.add(btnViewAllStudents);
		
		textField = new JTextField();
		textField.setFont(new Font("Agency FB", Font.PLAIN, 18));
		textField.setBounds(444, 101, 297, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Class Report", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Select class to view from the list:");
		lblNewLabel_2.setFont(new Font("Agency FB", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(405, 91, 191, 38);
		panel_1.add(lblNewLabel_2);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JLabel lbl_combo_selection = new JLabel("");
				lbl_combo_selection.setHorizontalAlignment(SwingConstants.CENTER);
				lbl_combo_selection.setFont(new Font("Agency FB", Font.BOLD, 23));
				lbl_combo_selection.setBounds(507, 225, 232, 31);
				panel_1.add(lbl_combo_selection);
				
				String value=(String)comboBox.getSelectedItem();
				
				if (value.equals(comboBox.getSelectedItem())){;
					lbl_combo_selection.setText(value);
					value = null;
					
				}
			}
		});
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Agency FB", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "Chemistry", "Pure Mathematics", "Add Mathematics", "Biology", "Physics", "Computer Science"}));
		comboBox.setBounds(628, 91, 241, 38);
		panel_1.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setForeground(SystemColor.textHighlight);
		btnNewButton_1.setBackground(SystemColor.text);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Login exit = new Login(app);
				Login.main(null);
				
				
			}
			
		});
		btnNewButton_1.setBounds(1258, 55, 82, 32);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnHome = new JButton("Home");
		btnHome.setForeground(SystemColor.textHighlight);
		btnHome.setBackground(SystemColor.text);
		btnHome.setBounds(1167, 55, 82, 32);
		frame.getContentPane().add(btnHome);
		
		
		
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
