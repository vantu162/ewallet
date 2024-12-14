package com.example.vimass_e_wallet.model.phi;

import com.google.gson.Gson;

public class ObjPhiChiHoTPB {

    public int soGDNoiBo;
    public double phiGDNoiBo;
    public int soGDLNH;
    public double phiGDLNH;
    public int soGD;
    public double phiGD;
    public int soGDHoan;
    public int soLanChayThucTe;


    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
