package pl.kielce.tu.iui.iui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.kielce.tu.iui.iui.controller.json.AddressJSON;
import pl.kielce.tu.iui.iui.controller.json.OrderParam;
import pl.kielce.tu.iui.iui.controller.json.OrderResponse;
import pl.kielce.tu.iui.iui.controller.json.UserResponse;
import pl.kielce.tu.iui.iui.controller.json.utill.AddressConverter;
import pl.kielce.tu.iui.iui.controller.json.utill.OrderResponseCreator;
import pl.kielce.tu.iui.iui.controller.json.utill.PizzaResponseCreator;
import pl.kielce.tu.iui.iui.controller.json.utill.UserConverter;
import pl.kielce.tu.iui.iui.entity.Address;
import pl.kielce.tu.iui.iui.entity.Order;
import pl.kielce.tu.iui.iui.model.OrderDetails;
import pl.kielce.tu.iui.iui.model.OrderModel;
import pl.kielce.tu.iui.iui.services.AddressService;
import pl.kielce.tu.iui.iui.services.OrderService;

@RestController
@RequestMapping("order")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderModel orderModel;


    @CrossOrigin
    @PostMapping("make")
    public ResponseEntity<?> makeOrder(@RequestBody OrderParam orderParam)
    {
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        Address address = AddressConverter.convertToAddress(orderParam.getAddressJSON());
        addressService.insert(address);

        OrderDetails orderDetails = new OrderDetails(orderParam.getPizzaIds(), address, currentUserEmail);

        Order order = orderModel.createOrder(orderDetails);

        orderService.save(order);
//        double price = pizzaRepository.getPriceById(1L);

        return ResponseEntity.ok(order.getId());
    }

    @CrossOrigin
    @GetMapping("{id}")
    public ResponseEntity<?> getOrderByOd(@RequestParam("id") int id)
    {
        Order order = orderService.getOrderById(id);

        OrderResponse orderResponse = OrderResponseCreator.createResponseOf(order);


        return ResponseEntity.ok(orderResponse);
    }
}
