package com.PimientaPasion.Sprint4.controllers;

import com.PimientaPasion.Sprint4.entities.Producto;
import com.PimientaPasion.Sprint4.services.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/productos")

public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImpl> {


    //@Autowired
    //ProductoServiceImpl productoService;

    @GetMapping("/buscarPorDenominacion")
    public ResponseEntity<?> buscarPorDenominacion(@RequestParam String denominacion) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorDenominacion(denominacion));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/buscarPorDenominacionPage")
    public ResponseEntity<?> buscarPorDenominacion(@RequestParam String denominacion, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorDenominacion(denominacion, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("no hay productos que coincidan con esa búsqueda"));
        }
    }

    @GetMapping("/buscarDisponibles")
    public ResponseEntity<?> buscarDisponibles (){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarDisponibles());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }
    }


}
