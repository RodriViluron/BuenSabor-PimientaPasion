package com.PimientaPasion.Sprint4.controllers;

import com.PimientaPasion.Sprint4.entities.RubroProducto;
import com.PimientaPasion.Sprint4.services.RubroProductoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/v1/rubroProductos")
public class RubroProductoController extends  BaseControllerImpl<RubroProducto, RubroProductoServiceImpl> {

    @GetMapping("buscarRubrosProdDisponibles")
    public ResponseEntity<?> buscarRubrosProdDisponibles (){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarRubrosProdDisponibles());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
