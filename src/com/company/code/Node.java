package com.company.code;

import java.time.LocalTime;
import java.util.Objects;

public class Node {
    private String company;
    private LocalTime depTime;
    private LocalTime arrTime;

    public Node(String company, LocalTime depTime, LocalTime arrTime) {
        this.company = company;
        this.depTime = depTime;
        this.arrTime = arrTime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalTime getDepTime() {
        return depTime;
    }

    public void setDepTime(LocalTime depTime) {
        this.depTime = depTime;
    }

    public LocalTime getArrTime() {
        return arrTime;
    }

    public void setArrTime(LocalTime arrTime) {
        this.arrTime = arrTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(company, node.company) && Objects.equals(depTime, node.depTime) && Objects.equals(arrTime, node.arrTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, depTime, arrTime);
    }

    @Override
    public String toString() {
        return "Node{" +
                "company='" + company + '\'' +
                ", depTime=" + depTime +
                ", arrTime=" + arrTime +
                '}';
    }
}
