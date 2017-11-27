/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedyking;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;
import java.util.TreeMap;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Jaime
 */
public class Board extends JPanel implements ActionListener {
    TreeMap<String,int[]>matriz;
    
    
    private int scale = 4;//El tamaño al que se aumenta el juego 1 = originial, 2 = al doble de grande, 3 = triple de grande etc...
    private int unidadMapaOriginal = 16;//El tile del mapa esta dividido en cuadros de 16x16
    private int unidadMapaGrande = 16*scale;//Tamaño que va a terner el juego al ejecutarse
    private int delay = 8;
    Personaje personaje;//Crear un personaje
    private Timer timer;
    Rectangle personajeColision;
    
    Rectangle personajeColisionPies;
    
    private ArrayList<MapaColision> colisionMovY = new ArrayList();
    private ArrayList<MapaColision> colisionMovX = new ArrayList();
    private ArrayList<MapaColision> colisionMovXY = new ArrayList();
    private ColisionBloqueLargo colisionBloqueLargoCaida;//Colision cuando cae el personaje
    private ColisionBloqueLargo colisionBloqueLargoDerecha;
    private ColisionBloqueLargo colisionBloqueLargoIzquierda;
    
    boolean pressS;boolean pressA;boolean pressW;boolean pressD;//La tecla esta siendo precionada
    boolean firstTimeD;//Primera vez que se preciona la tecla 
    boolean firstTimeEnSalto;//Primera vez que se preciona espacio
    boolean pressDMov2=false;//USAR
    
    //Repaint relacionado con delay
    int contadorDelays=0;
    final int velocidadDelay=2;
    int contadorDelaysSalto=0;
    final int velocidadDelaySalto=1;
    
    //Bross
    final java.util.Timer timer2 = new java.util.Timer();
    boolean tiempoDelay=true;boolean tiempoDelay2=true;
    TimerTask timeTrue;
    int contador=0;//Borrar
    //saltoPersonaje
    boolean enSalto=false;
    boolean pressSpace=false;
    int velocidadSalto;
    int gravedad=1;
    
    boolean haySuelo;
    
    int lastKeyPressed;
    
    //Mapa
    private int moverImgMapa = 0;//Dependiendo del numero que tenga mueve esa cantidad de columnas la matriz 
    private int cuadroInicioMapa = -1;
    private int moverMapa = cuadroInicioMapa*unidadMapaGrande;
    int posInicioCreacionMapa = cuadroInicioMapa*unidadMapaGrande;
    
    //        System.out.println("Se pinto mapa");//BORRAR
    int[] fnul = {-1, -1, 0};//SinFondo
    int[] f107 = {5, 6, 0};//fondoVerde

    int[] f027 = {10, 1, 3};//BloqueEsquinaArribaIzquierda
    int[] f028 = {11, 1, 1};//BloqueBaseArriba
    int[] f029 = {12, 1, 3};//BloqueEsquinaArribaDerecha
    int[] f041 = {7, 2, 3};//BloqueSolido

    int[] f061 = {10, 3, 3};//BloqueEsquinaAbajoIzquierda
    int[] f062 = {11, 3, 1};//BloqueBaseAbajo
    int[] f063 = {12, 3, 3};//BloqueEsquinaAbajoDerecha

    int[] f127 = {8, 7, 0};//MarBurbujas
    int[] f144 = {8, 8, 0};//MarOscuro  

    int[] f113 = {11, 6, 0};//FondoPastoArribaIzquierda
    int[] f114 = {12, 6, 0};//FondoPastoArribaBase
    int[] f115 = {13, 6, 0};//FondoPastoArribaIzquierda
    int[] f164 = {11, 9, 0};//FondoUnionPasto

    //Arbol
    int[] f020 = {3, 1, 0};
    int[] f021 = {4, 1, 0};
    int[] f022 = {5, 1, 0};
    int[] f023 = {6, 1, 0};
    int[] f036 = {2, 2, 0};
    int[] f037 = {3, 2, 0};
    int[] f038 = {4, 2, 0};
    int[] f039 = {5, 2, 0};
    int[] f053 = {2, 3, 0};
    int[] f054 = {3, 3, 0};
    int[] f055 = {4, 3, 0};
    int[] f056 = {5, 3, 0};
    int[] f071 = {3, 4, 0};
    int[] f072 = {4, 4, 0};
    int[] f073 = {5, 4, 0};
    int[] f088 = {3, 5, 0};
    int[] f089 = {4, 5, 0};
    int[] f105 = {3, 6, 0};
    int[] f106 = {4, 6, 0};
    int[] f122 = {3, 7, 0};
    int[] f123 = {4, 7, 0};
    int[] f138 = {2, 8, 0};
    int[] f139 = {3, 8, 0};
    int[] f140 = {4, 8, 0};

    int[] f017 = {0, 1, 0};
    int[] f018 = {1, 1, 0};
    int[] f035 = {1, 2, 0};

    int[] f068 = {0, 4, 0};
    int[] f069 = {1, 4, 0};
    int[] f070 = {2, 4, 0};
    int[] f086 = {1, 5, 0};
    int[] f087 = {2, 5, 0};

    int[] f008 = {8, 0, 1};
    int[] f009 = {9, 0, 1};
    int[] f130 = {11, 7, 0};
    int[] f131 = {12, 7, 0};//int[] f = {,};
    int[] f044 = {10, 2, 2};
    int[] f045 = {11, 2, 0};
    int[] f046 = {12, 2, 2};
    int[] f132 = {13, 7, 0};
    int[][][][] mapa = {
        //    0          1              2               3             4           5             6             7             8             9             10           11             12            13            14            15           16             17            18            19            20            21            22            23            24            25            26            27             28            29
        {{fnul,f107},{f107, f061}, {fnul, f062}, {fnul, f062}, {f107, f063}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {f107, f020}, {f107, f021}, {f107, f022}, {f107, f023}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {fnul, f107}},//0
        {{fnul,f107},{fnul, f107}, {f107, f068}, {f107, f069}, {f107, f070}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {f107, f036}, {f107, f037}, {f107, f038}, {f107, f039}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {f107, f113}, {f107, f114}, {f107, f114}, {f107, f114}, {f107, f114}, {f107, f114}, {f107, f114}, {f107, f114}, {f107, f114}, {f107, f115}, {fnul, f107}},//1
        {{fnul,f107},{fnul, f107}, {fnul, f107}, {f107, f086}, {f107, f087}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {f107, f053}, {f107, f054}, {f107, f055}, {fnul, f107}, {fnul, f107}, {f107, f113}, {f107, f114}, {fnul, f164}, {fnul, f131}, {fnul, f131}, {fnul, f131}, {fnul, f131}, {fnul, f131}, {fnul, f131}, {fnul, f131}, {fnul, f131}, {fnul, f131}, {f107, f114}},//2
        {{fnul,f107},{fnul, f107}, {fnul, f107}, {f107, f113}, {f107, f114}, {f107, f114}, {f107, f115}, {fnul, f107}, {fnul, f107}, {fnul, f107}, {f107, f041}, {f107, f071}, {f107, f041}, {f107, f041}, {f107, f113}, {fnul, f164}, {fnul, f131}, {fnul, f131}, {fnul, f131}, {fnul, f131}, {fnul, f131}, {fnul, f131}, {fnul, f131}, {fnul, f131}, {fnul, f131}, {fnul, f131}, {fnul, f131}, {fnul, f131}},//3
        {{fnul,f107},{fnul, f107}, {fnul, f107}, {f107, f130}, {fnul, f131}, {fnul, f131}, {f107, f132}, {fnul, f107}, {fnul, f107}, {f107, f041}, {fnul, f107}, {f107, f088}, {f107, f106}, {fnul, f107}, {f107, f130}, {fnul, f131}, {fnul, f131}, {f131, f027}, {fnul, f028}, {fnul, f028}, {fnul, f028}, {fnul, f028}, {fnul, f028}, {fnul, f028}, {fnul, f028}, {fnul, f028}, {f131, f029}, {fnul, f131}},//4
        {{fnul,f107},{fnul, f107}, {fnul, f107}, {f107, f130}, {fnul, f131}, {f131, f027}, {fnul, f028}, {fnul, f028}, {fnul, f028}, {f107, f029}, {fnul, f107}, {f107, f105}, {f107, f106}, {fnul, f107}, {f107, f027}, {fnul, f028}, {fnul, f028}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f028}},//5
        {{fnul,f107},{fnul, f008}, {fnul, f008}, {fnul, f009}, {fnul, f028}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {f127, f046}, {fnul, f127}, {fnul, f127}, {fnul, f127}, {fnul, f127}, {f127, f044}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}},//6
        {{fnul,f107},{fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {f144, f046}, {fnul, f144}, {fnul, f144}, {fnul, f144}, {fnul, f144}, {f144, f044}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}, {fnul, f045}},//7
    };
    
    
    //sonido
    Sonidos sonidos = new Sonidos();
    
    private int cuadroInicioMovMapaPersonaje = 8;
    
    public Board() {
        this.matriz=new TreeMap<>();
        matriz.put("fnul", fnul);
         matriz.put("f107", f107);
         matriz.put("f027", f027);
         matriz.put("f028", f028);
         matriz.put("f029", f029);
         matriz.put("f041", f041);
         matriz.put("f061", f061);
         matriz.put("f062", f062);
         matriz.put("f063", f063);
         matriz.put("f127", f127);
         matriz.put("f144", f144);
         matriz.put("f113", f113);
         matriz.put("f114", f114);
         matriz.put("f115", f115);
         matriz.put("f164", f164);
         matriz.put("f020", f020);
         matriz.put("f021", f021);
         matriz.put("f022", f022);
         matriz.put("f023", f023);
         matriz.put("f036", f036);
         matriz.put("f037", f037);
         matriz.put("f038", f038);
         matriz.put("f039", f039);
         matriz.put("f053", f053);
         matriz.put("f054", f054);
         matriz.put("f055", f055);
         matriz.put("f056", f056);
         matriz.put("f071", f071);
         matriz.put("f072", f072);
         matriz.put("f073", f073);
         matriz.put("f088", f088);
         matriz.put("f089", f089);
         matriz.put("f105", f105);
         matriz.put("f106", f106);
         matriz.put("f122", f122);
         matriz.put("f123", f123);
         matriz.put("f138", f138);
         matriz.put("f139", f139);
         matriz.put("f140", f140);
         matriz.put("f017", f017);
         matriz.put("f018", f018);
         matriz.put("f035", f035);
         matriz.put("f068", f068);
         matriz.put("f069", f069);
         matriz.put("f070", f070);
         matriz.put("f086", f086);
         matriz.put("f087", f087);
         matriz.put("f008", f008);
         matriz.put("f009", f009);
         matriz.put("f130", f130);
         matriz.put("f131", f131);
         matriz.put("f044", f044);
         matriz.put("f045", f045);
         matriz.put("f046", f046);
         matriz.put("f132", f132);
         
         
                 
                 
                 
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
        
        
        
        
        
        
        
        
        
        
        
        this.personaje = new Personaje(scale);
        timer = new Timer(this.delay,this);
        setFocusable(true);
        addKeyListener(new EventosTeclado());
        timer.start();
        sonidos.musicaFondo.asignarDireccion("Troll Song 10 The Happy Troll",true);
        sonidos.musicaFondo.reproducir();
        sonidos.caminar.asignarDireccion("slime5",true);
        sonidos.salto.asignarDireccion("sfx_movement_jump20", false);
        sonidos.caida.asignarDireccion("sfx_sounds_falling12", false);
        sonidos.perdidaDeVida.asignarDireccion("sfx_deathscream_human1", false);
        this.firstTimeD = true;
    }
    
    public void otherKeyPressed(int key){
//        System.out.println("Laskey "+KeyEvent.getKeyText(lastKeyPressed)+" key "+KeyEvent.getKeyText(key));
        if(lastKeyPressed!=key){
            if (lastKeyPressed != KeyEvent.VK_SPACE && key != KeyEvent.VK_SPACE) {
                switch (lastKeyPressed) {
                    case KeyEvent.VK_D:
                        pressD = false;
                        if (!enSalto) {
                            personaje.sinMovimiento();
                            personaje.noPermitirCambioImgMovimiento(false);
                        }
                        break;
                    case KeyEvent.VK_A:
                        pressA = false;
                        if (!enSalto) {
                            personaje.sinMovimiento();
                            personaje.noPermitirCambioImgMovimiento(false);
                        }
                        break;
                    case KeyEvent.VK_W:
                        pressW = false;
                        break;
                    case KeyEvent.VK_S:
                        pressS = false;
                        break;
                    case KeyEvent.VK_SPACE:
                        break;
                }
            }
            if((lastKeyPressed == KeyEvent.VK_SPACE) && (key==KeyEvent.VK_D)){
                pressA=false;
                if(!enSalto){
                    personaje.noPermitirCambioImgMovimiento(false);
                }
            }else if ((lastKeyPressed == KeyEvent.VK_SPACE) && (key==KeyEvent.VK_A)){
                pressD=false;
                if(!enSalto){
                    personaje.noPermitirCambioImgMovimiento(false);
                }
            };
            lastKeyPressed=key;
        }
    }
    
    private class EventosTeclado extends KeyAdapter {
        boolean otherKeyPress;
        @Override
        public void keyPressed(KeyEvent e){
//            pressS = false;pressW=false;pressA=false;pressD=false;
            int key = e.getKeyCode();
//            System.out.println("Ultima tecla presionada "+KeyEvent.getKeyText(key));
            switch (key){
                case KeyEvent.VK_D:
//                    if(firstTimeD){firstTimeD = true;};
                    pressD = true;//System.out.println("D");
                    break;
                case KeyEvent.VK_A:
                    pressA = true;//System.out.println("A"+" pressD "+pressD;
                    break;
                case KeyEvent.VK_W:
                    pressW = true;
                    break;
                case KeyEvent.VK_S:
                    pressS = true;
                    break;
                case KeyEvent.VK_SPACE:
                    pressSpace=true;
                    break;
                case KeyEvent.VK_E:
                    break;
                case KeyEvent.VK_Q:
                    break;
            };
            if (!enSalto && pressSpace) {
//                if(firstTimeEnSalto){firstTimeEnSalto = true;}
                personaje.noPermitirCambioImgMovimiento(false);
                pressSpace = true;
                enSalto = true;
//                        System.out.println("Salto");
                velocidadSalto = -25;
            }
            otherKeyPressed(key);
        };
        
        @Override
        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_D:
                    pressD=false;
                    firstTimeD = true;
                    if(!enSalto){
                        personaje.noPermitirCambioImgMovimiento(false);
                        personaje.sinMovimiento();
                    }
                    sonidos.detenerCaminar();
                    break;
                case KeyEvent.VK_A:
                    pressA=false;
                    if(!enSalto){
                        personaje.noPermitirCambioImgMovimiento(false);
                        personaje.sinMovimiento();
                    }
                    sonidos.detenerCaminar();
                    break;
                case KeyEvent.VK_W:
                    pressW=false;
                    break;
                case KeyEvent.VK_S:
                    pressS=false;
                    break;
                case KeyEvent.VK_SPACE:
                    pressSpace=false;
                    break;
                case KeyEvent.VK_RIGHT:
                    System.out.println("MOVE RIGHT MoverImgMapa++");
                    moverImgMapa++;
                    break;
                case KeyEvent.VK_LEFT:
                    if(moverImgMapa>0){
                    System.out.println("MOVE LEFT MoverImgMapa--");
                    moverImgMapa--;}else{System.out.println("Distancia minima");}
                    break;
                case KeyEvent.VK_E:
                    sonidos.musicaFondo.stop();
//                    sonidos.musicaFondo.reproducir();
                    break;
                case KeyEvent.VK_Q:
                    perdidaDeVida();
                    break;
            }
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
        }
        
    }
    
    public void revivir(int time) {
        timeTrue = new TimerTask() {
            @Override
            public void run() {
                tiempoDelay = true;
            }
        };
        timer2.schedule(timeTrue, time);
    };
    
    public void matarRevivir(){
        tiempoDelay=true;
        timeTrue.cancel();
    }
    
    public boolean colisionoBajando(boolean colisionoBoolean){
        for (MapaColision colisiono : colisionMovY) {
                if (personajeColisionPies.intersects(colisiono.getCollisionBloqueUp())) {
                    colisionoBoolean = true;
                };
            }
            for (MapaColision colisiono : colisionMovXY) {
                if (personajeColisionPies.intersects(colisiono.getCollisionBloqueUp())) {
                    colisionoBoolean = true;
                };
            };
            return colisionoBoolean;
    };
    
    private void ajustarImagen(){
//        personaje.noPermitirCambioImgMovimiento(false);
        switch (personaje.getNumImagen()) {
            case 10:
                personaje.setNumImagen(14);//System.out.println("Era 10 ahora soy 14");
                personaje.sentidoDeMovimiento(false);
                break;
            case 11:
                personaje.setNumImagen(15);//System.out.println("Era 10 ahora soy 15");
                personaje.sentidoDeMovimiento(false);
                break;
            case 12:
                personaje.setNumImagen(16);//System.out.println("Era 10 ahora soy 16");
                personaje.sentidoDeMovimiento(false);
                break;
            case 13:
                personaje.setNumImagen(17);//System.out.println("Era 10 ahora soy 17");
                personaje.sentidoDeMovimiento(false);
                break;
            case 14:
                personaje.setNumImagen(10);
                personaje.sentidoDeMovimiento(true);
                break;
            case 15:
                personaje.setNumImagen(11);
                personaje.sentidoDeMovimiento(true);
                break;
            case 16:
                personaje.setNumImagen(12);
                personaje.sentidoDeMovimiento(true);
                break;
            case 17:
                personaje.setNumImagen(13);
                personaje.sentidoDeMovimiento(true);
                break;
        }
    }
    
    public boolean colisionoIzquierda(boolean colisionoBoolean){
        if (tiempoDelay == true && !enSalto) {//ESTE IF NO PERTENECE A ESTA FUNCION
                    tiempoDelay = false;
                    personaje.sentidoDeMovimiento(false,'r');//r=run
                    personaje.setNumImagen(personaje.getNumImagen() + 1);
                    if (personaje.getNumImagen() == 10) {
                        personaje.setNumImagen(6);
                    }
                    revivir(100);
                };
                for (MapaColision colisiono : colisionMovX) {
                    if (personajeColision.intersects(colisiono.getCollisionBloquexyRight())) {;
                        colisionoBoolean = true;
                    }
                };
                for (MapaColision colisiono : colisionMovXY) {
                    if (personajeColision.intersects(colisiono.getCollisionBloquexyRight())) {
                        colisionoBoolean = true;
                    };
                };
                if(personajeColision.intersects(this.colisionBloqueLargoIzquierda.getColisionBloque())){
                    colisionoBoolean = true;
                };
                return colisionoBoolean;
    }
    
    public boolean colisionoDerecha(boolean colisionoBoolean){
        if (tiempoDelay == true && !enSalto) {//ESTE IF NO PERTENECE A ESTA FUNCION
                    tiempoDelay = false;
                    personaje.sentidoDeMovimiento(true,'r');//r=run
                    personaje.setNumImagen(personaje.getNumImagen() + 1);
                    if (personaje.getNumImagen() == 5) {
                        personaje.setNumImagen(1);
                    }
                    revivir(100);
                };
                for (MapaColision colisiono : colisionMovX) {
                    if (personajeColision.intersects(colisiono.getCollisionBloquexyLeft())) {;
                        colisionoBoolean = true;
                    }
                };
                for (MapaColision colisiono : colisionMovXY) {
                    if (personajeColision.intersects(colisiono.getCollisionBloquexyLeft())) {
                        colisionoBoolean = true;
                    };
                };
                if(personajeColision.intersects(this.colisionBloqueLargoDerecha.getColisionBloque())){
                    colisionoBoolean=true;
                }
                return colisionoBoolean;
    }
    
    @Override
    public void paintComponent(Graphics g) {
//        System.out.println("PressD "+pressD+" PressA "+pressA);
//        System.out.println("Timepo delay = "+tiempoDelay);
//        System.out.println("PressD="+pressD);
//        System.out.println("enSalto="+enSalto);
//        System.out.println("ContadorDelays="+contadorDelays);
        boolean colisionoBoolean;
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        mapa1(g);//Crear el mapa, se encarga de pintarlo
        if (contadorDelaysSalto >= velocidadDelaySalto) {
            if (enSalto) {//Salto
//                if(firstTimeEnSalto){firstTimeEnSalto=false;}
                if(!sonidos.salto.reproducido){sonidos.reproducirSalto();}
                colisionoBoolean = false;
                if((pressD && personaje.getUnidadAnchoImagenOriginal()<0) || (pressA && personaje.getUnidadAnchoImagenOriginal()>0)){
//                    System.out.println("Entre con "+personaje.getNumImagen());
                        ajustarImagen();
                    }
                if (tiempoDelay == true) {//System.out.println("No permitir cambio de img "+personaje.isNoPermitirCambioImgMovimiento());
//                    System.out.println("NO PERMITIR CAMBIO DE MOVIMIENTO "+personaje.isNoPermitirCambioImgMovimiento());
                    tiempoDelay = false;//System.out.println("Numero de imangen Inicio "+personaje.getNumImagen());
                    personaje.setNumImagen(personaje.getNumImagen() + 1);
                    personaje.sentidoDeMovimiento('j');//j=jump
//                    System.out.println("Numero de imange "+personaje.getNumImagen());
                    switch(personaje.getNumImagen()){
                        case 10:
                            revivir(100);
                            break;
                        case 11:
                            revivir(200);
                            break;
                        case 12:
                            revivir(200);
                            break;
                        case 13:
                            revivir(10000);
                            break;
                        case 14:
                            revivir(100);
                            break;
                        case 15:
                            revivir(200);
                            break;
                        case 16:
                            revivir(200);
                            break;
                        case 17:
                            revivir(10000);
                            break;
                        default:
                            personaje.setNumImagen(personaje.getNumImagen());
                            revivir(10000);
                            break;
                    }
//                    System.out.println("Num imagen"+personaje.getNumImagen());
                };
                if (velocidadSalto < 0) {//Sube
                    personaje.moveUP();
                } else {//Baja
                    colisionoBoolean = colisionoBajando(colisionoBoolean);
                    if (colisionoBoolean == true) {//Si toca con el suelo deja de bajar
                        enSalto = false;
                        personaje.sinMovimiento();
                        sonidos.detenerSalto();
//                        personaje.noPermitirCambioImgMovimiento(false); ¿BORRAR?
                        matarRevivir();
                    } else {
                        personaje.moveDown();
                    };
                };
                velocidadSalto += gravedad;
            };
            contadorDelaysSalto=0;
//            moverPj(g,true);//BORRAR
        }else{contadorDelaysSalto++;};
        
        if(contadorDelays>=velocidadDelay){
            if (pressS == true) {
                colisionoBoolean = false;
                colisionoBoolean = colisionoBajando(colisionoBoolean);
                if (!colisionoBoolean) {
                    personaje.moveDown();
                };
                pressS = false;
            };

        if (pressW == true) {
            colisionoBoolean=false;
            for (MapaColision colisiono : colisionMovY) {
                if (personajeColision.intersects(colisiono.getCollisionBloqueUp())) {
                    colisionoBoolean = true;
                };
            };
            for (MapaColision colisiono : colisionMovXY) {
                if (personajeColision.intersects(colisiono.getCollisionBloquexyDown())) {
                    colisionoBoolean = true;
                };
            };
            if (!colisionoBoolean) {
                personaje.moveUP();
            };
        };
        
        if (pressA == true) {
                colisionoBoolean = false;
                reproducirSonidoSalto();
                colisionoBoolean = colisionoIzquierda(colisionoBoolean);
                if (!colisionoBoolean) {
                        if((moverMapa%unidadMapaGrande!=0 || moverImgMapa !=0) && (personaje.getPositionX()<=cuadroInicioMovMapaPersonaje*unidadMapaGrande)){
                            moverMapa += scale;
                            if(moverMapa==posInicioCreacionMapa+unidadMapaGrande){//if(moverMapa==posInicioCreacionMapa+1*unidadMapaGrande){
                                moverImgMapa--;
                                moverMapa= posInicioCreacionMapa;
                            }
                        }else{personaje.moveLeft();}
                };
        };
        
        if (pressD) {
//            if(firstTimeD){sonidos.reproducirCaminar();firstTimeD=false;}
                reproducirSonidoSalto();
                colisionoBoolean = false;
                colisionoBoolean = colisionoDerecha(colisionoBoolean);
                if (!colisionoBoolean) {
//                    System.out.println("Personaje posicion" + personaje.getPositionX() + "=" + 7 * unidadMapaGrande);
//                    System.out.println("Mover mapa "+moverMapa);
//                    System.out.println("posicion x"+personaje.getPositionX()+">="+cuadroInicioMovMapaPersonaje * unidadMapaGrande);
                    if((moverMapa%unidadMapaGrande!=0 || moverImgMapa!=9) && (personaje.getPositionX() >= cuadroInicioMovMapaPersonaje * unidadMapaGrande)){
                        moverMapa-=scale;
                        if(moverMapa==posInicioCreacionMapa-unidadMapaGrande){//if(moverMapa==posInicioCreacionMapa-1*unidadMapaGrande){
                            moverImgMapa++;
                            moverMapa=posInicioCreacionMapa;//posInicioCreacionMapa
                        }
                    }else{personaje.moveRight();}
                };
//                moverPj(g,true);//BORRAR
        };
        
            /*Gravity*/
        if ((pressA || pressD || !haySuelo) && !enSalto) {
                colisionoBoolean = false;
                haySuelo = colisionoBajando(colisionoBoolean);
                if (!haySuelo) {
                    personaje.moveDown();
                };
            };
            personaje.positionXYEqualsPositionXYPaint();//Se encarga de que la imagen coincida con la colision
            contadorDelays = 0;
        } else {contadorDelays++;};
        moverPj(g, true);
        colisionConBloqueCaida();
        
        drawVida(g);
        
    }
    
    public void reproducirSonidoSalto(){
        if(!sonidos.caminar.reproducido && !enSalto){sonidos.reproducirCaminar();}
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    };
    
    public void colisionConBloqueCaida(){
        if(personajeColision.intersects(this.colisionBloqueLargoCaida.getColisionBloque())){
            personaje.setPosicionX(0);
            personaje.setPosicionY(0);
            perdidaDeVida();
            this.sonidos.caida.reproducir();
            terminoJuego();
        }
    }
    
    public void perdidaDeVida(){
        this.personaje.disminuirVida();
        this.sonidos.perdidaDeVida.reproducir();
        animacionPerdidaVida();
    }
    
    public void animacionPerdidaVida(){
        Thread animacion = new Thread(new Animacion(100,this.personaje.getPosicionesDeImgAnimacionVidaPerdida(),personaje));
        animacion.start();
    }
    
    public void terminoJuego(){
        if(this.personaje.getVidas()==0){
            System.out.println("Game Over");
        }
    }
    
    public  void drawVida(Graphics g){   
        g.drawImage(personaje.getVidaImage(),0, 0, personaje.getAnchoImgVida()*scale, personaje.getAltoImgVida()*scale,
        this.personaje.getPosXImgVidaPaint(), this.personaje.getPosYImgVidaPaint(), this.personaje.getPosXImgVidaPaint()+personaje.getAnchoImgVida(), this.personaje.getPosYImgVidaPaint()+this.personaje.getAltoImgVida(),this);
//        System.out.println(this.personaje.getPosXImgVidaPaint()+","+this.personaje.getPosYImgVidaPaint());
//        System.out.println(personaje.getPosXImgVidaPaint()+","+personaje.getPosYImgVidaPaint()+","+(this.personaje.getPosXImgVidaPaint()+personaje.getAnchoImgVida())+","+(this.personaje.getPosYImgVidaPaint()+this.personaje.getAltoImgVida()));
//        g.drawRect(0, 0, this.personaje.getAnchoImgVida()*scale, this.personaje.getAltoImgVida()*scale);
//        g.drawImage(this.personaje.getVidaImage(), 0, 0, this);
//        g.drawImage(this.personaje.getVidaImage(), unidadMapaGrande, unidadMapaGrande, this.personaje.getAnchoImgVida(), this.personaje.getAltoImgVida(), this);
    }
    
    public void mapa1(Graphics g){
        colisionMovX.clear();
        colisionMovY.clear();
        colisionMovXY.clear();
        Image fondo = loadImage("Tiles.png");
        for(int posY=0;posY<8;posY++){
            for (int posX=0; posX<19; posX++) {//Largo
                if(mapa[posY][posX+moverImgMapa][0][0]!=-1){//En caso de que haya fondo se ejecuta
                //Dibuja el fondo de la imagen g.drawImage(Imagen que va, posicion en pixeles de la columna donde empieza, posicion en pixeles de la fila donde empieza, posicion en pixeles de la columna donde termina, posicion en pixeles de la fila donde termina,
                //Esta parte se encarga de recotar la imagen original... posicion de la columna, posicion de la fila, posicion final de la columna,posicion final de la fila, this)
                
                g.drawImage(fondo,posX*unidadMapaGrande+moverMapa,posY*unidadMapaGrande,posX*unidadMapaGrande+unidadMapaGrande+moverMapa,posY*unidadMapaGrande+unidadMapaGrande,
                mapa[posY][posX+moverImgMapa][0][0]*unidadMapaOriginal,mapa[posY][posX+moverImgMapa][0][1]*unidadMapaOriginal,mapa[posY][posX+moverImgMapa][0][0]*unidadMapaOriginal+16,mapa[posY][posX+moverImgMapa][0][1]*unidadMapaOriginal+16, this);
                };
                
                g.drawImage(fondo,posX*unidadMapaGrande+moverMapa,posY*unidadMapaGrande,posX*unidadMapaGrande+unidadMapaGrande+moverMapa,posY*unidadMapaGrande+unidadMapaGrande,
                mapa[posY][posX+moverImgMapa][1][0]*unidadMapaOriginal,mapa[posY][posX+moverImgMapa][1][1]*unidadMapaOriginal,mapa[posY][posX+moverImgMapa][1][0]*unidadMapaOriginal+16,mapa[posY][posX+moverImgMapa][1][1]*unidadMapaOriginal+16, this);   

                agregarColision(mapa[posY][posX+moverImgMapa][1][2],posX,posY,this.scale,g,moverMapa);
            };
        };
        //bloque de caida
        this.colisionBloqueLargoCaida = new ColisionBloqueLargo(0,8,this.scale,g,18,1);
        //bloque de la derecha
        this.colisionBloqueLargoDerecha = new ColisionBloqueLargo(18+cuadroInicioMapa,0,this.scale,g,2,8);
        //bloque de la izquierda
        this.colisionBloqueLargoIzquierda = new ColisionBloqueLargo(cuadroInicioMapa,0,this.scale,g,1,8);
        //Barras de mov del mapa
        g.drawRect(posInicioCreacionMapa, 0, unidadMapaGrande, 8*unidadMapaGrande);//Barra inicial
//        g.drawRect(18*unidadMapaGrande+posInicioCreacionMapa, 0, unidadMapaGrande, 8*unidadMapaGrande);//Barra finañ
    }
    
    public void agregarColision(int agregarColision, int x, int y, int scale, Graphics g,int moverMapa) {
        
        switch (agregarColision) {
            case 1:
                this.colisionMovY.add(new MapaColision(x, y, this.scale, g, "y",moverMapa));
                break;
            case 2:
                this.colisionMovX.add(new MapaColision(x, y, this.scale, g, "x",moverMapa));
                break;
            case 3:
                this.colisionMovXY.add(new MapaColision(x, y, this.scale, g, "xy",moverMapa));
                break;
        };
    };
    
    public void moverPj(Graphics g,boolean pintar){
//        System.out.println("Mover pj");//BORRAR
        //Dibuja el rectangulo de la colision
        personajeColision = new 
         Rectangle(this.personaje.getPositionX()+2*scale,this.personaje.getPositionY(),this.personaje.getUnidadAnchoRun()-4*scale,this.personaje.getUnidadAltoRun()-1*scale);
        //Dibuja un rectangulo que ,muestra el rectangulo de la colision, para que se pueda ver en pantalla
//        g.drawRect(personajeColision.x,personajeColision.y,personajeColision.width,personajeColision.height);

        //pies
        personajeColisionPies = new
        Rectangle(this.personaje.getPositionX()+2*scale,this.personaje.getPositionY()+this.personaje.getUnidadAltoRun()-1*scale,this.personaje.getUnidadAnchoRun()-4*scale,1*scale); 
        //Dibuja pies
//        g.setColor(Color.RED);
//        g.drawRect(personajeColisionPies.x,personajeColisionPies.y,personajeColisionPies.width,personajeColisionPies.height);
//        g.setColor(Color.BLUE);
        
        if(pintar){//Dibuja la imagen
            g.drawImage(this.personaje.getPjImage(),this.personaje.getPositionXPaint(),this.personaje.getPositionYPaint(),this.personaje.getPositionXPaint()+this.personaje.getUnidadAnchoRun(),this.personaje.getPositionYPaint()+this.personaje.getUnidadAltoRun(),
                this.personaje.numeroDeImagenAncho(),this.personaje.numeroDeImagenAlto(),this.personaje.numeroDeImagenAncho()+this.personaje.getUnidadAnchoImagenOriginal(),this.personaje.numeroDeImagenAlto()+this.personaje.getUnidadAltoImagenOriginal(), this);//6,2
        };
    };

    public int getScale() {//Retoruna el tamaño al que se aumenta el juego 1 = originial, 2 = al doble de grande, 3 = triple de grande etc...
        return scale;
    }
    
}
