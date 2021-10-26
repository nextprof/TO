package exchange.rates;

import java.math.BigDecimal;
import java.util.Objects;

public class Currency {

    private final String name;
    private final double converter;
    private final String code;
    private final BigDecimal exchange;

    public Currency(String name, String converter, String code, String exchange) {
            this.name = name;
            this.converter = Double.parseDouble(converter);
            this.code = code;
            this.exchange = new BigDecimal(exchange.replaceAll(",", "."));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency)) return false;
        Currency currency = (Currency) o;
        return Objects.equals(getName(), currency.getName()) && Objects.equals(getConverter(), currency.getConverter()) && Objects.equals(getCode(), currency.getCode()) && Objects.equals(getExchange(), currency.getExchange());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getConverter(), getCode(), getExchange());
    }

    public String getName() {
        return name;
    }

    public double getConverter() {
        return converter;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getExchange() {
        return exchange;
    }
}