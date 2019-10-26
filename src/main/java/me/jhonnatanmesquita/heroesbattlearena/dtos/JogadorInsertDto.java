package me.jhonnatanmesquita.heroesbattlearena.dtos;

import java.io.Serializable;

public class JogadorInsertDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nickname;
	private String senha;
	private HeroiDto Heroi;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public HeroiDto getHeroi() {
		return Heroi;
	}

	public void setHeroi(HeroiDto heroi) {
		Heroi = heroi;
	}
}
