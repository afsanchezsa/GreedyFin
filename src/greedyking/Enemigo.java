/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedyking;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author COMPAQ
 */
class Enemigo {
    private int x;
    private int y;
    private BufferedImage ImagenGeneral;
    private Image[]imagenesderecha=new Image[4];
    private Image[]imagenesizquierda=new Image[4];
    private int indicederecha;
    private int indiceizquierda;
   private boolean derecha;
   
  
    public Enemigo() throws IOException{
        imagenesderecha=new Image[4];
        imagenesizquierda=new Image[4];
        this.derecha=true;
        
    this.ImagenGeneral=ImageIO.read(new File("characters.png"));
    for(int i=0;i<4;i++){
    this.imagenesderecha[i]=(BufferedImage)ImagenGeneral.getSubimage(i*32, 64, 32, 32);
    
    }
    for(int i=1;i<4;i++){
    this.imagenesizquierda[i]=(BufferedImage)ImagenGeneral.getSubimage(i*32, 64, 32,32);
    }
    this.indicederecha=0;
    this.indiceizquierda=0;
    
    
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image[] getImagenesderecha() {
        return imagenesderecha;
    }

    public Image[] getImagenesizquierda() {
        return imagenesizquierda;
    }

   

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void Aumentarderecha(){
    if(this.indicederecha<3){
     this.indicederecha++;
    }else{
    this.indicederecha=0;
    }
    
       
    }
    public void AumentarIzquierda(){
    if(this.indiceizquierda<3){
     this.indiceizquierda++;
    }else{
    this.indiceizquierda=0;
    }
    }
   public Image getImagen(){
   if(this.derecha){
   return this.imagenesderecha[this.indicederecha];
   }else{
   return this.imagenesizquierda[this.indiceizquierda];
   
   }
   }

    public void setDerecha(boolean derecha) {
        this.derecha = derecha;
    }

    
   
}
