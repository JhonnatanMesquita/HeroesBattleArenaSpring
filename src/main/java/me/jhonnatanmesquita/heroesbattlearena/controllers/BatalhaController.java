package me.jhonnatanmesquita.heroesbattlearena.controllers;

import me.jhonnatanmesquita.heroesbattlearena.dtos.BatalhaDto;
import me.jhonnatanmesquita.heroesbattlearena.dtos.JogadorDto;
import me.jhonnatanmesquita.heroesbattlearena.services.BatalhaService;
import me.jhonnatanmesquita.heroesbattlearena.services.HeroiService;
import me.jhonnatanmesquita.heroesbattlearena.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/batalha")
public class BatalhaController {

    @Autowired
    private JogadorService jogadorService;

    @Autowired
    private HeroiService heroiService;

    @Autowired
    private BatalhaService batalhaService;

    @RequestMapping(value = "/bot", method = RequestMethod.GET)
    public ResponseEntity<BatalhaDto> batalhaBot() {
        return ResponseEntity.ok().body(batalhaService.botBattle());
    }

    @RequestMapping(value = "/oponente/{op}")
    public ResponseEntity<BatalhaDto> batalhaOponente(@PathVariable(value = "op") Integer id) {
        return ResponseEntity.ok().body(batalhaService.playerBattle(id));
    }

    @RequestMapping(value = "/buscar")
    public ResponseEntity<List<JogadorDto>> buscarOponentes() {
        return ResponseEntity.ok().body(jogadorService.findMatch());
    }

}
