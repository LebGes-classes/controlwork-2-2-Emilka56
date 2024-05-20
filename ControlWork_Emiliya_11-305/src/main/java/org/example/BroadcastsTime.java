package org.example;

public class BroadcastsTime implements  Comparable<BroadcastsTime> {
    private byte hour;
    private byte minutes;
    public BroadcastsTime(){
        this.hour=hour;
        this.minutes=minutes;

    }

    public BroadcastsTime(byte hour, byte minute) {
        this.hour = hour;
        this.minutes = minute;
    }
    public byte minuts(){return minutes;}
    public byte hours (){return hour;}

    BroadcastsTime(String time){ //для добавления программы
        String[] curTime = time.split(":");
        this.hour = Byte.parseByte(curTime[0]);
        this.minutes = Byte.parseByte(curTime[1]);
    }


    boolean after (BroadcastsTime t){return this.compareTo(t)>=0;} //если программа начинается позже или в то же время выдаст 1 - true

    boolean before(BroadcastsTime t){return this.compareTo(t)<=0;} //если программа начинается раньше или в то же время выдаст -1 - true
    boolean between(BroadcastsTime t1, BroadcastsTime t2){return (!before(t1)&&(!after(t2)));}

    @Override
    public int compareTo(BroadcastsTime time2) {
        if(this.hour!=time2.hour){
            return Byte.compare(this.hour, time2.hour);
        } else{
            return Byte.compare(this.minutes, time2.minutes);
        }
    }

    @Override
    public String toString() {
        return hour + ":" + minutes;
    }

}
