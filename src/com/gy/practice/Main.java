package com.gy.practice;

import java.util.*;

/**
 * Created by alex on 2017/4/6.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int lineNum = scanner.nextInt();
        int outNum = scanner.nextInt();
        Map<String,Line> result = new HashMap<>();
        for (int i = 0; i < lineNum; i++) {
            String type = scanner.next();
            int price = scanner.nextInt();
            int amount = scanner.nextInt();
            String key = type+price;
            Line  line = new Line(type,price,amount);
            if(result.containsKey(key)){
                Line line_ = result.get(key);
                line.setAmout(line.getAmout()+line_.getAmout());
            }
            result.put(key,line);
        }
        // ֱ�����map
        Set<String> keys = result.keySet();
        for (String key : keys) {
            System.out.println(result.get(key).toString());
        }
    }
}

class Line implements  Comparable<Line>{
    String type;
    int price;
    int amout;

    public Line(String type, int price, int amout) {
        this.type = type;
        this.price = price;
        this.amout = amout;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmout() {
        return amout;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }

    @Override
    public int compareTo(Line o) {
        if(amout<o.getAmout()){
            return -1;
        }
        if(amout>o.getAmout()){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return type+" "+price+" "+amout;
    }
}