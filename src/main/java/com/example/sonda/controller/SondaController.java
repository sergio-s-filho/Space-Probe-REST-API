package com.example.sonda.controller;

import com.example.sonda.model.SondaModel;
import com.example.sonda.service.SondaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sonda")
public class SondaController {
    @Autowired
    SondaService sondaService;




    @PostMapping("/")
    public ResponseEntity<Object> adicionaSonda(@RequestBody SondaModel sondaModelJson){
        SondaModel sondaModelTemp = new SondaModel();
        sondaModelTemp.setPosX(sondaModelJson.getPosX());
        sondaModelTemp.setPosY(sondaModelJson.getPosY());
        sondaModelTemp.setOrientacao(sondaModelJson.getOrientacao());
        return ResponseEntity.status(HttpStatus.CREATED).body(sondaService.save(sondaModelTemp));
    }


  
    @GetMapping("/")
    public ResponseEntity<List> mostrarSondas(){
        return ResponseEntity.status(HttpStatus.OK).body(sondaService.findAll());
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Object> encontrarSonda(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(sondaService.findById(id));
    }

   

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarDadosSonda(@PathVariable UUID id, @RequestBody SondaModel sonda){
        SondaModel sondaModelTemp = sondaService.findById(id);
        sondaModelTemp.setPosX(sonda.getPosX());
        sondaModelTemp.setPosY(sonda.getPosY());
        sondaModelTemp.setOrientacao(sonda.getOrientacao());

        return ResponseEntity.status(HttpStatus.OK).body(sondaService.save(sondaModelTemp));
    }

    

    @PutMapping("/{id}/{comando}")
    public ResponseEntity<Object> enviarComandosSonda(@PathVariable UUID id, @PathVariable String comando){
        SondaModel sondaModelTemp = sondaService.findById(id);
        sondaModelTemp.followCommands(comando);
        return ResponseEntity.status(HttpStatus.OK).body(sondaService.save(sondaModelTemp));
    }
   

   @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarSonda(@PathVariable UUID id){
        SondaModel sondaModelTemp = sondaService.findById(id);
        sondaService.delete(sondaModelTemp);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado");
   }
}
