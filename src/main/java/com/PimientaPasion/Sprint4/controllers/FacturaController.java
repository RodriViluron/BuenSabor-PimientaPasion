package com.PimientaPasion.Sprint4.controllers;

import com.PimientaPasion.Sprint4.entities.Factura;
import com.PimientaPasion.Sprint4.services.FacturaServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path ="api/v1/facturas")
public class FacturaController extends BaseControllerImpl<Factura, FacturaServiceImpl>{

}