package com.thoughtworks.basic;

public class FlagSchema {
    String flag;
    private final Object type;

    public FlagSchema(String flag, Object type) {
        this.flag = flag;
        this.type = type;
    }

    public Boolean equalsWith(String flag) {
        return flag.equalsIgnoreCase(this.flag);
    }

    public Object getType() {
        return type;
    }

    public String getDefaultValue() {
        if (this.type ==String.class) {
            return null;
        }
        if (this.type ==Integer.class) {
            return "0";
        }
        if (this.type ==Boolean.class) {
            return "true";
        }
        return null;
    }


}
