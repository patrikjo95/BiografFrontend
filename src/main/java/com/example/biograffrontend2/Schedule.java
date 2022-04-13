package com.example.biograffrontend2;

public class Schedule {

    private String a;
    private String b;
    private String c;
    private String d;

    public Schedule(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }

    public Schedule(String a, String b, String c, String d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }


    @Override
    public String toString() {
        return "Schedule2{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                '}';
    }
}
