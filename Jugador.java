package asd;
import java.util.Scanner;

public class Jugador {
    private char ficha;
    private Scanner scanner;

    public Jugador(char ficha) {
        this.ficha = ficha;
        this.scanner = new Scanner(System.in);
    }

    public int seleccionarColumna() {
        System.out.print("Jugador '" + ficha + "', elige una columna (0-6): ");
        return scanner.nextInt();
    }

    public char getFicha() {
        return ficha;
    }
}
