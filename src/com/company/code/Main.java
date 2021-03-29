package com.company.code;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        FileManipulations fileManipulations = new FileManipulations("input.txt");

        FileManipulationsLogic logic = new FileManipulationsLogic();
        LinkedList<Node> list = logic.getTimetableList(fileManipulations);

        logic.writeResultInFile(list,fileManipulations);
    }
}
