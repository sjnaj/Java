/**
 * @Author: fengsc
 * @Date: 2022-04-25 14:10:12
 * @LastEditTime: 2022-05-01 00:03:18
 */
import java.util.Scanner;
import java.util.Arrays;
public class Tabnine{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] commands=new String[input.nextInt()];
        for(int i=0; i<commands.length; i++){
            commands[i]=input.next();
        }
        Arrays.sort(commands);
        String command=input.next();
        for(String cmd : commands){
            if(cmd.startsWith(command)){
                System.out.println(cmd);
            }
        }
        input.close();
        
    }
}