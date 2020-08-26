/*
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
// for both
public class CreateSpreadsheet {

  public CreateSpreadsheet(int gameType) throws FileNotFoundException{

      FileOutputStream fos = new FileOutputStream("Cod_Tournament.csv",true);
      PrintWriter pw = new PrintWriter(fos);
      pw = null;

      if (gameType == 2){
        pw.println("MAP,Player1,Player2,P1_RoundWins,P2_RoundWins");
      }
      else{
        pw.println("Tier,Player1,Player2,Map,MapWinner");
      }
  }
// for round robin
  public void write(String mapName, String Player1, String Player2, int P1RoundWins, int P2RoundWins){
    pw.println(mapName,Player1,Player2,P1RoundWins,P2RoundWins);
  }

// for tiered
  public void write(int tier, String mapName, String Player1, String Player2, String mapWinner, String eliminated){
    pw.println(tier,mapName,Player1,Player2,mapWinner,eliminated);
  }

  public void closeSheet(){
    pw.close();
  }

}
*/
