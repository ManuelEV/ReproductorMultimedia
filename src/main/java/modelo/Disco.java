package modelo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Disco extends Multimedia {

    public Disco(Genero genero, String titulo, String autor, String duracion, Formato formato) {
        super(titulo, autor, duracion, formato);
        this.genero = genero;
    }

    public Genero genero;

    @Override
    public String toString() {
        return super.titulo+"."+super.formato;
        //Esta sería el toString() "completo", decidí dejarlo un tanto mas simple para que se ve bien en el menú
        //return super.toString() + "Disco{" + " genero=" + genero + '}';
    }

    public Genero getGenero() {
        return genero;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo canción...");

        try {
            String workingDir = System.getProperty("user.dir");
            FileInputStream fis;
            Player player;
            fis = new FileInputStream(workingDir + "\\" + "archivos"+ "\\" +this.titulo+"."+this.formato);

            BufferedInputStream bis = new BufferedInputStream(fis);

            player = new Player(bis);

            player.play();

            if (player.isComplete()) {
                player.close();
                System.out.println("Canción terminada");
            }

        } catch (JavaLayerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }

}
