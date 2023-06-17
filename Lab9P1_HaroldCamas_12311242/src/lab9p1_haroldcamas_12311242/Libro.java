package lab9p1_haroldcamas_12311242;
import java.util.ArrayList;

public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private int edad_minima;
    
    Libro(){}
    
    Libro(String tituloN,String autorN,String generoN,int edad_minimaN){
        this.titulo = tituloN;
        this.autor = autorN;
        this.genero = generoN;
        this.edad_minima = edad_minimaN;
    }
    
    //getters
    public String getTitulo(){
        return this.titulo;
    }
    
    public String getAutor(){
        return this.autor;
    }
    
    public String getGenero(){
        return this.genero;
    }
    
    public int getEdad(){
        return this.edad_minima;
    }
    
    //setters
    public void setTitulo(String tituloN){
        this.titulo = tituloN;
    }
    
    public void setAutor(String autorN){
        this.autor = autorN;
    }
    
    public void setGenero(String generoN){
        this.genero = generoN;
    }
    
    public void setEdad(int edad){
        this.edad_minima = edad;
    }
       
}