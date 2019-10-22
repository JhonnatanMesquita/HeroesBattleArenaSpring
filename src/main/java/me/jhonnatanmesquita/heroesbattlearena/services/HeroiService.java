package me.jhonnatanmesquita.heroesbattlearena.services;

import me.jhonnatanmesquita.heroesbattlearena.models.Heroi;
import me.jhonnatanmesquita.heroesbattlearena.repositories.HeroiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroiService {

    @Autowired
    private HeroiRepository repo;

    public List<Heroi> findAll(){
        return repo.findAll();
    }
}
