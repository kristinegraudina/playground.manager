package com.kgraudina.playground.manager.objects;

public class Visitor {

    private String name;
    private int age;
    private int ticketNumber;

    public Visitor(String name, int age, int ticketNumber) {
        this.name = name;
        this.age = age;
        this.ticketNumber = ticketNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ticketNumber=" + ticketNumber +
                '}';
    }
}
