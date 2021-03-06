package pl.kielce.tu.iui.iui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kielce.tu.iui.iui.services.CartService;

@RestController
@RequestMapping("cart")
public class CartController
{

    @Autowired
    private CartService cartService;

    @CrossOrigin
    @PostMapping("add/{id}")
    public ResponseEntity<?> add(@RequestParam("id") Long id)
    {
        cartService.addToCart(id);
        return ResponseEntity.ok(null);
    }

    @CrossOrigin
    @GetMapping("/")
    public ResponseEntity<?> getCart()
    {
        return ResponseEntity.ok(cartService.getCart());
    }
}
