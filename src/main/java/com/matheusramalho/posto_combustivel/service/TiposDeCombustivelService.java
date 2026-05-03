package com.matheusramalho.posto_combustivel.service;

import com.matheusramalho.posto_combustivel.infrastructure.entities.TiposDeCombutivel;
import com.matheusramalho.posto_combustivel.infrastructure.repositories.TiposDeCombustivelRepostory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TiposDeCombustivelService {

    private final TiposDeCombustivelRepostory tiposDeCombustivelRepostory;

    public void criar(TiposDeCombutivel tiposDeCombustivel){
        tiposDeCombustivelRepostory.save(tiposDeCombustivel);
    }

    private TiposDeCombutivel buscarTiposDeCombustivelPorId(Integer id){
        return tiposDeCombustivelRepostory.findById(id).orElseThrow(() ->
                new NullPointerException("Tipo de combustivel nao encontrada pelo id "+id));
    }

    private List<TiposDeCombutivel> buscarTiposDeCombustivel(){
        return tiposDeCombustivelRepostory.findAll();
    }

    @Transactional
    private void deletarTipoDeCombustivel(Integer id){
        tiposDeCombustivelRepostory.deleteById(id);
    }

    private void alterarTipoDeCombustivel(Integer id, TiposDeCombutivel tiposDeCombustivel) {
        TiposDeCombutivel bomba= buscarTiposDeCombustivelPorId(id);
        tiposDeCombustivel.setId(bomba.getId());
        tiposDeCombustivelRepostory.save(tiposDeCombustivel);
    }

}
