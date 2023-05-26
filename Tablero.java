
public class Tablero {
    private static final int FILAS = 6;
    private static final int COLUMNAS = 7;
    private char[][] tablero;

    public Tablero() {
        tablero = new char[FILAS][COLUMNAS];
        // Inicializar el tablero con espacios en blanco	
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                tablero[fila][columna] = ' ';
            }
        }
    }

    public void imprimirTablero() {
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                System.out.print("| " + tablero[fila][columna] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------------------");
    }

    public boolean estaColumnaLlena(int columna) {
        return tablero[0][columna] != ' ';
    }

    public boolean realizarMovimiento(int columna, char ficha) {
        if (columna < 0 || columna >= COLUMNAS || estaColumnaLlena(columna)) {
            return false;
        }
        for (int fila = FILAS - 1; fila >= 0; fila--) {
            if (tablero[fila][columna] == ' ') {
                tablero[fila][columna] = ficha;
                return true;
            }
        }
        return false;
    }

    public boolean hayGanador(char ficha) {
        // Comprobar filas
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS - 3; columna++) {
                if (tablero[fila][columna] == ficha &&
                        tablero[fila][columna + 1] == ficha &&
                        tablero[fila][columna + 2] == ficha &&
                        tablero[fila][columna + 3] == ficha) {
                    return true;
                }
            }
        }

        // Comprobar columnas
        for (int fila = 0; fila < FILAS - 3; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                if (tablero[fila][columna] == ficha &&
                        tablero[fila + 1][columna] == ficha &&
                        tablero[fila + 2][columna] == ficha &&
                        tablero[fila + 3][columna] == ficha) {
                    return true;
                }
            }
        }

        // Comprobar diagonales ascendentes
        for (int fila = 3; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS - 3; columna++) {
                if (tablero[fila][columna] == ficha &&
                        tablero[fila - 1][columna + 1] == ficha &&
                        tablero[fila - 2][columna + 2] == ficha &&
                        tablero[fila - 3][columna + 3] == ficha) {
                    return true;
                }
            }
        }

        // Comprobar diagonales descendentes
        for (int fila = 0; fila < FILAS - 3; fila++) {
            for (int columna = 0; columna < COLUMNAS - 3; columna++) {
                if (tablero[fila][columna] == ficha &&
                        tablero[fila + 1][columna + 1] == ficha &&
                        tablero[fila + 2][columna + 2] == ficha &&
                        tablero[fila + 3][columna + 3] == ficha) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean tableroLleno() {
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                if (tablero[fila][columna] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
