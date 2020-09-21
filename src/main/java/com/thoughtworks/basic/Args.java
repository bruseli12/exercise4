package com.thoughtworks.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Args {
    private String argsText;
    private List<Arg> argList = new ArrayList<Arg>();
    private Schema schema;

    public Args(String argsText, Schema schema) {
        this.argsText = argsText;
        this.schema = schema;
    }

    public void scan() {
        List<String> keyValues = Arrays.asList(argsText.split("-"));
        List<KeyValuePair> keyValuePairs = new ArrayList<KeyValuePair>();
        keyValues = keyValues.stream().map(String::trim).collect(Collectors.toList());
        keyValues = keyValues.subList(1, keyValues.size());

        keyValues.forEach(keyValue -> {
            String[] splitKeyValue = keyValue.split(" ");
            String key = splitKeyValue[0];
            String value=null;
            if (splitKeyValue.length > 1) {
                value = splitKeyValue[1];
            }
            keyValuePairs.add(new KeyValuePair(key, value));
        });
        keyValuePairs.forEach(keyValuePair -> {
            String flag = keyValuePair.getKey();
            String value = keyValuePair.getType();
            if (value == null) {
                value = schema.getDefaultValueOf(flag);
            }
            Object type = schema.getTypeofFlag(flag);
            argList.add(new Arg(flag, value, type));
        });

    }

    public String print() {
        StringBuffer stringBuffer = new StringBuffer();
        argList.forEach(arg -> stringBuffer.append(arg.parse() + " "));
        return  stringBuffer.toString();
    }
}