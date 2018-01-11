package no.pederyo.Scraper;

import no.api.coinmarket.Coin;
import no.pederyo.util.CoinUtil;

public class VerdiSjekker {
    public VerdiSjekker() {
        new PushBullet(System.getenv("pb-api"));
    }

    /**
     * Regner ut differansen mellom current verdi og forje.
     * sjekker verditabellen om det er prisendring
     * @param c
     * @return returnerer true om det har vært en endring på +-0.8.
     */
    public static boolean sjekkVerdiOgPushNotifikasjon(Coin c) {
        double plussforje = CoinUtil.gjorOmDoubleTilBC(c.getForjePris(), "gange", 1.09);
        double minusforje = CoinUtil.gjorOmDoubleTilBC(c.getForjePris(), "gange", 0.91);
        double currentVerdi = c.getPris();
        boolean nyVerdi = false;
        if (currentVerdi >= plussforje) {
            PushBullet.client.sendNotePush(c.getName() +" er nå " + CoinUtil.formaterTall(currentVerdi) + " USD", "Økning");
            nyVerdi = true;
        } else if (currentVerdi <= minusforje) {
            PushBullet.client.sendNotePush(c.getName() + " er nå " + CoinUtil.formaterTall(currentVerdi) + " USD", "Nedgang");
            nyVerdi = true;
        }
        return nyVerdi;
    }

}
