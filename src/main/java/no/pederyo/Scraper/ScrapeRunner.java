package no.pederyo.Scraper;

import api.Coin;
import api.CoinService;

import java.net.MalformedURLException;

public class ScrapeRunner implements Runnable {
    private String name;

    public ScrapeRunner(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while(true){
            try {
                Coin coin = CoinService.getPris(name);
                System.out.println("Navn: " + coin.getName() + " Pris: " + coin.getPris());
                Thread.sleep(3000);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
