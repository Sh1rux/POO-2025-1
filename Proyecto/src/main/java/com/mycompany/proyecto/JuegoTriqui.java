package com.mycompany.proyecto;

import java.util.Scanner;

public class JuegoTriqui {

    Scanner input = new Scanner(System.in);
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;                       //definir los atributos de clase
    private Jugador jugadorActual;
    private int empates;
    private boolean juegoTerminado;
    private String ModoJuego;   //NUEVO, servirá posteriormente para saber cuantos jugadores registrar y para registrar compuF o compuM

    public JuegoTriqui(){
        this.tablero = new Tablero();
        this.jugador1 = new Jugador("jugador1", 'X');
        this.jugador2 = new Jugador("jugador2", 'O');
        this.jugadorActual = jugador1;        //constructor vacío por convnción
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

    public void tipoJuego(){           //Definición de Tipo de Juego (incompleto)
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
        else{System.out.println("Opción no válida");}
    }
    public void registrarJugador(){             // registra jugador1 o jugador2
        if (ModoJuego == "Dos Jugadores"){
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
        String r = "";
        String respuesta = "Si";
        int fila = 3;
        int columna = 3;
        while(this.juegoTerminado==false){
            tablero.inicializarTablero();
            fila = 3;
            columna = 3;
            while (tablero.estaLleno()== false){
                tablero.imprimirTablero();
                System.out.println("Turno de:  "+ jugadorActual.getNombre());
                if ("BotMedio".equals(jugadorActual.getNombre())== false && "BotFacil".equals(jugadorActual.getNombre())== false){
                    while (tablero.esCeldaVacia(fila, columna)==false){
                        System.out.println("Ingresa la fila:");
                        fila = input.nextInt();
                        System.out.println("Ingresa la columna:");
                        columna = input.nextInt();
                        if (tablero.esCeldaVacia(fila, columna)==false)
                            System.out.println("Error. Seleccione otra casilla");
                    }
                }
                jugadorActual.hacerMovimiento(tablero,fila, columna);
                if (hayGanador() == true){
                    System.out.println(jugadorActual.getNombre()+"es el ganador!!");
                    jugadorActual.setVictorias(jugadorActual.getVictorias()+1);
                    tablero.imprimirTablero();
                    break;
                }
                actualizarJugador();
                if (tablero.estaLleno())
                    this.empates++;
            }
            System.out.println("¿Desea ver el marcador actual? (Si, No)");
            r = input.next();
            if ("Si".equals(respuesta)){
                System.out.println("Victorias totales");
                System.out.println(jugador1.getNombre()+": " +jugador1.getVictorias());
                System.out.println(jugador2.getNombre()+": " +jugador2.getVictorias());
                System.out.println("Empates: " + empates);
            }
            System.out.println("¿Desea jugar otra partida? (Si, No)");
            respuesta = input.next();
            if ("No".equals(respuesta))
                juegoTerminado= true;
        }
        System.out.println("Gracias por jugar");
    }
}