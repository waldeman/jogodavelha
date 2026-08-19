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

    private Button[][] botaos = new Button[3][3];
    @FXML
    public void initialize() {
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
        botaos[pos[0]][pos[1]].setText("A");
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
