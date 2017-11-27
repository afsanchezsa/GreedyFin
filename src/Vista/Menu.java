/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author COMPAQ
 */
public class Menu extends JPanel {
    private Boton newGame;
    private Boton Score;
    private Image fondo;
    public Menu(){
    this.newGame=new Boton("NewGame");
    this.Score=new Boton("Score");
this.fondo=loadImage("fondo.jpg");

setSize(200,100);
   // setLayout(new GridLayout(4,3,20,20));
   setLayout(new GridBagLayout()); 
   GridBagConstraints r=new GridBagConstraints();
    r.gridx=2;
    r.gridy=2;
    r.gridheight=3;
    r.gridwidth=4;
    r.weightx=0;
    r.weighty=0;
    r.fill=GridBagConstraints.HORIZONTAL;
    add(newGame,r);
    
       r.gridx=2;
    r.gridy=6;
    r.gridheight=3;
    r.gridwidth=4;
     r.weightx=0;
    r.weighty=0;
    r.fill=GridBagConstraints.HORIZONTAL;
    add(Score,r);
    

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    g.drawImage(this.fondo, 0,0, this.getWidth(), this.getHeight(), this);
    
    }
    public static Image loadImage(String ruta){
    ImageIcon im=new ImageIcon(ruta);
    Image imagen=im.getImage();
    return imagen;
    }
}
