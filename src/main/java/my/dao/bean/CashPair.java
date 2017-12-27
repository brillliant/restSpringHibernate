package my.dao.bean;

import java.io.Serializable;

public class CashPair implements Serializable {

    private String key;

    private String value;

    public CashPair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
