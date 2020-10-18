package model;

import javax.persistence.*;

/**
 * Created by omid on 10/9/2020.
 */
@Entity
@Table(name = "customeraccount")

public class CustomerAccount {
    @EmbeddedId
    private CustomerAccountPmk id;

    public CustomerAccountPmk getId() {
        return id;
    }

    public void setId(CustomerAccountPmk id) {
        this.id = id;
    }
}
