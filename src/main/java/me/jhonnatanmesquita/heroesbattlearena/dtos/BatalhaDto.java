package me.jhonnatanmesquita.heroesbattlearena.dtos;

import java.io.Serializable;

/** Aqui é a classe com as informações que serão entregues ao usuario
 *
 * Seto os dois jogadores, o Log da batalha e uma MensagemDto
 *
 * O atributo battleLog é apenas uma String onde eu vou armazenar todos os estados da batalha
 * cada chamada de setBattleLog que é feita na BatalhaService concatena Strings nesse atributo.
 * Então basicamente cada alteração eu pego o valor que já esta armazenado na battleLog e faço uma
 * concatenação com novas informações
 *
 * o atributo menssagem é o responsavel por mostrar/armazenar o personagem vencedor, o heroi vencedor
 * e o estado da batalha (finalizada/empatada)
 *
 */

public class BatalhaDto implements Serializable {


    private static final long serialVersionUID = 1L;

    private JogadorDto player;
    private JogadorDto oponente;
    private String battleLog;
    private MensagemDto menssagem;


    public JogadorDto getPlayer() {
        return player;
    }

    public void setPlayer(JogadorDto player) {
        this.player = player;
    }

    public JogadorDto getOponente() {
        return oponente;
    }

    public void setOponente(JogadorDto oponente) {
        this.oponente = oponente;
    }

    public String getBattleLog() {
        return battleLog;
    }

    public void setBattleLog(String battleLog) {
        this.battleLog = battleLog;
    }

    public MensagemDto getMensagem() {
        return menssagem;
    }

    public void setMensagem(MensagemDto mensagem) {
        this.menssagem = mensagem;
    }
}
