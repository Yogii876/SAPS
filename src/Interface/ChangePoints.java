package Interface;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.text.NumberFormatter;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class ChangePoints {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePoints window = new ChangePoints();
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
	public ChangePoints() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 300, 800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblChangePoints = DefaultComponentFactory.getInstance().createTitle("Change Points");
		lblChangePoints.setBounds(0, 0, 782, 16);
		frame.getContentPane().add(lblChangePoints);
		
		JLabel lblNewLabel = new JLabel("Points are assigned to students to determine subject preferences based off of their CSEC grades. Click below to edit the weightage");
		lblNewLabel.setBounds(0, 13, 770, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPrimarySubject = new JLabel("Primary Subject");
		lblPrimarySubject.setBounds(135, 53, 106, 16);
		frame.getContentPane().add(lblPrimarySubject);
		
		//set format to integer so that only integer can be entered in point text field
		NumberFormatter formatter = new NumberFormatter(NumberFormat.getIntegerInstance());
		formatter.setValueClass(Integer.class);
		formatter.setAllowsInvalid(false);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(formatter);
		formattedTextField.setBounds(125, 82, 116, 22);
		frame.getContentPane().add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField(formatter);
		formattedTextField_1.setBounds(125, 126, 116, 22);
		frame.getContentPane().add(formattedTextField_1);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField(formatter);
		formattedTextField_2.setBounds(125, 168, 116, 22);
		frame.getContentPane().add(formattedTextField_2);
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField(formatter);
		formattedTextField_3.setBounds(125, 212, 116, 22);
		frame.getContentPane().add(formattedTextField_3);
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField(formatter);
		formattedTextField_4.setBounds(125, 254, 116, 22);
		frame.getContentPane().add(formattedTextField_4);
		
		JLabel lblSecondarySubject = new JLabel("Secondary Subject");
		lblSecondarySubject.setBounds(347, 53, 116, 16);
		frame.getContentPane().add(lblSecondarySubject);
		
		JFormattedTextField formattedTextField_5 = new JFormattedTextField(formatter);
		formattedTextField_5.setBounds(347, 82, 116, 22);
		frame.getContentPane().add(formattedTextField_5);
		
		JFormattedTextField formattedTextField_6 = new JFormattedTextField(formatter);
		formattedTextField_6.setBounds(347, 126, 116, 22);
		frame.getContentPane().add(formattedTextField_6);
		
		JFormattedTextField formattedTextField_7 = new JFormattedTextField(formatter);
		formattedTextField_7.setBounds(347, 168, 116, 22);
		frame.getContentPane().add(formattedTextField_7);
		
		JFormattedTextField formattedTextField_8 = new JFormattedTextField(formatter);
		formattedTextField_8.setBounds(347, 212, 116, 22);
		frame.getContentPane().add(formattedTextField_8);
		
		JFormattedTextField formattedTextField_9 = new JFormattedTextField(formatter);
		formattedTextField_9.setBounds(347, 254, 116, 22);
		frame.getContentPane().add(formattedTextField_9);

		JLabel lblTernarySubject = new JLabel("Ternary Subject");
		lblTernarySubject.setBounds(563, 53, 106, 16);
		frame.getContentPane().add(lblTernarySubject);
		
		JFormattedTextField formattedTextField_10 = new JFormattedTextField(formatter);
		formattedTextField_10.setBounds(553, 82, 116, 22);
		frame.getContentPane().add(formattedTextField_10);
		
		JFormattedTextField formattedTextField_11 = new JFormattedTextField(formatter);
		formattedTextField_11.setBounds(553, 126, 116, 22);
		frame.getContentPane().add(formattedTextField_11);
		
		JFormattedTextField formattedTextField_12 = new JFormattedTextField(formatter);
		formattedTextField_12.setBounds(553, 168, 116, 22);
		frame.getContentPane().add(formattedTextField_12);
		
		JFormattedTextField formattedTextField_13 = new JFormattedTextField(formatter);
		formattedTextField_13.setBounds(551, 212, 118, 22);
		frame.getContentPane().add(formattedTextField_13);
		
		JFormattedTextField formattedTextField_14 = new JFormattedTextField(formatter);
		formattedTextField_14.setBounds(553, 254, 116, 22);
		frame.getContentPane().add(formattedTextField_14);
		
		JLabel lblGrade = new JLabel("Grade 1");
		lblGrade.setBounds(30, 90, 56, 16);
		frame.getContentPane().add(lblGrade);
		
		JLabel lblGrade_1 = new JLabel("Grade 2");
		lblGrade_1.setBounds(30, 129, 56, 16);
		frame.getContentPane().add(lblGrade_1);
		
		JLabel lblGrade_2 = new JLabel("Grade 3");
		lblGrade_2.setBounds(30, 171, 56, 16);
		frame.getContentPane().add(lblGrade_2);
		
		JLabel lblGrade_3 = new JLabel("Grade 4");
		lblGrade_3.setBounds(30, 215, 56, 16);
		frame.getContentPane().add(lblGrade_3);
		
		JLabel lblGrade_4 = new JLabel("Grade 5");
		lblGrade_4.setBounds(30, 257, 56, 16);
		frame.getContentPane().add(lblGrade_4);
		
		JLabel lblResetToDefault = new JLabel("Reset to default point weightage");
		lblResetToDefault.setBounds(12, 299, 254, 16);
		frame.getContentPane().add(lblResetToDefault);
		lblResetToDefault.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				formattedTextField.setValue(new Integer("24"));
				formattedTextField_1.setValue(new Integer("20"));
				formattedTextField_2.setValue(new Integer("16"));
				formattedTextField_3.setValue(new Integer("0"));
				formattedTextField_4.setValue(new Integer("0"));
				formattedTextField_5.setValue(new Integer("10"));
				formattedTextField_6.setValue(new Integer("9"));
				formattedTextField_7.setValue(new Integer("8"));
				formattedTextField_8.setValue(new Integer("0"));
				formattedTextField_9.setValue(new Integer("0"));
				formattedTextField_10.setValue(new Integer("3"));
				formattedTextField_11.setValue(new Integer("2"));
				formattedTextField_12.setValue(new Integer("1"));
				formattedTextField_13.setValue(new Integer("0"));
				formattedTextField_14.setValue(new Integer("0"));
			}

			public void mouseEntered(MouseEvent arg0) {

			}

			public void mouseExited(MouseEvent arg0) {
				
			}

			public void mousePressed(MouseEvent arg0) {
				
			}

			public void mouseReleased(MouseEvent arg0) {
				
			}
		});
		
		JButton btnSubmitChanges = new JButton("Submit Changes!");
		btnSubmitChanges.setBounds(314, 328, 129, 25);
		frame.getContentPane().add(btnSubmitChanges);
		
	}
}
