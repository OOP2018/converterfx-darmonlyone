package converter;

/**
 * Temperature unit for converting
 * @author Manusporn Fukkham
 */
public enum  Currency implements Unit {
    Baht(1.0),
    USDollar(31.21),
    Pound(43.48),
    BitCoin(250878.86),
    Yuan(4.93),
    Yen(0.29),
    Rupee(0.48),
    Won(0.029);


    /**value of the unit*/
    private final double value;

    /**Constructor of Currency to set value of unit*/
    Currency(double v) {
        this.value = v;
    }

    /**
     * get the value of unit
     * @return the value of Currency
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
