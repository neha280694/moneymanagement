package com.ftpl.moneymanagement.Entity;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "income")

public class income extends Model {
    @Column(name = "date")
    private String date;
    @Column(name = "category")
    private String category;
    @Column(name = "amount")
    private String amount;
    @Column(name = "mode")
    private String mode;
    @Column(name = "expanded")
    private boolean  expanded;
    public income() {

       this.expanded = false;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}

