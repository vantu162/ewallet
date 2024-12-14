package com.example.vimass_e_wallet.controller;

import com.example.vimass_e_wallet.LocaleConfig;
import com.example.vimass_e_wallet.html.GenHTML;
import com.example.vimass_e_wallet.html.GenHTML_TaiKhoan;
import com.example.vimass_e_wallet.model.Response;
import com.example.vimass_e_wallet.model.acc.AccountInfo;
import com.example.vimass_e_wallet.model.taiKhoan.BankInfoResponse;
import com.example.vimass_e_wallet.model.taiKhoan.ObjTraCuuThongTinVdtRequest;
import com.example.vimass_e_wallet.model.taiKhoan.VDTEntity;
import com.example.vimass_e_wallet.model.tracuu.ItemCards;
import com.example.vimass_e_wallet.model.tracuu.ObjSaoKeNHNNRequest;
import com.example.vimass_e_wallet.model.tracuu.ObjSaoKeNHNNResponse;
import com.example.vimass_e_wallet.model.tracuu.ObjSaokeTheRequest;
import com.example.vimass_e_wallet.services.CallServices;
import com.example.vimass_e_wallet.services.CallServices_TaiKhoan;
import com.example.vimass_e_wallet.services.DataSystem;
import com.example.vimass_e_wallet.tool.Func;
import com.example.vimass_e_wallet.tool.GetValue;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.util.*;

@Controller
public class IndexController {
    private final LocaleConfig localeResolver;

    public IndexController(LocaleConfig localeResolver) {
        this.localeResolver = localeResolver;
    }

    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/acc")
    public String greeting1(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if(session != null){
            String acc = (String) session.getAttribute("acc"); // Lấy đối tượng Acc từ sess

            System.out.println("Phiên hiện tại đã tồn tại acc: " + acc);
            if(acc == null)
            {
                session.invalidate(); // Xóa session
                System.out.println("Phiên hiện tại đã tồn tại  acc 1: " + acc);
            }else{
                return "redirect:/quantri";
            }

        }

        return "Account/loginV1";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/aa")
    public String testAdmin(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            // Người dùng đã xác thực
            System.out.println("Người dùng đã xác thực aa: " + authentication.getAuthorities());
        } else {
            // Người dùng chưa xác thực
            System.out.println("Người dùng chưa xác thực aa: " + authentication.getAuthorities());
        }
        return "admin";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/bb")
    public String testUser(){
        return "user";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/quantri")
    public String pageAdmin(Model model, HttpServletRequest request) {

        HttpSession session =  request.getSession(false);

        if (session != null) {

            String acc = (String) session.getAttribute("acc");
            DataSystem.instance.accountInfo = new Gson().fromJson(acc, AccountInfo.class);

            model.addAttribute("username",DataSystem.instance.accountInfo );
            boolean isLoggedIn = checkLoginStatus();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            model.addAttribute("loginSuccess", isLoggedIn);
            model.addAttribute("authorities", authentication.getAuthorities());

            return "admin/admin_index";
        }

        return "redirect:/acc";
    }


    @GetMapping("/index")
    public String greetingv2(Model model, HttpServletRequest request) {
        // Lấy thông tin từ session
        HttpSession session =  request.getSession(false);
        String acc = (String) session.getAttribute("acc"); // Lấy đối tượng Acc từ sess
        // Kiểm tra xem session có còn hiệu lực không
        if (session != null && acc != null) {

//            DataSystem.instance.accountInfo = acc;
            System.out.println("Phiên hiện tại đã tồn tại." + acc);
            DataSystem.instance.accountInfo = new Gson().fromJson(acc, AccountInfo.class);

            model.addAttribute("username","" );
            boolean isLoggedIn = checkLoginStatus();

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated()) {
                // Người dùng đã xác thực
                System.out.println("Người dùng đã xác thực: " + authentication.getAuthorities());
            } else {
                // Người dùng chưa xác thực
                System.out.println("Người dùng chưa xác thực: " + authentication.getAuthorities());
            }

            model.addAttribute("loginSuccess", isLoggedIn);
            model.addAttribute("authorities", authentication.getAuthorities());
//

            return "index";
        } else {
              System.out.println("Đây là một phiên mới.");
        }

        return "redirect:/acc";
//        return "index";
    }

//    @RequestMapping("/{lang}/")
    public String greeting(@PathVariable("lang") String lang, HttpServletRequest request, HttpServletResponse response, Model model) {

        boolean isLoggedIn = checkLoginStatus(); // true nếu đã đăng nhập, false nếu chưa
        ObjSaoKeNHNNResponse objSaoKeNHNNResponse = null;
        String htmlTrans = "";
        String strTongGD ="";
        String strTongTien ="";
        String strPhi ="";
        int tatolItem = 0;
        if(isLoggedIn){
            ObjSaoKeNHNNRequest obj = GetValue.instance.getValueObjSaoKeNHNNRequest_V1();
            Response res= CallServices.instance.getSaoKeNHNN(obj);
            System.out.println("res ======> " + res.toString());
            objSaoKeNHNNResponse = new Gson().fromJson(new Gson().toJson(res.getResult()), ObjSaoKeNHNNResponse.class);
            tatolItem = objSaoKeNHNNResponse.total;
            htmlTrans = GenHTML.instance.genHtmlListTrans(objSaoKeNHNNResponse.dsHienThi);

            strTongGD =  Func.instance.getVNDFormat(objSaoKeNHNNResponse.total);
            strTongTien =  Func.instance.getVNDFormat(objSaoKeNHNNResponse.totalMoney);
            strPhi =  Func.instance.getVNDFormat(objSaoKeNHNNResponse.totalFee);
        }
        model.addAttribute("loginSuccess", isLoggedIn);
        model.addAttribute("htmlTrans", htmlTrans);
        model.addAttribute("tatolItem", tatolItem);

        model.addAttribute("tatolGD",strTongGD);
        model.addAttribute("tatolTien",strTongTien);
        model.addAttribute("tatolPhi", strPhi);

        // Thay đổi ngôn ngữ dựa trên giá trị trong URL
        Locale locale = new Locale(lang);
        localeResolver.localeResolver().setLocale(request, response, locale);
        return "index";
    }

    private boolean checkLoginStatus() {
        if(DataSystem.instance.accountInfo != null ) {
            return true;
        }
        return false;
    }

    @PostMapping("/login")
    @ResponseBody
    public String resLogin1(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        System.out.println("response login nhay vao day "  +username+"___"+password);
        Response response = CallServices.instance.postLoginV1(username, password);
        System.out.println("response login: " +response.toString());

        String url ="/saokeqr";
        String role ="ROLE_USER";

        if (response.msgCode == 1) {

            AccountInfo accountInfo = new Gson().fromJson(new Gson().toJson(response.getResult()), AccountInfo.class);
            if("0981455707".equals(username)){
                role = "ROLE_ADMIN";
                url = "/quantri";
            }

            // Thiết lập quyền cho người dùng (ví dụ: "ROLE_ADMIN")
//            List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(role));
            List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(role));

            // Tạo UsernamePasswordAuthenticationToken
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(username, null, authorities);

            // Đặt Authentication vào SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);

            SecurityContext context = SecurityContextHolder.getContext();

            HttpSession session = request.getSession(true); // Tạo hoặc lấy session hiện tại
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, context);


            // Lưu đối tượng acc vào session
            session.setAttribute("acc", accountInfo.toString()); // Lưu đối tượng Acc vào session

            System.out.println("Người dùng đã xác thực login: " + authentication.getAuthorities());

            return "OK"+"___"+url;
        } else {
            return "Invalid username and password.";
        }
    }

    @GetMapping("/transaction")
    @ResponseBody
    public String resTransaction(@RequestParam int typeE,@RequestParam int typeTran,
                                 @RequestParam int offset,@RequestParam int limit,
                                 @RequestParam int amountFrom, @RequestParam int amountTo,
                                 @RequestParam String timeFrom, @RequestParam String timeTo) {
        String htmlTrans ="";
        String tatolItem = "";
        AccountInfo acc = new AccountInfo();
        if(DataSystem.instance.accountInfo != null) {
            acc = DataSystem.instance.accountInfo;
        }
        if(typeE == 1){
            ObjSaoKeNHNNRequest obj = GetValue.instance.getValueObjSaoKeNHNNRequest(acc, offset, limit, timeFrom,timeTo , amountFrom, amountTo, typeTran, typeE);
//            System.out.println("ObjSaoKeNHNNRequest input ======> " + obj.toString());

            Response res= CallServices.instance.getSaoKeNHNN(obj);
            ObjSaoKeNHNNResponse objSaoKeNHNNResponse = new Gson().fromJson(new Gson().toJson(res.getResult()), ObjSaoKeNHNNResponse.class);

            htmlTrans += GenHTML.instance.genHtmlListTrans(objSaoKeNHNNResponse.dsHienThi);
            tatolItem = String.valueOf(objSaoKeNHNNResponse.total);

        }else if(typeE == 2){
            ObjSaokeTheRequest objSaokeTheRequest = GetValue.instance.getValueObjSaokeTheRequest(acc, offset, limit, timeFrom,timeTo, typeTran);

            Response res= CallServices.instance.postSaoKeThe(objSaokeTheRequest);

            Type collectionType_sk = new TypeToken<List<ItemCards>>(){}.getType();
            ArrayList<ItemCards> dsSaoKeThe  = new Gson().fromJson(new Gson().toJson(res.getResult()), collectionType_sk);

//            System.out.println("sao ke the res: " + dsSaoKeThe);
            htmlTrans += GenHTML.instance.genHtmlListTransCard(dsSaoKeThe);
            tatolItem = String.valueOf(res.totalItem);
        }
        // Trả về JSON cho jQuery
        return tatolItem + "___" + htmlTrans;
    }

    @GetMapping("/a")
    @ResponseBody
    public String resTaiKhoan() {
        String html ="";
        String tongViCoTien = "0";
        String tongTienCacVi = "0";
        String tongTienViThuChiHo = "0";
        AccountInfo acc = new AccountInfo();
        if(DataSystem.instance.accountInfo != null) {
            acc = DataSystem.instance.accountInfo;
        }
        ObjTraCuuThongTinVdtRequest obj = GetValue.instance.getObjTraCuuThongTinVdtRequest(10, acc.secssion, acc.phone, "fkjskldfadafa");
            System.out.println("ObjSaoKeNHNNRequest input ======> " + obj.toString());
        Response res= CallServices_TaiKhoan.instance.postTraCuuThongTinVDT(obj);

        if(res!=null)
        {
            if(res.getMsgCode()==1)
            {
                VDTEntity entity = new Gson().fromJson(new Gson().toJson(res.getResult()),VDTEntity.class);
                tongViCoTien = Func.getVNDFormat(entity.getTongViKichHoat());
                tongTienCacVi = Func.getVNDFormat(entity.getTongSoDuCacVi());
                tongTienViThuChiHo = Func.getVNDFormat(entity.getTongSoDuCacViThuChiHo());
                DataSystem.instance.B2 = entity.getTongSoDuCacViThuChiHo();
                DataSystem.instance.B1 = entity.getTongSoDuCacVi();
            }
        }

            String htmlTaiKhoanDamBaoVDT = GenHTML_TaiKhoan.instance.layDanhSachTaiKhoanDamBao(acc.phone,acc.secssion,tongViCoTien,tongTienCacVi);
            String htmlTaiKhoanDamBaoThuChiHo = GenHTML_TaiKhoan.instance.layDanhSachTaiKhoanThuChiHo(acc.phone,acc.secssion,tongViCoTien);
            String htmlTaiKhoanDamBaoCTT = GenHTML_TaiKhoan.instance.layDanhSachTaiKhoanDamBao_CTT(acc.phone,acc.secssion);
            String htmlTaiKhoanCaNhan = GenHTML_TaiKhoan.instance.layDanhSachTaiKhoanCaNhan(acc.phone,acc.secssion);

            String htmlTamUng = "";
//            if(Utility.CTViMass(user)||Utility.PTViMass(user)||user.equals("01677249552")|| user.equals("0377249552"))
//            {
//                htmlTamUng = laySoLieuTamUng();
//            }
//
        double  A1A2A3A4 =  DataSystem.instance.A1 +  DataSystem.instance.A2 +  DataSystem.instance.A3 +  DataSystem.instance.A4;
//
        double B1B2 =  DataSystem.instance.B1 +  DataSystem.instance.B2;
            String thoiGianTraCuu = Func.convertLongTimeFull(new Date().getTime());
//
            String htmlChenhLech = GenHTML_TaiKhoan.instance.genHtmlChenhLech(DataSystem.instance.B1, DataSystem.instance.A4,  B1B2,  A1A2A3A4);
            String htmlVenhSoDu = GenHTML_TaiKhoan.instance.genVenhTien();

        html += htmlTaiKhoanDamBaoVDT + "___" +
                htmlVenhSoDu + "___" +
                htmlChenhLech + "___" +
                htmlTaiKhoanCaNhan + "___" +
                htmlTaiKhoanDamBaoCTT + "___" +
                htmlTaiKhoanDamBaoThuChiHo+ "___" +
                htmlTamUng + "___" +
                thoiGianTraCuu;
        return html;
        }


}
