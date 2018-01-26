package pl.kielce.tu.iui.iui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.kielce.tu.iui.iui.controller.json.OrderParam;
import pl.kielce.tu.iui.iui.entity.Order;
import pl.kielce.tu.iui.iui.model.OrderModel;
import pl.kielce.tu.iui.iui.services.OrderService;

@RestController
@RequestMapping("order")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @CrossOrigin
    @PostMapping("make")
    public ResponseEntity<?> makeOrder(@RequestBody OrderParam orderParam)
    {
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        OrderModel orderModel = new OrderModel(orderParam, currentUserEmail);
        Order order = orderModel.createOrder();

        orderService.save(order);


        return ResponseEntity.ok(orderParam);
    }
}
