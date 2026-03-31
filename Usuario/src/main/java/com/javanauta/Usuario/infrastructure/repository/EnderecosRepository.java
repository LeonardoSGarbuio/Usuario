package com.javanauta.Usuario.infrastructure.repository;

import com.javanauta.aprendendo_spring.infrastructure.entity.Enderecos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecosRepository extends JpaRepository<Enderecos, Long> {
}
