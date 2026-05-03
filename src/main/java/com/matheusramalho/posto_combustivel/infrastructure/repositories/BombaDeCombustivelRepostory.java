package com.matheusramalho.posto_combustivel.infrastructure.repositories;

import com.matheusramalho.posto_combustivel.infrastructure.entities.BombaDeCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BombaDeCombustivelRepostory extends JpaRepository<BombaDeCombustivel,Integer> {
}
