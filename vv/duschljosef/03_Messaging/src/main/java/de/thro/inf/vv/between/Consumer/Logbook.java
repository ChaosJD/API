package de.thro.inf.vv.between.Consumer;

import com.rabbitmq.client.*;
import de.thro.inf.vv.between.MyMessage;
import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Logbook {
    //This is Subscriber of Topic verteiler

    private static final String INCOMING_TASK_QUEUE_NAME = "distributor";
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(INCOMING_TASK_QUEUE_NAME, true, false, false, null);
        System.out.println("Waiting for messages");

        channel.basicQos(0);

        DeliverCallback deliverCallback = (consumerTag, delivery) ->{

            MyMessage myMessage = (MyMessage) SerializationUtils.deserialize(delivery.getBody());
            System.out.println("Recieved in Logbook" + myMessage);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        };
        channel.basicConsume(INCOMING_TASK_QUEUE_NAME, false, deliverCallback, consumerTag -> {});
    }
}
