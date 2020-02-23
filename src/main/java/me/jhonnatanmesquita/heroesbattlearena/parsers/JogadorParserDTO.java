package me.jhonnatanmesquita.heroesbattlearena.parsers;

import me.jhonnatanmesquita.heroesbattlearena.dtos.HeroiDto;
import me.jhonnatanmesquita.heroesbattlearena.dtos.JogadorDto;
import me.jhonnatanmesquita.heroesbattlearena.dtos.JogadorInsertDto;
import me.jhonnatanmesquita.heroesbattlearena.models.Heroi;
import me.jhonnatanmesquita.heroesbattlearena.models.Jogador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JogadorParserDTO extends AbstractParser<JogadorDto, Jogador> {

	@Autowired
	private HeroiParserDTO heroiParserDTO;

	@Override
	public JogadorDto toDTO(Jogador entity) {
		JogadorDto dto = new JogadorDto();
		dto.setId(entity.getId());
		dto.setNickname(entity.getNickname());

		HeroiDto heroiDto = heroiParserDTO.toDTO(entity.getHeroi());
		dto.setHeroi(heroiDto);

		return dto;
	}

	@Override
	public Jogador toEntity(JogadorDto dto) {
		Jogador entity = new Jogador();
		entity.setId(dto.getId());
		entity.setNickname(dto.getNickname());

		Heroi heroi = heroiParserDTO.toEntity(dto.getHeroi());
		entity.setHeroi(heroi);

		return entity;
	}


	public Jogador toEntity(JogadorInsertDto dto) {
		Jogador entity = new Jogador();
		entity.setNickname(dto.getNickname());
		entity.setSenha(dto.getSenha());

		Heroi heroi = heroiParserDTO.toEntity(dto.getHeroi());
		entity.setHeroi(heroi);

		return entity;
	}

}
