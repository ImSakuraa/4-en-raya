import java.util.Scanner;

public class Jugador {
    private char ficha;
    private Scanner sc;

    public Jugador(char ficha) {
        this.ficha = ficha;
        this.sc = new Scanner(System.in);
    }

    public int seleccionarColumna() {
        System.out.print("Jugador '" + ficha + "', elige una columna (0-6): ");
        return sc.nextInt();
    }

    public char getFicha() {
        return ficha;
    }
}
