package no.pederyo.Scraper;

import no.api.pushbullet.PushbulletClient;
import no.api.pushbullet.items.device.Device;

import java.util.List;

public class PushBullet {

    public static volatile PushbulletClient client;

    public PushBullet(String apikey) {
        client = new PushbulletClient(apikey);
    }

    public void printDivices() {
        List<Device> devices = client.listDevices();
        for (Device d : devices) {
            System.out.println(d.getNickname() + " \t\t" + d.getIden());
        }
    }

    public void pushNote(String tittel, String melding) {
        synchronized (this){
            client.sendNotePush(tittel, melding);
        }
    }

    public PushbulletClient getClient() {
        return client;
    }

}
