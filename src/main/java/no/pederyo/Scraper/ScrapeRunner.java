package no.pederyo.Scraper;

import no.api.Coin;
import no.api.CoinService;
import no.pederyo.PushBullet;
import no.pederyo.VerdiSjekker;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.text.DecimalFormat;

public class ScrapeRunner implements Runnable {
    private Coin coin;
    private static String name;
    private static double oldValue = 0.0;
    private static int iterasjon = 0;

    public ScrapeRunner(String name) throws MalformedURLException {
        coin = CoinService.getPris(name);
        this.name = name;
    }

    @Override
    public void run() {
        while(true){
            try {
                iterasjon++;
                double verdi = CoinService.getPris(name).getPris();
                if(iterasjon % 3 == 0) {
                    oldValue = verdi;
                }
                halvTimeSjekkVerdiEndring(coin);
                Thread.sleep(3000);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean halvTimeSjekkVerdiEndring(Coin coin) {
        boolean leggTil = false;
        if (iterasjon % 180 == 0) {
            leggTil = VerdiSjekker.sjekkVerdiOgPushNotifikasjon(coin); //sjekker gammel mot current verdi.
            if (leggTil) {
               coin.setForjePris(coin.getPris());//legger til ny verdi om det har vært en økning på 8% siden forjegang.
            }
        }
        return leggTil;
    }


}
/*

        halvTimeSjekkVerdiEndring(coin, verdi); // sjekker verdi endring på IoTa

        sjekkforjeVerdi(oldValue, verdi); // sjekker om det har skjedd en endring på 4% på 30 sekunder.

        DagSammendrag(coin, verdi, avk);  // hver 24 time send summary.
* */