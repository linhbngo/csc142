import java.util.Scanner;
import java.io.*;

public class ExtendedParseAwards {

  public static String[] stateListBR(String filename){
    String states = "";
    try {
      BufferedReader br = new BufferedReader(new FileReader(filename));      
      br.readLine();
      String current = null;
      while ((current = br.readLine()) != null) {
        String[] award = current.split("\",\"");
        if (!states.contains(award[7])){
          states += award[7] + " ";
        }
      }
      return states.split(" ");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }


  public static String[] stateList(String filename){
    String states = "";
    try {
      File awardFile = new File(filename);
      Scanner sc = new Scanner(awardFile);      
      sc.nextLine();
      while (sc.hasNextLine()) {
        String[] award = sc.nextLine().split("\",\"");
        if (!states.contains(award[7])){
          states += award[7] + " ";
        }
      }
      return states.split(" ");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void main(String[] args) {
    //String[] fundedStates = stateList("Awards_CISE_2019.csv");
    String[] fundedStates = stateListBR("Awards_CISE_2019.csv");
    for (int i = 0; i < fundedStates.length; i++) {
      System.out.println(fundedStates[i]);
    }
  }
}