package g3051a_telefonkonyv;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class MainWindow {

	private JFrame frame;
	private ArrayList<Telefonszam> telefonszamok;
	private ArrayList<Telefonszam> szurtTelefonszamok;
	private JTable table;
	private JTextField textField;

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
	
	public void telefonszamokInit() {
		telefonszamok = new ArrayList<Telefonszam>();
		try {
			FileReader fileReader = new FileReader("telefonkonyv.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			for(String s : bufferedReader.lines().toList()) {
				Telefonszam t = new Telefonszam(s);
				if(t.telefonszamValid())
					telefonszamok.add(t);
				else
					System.out.println("Érvénytelen telefonszám: " + t);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox szolgaltatoBox = new JComboBox();
		szolgaltatoBox.setModel(new DefaultComboBoxModel(new String[] {"Összes szolgáltató", "Yettel (06-20)", "Telekom (06-30)", "Vodafone (06-70)"}));
		szolgaltatoBox.setSelectedIndex(0);
		szolgaltatoBox.setBounds(10, 36, 160, 22);
		szolgaltatoBox.setEnabled(false);
		frame.getContentPane().add(szolgaltatoBox);
		
		JLabel szolgaltatoLabel = new JLabel("Szolgáltató:");
		szolgaltatoLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		szolgaltatoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		szolgaltatoLabel.setFont(UIManager.getFont("Button.font"));
		szolgaltatoLabel.setBounds(10, 11, 97, 22);
		frame.getContentPane().add(szolgaltatoLabel);
		
		JButton fileReadButton = new JButton("Telefonszámok beolvasása");
		fileReadButton.setBounds(274, 657, 200, 23);
		frame.getContentPane().add(fileReadButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 69, 464, 580);
		textArea.setEditable(false);
		frame.getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setBounds(314, 37, 160, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel nevLabel = new JLabel("Név:");
		nevLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		nevLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nevLabel.setFont(UIManager.getFont("Button.font"));
		nevLabel.setBounds(314, 11, 97, 22);
		frame.getContentPane().add(nevLabel);
		
		JButton newDataButton = new JButton("Új adat");
		newDataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyDialog dialog = new MyDialog();	
				dialog.setVisible(true);
				if(dialog.getResult() == 0) {
					//OK
					String nev = dialog.getNev();
					String szam = dialog.getSzam();
					
					Telefonszam t = new Telefonszam(nev, szam);
					telefonszamok.add(t);
					
					Collections.sort(telefonszamok);
					
					String text = "";
					for(Telefonszam q : telefonszamok)
						text += q.getNev()  + "\t\t" + q.masikFormatum() + "\t" + q.getSzolgaltato() + "\n";
					textArea.setText(text);
				}else if(dialog.getResult() == -1) {
					//Cancel
				}
			}
		});
		newDataButton.setBounds(175, 657, 89, 23);
		frame.getContentPane().add(newDataButton);
		
		JButton saveButton = new JButton("Mentés fájlba");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter fileWriter = new FileWriter("output.txt");
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					
					for(Telefonszam t : telefonszamok)
						bufferedWriter.append(t.getNev()  + "\t\t" + t.masikFormatum() + "\t" + t.getSzolgaltato() + "\n");
					
					bufferedWriter.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		saveButton.setBounds(57, 657, 113, 23);
		frame.getContentPane().add(saveButton);
		
		fileReadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telefonszamokInit();
				String text = "";
				for(Telefonszam t : telefonszamok)
					text += t.getNev()  + "\t\t" + t.masikFormatum() + "\t" + t.getSzolgaltato() + "\n";
				textArea.setText(text);
				szolgaltatoBox.setSelectedIndex(0);
				szolgaltatoBox.setEnabled(true);
			}
		});
		
		szolgaltatoBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Collections.sort(telefonszamok);
				szurtTelefonszamok = new ArrayList<Telefonszam>();
				
				int selectedKorzet = -1;
				switch(szolgaltatoBox.getSelectedIndex())
				{
					case 0:{
						selectedKorzet = 0;
						break;
					}
					case 1:{
						selectedKorzet = 20;
						break;
					}
					case 2:{
						selectedKorzet = 30;
						break;
					}
					case 3:{
						selectedKorzet = 70;
						break;
					}
				}
				
				String text = "";
				for(Telefonszam t : telefonszamok)
					if(selectedKorzet == 0 || t.getKorzet() == selectedKorzet)
						szurtTelefonszamok.add(t);
				
				for(Telefonszam t : szurtTelefonszamok)
					text += t.getNev()  + "\t\t" + t.masikFormatum() + "\t" + t.getSzolgaltato() + "\n";
				textArea.setText(text);
				textArea.setRows(szurtTelefonszamok.size());
			}
		});
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String text = "";
				for(Telefonszam t : szurtTelefonszamok)
					if(textField.getText().isEmpty() || t.getNev().toLowerCase().contains(textField.getText().toLowerCase()))
						text += t.getNev()  + "\t\t" + t.masikFormatum() + "\t" + t.getSzolgaltato() + "\n";
				textArea.setText(text);
			}
		});
	}
}
