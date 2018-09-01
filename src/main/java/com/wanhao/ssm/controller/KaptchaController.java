package com.wanhao.ssm.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * Created by LiuLiHao on 2018/7/16 18:19.
 * 描述：验证码操作类
 * 作者： LiuLiHao
 */
@RequestMapping(value = "kaptcha")
@Controller
public class KaptchaController {

    @Autowired
    DefaultKaptcha captchaProducer;

    private static final String VALIDATECODE = "validateCode";

    /**
     * 获取验证码
     *
     * @param request
     * @param response
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/captcha-image")
    public ModelAndView getKaptchaImage(HttpServletRequest request,
                                        HttpServletResponse response,
                                        HttpSession session) throws Exception {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control",
                "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        String capText = captchaProducer.createText();
        session.setAttribute(VALIDATECODE, capText);
        System.out.println("capText: " + capText);

        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }


    /**
     * 检查验证码是否正确
     *
     * @param verifyCode
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping(value = "/checkVerifyCode", method = RequestMethod.POST)
    @ResponseBody
    public Object checkVerifyCode(@RequestParam(value = "verifyCode") String verifyCode, HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        String flag = "false";


        JsonObject jsonObject = new JsonObject();

        if(verifyCode!=null){
            String validateCode= (String) session.getAttribute(VALIDATECODE);

            if(validateCode!= null && validateCode.equals(verifyCode)){
                jsonObject.addProperty("valid", true);
                flag = "true";
            }else{
                jsonObject.addProperty("valid", false);
                flag = "false";
            }
        }else{
            jsonObject.addProperty("valid", false);
            flag = "false";
        }
         //return jsonObject;
        return flag;
    }
}