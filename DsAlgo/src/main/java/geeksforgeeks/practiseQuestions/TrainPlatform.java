package geeksforgeeks.practiseQuestions;

public class TrainPlatform {

  public static void main(String[] args) {
    int n = 6;
    int [] arr = {900,940,950,1100,1500,1800};
    int [] dept ={910,1200,1120,1130,1900,2000};
    int emptyPlatform=0;
    int filledPlatform=1;
    int maxDep=dept[0];
    int maxPlatform=1;
    for(int i=0;i<n-1;i++) {
      if(emptyPlatform>0) {
        emptyPlatform--;
      }
      if(arr[i+1] <dept[i]) {
        if(emptyPlatform==0) {

          maxPlatform++;
        }
      } else {
        emptyPlatform++;
      }
    }
    System.out.println(maxPlatform);
    System.out.println(emptyPlatform);
    System.out.println(filledPlatform);
  }

}
