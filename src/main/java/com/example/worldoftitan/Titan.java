package com.example.worldoftitan;

import java.util.Random;

public class Titan implements Comparable<Titan> {
    private final String type;
    private int height;
    private int legs;
    private int speed;
    private String pattern;
    private boolean climb;
    private int risk;
    private final int index;
    private final int position;

    public Titan(String type, int index, int position) {
        this.type = type;
        this.index = index;
        this.position = position;
        generateValues();
        calculateRisk();
    }

    private void generateValues(){
        Random rand = new Random();
        if(type.equals("Normal")){
            height = rand.nextInt(31-5) + 5;
            legs = rand.nextInt(3) * 2;
            speed = rand.nextInt(31-1) + 1;
            int patternType = rand.nextInt(3);
            switch (patternType){
                case 0 -> pattern = "Normal Pattern";
                case 1 -> pattern = "Repeated Pattern";
                default -> pattern = "No Repeated Pattern";
            }
            int climbSkill = rand.nextInt(2);
            climb = (climbSkill == 0);
        }
        else if(type.equals("Abnormal")){
            height = rand.nextInt(31-20) + 20;
            legs = (rand.nextInt(3-1) + 1) * 2;
            speed = rand.nextInt(31-20) + 20;
            pattern = "No Repeated Pattern";
            climb = true;
        }
        else {
            height = rand.nextInt(40-25)+25;
            legs = (rand.nextInt(3-1) + 1) * 2;
            speed = rand.nextInt(40-25) + 25;
            pattern = "No Repeated Pattern";
            climb = true;
        }
    }

    private void calculateRisk(){
        if(type.equals("Normal")){
            //height
            if(height < 10) risk++;
            else if (height < 20) risk+=2;
            else risk+=3;

            //walking legs
            if(legs == 0) risk++;
            else if (legs == 2) risk+=2;
            else risk+=3;

            //running speed
            if(speed < 10) risk++;
            else if (speed < 20) risk+=2;
            else risk+=3;

            //walking pattern
            if(pattern.equals("Normal Pattern")) risk++;
            else if (pattern.equals("Repeated Normal")) risk+=2;
            else risk+=3;

            //climbing skill
            if(!climb) risk++;
            else risk+=3;
        }
        else if(type.equals("Abnormal")) risk = 15;
        else risk = 19;
    }

    public String getType() {
        return type;
    }

    public int getRisk() { return risk; }

    public int getPosition() {
        return position;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return  type + " Titan (" +
                height + "m, " +
                legs + " legs, " +
                speed + "ms, " +
                pattern + ", " +
                ((climb)?"Can climb) ":"Cannot climb) ") +
                "Risk: " + risk;
    }

    @Override
    public int compareTo(Titan titan) {
        return Integer.compare(titan.risk, this.risk);
    }

}
