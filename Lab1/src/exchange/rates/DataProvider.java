package exchange.rates;

import java.io.IOException;

public interface DataProvider {
    String getData(String URL) throws IOException, InterruptedException;
}
