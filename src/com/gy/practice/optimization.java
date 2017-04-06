package com.gy.practice;

import java.util.*;

/**
 * Created by alex on 2017/4/6.
 */
public class optimization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<CandyInfo> candyinfos = new ArrayList<>();
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int volume = scanner.nextInt();
            for (int i = 0; i < num; i++) {
                int v = scanner.nextInt();
                int capacity = scanner.nextInt();
                CandyInfo candyInfo = new CandyInfo(i, v, capacity);
                candyinfos.add(candyInfo);
            }
            Collections.sort(candyinfos);

            List<Integer> ids = new ArrayList<>();

            int cost=0;
            for (CandyInfo candyinfo : candyinfos) {
                if (candyinfo.getVolume() <= volume && volume >= 0) {
                    volume = volume - candyinfo.getVolume();
                    cost = cost+candyinfo.getCapacity();
                    ids.add(candyinfo.getId());
                }
            }
            System.out.println(cost);
            Collections.sort(ids);
            for (Integer id : ids) {
                System.out.print(id+" ");
            }
            System.out.println();

        }

    }


}

class CandyInfo implements Comparable<CandyInfo> {
    int id;
    int volume;
    int capacity;

    public CandyInfo(int id, int volume, int capacity) {
        this.id = id;
        this.volume = volume;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int compareTo(CandyInfo o) {
        return o.getCapacity() / o.getVolume() - this.getCapacity() / this.getVolume();
    }
}