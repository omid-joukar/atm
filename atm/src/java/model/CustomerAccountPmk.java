package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by omid on 10/9/2020.
 */
@Embeddable
public class CustomerAccountPmk implements Serializable {
    private Integer customerId;
    private Integer accountId;
    @Column(name = "customerId")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    @Column(name = "accountId")
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public CustomerAccountPmk() {
    }

    public CustomerAccountPmk(Integer customerId, Integer accountId) {
        this.customerId = customerId;
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerAccountPmk that = (CustomerAccountPmk) o;

        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        return accountId != null ? accountId.equals(that.accountId) : that.accountId == null;
    }

    @Override
    public int hashCode() {
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        return result;
    }
}
