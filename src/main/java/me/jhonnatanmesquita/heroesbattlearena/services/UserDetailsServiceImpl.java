package me.jhonnatanmesquita.heroesbattlearena.services;

import me.jhonnatanmesquita.heroesbattlearena.models.Jogador;
import me.jhonnatanmesquita.heroesbattlearena.repositories.JogadorReposity;
import me.jhonnatanmesquita.heroesbattlearena.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private JogadorReposity repo;

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {

        Jogador jogador = repo.findByNickname(nickname);

        if(jogador == null){
            throw new UsernameNotFoundException(nickname);
        }

        return new UserSS(jogador.getId(), jogador.getNickname(), jogador.getSenha(), jogador.getHeroi());
    }
}
