package com.gy.practice;

import java.util.*;

/**
 * Created by alex on 2017/4/6.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int lineNum = scanner.nextInt();
            int outNum = scanner.nextInt();
            Map<String, Line> result = new HashMap<>();
            for (int i = 0; i < lineNum; i++) {
                String type = scanner.next();
                int price = scanner.nextInt();
                int amount = scanner.nextInt();
                String key = type + price;
                Line line = new Line(type, price, amount);
                if (result.containsKey(key)) {
                    Line line_ = result.get(key);
                    line.setAmout(line.getAmout() + line_.getAmout());
                }
                result.put(key, line);
            }
            Set<String> keys = result.keySet();
            List<Line> list_S = new ArrayList<>();
            List<Line> list_B = new ArrayList<>();
            for (String key : keys) {
                Line line = result.get(key);
                if ("S".equals(line.getType())) {
                    list_S.add(line);
                } else {
                    list_B.add(line);
                }
            }
            Collections.sort(list_B);
            Collections.sort(list_S);
            for (int i = 0; i < outNum && i < list_S.size(); i++) {
                System.out.println(list_S.get(i));
            }
            for (int i = 0; i < outNum && i < list_B.size(); i++) {
                System.out.println(list_B.get(i));
            }
        }
    }

}

class Line implements Comparable<Line> {
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
        return o.price-this.price;
    }

    @Override
    public String toString() {
        return type + " " + price + " " + amout;
    }
}