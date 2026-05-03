package com.matheusramalho.posto_combustivel.infrastructure.repositories;

import com.matheusramalho.posto_combustivel.infrastructure.entities.Abastecimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbastecimentoRepostory extends JpaRepository<Abastecimento,Integer> {
}
