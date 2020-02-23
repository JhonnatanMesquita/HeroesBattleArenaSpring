package me.jhonnatanmesquita.heroesbattlearena.services;

import me.jhonnatanmesquita.heroesbattlearena.dtos.JogadorDto;
import me.jhonnatanmesquita.heroesbattlearena.dtos.JogadorInsertDto;
import me.jhonnatanmesquita.heroesbattlearena.exceptions.ObjectNotFoundException;
import me.jhonnatanmesquita.heroesbattlearena.exceptions.ValidationError;
import me.jhonnatanmesquita.heroesbattlearena.exceptions.ValidationErrorException;
import me.jhonnatanmesquita.heroesbattlearena.models.Jogador;
import me.jhonnatanmesquita.heroesbattlearena.parsers.JogadorParserDTO;
import me.jhonnatanmesquita.heroesbattlearena.repositories.JogadorReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorReposity repo;

    @Autowired
    private JogadorParserDTO parser;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<JogadorDto> listar() {
        List<Jogador> jogadorList = repo.findAll();

        if(jogadorList.isEmpty()){
            throw new ObjectNotFoundException("Nenhum jogador encontrado!");
        }

        return parser.toDTO(jogadorList);
    }

    public JogadorDto findById(Integer id) {
        Optional<Jogador> jogador = repo.findById(id);
        JogadorDto jogadorDto = parser.toDTO(jogador.get());

        if(jogadorDto == null || jogadorDto.getNickname() == null){
            throw new ObjectNotFoundException("Jogador não encontrado!");
        }

        return jogadorDto;
    }

    public JogadorDto findByName(String name){
        Jogador jogador = repo.findByNickname(name);

        if(jogador == null || jogador.getNickname() == null){
            throw new ObjectNotFoundException("Jogador não encontrado!");
        }

        return parser.toDTO(jogador);
    }

    public JogadorDto salvar(JogadorInsertDto jogador) {

        if(jogador.getNickname().contains(" ")){
            throw new ValidationErrorException("Seu nickname não pode conter espaços, utilize - ou _");
        }

        if(jogador.getHeroi() == null){
            throw new ValidationErrorException("Herói não selecionado, por favor, escolha um herói e tente novamente!");
        }

        Jogador jogadorEnt = parser.toEntity(jogador);
        jogadorEnt.setSenha(passwordEncoder.encode(jogador.getSenha()));
        repo.save(jogadorEnt);
        return parser.toDTO(jogadorEnt);
    }
}
