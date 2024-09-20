package org.example.game3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

public class Game3Controller {

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_6;

    @FXML
    private Button btn_7;

    @FXML
    private Button btn_8;

    @FXML
    private Button btn_9;

    @FXML
    private Label notice_lbl;

    @FXML
    private Button reset_btn;

    @FXML
    private Label result_lbl;

    private int button_number;

    private boolean win_checker (){
        String[][] gameBoard = {
                { btn_1.getText(),btn_2.getText(), btn_3.getText()},
                { btn_4.getText(),btn_5.getText(), btn_6.getText()},
                { btn_7.getText(),btn_8.getText(), btn_9.getText()}
        };
        for (int i = 0; i < 3; i++) {
            if(gameBoard[i][0].equals(gameBoard[i][1]) && gameBoard[i][1].equals(gameBoard[i][2]) && !gameBoard[i][0].isEmpty())return true;
            if(gameBoard[0][i].equals(gameBoard[1][i]) && gameBoard[1][i].equals(gameBoard[2][i]) && !gameBoard[0][i].isEmpty())return true;
        }
        if(gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2]) && !gameBoard[0][0].isEmpty())return true;
        if(gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][0]) && !gameBoard[0][2].isEmpty())return true;
        return false;
    }
    private boolean draw_checker(){
        return !btn_1.getText().isEmpty() &&!btn_2.getText().isEmpty() && !btn_3.getText().isEmpty() && !btn_4.getText().isEmpty() && !btn_5.getText().isEmpty() && !btn_6.getText().isEmpty() &&!btn_7.getText().isEmpty() &&!btn_8.getText().isEmpty() && !btn_9.getText().isEmpty();
    }

    private void button_disable(){
        btn_1.setDisable(true);
        btn_2.setDisable(true);
        btn_3.setDisable(true);
        btn_4.setDisable(true);
        btn_5.setDisable(true);
        btn_6.setDisable(true);
        btn_7.setDisable(true);
        btn_8.setDisable(true);
        btn_9.setDisable(true);
    }
    private void Result_Maker(String result){
        if (win_checker()){
            result_lbl.setText(result);
            button_disable();
        } else if (draw_checker()) {
            result_lbl.setText("Draw");
        }
    }

    //player Move
    private void  player_Move(Button button , int buttonNumebr){
        notice_lbl.setText("");
        if (button.getText().isEmpty()) {
            button.setText("X");
            button_number=buttonNumebr;
            Result_Maker("Win!!");
            if (result_lbl.getText().isEmpty()){
                computer_move();
            }
        }else {
            notice_lbl.setText("please choose a valid box");
        }

    }
    // random value generator
    private int random_value_genaretor (){
        Random random = new Random();
        int random_value;
        do {
            random_value = random.nextInt(9)+1;
        }while (random_value==button_number|| !Button_empty_checker(random_value));
            return random_value;
    }

    private boolean Button_empty_checker(int  button_number){
        switch (button_number){
            case 1 : return btn_1.getText().isEmpty();
            case 2 : return btn_2.getText().isEmpty();
            case 3 : return btn_3.getText().isEmpty();
            case 4 : return btn_4.getText().isEmpty();
            case 5 : return btn_5.getText().isEmpty();
            case 6 : return btn_6.getText().isEmpty();
            case 7 : return btn_7.getText().isEmpty();
            case 8 : return btn_8.getText().isEmpty();
            case 9 : return btn_9.getText().isEmpty();
            default: return false;

        }
    }



    //computer move
    private void computer_move(){
        int random_num = random_value_genaretor();
        switch (random_num){
            case 1:btn_1.setText("O");
            break;
            case 2:btn_2.setText("O");
                break;
            case 3:btn_3.setText("O");
                break;
            case 4:btn_4.setText("O");
                break;
            case 5:btn_5.setText("O");
                break;
            case 6:btn_6.setText("O");
                break;
            case 7:btn_7.setText("O");
                break;
            case 8:btn_8.setText("O");
                break;
            case 9:btn_9.setText("O");
                break;

        }
        Result_Maker("lose");
    }


    @FXML
    void btn_1_action(ActionEvent event) {
        player_Move(btn_1,1);
    }

    @FXML
    void btn_2_action(ActionEvent event) {
        player_Move(btn_2,2);
    }

    @FXML
    void btn_3_action(ActionEvent event) {
        player_Move(btn_3,3);
    }

    @FXML
    void btn_4_action(ActionEvent event) {
        player_Move(btn_4,4);
    }

    @FXML
    void btn_5_action(ActionEvent event) {
        player_Move(btn_5,5);
    }

    @FXML
    void btn_6_action(ActionEvent event) {
        player_Move(btn_6,6);
    }

    @FXML
    void btn_7_action(ActionEvent event) {
        player_Move(btn_7,7);
    }

    @FXML
    void btn_8_action(ActionEvent event) {
        player_Move(btn_8,8);
    }

    @FXML
    void btn_9_action(ActionEvent event) {
        player_Move(btn_9,9);
    }

    @FXML
    void reset_btn_action(ActionEvent event) {
        btn_1.setText("");
        btn_2.setText("");
        btn_3.setText("");
        btn_4.setText("");
        btn_5.setText("");
        btn_6.setText("");
        btn_7.setText("");
        btn_8.setText("");
        btn_9.setText("");

        btn_1.setDisable(false);
        btn_2.setDisable(false);
        btn_3.setDisable(false);
        btn_4.setDisable(false);
        btn_5.setDisable(false);
        btn_6.setDisable(false);
        btn_7.setDisable(false);
        btn_8.setDisable(false);
        btn_9.setDisable(false);

        result_lbl.setText("");
        notice_lbl.setText("");

        button_number=0;

    }

}
