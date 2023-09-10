package console;

import java.util.function.BinaryOperator;

public enum OperationType {
    PLUS((a, b) -> a + b),
    MINUS((a, b) -> (a - b));

    private final BinaryOperator<Integer> operation;

    OperationType(final BinaryOperator<Integer> operation) {
        this.operation = operation;
    }

    public Integer getOperation(final Integer a, final Integer b) {
        return operation.apply(a, b);
    }
}
