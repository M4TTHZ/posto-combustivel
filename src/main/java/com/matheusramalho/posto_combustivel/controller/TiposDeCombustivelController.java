package com.matheusramalho.posto_combustivel.controller;

import com.matheusramalho.posto_combustivel.infrastructure.entities.TiposDeCombutivel;
import com.matheusramalho.posto_combustivel.service.TiposDeCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tiposDeCombustivel")
public class TiposDeCombustivelController {

    private TiposDeCombustivelService tiposDeCombustivelService;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody TiposDeCombutivel tiposDeCombutivel) {
        tiposDeCombustivelService.criar(tiposDeCombutivel);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<TiposDeCombutivel>> buscarTiposDeCombustivel(){
        return ResponseEntity.ok(tiposDeCombustivelService.buscarTiposDeCombustivel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TiposDeCombutivel>  buscarTiposDeCombutivelPorId(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(tiposDeCombustivelService.buscarTiposDeCombustivelPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTipoDeCombustivelPorId(@PathVariable(name = "id") Integer id){
        tiposDeCombustivelService.deletarTipoDeCombustivel(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> alterarTipoDeCombustivelPorId(@PathVariable(name = "id") Integer id,
                                                                                @RequestBody TiposDeCombutivel tiposDeCombutivel){
        tiposDeCombustivelService.alterarTipoDeCombustivel(id, tiposDeCombutivel);
        return ResponseEntity.ok().build();
    }

}
