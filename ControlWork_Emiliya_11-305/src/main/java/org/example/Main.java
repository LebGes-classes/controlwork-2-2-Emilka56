package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> programs = Deserialization.deserialize("C:\\Users\\Home\\Desktop\\data.txt");
        ArrayList<Programm> allPrograms = Converting.convertAllPrograms(programs);

        ArrayList<Programm> sortedOfTimePrograms = Programm.SortByTime(allPrograms);
        System.out.println(allPrograms.toString());

        ArrayList<Programm> ProgramsInCurrentTime = Programm.CurrentProgramms(allPrograms, "00:00");
        System.out.println("Программы, которые идут сейчас");
        System.out.println(ProgramsInCurrentTime.toString());


        ArrayList<Programm> ProgramsByName = Programm.getProgrammByName(allPrograms,"Малыш и Карлсон");
        System.out.println(ProgramsByName.toString());

        Serialization writer = new Serialization(sortedOfTimePrograms, "программы.xlsx");
        Serialization.saveToExcel(sortedOfTimePrograms, "программы.xlsx");




    }
}