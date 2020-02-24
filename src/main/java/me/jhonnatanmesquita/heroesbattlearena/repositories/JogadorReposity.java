package me.jhonnatanmesquita.heroesbattlearena.repositories;

import me.jhonnatanmesquita.heroesbattlearena.models.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JogadorReposity extends JpaRepository<Jogador, Integer> {

    @Transactional(readOnly = true)
    Jogador findByNickname(String nick);

    @Transactional(readOnly = true)
    List<Jogador> findAllByNicknameIsNotContaining(String nick);
}
