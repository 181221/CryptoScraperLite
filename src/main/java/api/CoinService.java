package api;

import javax.json.*;
import javax.json.stream.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;

public class CoinService {

    public static Coin getPris(String name) throws MalformedURLException {
        String baseUrl = "https://api.coinmarketcap.com/v1/ticker/";
        String coinname = name;
        URL url = new URL(baseUrl + coinname);
        Coin c = new Coin();
        try (InputStream is = url.openStream();
             JsonParser parser = Json.createParser(is)) {
            while (parser.hasNext()) {
                JsonParser.Event e = parser.next();
                if (e == JsonParser.Event.KEY_NAME) {
                    switch (parser.getString()) {
                        case "name":
                            parser.next();
                            c.setName(parser.getString());
                            break;
                        case "price_usd":
                            parser.next();
                            c.setPris(Double.parseDouble(parser.getString()));
                            break;

                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Coinen finnes ikke eller sjekk navn");

        }
        return c;
    }
}
