package modelo;

import java.util.ArrayList;

public class ListaMultimedia {

    public ArrayList<Multimedia> listaMultimedia;
    
    public ListaMultimedia(){
         listaMultimedia= new ArrayList<>();
    }

    public int obtenerTamanio() {
        return listaMultimedia.size();
    }

    /**
     * Agrega un multimedia a la lista
     * @param multi es el multimedia a agregar
     * @return False si los campos del objeto están vacíos y True en caso contrario
     */
    public boolean agregar(Multimedia multi) {
        
        if(multi.toString().equals("."+multi.formato))
            return false;
        
        listaMultimedia.add(multi);

        return true;
    }

    public Multimedia obtenerObjeto(int i) {
        return listaMultimedia.get(i);
    }

    public int obtenerIndice(Multimedia multi) {
         if(listaMultimedia.contains(multi))
             return listaMultimedia.indexOf(multi);
         else
             return -1;
    }

    @Override
    public String toString() {
        //return "ListaMultimedia{" + "listaMultimedia=" + listaMultimedia + '}';
        
        String out = "";
        for(Multimedia multimedia: this.listaMultimedia){
        out += "\n Título: "+multimedia.titulo+"\n Autor:"+multimedia.autor+"\n Duración:"+multimedia.duracion+"\n ********************";
        
        }
        return out;
        
    }

    

    
}
