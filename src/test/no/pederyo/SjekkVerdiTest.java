package no.pederyo;
import no.api.coinmarket.Coin;
import no.pederyo.Scraper.VerdiSjekker;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static no.pederyo.Scraper.ScrapeRunner.halvTimeSjekkVerdiEndring;

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
        assertTrue(VerdiSjekker.sjekkVerdiOgPushNotifikasjon(c));

        c.setForjePris(10);
        c.setPris(10.9);
        assertTrue(VerdiSjekker.sjekkVerdiOgPushNotifikasjon(c));

        c.setForjePris(10.1231);
        c.setPris(15.123);
        assertTrue(VerdiSjekker.sjekkVerdiOgPushNotifikasjon(c));

        c.setPris(23);
        assertTrue(VerdiSjekker.sjekkVerdiOgPushNotifikasjon(c));

    }

    @Test
    public void haltimeendirng(){
        c.setForjePris(10.1231);
        c.setPris(15.123);
        assertTrue(halvTimeSjekkVerdiEndring(c));
        assertTrue(c.getPris() == c.getForjePris());

        c.setPris(5.123);
        assertTrue(halvTimeSjekkVerdiEndring(c));
        assertTrue(c.getPris() == c.getForjePris());


    }



}
