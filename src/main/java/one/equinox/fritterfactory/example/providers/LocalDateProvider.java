package one.equinox.fritterfactory.example.providers;

import one.equinox.fritterfactory.util.RandomFactory;
import org.joda.time.LocalDate;

import javax.inject.Provider;
import java.util.Random;

public class LocalDateProvider implements Provider<LocalDate> {
    Random random = new RandomFactory().get();

    @Override
    public LocalDate get() {
        return new LocalDate(random.nextLong());
    }
}