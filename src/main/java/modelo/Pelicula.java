package modelo;

import java.io.File;

import static modelo.VideoManager.archivo;

public class Pelicula extends Multimedia {

    private String actorPrincipal;
    private String actrizPrincipal;

    public Pelicula(String actorPrincipal, String actrizPrincipal, String titulo, String autor, String duracion, Formato formato) {
        super(titulo, autor, duracion, formato);

        this.actorPrincipal = actorPrincipal;
        this.actrizPrincipal = actrizPrincipal;
        
        //Si la pelicula no tiene actor ni actriz principal, se vacían los datos del objeto (menos el formato)
        if (!peliculaValida()) 
            vaciarDatos();

    }

    public boolean peliculaValida() {
        return !(actorPrincipal.equals("") && actrizPrincipal.equals(""));
    }

    public void vaciarDatos() {
        this.actorPrincipal = "";
        this.actrizPrincipal = "";
        this.autor = "";
        this.duracion = "";
        this.titulo = "";
    }

    @Override
    public String toString() {
        return super.titulo + "." + super.formato;
        //Esta sería el toString() "completo", decidí dejarlo un tanto mas simple para que se ve bien en el menú
        //return super.toString() + " Pelicula{" + "actorPrincipal=" + actorPrincipal + ", actrizPrincipal=" + actrizPrincipal + '}';
    }

    public String getActorPrincipal() {
        return this.actorPrincipal;
    }

    public String getActrizPrincipal() {
        return this.actrizPrincipal;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo video...");
        String workingDir = System.getProperty("user.dir");

        archivo = new File(workingDir, "\\" + "archivos" + "\\" + this.titulo + "." + this.formato);

        VideoManager.reproducirVideo();

    }
}
