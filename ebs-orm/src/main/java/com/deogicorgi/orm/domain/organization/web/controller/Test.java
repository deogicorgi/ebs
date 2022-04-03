package com.deogicorgi.orm.domain.organization.web.controller;

public class Test {

    public static void main(String args[]){
        System.out.println(solution(32));

    }


    public static int solution(int N) {
        // write your code in Java SE 8
        String num = "";

        int i = N;

        int max = 0;

        while(i >= 2) {
            if(i % 2 == 1) {
                num += "1";
            } else {
                num += "0";
            }
            i = i / 2;
        }

        String[] numArray =  num.split("1");
        System.out.println(num);
        for(String nums : numArray) {
            System.out.println(nums);
            if(nums.length() > max) {
                max = nums.length();
            }
        }

        return max;
    }
}
