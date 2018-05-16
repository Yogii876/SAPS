package Interface;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.io.File;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import System.App;
import Components.*;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainScreen {
	private App controller;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App test = new App();
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					MainScreen window = new MainScreen(test);
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
		initialize();
		this.controller = app;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
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
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new FileFilter() {

				    public String getDescription() {
				        return "Comma-Separated Value Files (*.csv)";
				    }
				 
				    public boolean accept(File f) {
				        if (f.isDirectory()) {
				            return true;
				        } else {
				            return f.getName().toLowerCase().endsWith(".csv");
				        }
				    }
				});
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("CSV Files", "csv"));
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				fileChooser.setAcceptAllFileFilterUsed(false);
				int result = fileChooser.showOpenDialog(frame);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    try {
				    	controller.populateStudents(selectedFile);
				    }
				    catch (Exception e1) {
				    	JOptionPane.showMessageDialog(null, "Incorrect Password", "Login Error", JOptionPane.ERROR_MESSAGE);
				    }				    
				}
			}
		});
		lblUploadFilw.setBounds(205, 172, 72, 16);
		frame.getContentPane().add(lblUploadFilw);
		
		
		
		ImageIcon image1 = new ImageIcon(getClass().getResource("../img/upload1.png"));
		ImageIcon image2 = new ImageIcon(getClass().getResource("../img/reports1.png"));
		ImageIcon image3 = new ImageIcon(getClass().getResource("../img/users1.png"));
		ImageIcon image4 = new ImageIcon(getClass().getResource("../img/preference1.png"));
		ImageIcon image5 = new ImageIcon(getClass().getResource("../img/points1.png"));
		
		JLabel lblReports = new JLabel("Reports");
		lblReports.setBounds(441, 322, 60, 20);
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
		frame.getContentPane().add(lblReports);
		
		JLabel lblManageUsers = new JLabel("Manage Users");
		lblManageUsers.setBounds(412, 172, 99, 16);
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
		lblSetPreferences.setBounds(205, 324, 99, 16);
		frame.getContentPane().add(lblSetPreferences);
		
		JLabel lblUpl = new JLabel(image1);
		lblUpl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new FileFilter() {

				    public String getDescription() {
				        return "Comma-Separated Value Files (*.csv)";
				    }
				 
				    public boolean accept(File f) {
				        if (f.isDirectory()) {
				            return true;
				        } else {
				            return f.getName().toLowerCase().endsWith(".csv");
				        }
				    }
				});
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("CSV Files", "csv"));
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				fileChooser.setAcceptAllFileFilterUsed(false);
				int result = fileChooser.showOpenDialog(frame);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    try {
				    	controller.populateStudents(selectedFile);
				    }
				    catch (Exception e1) {
				    	JOptionPane.showMessageDialog(null, "Incorrect Password", "Login Error", JOptionPane.ERROR_MESSAGE);
				    }				    
				}
			}
		});
		lblUpl.setBounds(135, 0, 225, 225);
		frame.getContentPane().add(lblUpl);
		
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
		lblLabel.setBounds(399, 241, 120, 50);
		frame.getContentPane().add(lblLabel);
		
		JLabel lblHehe = new JLabel(image3);
		lblHehe.setBounds(353, 13, 216, 199);
		frame.getContentPane().add(lblHehe);
		
		JLabel lblLabl = new JLabel(image4);
		lblLabl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Preferences window = new Preferences(controller);
					//windoww.frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		lblLabl.setBounds(205, 218, 100, 100);
		frame.getContentPane().add(lblLabl);
	}
}