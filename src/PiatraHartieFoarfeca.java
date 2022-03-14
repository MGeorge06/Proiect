import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PiatraHartieFoarfeca extends JFrame{
	
	JLabel  alegereCalculator, rezultat_final;
	
	ImageIcon img_hartie, img_foarfeca, img_piatra;
	
	public PiatraHartieFoarfeca() {
		this.setTitle("PIATRA HARTIE FOARFECA");
		this.setBounds(400, 200, 600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.blue);
		this.joc();
		this.setResizable(false);
		this.setVisible(false);
	}
	
	public void joc() {
		
		img_hartie = new ImageIcon(new ImageIcon("hartie.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		img_piatra = new ImageIcon(new ImageIcon("piatra.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		img_foarfeca = new ImageIcon(new ImageIcon("foarfeca.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		
		alegereCalculator = new JLabel();
		alegereCalculator.setBounds(225, 100 ,400, 100);
		
		rezultat_final = new JLabel();
		rezultat_final.setBounds(300, 15, 500, 500);
		rezultat_final.setFont(new Font("Serif", Font.BOLD, 20));
		
		
		JLabel label_hartie = new JLabel();
		label_hartie.setIcon(img_hartie);
		label_hartie.setBounds(10, 150, 400, 500);
		label_hartie.setText("Hartie");
		label_hartie.setHorizontalTextPosition(JLabel.CENTER);
		label_hartie.setVerticalTextPosition(JLabel.BOTTOM);
		
		JLabel label_foarfeca = new JLabel();
		label_foarfeca.setIcon(img_foarfeca);
		label_foarfeca.setBounds(225, 150, 400, 500);
		label_foarfeca.setText("Foarfeca");
		label_foarfeca.setHorizontalTextPosition(JLabel.CENTER);
		label_foarfeca.setVerticalTextPosition(JLabel.BOTTOM);
		
		
		JLabel label_piatra = new JLabel();
		label_piatra.setIcon(img_piatra);
		label_piatra.setBounds(430, 150, 400, 500);
		label_piatra.setText("Piatra");
		label_piatra.setHorizontalTextPosition(JLabel.CENTER);
		label_piatra.setVerticalTextPosition(JLabel.BOTTOM);
		
		label_hartie.addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e) {
				calculate(label_hartie.getText());
			}
		});
		
		label_piatra.addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e) {
				calculate(label_piatra.getText());
			}
		});

		label_foarfeca.addMouseListener(new MouseAdapter(){
	
	public void mouseClicked(MouseEvent e) {
		calculate(label_foarfeca.getText());
	}
});
		
		add(label_piatra);
		add(label_hartie);
		add(label_foarfeca);
		add(rezultat_final);
		add(alegereCalculator);
		
		
		
		setLayout(null);
	}
	
	public void calculate(String player) {
		String[] list = {"Hartie","Foarfeca","Piatra"};
				int alegere_random = (int)((Math.random()*3));
				String calculator = list[alegere_random];
				
				
				if(alegere_random == 0) {
					
					alegereCalculator.setIcon(img_hartie);
					
				}else if(alegere_random == 1) {
					
					alegereCalculator.setIcon(img_foarfeca);
					
				} else if(alegere_random == 2){
					alegereCalculator.setIcon(img_piatra);
				}
				
				String rezultat ="";
				if(player.equals(calculator)) {
					
					rezultat = "EGALITATE!";
				} else if(player.equals("Piatra")) {
					if(calculator.equals("Foarfeca")) {
						rezultat = "Bine boss!";
					} else if(calculator.equals("Hartie")) {
						rezultat = "Ai cam pierdut, curcanule!";
					}
				} 
				else if(player.equals("Hartie")) {
					if(calculator.equals("Foarfeca")) {
						rezultat = "Ai cam pierdut, curcanule!";
					} else if(calculator.equals("Piatra")) {
						rezultat = "Bine boss!";
					}
				} 
				else if(player.equals("Foarfeca")) {
					if(calculator.equals("Piatra")) {
						rezultat = "Ai cam pierdut, curcanule!";
						System.out.println(player);
						System.out.println(calculator);
					} else if(calculator.equals("Hartie")) {
						rezultat = "Bine boss!";
						System.out.println(player);
						System.out.println(calculator);
					}
				}
				
				rezultat_final.setText(rezultat);	}
	
	
	
	
}//primaClasa
