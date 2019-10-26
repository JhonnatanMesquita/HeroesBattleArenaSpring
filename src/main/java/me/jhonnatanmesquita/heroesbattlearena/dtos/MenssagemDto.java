package me.jhonnatanmesquita.heroesbattlearena.dtos;

import java.io.Serializable;

public class MenssagemDto implements Serializable {


    private static final long serialVersionUID = 1L;

    private String statusBatalha;
    private String playerVencedor;
    private String heroiVencedor;

    public String getStatusBatalha() {
        return statusBatalha;
    }

    public void setStatusBatalha(String statusBatalha) {
        this.statusBatalha = statusBatalha;
    }

    public String getPlayerVencedor() {
        return playerVencedor;
    }

    public void setPlayerVencedor(String playerVencedor) {
        this.playerVencedor = playerVencedor;
    }

    public String getHeroiVencedor() {
        return heroiVencedor;
    }

    public void setHeroiVencedor(String heroiVencedor) {
        this.heroiVencedor = heroiVencedor;
    }
}
