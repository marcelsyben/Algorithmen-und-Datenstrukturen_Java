package com.company;




public class PQElement<String> {


    private double priority;   /* Prioritaet ist eine ganze Zahl */

    /* weitere Daten ... */
    public String data;

    public PQElement (String val, double priority) {
        data = val;
        this.priority = priority;
    }



    public double priority () { return priority; }
    public void set_priority (double p) { priority = p; }

    public boolean is_lower(PQElement e) {
        return priority < e.priority;
    }
}
