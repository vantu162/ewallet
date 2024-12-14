package com.example.vimass_e_wallet.model.taiKhoan;

public class BankInfo {

    private double amount;
    private int status;
    private String bankName;
    private String nameBenefit;
    private String bankNumber;
    private String dsAmount;
    private String dsBankNumber;
    private String bankCode;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getNameBenefit() {
        return nameBenefit;
    }

    public void setNameBenefit(String nameBenefit) {
        this.nameBenefit = nameBenefit;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getDsAmount() {
        return dsAmount;
    }

    public void setDsAmount(String dsAmount) {
        this.dsAmount = dsAmount;
    }

    public String getDsBankNumber() {
        return dsBankNumber;
    }

    public void setDsBankNumber(String dsBankNumber) {
        this.dsBankNumber = dsBankNumber;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
}
