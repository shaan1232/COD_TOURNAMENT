import java.util.Scanner;
import java.util.Random;

public class TieredTournament extends Tournament{

  //private int bestOf;
  private int nTiers;


  public TieredTournament(){
    super(1);

    int c = getPlayerCount();
    int nTiers =1 ;
    while (true){
      if (c/2 != 1){
        c = c/2;
        nTiers++;
      }
      else{
        break;
      }
    }
    setNumTiers(nTiers);

  }

  public void setNumTiers(int i){
    nTiers = i;
  }
  public int getTiers(){
    return nTiers;
  }


}
