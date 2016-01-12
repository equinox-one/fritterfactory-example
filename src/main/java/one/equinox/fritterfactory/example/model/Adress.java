package one.equinox.fritterfactory.example.model;

import one.equinox.symbols.Symbolize;

/**
 * Sample model that contains an Adress
 */
@Symbolize
public class Adress {
    String street;
    String city;
    String country;

    @Override
    public String toString() {
        return "Adress{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
