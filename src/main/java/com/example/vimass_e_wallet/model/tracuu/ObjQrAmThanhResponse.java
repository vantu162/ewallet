package com.example.vimass_e_wallet.model.tracuu;

import com.example.vimass_e_wallet.model.acc.AccInfoQrAmThanh;

import java.util.List;

public class ObjQrAmThanhResponse {
    private AccInfoQrAmThanh accInf;

    private List<ItemQrAmThanh> list;

    public AccInfoQrAmThanh getAccInf() {
        return accInf;
    }

    public void setAccInf(AccInfoQrAmThanh accInf) {
        this.accInf = accInf;
    }

    public List<ItemQrAmThanh> getList() {
        return list;
    }

    public void setList(List<ItemQrAmThanh> list) {
        this.list = list;
    }


}
