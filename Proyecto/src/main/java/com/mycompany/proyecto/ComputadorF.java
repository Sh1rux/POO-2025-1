package com.mycompany.proyecto;
import java.util.Random;

public class ComputadorF extends Jugador{
    public ComputadorF (char simbolo){
        super("BotFacil",simbolo);
    }
    public boolean hacerMovimiento(Tablero tablero){
        Random rand = new Random();
        int fila = rand.nextInt(3);
        int columna = rand.nextInt(3);
        while (tablero.esCeldaVacia(fila, columna)== false){
            fila = rand.nextInt(3);
            columna = rand.nextInt(3);
        }
        tablero.colocarMovimiento(fila, columna, simbolo);
        return true;
    }
}
