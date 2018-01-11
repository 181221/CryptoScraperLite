package no.pederyo.Scraper;

import no.api.coinmarket.Coin;
import no.api.coinmarket.CoinService;

import java.net.MalformedURLException;

import static no.pederyo.util.CoinUtil.formaterTall;

public class ScrapeRunner implements Runnable {
    private Coin coin;
    private static String name;
    private static int iterasjon = 0;

    public ScrapeRunner(String name) throws MalformedURLException {
        coin = CoinService.getPris(name);
        this.name = name;
    }

    @Override
    public void run() {
        while(true){
            try {

                coin.setPris(CoinService.getPris(name).getPris());

                halvTimeSjekkVerdiEndring(coin);

                Thread.sleep(60000);

                iterasjon++;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean halvTimeSjekkVerdiEndring(Coin coin) {
        boolean leggTil = false;
        if (iterasjon % 30 == 0) {
            leggTil = VerdiSjekker.sjekkVerdiOgPushNotifikasjon(coin); //sjekker gammel mot current verdi.
            if (leggTil) {
                coin.setForjePris(coin.getPris()); //legger til ny verdi om det har vært en økning på 8% siden forjegang.
            }
        }
        return leggTil;
    }

}