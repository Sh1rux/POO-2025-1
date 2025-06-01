package com.mycompany.proyecto;
import java.util.Random;

public class ComputadorM extends Jugador{
    private int fila = 0;
    private int columna = 0;
    public ComputadorM (char simbolo){
        super("BotMedio",simbolo);
    }
    private boolean posibleVictoria(Tablero tablero){
        char s;
        if (this.simbolo=='O')
            s='X';
        else
            s='O';
        for (int i = 0; i < 3; i++) {
            int conteo = 0;
            int vacio = -1;
            for (int j = 0; j < 3; j++) {
                if (tablero.getCelda(i,j)== s) conteo++;
                else if (tablero.getCelda(i,j) == ' ') vacio = j;
            }
            if (conteo == 2 && vacio != -1){
                fila = i;
                columna = vacio;
                return true;
            }
        }

        // Verificar columnas
        for (int j = 0; j < 3; j++) {
            int conteo = 0;
            int vacio = -1;
            for (int i = 0; i < 3; i++) {
                if (tablero.getCelda(i,j) == s) conteo++;
                else if (tablero.getCelda(i,j) == ' ') vacio = i;
            }
            if (conteo == 2 && vacio != -1){
                fila = vacio;
                columna = j;
                return true;
            }
        }

        // Verificar diagonal principal
        int conteo = 0;
        int vacio = -1;
        for (int i = 0; i < 3; i++) {
            if (tablero.getCelda(i,i) == s) conteo++;
            else if (tablero.getCelda(i,i) == ' ') vacio = i;
        }
        if (conteo == 2 && vacio != -1) {
            fila = vacio;
            columna = vacio;
            return true;
        }

        // Verificar diagonal secundaria
        conteo = 0;
        vacio = -1;
        for (int i = 0; i < 3; i++) {
            if (tablero.getCelda(i,2-i) == s) conteo++;
            else if (tablero.getCelda(i,2-i) == ' ') vacio = i;
        }
        if (conteo == 2 && vacio != -1){
            fila = vacio;
            columna = 2 - vacio;
            return true;
        }else{
            return false;
        }
    }
    public boolean hacerMovimiento(Tablero tablero){
        //pedir tablero
        if (posibleVictoria(tablero)){
            tablero.colocarMovimiento(fila, columna, simbolo);
            return true;
        }else{
            Random rand = new Random();
            fila = rand.nextInt(3);
            columna = rand.nextInt(3);
            while (tablero.esCeldaVacia(fila, columna)== false){
                fila = rand.nextInt(3);
                columna = rand.nextInt(3);
            }
            tablero.colocarMovimiento(fila, columna, simbolo);
            return true;
        }
    }
}
