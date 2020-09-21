package com.thoughtworks.basic;

import java.util.Objects;

public class KeyValuePair {
    private final String key;
    private final String type;

    public KeyValuePair(String key, String type) {
        this.key = key;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyValuePair that = (KeyValuePair) o;
        return key.equals(that.key) &&
                type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, type);
    }

    public String getKey() {
        return key;
    }

    public String getType() {
        return type;
    }
}
