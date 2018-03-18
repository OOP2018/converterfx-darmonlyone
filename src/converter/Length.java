package converter;

/**
 * Length unit for converting
 * @author Manusporn Fukkham
 */
public enum Length implements Unit {
    Meter(1.0),
    Centimeter(0.01),
    Kilometer(1000.0),
    Mile(1609.344),
    Foot(0.0480),
    Wa(2.0),
    Au(149597870700.0);

    /**value of the unit*/
    private final double value;

    /**Constructor of Length to set value of unit*/
    Length(double v) {
        this.value = v;
    }

    /**
     * get the value of unit
     * @return the value of Length
     */
    @Override
    public double getValue() {
        return value;
    }

    /**
     * convert unit
     * @param unit to convert to
     * @return the amount of unit change from convert
     */
    @Override
    public double convert(Unit unit , double value){
        return value* (this.getValue()/unit.getValue());
    }
}
