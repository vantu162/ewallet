package com.example.vimass_e_wallet.services;


import com.example.vimass_e_wallet.model.acc.AccountInfo;
import com.example.vimass_e_wallet.model.taiKhoan.ObjTaiKhoanDamBaoMoi;

public class DataSystem {

    public static DataSystem instance;
    static {
        instance = new DataSystem();
    }

    public AccountInfo accountInfo;

    public ObjTaiKhoanDamBaoMoi objVPB;

    public double A4 = 0;
    public double A3 = 0;
    public double A1 = 0;
    public double A2 = 0;

    public double B2 = 0;
    public double B1 = 0;
}
