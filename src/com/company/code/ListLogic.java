package com.company.code;

import java.time.LocalTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ListLogic {

    public void insertNode(Node ob, LinkedList<Node> list) {
        ExternalComparisonLogic logic = new ExternalComparisonLogic();

        int index = sameDepTimeInList(ob, list);
        if (index != -1) {
            int comparison = logic.externalTimeComp(list.get(index).getArrTime(),ob.getArrTime());
            if (comparison > 0) {
                insertion(ob, list, index);
                return;
            } else {
                if (comparison == 0){
                    if((list.get(index).getCompany().equals("Grotty") && (ob.getCompany().equals("Posh")))){
                        insertion(ob, list, index);
                    }
                    return;
                }


            }
        }
        index = sameArrTimeInList(ob, list);
        if (index != -1) {
            if(logic.externalTimeComp(list.get(index).getDepTime(),ob.getDepTime())<0){
                insertion(ob, list, index);
                return;
            }
        }
        index = startsLaterReachesEarlier(ob, list);
        if (index != -1) {
            insertion(ob, list, index);
            return;
        }

        list.add(ob);
    }

    private int sameDepTimeInList(Node compOb, LinkedList<Node> list) {
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getDepTime().equals(compOb.getDepTime())) {
                return i;
            }
        }
        return -1;
    }

    private int sameArrTimeInList(Node compOb, LinkedList<Node> list) {
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getArrTime().equals(compOb.getArrTime())) {
                return i;
            }
        }
        return -1;
    }

    private int startsLaterReachesEarlier(Node compOb, LinkedList<Node> list) {
        ExternalComparisonLogic logic = new ExternalComparisonLogic();
        for (int i = 0; i < list.size(); i++) {

            if (logic.externalTimeComp(list.get(i).getDepTime(),compOb.getDepTime()) < 0) {

                int comparison = logic.externalTimeComp(list.get(i).getArrTime(),compOb.getArrTime());
                switch (comparison) {
                    case 1 -> {
                        return i;
                    }
                    case -1 -> {
                        return -1;
                    }
                }
            }
        }
        return -1;
    }



    private void insertion(Node ob, LinkedList<Node> list, int indexToInsert) {
        list.remove(indexToInsert);
        list.add(ob);
    }

    public void sortList(LinkedList<Node> list){
        list.sort(new Comparator<Node>() {

            @Override
            public int compare(Node lhs, Node rhs) {
                // -1 - less than, 1 - greater than, 0 - equal
                if (lhs.getCompany().compareTo(rhs.getCompany()) > 0) {
                    return -1;
                }
                if (lhs.getCompany().compareTo(rhs.getCompany()) < 0) {
                    return 1;
                }
                ExternalComparisonLogic logic = new ExternalComparisonLogic();
                //return logic.externalTimeComp(lhs.getDepTime(),rhs.getDepTime());
                return  lhs.getDepTime().compareTo(rhs.getDepTime());
            }
        });
    }


}
