package de.thro.inf.vv.between;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

import static de.thro.inf.vv.between.RandomNumber.*;

public class MyMessage extends RandomNumber implements Serializable{
    private double latitude;
    private double longitude;
    private static AtomicLong idTelematik;
    private int drivenMiles;
    LocalTime time;
    private boolean alarm;

    public MyMessage(AtomicLong idTelematik) {
        this.idTelematik = idTelematik;
        this.drivenMiles = RandomRoute();
        time = LocalTime.now();
        longitude = RandomGpsLongitudes();
        latitude = RandomGpsLatitude();
        alarm = false;
    }

    public MyMessage() {
    }

    /**
     * getter & setter
     */

    public static void setIdTelematik(AtomicLong idTelematik) {
        MyMessage.idTelematik = idTelematik;
    }

    public int getDrivenMiles() {
        return drivenMiles;
    }

    public void setAlarm(boolean alarm) {
        this.alarm = alarm;
    }

    @Override
    public String toString()  {
        return "MyMessage{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", drivenMiles=" + drivenMiles +
                ", time=" + time +
                '}';
    }
}
