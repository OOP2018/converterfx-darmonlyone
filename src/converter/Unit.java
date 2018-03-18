package converter;

/**
 * The interface of unit for converter
 * @author Manusporn Fukkham
 */
public interface Unit {
    /** return a value of unit*/
    double getValue();
    /** set a String*/
    String toString();
    /** convert a unit as value*/
    double convert(Unit unit, double value);
}
