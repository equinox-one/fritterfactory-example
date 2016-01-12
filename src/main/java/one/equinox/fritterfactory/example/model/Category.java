package one.equinox.fritterfactory.example.model;

import one.equinox.symbols.Symbolize;

/**
 * Sample model that contains a Category
 */
@Symbolize
public class Category {
    String name;

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}
