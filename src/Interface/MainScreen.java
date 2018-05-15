package Interface;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import System.App;

import javax.swing.JFileChooser;
import java.io.File;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;


public class MainScreen {

	private JFrame frame;
	private static App app;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen(app);
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
	public MainScreen(App app) {
		this.app = app;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(0, 0, 2000, 1300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeSapsUser = new JLabel("Welcome SAPS User");
		lblWelcomeSapsUser.setFont(new Font("Agency FB", Font.BOLD, 38));
		lblWelcomeSapsUser.setBounds(12, 13, 900, 100);
		frame.getContentPane().add(lblWelcomeSapsUser);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setFont(new Font("Agency FB", Font.BOLD, 34));
		lblLogout.setBounds(1600, 13, 150, 100);
		frame.getContentPane().add(lblLogout);
		
		JLabel lblUploadFilw = new JLabel("Upload File");
		lblUploadFilw.setFont(new Font("Agency FB", Font.BOLD, 28));
		//lblUploadFilw.addMouseListener(new MouseAdapter() {
		JLabel lblUploadFile = new JLabel("Upload File");
		lblUploadFile.setFont(new Font("Agency FB", Font.BOLD, 28));
		lblUploadFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(frame);
			if (result == JFileChooser.APPROVE_OPTION) {
			    File selectedFile = fileChooser.getSelectedFile();
			    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
			    try {
					app.populateStudents(selectedFile);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}});
		lblUploadFilw.setBounds(318, 510, 150, 100);
		frame.getContentPane().add(lblUploadFilw);
		
		lblUploadFile.setBounds(125, 172, 72, 16);
		frame.getContentPane().add(lblUploadFile);
		
		
		
		ImageIcon image1 = new ImageIcon(getClass().getResource("../img/upload1.png"));
		ImageIcon image2 = new ImageIcon(getClass().getResource("../img/reports1.png"));
		ImageIcon image3 = new ImageIcon(getClass().getResource("../img/users1.png"));
		ImageIcon image4 = new ImageIcon(getClass().getResource("../img/preference1.png"));
		ImageIcon image5 = new ImageIcon(getClass().getResource("../img/points1.png"));
		
		JLabel lblReports = new JLabel("Reports");
		lblReports.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Report window = new Report();
					//window.frame.setVisible(true);
				} catch (Exception ec) {
					ec.printStackTrace();
				}
			}
		});
		lblReports.setFont(new Font("Agency FB", Font.BOLD, 28));
		lblReports.setBounds(1474, 508, 150, 100);
		frame.getContentPane().add(lblReports);
		
		JLabel lblManageUsers = new JLabel("Manage Users");
		lblManageUsers.setFont(new Font("Agency FB", Font.BOLD, 28));
		lblManageUsers.setBounds(1100, 510, 150, 100);
		frame.getContentPane().add(lblManageUsers);
		
		JLabel lblSetPreferences = new JLabel("Set Preferences");
		lblSetPreferences.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Preferences windoww = new Preferences();
					//windoww.frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		lblSetPreferences.setFont(new Font("Agency FB", Font.BOLD, 28));
		lblSetPreferences.setBounds(708, 510, 150, 100);
		frame.getContentPane().add(lblSetPreferences);
		
		JLabel lblLabel1 = new JLabel(image1);
		lblLabel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(frame);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
			}
		});
		lblLabel1.setBounds(100, 125, 500, 500);
		frame.getContentPane().add(lblLabel1);
		
		JLabel lblLabel = new JLabel(image2);
		lblLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Report window = new Report();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		lblLabel.setBounds(1250, 125, 500, 500);
		frame.getContentPane().add(lblLabel);
		
		JLabel lblLabel2 = new JLabel(image3);
		lblLabel2.setBounds(850, 125, 600, 500);
		frame.getContentPane().add(lblLabel2);
		
		JLabel lblLabl = new JLabel(image4);
		lblLabl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Preferences windoww = new Preferences();
					//windoww.frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		lblLabl.setBounds(500, 125, 500, 500);
		frame.getContentPane().add(lblLabl);
	}
}
