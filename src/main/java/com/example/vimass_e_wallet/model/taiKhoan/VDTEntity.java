package com.example.vimass_e_wallet.model.taiKhoan;

import com.google.gson.Gson;

public class VDTEntity {

    private int tongSoVi;
    private int tongViKichHoat;
    private int tongViDangHoatDong;
    private double tongSoDuCacVi;
    private double tongSoDuCacViThuChiHo;

    public int getTongSoVi() {
        return tongSoVi;
    }

    public void setTongSoVi(int tongSoVi) {
        this.tongSoVi = tongSoVi;
    }

    public int getTongViKichHoat() {
        return tongViKichHoat;
    }

    public void setTongViKichHoat(int tongViKichHoat) {
        this.tongViKichHoat = tongViKichHoat;
    }

    public int getTongViDangHoatDong() {
        return tongViDangHoatDong;
    }

    public void setTongViDangHoatDong(int tongViDangHoatDong) {
        this.tongViDangHoatDong = tongViDangHoatDong;
    }

    public double getTongSoDuCacVi() {
        return tongSoDuCacVi;
    }

    public void setTongSoDuCacVi(double tongSoDuCacVi) {
        this.tongSoDuCacVi = tongSoDuCacVi;
    }

    public double getTongSoDuCacViThuChiHo() {
        return tongSoDuCacViThuChiHo;
    }

    public void setTongSoDuCacViThuChiHo(double tongSoDuCacViThuChiHo) {
        this.tongSoDuCacViThuChiHo = tongSoDuCacViThuChiHo;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
