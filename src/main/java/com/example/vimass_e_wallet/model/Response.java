package com.example.vimass_e_wallet.model;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class Response <T> implements Serializable {
    public int msgCode;
    public String msgContent;
    public String msgContent_en;
    public T result;
    public int tatol;
    public int ttatol2;
    public double tatolMoney;

    public int totalItem;


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
