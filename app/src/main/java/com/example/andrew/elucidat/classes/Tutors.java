package com.example.andrew.elucidat.classes;

/**
 * Created by andrew on 16/9/17.
 */

public class Tutors {
    String name,phnNo,state,nativeLanguage;


    public Tutors(){

    }

    public Tutors(String name, String phnNo, String state, String nativeLanguage) {
        this.name = name;
        this.phnNo = phnNo;
        this.state = state;
        this.nativeLanguage = nativeLanguage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhnNo() {
        return phnNo;
    }

    public void setPhnNo(String phnNo) {
        this.phnNo = phnNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(String nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }
}
