package com.example.vimass_e_wallet.model.phi;

import com.google.gson.Gson;

public class ObjBankDTO {
    public String gdNoiBo;
    public String phiNoiBo;
    public String soGDLNH;
    public String phiGDLNH;
    public String soGD;
    public String phiGD;
    public String soGDHoan;
    public String soLanChayThucTe;
    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
