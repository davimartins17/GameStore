package org.example.gamestore.controller;

import jakarta.validation.Valid;
import org.example.gamestore.dto.DesenvolvedoraRequestDTO;
import org.example.gamestore.dto.DesenvolvedoraResponseDTO;
import org.example.gamestore.model.Desenvolvedora;
import org.example.gamestore.service.DesenvolvedoraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desenvolvedora")
public class DesenvolvedoraController {

    private final DesenvolvedoraService service;

    public DesenvolvedoraController(DesenvolvedoraService service){
        this.service = service;
    }
    @PostMapping
    public DesenvolvedoraResponseDTO salvar(@RequestBody @Valid DesenvolvedoraRequestDTO dto){
        return service.salvar(dto);
    }
    @GetMapping
    public List<DesenvolvedoraResponseDTO> buscar(){
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public DesenvolvedoraResponseDTO buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public DesenvolvedoraResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid DesenvolvedoraRequestDTO dto){
        return service.atualizar(dto,id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
