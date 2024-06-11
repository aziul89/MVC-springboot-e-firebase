package com.example.ConCon.controllers;

import com.example.ConCon.model.Order;
import com.example.ConCon.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public List<Order> getAllOrders() throws ExecutionException, InterruptedException {
        return orderService.getAllOrders();
    }

    @PostMapping("/createOrder")
    public String createOrder(@Valid @RequestBody Order order, BindingResult bindingResult) throws ExecutionException, InterruptedException {
        if (bindingResult.hasErrors()) {
            System.out.println("error");
            return "Error";
        } else {
            System.out.println(order);
            return orderService.createOrder(order);
        }
    }

    @DeleteMapping("/deleteOrder")
    public String deleteOrder(@RequestBody int orderId) {
        return orderService.deleteOrder(orderId);
    }

    @PutMapping("/updateOrder")
    public String updateOrder(@RequestBody Order order) throws ExecutionException, InterruptedException {
        return orderService.updateOrder(order);
    }

    @GetMapping("/order/{orderId}")
    public Order getOrderById(@PathVariable int orderId) throws ExecutionException, InterruptedException {
        return orderService.getOrder(orderId);
    }
}
