package com.example.vimass_e_wallet.model.taiKhoan;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class BankInfoResponse {
    private double totalBank;
    private double totalWallet;
    private double totalWalletTheDaNang;
    private double c;
    private double totalWalletP2P;
    private int walletSum;
    private List<BankInfo> list;
    private int walletSumFull;
    private double totalMoneyTransaction;
    private int totalTransaction;
    private double totalFee;
    private double totalFeeInQuarter;
    private long tongTienTietKiemCoHieuLuc;
    private int tongSoTietKiemCoHieuLuc;
    private double soTienDaKhuyenMai;
    private double checkLechSoDu;

}
