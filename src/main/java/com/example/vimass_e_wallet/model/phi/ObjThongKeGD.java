package com.example.vimass_e_wallet.model.phi;

import java.util.ArrayList;

public class ObjThongKeGD {

    public int id;
    public int idNgay;
    public int gio;
    public ArrayList<ListGiaoDich> listGiaoDich;
    public int trangThai;
    public long ngayTao;
    public long ngaySua;

    public class ListGiaoDich{
        public int typeTranfer;
        public int total;

        public int getTypeTranfer() {
            return typeTranfer;
        }

        public void setTypeTranfer(int typeTranfer) {
            this.typeTranfer = typeTranfer;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNgay() {
        return idNgay;
    }

    public void setIdNgay(int idNgay) {
        this.idNgay = idNgay;
    }

    public int getGio() {
        return gio;
    }

    public void setGio(int gio) {
        this.gio = gio;
    }

    public ArrayList<ListGiaoDich> getListGiaoDich() {
        return listGiaoDich;
    }

    public void setListGiaoDich(ArrayList<ListGiaoDich> listGiaoDich) {
        this.listGiaoDich = listGiaoDich;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Object getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(long ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Object getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(long ngaySua) {
        this.ngaySua = ngaySua;
    }
}
