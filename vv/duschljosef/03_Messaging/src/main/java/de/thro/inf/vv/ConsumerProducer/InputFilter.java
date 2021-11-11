package de.thro.inf.vv.ConsumerProducer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import de.thro.inf.vv.between.MyMessage;
import org.apache.commons.lang3.SerializationUtils;


import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public class InputFilter {
    //von queue fahrdaten into topic verteiler
    //Zu jeder Telematikeinheit eine eigene Liste
    //mit allen Nachricthen zu dieser Telematik Einheit.
    //Telematikeinheit wird über ID identifiziert.

    private static final String INCOMING_TASK_QUEUE_NAME = "travelData";
    private static final String OUTGOING_TASK_QUEUE_NAME = "distributor";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(INCOMING_TASK_QUEUE_NAME, true, false, false, null);
        System.out.println("Waiting for messages");

        channel.basicQos(0);

       // AtomicReference<MyMessage> myMessage = null;

        DeliverCallback deliverCallback = (consumerTag, delivery) ->{

            MyMessage myMessage = (MyMessage) SerializationUtils.deserialize(delivery.getBody());
            System.out.println("Recieved in InputFilter" + myMessage);

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

            try{
                channel.queueDeclare(OUTGOING_TASK_QUEUE_NAME, true, false, false, null);

                channel.basicPublish("",OUTGOING_TASK_QUEUE_NAME,false, null, SerializationUtils.serialize(myMessage));
                System.out.println("Sent " + myMessage);
            }
            catch (Exception e){}
        };
        channel.basicConsume(INCOMING_TASK_QUEUE_NAME, false, deliverCallback, consumerTag -> {});


    }
}
