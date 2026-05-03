package com.matheusramalho.posto_combustivel.service;

import com.matheusramalho.posto_combustivel.infrastructure.entities.Abastecimento;
import com.matheusramalho.posto_combustivel.infrastructure.entities.BombasDeCombustivel;
import com.matheusramalho.posto_combustivel.infrastructure.repositories.AbastecimentoRepostory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AbastecimentoService {

    private final AbastecimentoRepostory abastecimentoRepostory;
    private final BombaDeCombustivelService bombaDeCombustivelService;

    public void abastecer(Integer idBomba, Long litros){
        BombasDeCombustivel bomba = bombaDeCombustivelService.buscarBombaDeCombustivelPorId(idBomba);
        BigDecimal valorTotal= bomba.getTiposDeCombutivel()
                .getPrecoPorLitro().multiply(BigDecimal.valueOf(litros));

        Abastecimento abastecimento= Abastecimento.builder()
                .dataAbastecimento(LocalDate.now())
                .bombaDeCombustivel(bomba)
                .valorTotal(valorTotal)
                .quantidadeLitros(litros)
                .build();

        abastecimentoRepostory.save(abastecimento);
    }

    public List<Abastecimento> buscarAbastecimentos(){
       return abastecimentoRepostory.findAll();
    }

}
