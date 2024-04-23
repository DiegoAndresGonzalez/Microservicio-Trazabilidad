package com.pragma.powerup.adapter;

import com.pragma.powerup.feignclient.IUserFeignClient;
import com.pragma.powerup.model.OrderStatusLog;
import com.pragma.powerup.model.UserModel;
import com.pragma.powerup.repository.OrderStatusLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TraceabilityAdapter {

    private final OrderStatusLogRepository statusLogRepository;
    private final IUserFeignClient userFeignClient;

    public OrderStatusLog changeOrderStatus(Long orderId, Long clientId, Long chefId,
                                            String lastStatus, String newStatus, Date date,
                                            String clientEmail, String chefEmail){
        OrderStatusLog log = new OrderStatusLog();
        log.setOrderId(orderId);
        log.setNewStatus(newStatus);
        log.setLastStatus(lastStatus);
        log.setDate(date);
        log.setClientId(clientId);
        log.setClientEmail(clientEmail);
        log.setEmployeeEmail(chefEmail);
        log.setEmployeeId(chefId);
        statusLogRepository.save(log);
        return log;
    }

    public List<OrderStatusLog> getClientLogs(String token){
        UserModel userModel = userFeignClient.fetchUser(token);
        return statusLogRepository.
                findByClientId(userModel.getId());
    }

}
