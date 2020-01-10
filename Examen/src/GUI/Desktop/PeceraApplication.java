package GUI.Desktop;



import javax.imageio.ImageIO;
import javax.swing.*;

import Clases.Peces.CoralAzulEntity;
import Clases.Peces.CoralEntity;
import Clases.Peces.CoralRojoEntity;
import Clases.Peces.Pecera;
import Clases.Peces.PescadoControl;
import Clases.Peces.PescadoEntity;
import Clases.Espacio.Posicion;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;

public class PeceraApplication extends JDialog {
    private Pecera pecera = new Pecera("pezland");
    private Random random;
    public JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton buttonAgregarPez;
    private JButton buttonRojo;
    private JPanel panelPrincipal; 
    private JButton buttonPintar; 
    private JButton buttonAzul;
    private JButton buttonLadrar;

    public PeceraApplication() {
        try {
        	FileOutputStream fileOutputStream = new FileOutputStream("pecera.dat");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

            objectOutputStream.writeObject(pecera);
            bufferedOutputStream.flush();

            objectOutputStream.close();
            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < pecera.getLosObjetos().size() ; i++){
            if (pecera.getLosObjetos().get(i).getClass().getSimpleName().equalsIgnoreCase("PescadoEntity")) {
                PescadoControl PescadoControl = new PescadoControl((PescadoEntity) pecera.getLosObjetos().get(i));
                PescadoControl.start();
            }
        }

        PintarPeceraThread pintarPeceraThread = new PintarPeceraThread(panelPrincipal, pecera);
        pintarPeceraThread.start();

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        buttonRojo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CoralEntity unCoralEntity = new CoralRojoEntity("miCoral" + random.nextInt(10000), new Posicion(random.nextInt(1000),random.nextInt(500)), pecera);
                pecera.getLosObjetos().add(unCoralEntity);
                System.out.print(pecera);

                //Image imagenArbol = null;
                //Image imagenPez = null;
                //try {
                //    imagenArbol = ImageIO.read(new File("image.png"));
                //    imagenPez = ImageIO.read(new File("pez.png"));
                //} catch (IOException ex) {
                //    ex.printStackTrace();
                //}
                //panelPrincipal.getGraphics().clearRect(0,0, 1000, 500);

                //for (int i = 0; i < pecera.getLosObjetos().size(); i++) {
                //    if (pecera.getLosObjetos().get(i).getClass().getSimpleName().equalsIgnoreCase("PerroEntity")){
                //        panelPrincipal.getGraphics().drawImage(imagenPez,pecera.getLosObjetos().get(i).getLaPosicion().getX(), pecera.getLosObjetos().get(i).getLaPosicion().getY(),20,10,null);
                //    }else {
                //        panelPrincipal.getGraphics().drawImage(imagenArbol, pecera.getLosObjetos().get(i).getLaPosicion().getX(), pecera.getLosObjetos().get(i).getLaPosicion().getY(), 100, 100, null);
                //    }
                //}

            }
        });
        buttonAgregarPez.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PescadoEntity unPezEntity = new PescadoEntity("miPez" + random.nextInt(10000), new Posicion(random.nextInt(1000),random.nextInt(500)), pecera);
                pecera.getLosObjetos().add(unPezEntity);

                PescadoControl PescadoControl = new PescadoControl(unPezEntity);
                PescadoControl.start();

                System.out.print(pecera);

                //Image imagenArbol = null;
                //Image imagenPez = null;
                //try {
                //    imagenArbol = ImageIO.read(new File("image.png"));
                //    imagenPez = ImageIO.read(new File("pez.png"));
                //} catch (IOException ex) {
                //    ex.printStackTrace();
                //}
                //panelPrincipal.getGraphics().clearRect(0,0, 1000, 500);

                //for (int i = 0; i < pecera.getLosObjetos().size(); i++) {
                //    if (pecera.getLosObjetos().get(i).getClass().getSimpleName().equalsIgnoreCase("PerroEntity")){
                //        panelPrincipal.getGraphics().drawImage(imagenPez,pecera.getLosObjetos().get(i).getLaPosicion().getX(), pecera.getLosObjetos().get(i).getLaPosicion().getY(),20,10,null);
                //    }else {
                //        panelPrincipal.getGraphics().drawImage(imagenArbol, pecera.getLosObjetos().get(i).getLaPosicion().getX(), pecera.getLosObjetos().get(i).getLaPosicion().getY(), 100, 100, null);
                //    }
                //}

            }
        });
        buttonPintar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Image imagenRojo = null;
                Image imagenAzul = null;
                Image imagenPez = null;
                try {
                    imagenAzul = ImageIO.read(new File("azul.png"));
                    imagenRojo = ImageIO.read(new File("Rojo.png"));
                    imagenPez = ImageIO.read(new File("pez.png"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                panelPrincipal.getGraphics().clearRect(0,0, 1000, 500);

                for (int i = 0; i < pecera.getLosObjetos().size(); i++) {
                    if (pecera.getLosObjetos().get(i).getClass().getSimpleName().equalsIgnoreCase("PezEntity")){
                        panelPrincipal.getGraphics().drawImage(imagenPez,pecera.getLosObjetos().get(i).getLaPosicion().getX(), pecera.getLosObjetos().get(i).getLaPosicion().getY(),20,10,null);
                    }
                    if (pecera.getLosObjetos().get(i).getClass().getSimpleName().equalsIgnoreCase("CoralAzulEntity")) {
                        panelPrincipal.getGraphics().drawImage(imagenRojo, pecera.getLosObjetos().get(i).getLaPosicion().getX(), pecera.getLosObjetos().get(i).getLaPosicion().getY(), 100, 100, null);
                    }
                    if (pecera.getLosObjetos().get(i).getClass().getSimpleName().equalsIgnoreCase("CoralRojoEntity")) {
                        panelPrincipal.getGraphics().drawImage(imagenAzul, pecera.getLosObjetos().get(i).getLaPosicion().getX(), pecera.getLosObjetos().get(i).getLaPosicion().getY(), 100, 100, null);
                    }
                }
            }
        });
        contentPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {

            }
        });
        buttonAzul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CoralEntity unCoralEntity = new CoralAzulEntity("miCoral" + random.nextInt(10000), new Posicion(random.nextInt(1000),random.nextInt(500)), pecera);
                pecera.getLosObjetos().add(unCoralEntity);
                System.out.print(pecera);
            }
        });
        buttonLadrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EjecutarSonido sonido = new EjecutarSonido(new File("gallina.wav"));
                sonido.start();
            }
        });
    }

    private void onOK() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("pecera.dat");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

            objectOutputStream.writeObject(pecera);
            bufferedOutputStream.flush();

            objectOutputStream.close();
            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        PeceraApplication dialog = new PeceraApplication();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
