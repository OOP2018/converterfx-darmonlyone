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
        double tempValue = (double) 9/5;
        double oppTempValue = (double) 5/9;

        if (this.equals(Celcius)){
            if (unit.equals(Fahrenhi))
                //°C  x  9/5 + 32 = °F
                return (value*(tempValue))+32;
            if (unit.equals(Kelvin))
                //°C + 273.15
                return value + unit.getValue();
            if (unit.equals(Rankine))
                //T(°C) = (T(°R) - 491.67) × 5/9
                return (value*(tempValue))+unit.getValue();
        }
        if (this.equals(Fahrenhi)){
            if (unit.equals(Celcius))
                //(°F  -  32)  x  5/9 = °C
                return (value - 32)*(oppTempValue);
            if (unit.equals(Kelvin))
                return (this.convert(Celcius,value)) + unit.getValue();
            if (unit.equals(Rankine))
                return this.convert(Celcius,value) * (tempValue) +unit.getValue();
        }

        if (this.equals(Kelvin)){
            if (unit.equals(Celcius))
                //°C - 273.15
                return value - this.getValue();
            if (unit.equals(Fahrenhi))
                return (this.convert(Celcius,value)*tempValue) + 32;
            if (unit.equals(Rankine))
                //T(°R) = T(K) × 9/5
                return value*(tempValue);
        }

        if (this.equals(Rankine)){
            //T(°C)*9/5 + 491.67 = T(°R)
           if (unit.equals(Celcius))
               return (value - this.getValue()) * (oppTempValue);
           if (unit.equals(Fahrenhi))
               return (this.convert(Celcius,value)*(tempValue))+32;
           if (unit.equals(Rankine))
               return value*(oppTempValue);
        }
        return value;
    }
}
