package converter;

/**
 * Speed unit for converting
 * @author Manusporn Fukkham
 */
public enum Speed implements Unit {
    KilometerPerSecond(1),
    MeterPerSecond(0.001),
    KilometerPerMinute(0.01667),
    MeterPerMinute(0.00001667),
    KilometerPerHour(0.0002778),
    MeterPerHour(0.0000002778),
    KilometerPerYears(0.00000003169),
    MeterPerYear(0.00000000003169);

    /**value of the unit*/
    private final double value;

    /**Constructor of Speed to set value of unit*/
    Speed(double v) {
        this.value = v;
    }

    /**
     * get the value of unit
     * @return the value of Speed
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
        return this.getValue()/unit.getValue();
    }
}
