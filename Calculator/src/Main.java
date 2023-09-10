import console.ConsoleException;
import console.impl.ConsoleCalculator;

public class Main {
    public static void main(String[] args) {
        try {
            final ConsoleCalculator consoleCalculator = new ConsoleCalculator();
            consoleCalculator.calculate();
        } catch (ConsoleException e) {
            System.err.println(e);
        }
    }
}