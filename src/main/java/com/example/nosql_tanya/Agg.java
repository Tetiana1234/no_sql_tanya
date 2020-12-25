package com.example.nosql_tanya;

import javax.persistence.Id;

public class Agg {

    @Id
    String id;

    Integer count;

    Double money;

    public Agg() {
    }

    public Agg(String id, Integer count) {
        this.id = id;
        this.count = count;
    }

    public Agg(String id, Double money) {
        this.id = id;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        String result="Agg{" + "id='" + id + '\'';
        if(count!=null){
            result+=", count=" + count;
        }
        if(money!=null){
            result+=", money=" + money;
        }
        result+='}';
        return result;
    }
}
