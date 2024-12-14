package com.example.vimass_e_wallet.security;

import com.example.vimass_e_wallet.services.DataSystem;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                Authentication authentication) throws IOException {
        // Gán object thông tin người dùng đăng nhập thành null
        DataSystem.instance.accountInfo = null; // Gán đối tượng thành null

        // Đặt trạng thái HTTP thành 200 OK
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");

        // Trả về thông báo thành công
        response.getWriter().write("{\"status\":\"OK\"}");
        response.getWriter().flush();
    }
}