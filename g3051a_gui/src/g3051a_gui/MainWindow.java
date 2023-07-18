package g3051a_gui;

import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainWindow {

	private JFrame frame;
	private int fontSize = 20;
	private JTextField textA;
	private JTextField textB;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for(int i = 0; i < 1; i++) {
						Random random = new Random();
						MainWindow window = new MainWindow();
						window.frame.setVisible(true);
						window.frame.setBounds(random.nextInt(0,1450), random.nextInt(0,750), 450, 300);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 1);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A=");
		lblNewLabel.setBounds(20, 33, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textA = new JTextField();
		textA.setBounds(20, 47, 86, 20);
		frame.getContentPane().add(textA);
		textA.setColumns(10);
		
		textB = new JTextField();
		textB.setColumns(10);
		textB.setBounds(132, 47, 86, 20);
		frame.getContentPane().add(textB);
		
		JLabel lblB = new JLabel("B=");
		lblB.setBounds(132, 33, 46, 14);
		frame.getContentPane().add(lblB);
		
		JButton btnNewButton = new JButton("Összeadás");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.valueOf(textA.getText());
				int b = Integer.valueOf(textB.getText());
				btnNewButton.setText((a+b) + "");
			}
		});
		btnNewButton.setBounds(63, 99, 115, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
