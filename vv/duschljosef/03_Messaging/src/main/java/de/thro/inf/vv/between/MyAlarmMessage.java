package de.thro.inf.vv.between;

import java.util.concurrent.atomic.AtomicLong;

public class MyAlarmMessage extends MyMessage{

    public MyAlarmMessage(AtomicLong idTelematik) {
        super(idTelematik);
        super.setAlarm(true);
    }
}
