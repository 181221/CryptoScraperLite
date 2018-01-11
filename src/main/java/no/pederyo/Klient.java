package no.pederyo;

import no.pederyo.Scraper.PushBullet;
import no.pederyo.Scraper.ScrapeRunner;

import java.io.IOException;

public class Klient {
    public static void main(String[] args) throws IOException {
        new PushBullet(args[0]);
        for(int i = 1; i < args.length; i ++) {
            ScrapeRunner sr = new ScrapeRunner(args[i]);
            new Thread(sr).start();
        }
    }
}
