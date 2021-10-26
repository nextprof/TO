package exchange.rates;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CurrencyCalculator {

    private final CurrencyRepository currencyRepository = CurrencyRepository.getInstance();

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
        Currency destinationCurrency =  currencyRepository.getCurrencyByCode(destination);

        BigDecimal converter = BigDecimal.valueOf(destinationCurrency.getConverter() / sourceCurrency.getConverter());
        return amountMoney.multiply(converter).multiply(sourceCurrency.getExchange()).divide(destinationCurrency.getExchange(),
                2
                ,RoundingMode.DOWN);
    }
}
