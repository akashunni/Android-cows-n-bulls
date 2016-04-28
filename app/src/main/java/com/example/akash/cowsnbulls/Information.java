package com.example.akash.cowsnbulls;

/**
 * Created by akash on 19/9/15.
 */
public class Information {
    int chance_info;
    int cows_info;
    int bulls_info;
    String answer;
    Information(int chance_info,int cows_info,int bulls_info,String answer){
        this.setChance_info(chance_info);
        this.setCows_info(cows_info);
        this.setBulls_info(bulls_info);
        this.setAnswer(answer);
    }
    String getAnswer(){
        return answer;
    }
    int getChance_info(){
        return chance_info;
    }
    int getCows_info(){
        return cows_info;
    }
    int getBulls_info(){
        return bulls_info;
    }
    void setAnswer(String answer){
        this.answer = answer;
    }
    void setChance_info(int chance){
        this.chance_info = chance;
    }
    void setCows_info(int cows){
        this.cows_info = cows;
    }
    void setBulls_info(int bulls){
        this.bulls_info = bulls;
    }
}
