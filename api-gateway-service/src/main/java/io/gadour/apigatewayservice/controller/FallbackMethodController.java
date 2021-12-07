package io.gadour.apigatewayservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {

    @GetMapping("/entrepotFallBack")
    public String entrepotFallBackMethod(){
        return "Entrepot service is taking more time then expected! Please try again later.";
    }

    @GetMapping("/productFallBack")
    public String productFallBackMethod(){
        return "Product service is taking more time then expected! Please try again later.";
    }
}
