package g3051a_masodfoku;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField ax;
	private JTextField bx;
	private JTextField c;

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
		
		ax = new JTextField();
		ax.setBounds(10, 27, 86, 20);
		frame.getContentPane().add(ax);
		ax.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ax^2");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblBx = new JLabel("bx");
		lblBx.setBounds(106, 11, 46, 14);
		frame.getContentPane().add(lblBx);
		
		bx = new JTextField();
		bx.setColumns(10);
		bx.setBounds(106, 27, 86, 20);
		frame.getContentPane().add(bx);
		
		JLabel lblC = new JLabel("c");
		lblC.setBounds(202, 11, 46, 14);
		frame.getContentPane().add(lblC);
		
		c = new JTextField();
		c.setColumns(10);
		c.setBounds(202, 27, 86, 20);
		frame.getContentPane().add(c);
		
		JLabel eredmenyLabel = new JLabel("x1=, x2=");
		eredmenyLabel.setBounds(10, 122, 414, 54);
		frame.getContentPane().add(eredmenyLabel);
		
		JButton calc = new JButton("Számítás");
		calc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ax.getText().equals("") || bx.getText().equals("") || c.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Hiányzó adat, kérem pótolja!", "Hiba", JOptionPane.ERROR_MESSAGE);
					return;
				}else {
					int _ax = Integer.valueOf(ax.getText());
					int _bx = Integer.valueOf(bx.getText());
					int _c = Integer.valueOf(c.getText());
					double x1 = Masodfoku.x1(_ax, _bx, _c);
					double x2 = Masodfoku.x2(_ax, _bx, _c);
					
					if(Masodfoku.megoldasokSzama(_ax, _bx, _c) == 1) {					
						eredmenyLabel.setText("x1=x2=" + x1);
					}else if(Masodfoku.megoldasokSzama(_ax, _bx, _c) == 2) {
						eredmenyLabel.setText("x1=" + x1 + "     x2=" + x2);
					}else if(Masodfoku.megoldasokSzama(_ax, _bx, _c) == 0) {
						eredmenyLabel.setText("Nincs valós megoldás!");
					}
					return;
				}
			}
		});
		calc.setBounds(335, 26, 89, 23);
		frame.getContentPane().add(calc);
	}
}
