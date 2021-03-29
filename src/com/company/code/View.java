package com.company.code;

import java.util.LinkedList;

public class View {

    public void showList(LinkedList<Node> list){
        for(Node node:list){
            System.out.println(node.toString());
        }
    }

    public String outNode(Node node) {
        return node.getCompany() + " " +
        node.getDepTime()+" "+node.getArrTime()+"\n";
    }
}
