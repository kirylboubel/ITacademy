package console.impl;

import console.Calculate;
import console.ConsoleException;
import console.OperationType;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleCalculator implements Calculate {
    @Override
    public void calculate() throws ConsoleException {
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите значение для переменной А ");
            final int a = Integer.parseInt(scanner.nextLine());

            System.out.println("Введите значение для переменной В ");
            final int b = Integer.parseInt(scanner.nextLine());

            System.out.println("Выберите действи, где plus - А + В, а minus - А - В " + Arrays.toString(OperationType.values()));
            final OperationType operationType = OperationType.valueOf(scanner.nextLine().toUpperCase());

            System.out.println("Результат - " + operationType.getOperation(a, b));
        }
    }
}
