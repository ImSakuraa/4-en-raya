public class Main {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador('X');
        Jugador jugador2 = new Jugador('O');
        Jugador jugadorActual = jugador1;
        boolean juegoTerminado = false;

        System.out.println("¡Bienvenido al 4 en raya!");

        while (!juegoTerminado) {
            tablero.imprimirTablero();
            int columna = jugadorActual.seleccionarColumna();
            boolean movimientoValido = tablero.realizarMovimiento(columna, jugadorActual.getFicha());

            if (!movimientoValido) {
                System.out.println("¡Movimiento inválido! Inténtalo de nuevo.");
                continue;
            }

            if (tablero.hayGanador(jugadorActual.getFicha())) {
                tablero.imprimirTablero();

                System.out.println("¡El jugador '" + jugadorActual.getFicha() + "' ha ganado!");
                juegoTerminado = true;
            } else if (tablero.tableroLleno()) {
                tablero.imprimirTablero();

                System.out.println("¡Empate! El tablero está lleno.");
                juegoTerminado = true;
            }

            if (jugadorActual == jugador1) {
                jugadorActual = jugador2;
            } else {
                jugadorActual = jugador1;
            }
        }
    }
}
