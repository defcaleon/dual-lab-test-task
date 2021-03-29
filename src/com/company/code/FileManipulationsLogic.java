package com.company.code;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;


public class FileManipulationsLogic {

    public LinkedList<Node> getTimetableList(FileManipulations ob) {

        LinkedList<Node> list = new LinkedList<>();

        try {
            BufferedReader reader = new BufferedReader(ob.getInpFileDescriptor());

            NodeLogic nodeLogic = new NodeLogic();
            ListLogic listLogic = new ListLogic();

            Node node;
            String line = reader.readLine();

            while (line != null) {

                node = nodeLogic.getNodeFromString(line);

                if (nodeLogic.isValidTravelTime(node)) {
                    listLogic.insertNode(node, list);
                }

                line = reader.readLine();
            }



            listLogic.sortList(list);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void writeResultInFile(LinkedList<Node> list, FileManipulations ob) {
        if (list == null || ob == null) {
            return;
        }

        boolean flag=true;
        View view = new View();

        try(FileWriter writer = ob.getOutFileDescriptor())
        {
            for (Node node : list) {

                if(flag&&node.getCompany().equals("Grotty")){
                    writer.append('\n');
                    flag=false;
                }

                writer.write(view.outNode(node));
            }

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }



        System.out.println("file overwritten successfully");
    }




}
