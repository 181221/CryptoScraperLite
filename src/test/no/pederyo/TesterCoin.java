package no.pederyo;

import no.api.coinmarket.Coin;
import no.api.coinmarket.CoinService;

import java.net.MalformedURLException;

public class TesterCoin {
    public static void main(String[] args) throws MalformedURLException {
        Coin c;
        CoinService cs = new CoinService();
        c = cs.oppRettCoin("bitcoin");
        c.setForjePris(10000);
        c.setPris(cs.getPris("bitcoin"));
        System.out.println(c.getPris());
        System.out.println(c.getName());
        System.out.println(c.getForjePris());

    }
}
