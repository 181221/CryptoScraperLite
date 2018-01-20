package no.pederyo;

import no.api.coinmarket.Coin;
import no.api.coinmarket.ICoinService;

import java.net.MalformedURLException;

public class CoinServiceStub {


    public Coin getPris(String name) throws MalformedURLException {
        Coin c = new Coin();
        c.setPris(9);
        return c;
    }
}
