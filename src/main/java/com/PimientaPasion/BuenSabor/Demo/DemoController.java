package com.PimientaPasion.BuenSabor.Demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
@RequiredArgsConstructor
public class DemoController {

    @PostMapping(value = "demoUser")
    public String welcome()
    {
        return "Bienvenido desde el endpoint seguro";
    }

    @PostMapping(value = "demoAdmin")
    public String welcomeAdmin()
    {
        return "Bienvenido desde el endpoint seguro ADMIN";
    }

}