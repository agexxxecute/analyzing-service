package com.petproject.analyzingservice.repository;

import com.petproject.analyzingservice.model.DailyOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для сохранения информации о заказах за сутки в базе данных
 *
 * @author Egor Nazarev
 */
@Repository
public interface DailyOrderRepository extends MongoRepository<DailyOrder, String> {

}
