package Interface;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import System.App;
import Core.CAPE;
import Core.Student;

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
					MainScreen window = new MainScreen();
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
	public MainScreen() {
		this.controller = new App();
		initialize();
		frmSaps.setVisible(true);
		this.self = this;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void chooser(boolean type) {
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
		    	if (type)  {
		    		controller.populateStudents(selectedFile);
		    	}
		    	else {
		    		controller.populateSubjects(selectedFile);
		    	}
		    }
		    catch (Exception e1) {
		    	JOptionPane.showMessageDialog(null, e1.getMessage(), "Parsing Error", JOptionPane.ERROR_MESSAGE);
		    }	
		}
	}
	
	
	
	private void initialize() {
		
		frmSaps = new JFrame();
		frmSaps.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmSaps.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(frmSaps, "Are you sure you want to exit the application?", "Exit Application", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					frmSaps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				else {
					frmSaps.setVisible(true);
				}
		}
		});
		
		MouseAdapter clickedUpload = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] options = { "Subject", "Students" };
				int res = JOptionPane.showOptionDialog(null, "What file is it?", "File Type",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
						null, options, options[1]);
				if (res == 0) {
					chooser(false);
				}
				else {
					chooser(true);
				}
			}
			
		};
			
		frmSaps.setTitle("Sixth Form Application Processing System");
		frmSaps.setFont(new Font("Corbel", Font.PLAIN, 14));
		frmSaps.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/img/saps-logo.png")));
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		frmSaps.getContentPane().setBackground(Color.WHITE);
		frmSaps.setBounds(300, 300, 800, 493);
		frmSaps.getContentPane().setLayout(null);
		
		JLabel lblWelcomeSapsUser = new JLabel("Welcome");
		lblWelcomeSapsUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeSapsUser.setForeground(new Color(0, 128, 128));
		lblWelcomeSapsUser.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 27));
		lblWelcomeSapsUser.setBounds(10, -1, 128, 32);
		frmSaps.getContentPane().add(lblWelcomeSapsUser);
		
		JLabel lblUploadFilw = new JLabel("Upload File");
		lblUploadFilw.setFont(new Font("Corbel", Font.PLAIN, 14));
		lblUploadFilw.setHorizontalAlignment(SwingConstants.CENTER);
		lblUploadFilw.addMouseListener(clickedUpload);
		lblUploadFilw.setBounds(159, 171, 82, 16);
		frmSaps.getContentPane().add(lblUploadFilw);
		
		
		
		ImageIcon image1 = new ImageIcon(MainScreen.class.getResource("/img/upload1.png"));
		ImageIcon image2 = new ImageIcon(MainScreen.class.getResource("/img/report3.png"));
		ImageIcon image3 = new ImageIcon(MainScreen.class.getResource("/img/users1.png"));	
		ImageIcon image4 = new ImageIcon(MainScreen.class.getResource("/img/preference1.png"));
		
		MouseAdapter clickReport = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (controller.getOffered().isEmpty()) {
					JOptionPane.showMessageDialog(frmSaps, "Set CAPE Preferences", "Error", JOptionPane.ERROR_MESSAGE);
					new Preferences(self);
					self.setVisible(false);
					return;
					}
				if(controller.getStudents().isEmpty()){
					JOptionPane.showMessageDialog(frmSaps, "Upload Student Data", "Error", JOptionPane.ERROR_MESSAGE);
					chooser(true);
					return;
				}
				try {
					int dialogResult = JOptionPane.showConfirmDialog (null, "Is there restriction on the number of courses a student can do?","Warning", JOptionPane.INFORMATION_MESSAGE);
					if(dialogResult == JOptionPane.YES_OPTION){
						int ans = Integer.parseInt(JOptionPane.showInputDialog(frmSaps, "Enter number", "Maximum Allocation of Courses", JOptionPane.INFORMATION_MESSAGE));
						controller.generateMappings(ans);
					}
				    else if (dialogResult == JOptionPane.NO_OPTION){
						controller.generateMappings(0);
					}
					List<Object[]> info = new ArrayList<Object[]>();

					for (CAPE c: controller.getOffered()) {
						int cSize = c.getClassSize();
						String cMax;
						if  (cSize == 0) {
							cMax = "N/A";
						}
						else {
							cMax = Integer.toString(cSize);
						}
						Object [] temp = {c.getName(), c.getApplied(), c.getMetReq(), cMax, c.getAccNum(), c.getPending(), c.getRejectedSize()};
						info.add(temp);
					}
					Object[][] data = new Object[info.size()][];
					data = info.toArray(data);
					self.setVisible(false);
					new MainReport(self, data);	
				}
				catch(NumberFormatException ne) {
					JOptionPane.showMessageDialog(frmSaps, "Please enter an Integer", "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(frmSaps, "Error While Assigning Students, Try Again", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		
		
		JLabel repLabel = new JLabel("Generate Report");
		repLabel.setFont(new Font("Corbel", Font.PLAIN, 14));
		repLabel.setHorizontalAlignment(SwingConstants.CENTER);
		repLabel.setBounds(509, 344, 102, 20);
		repLabel.addMouseListener(clickReport);
		frmSaps.getContentPane().add(repLabel);
		
		JLabel lblManageUsers = new JLabel("Manage Users");
		lblManageUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblManageUsers.setFont(new Font("Corbel", Font.PLAIN, 14));
		lblManageUsers.setHorizontalAlignment(SwingConstants.CENTER);
		lblManageUsers.setBounds(509, 171, 99, 16);
		frmSaps.getContentPane().add(lblManageUsers);
		
		MouseAdapter clickPref = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new Preferences(self);
					self.setVisible(false);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};
		
		JLabel lblSetPreferences = new JLabel("Set Preferences");
		lblSetPreferences.setFont(new Font("Corbel", Font.PLAIN, 14));
		lblSetPreferences.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetPreferences.addMouseListener(clickPref);
		lblSetPreferences.setBounds(136, 346, 99, 16);
		frmSaps.getContentPane().add(lblSetPreferences);
		
		
		JLabel upLabel = new JLabel(image1);
		upLabel.addMouseListener(clickedUpload);
		upLabel.setBounds(136, 57, 120, 118);
		frmSaps.getContentPane().add(upLabel);
		
		JLabel lblLabel = new JLabel(image2);
		lblLabel.addMouseListener(clickReport);
		
		
		lblLabel.setBounds(499, 223, 128, 128);
		frmSaps.getContentPane().add(lblLabel);
		
		JLabel lblHehe = new JLabel(image3);
		lblHehe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblHehe.setBounds(475, 55, 167, 142);
		frmSaps.getContentPane().add(lblHehe);
		
		JLabel lblLabl = new JLabel(image4);
		lblLabl.addMouseListener(clickPref);
		lblLabl.setBounds(136, 233, 114, 107);
		frmSaps.getContentPane().add(lblLabl);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Corbel", Font.BOLD, 14));
		btnLogOut.setBackground(new Color(0, 128, 128));
		btnLogOut.setForeground(new Color(0, 128, 128));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(frmSaps, "Are you sure you want to log out?", "Logging Out", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					frmSaps.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					new Login();
					frmSaps.dispose();					
				}
			}
		});
		btnLogOut.setBounds(685, 11, 99, 21);
		frmSaps.getContentPane().add(btnLogOut);
	}
	
	
	
	public App getController() {
		return this.controller;
	}
	
	public void setVisible(boolean b) {
		frmSaps.setVisible(b);
	}
}