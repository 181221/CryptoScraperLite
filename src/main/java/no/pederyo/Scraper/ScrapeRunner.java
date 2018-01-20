package no.pederyo.Scraper;

import no.api.coinmarket.Coin;
import no.api.coinmarket.CoinService;

import java.net.MalformedURLException;

public class ScrapeRunner implements Runnable {
    private Coin coin;
    private String name;
    private static int iterasjon = 0;
    private CoinService coinService;
    private VerdiSjekker verdiSjekker;

    public ScrapeRunner(String name) throws MalformedURLException {
        coinService = new CoinService();
        coin = coinService.oppRettCoin(name); //Oppretter coinen
        coin.setForjePris(coin.getPris());
        this.name = name;
        verdiSjekker = new VerdiSjekker();
    }

    @Override
    public void run() {
        while(true){
            try {

                coin.setPris(coinService.getPris(name));

                halvTimeSjekkVerdiEndring();

                Thread.sleep(60000);

                iterasjon++;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean halvTimeSjekkVerdiEndring() {
        boolean leggTil = false;
        if (iterasjon % 30 == 0) {
            leggTil = verdiSjekker.sjekkVerdiOgPushNotifikasjon(coin); //sjekker gammel mot current verdi.
            if (leggTil) {
                coin.setForjePris(coin.getPris()); //legger til ny verdi om det har vært en økning på 8% siden forjegang.
            }
        }
        return leggTil;
    }

}