package com.petproject.analyzingservice.service;

/**
 * Интерфейс, описывающий логику обработки входящей информации о заказах
 *
 * @author Egor Nazarev
 */
public interface OrderCreateStat {

    /**
     * Метод, сохраняющий информацию о новом заказе
     * @param totalPrice стоимость нового заказа
     */
    void IncomingOrder(String totalPrice);

}
