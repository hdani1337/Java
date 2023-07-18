package g3051a_kamat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class MainWindow {

	private JFrame frame;
	private JTextField tokeField;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox kamatBox = new JComboBox();
		kamatBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		kamatBox.setBounds(10, 28, 46, 22);
		frame.getContentPane().add(kamatBox);
		
		JLabel kamatLabel = new JLabel("Kamat:");
		kamatLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(kamatLabel);
		
		JComboBox evBox = new JComboBox();
		evBox.setBounds(10, 78, 46, 22);
		frame.getContentPane().add(evBox);
		
		JLabel evLabel = new JLabel("Év:");
		evLabel.setBounds(10, 61, 46, 14);
		frame.getContentPane().add(evLabel);
		
		tokeField = new JTextField();
		tokeField.setBounds(10, 124, 136, 20);
		frame.getContentPane().add(tokeField);
		tokeField.setColumns(10);
		
		JLabel tokeLabel = new JLabel("Alaptőke:");
		tokeLabel.setBounds(10, 111, 136, 14);
		frame.getContentPane().add(tokeLabel);
		
		JLabel osszegLabel = new JLabel("");
		osszegLabel.setBounds(10, 155, 414, 14);
		frame.getContentPane().add(osszegLabel);
		
		JButton calcButton = new JButton("Számol");
		calcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ennek majd külön osztályt, hozam legyen kerekítve
				int alap = Integer.parseInt(tokeField.getText());
				int kamat = Integer.parseInt(kamatBox.getSelectedItem().toString());
				int ido = Integer.parseInt(evBox.getSelectedItem().toString());							
				
				osszegLabel.setText(alap + " forint " + ido + " év alatti hozama " + kamat + "% kamattal: " + Bank.hozam(alap, kamat, ido) + " Ft");
			}
		});
		calcButton.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(calcButton);
		
		JComboBox tokeBox = new JComboBox();
		tokeBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tokeField.setText(tokeBox.getSelectedItem().toString());
			}
		});
		tokeBox.setBounds(156, 123, 110, 22);
		frame.getContentPane().add(tokeBox);
		
		for(int i = 1; i <= 10; i++) {
			evBox.addItem(i);
			kamatBox.addItem(i);
			tokeBox.addItem(i*1000000);
		}
		
		JSlider kamatSlider = new JSlider();
		kamatSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				kamatBox.setSelectedIndex(kamatSlider.getValue()-1);
			}
		});
		kamatSlider.setMaximum(10);
		kamatSlider.setBounds(66, 28, 200, 26);
		frame.getContentPane().add(kamatSlider);
		
		JSlider evSlider = new JSlider();
		evSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				evBox.setSelectedIndex(evSlider.getValue()-1);
			}
		});
		evSlider.setMaximum(10);
		evSlider.setMinimum(1);
		evSlider.setBounds(66, 78, 200, 26);
		frame.getContentPane().add(evSlider);

	}
}
