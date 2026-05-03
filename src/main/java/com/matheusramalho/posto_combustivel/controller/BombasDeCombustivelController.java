package com.matheusramalho.posto_combustivel.controller;

import com.matheusramalho.posto_combustivel.infrastructure.entities.BombasDeCombustivel;
import com.matheusramalho.posto_combustivel.infrastructure.entities.TiposDeCombutivel;
import com.matheusramalho.posto_combustivel.service.BombaDeCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bombasDeCombustivel")
public class BombasDeCombustivelController {

    private BombaDeCombustivelService bombaDeCombustivelService;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody BombasDeCombustivel bombasDeCombustivel) {
        bombaDeCombustivelService.criar(bombasDeCombustivel);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<BombasDeCombustivel>> buscarBombasDeCombustivel(){
        return ResponseEntity.ok(bombaDeCombustivelService.buscarBombaDeCombustivel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BombasDeCombustivel>  buscarBombasDeCombutivelPorId(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(bombaDeCombustivelService.buscarBombaDeCombustivelPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBombaDeCombustivelPorId(@PathVariable(name = "id") Integer id){
        bombaDeCombustivelService.deletarBombaDeCombustivel(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> alterarBombaDeCombustivelPorId(@PathVariable(name = "id") Integer id,
                                                                                @RequestBody BombasDeCombustivel bombasDeCombustivel){
        bombaDeCombustivelService.alterarBombaDeCombustivel(id, bombasDeCombustivel);
        return ResponseEntity.ok().build();
    }

}
