package com.mycompany.proyecto;

public class Proyecto {

    public static void main(String[] args) {
        //Prueba de funciones hacerMovimiento, tambien se probo el modo facil.
        Tablero partida= new Tablero();
        Jugador jugador1 = new Jugador("Hassel",'X');
        ComputadorM jugador2 = new ComputadorM('O');
        partida.imprimirTablero();
        jugador1.hacerMovimiento(partida, 0, 0);
        jugador1.hacerMovimiento(partida, 1, 2);
        jugador2.hacerMovimiento(partida);
        partida.imprimirTablero();
    }
}
