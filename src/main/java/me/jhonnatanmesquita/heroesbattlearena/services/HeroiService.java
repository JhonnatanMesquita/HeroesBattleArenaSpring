package me.jhonnatanmesquita.heroesbattlearena.services;

import me.jhonnatanmesquita.heroesbattlearena.dtos.HeroiDto;
import me.jhonnatanmesquita.heroesbattlearena.models.Heroi;
import me.jhonnatanmesquita.heroesbattlearena.repositories.HeroiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroiService {

    @Autowired
    private HeroiRepository repo;

    public List<HeroiDto> findAll(){

        return toDtoList(repo.findAll());
    }

    public HeroiDto toDto(Heroi heroi){

        HeroiDto heroiDto = new HeroiDto();
        heroiDto.setId(heroi.getId());
        heroiDto.setNome(heroi.getNome());
        heroiDto.setAtaque(heroi.getAtaque());
        heroiDto.setDefesa(heroi.getDefesa());
        heroiDto.setForca(heroi.getForca());
        heroiDto.setPoder(heroi.getPoder());
        heroiDto.setInteligencia(heroi.getInteligencia());
        heroiDto.setVelocidade(heroi.getVelocidade());
        heroiDto.setVida(heroi.getVida());

        return heroiDto;
    }

    public List<HeroiDto> toDtoList(List<Heroi> heroiList){

        List<HeroiDto> heroiDtoList = new ArrayList<>();

        for (Heroi heroi: heroiList) {
            heroiDtoList.add(toDto(heroi));
        }

        return heroiDtoList;

    }
}
