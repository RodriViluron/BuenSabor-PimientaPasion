package com.PimientaPasion.Sprint4.controllers;

import com.PimientaPasion.Sprint4.entities.Domicilio;
import com.PimientaPasion.Sprint4.services.DomicilioServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/domicilios")

public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioServiceImpl>{


}
