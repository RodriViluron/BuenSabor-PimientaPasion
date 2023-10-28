package com.PimientaPasion.Sprint4.controllers;


import com.PimientaPasion.Sprint4.entities.Cliente;
import com.PimientaPasion.Sprint4.services.ClienteServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path ="api/v1/clientes")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl>{

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde\"}");
        }
    }

    @GetMapping("/singInCliente")
    public ResponseEntity<?> singInCliente(@RequestParam String filtro1, @RequestParam String filtro2){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.singInCliente(filtro1,filtro2));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde\"}");
        }
    }

}