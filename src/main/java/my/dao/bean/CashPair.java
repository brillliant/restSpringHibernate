package my.dao.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cash_pair")
public class CashPair implements Serializable {

    private static final long serialVersionUID = 20150602L;

    @Id
    private String name;

    private String value;

    public CashPair() {
    }

    public CashPair(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
