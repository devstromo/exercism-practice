import static java.lang.Math.max;
import static java.lang.Math.sqrt;

class Triangle {
    double side1;
    double side2;
    double side3;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        validation();
    }

    boolean isEquilateral() {
        return nonZero() && side1 == side2 && side2 == side3;
    }

    boolean isIsosceles() {
        return nonZero() && (side1 == side2 || side1 == side3 || side2 == side3);
    }

    boolean isScalene() {
        return nonZero() && side1 != side2 && side2 != side3 && side1 != side3;
    }

    private void validation() throws TriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0 || !nonZero() || !isTriangle(side1, side2, side3))
            throw new TriangleException();
    }

    private boolean isTriangle(double side1, double side2, double side3) {
        var s = (side1 + side2 + side3) / 2;
        var inner = s * (s - side1) * (s - side2) * (s - side3);
        if (inner <= 0) {
            return false;
        }
        return true;
    }
    private boolean nonZero() {
        return side1 > 0 && side2 > 0 && side3 > 0;
    }
}
