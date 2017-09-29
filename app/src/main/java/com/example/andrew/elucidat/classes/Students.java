package com.example.andrew.elucidat.classes;

/**
 * Created by andrew on 17/9/17.
 */

public class Students {
    String name,phno,state,nativelang;

    public  Students()
    {

    }
    public Students(String name,String phno,String state,String nativelang)
    {
        this.name   =name;
        this.phno=phno;
        this.state=state;
        this.nativelang=nativelang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNativelang() {
        return nativelang;
    }

    public void setNativelang(String nativelang) {
        this.nativelang = nativelang;
    }
}
