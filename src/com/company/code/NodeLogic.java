package com.company.code;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static java.time.temporal.ChronoUnit.MINUTES;

public class NodeLogic {

    public Node getNodeFromString(String line) {
        if (isValid(line)) {
            return getObFromString(line);
        }

        return null;
    }

    private boolean isValid(String line) {

        if(line.trim()==""){
            return false;
        }
        String[] words = line.split(" ");

        if (words.length != 3) {
            return false;
        }
        if (!words[0].equals("Posh") && !words[0].equals("Grotty")) {
            return false;
        }

        for (int i = 1; i < 3; i++) {
            if (!isValidTime(words[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidTime(String time) {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime tTime = LocalTime.parse(time, formatter);
            return true;
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    private Node getObFromString(String line) {

        String[] words = line.split(" ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime depTime = LocalTime.parse(words[1], formatter);
        LocalTime arrTime = LocalTime.parse(words[2], formatter);

        return new Node(words[0], depTime, arrTime);
    }

    public boolean isValidTravelTime(Node ob){
        LocalTime depTime = ob.getDepTime();
        LocalTime arrTime = ob.getArrTime();

        if(depTime.getHour()==23&&arrTime.getHour()==0){
            if(depTime.getMinute()>=arrTime.getMinute()){
                return true;
            }else{
                return false;
            }
        }
        long minutes=depTime.until(arrTime,MINUTES);
        if(minutes<1||minutes>60){
            return false;
        }
        return true;
    }


}
