package com.pragma.powerup.repository;

import com.pragma.powerup.model.OrderStatusLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderStatusLogRepository extends MongoRepository<OrderStatusLog,Long> {

    @Query("{ 'id_cliente' : ?0 }")
    List<OrderStatusLog> findByClientId(Long clientId);

}
