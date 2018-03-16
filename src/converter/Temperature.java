package converter;

/**
 * Temperature unit for converting
 * @author Manusporn Fukkham
 */
public enum  Temperature implements Unit {
    Celcius(1.0),
    Fahrenhi(-17.22),
    Kelvin(-272.15),
    Rankine(-272.594);


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
    public double convert(Unit unit){
        return this.getValue() - unit.getValue();
    }
}
