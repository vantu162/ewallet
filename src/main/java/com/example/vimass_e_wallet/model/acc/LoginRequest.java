package com.example.vimass_e_wallet.model.acc;

import com.google.gson.Gson;

public class LoginRequest {
    public String user;
    public String pass;
    public int deviceId;
    public String VimassMH;
    public String companyCode;
    public int type;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
