package com.gutjahr.funcionario.service;

import com.gutjahr.funcionario.exception.Advertencia;
import com.gutjahr.funcionario.model.Funcionario;
import com.gutjahr.funcionario.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public void salvar(Funcionario funcionario) {
        repository.save(funcionario);
    }

    public List<Funcionario> listar() {
        return repository.findAll();
    }

    public void excluir(Long id) {
        Optional<Funcionario> funcionario = repository.findById(id);
        if (funcionario.isEmpty()) {
            throw new Advertencia("Funcionário não encontrado");
        }
        repository.deleteById(id);
    }
}
