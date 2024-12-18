package net.javaguides.stockservice.consumer;

import net.javaguides.stockservice.DTO.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.stock.name}")
    public void consume(OrderEvent event){

        LOGGER.info(String.format("Order event received -> %s",event.toString()));

        // save order event data in database

    }

}
