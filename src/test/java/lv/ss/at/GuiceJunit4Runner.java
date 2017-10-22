package lv.ss.at;

import com.google.inject.Guice;
import com.google.inject.Module;
import com.google.inject.internal.ProviderMethodsModule;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class GuiceJunit4Runner extends BlockJUnit4ClassRunner {
    /**
     * Creates a BlockJUnit4ClassRunner to run {@code klass}
     *
     * @param klass
     * @throws InitializationError if the test class is malformed.
     */
    public GuiceJunit4Runner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    public Object createTest() throws Exception {
        Object object = super.createTest();
        Module module = ProviderMethodsModule.forObject(object);
        Guice.createInjector(module).injectMembers(object);
        return object;
    }
}
