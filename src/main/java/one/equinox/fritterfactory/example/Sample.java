package one.equinox.fritterfactory.example;

import one.equinox.fritterfactory.example.model.Adress;
import one.equinox.fritterfactory.FritterFactory;
import one.equinox.fritterfactory.example.model.Person;
import one.equinox.fritterfactory.example.providers.LocalDateProvider;
import one.equinox.fritterfactory.mold.MapMold;
import one.equinox.fritterfactory.providers.ModelProvider;
import one.equinox.fritterfactory.providers.images.PersonImageProvider;
import one.equinox.fritterfactory.providers.lorem.CityProvider;
import one.equinox.fritterfactory.providers.lorem.CountryProvider;
import one.equinox.fritterfactory.providers.lorem.FirstNameProvider;
import one.equinox.fritterfactory.providers.lorem.WordProvider;
import one.equinox.fritterfactory.providers.primitives.IntegerProvider;
import one.equinox.fritterfactory.example.model.symbols.*;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import javax.inject.Provider;
import java.util.List;

/**
 * Sample of Fritter Factory use.
 *
 */
public class Sample {

    public  static void main(String[] args){
        Sample sample = new Sample();
        sample.sample();
        sample.sampleWithMolds();
    }

    /**
     * Print 3 persons, using default providers
     */
    public void sample(){
        FritterFactory fritterFactory = new FritterFactory();
        fritterFactory.addProvider(LocalDate.class, new LocalDateProvider());
        List<Person> persons = fritterFactory.buildList(Person.class, 3);
        System.out.println("Persons with default provider");
        System.out.println(persons);
    }

    /**
     * Print 3 persons, using specific providers defined by a mold.
     */
    public void sampleWithMolds(){
        FritterFactory fritterFactory = createFactoryWithMolds();
        fritterFactory.addProvider(LocalDate.class, new LocalDateProvider());
        List<Person> persons = fritterFactory.buildList(Person.class, 3);
        System.out.println("Persons with custom mold provider");cd 
        System.out.println(persons);
    }

    /**
     * Creates a FritterFactory with defined providers for Person and Adress.
     * @return
     */
    public FritterFactory createFactoryWithMolds(){
        FritterFactory fritterFactory = new FritterFactory();
        fritterFactory.addProvider(Person.class, createPersonProvider(fritterFactory));
        fritterFactory.addProvider(Adress.class, createAdressProvider(fritterFactory));
        return fritterFactory;
    }

    public Provider<Person> createPersonProvider(FritterFactory fritterFactory){
        MapMold personMold = new MapMold();
        personMold.put(PersonSymbols.NAME, new FirstNameProvider());
        personMold.put(PersonSymbols.SURNAME, new FirstNameProvider());
        personMold.put(PersonSymbols.AGE, new IntegerProvider(0,110));
        personMold.put(PersonSymbols.DESCRIPTION, new WordProvider(50, 100));
        personMold.put(PersonSymbols.IMAGE, new PersonImageProvider());
        return new ModelProvider<Person>(fritterFactory, Person.class, personMold);
    }

    public Provider<Adress> createAdressProvider(FritterFactory fritterFactory){
        MapMold adressMold = new MapMold();
        adressMold.put(AdressSymbols.STREET, new WordProvider(1, 3));
        adressMold.put(AdressSymbols.CITY, new CityProvider());
        adressMold.put(AdressSymbols.COUNTRY, new CountryProvider());
        return new ModelProvider<Adress>(fritterFactory, Adress.class, adressMold);
    }

}
