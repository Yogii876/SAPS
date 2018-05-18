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
		this.controller = app;
		initialize();
		frmSaps.setVisible(true);
		this.self = this;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void chooser() {
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
		frmSaps.setBounds(300, 300, 655, 451);
		frmSaps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSaps.getContentPane().setLayout(null);
		
		JLabel lblWelcomeSapsUser = new JLabel("Welcome");
		lblWelcomeSapsUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeSapsUser.setForeground(new Color(0, 128, 128));
		lblWelcomeSapsUser.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 27));
		lblWelcomeSapsUser.setBounds(31, 21, 128, 32);
		frmSaps.getContentPane().add(lblWelcomeSapsUser);
		
		JLabel lblUploadFilw = new JLabel("Upload File");
		lblUploadFilw.setFont(new Font("Corbel", Font.PLAIN, 14));
		lblUploadFilw.setHorizontalAlignment(SwingConstants.CENTER);
		lblUploadFilw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chooser();
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
		lblUploadFilw.setBounds(102, 193, 82, 16);
		frmSaps.getContentPane().add(lblUploadFilw);
		
		
		
		ImageIcon image1 = new ImageIcon(getClass().getResource("../img/upload1.png"));
		ImageIcon image2 = new ImageIcon(getClass().getResource("../img/report3.png"));
		ImageIcon image3 = new ImageIcon(getClass().getResource("../img/users1.png"));	
		ImageIcon image4 = new ImageIcon(getClass().getResource("../img/preference1.png"));
		
		MouseAdapter clickReport = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (controller.getOffered().isEmpty()) {
					JOptionPane.showMessageDialog(frmSaps, "Set CAPE Preferences Before Proceeding", "Error", JOptionPane.ERROR_MESSAGE);
					new Preferences(self,controller);
					self.setVisible(false);
					return;
					}
				else if(controller.getStudents().isEmpty()){
					JOptionPane.showMessageDialog(frmSaps, "Upload Student Data Before Proceeding", "Error", JOptionPane.ERROR_MESSAGE);
					chooser();
					return;
				}
				try {
					int dialogResult = JOptionPane.showConfirmDialog (null, "Is there restriction on the number of courses a student can do?","Warning", JOptionPane.INFORMATION_MESSAGE);
					if(dialogResult == JOptionPane.YES_OPTION){
							int ans = Integer.parseInt(JOptionPane.showInputDialog(frmSaps, "Enter number", "Maximum Allocation of Courses", JOptionPane.INFORMATION_MESSAGE));
							controller.generateMappings(ans);
					}
					else {
						controller.generateMappings(0);
					}
					new Report(self);
					self.setVisible(false);
					
				}
				catch(NumberFormatException ne) {
					JOptionPane.showMessageDialog(frmSaps, "Please enter an Integer", "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(frmSaps, "Error While Assigning Students, Try Again", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		
		
		JLabel repLabel = new JLabel("Generate Report");
		repLabel.setFont(new Font("Corbel", Font.PLAIN, 14));
		repLabel.setHorizontalAlignment(SwingConstants.CENTER);
		repLabel.setBounds(271, 362, 102, 20);
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
		lblManageUsers.setBounds(287, 193, 99, 16);
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
		lblSetPreferences.setBounds(102, 364, 99, 16);
		frmSaps.getContentPane().add(lblSetPreferences);
		
		
		JLabel upLabel = new JLabel(image1);
		upLabel.addMouseListener(new MouseAdapter() {
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
		upLabel.setBounds(92, 64, 120, 118);
		frmSaps.getContentPane().add(upLabel);
		
		JLabel lblLabel = new JLabel(image2);
		lblLabel.addMouseListener(clickReport);
		
		
		lblLabel.setBounds(261, 223, 128, 128);
		frmSaps.getContentPane().add(lblLabel);
		
		JLabel lblHehe = new JLabel(image3);
		lblHehe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblHehe.setBounds(261, 64, 144, 118);
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
		lblLabl.setBounds(101, 234, 100, 100);
		frmSaps.getContentPane().add(lblLabl);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Corbel", Font.BOLD, 14));
		btnLogOut.setBackground(new Color(0, 128, 128));
		btnLogOut.setForeground(new Color(0, 128, 128));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogOut.setBounds(512, 11, 99, 21);
		frmSaps.getContentPane().add(btnLogOut);
		fakeSubjects();
	}
	
	private  void fakeSubjects() {
		Random r = new Random();
		String[] csec_subjs = {"ADDITIONAL MATHEMATICS", "AGRICULTURAL SCIENCE", "BIOLOGY", "CARIBBEAN HISTORY", "CHEMISTRY", "ECONOMICS", "ELECTRONIC DOCUMENT PREPARATION AND MANAGEMENT", "ENGLISH A", "ENGLISH B", "FAMILY AND RESOURCE MANAGEMENT", "FOOD, NUTRITION AND HEALTH", "FRENCH", "GEOGRAPHY", "HOME ECONOMICS", "HUMAN AND SOCIAL BIOLOGY", "INDUSTRIAL TECHNOLOGY", "INFORMATION TECHNOLOGY", "INTEGRATED SCIENCE", "MATHEMATICS", "MUSIC", "OFFICE ADMINISTRATION", "PHYSICAL EDUCATION AND SPORT", "PHYSICS", "PORTUGUESE", "PRINCIPLES OF ACCOUNTS", "PRINCIPLES OF BUSINESS", "RELIGIOUS EDUCATION", "SOCIAL STUDIES", "SPANISH", "TECHNICAL DRAWING", "TEXTILES, CLOTHING AND FASHION", "THEATRE ARTS", "VISUAL ARTS"};
		String[] csec_subjs1 = {"None", "ADDITIONAL MATHEMATICS", "AGRICULTURAL SCIENCE", "BIOLOGY", "CARIBBEAN HISTORY", "CHEMISTRY", "ECONOMICS", "ELECTRONIC DOCUMENT PREPARATION AND MANAGEMENT", "ENGLISH A", "ENGLISH B", "FAMILY AND RESOURCE MANAGEMENT", "FOOD, NUTRITION AND HEALTH", "FRENCH", "GEOGRAPHY", "HOME ECONOMICS", "HUMAN AND SOCIAL BIOLOGY", "INDUSTRIAL TECHNOLOGY", "INFORMATION TECHNOLOGY", "INTEGRATED SCIENCE", "MATHEMATICS", "MUSIC", "OFFICE ADMINISTRATION", "PHYSICAL EDUCATION AND SPORT", "PHYSICS", "PORTUGUESE", "PRINCIPLES OF ACCOUNTS", "PRINCIPLES OF BUSINESS", "RELIGIOUS EDUCATION", "SOCIAL STUDIES", "SPANISH", "TECHNICAL DRAWING", "TEXTILES, CLOTHING AND FASHION", "THEATRE ARTS", "VISUAL ARTS"};

		String[] cape_subjs = {"ACCOUNTING", "ANIMATION & GAME DESIGN", "AGRICULTURAL SCIENCE", "APPLIED MATHEMATICS", "ART AND DESIGN", "BIOLOGY", "BUILDING AND MECHANICAL ENGINEERING DRAWING", "CARIBBEAN STUDIES", "CHEMISTRY", "COMMUNICATION STUDIES", "COMPUTER SCIENCE", "DIGITAL MEDIA", "ELECTRICAL AND ELECTRONIC ENGINEERING TECHNOLOGY", "ECONOMICS", "ENTREPRENEURSHIP", "ENVIRONMENTAL SCIENCE", "FINANCIAL SERVICES STUDIES", "FOOD AND NUTRITION", "FRENCH", "GEOGRAPHY", "GREEN ENGINEERING", "HISTORY", "INFORMATION TECHNOLOGY", "INTEGRATED MATHEMATICS", "LAW", "LITERATURES IN ENGLISH", "LOGISTICS AND SUPPLY CHAIN OPERATIONS", "MANAGEMENT OF BUSINESS", "PERFORMING ARTS", "PHYSICS", "PHYSICAL EDUCATION AND SPORT", "PURE MATHEMATICS", "SOCIOLOGY", "SPANISH", "TOURISM"};
		List<String> cape_subjs3 = Arrays.asList(cape_subjs);
		ArrayList<String> cape_subjs2 = new ArrayList<String>();
		cape_subjs2.addAll(cape_subjs3);
		System.out.println(cape_subjs2.size());

		//int sub = r.nextInt(cape_subjs2.length);  // [0...4] [min = 0, max = 4]
		while (cape_subjs2.size() != 0) {
			int sub = r.nextInt(cape_subjs2.size());
			String name = cape_subjs2.get(sub);
			String pReq = csec_subjs[r.nextInt(csec_subjs.length)];
			String sReq = csec_subjs[r.nextInt(csec_subjs.length)];
			String tReq = csec_subjs1[r.nextInt(csec_subjs1.length)];
			
			String anti1 = cape_subjs[r.nextInt(csec_subjs.length)];
			String anti2 = cape_subjs[r.nextInt(csec_subjs.length)];
			String anti3 = cape_subjs[r.nextInt(csec_subjs.length)];
			
			String[] antis = {anti1, anti2, anti3};
			
			int maxStud = r.nextInt(5) + 1;
			//int maxStud =-1;
			CAPE cape;
			
			if (!tReq.equals("None")) cape = controller.populateSubjects(name, pReq, sReq, tReq, maxStud);
			else if (!sReq.equals("None")) cape = controller.populateSubjects(name, pReq, sReq, null, maxStud);
			else cape = controller.populateSubjects(name, pReq, null, null, maxStud);

			for (String s: antis) {
				if (!s.equals("None")) cape.addAntiReq(s);
			}
			cape_subjs2.remove(sub);
		}
	}
	
	public void setVisible(boolean b) {
		frmSaps.setVisible(b);
	}
}