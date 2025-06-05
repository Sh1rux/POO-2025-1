package com.mycompany.proyecto;
import java.util.Random;

public class ComputadorF extends Jugador{
    public ComputadorF (char simbolo){
        super("BotFacil",simbolo);
    }
    @Override
    public boolean hacerMovimiento(Tablero tablero,int a, int b){
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
/*Metodos
Constructor, solo recibe un simbolo y genera un usuario llamado bot facil
hacerMovimiento(recibe el tablero):genera un movimiento totalmente al azar y coloca su simbolo en esa ubicacion
*/
