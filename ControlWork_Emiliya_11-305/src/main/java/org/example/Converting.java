package org.example;

import java.util.ArrayList;

public class Converting {
    static String chanel = "";
    static BroadcastsTime time = null;

    public static ArrayList<Programm> convertAllPrograms(ArrayList<String> data) {
        ArrayList<Programm> allPrograms = new ArrayList<>();
        for (String program : data) {
            if (program.contains("#")){
                chanel = program.split("#")[1];
            }
            else if (program.contains(":") && (program.length() == 5)){
                time = new BroadcastsTime(Byte.parseByte(program.split(":")[0]), Byte.parseByte(program.split(":")[1]));
            }
            else {
                Programm p = new Programm(chanel, time, program);
                allPrograms.add(p);
            }
        }
        return allPrograms;
    }
}
