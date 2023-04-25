package com.gutjahr.funcionario.repository;

import com.gutjahr.funcionario.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {}
