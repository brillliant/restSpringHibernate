package my.dao.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "cash_pair")
public class CashPair implements Serializable {

    @Id
    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;

    public CashPair() {
    }

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
