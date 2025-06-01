package com.mycompany.proyecto;

public class Jugador {
    private String nombre;
    private int victorias;
    protected char simbolo;
    
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
    public boolean hacerMovimiento(Tablero tablero, int fila, int columna){
        if(tablero.esCeldaVacia(fila, columna)){
            tablero.colocarMovimiento(fila, columna, simbolo);
            return true;
        }else{
            System.out.println("¡Error interno del tablero! La celda ya está ocupada o las coordenadas son inválidas.");
            return false;
        }
    }
}
