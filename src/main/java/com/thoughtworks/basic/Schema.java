package com.thoughtworks.basic;

import java.util.Set;

public class Schema {
    Set<FlagSchema> flagSchemaSet;

    public Schema(Set<FlagSchema> flagSchemaSet) {
        this.flagSchemaSet = flagSchemaSet;
    }

    public Object getTypeofFlag(String flag) {
        return flagSchemaSet.stream()
                .filter(flagSchema -> flagSchema.equalsWith(flag))
                .findFirst()
                .get()
                .getType();
    }
    public String getDefaultValueOf(String flag) {
        return flagSchemaSet.stream()
                .filter(flagSchema -> flagSchema.equalsWith(flag))
                .findFirst()
                .get()
                .getDefaultValue();
    }
}
