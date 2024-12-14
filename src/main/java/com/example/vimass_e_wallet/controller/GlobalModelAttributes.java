package com.example.vimass_e_wallet.controller;

import com.example.vimass_e_wallet.model.acc.AccountInfo;
import com.example.vimass_e_wallet.services.DataSystem;
import com.google.gson.Gson;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ControllerAdvice(assignableTypes = {IndexController.class, UserController.class})
public class GlobalModelAttributes {
    @ModelAttribute("accountInfo")
    public AccountInfo getUsername(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        AccountInfo accountInfo = new AccountInfo();
        if (session != null) {
            String acc = (String) session.getAttribute("acc"); // Lấy đối tượng Acc từ sess

            if(acc != null)
            {
                accountInfo= new Gson().fromJson(acc, AccountInfo.class);
                System.out.println("accountInfo: " + accountInfo.toString());
            }

        }

//
//        if(DataSystem.instance.accountInfo != null) {
//            acc = DataSystem.instance.accountInfo;
//        }
        return accountInfo;
    }
}
