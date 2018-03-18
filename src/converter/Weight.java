package converter;

/**
 * Weight unit for converting
 * @author Manusporn Fukkham
 */
public enum  Weight implements Unit {
    Kilogram(1.0),
    Gram(0.001),
    Milligram(0.000001),
    Pound(0.454),
    Tonne(1000),
    LongTon(1016),
    ShortTon(907.2),
    Baht(0.015),
    Chang(1.2),
    Hap(60);



    /**value of the unit*/
    private final double value;

    /**Constructor of Weight to set value of unit*/
    Weight(double v) {
        this.value = v;
    }

    /**
     * get the value of unit
     * @return the value of Weight
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
