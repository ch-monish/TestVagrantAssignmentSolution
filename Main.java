import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class Main {
    String Name;
 int Pts;
 int[] Last5;
 Main(String name,int pts,int[] last5){
    this.Name=name;
    this.Pts=pts;
    this.Last5=last5;

 }   
 //Generalize the same solution, so that we could get teams that have n consecutive losses/wins.
 //here n is noofconsecutive occurances win holds won or lose
 static void helper(ArrayList<Main> dataa,int n,int win){
   ArrayList<String> result=new ArrayList<String>();
   ArrayList<Float> avgpoints=new ArrayList<Float>();
   for(Main m:dataa){
      int count=1;
      int last=2;
      for(int i=0;i<m.Last5.length;i++){
         if(m.Last5[i]==win&&last==win){
            count++;
            last=win;
         }
         else last=m.Last5[i];
      }
      // System.out.println(count);
      if(count>=n){
         result.add(m.Name);
         int sum=0;
         //Calculate the average points of these filtered teams
         for(int i=0;i<m.Last5.length;i++){
            // System.out.print(m.Last5[i]);
            sum=sum+m.Last5[i];}
         // System.out.println(avgofpoints);
         avgpoints.add((float)sum/m.Last5.length);
      }
      
   }
   System.out.print(result);
   System.out.print(avgpoints);
   
}

    public static void main(String[] args) {

      ArrayList<Main> data = new ArrayList<Main>();
      // Main o = new Main("GT", 20, new int[]{1,1,0,0,1});
      data.add(new Main("GT", 20, new int[]{1,1,0,0,1}));
      data.add(new Main("LSG", 18, new int[]{1,0,0,1,1}));
      data.add(new Main("RR", 16, new int[]{1,0,1,0,0}));
      data.add(new Main("DC", 14, new int[]{1,1,0,1,0}));
      data.add(new Main("RCB", 14, new int[]{0,1,1,0,0}));
      data.add(new Main("KKR", 12, new int[]{0,1,1,0,1}));
      data.add(new Main("PBKS", 12, new int[]{0,1,0,1,0}));
      data.add(new Main("SRH", 12, new int[]{1,0,0,0,0}));
      data.add(new Main("CSK", 8, new int[]{0,0,1,0,1}));
      data.add(new Main("MI", 6, new int[]{0,1,0,1,1}));
      //solution for Programmatically retrieve the teams that have 2 consecutive losses.
     helper(data,2,0);
      
    }
  }
  