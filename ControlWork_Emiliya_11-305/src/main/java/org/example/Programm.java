package org.example;

import java.util.ArrayList;
import java.util.Comparator;

public class Programm {
    private String channel;
    private BroadcastsTime time;
    private String name;

    public Programm(String channel, BroadcastsTime time, String name){
        this.channel=channel;
        this.time = time;
        this.name=name;
    }

    public BroadcastsTime getTime() {
        return time;
    }

    public String getChannel() {
        return channel;
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Programm> SortByTime(ArrayList<Programm> programms){ //  программы в порядке возрастания времеи показа
        programms.sort(Comparator.comparing(Programm::getTime));
        return programms;
    }

    public static ArrayList<Programm> CurrentProgramms(ArrayList<Programm> programms, String time){ // нахождение текущих программ
        BroadcastsTime currentTime = new BroadcastsTime(time);
        ArrayList<Programm> currentProgramms = new ArrayList<>();
        for(Programm programm:programms){
            if(programm.getTime().compareTo(currentTime)==0){
                currentProgramms.add(programm);
            }
        }
        return currentProgramms;
    }

    public static ArrayList<Programm> getProgrammByName(ArrayList<Programm> programms, String name){ // нахождение программ по названию
        ArrayList<Programm> currentProgramms = new ArrayList<>();
        for(Programm programm:programms){
            if(programm.getName().equals(name)){
                currentProgramms.add(programm);
            }
        }
        return currentProgramms;

    }

    public static Programm CurrentProgrammOnChannel(ArrayList<Programm> programms, String channel, String time){ //  нахождение текущей программы по названию канала
        BroadcastsTime broadcastsTime = new BroadcastsTime(time);
        for (Programm programm : programms){
            if(programm.getName().equals(channel)){
                return programm;
            }
        }
        return null;

    }

    public static ArrayList<Programm> AllProgramBetween(ArrayList<Programm> programms, String time1, String time2, String channel){ //нахождение программ определенного канала  некоторого промежутка времени
        BroadcastsTime broadTime1 = new BroadcastsTime(time1);
        BroadcastsTime broadTime2 = new BroadcastsTime(time2);
        ArrayList<Programm> progBetween = new ArrayList<>();
        for (Programm program : programms) {
            if (program.getTime().between(broadTime1, broadTime2) && (program.getChannel().equals(channel))){
                progBetween.add(program);
            }

        }return progBetween;
    }

    @Override
    public String toString() {
        return "Program{" +
                "chanel='" + channel + '\'' +
                ", time=" + time +
                ", name='" + name + '\'' +
                "}"+"\n";
    }



}
