package no.pederyo;

import no.pederyo.Scraper.ScrapeRunner;

import java.io.IOException;

public class Klient {
    public static void main(String[] args) throws IOException {
        String bitcoin = "bitcoin";
        String ripple = "ripple";

        ScrapeRunner sr = new ScrapeRunner(bitcoin);
        new Thread(sr).start();

        new Thread(new ScrapeRunner(ripple)).start();

       /*Coin bitcoin = CoinService.getPris("bitcoin");
       Coin iota = CoinService.getPris("iota");
       Coin ripple = CoinService.getPris("ripple");
       Coin etherium = CoinService.getPris("ethereum");*/



    }
}
