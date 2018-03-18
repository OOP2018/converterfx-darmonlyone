package converter;

/**
 * Volume unit for converting
 * @author Manusporn Fukkham
 */
public enum Volume implements Unit {
    Litre(1.0),
    Millilitre(0.001),
    USgallon(3.785),
    UKgallon(4.546),
    Barrel(159.0),
    CubicFeet(28.3),
    CubicMetre(1000.0),
    Sat(25),
    Kwian(2000),
    YipMue(0.0078125),
    KamMue(0.03125);

    /**value of the unit*/
    private final double value;

    /**Constructor of Volume to set value of unit*/
    Volume(double v) {
        this.value = v;
    }

    /**
     * get the value of unit
     * @return the value of Volume
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
        return value * (this.getValue()/unit.getValue());
    }
}
