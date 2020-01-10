package GUI.Desktop;


import javax.imageio.ImageIO;
import javax.swing.*;

import Clases.Peces.Pecera;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class PintarPeceraThread extends Thread{
    
	private Image imagenRojo = null;
    private Image imagenAzul = null;
    private Image imagenPez = null;
    private JPanel panelPrincipal = null;
    private Pecera pecera ;

    public PintarPeceraThread(JPanel panelPrincipal, Pecera pecera) {
        this.panelPrincipal = panelPrincipal;
        this.pecera = pecera;
    }

    @Override
    public void run() {
        System.out.println("Pintar pecera thread inicializado");

        try {
        	imagenPez = ImageIO.read(new File("pez.png"));
            imagenAzul = ImageIO.read(new File("azul.png"));
             imagenRojo = ImageIO.read(new File("Rojo.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        while (true) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           // panelPrincipal.getGraphics().clearRect(0,0, 1000, 500);
            panelPrincipal.getGraphics().clearRect(0, 0, 1000, 1000);

            for (int i = 0; i < pecera.getLosObjetos().size(); i++) {
                if (pecera.getLosObjetos().get(i).getClass().getSimpleName().equalsIgnoreCase("PescadoEntity")){
                    panelPrincipal.getGraphics().drawImage(imagenPez,pecera.getLosObjetos().get(i).getLaPosicion().getX(), pecera.getLosObjetos().get(i).getLaPosicion().getY(),20,10,null);
                }
                if (pecera.getLosObjetos().get(i).getClass().getSimpleName().equalsIgnoreCase("CoralRojoEntity")) {
                    panelPrincipal.getGraphics().drawImage(imagenRojo, pecera.getLosObjetos().get(i).getLaPosicion().getX(), pecera.getLosObjetos().get(i).getLaPosicion().getY(), 100, 100, null);
                }
                if (pecera.getLosObjetos().get(i).getClass().getSimpleName().equalsIgnoreCase("CoralAzulEntity")) {
                    panelPrincipal.getGraphics().drawImage(imagenAzul, pecera.getLosObjetos().get(i).getLaPosicion().getX(), pecera.getLosObjetos().get(i).getLaPosicion().getY(), 100, 100, null);
                }
                
             }
          }
     }
}

