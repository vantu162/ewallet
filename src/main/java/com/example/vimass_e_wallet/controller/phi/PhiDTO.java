package com.example.vimass_e_wallet.controller.phi;

import com.example.vimass_e_wallet.model.Response;
import com.example.vimass_e_wallet.model.acc.AccountInfo;
import com.example.vimass_e_wallet.model.phi.*;
import com.example.vimass_e_wallet.services.CallServices_Phi;
import com.example.vimass_e_wallet.services.DataSystem;
import com.example.vimass_e_wallet.tool.Func;
import com.example.vimass_e_wallet.tool.GetValue;
import com.google.gson.Gson;

public class PhiDTO {
    public static PhiDTO instance;
    static {
        instance = new PhiDTO();
    }

    public Response[] getDataThuChi(String secssion,String user ,String timeFrom, String timeTo){

        //type = 3 thu, type = 2 chi
        //----------------------------Gd thu----------------------------------------------------------
        Response[] results = new Response[2];
        int delay = 200;
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(delay);
                ObjThuChiRequest obj = GetValue.instance.getObjThuChiRequest(secssion, user, timeFrom, timeTo, 3);
                results[0] =  CallServices_Phi.instance.resTongGD_ThuChi(obj);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        //----------------------------Gd chi----------------------------------------------------------
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(delay);
                    ObjThuChiRequest obj = GetValue.instance.getObjThuChiRequest(secssion, user, timeFrom, timeTo, 2);
                results[1] = CallServices_Phi.instance.resTongGD_ThuChi(obj);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        11_xxx_
        return results;

    }
    public String[] getDataChiPVCB(String timeFrom, String timeTo){

        String[] results = new String[5];

        int delay = 200;

        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(delay);
                results[0] = getChiPVCB(timeFrom, timeTo, 0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(delay);
                results[1] = getChiPVCB(timeFrom, timeTo, 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2.start();
        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(delay);
                results[2] = getChiPVCB(timeFrom, timeTo, 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread3.start();
        Thread thread4 = new Thread(() -> {
            try {
                Thread.sleep(delay);
                results[3] = getChiPVCB(timeFrom, timeTo, 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread4.start();
        Thread thread5 = new Thread(() -> {
            try {
                Thread.sleep(delay);
                results[4] = getChiPVCB(timeFrom, timeTo, 6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return results;
    }

    public String getChiPVCB(String timeFrom, String timeTo, int type)
    {
        String str ="";
        long t1 = Func.instance.converFullDateTimeToLongTime(timeFrom);
        long t2 =Func.instance.converFullDateTimeToLongTime(timeTo);
        String res = CallServices_Phi.instance.getlayPhiChiHoPVCB(t1,t2,type); //type = 1
        if(res != null && res!="")
        {
            if (res.contains("#")) {

                str += Func.getVNDFormat(Double.valueOf(res.split("#")[0]));
                str += "___";
                str += Func.getVNDFormat(Double.valueOf(res.split("#")[1]));
            }else{
                str += res;
            }
        }
        return str;
    }

    public String[] getDataChiBIDV(String timeFrom, String timeTo){

        String[] results = new String[5];

        int delay = 200;

        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(delay);
                results[0] = getChiBIDV(timeFrom, timeTo, 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(delay);
                results[1] = getChiBIDV(timeFrom, timeTo, 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2.start();
        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(delay);
                results[2] = getChiBIDV(timeFrom, timeTo, 3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread3.start();
        Thread thread4 = new Thread(() -> {
            try {
                Thread.sleep(delay);
                results[3] = getChiBIDV(timeFrom, timeTo, 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread4.start();
        Thread thread5 = new Thread(() -> {
            try {
                Thread.sleep(delay);
                results[4] = getChiBIDV(timeFrom, timeTo, 6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return results;
    }

    public String getChiBIDV(String timeFrom, String timeTo, int type) {
        String str ="";
        BankDTORequest obj = GetValue.instance.getObjBankDTORequest(14, timeFrom, timeTo, type);
        String res = CallServices_Phi.instance.postLayPhiChiHoBIDV(obj);
         System.out.println("bidv type: "+type+"___" + res);
        if (res != null && res != "") {
            if (res.contains("#")) {
                str += Func.getVNDFormat(Double.valueOf(res.split("#")[0]));
                str += "___";
                str += Func.getVNDFormat(Double.valueOf(res.split("#")[1]));
            } else {
                str += res;
            }
        }
        return str;
    }


    public ObjPhiThuQuaQR getPhiThuQuaQR(String timeFrom, String timeTo){

        ObjPhiThuQuaQR objPhiThuQuaQR = null;
        try{
            ObjThuQuaQR_Request obj = ToolPhi.instance.getValueObjThuQuaQR(timeFrom,timeTo);

            ObjThuQuaQR_Response objThuQuaQR_response = CallServices_Phi.instance.postLayPhiThuQuaQR(obj);

            objPhiThuQuaQR = new Gson().fromJson(new Gson().toJson(objThuQuaQR_response.getResult()), ObjPhiThuQuaQR.class);

            System.out.println("resThuQuaQR obj: " +objPhiThuQuaQR.toString());
        }catch (Exception e){
            System.out.println("resThuQuaQR: " +e.getMessage());
        }
        return objPhiThuQuaQR;
    }

}

