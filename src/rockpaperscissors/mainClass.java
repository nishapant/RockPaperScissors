/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.util.ArrayList;

/**
 *
 * @author pant9060
 */
public class mainClass{
    private String userChoice;
    private String computerChoice;
    private int wins;
    private int losses;
    private int ties;
    private int gamesPlayed=1;
    ArrayList<String> history = new ArrayList<>();
    ArrayList<String> current = new ArrayList<>();
    
    //populates the history array
    public mainClass(){
        populateArray();
    }
    
    //sets the input as the user choice and adds it to both arrays. if the size is greater than 5,
    //the first element is removed to keep the array at 5.
    public void setUserChoice(String input){
        userChoice = input;
        gamesPlayed+=1;
        history.add(userChoice);
        current.add(userChoice);
        
        if(current.size()>5){
            current.remove(0);
        }
    }
    
    //if less than 5 games have been played, the computer retuns a random choice. 
    //if 5 or more games have been played, the user returns a logical answer using the array.
    public String computerChoiceHard(){
        System.out.println("games played: "+(gamesPlayed));
        if((gamesPlayed)<6){
            computerChoiceEasy();
            return computerChoice;
        }else{
            findHardComputerChoice(findNextElement());
            return computerChoice;
        }
    }
    
    //returns a random choice
    public String computerChoiceEasy(){
        int computerNumber = (int)(Math.random()*3);
        switch (computerNumber) {
            case 0:
                computerChoice = "Rock";
                return "Rock";
            case 1:
                computerChoice = "Paper";
                return "Paper";
            default:
                computerChoice = "Scissors";
                return "Scissors";
        }
    }
    
    //checks all the cases of the user and computer choice and returns the winner
    public String findWinner(){
        if(userChoice.equals("Rock")&& computerChoice.equals("Paper")){
            losses +=1;
            return("Computer Wins!");
        }
        if(userChoice.equals("Rock")&& computerChoice.equals("Scissors")){
            wins+=1;
            return("Human Wins!");
        }
        if(userChoice.equals("Scissors")&& computerChoice.equals("Paper")){
            wins+=1;
            return("Human Wins!");
        }
        if(userChoice.equals("Scissors")&& computerChoice.equals("Rock")){
            losses +=1;
            return("Computer Wins!");
        }
        if(userChoice.equals("Paper")&& computerChoice.equals("Scissors")){
            losses +=1;
            return("Computer Wins!");
        }
        if(userChoice.equals("Paper")&& computerChoice.equals("Rock")){
            wins+=1;
            return("Human Wins!");
        }
        else{
            ties+=1;
            return("Tie!");
        }
    }
    
    //returns the ties
    public String setTies(){
        return "Ties: " + ties;
    }
    
     //returns the wins
    public String setWins(){
        return "Wins: " + wins;
    }
    
    //returns the losses
    public String setLosses(){
        return "Losses: " + losses;
    }
    
    //simulates actual human choices and stores it in the history array
    public void populateArray(){
        for(int i = 0; i<1000; i++){
            int computerNumber = (int)(Math.random()*3);
            switch (computerNumber) {
                case 0:
                    history.add("Rock");
                    break;
                case 1:
                    history.add("Scissors");
                    break;
                default:
                    history.add("Paper");
                    break;
            }
        } 
        
    }
    
    //using the guess of the human choice, the computer finds what would beat the human 
    //guess choice and uses that as the computer choice.
    public void findHardComputerChoice(String guessForUser){
        if(guessForUser.equals("Paper")){
            computerChoice="Scissors";
        }
        if(guessForUser.equals("Scissors")){
            computerChoice = "Rock";
        }else{
            computerChoice = "Paper";
        }
    }
    
    //checks if the user's array is anywhere in the computer array. if so, it will find the next element. if not,
    //the method will return a random choice
    public String findNextElement(){
        System.out.println(current);
        boolean check = false;
        int i;
        int j;
        for(j= 0; j< history.size()-5 && !check;j++){
            for(i=0; i<current.size(); i++){
                if(!(current.get(i).equals(history.get(j+i)))){
                    break;
                }
                
            }
            if(i == current.size()){
                check = true;
            }
        }
        if(check==false){
            return computerChoiceEasy();
        }else{
            return history.get(j+4);
        }
    }
    
    //returns the computer choice
    public String returnComputerChoice(){
        return computerChoice;
    }
    
    //clears the ties, wins and losses to reset game
    public void reset(){
        ties = 0;
        wins = 0;
        losses = 0;
    }
}
