import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;

public class RRobin_Tournament extends Tournament{
  private ArrayList<String> listTop;
  private ArrayList<String> listBot;
  private boolean offRound;
  private int playerCount_Odd;

  private int[] points;
  int roundWinPoints;
  int mapWinPoints;

  public RRobin_Tournament(){
    super(2);
    
    // EDITABLE VARIABLES
    roundWinPoints = 2;
    mapWinPoints = 7;

    listTop = new ArrayList<String>();
    listBot = new ArrayList<String>();
    setOffRound();
    points = new int[getPlayerCount()];
    for (int i = 0; i < getPlayerCount(); i++){
      points[i] = 0;
    }
  }

  private void setOffRound(){
    String nameSave;
    if (getPlayerCount() % 2 == 1){
      offRound = true;
      playerCount_Odd = getPlayerCount()+1;

      for (int i = 0; i < (playerCount_Odd/2); i++){
        listTop.add(getName(i));
        //
        if (i != playerCount_Odd/2){
          listBot.add(getName(i+(playerCount_Odd/2)));
        }
        else{
          break;
        }
      }
    }
    else{
      playerCount_Odd = getPlayerCount();
      offRound = false;
      for (int i = 0; i < (getPlayerCount()/2); i++){
        nameSave = getName(i);
        listTop.add(nameSave);
        nameSave = getName(i+(getPlayerCount()/2));
        listBot.add(nameSave) ;
      }
    }
  }

  public int RR_getTiers(){
    if (getPlayerCount() % 2 == 1){
      return getPlayerCount();
    }
    else{
      return getPlayerCount()-1;
    }
  }
  
  public int getPoints(int i){
    return points[i];
  }

  public void matchWin(String checkName){
    for (int i = 0; i < getPlayerCount(); i++){
      if (checkName.equals(getName(i))){
        points[i] += mapWinPoints;
        break;
      }
    }
  }

  public void roundsWin(String checkName, int roundsWon){
    for (int i = 0; i < getPlayerCount(); i++){
      if (checkName.equals(getName(i))){
        points[i] += (roundWinPoints*roundsWon);
        break;
      }
    }
  }

  public void getWinners(){
    int highestPointsI = 0;
    int highestPoints = 0;
    System.out.println("\n\nFINAL SCORES:");
    for (int i = 0; i < getPlayerCount(); i++){
      if (!(getName(i).equals("Empty"))){
        System.out.println(getName(i)+" got "+points[i]+" points");
      }
      if (points[i] >= highestPoints){
        highestPointsI = i;
        highestPoints = points[i];
      }
    }
    System.out.println("The winner is: "+getName(highestPointsI)+"!");
  }

  public String getCurrentPlayer(int i){
    if (i < playerCount_Odd/2){
      return listTop.get(i);
    }
    else{
      return listBot.get(i-(playerCount_Odd/2));
    }
  }

  public int getOddPlayerCount(){
    return playerCount_Odd;
  }

  public void changeTier(){
    ArrayList<String> listTopCopy = new ArrayList(listTop);
    ArrayList<String> listBotCopy = new ArrayList(listBot);
    String copy1;
    String copy2;
    for (int i = 0; i < playerCount_Odd/2; i++){
      // LEFT
      if (i == 0){
        copy2 = listBotCopy.get(i+1);
        listBot.set(i,copy2);
      }
      // i = 1
      if ( i == 1 && playerCount_Odd > 4){
        copy1 = listBotCopy.get(i-1);
        copy2 = listBotCopy.get(i+1);
        listTop.set(i,copy1);
        listBot.set(i,copy2);
      }
      // MIDDLE
      if ( i > 1 && (i < (playerCount_Odd/2)-1) && playerCount_Odd > 4){
        copy1 = listTopCopy.get(i-1);
        copy2 = listBotCopy.get(i+1);
        listTop.set(i,copy1);
        listBot.set(i,copy2);
      }
      // RIGHT
      if (i == ((playerCount_Odd/2)-1) && playerCount_Odd > 4){
        copy1 = listTopCopy.get(i-1);
        copy2 = listTopCopy.get(i);
        listTop.set(i,copy1);
        listBot.set(i,copy2);
      }
      // RIGHT CUBE SHAPE < 4 PLAYERS
      if (i == 1 && playerCount_Odd <= 4){
        copy1 = listBotCopy.get(0);
        copy2 = listTopCopy.get(1);
        listTop.set(i,copy1);
        listBot.set(i,copy2);
      }
    }
  }
}
