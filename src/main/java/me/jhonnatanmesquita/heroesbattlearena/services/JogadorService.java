package me.jhonnatanmesquita.heroesbattlearena.services;

import me.jhonnatanmesquita.heroesbattlearena.dtos.JogadorDto;
import me.jhonnatanmesquita.heroesbattlearena.dtos.JogadorInsertDto;
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
        return parser.toDTO(jogadorList);
    }

    public JogadorDto findById(Integer id) {
        Optional<Jogador> jogador = repo.findById(id);
        JogadorDto jogadorDto = parser.toDTO(jogador.get());
        return jogadorDto;
    }

    public JogadorDto findByName(String name){
        Jogador jogador = repo.findByNickname(name);
        return parser.toDTO(jogador);
    }

    public JogadorDto salvar(JogadorInsertDto jogador) {
        Jogador jogadorEnt = parser.toEntity(jogador);
        jogadorEnt.setSenha(passwordEncoder.encode(jogador.getSenha()));
        repo.save(jogadorEnt);
        return parser.toDTO(jogadorEnt);
    }
}
