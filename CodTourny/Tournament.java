import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;

/*
We are gonna need each players current state for tiered, since if a player loses they are out of the tourny and the
winner goes on, so we need a boolean playercheck to go alongside each player name.

We can have a round status. start of every round every player is true in this variable, meaning they hadn't played yet.
we can use it to randomize all our matches.

Swap playerstatus and playerroundstatus to arraylists *********************

https://stackoverflow.com/questions/26471421/round-robin-algorithm-implementation-java HOW TO DO ROUND ROBIN
*/
public class Tournament{

  private int playerCount;
  public String[] names;
  //private boolean[] playerStatus;

  private ArrayList<Boolean> playerStatus;
  private ArrayList<Boolean> playerRoundStatus;

  //private boolean[] playerRoundStatus;

  public Tournament(int gameType){

    /*
    Variable definitions
    int playerCount: # of players participating in Tournament
    int tournament: tournament type. 1 for Tiered 2 for R-R
    */

    // input prompt: # of players

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

  //public void setName(int i){
  //  names[i] = "empty";
  //}

  public void newTierRefresh(){

    for (int i = 0; i < playerCount; i++) {
      playerRoundStatus.set(i,true);
    }
  }

  public void printTier(){
    System.out.println( playerRoundStatus );
  }

  public void setPlayerRoundStatus(int p1, int p2){
    //playerRoundStatus[p1] = false;
    playerRoundStatus.set(p1,false);
    //playerRoundStatus[p2] = false;
    playerRoundStatus.set(p2,false);
  }


  public void setPlayerStatus(int winner, int liberal){
    playerStatus.set(winner,true);
    //playerStatus[winner] = true;
    playerStatus.set(liberal,false);
    //playerStatus[liberal] = false;
  }

  public boolean getPlayerRoundStatus(int i){
    return playerRoundStatus.get(i);
  }

  public boolean getPlayerStatus(int i){
    return playerStatus.get(i);
    //return playerStatus[i];
  }

  public int getRemainingPlayers(){
    int numPlayersRemaining = 0;
    for (int i = 0; i < playerCount; i++){
    //  if (playerStatus[i] == true){
      if (playerStatus.get(i) == true){
        numPlayersRemaining++;
      }
    }
    return numPlayersRemaining;
  }

}
