package no.pederyo.Scraper;

import api.Coin;
import api.CoinService;

import java.net.MalformedURLException;

public class ScrapeRunner implements Runnable {
    private String name;
    private static double oldValue30SekSjekk = 0.0;
    private static double forjeVerdi30minSjekk = 0.0;
    private static int iterasjon = 0;

    public ScrapeRunner(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while(true){
            try {
                iterasjon++;
                Coin coin = CoinService.getPris(name);
                double verdi = coin.getPris();
                if(iterasjon % 3 == 0) {
                    oldValue30SekSjekk = verdi;
                }
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
/*

        halvTimeSjekkVerdiEndring(coin, verdi); // sjekker verdi endring på IoTa

        sjekkforjeVerdi(oldValue, verdi); // sjekker om det har skjedd en endring på 4% på 30 sekunder.

        DagSammendrag(coin, verdi, avk);  // hver 24 time send summary.
* */