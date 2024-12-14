package com.example.vimass_e_wallet.model.donvi_model;

import com.example.vimass_e_wallet.tool.Func;
import com.google.gson.Gson;

public class ObjSaoKeViRequest_v1 {
    public String phone;
    public long fromDate;
    public long toDate;
    public int start;
    public int limit;
    public int type;
    public String idVimass;
    public String session;
    public int VMApp;
    public String checkSum;
    public String userLogin;
    public int VimassMH;
    public int ver;

    public String getCks(){
        String cks = Func.getMD5("9874397635976839" + this.phone + this.fromDate + this.toDate + this.limit);
        return  cks;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }

}
