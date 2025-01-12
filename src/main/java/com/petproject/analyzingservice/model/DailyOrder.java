package com.petproject.analyzingservice.model;

import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Сущность, описывающая информацию о заказах за сутки
 *
 * @author Egor Nazarev
 */
@Data
@Document(collection = "daily_orders")
@NoArgsConstructor
public class DailyOrder {
    @Id
    private String id;

    @Field(value = "totalOrders")
    private long totalOrders;

    @Field(value = "totalPrice")
    private BigDecimal totalPrice;

    public DailyOrder(long totalOrders, BigDecimal totalPrice) {
        this.totalOrders = totalOrders;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(Long totalOrders) {
        this.totalOrders = totalOrders;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
