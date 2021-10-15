package exchange.rates;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CurrencyCalculator {

    CurrencyRepository currencyRepository = CurrencyRepository.getInstance();

    public CurrencyCalculator() {
    }

    public void exchangeUserMoney() {
        Scanner scanner =  new Scanner(System.in);
        boolean repeat = true;

        while(repeat) {
            System.out.println("Pick currency code you want to exchange eg. 'USD'");
            String sourceCode = scanner.nextLine();

            System.out.println("Pick currency code you want to get eg. 'EUR'");
            String destinationCode = scanner.nextLine();

            System.out.println("How much you want to exchange? eg. '120.50'");
            String money = scanner.nextLine();
            money = money.replaceAll(",", ".");

            try {
                BigDecimal amountMoney = new BigDecimal(money).setScale(2, RoundingMode.DOWN);

                validateInput(sourceCode,destinationCode,amountMoney);

                BigDecimal exchangedMoney = calculateExchange(sourceCode,destinationCode,amountMoney);
                System.out.format("%.2f %s = %.2f %s",amountMoney,sourceCode,exchangedMoney,destinationCode);

                repeat = false;
            } catch (NumberFormatException e) {
                System.out.println("Invalid format of money provided");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateInput(String sourceCode, String destinationCode, BigDecimal amountMoney) throws Exception {
        if(amountMoney.doubleValue() <=0 )
            throw new Exception("Invalid amount money to exchange");
        if(currencyRepository.isInvalidCurrencyCode(sourceCode) ||
                currencyRepository.isInvalidCurrencyCode(destinationCode))
            throw new Exception("Invalid currency code provided");
    }

    public BigDecimal calculateExchange(String source,String destination, BigDecimal amountMoney) {

        Currency sourceCurrency = currencyRepository.getCurrencyByCode(source);
        double sourceConverter = Double.parseDouble(sourceCurrency.getConverter());
        BigDecimal sourceExchange = new BigDecimal(sourceCurrency.getExchange());

        Currency destinationCurrency =  currencyRepository.getCurrencyByCode(destination);
        double destinationConverter = Double.parseDouble(destinationCurrency.getConverter());
        BigDecimal destinationExchange = new BigDecimal(destinationCurrency.getExchange());

        BigDecimal converter = new BigDecimal(destinationConverter/sourceConverter);
        return amountMoney.multiply(converter).multiply(sourceExchange).divide(destinationExchange,2,RoundingMode.DOWN);
    }
}
