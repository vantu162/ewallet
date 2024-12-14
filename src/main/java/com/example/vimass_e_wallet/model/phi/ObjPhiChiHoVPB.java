package com.example.vimass_e_wallet.model.phi;

import com.google.gson.Gson;

public class ObjPhiChiHoVPB {
    public int soGDNoiBoVP;
    public int phiGDNoiBoVP;
    public int soGDLNH;
    public int phiGDLNH;
    public int soGD;
    public int phiGD;
    public int soGDHoan;
    public int phiGDHoan;
    public int soLanChayThucTe;

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
