package modelo;



public abstract class Multimedia{

    protected String titulo;
    protected String autor;
    protected String duracion;
    protected Formato formato;

    public Multimedia(String titulo, String autor, String duracion, Formato formato) {
        this.titulo = titulo;
        this.autor = autor;
        this.duracion = duracion;
        this.formato = formato;
    }

    @Override
    public String toString() {
        return "Multimedia{" + "titulo=" + titulo + ", autor=" + autor + ", duracion=" + duracion + ", formato=" + formato + '}';
    }

    public boolean equals(Multimedia multi) {
        return (multi.getAutor().equals(this.getAutor()) 
                && multi.getTitulo().equals(this.getTitulo()));
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getDuracion() {
        return this.duracion;
    }

    public Formato getFormato() {
        return formato;
    }
    
    public abstract void reproducir();
    
}
