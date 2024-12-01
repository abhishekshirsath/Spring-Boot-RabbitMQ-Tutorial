package net.javaguides.orderservice.publisher;

import net.javaguides.orderservice.DTO.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchage;

    @Value("${rabbitmq.routing.key.order}")
    private String orderRoutingKey;

    @Value("${rabbitmq.routing.key.email}")
    private String emailRoutingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrderEvent(OrderEvent orderEvent){

        LOGGER.info(String.format("OrderEvent sent to Order queue-> %s",orderEvent.toString()));

        // Send an order event to order queue
        rabbitTemplate.convertAndSend(exchage,orderRoutingKey,orderEvent);

        LOGGER.info(String.format("OrderEvent sent to Email queue -> %s",orderEvent.toString()));

        // Send an order event to email queue
        rabbitTemplate.convertAndSend(exchage,emailRoutingKey,orderEvent);
    }

}
