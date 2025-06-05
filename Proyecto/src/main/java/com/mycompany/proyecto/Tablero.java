package com.mycompany.proyecto;

public class Tablero {
    private char[][] cuadrilla; 
    private final int TAMANO = 3; 

    public Tablero() {
        cuadrilla = new char[TAMANO][TAMANO];
        inicializarTablero(); // Inicializa el tablero al crear un objeto Tablero
    }

    // Inicializa todas las celdas del tablero con un espacio en blanco
    public void inicializarTablero() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                cuadrilla[i][j] = ' '; // Espacio en blanco para celda vacía
            }
        }
    }

    // Imprime el estado actual del tablero en la consola
    public void imprimirTablero() {
        System.out.println("-------------");
        for (int i = 0; i < TAMANO; i++) {
            System.out.print("| ");
            for (int j = 0; j < TAMANO; j++) {
                System.out.print(cuadrilla[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    // Verifica si una celda específica está vacía y si las coordenadas son válidas
    public boolean esCeldaVacia(int fila, int columna) {
        // Primero toca validar que las coordenadas estén dentro de los límites
        if (fila < 0 || fila >= TAMANO || columna < 0 || columna >= TAMANO) {
            return false; // Coordenadas fuera de rango no están "vacías"
        }
        return cuadrilla[fila][columna] == ' '; // Retorna true si la celda está vacía
    }

    // Coloca el símbolo del jugador en la celda especificada
    public void colocarMovimiento(int fila, int columna, char simbolo) {
        if (esCeldaVacia(fila, columna)) {
            cuadrilla[fila][columna] = simbolo;
        } else {
            System.out.println("¡Error interno del tablero! La celda ya está ocupada o las coordenadas son inválidas.");
        }
    }

    // Verifica si el tablero está completamente lleno (para detectar empates)
    public boolean estaLleno() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                if (cuadrilla[i][j] == ' ') {
                    return false; // Si encuentra alguna celda vacía, el tablero no está lleno
                }
            }
        }
        return true; // Si llega aquí, todas las celdas están ocupadas
    }

    // Método para acceder al símbolo en una celda (Es para verificar ganadores)
    public char getCelda(int fila, int columna) { // Cambiado de 'getCell' a 'getCelda'
        if (fila < 0 || fila >= TAMANO || columna < 0 || columna >= TAMANO) {
            return '\0'; // Carácter nulo o lanzar una excepción para indicar un error
        }
        return cuadrilla[fila][columna];
    }
}

//Métodos (Sobreentender que "+" significa que la clase es pública y "-" significa que es privada)
//Tablero: Este es el nombre de la clase.
//-char[][] cuadrilla:
    //char[][]: Es el tipo de dato, una matriz bidimensional de caracteres, que se usa para representar la cuadrícula 3x3 del juego.
    //cuadrilla: El nombre del atributo.
//-final int TAMANO = 3:
    //final int: Indica que es una constante entera y su valor no puede cambiar una vez asignado (3).
    //TAMANO: El nombre del atributo que define el tamaño del tablero.
//+inicializarTablero(): void:
    //inicializarTablero(): El nombre del método, no toma parámetros.
    //: void: Indica que el método no devuelve ningún valor.
//+imprimirTablero(): void:
    //imprimirTablero(): Nombre del método.
    //: void: No devuelve ningún valor. Se encarga de mostrar el tablero en la consola.
//+esCeldaVacia(fila: int, columna: int): boolean:
    //esCeldaVacia(): Nombre del método.
    //fila: int, columna: int: Toma dos parámetros enteros, fila y columna.
    //: boolean: Devuelve un valor booleano (true si la celda está vacía y es válida, false en caso contrario).
//+colocarMovimiento(fila: int, columna: int, simbolo: char): void:
    //colocarMovimiento(): Nombre del método.
    //fila: int, columna: int, simbolo: char: Toma tres parámetros: la fila, la columna y el símbolo del jugador a colocar.
    //: void: No devuelve ningún valor.
//+estaLleno(): boolean:.
    //estaLleno(): Nombre del método.
    //: boolean: Devuelve true si el tablero está completamente lleno, false en caso contrario.
//+getCelda(fila: int, columna: int): char:
    //getCelda(): Nombre del método.
    //fila: int, columna: int: Toma dos parámetros enteros, fila y columna.
    //: char: Devuelve el carácter ('X', 'O', o ' ') presente en la celda especificada.
    

