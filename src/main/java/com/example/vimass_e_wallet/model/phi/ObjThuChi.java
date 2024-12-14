package com.example.vimass_e_wallet.model.phi;

import com.google.gson.Gson;

public class ObjThuChi {

    public String tongThu;
    public String tongChi;
    public String tongTienThu;
    public String tongTienChi;
    public String tongDoanhThu;
    public String chiNganHang;
    public String thuNet;

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
