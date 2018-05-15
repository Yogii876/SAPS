package Interface;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import System.App;

import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class Login {

	private JFrame frame;
	private JTextField txt_Username;
	private JPasswordField txt_Password;
	private static App app;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login(app);
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
	public Login(App app) {
		this.app = app;
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("../img/book.ico")));
		frame.setBackground(SystemColor.inactiveCaptionText);
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBounds(257, 133, 885, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(389, 379, 550, -4);
		frame.getContentPane().add(separator_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 902, 398);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SAPS LOGIN");
		lblNewLabel.setBounds(275, 129, 349, 41);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 24));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(315, 235, 291, 2);
		panel.add(separator);
		
		JLabel lbUsername = new JLabel("Username:");
		lbUsername.setBounds(315, 181, 111, 30);
		panel.add(lbUsername);
		lbUsername.setFont(new Font("Agency FB", Font.BOLD, 18));
		
		txt_Username = new JTextField();
		txt_Username.setBounds(315, 207, 291, 30);
		panel.add(txt_Username);
		txt_Username.setColumns(10);
		
		txt_Password = new JPasswordField();
		txt_Password.setBounds(315, 271, 291, 32);
		panel.add(txt_Password);
		
		JLabel lbPassword = new JLabel("Password:");
		lbPassword.setBounds(315, 245, 111, 32);
		panel.add(lbPassword);
		lbPassword.setFont(new Font("Agency FB", Font.BOLD, 18));
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(315, 301, 291, 2);
		panel.add(separator_2);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.setFont(new Font("Agency FB", Font.BOLD, 18));
		btnLogin.setBounds(315, 324, 291, 32);
		panel.add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("../img/lo.png")));
		lblNewLabel_1.setBounds(139, 0, 555, 349);
		panel.add(lblNewLabel_1);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = txt_Password.getText();
				String username = txt_Username.getText();
				
				if (password.equals("Administrator") && username.equals("admin")){
					txt_Password.setText(null);
					txt_Username.setText(null);
					frame.dispose();

					Report rep = new Report();
					Report.main(null);
					
				}
				else{
					JOptionPane.showMessageDialog(null, "Invalid Login", "Login Error", JOptionPane.ERROR_MESSAGE);
					txt_Password.setText(null);
					txt_Username.setText(null);
				}
			}
		});
	}
}
