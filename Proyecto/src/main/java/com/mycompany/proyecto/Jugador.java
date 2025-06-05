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
    public void setNombre(String Nombre){
        nombre=Nombre;
    }
    public char getSimbolo(){
        return simbolo;
    }
    public int getVictorias(){
        return victorias;
    }
    public void setVictorias(int N){
        victorias=N;
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

/*Metodos
Todos los get devuelven el valor solicitado y todos son publicos
setVictorias metodo para cambiar el numero de victorias (es publico pero usar solo para agregar una victoria cuando sea necesario)
hacerMovimiento (recibe el tablero y la posicion deseada por el jugador): retorna un booleano positivo si el movimiento fue posible de ejecutar
negativo si no era un movimiento legal
*/
