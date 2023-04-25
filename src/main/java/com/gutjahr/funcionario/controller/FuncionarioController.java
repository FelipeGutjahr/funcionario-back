package com.gutjahr.funcionario.controller;

import com.gutjahr.funcionario.dto.ResponseDTO;
import com.gutjahr.funcionario.model.Funcionario;
import com.gutjahr.funcionario.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @PostMapping("/salvar")
    public ResponseDTO salvar(@Valid @RequestBody Funcionario funcionario, ResponseDTO response) {
        service.salvar(funcionario);
        return response.setMessage("Funcionário salvo com sucesso");
    }

    @GetMapping("/listar")
    public ResponseDTO listar(ResponseDTO response) {
        response.setResult(service.listar());
        return response;
    }

    @DeleteMapping("/excluir")
    public ResponseDTO excluir(ResponseDTO response, Long id) {
        service.excluir(id);
        return response.setMessage("Funcionário excluído com sucesso");
    }
}
