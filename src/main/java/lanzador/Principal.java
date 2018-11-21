package lanzador;


import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import modelo.*;


public class Principal{


    public static void main(String[] args) {

        Pelicula p1 = new Pelicula("Chavo", "", "Chavo del 8", "Tarantino", "2:00:00", Formato.MP4);
        Pelicula p2 = new Pelicula("", "Emma Wattson", "Toy story", "Spielberg", "2:30:00", Formato.MP4);
        Pelicula p3 = new Pelicula("Paul Walker", "Jenniffer Aniston", "Frozen", "Woody Allen", "1:40:00", Formato.MP4);
        
        
        /*
        Probando el caso en que no se le ingresa ni actor ni actriz principal:
        -Si esto pasa, se vacían los datos del objeto (solo queda el formato ya que no puede esar vacío)
        -Si los datos del objeto están vacíos, no se podrá agregar a la lista
        */
        Pelicula p4 = new Pelicula("", "", "Naranja Mecanica", "Cubrik", "2:40:00", Formato.MPG);
        
        Disco d1 = new Disco(Genero.ROCK, "No vives de ensalada", "Europe", "00:03:30", Formato.MP3);
        Disco d2 = new Disco(Genero.POP, "Bar de Moe", "Madonna", "00:04:43", Formato.MP3);
        Disco d3 = new Disco(Genero.FUNK, "La pollera colora", "Sex Pistols", "00:03:35", Formato.MP3);

        /*
        Probando el método equals() para disco y película
        */        
        Pelicula p5 = new Pelicula("Gonzalo Valenzuela", "", p3.getTitulo(), p3.getAutor(), "1:40:00", Formato.MP4);
        System.out.println("Dos películas con el mismo título y autor (probando método equals):");
        System.out.println(p3.equals(p5));//devuelve true
        
        Disco d4 = new Disco(Genero.POP, d1.getTitulo(), d1.getAutor(), "00:05:10", Formato.MP3);
        System.out.println("Dos discos con el mismo título y autor (probando método equals):");
        System.out.println(d1.equals(d4));//devuelve true
        
        ListaMultimedia lista = new ListaMultimedia();

        lista.agregar(p1);
        lista.agregar(p2);
        lista.agregar(p3);
        lista.agregar(p4);
        System.out.println("Agregando multimedia con campos vacíos a la lista multimedia: ");
        System.out.println(lista.agregar(p4));//devuelve false
        lista.agregar(d1);
        lista.agregar(d2);
        lista.agregar(d3);
        
        System.out.println("********************");
        
        int indice = lista.obtenerIndice(p3);
        Multimedia multObtenido = lista.obtenerObjeto(indice);
        
        System.out.println("Índice de "+p3+" en la lista: "+indice);
        
        System.out.println("Obteniendo multimedia en el índice "+indice+": "+multObtenido);
        
        indice = lista.obtenerIndice(d3);
        multObtenido = lista.obtenerObjeto(indice);
        
        System.out.println("Índice de "+d3+" en la lista: "+indice);
        
        System.out.println("Obteniendo multimedia en el índice "+indice+": "+multObtenido);
        
        
        
        System.out.println("");
        
        System.out.println("********************");
        System.out.println("Mostrando el contenido de la lista multimedia:");
        System.out.println(lista);
        

        JComboBox optionList = new JComboBox();

        for (int i = 0; i < lista.obtenerTamanio(); i++) {
            optionList.addItem(lista.obtenerObjeto(i));
        }

        
        
        JOptionPane.showMessageDialog(null, "Bienvenido al reproductor multimedia \n"
                + "Nota: este reproductor no puede ejecutar más de un video en la misma ejecución");
        
        while (true) {

            
            JOptionPane.showMessageDialog(null, optionList, "Selector multimedia",
                    JOptionPane.QUESTION_MESSAGE);

            
            int indiceElegido = optionList.getSelectedIndex();
            Multimedia multElegido = lista.obtenerObjeto(indiceElegido);

            
            
            multElegido.reproducir();

            
            int continuar = JOptionPane.showConfirmDialog(null, "¿Desea seguir en el programa?", "Alerta",
                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

            if (continuar == 1) {
                System.exit(0);
            }

        }

    }

    
    
    
}
