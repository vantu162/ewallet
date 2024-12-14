package com.example.vimass_e_wallet.model.acc;

import com.google.gson.Gson;

public class AccInfoQrAmThanh {

    public int funcId;
    public int timeRequest;
    public String maGiaoDich;
    public long timeCreate;
    public String viVimassSDT;
    public String bankCode;
    public String bankNumber;
    public String tenThuHuong;
    public String cks;
    public int trangThai;
    public String maNapTien;
    public String bankCodeMaNapTien;
    public String textQR;
    public double amo;
    public long timeFrom;
    public long timeTo;
    public int amountFrom;
    public int amountTo;
    public int offset;
    public int limit;
    public int typeSaoKe;
    public long timeCheck;

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }

}
