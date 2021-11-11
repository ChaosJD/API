package de.thro.inf.vv.between.Consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import de.thro.inf.vv.between.MyMessage;
import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class DataWarehouse {
    private static final String INCOMING_TASK_QUEUE_NAME = "distributor";
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(INCOMING_TASK_QUEUE_NAME, true, false, false, null);
        System.out.println("Waiting for messages");

        channel.basicQos(0);


        //List<MyMessage> list = new LinkedList<>();
        //data Structure with 24 fields.


        DeliverCallback deliverCallback = (consumerTag, delivery) ->{

            MyMessage myMessage = (MyMessage) SerializationUtils.deserialize(delivery.getBody());
            System.out.println("Recieved in Logbook" + myMessage);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
           // list.add(myMessage);
        };


        channel.basicConsume(INCOMING_TASK_QUEUE_NAME, false, deliverCallback, consumerTag -> {});
    }
}
