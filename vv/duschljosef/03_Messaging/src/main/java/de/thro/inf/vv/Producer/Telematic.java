package de.thro.inf.vv.Producer;

import com.rabbitmq.client.*;
import de.thro.inf.vv.between.MyMessage;
import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

public class Telematic{

    private static final String TASK_QUEUE_NAME = "travelData";
    private static AtomicLong id;
    private long timeIntervall;
    private LinkedList<MyMessage> myMessageList;
    private int totalDrivenMiles;

    public Telematic(long timeIntervall){
        this.id = new AtomicLong(System.currentTimeMillis());
        this.timeIntervall = timeIntervall * 100;
        myMessageList = new LinkedList<MyMessage>();
        fillMessagelist();
    }

    /**
     * fills the list with the first message
     */
    private void fillMessagelist() {
        myMessageList.add(new MyMessage(id));
    }

    /**
     * sum the miles together from the messages
     * @return driven miles
     */
    public int getMiles(){
        if(!myMessageList.isEmpty()) {
            for (MyMessage mm : myMessageList) {
                totalDrivenMiles += mm.getDrivenMiles();
            }
            return totalDrivenMiles;
        }
        else{
            return 0;
        }
    }
    /**
     * getter & setter
     */

    /**
     *
     * @return in milliseconds
     */
    public long getTimeIntervall() {
        return timeIntervall / 100;
    }

    /**
     *
     * @param timeIntervall in seconds
     */
    public void setTimeIntervall(long timeIntervall) {
        this.timeIntervall = timeIntervall * 100;
    }


    @Override
    public String toString() {
        return "Telematik{" +
                "timeIntervall=" + timeIntervall +
                ", myMessageList=" + myMessageList +
                '}';
    }

    //Idea implements Runnable and fill the messages with waiting time and "run" the fil messages Method"

    public static void main(String[] args) throws IOException, TimeoutException {

        Telematic telematic = new Telematic(100);
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try(Connection connection = factory.newConnection();
        Channel channel = connection.createChannel()){
            channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

            channel.basicPublish("",TASK_QUEUE_NAME,false, null, SerializationUtils.serialize(telematic.myMessageList.getFirst()));
            System.out.println("Sent " + telematic.myMessageList);
        }


    }


}
