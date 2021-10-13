package exchange.rates;

import java.util.Objects;

public class Currency {

    private String name;
    private String converter;
    private String code;
    private String exchange;

    public Currency(String name, String converter, String code, String exchange) {
        this.name = name;
        this.converter = converter;
        this.code = code;
        this.exchange = exchange.replaceAll(",",".");
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

    public void setName(String name) {
        this.name = name;
    }

    public String getConverter() {
        return converter;
    }

    public void setConverter(String converter) {
        this.converter = converter;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }
}
