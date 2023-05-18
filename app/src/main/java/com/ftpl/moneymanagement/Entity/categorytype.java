package com.ftpl.moneymanagement.Entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "categorytype")
public class categorytype extends Model {
    @Column(name = "amount")
    private String amount;
    @Column(name = "category")
    private String category;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}


