package com.petproject.analyzingservice.service.impl;

import com.petproject.analyzingservice.model.DailyOrder;
import com.petproject.analyzingservice.repository.DailyOrderRepository;
import com.petproject.analyzingservice.service.OrderCreateStat;
import java.math.BigDecimal;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Реализация интерфейса, описывающего логику обработки входящей информации о заказах
 *
 * @author Egor Nazarev
 */
@Service
public class OrderCreateStatImpl implements OrderCreateStat {

    private final DailyOrderRepository dailyOrderRepository;

    public OrderCreateStatImpl(DailyOrderRepository dailyOrderRepository) {
        this.dailyOrderRepository = dailyOrderRepository;
    }

    private DailyOrder dailyOrder = new DailyOrder(0, BigDecimal.ZERO);

    /**
     * Метод, сохраняющий информацию о новом заказе
     * @param totalPrice стоимость нового заказа
     */
    @Override
    @KafkaListener(topics = "order-create", groupId = "incoming-info")
    public void IncomingOrder(String totalPrice) {
        dailyOrder.setTotalOrders(dailyOrder.getTotalOrders() + 1);
        dailyOrder.setTotalPrice(dailyOrder.getTotalPrice().add(BigDecimal.valueOf(Double.parseDouble(totalPrice))));
        System.out.println(dailyOrder.getTotalOrders() + " " + dailyOrder.getTotalPrice());
    }

    @Scheduled(cron = "@daily")
    private void dailyOrderSave(){
        dailyOrderRepository.save(dailyOrder);
        dailyOrder = new DailyOrder();
    }
}
