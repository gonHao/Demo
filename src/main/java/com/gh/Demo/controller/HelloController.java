package com.gh.Demo.controller;

import com.gh.Demo.module.testModule;
import com.gh.Demo.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    private testService ts;

    @RequestMapping("/exist")
    public String exits(String username, String password) {
        testModule user = null;
        user = ts.browseUser(username);
        System.out.println("user:" + user);
        if (user == null) {
            return "redirect:/nonExistentUser.html";
        } else if (user.getPassword().equals(password)) {
            return "find";
        } else {
            return "redirect:/nonExistentUser.html";
        }
    }

    @RequestMapping("/findUsername")
    @ResponseBody
    public boolean fUsername(String username) {
        testModule user = null;
        user = ts.browseUser(username);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(String username, String password, String describe) {
        testModule user = new testModule();
        user.setUsername(username);
        user.setPassword(password);
        user.setDescribe(describe);
        if (ts.browseUser(username) == null) {
            ts.addUser(user);
            return "插入成功";
        } else {
            return "用户名已经存在";
        }

    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(String upusername, String uppassword, String updescribe) {
        testModule user = new testModule();
        user.setUsername(upusername);
        user.setPassword(uppassword);
        user.setDescribe(updescribe);
        System.out.println(user);
        if (ts.browseUser(upusername) != null) {
            ts.updateUser(user);
            return "修改成功";
        } else {
            return "用户不存在";
        }

    }

    @RequestMapping("/index")
    public String hi() {
        return "/index";
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(String dusername) {
        ts.dorpUser(dusername);
        return "删除成功";
    }

    @RequestMapping("/findUser")
    @ResponseBody
    public testModule findUser(String selusername) {
        testModule user = null;
        user = ts.browseUser(selusername);
        return user;
    }

    @RequestMapping("/findTest")
    public String findTest(HttpServletRequest request, String selusername) {
        testModule user = null;
        user = ts.browseUser(selusername);
        request.setAttribute("username", user.getUsername());
        request.setAttribute("describe", user.getDescribe());
        return "findTest";
    }

    @RequestMapping("/findAll")
    public String findAll(ModelMap model) {
        List<testModule> users = ts.findAll();
        System.out.println(users);
        model.addAttribute("users", users);
        return "findAll";
    }



    public static void main(String[] args) {
        int year = 2014;
        int m=3;
        double bj = 1452000;
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(year+"年"+m+"月本金为："+df.format(bj));
        for (int i = 1; i <= 15; i++) {
            m++;
            if(m>12){
                m=1;
                year++;
            }
            double lx = bj * 0.03;
            double kj = 48000-lx;
            bj = bj - kj;
            System.out.println(year+"年"+m+"月本金为" + df.format(bj)+"  应还利息："+df.format(lx));
            System.out.println("  扣减本金："+df.format(kj));
        }
        System.out.println("每月还70400");
        for (int i = 1; i <= 14; i++) {
            m++;
            if(m>12){
                m=1;
                year++;
            }
            double lx = bj * 0.03;
            double kj = 70400-lx;
            bj = bj - kj;
            System.out.println(year+"年"+m+"月本金为" + df.format(bj)+"  应还利息："+df.format(lx));
            System.out.println("  扣减本金："+df.format(kj));
        }
        System.out.print("利率变为2%后,");
        for (int i = 1; i <= 5; i++) {
            m++;
            if(m>12){
                m=1;
                year++;
            }
            double lx = bj * 0.02;
            bj = bj + lx;
            System.out.println(year+"年"+m+"月本金为：" + df.format(bj)+"  每月利息"+df.format(lx));
        }
        bj = bj - 500000;
        System.out.println("还款50万后本金：" + df.format(bj));
        for (int i = 1; i <= 12; i++) {
            m++;
            if(m>12){
                m=1;
                year++;
            }
            double lx = bj * 0.02;
            bj = bj + lx;
            System.out.println(year+"年"+m+"月本金为：" + df.format(bj)+"  每月利息"+df.format(lx));
        }
        bj=bj-250000;
        System.out.println("还款25万后本金：" +df.format(bj));
        for (int i = 1; i <= 7; i++) {
            m++;
            if(m>12){
                m=1;
                year++;
            }
            double lx = bj * 0.02;
            bj = bj + lx;
            System.out.println(year+"年"+m+"月本金为：" + df.format(bj)+"  每月利息"+df.format(lx));
        }
        bj = bj - 200000;
        System.out.println("还款20万后本金：" +df.format(bj));
        for (int i = 1; i <= 7; i++) {
            m++;
            if(m>12){
                m=1;
                year++;
            }
            double lx = bj * 0.02;
            bj = bj + lx;
            System.out.println(year+"年"+m+"月本金为：" + df.format(bj)+"  每月利息"+df.format(lx));
            System.out.println("截止2019年3月本息为"+df.format(bj));
        }
    }

}
