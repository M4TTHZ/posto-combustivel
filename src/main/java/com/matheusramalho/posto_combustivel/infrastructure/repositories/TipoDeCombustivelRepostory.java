package com.matheusramalho.posto_combustivel.infrastructure.repositories;

import com.matheusramalho.posto_combustivel.infrastructure.entities.TiposDeCombutivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDeCombustivelRepostory extends JpaRepository<TiposDeCombutivel, Integer> {
}
