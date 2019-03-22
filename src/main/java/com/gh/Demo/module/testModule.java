package com.gh.Demo.module;


import java.text.DecimalFormat;

public class testModule {
    private Integer userid;
    private String username;
    private String password;
    private String describe;

    public testModule() {
    }

    public Integer getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDescribe() {
        return describe;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        testModule that = (testModule) o;

        if (!userid.equals(that.userid)) return false;
        if (!username.equals(that.username)) return false;
        if (!password.equals(that.password)) return false;
        return describe.equals(that.describe);
    }

    @Override
    public int hashCode() {
        int result = userid.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + describe.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "testModule{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }

    public static void main(String[] args) {
        int year = 2014;
        int m = 3;
        double bj = 3097600;
        DecimalFormat df = new DecimalFormat("#.00");
        for (int i = 1; i <= 12; i++) {
            m++;
            if (m > 12) {
                m = 1;
                year++;
            }
            double lx = bj * 0.03;
            double kj = 102400 - lx;
            bj = bj - kj;
            System.out.println(year + "年" + m + "月本金为：" + df.format(bj) + "  应还利息：" + df.format(lx));
            System.out.println("扣减本金：" + df.format(kj));
        }
        bj = bj - 1000000;
        System.out.println("减去100万"+df.format(bj));
        for (int i = 1; i <= 17; i++) {
            m++;
            if (m > 12) {
                m = 1;
                year++;
            }
            double lx = bj * 0.03;
            double kj = 70400 - lx;
            bj = bj - kj;
            System.out.println(year + "年" + m + "月本金为：" + df.format(bj) + "  应还利息：" + df.format(lx));
            System.out.println("扣减本金：" + df.format(kj));
        }
        for (int i = 1; i <= 6; i++) {
            m++;
            if (m > 12) {
                m = 1;
                year++;
            }
            double lx = bj * 0.02;
            bj = bj + lx;
            System.out.println(year + "年" + m + "月本金为：" + df.format(bj) + "  利息：" + df.format(lx));
        }
        bj = bj - 500000;
        System.out.println("还款50万：" + df.format(bj));
        for (int i = 1; i <= 12; i++) {
            m++;
            if (m > 12) {
                m = 1;
                year++;
            }
            double lx = bj * 0.02;
            bj = bj + lx;
            System.out.println(year + "年" + m + "月本金为：" + df.format(bj) + "  利息：" + df.format(lx));
        }
        bj = bj - 250000;
        System.out.println("还款25万：" + df.format(bj));
        for (int i = 1; i <= 7; i++) {
            m++;
            if (m > 12) {
                m = 1;
                year++;
            }
            double lx = bj * 0.02;
            bj = bj + lx;
            System.out.println(year + "年" + m + "月本金为：" + df.format(bj) + "  利息：" + df.format(lx));
        }
        bj = bj - 200000;
        System.out.println("还款20万：" + df.format(bj));
        for (int i = 1; i <= 6; i++) {
            m++;
            if (m > 12) {
                m = 1;
                year++;
            }
            double lx = bj * 0.02;
            bj = bj + lx;
            System.out.println(year + "年" + m + "月本金为：" + df.format(bj) + "  利息：" + df.format(lx));
        }
    }
}
