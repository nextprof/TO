package exchange.rates;

public class ExchangeApp {

    public ExchangeApp() {
        CurrencyRepository.getInstance().printCurrenciesList();
        CurrencyCalculator.exchangeUserMoney();
    }

}
