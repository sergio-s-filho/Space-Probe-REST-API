package com.example.sonda.repository;

import com.example.sonda.model.SondaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SondaRepository extends JpaRepository<SondaModel, UUID> {


}
