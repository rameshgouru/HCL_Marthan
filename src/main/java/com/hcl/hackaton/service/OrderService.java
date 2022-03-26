/**
 * Author       : Ramesh Gouru
 * Created date : 26/3/2022
 * Description  : this class have methods to interact with order repository
 */

package com.hcl.hackaton.service;

import com.hcl.hackaton.exception.OrderNotFoundException;
import com.hcl.hackaton.models.Order;
import com.hcl.hackaton.repository.OrderRepository;
import com.hcl.hackaton.utils.ConstantValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Optional<Order> findOrderByOrderId(Long orderId){
        return orderRepository.findById(orderId);
    }

    @Modifying
    public Order updateOrder(Order order){
        if(findOrderByOrderId(order.getOrderId()).isPresent()){
            return saveOrder(order);
        }else{
            throw new OrderNotFoundException(ConstantValue.ORDER_NOT_FOUND +order.getOrderId());
        }
    }

    @Modifying
    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }
    
}
