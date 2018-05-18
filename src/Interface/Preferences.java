package Interface;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import Core.CAPE;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import System.App;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.JTextField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.LineBorder;

public class Preferences {

	public static JFrame prefFrame;
	private App controller;
	private JTextField classSize;
	private MainScreen parent;
	private int maxStud = -1;
	private CAPE searchedSub = null;

	/**
	 * Launch the application.
	 */
	
	private static class RoundedBorder implements Border {

	    private int radius;


	    RoundedBorder(int radius) {
	        this.radius = radius;
	    }


	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	    }


	    public boolean isBorderOpaque() {
	        return true;
	    }


	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
	    }
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App con = new App();
					MainScreen t = new MainScreen(con);
					t.setVisible(false);
					Preferences window = new Preferences(t, con);
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
	public Preferences(MainScreen parent, App app) {
		initialize();
		this.parent = parent;
		prefFrame.setVisible(true);
		this.controller = app;
		prefFrame.setVisible(true);
		this.maxStud = -1;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private class MyListCellRenderer extends DefaultListCellRenderer {
		  @Override
		  public Component getListCellRendererComponent(JList list, Object value,
		      int index, boolean isSelected, boolean cellHasFocus) {
		    Component component = super.getListCellRendererComponent(list, value,
		        index, isSelected, cellHasFocus);
		    component.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		    return component;
		  }
	}
	private void initialize() {		
		prefFrame = new JFrame();
		prefFrame.setBackground(new Color(0, 128, 128));
		prefFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(Preferences.class.getResource("/img/saps-logo.png")));
		prefFrame.setTitle("Sixth Form Application Processing System");
		prefFrame.setForeground(new Color(0, 128, 128));
		prefFrame.setFont(new Font("Corbel", Font.PLAIN, 14));
		prefFrame.setResizable(false);
		prefFrame.getContentPane().setBackground(new Color(255, 255, 255));
		prefFrame.getContentPane().setForeground(Color.WHITE);
		prefFrame.setBounds(257, 133, 710, 565);
		prefFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prefFrame.getContentPane().setLayout(null);
		
		JLabel lblCapePreferences = DefaultComponentFactory.getInstance().createTitle("Register CAPE Subject");
		lblCapePreferences.setForeground(new Color(0, 128, 128));
		lblCapePreferences.setHorizontalAlignment(SwingConstants.LEFT);
		lblCapePreferences.setBounds(10, 10, 269, 37);
		lblCapePreferences.setFont(new Font("Century Gothic", Font.BOLD, 21));
		prefFrame.getContentPane().add(lblCapePreferences);
		
		JLabel lblClassSize = new JLabel("Maximum Class Size");
		lblClassSize.setFont(new Font("Corbel", Font.ITALIC, 18));
		lblClassSize.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClassSize.setBounds(443, 16, 147, 32);
		prefFrame.getContentPane().add(lblClassSize);
		
		classSize = new JTextField();
		classSize.setToolTipText("Leave empty if there is no limit of how many students can sit this course");
		classSize.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
					arg0.consume();
				}
				else {
					if (classSize.getText().equals("") || classSize.getText() == null);
					else {
					String size =	classSize.getText().concat(Character.toString(arg0.getKeyChar()));
					int cSize = Integer.parseInt(size);
					if (cSize>=500) arg0.consume();
					}
				}
			}
		});
		
		classSize.setBounds(600, 23, 37, 20);
		prefFrame.getContentPane().add(classSize);
		classSize.setColumns(3);
		
		JLabel lblNewLabel = new JLabel("Subject Name");
		lblNewLabel.setBounds(2, 60, 243, 20);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Corbel", Font.PLAIN, 18));
		lblNewLabel.setBackground(Color.WHITE);
		prefFrame.getContentPane().add(lblNewLabel);
		
		//String[] cape_subjs = {"ACCOUNTING", "ANIMATION & GAME DESIGN", "AGRICULTURAL SCIENCE", "APPLIED MATHEMATICS", "ART AND DESIGN", "BIOLOGY", "BUILDING AND MECHANICAL ENGINEERING DRAWING", "CARIBBEAN STUDIES", "CHEMISTRY", "COMMUNICATION STUDIES", "COMPUTER SCIENCE", "DIGITAL MEDIA", "ELECTRICAL AND ELECTRONIC ENGINEERING TECHNOLOGY", "ECONOMICS", "ENTREPRENEURSHIP", "ENVIRONMENTAL SCIENCE", "FINANCIAL SERVICES STUDIES", "FOOD AND NUTRITION", "FRENCH", "GEOGRAPHY", "GREEN ENGINEERING", "HISTORY", "INFORMATION TECHNOLOGY", "INTEGRATED MATHEMATICS", "LAW", "LITERATURES IN ENGLISH", "LOGISTICS AND SUPPLY CHAIN OPERATIONS", "MANAGEMENT OF BUSINESS", "PERFORMING ARTS", "PHYSICS", "PHYSICAL EDUCATION AND SPORT", "PURE MATHEMATICS", "SOCIOLOGY", "SPANISH", "TOURISM"};
		String[] cape_subjs2 = {"None", "ACCOUNTING", "ANIMATION & GAME DESIGN", "AGRICULTURAL SCIENCE", "APPLIED MATHEMATICS", "ART AND DESIGN", "BIOLOGY", "BUILDING AND MECHANICAL ENGINEERING DRAWING", "CARIBBEAN STUDIES", "CHEMISTRY", "COMMUNICATION STUDIES", "COMPUTER SCIENCE", "DIGITAL MEDIA", "ELECTRICAL AND ELECTRONIC ENGINEERING TECHNOLOGY", "ECONOMICS", "ENTREPRENEURSHIP", "ENVIRONMENTAL SCIENCE", "FINANCIAL SERVICES STUDIES", "FOOD AND NUTRITION", "FRENCH", "GEOGRAPHY", "GREEN ENGINEERING", "HISTORY", "INFORMATION TECHNOLOGY", "INTEGRATED MATHEMATICS", "LAW", "LITERATURES IN ENGLISH", "LOGISTICS AND SUPPLY CHAIN OPERATIONS", "MANAGEMENT OF BUSINESS", "PERFORMING ARTS", "PHYSICS", "PHYSICAL EDUCATION AND SPORT", "PURE MATHEMATICS", "SOCIOLOGY", "SPANISH", "TOURISM"};
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox nameBox = new JComboBox(cape_subjs2);
		nameBox.setFont(new Font("Corbel", Font.PLAIN, 14));
		nameBox.setBounds(343, 54, 336, 34);
		prefFrame.getContentPane().add(nameBox);
		
		JLabel lblPrerequisites = new JLabel("Pre-Requisites");
		lblPrerequisites.setForeground(new Color(0, 128, 128));
		lblPrerequisites.setBackground(Color.WHITE);
		lblPrerequisites.setFont(new Font("Century", Font.BOLD, 18));
		lblPrerequisites.setBounds(9, 95, 236, 25);
		prefFrame.getContentPane().add(lblPrerequisites);
		
		JLabel lblSelectPrimaryPrerequisite = new JLabel("Primary");
		lblSelectPrimaryPrerequisite.setBounds(2, 146, 243, 20);
		lblSelectPrimaryPrerequisite.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectPrimaryPrerequisite.setFont(new Font("Corbel", Font.PLAIN, 18));
		prefFrame.getContentPane().add(lblSelectPrimaryPrerequisite);
		
		String[] csec_subjs = {"None", "ADDITIONAL MATHEMATICS", "AGRICULTURAL SCIENCE", "BIOLOGY", "CARIBBEAN HISTORY", "CHEMISTRY", "ECONOMICS", "ELECTRONIC DOCUMENT PREPARATION AND MANAGEMENT", "ENGLISH A", "ENGLISH B", "FAMILY AND RESOURCE MANAGEMENT", "FOOD, NUTRITION AND HEALTH", "FRENCH", "GEOGRAPHY", "HOME ECONOMICS", "HUMAN AND SOCIAL BIOLOGY", "INDUSTRIAL TECHNOLOGY", "INFORMATION TECHNOLOGY", "INTEGRATED SCIENCE", "MATHEMATICS", "MUSIC", "OFFICE ADMINISTRATION", "PHYSICAL EDUCATION AND SPORT", "PHYSICS", "PORTUGUESE", "PRINCIPLES OF ACCOUNTS", "PRINCIPLES OF BUSINESS", "RELIGIOUS EDUCATION", "SOCIAL STUDIES", "SPANISH", "TECHNICAL DRAWING", "TEXTILES, CLOTHING AND FASHION", "THEATRE ARTS", "VISUAL ARTS"};
		JComboBox pBox = new JComboBox(csec_subjs);
		pBox.setFont(new Font("Corbel", Font.PLAIN, 14));
		pBox.setBounds(344, 140, 335, 34);
		pBox.setSelectedIndex(0);
		prefFrame.getContentPane().add(pBox);
		
		JLabel lblSelectSecondaryPrerequisite = new JLabel("Secondary");
		lblSelectSecondaryPrerequisite.setBounds(2, 191, 243, 20);
		lblSelectSecondaryPrerequisite.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectSecondaryPrerequisite.setFont(new Font("Corbel", Font.PLAIN, 18));
		prefFrame.getContentPane().add(lblSelectSecondaryPrerequisite);
		
		JComboBox sBox = new JComboBox(csec_subjs);
		sBox.setFont(new Font("Corbel", Font.PLAIN, 14));
		sBox.setBounds(344, 185, 335, 34);
		sBox.setSelectedIndex(0);
		prefFrame.getContentPane().add(sBox);
		
		JLabel lblSelectTernaryPrerequisite = new JLabel("Tertiary");
		lblSelectTernaryPrerequisite.setBounds(2, 242, 243, 20);
		lblSelectTernaryPrerequisite.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectTernaryPrerequisite.setFont(new Font("Corbel", Font.PLAIN, 18));
		prefFrame.getContentPane().add(lblSelectTernaryPrerequisite);
		
		JComboBox tBox = new JComboBox(csec_subjs);
		tBox.setFont(new Font("Corbel", Font.PLAIN, 14));
		tBox.setBounds(343, 236, 335, 34);
		tBox.setSelectedIndex(0);
		prefFrame.getContentPane().add(tBox);
		
		JLabel lblAntirequisites = new JLabel("Anti-Requisites");
		lblAntirequisites.setHorizontalAlignment(SwingConstants.LEFT);
		lblAntirequisites.setForeground(new Color(0, 128, 128));
		lblAntirequisites.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblAntirequisites.setBounds(10, 276, 226, 25);
		prefFrame.getContentPane().add(lblAntirequisites);
		
		JLabel lblSelectAntirequisite = new JLabel("First");
		lblSelectAntirequisite.setBounds(2, 324, 243, 20);
		lblSelectAntirequisite.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectAntirequisite.setFont(new Font("Corbel", Font.PLAIN, 18));
		prefFrame.getContentPane().add(lblSelectAntirequisite);
		
		JComboBox a1Box = new JComboBox(cape_subjs2);
		a1Box.setFont(new Font("Corbel", Font.PLAIN, 14));
		a1Box.setBounds(343, 318, 335, 34);
		a1Box.setSelectedIndex(0);
		prefFrame.getContentPane().add(a1Box);
		
		JLabel lblSelectAntirequisite_1 = new JLabel("Second");
		lblSelectAntirequisite_1.setBounds(2, 369, 243, 20);
		lblSelectAntirequisite_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectAntirequisite_1.setFont(new Font("Corbel", Font.PLAIN, 18));
		prefFrame.getContentPane().add(lblSelectAntirequisite_1);
		
		JComboBox a2Box = new JComboBox(cape_subjs2);
		a2Box.setFont(new Font("Corbel", Font.PLAIN, 14));
		a2Box.setBounds(343, 363, 335, 34);
		a2Box.setSelectedIndex(0);
		prefFrame.getContentPane().add(a2Box);
		
		JLabel lblSelectAntirequisite_2 = new JLabel("Third");
		lblSelectAntirequisite_2.setBounds(0, 423, 243, 20);
		lblSelectAntirequisite_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectAntirequisite_2.setFont(new Font("Corbel", Font.PLAIN, 18));
		prefFrame.getContentPane().add(lblSelectAntirequisite_2);
		
		JComboBox a3Box = new JComboBox(cape_subjs2);
		a3Box.setFont(new Font("Corbel", Font.PLAIN, 14));
		a3Box.setBounds(343, 417, 335, 34);
		a3Box.setSelectedIndex(0);
		prefFrame.getContentPane().add(a3Box);
		
		JButton btnSubmit = new JButton("Add");
		btnSubmit.setOpaque(false);
		btnSubmit.setFocusPainted(false);
		btnSubmit.setBorder(new LineBorder(new Color(0, 128, 128), 2, true));
		btnSubmit.setFont(new Font("Corbel", Font.PLAIN, 14));
		btnSubmit.setBounds(343, 469, 102, 38);
		btnSubmit.addActionListener(new ActionListener() {
			private void resetSelections() {
				nameBox.setSelectedIndex(0);
				pBox.setSelectedIndex(0);
				sBox.setSelectedIndex(0);
				tBox.setSelectedIndex(0);
				a1Box.setSelectedIndex(0);
				a2Box.setSelectedIndex(0);
				a3Box.setSelectedIndex(0);
				classSize.setText(null);
				maxStud = -1;
			}
			
			public void actionPerformed(ActionEvent arg0) {
				String name = (String)nameBox.getSelectedItem();
				if (!name.equals("None")) {
					String pReq, sReq, tReq, anti1, anti2, anti3;
					pReq = (String)pBox.getSelectedItem();
					sReq = (String)sBox.getSelectedItem();
					tReq = (String)tBox.getSelectedItem();
					anti1 = (String)a1Box.getSelectedItem();
					anti2 = (String)a2Box.getSelectedItem();
					anti3 = (String)a3Box.getSelectedItem();
					String cSize = classSize.getText();
					cSize.trim();
					try {
						if (cSize.equals("") || cSize.equals(null));
						else {
							int size = Integer.parseInt(cSize);
							maxStud = size;
							System.out.print(Integer.toString(maxStud));
						}
					}
						catch (NumberFormatException e) {
						}
					
					if  (pReq.equals("None") && (!sReq.equals("None") || !tReq.equals("None"))) {
						// TODO add JOptionPane
						JOptionPane.showMessageDialog(prefFrame, "Enter a Primary Pre-Requisite", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else if (sReq.equals("None") && !tReq.equals("None")) {
						// TODO JOption for they added a ternary without a secondary
						JOptionPane.showMessageDialog(prefFrame, "Enter a Secondary Pre-Requisite", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else {
						CAPE cape;
						if (!tReq.equals("None")) {
							cape = controller.populateSubjects(name, pReq, sReq, tReq, maxStud);				
						}
						else if (!sReq.equals("None")) {
							cape = controller.populateSubjects(name, pReq, sReq, null, maxStud);
						}
						else {
							cape = controller.populateSubjects(name, pReq, null, null, maxStud);
						}
						
						String[] antiArray = {anti1, anti2, anti3};
						for (String s: antiArray) {
							if (!s.equals("None")) cape.addAntiReq(s);
						}
						resetSelections();
					}
					
				}
				else {
					//TODO JOption to input name first
					JOptionPane.showMessageDialog(prefFrame, "Please select a CAPE Subject before submitting", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(0, 451, 335, 56);
		prefFrame.getContentPane().add(label_9);
		prefFrame.getContentPane().add(btnSubmit);
		
		
		
		
		JButton edit = new JButton("Edit");
		edit.setEnabled(false);
		edit.setFont(new Font("Corbel", Font.PLAIN, 14));
		edit.setBounds(462, 469, 102, 38);
		
		JButton btnCancel = new JButton("Back");
	
		btnCancel.setFont(new Font("Corbel", Font.PLAIN, 14));
		btnCancel.setBounds(574, 469, 102, 38);
		btnCancel.addActionListener(new ActionListener() {
			private void resetSelections() {
				nameBox.setSelectedIndex(0);
				pBox.setSelectedIndex(0);
				sBox.setSelectedIndex(0);
				tBox.setSelectedIndex(0);
				a1Box.setSelectedIndex(0);
				a2Box.setSelectedIndex(0);
				a3Box.setSelectedIndex(0);
				classSize.setText(null);
				maxStud = -1;
			}
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (edit.isEnabled()) {
					resetSelections();
					searchedSub = null;
					edit.setEnabled(false);
					btnSubmit.setEnabled(true);
					nameBox.setEnabled(true);
					btnCancel.setText("Cancel");
				}
				else {
					prefFrame.dispose();
					parent.setVisible(true);
				}
			}
		});
		
		prefFrame.getContentPane().add(edit);
		prefFrame.getContentPane().add(btnCancel);
		edit.addActionListener(new ActionListener() {
			private void resetSelections() {
				nameBox.setSelectedIndex(0);
				pBox.setSelectedIndex(0);
				sBox.setSelectedIndex(0);
				tBox.setSelectedIndex(0);
				a1Box.setSelectedIndex(0);
				a2Box.setSelectedIndex(0);
				a3Box.setSelectedIndex(0);
				classSize.setText(null);
				maxStud = -1;
			}
			
			public void actionPerformed(ActionEvent arg0) {
				String name = (String)nameBox.getSelectedItem();
				String pReq, sReq, tReq, anti1, anti2, anti3;
				pReq = (String)pBox.getSelectedItem();
				sReq = (String)sBox.getSelectedItem();
				tReq = (String)tBox.getSelectedItem();
				anti1 = (String)a1Box.getSelectedItem();
				anti2 = (String)a2Box.getSelectedItem();
				anti3 = (String)a3Box.getSelectedItem();
				String cSize = classSize.getText();
				cSize.trim();
				try {
					if (cSize.equals("") || cSize.equals(null));
					else {
						int size = Integer.parseInt(cSize);
						maxStud = size;
						System.out.print(Integer.toString(maxStud));
					}
				}
					catch (NumberFormatException e) {
					}
				
				if  (pReq.equals("None") && (!sReq.equals("None") || !tReq.equals("None"))) {
					// TODO add JOptionPane
					JOptionPane.showMessageDialog(prefFrame, "Enter a Primary Pre-Requisite", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (sReq.equals("None") && !tReq.equals("None")) {
					// TODO JOption for they added a ternary without a secondary
					JOptionPane.showMessageDialog(prefFrame, "Enter a Secondary Pre-Requisite", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if (!tReq.equals("None")) {
						controller.editSubject(searchedSub,pReq, sReq, tReq, maxStud);				
					}
					else if (!sReq.equals("None")) {
						controller.editSubject(searchedSub,pReq, sReq, null, maxStud);
					}
					else {
						controller.editSubject(searchedSub,pReq, null, null, maxStud);
					}
					String[] antiArray = {anti1, anti2, anti3};
					for (String s: antiArray) {
						if (!s.equals("None")) searchedSub.addAntiReq(s);
						//System.out.println(s);
					}
					searchedSub = null;
					nameBox.setEnabled(true);
					resetSelections();					
					edit.setEnabled(false);
					btnSubmit.setEnabled(true);
				}
			}
		});
		
		ItemListener editListener = new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				//JComboBox cb = (JComboBox) evt.getSource();
				//int myIndex = cb.getSelectedIndex();
			    String choice = (String) evt.getItem();

			    if (evt.getStateChange() == ItemEvent.SELECTED) {
			    	if (!choice.equals("None")) {
			    		//TODO remove SearchedSub
			    		searchedSub = controller.searchSubjects(choice.toLowerCase());
			    		if (searchedSub != null) {
			    			pBox.setSelectedItem(searchedSub.getPrimary().toUpperCase());
			    			nameBox.setEnabled(false);
			    			maxStud = searchedSub.getMax();
			    			classSize.setText(Integer.toString(maxStud));
			    			if (searchedSub.getSecondary() != null) sBox.setSelectedItem(searchedSub.getSecondary().toUpperCase());
			    			if (searchedSub.getTertiary() != null) tBox.setSelectedItem(searchedSub.getTertiary().toUpperCase());
			    			ArrayList<String> anti = searchedSub.getAnti();
			    			int aLen = anti.size();
			    			if (aLen != 0) {
			    				int i = 1;
			    				while (i <= aLen-1) {
			    					if (i == 1) a1Box.setSelectedItem(anti.get(i).toUpperCase());
			    					else if (i == 2) a2Box.setSelectedItem(anti.get(i).toUpperCase());
			    					else a3Box.setSelectedItem(anti.get(i).toUpperCase());
			    					i++;
			    				}
			    			}
			    			edit.setEnabled(true);
			    			nameBox.setEnabled(false);
			    			btnSubmit.setEnabled(false);
			    		}
			    	}
			      // Item was just selected
			    } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
			      // Item is no longer selected
			    }
			}
		};
		nameBox.addItemListener(editListener);
		edit.setOpaque(false);
		edit.setFocusPainted(false);
		edit.setBorder(new LineBorder(new Color(0, 128, 128), 2, true));
		btnCancel.setOpaque(false);
		btnCancel.setFocusPainted(false);
		btnCancel.setBorder(new LineBorder(new Color(0, 128, 128), 2, true));
		nameBox.setRenderer(new MyListCellRenderer());
	}
}