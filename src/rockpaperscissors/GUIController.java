/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author pant9060
 */
public class GUIController implements Initializable {
    
    private String difficulty = "easy";
    @FXML
    private Label label, label1, label2, label3, label4, label5, label6, label7;
    
    @FXML
    private ImageView img, img2;
    
    mainClass game = new mainClass();
    //sets the picture to rock and puts rock in as the user input. checks if the game is easy
    //or hard in order to find the correct computer choice. the choices are then compared and the
    //winner is found as well as ties, losses and wins.
    @FXML
    private void handleRock(ActionEvent event) {
        img.setImage(new Image("resources/rock.jpg"));
        game.setUserChoice("Rock");
        if(difficulty.equals("easy")){
            label2.setText(game.computerChoiceEasy());
        }else{
            label2.setText(game.computerChoiceHard());
        }
        setImage(game.returnComputerChoice());
        label4.setText(game.findWinner());
        label5.setText(game.setTies());
        label6.setText(game.setWins());
        label7.setText(game.setLosses());
    }
    
    //sets the picture to paper and puts paper in as the user input. checks if the game is easy
    //or hard in order to find the correct computer choice. the choices are then compared and the
    //winner is found as well as ties, losses and wins.
    @FXML
    private void handlePaper(ActionEvent event) {
        img.setImage(new Image("resources/paper.png"));
        game.setUserChoice("Paper");
        if(difficulty.equals("easy")){
            label2.setText(game.computerChoiceEasy());
        }else{
            label2.setText(game.computerChoiceHard());
        }
        setImage(game.returnComputerChoice());
        label4.setText(game.findWinner());
        label5.setText(game.setTies());
        label6.setText(game.setWins());
        label7.setText(game.setLosses());
    }
    
    //sets the picture to scissors and puts scissors in as the user input. checks if the game is easy
    //or hard in order to find the correct computer choice. the choices are then compared and the
    //winner is found as well as ties, losses and wins.
    @FXML
    private void handleScissors(ActionEvent event) {
        img.setImage(new Image("resources/scissors.png"));
        game.setUserChoice("Scissors");
        if(difficulty.equals("easy")){
            label2.setText(game.computerChoiceEasy());
        }else{
            label2.setText(game.computerChoiceHard());
        }
        setImage(game.returnComputerChoice());
        label4.setText(game.findWinner());
        label5.setText(game.setTies());
        label6.setText(game.setWins());
        label7.setText(game.setLosses());
    }
    
    //sets difficulty to hard
    @FXML
    private void handleHard(ActionEvent event) {
        difficulty = "hard";
    }
    
    //resets the game by clearing the ties, wins and losses
    @FXML
    private void handleReset(ActionEvent event) {
        game.reset();
        label5.setText(game.setTies());
        label6.setText(game.setWins());
        label7.setText(game.setLosses());
    }
    
    //sets difficulty to easy
    @FXML
    private void handleEasy(ActionEvent event) {
        difficulty = "easy";
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //changes the copmuter choice image based on the computer choice
    private void setImage(String computerChoice){
        if(computerChoice.equals("Scissors")){
            img2.setImage(new Image("resources/scissors.png"));
        }
        if(computerChoice.equals("Paper")){
            img2.setImage(new Image("resources/paper.png"));
        }
        if(computerChoice.equals("Rock")){
            img2.setImage(new Image("resources/rock.jpg"));
        }
    }
}
