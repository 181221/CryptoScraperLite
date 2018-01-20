package no.pederyo;
import no.api.coinmarket.Coin;
import no.pederyo.Scraper.ScrapeRunner;
import no.pederyo.Scraper.VerdiSjekker;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.net.MalformedURLException;

import static junit.framework.TestCase.assertTrue;

public class SjekkVerdiTest {
    private VerdiSjekker verdiSjekker;
    private Coin c;
    @Before
    public void setup() {
        verdiSjekker = new VerdiSjekker();
        c = new Coin();
    }
    @Ignore
    @Test
    public void sjekkVerdiOgPushNotifikasjonTest(){
        c.setName("bitcoin");
        c.setPris(9.9);
        c.setForjePris(10.9);
        assertTrue(verdiSjekker.sjekkVerdiOgPushNotifikasjon(c));

        c.setForjePris(10);
        c.setPris(10.9);
        assertTrue(verdiSjekker.sjekkVerdiOgPushNotifikasjon(c));

        c.setForjePris(10.1231);
        c.setPris(15.123);
        assertTrue(verdiSjekker.sjekkVerdiOgPushNotifikasjon(c));

        c.setPris(23);
        assertTrue(verdiSjekker.sjekkVerdiOgPushNotifikasjon(c));

    }
    // Maa ordnes paa.
    @Test
    public void haltimeendirng(){
        ScrapeRunner sr = null;
        try {
             sr = new ScrapeRunner("bitcoin");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        c.setForjePris(10.1231);
        c.setPris(15.123);
        assertTrue(sr.halvTimeSjekkVerdiEndring());
        assertTrue(c.getPris() == c.getForjePris());

        c.setPris(5.123);
        assertTrue(sr.halvTimeSjekkVerdiEndring());
        assertTrue(c.getPris() == c.getForjePris());


    }



}
