package com.mycompany.proyecto;
import java.util.Random;

public class ComputadorM extends Jugador{
    private int [] movimiento = {0,0} ;
    public ComputadorM (char simbolo){
        super("BotFacil",simbolo);
    }
    private boolean posibleVictoria(){
        //pedir tablero
        //if 2 simbolos enemigos seguidos y esCeldaVacia
        return false;
    }
    public boolean hacerMovimiento(){
        //pedir tablero
        if (posibleVictoria()){
            //colocarMovimiento(fila, columna)
            return true;
        }else{
            Random rand = new Random();
            //while esCeldaVacia==false
            int fila = rand.nextInt(3);
            int columna = rand.nextInt(3);
            //colocarMovimiento(fila, columna)
            return true;
        }
    }
}
