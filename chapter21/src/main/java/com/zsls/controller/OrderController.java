package com.zsls.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zsls.pojo.*;

import java.time.LocalDateTime;

/**
 * @author Levin
 * @since 2018/8/2 0002
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public Order test1() {
		Order order = new Order();
        order.setPayTime(LocalDateTime.now());
        return order;
    }
}
