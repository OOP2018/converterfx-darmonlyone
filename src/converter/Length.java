package converter;

/**
 * Length unit of converting
 * @author Manusporn Fukkham
 */
public enum Length {
    Meter(1.0),
    Centimeter(0.01),
    Kilometer(1000.0),
    Mile(1609.344),
    Foot(0.0480),
    Wa(2.0),
    Au(149597870700.0);

    /**value of the unit*/
    private final double value;

    /**Constructor of Length so get value of unit*/
    Length(double v) {
        this.value = v;
    }

    /**
     * get the value of unit
     * @return the value of Length
     */
    public double getValue() {
        return value;
    }
}
