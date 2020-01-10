package GUI.Desktop;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class EjecutarSonido extends Thread{
    private File file = null;

    public EjecutarSonido(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
            clip.open(inputStream);
            clip.start();
        } catch (Exception e1) {
            System.err.println(e1.getMessage());
        }
    }
}
