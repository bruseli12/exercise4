package com.thoughtworks.basic;

public class Arg {
    String flag;
    String value;
    Object type;

    public Arg(String flag, String value, Object type) {
        this.flag = flag;
        this.value = value;
        this.type = type;
    }
    public  String parse(){
        return flag+" "+value+" "+type;
    }
}
