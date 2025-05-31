package com.mycompany.proyecto;
import java.util.Random;

public class ComputadorF extends Jugador{
    public ComputadorF (char simbolo){
        super("BotFacil",simbolo);
    }
    public boolean hacerMovimiento(){
        //pedir tablero
        Random rand = new Random();
        //while esCeldaVacia==false
        int fila = rand.nextInt(3);
        int columna = rand.nextInt(3);
        //colocarMovimiento(fila, columna) y return true
        return true;
    }
}
