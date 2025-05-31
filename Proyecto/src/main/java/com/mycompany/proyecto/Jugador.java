package com.mycompany.proyecto;

public class Jugador {
    private String nombre;
    private int victorias;
    private char simbolo;
    
    public Jugador(String nombre, char simbolo){
        this.nombre=nombre;
        this.simbolo=simbolo;
        this.victorias=0;
    }
    public String getNombre(){
        return nombre;
    }
    public char getSimbolo(){
        return simbolo;
    }
    public int getVictorias(){
        return victorias;
    }
    public boolean hacerMovimiento(int fila, int columna){
        //Agregar tablero a los pedidos
        //if esCeldaVacia
        //true:colocarMovimiento y return true
        return true;
    }
}
