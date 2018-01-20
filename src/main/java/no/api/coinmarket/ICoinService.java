package no.api.coinmarket;

import java.net.MalformedURLException;

public interface ICoinService {
    public Coin getPris(String name) throws MalformedURLException;
    public Coin oppRettCoin(String name);
}
