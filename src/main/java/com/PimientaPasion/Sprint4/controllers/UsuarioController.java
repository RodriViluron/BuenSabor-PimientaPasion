package com.PimientaPasion.Sprint4.controllers;

import com.PimientaPasion.Sprint4.entities.Usuario;
import com.PimientaPasion.Sprint4.services.UsuarioServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/usuarios")

public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>{


}
