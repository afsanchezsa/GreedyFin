/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedyking;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author COMPAQ
 */
public class Prueba extends JPanel implements ActionListener{
    private Enemigo enemigo;
    Timer timer;
    Thread Movimiento;
    public Prueba(){
        try {
            this.enemigo=new Enemigo();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        this.timer=new Timer(5,this);
        this.timer.start();
        Movimiento=new Thread(new MovimientoEnemigo(this.enemigo));
        Movimiento.start();
    }
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(enemigo.getImagen(), enemigo.getX(), enemigo.getY(),50,50,this);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
    }
}
