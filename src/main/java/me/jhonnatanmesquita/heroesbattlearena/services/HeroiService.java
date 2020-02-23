package me.jhonnatanmesquita.heroesbattlearena.services;

import javassist.NotFoundException;
import me.jhonnatanmesquita.heroesbattlearena.dtos.HeroiDto;
import me.jhonnatanmesquita.heroesbattlearena.models.Heroi;
import me.jhonnatanmesquita.heroesbattlearena.parsers.HeroiParserDTO;
import me.jhonnatanmesquita.heroesbattlearena.repositories.HeroiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HeroiService {

    @Autowired
    private HeroiRepository repo;

    @Autowired
    private HeroiParserDTO parse;

    public List<HeroiDto> findAll(){

        return parse.toDTO(repo.findAll());
    }

    public HeroiDto findById(Integer id) throws NotFoundException {

        Optional<Heroi> opHeroi = repo.findById(id);

        if(opHeroi.isPresent()){
            return parse.toDTO(opHeroi.get());
        }else{
            throw new NotFoundException("Heroi não encontrado!");
        }
    }
}
