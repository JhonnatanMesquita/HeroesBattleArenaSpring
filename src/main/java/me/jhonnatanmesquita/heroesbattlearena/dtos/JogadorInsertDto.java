package me.jhonnatanmesquita.heroesbattlearena.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class JogadorInsertDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento Obrigatório")
	@Length(min=3, max = 45, message = "Seu nickname não corresponde ao padrão do sistema. Verifique se o nickname possuí no mínimo 3 caracteres e no maximo 45 caracteres.")
	private String nickname;

	@NotEmpty(message = "Preenchimento Obrigatório")
	@Length(min=6, max = 8, message = "A senha não corresponde ao padrão do sistema. Verifique se a senha possuí no mínimo 6 caracteres e no maximo 8 caracteres.")
	private String senha;

	private HeroiDto heroi;

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
		return heroi;
	}

	public void setHeroi(HeroiDto heroi) {
		this.heroi = heroi;
	}
}
