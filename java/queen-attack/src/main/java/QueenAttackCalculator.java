import static java.lang.Math.abs;

import java.util.Objects;

public class QueenAttackCalculator {
    private final Queen firstQueen;
    private final Queen secondQueen;

    private final int[][] chessTable = new int[8][8];

    public QueenAttackCalculator(Queen firstQueen, Queen secondQueen) {
        validateQueens(firstQueen, secondQueen);
        this.firstQueen = firstQueen;
        this.secondQueen = secondQueen;
    }

    public boolean canQueensAttackOneAnother() {
        double diff = abs((secondQueen.getRow() - firstQueen.getRow()));
        if (diff == 0) {
            return true;
        }
        double result = abs((secondQueen.getColumn() - firstQueen.getColumn())) / diff;
        return result == 0.0 || result == 1.0;
    }

    private void validateQueens(Queen firstQueen, Queen secondQueen) {
        if (Objects.isNull(firstQueen) || Objects.isNull(secondQueen)) {
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        }
        if (firstQueen.equals(secondQueen)) {
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        }
    }
}
