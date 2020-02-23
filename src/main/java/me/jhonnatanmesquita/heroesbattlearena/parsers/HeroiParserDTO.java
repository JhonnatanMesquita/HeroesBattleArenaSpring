package me.jhonnatanmesquita.heroesbattlearena.parsers;

import me.jhonnatanmesquita.heroesbattlearena.dtos.HeroiDto;
import me.jhonnatanmesquita.heroesbattlearena.models.Heroi;
import org.springframework.stereotype.Component;

@Component
public class HeroiParserDTO extends AbstractParser<HeroiDto, Heroi> {

	@Override
	public HeroiDto toDTO(Heroi entity) {
		HeroiDto dto = new HeroiDto();
		dto.setAtaque(entity.getAtaque());
		dto.setDefesa(entity.getDefesa());
		dto.setForca(entity.getForca());
		dto.setId(entity.getId());
		dto.setInteligencia(entity.getInteligencia());
		dto.setNome(entity.getNome());
		dto.setPoder(entity.getPoder());
		dto.setVelocidade(entity.getVelocidade());
		dto.setVida(entity.getVida());
		return dto;
	}

	@Override
	public Heroi toEntity(HeroiDto dto) {
		Heroi entity = new Heroi();
		entity.setAtaque(dto.getAtaque());
		entity.setDefesa(dto.getDefesa());
		entity.setForca(dto.getForca());
		entity.setId(dto.getId());
		entity.setInteligencia(dto.getInteligencia());
		entity.setNome(dto.getNome());
		entity.setPoder(dto.getPoder());
		entity.setVelocidade(dto.getVelocidade());
		entity.setVida(dto.getVida());
		return entity;
	}

}
