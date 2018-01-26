package pl.kielce.tu.iui.iui.controller.json.utill;

import pl.kielce.tu.iui.iui.controller.json.AddressJSON;
import pl.kielce.tu.iui.iui.controller.json.OrderResponse;
import pl.kielce.tu.iui.iui.controller.json.UserResponse;
import pl.kielce.tu.iui.iui.entity.Order;

import java.time.format.DateTimeFormatter;

public class OrderResponseCreator
{
    public static OrderResponse createResponseOf(Order order)
    {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setCanceled(order.isCanceled());
        orderResponse.setDone(order.isDone());
        orderResponse.setPrice(order.getPrice());
        orderResponse.setDate(order.getData().format(DateTimeFormatter.ofPattern("DD-MM-YYYY")));

        UserResponse userResponse = UserConverter.cpnvertToUserResponse(order.getUser());
        orderResponse.setUser(userResponse);

        AddressJSON address = AddressConverter.convertToAddressJSON(order.getAddress());
        orderResponse.setAddress(address);

        orderResponse.setPizzas(PizzaResponseCreator.createResponseOf(order.getPizzas()));

        return orderResponse;
    }
}
