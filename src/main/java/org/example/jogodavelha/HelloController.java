package org.example.jogodavelha;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class HelloController {
    @FXML
    private GridPane tabuleiro;
    @FXML
    private Label labelResultado;
    private Button[][] botaos = new Button[3][3];
    private String jogada;
    @FXML
    public void initialize() {
        jogada = "X";
        for (Node node : tabuleiro.getChildren()){
            if (node instanceof Button){
                Button b = (Button) node;
                Integer linha = GridPane.getRowIndex(b);
                Integer coluna = GridPane.getColumnIndex(b);
                if (linha == null){
                    linha = 0;
                }
                if (coluna == null){
                    coluna = 0;
                }
                botaos[linha][coluna] = b;
            }
        }
    }
    @FXML
    public void jogar(ActionEvent event) {
        int[] pos = qualOBotao(botaos, event);
        if (!ganhou()) {
            if (isVazia(botaos, pos)) {
                botaos[pos[0]][pos[1]].setText(jogada);
                alternarJogada();
            } else {
                labelResultado.setText("Posição já preenchida!");
            }
        }

    }
    public boolean ganhou(){

        for (int i = 0; i < botaos.length; i++){
            if (this.botaos[i][0].getText().equals(this.jogada) && this.botaos[i][1].getText().equals(this.jogada) && this.botaos[i][2].getText().equals(this.jogada)){
                return true;
            } else if (this.botaos[0][i].getText().equals(this.jogada) && this.botaos[1][0].getText().equals(this.jogada) && this.botaos[2][i].getText().equals(this.jogada)) {
                return true;
            }
        }
        if (this.botaos[0][0].getText().equals(this.jogada) && this.botaos[1][1].getText().equals(this.jogada) && this.botaos[2][2].getText().equals(this.jogada)){
            return true;
        }
        if (this.botaos[0][2].getText().equals(this.jogada) && this.botaos[1][1].getText().equals(this.jogada) && this.botaos[2][0].getText().equals(this.jogada)){
            return true;
        }
        return false;
    }
    public static boolean isVazia(Button[][] botoes,int[] pos){
        if (botoes[pos[0]][pos[1]].getText().equals("")){
            return true;
        }return false;
    }
    public void alternarJogada(){
        if (this.jogada.equals("X")){
            this.jogada = "O";
        }else if (this.jogada.equals("O")){
            this.jogada = "X";
        }
    }
    public int[] qualOBotao(Button[][] botaos, ActionEvent evento) {
        Button certo = (Button) evento.getSource();
        int[] posicao = new int[2];
        for (int i = 0; i < botaos.length; i++) {
            for (int j = 0;j < botaos.length; j++){
                if (botaos[i][j] == certo){
                    posicao[0] = i;
                    posicao[1] = j;
                }
            }
        }
        return posicao;
    }




}
