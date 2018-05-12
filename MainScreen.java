import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JFileChooser;
import java.io.File;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class MainScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
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
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(300, 300, 800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeSapsUser = new JLabel("Welcome SAPS User");
		lblWelcomeSapsUser.setBounds(12, 13, 155, 16);
		frame.getContentPane().add(lblWelcomeSapsUser);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setBounds(714, 13, 56, 16);
		frame.getContentPane().add(lblLogout);
		
		JLabel lblUploadFilw = new JLabel("Upload File");
		lblUploadFilw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(frame);
			if (result == JFileChooser.APPROVE_OPTION) {
			    File selectedFile = fileChooser.getSelectedFile();
			    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
			}
			}});
		lblUploadFilw.setBounds(125, 172, 72, 16);
		frame.getContentPane().add(lblUploadFilw);
		
		
		
		ImageIcon image1 = new ImageIcon(getClass().getResource("img/upload1.png"));
		ImageIcon image2 = new ImageIcon(getClass().getResource("img/reports1.png"));
		ImageIcon image3 = new ImageIcon(getClass().getResource("img/users1.png"));
		ImageIcon image4 = new ImageIcon(getClass().getResource("img/preference1.png"));
		ImageIcon image5 = new ImageIcon(getClass().getResource("img/points1.png"));
		
		JLabel lblReports = new JLabel("Reports");
		lblReports.setBounds(380, 152, 60, 20);
		frame.getContentPane().add(lblReports);
		
		JLabel lblManageUsers = new JLabel("Manage Users");
		lblManageUsers.setBounds(571, 154, 99, 16);
		frame.getContentPane().add(lblManageUsers);
		
		JLabel lblSetPreferences = new JLabel("Set Preferences");
		lblSetPreferences.setBounds(229, 312, 99, 16);
		frame.getContentPane().add(lblSetPreferences);
		
		JLabel lblSetPoints = new JLabel("Set Points");
		lblSetPoints.setBounds(446, 312, 72, 16);
		frame.getContentPane().add(lblSetPoints);
		
		JLabel lblUpl = new JLabel(image1);
		lblUpl.setBounds(54, 0, 225, 225);
		frame.getContentPane().add(lblUpl);
		
		JLabel lblLabel = new JLabel(image2);
		lblLabel.setBounds(332, 89, 120, 50);
		frame.getContentPane().add(lblLabel);
		
		JLabel lblHehe = new JLabel(image3);
		lblHehe.setBounds(512, 13, 216, 199);
		frame.getContentPane().add(lblHehe);
		
		JLabel lblLabl = new JLabel(image4);
		lblLabl.setBounds(229, 199, 100, 100);
		frame.getContentPane().add(lblLabl);
		
		JLabel lblYupp = new JLabel(image5);
		lblYupp.setBounds(429, 211, 100, 100);
		frame.getContentPane().add(lblYupp);
	}
}
