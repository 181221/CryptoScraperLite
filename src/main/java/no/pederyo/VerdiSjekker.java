package no.pederyo;

import no.api.Coin;

public class VerdiSjekker {

    /**
     * Regner ut differansen mellom current verdi og forje.
     * sjekker verditabellen om det er prisendring
     * @param c
     * @return returnerer true om det har vært en endring på +-0.8.
     */
    public static boolean sjekkVerdiOgPushNotifikasjon(Coin c) {
        double plussforje = CoinUtil.gjorOmDoubleTilBC(c.getForjePris(), "gange", 1.08);
        double minusforje = CoinUtil.gjorOmDoubleTilBC(c.getForjePris(), "gange", 0.92);
        double currentVerdi = c.getPris();
        String prosent = CoinUtil.formaterTall(plussforje - currentVerdi);
        System.out.println(prosent);
        boolean nyVerdi = false;
        if (currentVerdi >= plussforje) {
            PushBullet.client.sendNotePush("Stigning! IoTaVerdi er nå " + CoinUtil.formaterTall(currentVerdi) + " USD", "Økning");
            nyVerdi = true;
        } else if (currentVerdi <= minusforje) {
            PushBullet.client.sendNotePush("Nedgang! IoTaVerdi er nå " + CoinUtil.formaterTall(currentVerdi) + " USD", "Nedgang");
            nyVerdi = true;
        }
        return nyVerdi;
    }
}
