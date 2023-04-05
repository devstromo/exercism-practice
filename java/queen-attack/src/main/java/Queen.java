import java.util.Objects;

public class Queen {
    private final int row;
    private final int column;

    public Queen(int row, int column) {
        validate(row, column);
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    private void validate(int row, int column) {
        if (column > 7) {
            throw new IllegalArgumentException("Queen position must have column <= 7.");
        }
        if (row > 7) {
            throw new IllegalArgumentException("Queen position must have row <= 7.");
        }

        if (column < 0) {
            throw new IllegalArgumentException("Queen position must have positive column.");
        }
        if (row < 0) {
            throw new IllegalArgumentException("Queen position must have positive row.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Queen queen = (Queen) o;
        return row == queen.row && column == queen.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}