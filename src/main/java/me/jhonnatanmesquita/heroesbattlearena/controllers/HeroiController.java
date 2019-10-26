package me.jhonnatanmesquita.heroesbattlearena.controllers;

import me.jhonnatanmesquita.heroesbattlearena.dtos.HeroiDto;
import me.jhonnatanmesquita.heroesbattlearena.services.HeroiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/heroi")
public class HeroiController {

    @Autowired
    private HeroiService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<HeroiDto>> findAll(){

        return ResponseEntity.ok().body(service.findAll());
    }
}
