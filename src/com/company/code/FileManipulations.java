package com.company.code;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class FileManipulations {
    private FileReader inpFileDescriptor;
    private FileWriter outFileDescriptor;
    private final String path = "src/com/company/files/";

    public FileManipulations(FileReader inpFileDescriptor, FileWriter outFileDescriptor) {
        this.inpFileDescriptor = inpFileDescriptor;
        this.outFileDescriptor = outFileDescriptor;
    }



    public FileManipulations(String inpFileName) {

        try {
            inpFileDescriptor = new FileReader(path + inpFileName);

            outFileDescriptor = new FileWriter(path + "output.txt", false);

        } catch (IOException ex) {
            closeConnections();
            System.out.println(ex.getMessage());
        }
    }

    public FileReader getInpFileDescriptor() {
        return inpFileDescriptor;
    }

    public void setInpFileDescriptor(FileReader inpFileDescriptor) {
        this.inpFileDescriptor = inpFileDescriptor;
    }

    public FileWriter getOutFileDescriptor() {
        return outFileDescriptor;
    }

    public void setOutFileDescriptor(FileWriter outFileDescriptor) {
        this.outFileDescriptor = outFileDescriptor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileManipulations that = (FileManipulations) o;
        return Objects.equals(inpFileDescriptor, that.inpFileDescriptor) && Objects.equals(outFileDescriptor, that.outFileDescriptor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inpFileDescriptor, outFileDescriptor, path);
    }

    @Override
    public String toString() {
        return "FileManipulations{" +
                "inpFileDescriptor=" + inpFileDescriptor +
                ", outFileDescriptor=" + outFileDescriptor +
                ", path='" + path + '\'' +
                '}';
    }

    public void closeConnections(){
        try {
            this.inpFileDescriptor.close();
            this.outFileDescriptor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void finalize ( ) {
        try {
            inpFileDescriptor.close();
            outFileDescriptor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
