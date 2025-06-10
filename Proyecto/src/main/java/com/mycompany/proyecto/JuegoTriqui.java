package com.mycompany.proyecto;

import java.util.Scanner;

public class JuegoTriqui {

    Scanner input = new Scanner(System.in);
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActual;
    private int empates;
    private boolean juegoTerminado;
    private String ModoJuego;

    public JuegoTriqui(){
        this.tablero = new Tablero();
        this.jugador1 = new Jugador("jugador1", 'X');
        this.jugador2 = new Jugador("jugador2", 'O');
        this.jugadorActual = jugador1;
        this.empates = 0;
        this.juegoTerminado = false;
        this.ModoJuego = " ";

    }

    public void actualizarJugador(){
        if (jugadorActual == jugador1){
            this.jugadorActual = jugador2;
        }
        else{
            this.jugadorActual = jugador1;
        }
    }

    public void tipoJuego(){
        System.out.println("Seleccione el tipo de juego:");
        System.out.println("1. Contra otro jugador");
        System.out.println("2. Contra la computadora");
        int opcion = input.nextInt();
        if (opcion == 2){
            System.out.println("Seleccione la dificultad");
            System.out.println("1. Fácil");
            System.out.println("2. Medio");
            int dificultad = input.nextInt();
            if (dificultad == 1){
                this.ModoJuego = "ComputadorF";
                jugador2 = new ComputadorF('O');
            }
            else if (dificultad == 2){
                this.ModoJuego = "ComputadorM";
                jugador2 = new ComputadorM('O');
            }
            else{
                System.out.println("Opción no válida");
            }
        }
        else if(opcion == 1){
            this.ModoJuego = "Dos Jugadores";
        }
        else{System.out.println("Opción no valida");}
    }
    public void registrarJugador(){
        if ("Dos Jugadores".equals(ModoJuego)){
            System.out.println("Ingrese el nombre del jugador 1");
            String nombre = input.next();
            jugador1.setNombre(nombre);
            System.out.println("Ingrese el nombre del jugador 2");
            nombre = input.next();
            jugador2.setNombre(nombre);
        }else{
            System.out.println("Ingrese el nombre del jugador 1");
            String nombre = input.next();
            jugador1.setNombre(nombre);
        }
    }
    public boolean hayGanador(){
                // Verificar filas y columnas
        char simbolo = jugadorActual.getSimbolo();
        for (int i = 0; i < 3; i++) {
            if (tablero.getCelda(i,0) == simbolo && tablero.getCelda(i,1) == simbolo && tablero.getCelda(i,2) == simbolo) {
                return true;
            }
            if (tablero.getCelda(0,i) == simbolo && tablero.getCelda(1,i) == simbolo && tablero.getCelda(2,i) == simbolo) {
                return true;
            }
        }

        // Verificar diagonales
        if ((tablero.getCelda(0,0) == simbolo && tablero.getCelda(1,1) == simbolo && tablero.getCelda(2,2)== simbolo) ||
                (tablero.getCelda(0,2) == simbolo && tablero.getCelda(1,1) == simbolo && tablero.getCelda(2,0) == simbolo)) {
            return true;
        }else{
            return false;
        }
    }
    public void iniciarJuego(){
        String r = ""; // Variable para la respuesta "ver marcador"
        String respuestaJugarOtra = "Si"; 
        int fila = 3;
        int columna = 3;
        while(!this.juegoTerminado){
            tablero.inicializarTablero();
            // Restablecer fila y columna a valores "inválidos" para asegurar que el bucle de validación se ejecute la primera vez
            fila = -1;
            columna = -1;

            while (!tablero.estaLleno()){
                tablero.imprimirTablero();
                System.out.println("Turno de:  "+ jugadorActual.getNombre());

                boolean esComputadora = ("ComputadorF".equals(ModoJuego) || "ComputadorM".equals(ModoJuego));

                if (!esComputadora || !jugadorActual.getNombre().startsWith("Bot")) {
                    while (!tablero.esCeldaVacia(fila, columna)){
                        System.out.println("Ingresa la fila (0,1,2):");
                        fila = input.nextInt();
                        System.out.println("Ingresa la columna (0,1,2):");
                        columna = input.nextInt();
                        if (!tablero.esCeldaVacia(fila, columna))
                            System.out.println("Error. Seleccione otra casilla o coordenadas validas.");
                    }
                }

                jugadorActual.hacerMovimiento(tablero, fila, columna);

                if (hayGanador()){
                    System.out.println(jugadorActual.getNombre()+" es el ganador!!");
                    jugadorActual.setVictorias(jugadorActual.getVictorias()+1);
                    tablero.imprimirTablero();
                    break;
                }

                if (!tablero.estaLleno() && !hayGanador()) {
                    actualizarJugador();
                }

                if (tablero.estaLleno() && !hayGanador()){
                    this.empates++;
                    System.out.println("¡El juego ha terminado en empate!");
                    tablero.imprimirTablero();
                    break;
                }
            }
            
            System.out.println("Desea ver el marcador actual? (Si, No)");
            r = input.next();
            if ("Si".equalsIgnoreCase(r)){
                System.out.println("Victorias totales");
                System.out.println(jugador1.getNombre()+": " +jugador1.getVictorias());
                System.out.println(jugador2.getNombre()+": " +jugador2.getVictorias());
                System.out.println("Empates: " + empates);
            }

            System.out.println("Desea jugar otra partida? (Si, No)");
            respuestaJugarOtra = input.next(); 
            if ("No".equalsIgnoreCase(respuestaJugarOtra)) 
                juegoTerminado= true;
        }
        System.out.println("Gracias por jugar!");
    }
}