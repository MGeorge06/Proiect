import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

    public class Screen extends JFrame implements ActionListener {
        private static final long serialVersionUID = 1L;

        int width, height;

        JButton play = new JButton("PHF");
        JButton play2 = new JButton("Te simti norocos?");
        JButton exit = new JButton("exit");
        JButton mainMenu = new JButton("main menu");

        CardLayout layout = new CardLayout();

        JPanel panel = new JPanel();
        JPanel menu = new JPanel();
        

        public Screen(int width, int height) {
            this.width = width;
            this.height = height;

            panel.setLayout(layout);
            addButtons();

            setSize(width, height);
            setResizable(false);
            setLocationRelativeTo(null);
            setVisible(true);
            setTitle("Piatra Hartie Foarfeca");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            requestFocus();

        }

        private void addButtons() {

            play.addActionListener(this);
            play2.addActionListener(this);
            exit.addActionListener(this);
          

            //menu buttons
            menu.add(play);
            menu.add(play2);
            menu.add(exit);

         

            //background colors
      
            menu.setBackground(Color.GREEN);

            //adding children to parent Panel
            panel.add(menu,"Menu");
            
            
            add(panel);
            layout.show(panel,"Menu");

        }

        public void actionPerformed(ActionEvent event) {

            Object source = event.getSource();

            if (source == exit) {
                System.exit(0);
            } else if (source == play) {
               new PiatraHartieFoarfeca().setVisible(true);
               this.setVisible(false);
            }  else if(source == play2) {
            	new Zar().setVisible(true);
            	this.setVisible(false);
            }
            

        }
     

    }