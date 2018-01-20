package no.pederyo.Scraper;

import no.api.coinmarket.Coin;
import no.pederyo.Klient;
import no.pederyo.util.CoinUtil;

public class VerdiSjekker {

    private PushBullet pb;
    private CoinUtil coinUtil;

    public VerdiSjekker() {
        //pb = new PushBullet(System.getenv("pb-api"));
        coinUtil = new CoinUtil();
    }

    /**
     * Regner ut differansen mellom current verdi og forje.
     * sjekker verditabellen om det er prisendring
     * @param c
     * @return returnerer true om det har vært en endring på +-0.8.
     */
    public boolean sjekkVerdiOgPushNotifikasjon(Coin c) {
        double plussforje = coinUtil.gjorOmDoubleTilBC(c.getForjePris(), "gange", 1.09);
        double minusforje = coinUtil.gjorOmDoubleTilBC(c.getForjePris(), "gange", 0.91);
        double currentVerdi = c.getPris();
        boolean nyVerdi = false;
        if (currentVerdi >= plussforje) {
            PushBullet.client.sendNotePush(c.getName() +" er nå " + coinUtil.formaterTall(currentVerdi) + " USD", "Økning");
            nyVerdi = true;
        } else if (currentVerdi <= minusforje) {
            PushBullet.client.sendNotePush(c.getName() + " er nå " + coinUtil.formaterTall(currentVerdi) + " USD", "Nedgang");
            nyVerdi = true;
        }
        return nyVerdi;
    }



}
