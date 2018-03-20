package converter;

/**
 * Temperature unit for converting
 * @author Manusporn Fukkham
 */
public enum  Temperature implements Unit {
    Celcius(1),
    Fahrenhi(1.0),
    Kelvin(273.15),
    Rankine(491.67);


    /**value of the unit*/
    private final double value;

    /**Constructor of Temperature to set value of unit*/
    Temperature(double v) {
        this.value = v;
    }

    /**
     * get the value of unit
     * @return the value of Temperature
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
    public double convert(Unit unit, double value){
        return value;
    }
}
