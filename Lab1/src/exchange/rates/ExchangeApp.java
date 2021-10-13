package exchange.rates;

public class ExchangeApp {

    public ExchangeApp() {
        CurrencyRepository currencyRepository = CurrencyRepository.getInstance();
        currencyRepository.printCurrenciesList();
        CurrencyCalculator calculator = new CurrencyCalculator();
        calculator.exchangeUserMoney();
    }

}
