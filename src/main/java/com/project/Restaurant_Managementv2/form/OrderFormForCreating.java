package com.project.Restaurant_Managementv2.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderFormForCreating {

    private short UserId;

    private Date ordered;

    private String status;

    private BigDecimal total;


    public OrderFormForCreating(){
        super();
    }

    public Short getUserId() {
        return UserId;
    }

    public void setCustomerId(Short UserId) {
        this.UserId = UserId;
    }

    public Date getOrdered() {
        return ordered;
    }

    public void setOrdered(Date ordered) {
        this.ordered = ordered;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}
