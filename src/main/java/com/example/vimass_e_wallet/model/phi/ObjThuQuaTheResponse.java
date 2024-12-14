package com.example.vimass_e_wallet.model.phi;

import com.google.gson.Gson;

public class ObjThuQuaTheResponse {

    public int msgCode;
    public String msgContent;
    public double totalMoney;
    public double totalPhi;
    public double totalItem;

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }


}
