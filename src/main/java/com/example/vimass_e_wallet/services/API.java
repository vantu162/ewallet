package com.example.vimass_e_wallet.services;

public class API {
    public static API instance;
    static { instance = new API();}
    private String domain =  "https://vimass.vn";
    public String login = domain + "/vmbank/services/account/loginVer2";

    public String saoke_bank = "http://" +"210.245.8.6:8080/vmNoiBo/services/admin/NHNNGetTransaction";

    public String url_saoKe_nhnn = "https://vimass.vn/VimassQR/services/QRSDT/requestCommand";

    public String url_saoKe_the= "http://210.245.8.6:8080/vmNoiBo/services/quanTriVID/requestCommand";

    public String url_saoKe_qr_amthanh = "https://vimass.vn/VimassQR/services/QRSDT/requestCommand";


    public  String SERVICE_TRACUU_THONGTIN_VDT = "http://210.245.8.6:8080/vmNoiBo/services/quanTriHeThong/requestCommand";

    public  String SERVICE_LIST_BANK = "http://210.245.8.6:8080/vmNoiBo/services/quanTriHeThong/layTSTK_04";

    public String chi_ho ="http://210.245.8.7:13316/vmNoiBo/services/quanTriHeThong/requestCommand";

    public String vpb_chi_ho ="http://210.245.8.7:12315/PVComBank/services/pvcb/thongKeGDTheoThoiGian";

    public String tong_gd_thu_chi = "http://210.245.8.6:8080/vmNoiBo/services/admin/NHNNGetTransaction";

    public String thu_qua_qr = "https://vimass.vn/VimassQR/services/VMQR/requestCommand";

    public String thu_qua_the ="http://210.245.8.6:8080/vmNoiBo/services/quanTriVID/requestCommand";

    public String quan_li_phi = "http://210.245.8.6:8080/vmNoiBo/services/quanTriHeThong/quanTriThuChiHo";


    public String thong_ke_gd_theo_gio_trong_ngay ="http://118.69.84.248:49465/vmthongke/services/api/taothongke";

    public String sao_ke_vi_dn = "http://210.245.8.6:8080/vmNoiBo/services/account/inquiry5";
    public String ds_vi_doanh_nghiep ="http://210.245.8.6:8080/vmNoiBo/services/quanTriHeThong/quanTriThuChiHo";

}
