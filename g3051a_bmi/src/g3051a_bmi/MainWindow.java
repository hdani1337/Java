package g3051a_bmi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Testsúly (kg):");
		lblNewLabel.setBounds(10, 11, 148, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMagassgcm = new JLabel("Magasság (cm):");
		lblMagassgcm.setBounds(10, 59, 148, 14);
		frame.getContentPane().add(lblMagassgcm);
		
		JLabel eredmenyLabel = new JLabel("");
		eredmenyLabel.setBounds(10, 107, 414, 14);
		frame.getContentPane().add(eredmenyLabel);
			
		JComboBox sulyBox = new JComboBox();
		sulyBox.setBounds(10, 26, 107, 22);
		frame.getContentPane().add(sulyBox);
		
		JComboBox magassagBox = new JComboBox();
		magassagBox.setBounds(10, 74, 107, 22);
		frame.getContentPane().add(magassagBox);

		for(int i = 30; i <= 300; i++) 
			sulyBox.addItem(i);
		
		for(int i = 50; i <= 220; i++) 
			magassagBox.addItem(i);

		JButton btnNewButton = new JButton("Számítás");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int kg = Integer.parseInt(sulyBox.getSelectedItem().toString());
				int cm = Integer.parseInt(magassagBox.getSelectedItem().toString());
				eredmenyLabel.setText("Testtömegindex: " + BMI.BMI(kg, cm));
			}
		});
		btnNewButton.setBounds(335, 127, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
	
	}
}
