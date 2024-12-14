package com.example.vimass_e_wallet.model.phi;

import com.google.gson.Gson;

public class BankDTORequest {

    public int funcId;
    public long timeFrom;
    public long timeTo;
    public int type;

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }

}
