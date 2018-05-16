package Components;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxActionListener extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComboBoxActionListener() {
        initialize();
    }

    private void initialize() {
        setSize(300, 300);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] names = new String[]{
                "James", "Joshua", "Matt", "John", "Paul"
        };
        JComboBox comboBox = new JComboBox(names);
        comboBox.setEditable(true);

        //
        // Create an ActionListener for the JComboBox component.
        //
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //
                // Get the source of the component, which is our combo
                // box.
                //
                JComboBox comboBox = (JComboBox) event.getSource();

                //
                // Print the selected items and the action command.
                //
                Object selected = comboBox.getSelectedItem();
                System.out.println("Selected Item  = " + selected);
                String command = event.getActionCommand();
                System.out.println("Action Command = " + command);

                //
                // Detect whether the action command is "comboBoxEdited"
                // or "comboBoxChanged"
                //
                if ("comboBoxEdited".equals(command)) {
                    System.out.println("User has typed a string in " +
                            "the combo box.");
                } else if ("comboBoxChanged".equals(command)) {
                    System.out.println("User has selected an item " +
                            "from the combo box.");
                }
            }
        });
        getContentPane().add(comboBox);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComboBoxActionListener().setVisible(true);
            }
        });
    }
}