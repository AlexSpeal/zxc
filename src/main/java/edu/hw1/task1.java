package edu.hw1;

import java.util.Scanner;

public class task1 {
    public static Boolean check(String str){
        boolean result=true;
        boolean flag=false;
        int length=str.length();
        String check_min=str.substring(str.indexOf(':')+1,length);
        String check_sec=str.substring(0,str.indexOf(':'));
        if (check_sec.length()<2 ||check_min.length()!=2) {
            result=false;
        }

        for(int i=0; i<length && result;++i){
            if((str.charAt(i) == ':' ) & (!flag)){
                flag=true;
            }
            else if((str.charAt(i) < '0')||(str.charAt(i)>'9')){
                result=false;
            }
        }
        return (result && flag && (str.charAt(0)!=':'));
    }
    public static int Minut_to_Seconds(String time){
        int result;
        if(!check(time)){
            result=-1;
        }
        else{
            int to_colon=time.indexOf(':');
            int minut=Integer.parseInt(time.substring(0,to_colon));
            int seconds=Integer.parseInt(time.substring(to_colon+1));
            if(seconds<60 && seconds>=0 && minut>=0){
                result=minut*60+seconds;
            }
            else{
                result=-1;
            }
        }
        return result;
    }
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        System.out.print("Input a time: ");
        String time=cin.nextLine();
        System.out.print(Minut_to_Seconds(time));
        cin.close();
    }
}
