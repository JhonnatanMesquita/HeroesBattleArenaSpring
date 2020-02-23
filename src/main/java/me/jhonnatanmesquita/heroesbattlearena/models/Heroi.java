package me.jhonnatanmesquita.heroesbattlearena.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "heroi")
public class Heroi implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer ataque;
	private Integer defesa;
	private Integer inteligencia;
	private String nome;
	private Integer poder;
	private Integer velocidade;
	private Integer forca;
	private Integer vida;

	@JsonIgnore
	@OneToMany(mappedBy = "heroi")
	private List<Jogador> jogadores = new ArrayList<>();

	public Heroi() {
	}

	public Heroi(Integer ataque, Integer defesa, Integer inteligencia, String nome, Integer poder, Integer velocidade, Integer forca, Integer vida) {
		this.ataque = ataque;
		this.defesa = defesa;
		this.inteligencia = inteligencia;
		this.nome = nome;
		this.poder = poder;
		this.velocidade = velocidade;
		this.forca = forca;
		this.vida = vida;
	}

	public Integer getAtaque() {
		return ataque;
	}

	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}

	public Integer getDefesa() {
		return defesa;
	}

	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(Integer inteligencia) {
		this.inteligencia = inteligencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPoder() {
		return poder;
	}

	public void setPoder(Integer poder) {
		this.poder = poder;
	}

	public Integer getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Integer velocidade) {
		this.velocidade = velocidade;
	}

	public Integer getForca() {
		return forca;
	}

	public void setForca(Integer forca) {
		this.forca = forca;
	}

	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}

}
