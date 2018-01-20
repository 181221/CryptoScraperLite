package no.pederyo;
import no.pederyo.Scraper.PushBullet;
import no.pederyo.Scraper.ScrapeRunner;
import java.io.IOException;
import java.util.Arrays;

public class Klient {


    public static void main(String[] args) throws IOException {

        PushBullet pb = new PushBullet(args[0]);

        for(int i = 1; i < args.length; i ++) {
            ScrapeRunner sr = new ScrapeRunner(args[i]);
            new Thread(sr).start();
        }

        String[] coins = new String[args.length-1];
        for(int i = 0; i < coins.length;i++) {
            coins[i] = args[i+1];
        }

        pb.client.sendNotePush("CryptoScraperLite Started!","Sjekk ut https://github.com/181221/CryptoScraperLite" + "\nTracking Coins: \n" + Arrays.toString(coins));
    }
}
