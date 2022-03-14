import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Zar extends JFrame implements ActionListener{
	
	int fata, fata2;
	int scorPlayer = 0, scorCalculator = 0;
	ImageIcon fata_zar, fata_zar2;
	
	JPanel panel = new JPanel();
	JLabel image_label, image_label2;
	JLabel scor_player, scor_calculator;
	
	public Zar() {
		this.setTitle("Te simti norocos?");
		this.setBounds(400, 200, 600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.joc2();
		this.setResizable(false);
		this.setVisible(false);	
	}
	
	public void joc2() {
		
		//Label scor
		JLabel scor = new JLabel("Scorul: ");
		scor.setBounds(200, 10, 100, 100);
		panel.add(scor);
		
		//scor player
		scor_player = new JLabel();
		scor_player.setText("Scorul tau: 0");
		scor_player.setBounds(250, 10, 100, 100);
		panel.add(scor_player);
		
		//scor calculator
		scor_calculator = new JLabel();
		scor_calculator.setText("Scorul calculatorului: 0");
		scor_calculator.setBounds(350, 10, 200, 100);
		panel.add(scor_calculator);
		
		//panelPlayer
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		//imaginiPlayer
		image_label = new JLabel("Cat de norocos esti?");
		image_label.setBounds(100, 200, 120, 29);
		panel.add(image_label);
		
		//imaginiCalculator
		image_label2 = new JLabel("Calculator");
		image_label2.setBounds(400, 200, 117, 29);
		panel.add(image_label2);
		
		
		//buton
		Button button = new Button("Apasa");
		button.setBackground(Color.RED);
		button.setBounds(231, 500, 117, 29);
		button.addActionListener(this);
		panel.add(button);
			
			
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Random r = new Random();
		fata = r.nextInt(6) + 1;
		fata2 = r.nextInt(6) + 1;
		panel.remove(image_label);
		panel.remove(image_label2);
		fata_zar = new ImageIcon(getClass().getResource(fata + ".png"));
		fata_zar2 = new ImageIcon(getClass().getResource(fata2 + ".png"));
		
		image_label = new JLabel(fata_zar);
		image_label.setBounds(50, 106, 236, 271);
		image_label.setText(String.valueOf(fata));
		panel.add(image_label);
		
		
		image_label2 = new JLabel(fata_zar2);
		image_label2.setBounds(300, 106, 236, 271);
		image_label2.setText(String.valueOf(fata2));
		panel.add(image_label2);
		
		
		//////////////de terminat scor afisat
		if(fata > fata2) {
			scorPlayer++;
		} else if(fata2 > fata) {
			scorCalculator++;
		}
		
		scor_player.setText("Scorul tau: " + scorPlayer);
		scor_calculator.setText("Scorul calculatorului: " + scorCalculator);
		this.repaint();
	}
}