package com.example.demo.play;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class GetMoney {
    public Random random=new Random();
    public List<Integer> arr=new ArrayList<Integer>();

    public static void main(String[] args) {
        GetMoney getMoney=new GetMoney();
        getMoney.getHappy();
    }

    public void getHappy(){
        for (int i=0;i<6;i++) {
            join(random.nextInt(33)+1);
        }
        System.out.println(arr.toString());
//        Arrays.toString()
        System.out.println(random.nextInt(16)+1);
    }

    public List join(int m){
        if (!arr.contains(m)){
            arr.add(m);
            return arr;
        }else {
            m = random.nextInt(33)+1;
            return join(m);
        }
    }
    @Test
    public void study(){
        //数组两种声明方式
  /*      String[] arr=new String[8];
        arr[0]="1";
        arr[1]="2";
        int[] arr1={1, 2 ,3};
        for (int i=0 ; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        for (int value: arr1){
            System.out.print(value+" ");
        }*/

        Date date=new Date();
        System.out.println(date);
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sf.format(date));

    }
}
