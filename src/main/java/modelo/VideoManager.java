/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 *
 * @author Manuel
 */
public class VideoManager extends Application {

    public static File archivo;
    
    public static void reproducirVideo() {
        try {
            launch();
        } catch (IllegalStateException e) {
            System.out.println("No puede reproducir más de una vez un video");
            System.out.println("Error: "+ e);
            System.out.println("Si lo desea, intente reproducir un archivo de audio");
        }
    }

    @Override
    public void start(Stage primaryStage) {

        Media m = new Media(archivo.toURI().toString());
        MediaPlayer mp = new MediaPlayer(m);
        MediaView mv = new MediaView(mp);

        StackPane root = new StackPane();
        root.getChildren().add(mv);

        primaryStage.setScene(new Scene(root, 960, 540));
        primaryStage.setTitle("Reproductor");
        primaryStage.show();
        mp.setVolume(0.5);

        mp.play();

        //Referencia:
        //http://what-when-how.com/javafx-2/playing-video-using-the-media-classes-javafx-2/
    }

}
