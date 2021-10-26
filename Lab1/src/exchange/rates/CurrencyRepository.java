package exchange.rates;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CurrencyRepository {

    private Map<String,Currency> map = Collections.emptyMap();
    private static CurrencyRepository instance = null;

    private CurrencyRepository() {
        try {
            this.map = getCurrencies();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static CurrencyRepository getInstance(){
        try {
            if (instance == null) {
                instance = new CurrencyRepository();
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return instance;
    }

    Map<String,Currency> getCurrencies() throws IOException, InterruptedException, ParserConfigurationException, SAXException {

        String URL = "https://www.nbp.pl/kursy/xml/lasta.xml";
        Document doc = XmlResponseProvider.getDataDocument(URL);

        int length = doc.getElementsByTagName("pozycja").getLength();

        Map<String,Currency> map = new HashMap<>();
        map.put("PLN",new Currency("Polski Złoty","1","PLN","1.0000"));
        for (int i = 0; i < length; i++) {
            String name = doc.getElementsByTagName("nazwa_waluty").item(i).getTextContent();
            String converter = doc.getElementsByTagName("przelicznik").item(i).getTextContent();
            String code = doc.getElementsByTagName("kod_waluty").item(i).getTextContent();
            String exchange = doc.getElementsByTagName("kurs_sredni").item(i).getTextContent();
            map.put(code,new Currency(name,converter,code,exchange));
        }
        System.out.println("<SERVER> CURRENCIES DOWNLOADED");
        return map;
    }

    public void printCurrenciesList() {
        System.out.println("Currencies:");
        for (String s : map.keySet()) {
            Currency c = map.get(s);
            System.out.format("[%s] - %s, converter: %s %n",c.getCode(),c.getExchange(),c.getConverter());
        }
    }

    public Currency getCurrencyByCode(String code) {
        return map.get(code);
    }

    boolean isInvalidCurrencyCode(String name) {
        return !map.containsKey(name);
    }
}
