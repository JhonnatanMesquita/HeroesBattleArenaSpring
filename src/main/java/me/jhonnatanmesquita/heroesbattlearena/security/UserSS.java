package me.jhonnatanmesquita.heroesbattlearena.security;

import me.jhonnatanmesquita.heroesbattlearena.dtos.HeroiDto;
import me.jhonnatanmesquita.heroesbattlearena.dtos.JogadorDto;
import me.jhonnatanmesquita.heroesbattlearena.models.Heroi;
import me.jhonnatanmesquita.heroesbattlearena.parsers.HeroiParserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserSS implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nickname;
    private String senha;
    private Heroi heroi;

    private Collection<? extends GrantedAuthority> authorities;

    public UserSS() {
    }

    public UserSS(Integer id, String nickname, String senha, Heroi heroi) {
        this.id = id;
        this.nickname = nickname;
        this.senha = senha;
        this.heroi = heroi;
    }

    public Integer getId(){
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return nickname;
    }

    public JogadorDto getJogador(){
        return new JogadorDto(id, nickname,  new HeroiParserDTO().toDTO(heroi));
    }

    public Heroi getHeroi(){
        return heroi;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
