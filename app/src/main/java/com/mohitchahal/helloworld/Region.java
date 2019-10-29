package com.mohitchahal.helloworld;

import java.io.Serializable;

public class Region implements Serializable {

    public String zone;

    public String province;

    public String area;

    public String description;

    public Region() {
    }

    public Region(String zone, String province, String area, String description) {
        this.zone = zone;
        this.province = province;
        this.area = area;
        this.description = description;
    }

}
