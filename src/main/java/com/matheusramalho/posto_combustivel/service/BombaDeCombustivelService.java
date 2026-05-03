package com.matheusramalho.posto_combustivel.service;

import com.matheusramalho.posto_combustivel.infrastructure.entities.BombasDeCombustivel;
import com.matheusramalho.posto_combustivel.infrastructure.repositories.BombaDeCombustivelRepostory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BombaDeCombustivelService {

    private final BombaDeCombustivelRepostory bombaDeCombustivelRepostory;

    public void criar(BombasDeCombustivel bombaDeCombustivel){
       bombaDeCombustivelRepostory.save(bombaDeCombustivel);
    }

    public BombasDeCombustivel buscarBombaDeCombustivelPorId(Integer id){
       return bombaDeCombustivelRepostory.findById(id).orElseThrow(() ->
            new NullPointerException("Bomba de combustivel nao encontrada pelo id "+id));
    }

    public List<BombasDeCombustivel> buscarBombaDeCombustivel(){
        return bombaDeCombustivelRepostory.findAll();
    }

    @Transactional
    public void deletarBombaDeCombustivel(Integer id){
        bombaDeCombustivelRepostory.deleteById(id);
    }

    public void alterarBombaDeCombustivel(Integer id, BombasDeCombustivel bombaDeCombustivel) {
        BombasDeCombustivel bomba= buscarBombaDeCombustivelPorId(id);
        bombaDeCombustivel.setId(bomba.getId());
        bombaDeCombustivelRepostory.save(bombaDeCombustivel);
    }

}
