package me.jhonnatanmesquita.heroesbattlearena.controllers;

import me.jhonnatanmesquita.heroesbattlearena.dtos.JogadorDto;
import me.jhonnatanmesquita.heroesbattlearena.dtos.JogadorInsertDto;
import me.jhonnatanmesquita.heroesbattlearena.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/jogador")
public class JogadorController {

    @Autowired
    private JogadorService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<JogadorDto>> listar() {
        return ResponseEntity.ok().body(service.listar());
    }

    @RequestMapping(value = "/nick/{nick}", method = RequestMethod.GET)
    public ResponseEntity<JogadorDto> getByName(@PathVariable(value = "nick") String nick) {
        return ResponseEntity.ok().body(service.findByName(nick));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<JogadorDto> salvar(@Valid @RequestBody JogadorInsertDto jogador){
        return ResponseEntity.ok().body(service.salvar(jogador));
    }
}
