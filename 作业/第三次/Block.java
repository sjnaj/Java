/**
 * @Author: fengsc
 * @Date: 2022-03-28 15:39:10
 * @LastEditTime: 2022-03-28 15:47:01
 */
import java.util.Scanner;
public class Block {
    int hour, minute, second;
    Block(int secondSummary){
        hour=secondSummary/3600;
        secondSummary%=3600;
        minute=secondSummary/60;
        secondSummary%=60;
        second=secondSummary;
    }
   public String toString(){
       return hour + ":" + minute + ":"+second;
   }
    public static void main(String[] args){
        int count;
        Scanner input = new Scanner(System.in);
        count=input.nextInt();
        int[] times= new int[count];
        for(int i=0; i<count; i++){
            times[i]=input.nextInt();
        }
        for(int time:times){
            System.out.println(new Block(time));
        }
    }
    
}