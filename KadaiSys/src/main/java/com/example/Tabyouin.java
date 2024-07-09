package com.example;

public class Tabyouin {
    private String tabyouinid;
    private String tabyouinmei;
    private String tabyouinaddress;
    private String tabyouintel;
    private int tabyouinshihonkin;
    private int kyukyu;

    public Tabyouin(String tabyouinid, String tabyouinmei, String tabyouinaddress, String tabyouintel,
            int tabyouinshihonkin, int kyukyu) {
        this.tabyouinid = tabyouinid;
        this.tabyouinmei = tabyouinmei;
        this.tabyouinaddress = tabyouinaddress;
        this.tabyouintel = tabyouintel;
        this.tabyouinshihonkin = tabyouinshihonkin;
        this.kyukyu = kyukyu;
    }

    // Getter and Setter methods
    // 省略
}
