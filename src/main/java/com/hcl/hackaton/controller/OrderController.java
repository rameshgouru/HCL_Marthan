/**
 * Author       : Ramesh Gouru
 * Created date : 26/3/2022
 * Description  : this class describes the Order details and have apis info
 */

package com.hcl.hackaton.controller;

import com.hcl.hackaton.exception.OrderNotFoundException;
import com.hcl.hackaton.exception.PortfolioCustomException;
import com.hcl.hackaton.models.Order;
import com.hcl.hackaton.service.OrderService;
import com.hcl.hackaton.utils.ConstantValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     *
     * @param orderId get from api call
     * @return Order Object
     */
    @GetMapping("/orderid/{orderid}")
    public ResponseEntity<Order> findOrderByOrderId(@PathVariable(name = "orderid")  String orderId){
        log.info("findOrderByOrderId , orderId :: {} ",orderId);
        try{
            Optional<Order> order=orderService.findOrderByOrderId(Long.parseLong(orderId));
            log.info("findOrderByOrderId , order result :: {} ",order);
            if(order.isPresent()){
                return new ResponseEntity<>(order.get(), HttpStatus.OK);
            }else{
                throw new OrderNotFoundException(ConstantValue.ORDER_NOT_FOUND +orderId);
            }
        }catch (NumberFormatException e){
            throw new PortfolioCustomException(ConstantValue.ORDER_ID_FORMAT);
        }

    }

    /**
     *
     * @param portfolioid input from api
     * @param order input from api (Order Entity)
     * @return Order Entity
     */
    @PutMapping("/updateorder/{portfolioid}/{order}")
    public ResponseEntity<Order> updateOrder(@PathVariable (name="portfolioid") Long portfolioid, @RequestBody Order order){
        log.info("updateOrder , portfolioid :: {} and order object ",portfolioid,order);
        try{
            return new ResponseEntity<>(orderService.updateOrder(order), HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PostMapping("/addOrder/{order}")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        log.info("saveOrder , order object ",order);
        try{
            return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
