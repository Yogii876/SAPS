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
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

public class MainScreen {
	private App controller;

	private JFrame frmSaps;
	private MainScreen self;

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
					window.frmSaps.setVisible(true);
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
		frmSaps.setVisible(true);
		this.self = this;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSaps = new JFrame();
		frmSaps.setTitle("Sixth Form Application Processing System");
		frmSaps.setFont(new Font("Corbel", Font.PLAIN, 14));
		frmSaps.setResizable(false);
		frmSaps.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/img/saps-logo.png")));
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		frmSaps.getContentPane().setBackground(Color.WHITE);
		frmSaps.setBounds(300, 300, 708, 451);
		frmSaps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSaps.getContentPane().setLayout(null);
		
		JLabel lblWelcomeSapsUser = new JLabel("Welcome");
		lblWelcomeSapsUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeSapsUser.setForeground(new Color(0, 128, 128));
		lblWelcomeSapsUser.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 27));
		lblWelcomeSapsUser.setBounds(10, 21, 128, 32);
		frmSaps.getContentPane().add(lblWelcomeSapsUser);
		
		JLabel lblUploadFilw = new JLabel("Upload File");
		lblUploadFilw.setFont(new Font("Corbel", Font.PLAIN, 14));
		lblUploadFilw.setHorizontalAlignment(SwingConstants.CENTER);
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
				int result = fileChooser.showOpenDialog(frmSaps);
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
			@Override
			public void mouseEntered(MouseEvent e) {
				JLabel src = (JLabel)e.getSource();
	            src.setForeground(Color.BLUE);
	            src.setFont(new Font("Corbel", Font.BOLD, 16));
			}
			public void mouseExited(MouseEvent e) {
				JLabel src = (JLabel)e.getSource();
	            src.setForeground(Color.BLACK);
	            src.setBackground(Color.BLACK);
	            src.setFont(new Font("Corbel", Font.PLAIN, 14));
			}
			
		});
		lblUploadFilw.setBounds(145, 212, 82, 16);
		frmSaps.getContentPane().add(lblUploadFilw);
		
		
		
		ImageIcon image1 = new ImageIcon(getClass().getResource("../img/upload1.png"));
		ImageIcon image2 = new ImageIcon(getClass().getResource("../img/report3.png"));
		ImageIcon image3 = new ImageIcon(getClass().getResource("../img/users1.png"));	
		ImageIcon image4 = new ImageIcon(getClass().getResource("../img/preference1.png"));
		
		JLabel lblReports = new JLabel("Reports");
		lblReports.setFont(new Font("Corbel", Font.PLAIN, 14));
		lblReports.setHorizontalAlignment(SwingConstants.CENTER);
		lblReports.setBounds(513, 362, 78, 20);
		lblReports.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					//new Report(self,controller);
					self.setVisible(false);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		frmSaps.getContentPane().add(lblReports);
		
		JLabel lblManageUsers = new JLabel("Manage Users");
		lblManageUsers.setFont(new Font("Corbel", Font.PLAIN, 14));
		lblManageUsers.setHorizontalAlignment(SwingConstants.CENTER);
		lblManageUsers.setBounds(492, 212, 99, 16);
		frmSaps.getContentPane().add(lblManageUsers);
		
		JLabel lblSetPreferences = new JLabel("Set Preferences");
		lblSetPreferences.setFont(new Font("Corbel", Font.PLAIN, 14));
		lblSetPreferences.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetPreferences.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new Preferences(self,controller);
					self.setVisible(false);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		lblSetPreferences.setBounds(145, 364, 99, 16);
		frmSaps.getContentPane().add(lblSetPreferences);
		
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
				int result = fileChooser.showOpenDialog(frmSaps);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    try {
				    	controller.populateStudents(selectedFile);
				    }
				    catch (Exception e1) {
				    	JOptionPane.showMessageDialog(null, e1.getMessage(), "Parsing Error", JOptionPane.ERROR_MESSAGE);
				    }				    
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				JLabel src = (JLabel)e.getSource();
				src.setBounds(117, 78, 140, 138);
			}
			
			public void mouseExited(MouseEvent e) {
				JLabel src = (JLabel)e.getSource();
				src.setBounds(134, 78, 120, 118);
			}
		});
		lblUpl.setBounds(134, 78, 120, 118);
		frmSaps.getContentPane().add(lblUpl);
		
		JLabel lblLabel = new JLabel(image2);
		lblLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					//TODO change report
					//new Report(self,controller);
					self.setVisible(false);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		lblLabel.setBounds(510, 253, 100, 100);
		frmSaps.getContentPane().add(lblLabel);
		
		JLabel lblHehe = new JLabel(image3);
		lblHehe.setBounds(482, 78, 128, 118);
		frmSaps.getContentPane().add(lblHehe);
		
		JLabel lblLabl = new JLabel(image4);
		lblLabl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Preferences window = new Preferences(self,controller);
					self.setVisible(false);
					//windoww.frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		lblLabl.setBounds(145, 253, 100, 100);
		frmSaps.getContentPane().add(lblLabl);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Corbel", Font.BOLD, 14));
		btnLogOut.setBackground(new Color(0, 128, 128));
		btnLogOut.setForeground(new Color(0, 128, 128));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogOut.setBounds(593, 11, 99, 21);
		frmSaps.getContentPane().add(btnLogOut);
	}
	
	public void setVisible(boolean b) {
		frmSaps.setVisible(b);
	}
}