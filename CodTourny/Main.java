import java.util.Scanner;
import java.util.Random;

public class Main{

  public static void main(String[] args){
    Random random = new Random();
    Scanner input = new Scanner(System.in);

    System.out.println("Choose Tournament Style: \n[1] for 'Tiered' [2] for 'Round-Robin':");
    int tournamentChoice = input.nextInt();
    int playersPerTier = 0;

    int p1 = 0;
    int p2 = 0;
    int roundCounter = 0;

    int winner;
    int loser;
    int rounds_won1;
    int rounds_won2;


    int breakableCheck = 0;




    if (tournamentChoice == 1){

      TieredTournament tournament = new TieredTournament();
      MapSelector map = new MapSelector(tournament.getTiers());

      for (int i = 0; i < tournament.getTiers(); i++){
        playersPerTier = tournament.getRemainingPlayers();
        tournament.newTierRefresh();

        for (int j = 0; j < (playersPerTier/2); j++){

          // making sure both players playing this round are valid :)
          while(true){
            p1 = random.nextInt(tournament.getPlayerCount());
            if (tournament.getPlayerStatus(p1) == true && tournament.getPlayerRoundStatus(p1) == true){
              break;
            }
          }
          while(true){
            p2 = random.nextInt(tournament.getPlayerCount());
            if (tournament.getPlayerStatus(p2) == true && tournament.getPlayerRoundStatus(p2) == true && p1 != p2){
              break;
            }
          }
          System.out.println("\nTier "+(i+1)+". Round "+(j+1));
          System.out.println(tournament.getName(p1)+" vs "+tournament.getName(p2));
          System.out.println("Map: \n\n"+map.getCurrentMap(i));
          System.out.println("Who won current map?\n[1] for "+tournament.getName(p1)+". [2] for "+tournament.getName(p2)+":");
          winner = input.nextInt();
          tournament.setPlayerRoundStatus( p1, p2);
          if (winner == 1){

            tournament.setPlayerStatus( p1, p2);

          }
          else{

            tournament.setPlayerStatus( p2, p1);

          }

          // get the map for the tier
        }
      }
      int counter = 0;
      while (tournament.getPlayerStatus(counter) != true){
        counter++;
      }
      System.out.println("Winner is "+tournament.getName(counter));




    }
    // RUN THE ROUND, GET THE INFO, THEN SWAP PLAYER POSITIONS AFTER!
    if (tournamentChoice == 2){
      RRobin_Tournament tournament = new RRobin_Tournament();

      MapSelector map = new MapSelector(tournament.RR_getTiers());

      for (int i = 0; i < tournament.RR_getTiers(); i++){
        if (i > 0){
          tournament.changeTier();
        }

        for (int j = 0; (j < tournament.getOddPlayerCount()/2); j++){

          // REMEMBER POSITION FOR p1 is J = i and P2 is J = i + getPlayerCount()/2

          p1 = j;
          p2 = j + (tournament.getPlayerCount())/2;
          if (!((tournament.getCurrentPlayer(p1).equals("Empty")) || (tournament.getCurrentPlayer(p2).equals("Empty")))){
            System.out.print("Round ["+roundCounter+"] |  ");
            System.out.println(tournament.getCurrentPlayer(p1)+" vs "+tournament.getCurrentPlayer(p2));
            System.out.println("Map: "+map.getCurrentMap(i));

            System.out.println("How many rounds did "+tournament.getCurrentPlayer(p1)+" win?: ");
            rounds_won1 = input.nextInt();
            tournament.roundsWin(tournament.getCurrentPlayer(p1),rounds_won1);
            System.out.println("How many rounds did "+tournament.getCurrentPlayer(p2)+" win?: ");
            rounds_won2 = input.nextInt();
            tournament.roundsWin(tournament.getCurrentPlayer(p2),rounds_won2);
            System.out.println("\n");
            if (rounds_won1 > rounds_won2){
              winner = 1;
            }
            else{
              winner = 2;
            }
            roundCounter++;
            tournament.matchWin(tournament.getCurrentPlayer(winner));


          }


        }
      }
      tournament.getWinners();
    }

  }
}
