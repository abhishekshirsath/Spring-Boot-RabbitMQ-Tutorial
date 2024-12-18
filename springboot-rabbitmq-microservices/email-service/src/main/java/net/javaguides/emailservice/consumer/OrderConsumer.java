package net.javaguides.emailservice.consumer;

import net.javaguides.emailservice.DTO.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.email.name}")
    public void consume(OrderEvent orderEvent){

        LOGGER.info(String.format("Order event received in email service -> %s",orderEvent.toString()));

        //email service needs to email customer

    }

}
