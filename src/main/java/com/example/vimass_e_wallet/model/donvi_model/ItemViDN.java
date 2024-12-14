package com.example.vimass_e_wallet.model.donvi_model;

import com.google.gson.Gson;

public class ItemViDN {

    public String soViVimass;
    public String tenChuVi;
    public String tenVietTat;

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
