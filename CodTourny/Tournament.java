import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;

public class Tournament{

  private int playerCount;
  public String[] names;
  private ArrayList<Boolean> playerStatus;
  private ArrayList<Boolean> playerRoundStatus;

  public Tournament(int gameType){

    Scanner input = new Scanner(System.in);
    System.out.println("Enter Number of players (must be of 2^n for tiered tourny):");
    playerCount = input.nextInt();

    playerStatus = new ArrayList<Boolean>();
    playerRoundStatus = new ArrayList<Boolean>();

    if (gameType == 2 && (playerCount % 2 == 1)){
      names = new String[playerCount+1];
      names[playerCount] = "Empty";
    }
    else{
      names = new String[playerCount];

    }
    for (int i = 0; i < playerCount; i++) {
      System.out.println("Please enter player "+(i+1)+"'s name: ");
      names[i] = input.next();
      playerStatus.add(true);
      playerRoundStatus.add(true);
    }
    if (gameType == 2 && (playerCount % 2 == 1)){
      playerCount++;
    }
  }
  
  public int getPlayerCount(){
    return playerCount;
  }

  public String getName(int i){
    return names[i];
  }

  public void newTierRefresh(){
    for (int i = 0; i < playerCount; i++) {
      playerRoundStatus.set(i,true);
    }
  }

  public void printTier(){
    System.out.println( playerRoundStatus );
  }

  public void setPlayerRoundStatus(int p1, int p2){
    playerRoundStatus.set(p1,false);
    playerRoundStatus.set(p2,false);
  }


  public void setPlayerStatus(int winner, int liberal){
    playerStatus.set(winner,true);
    playerStatus.set(liberal,false);
  }

  public boolean getPlayerRoundStatus(int i){
    return playerRoundStatus.get(i);
  }

  public boolean getPlayerStatus(int i){
    return playerStatus.get(i);
  }

  public int getRemainingPlayers(){
    int numPlayersRemaining = 0;
    for (int i = 0; i < playerCount; i++){
      if (playerStatus.get(i) == true){
        numPlayersRemaining++;
      }
    }
    return numPlayersRemaining;
  }

}
