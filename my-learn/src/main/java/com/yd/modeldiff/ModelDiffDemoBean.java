package com.yd.modeldiff;

import java.util.Date;

/**
 * Created by nick on 2017/11/13.
 */
@ModelDiffBean
public class ModelDiffDemoBean {

    private int intP;

    private Integer integerP;

    private String stringP;

    private Date dateP;

    public ModelDiffDemoBean(){

    }

    public ModelDiffDemoBean(int intP, Integer integerP, String stringP, Date dateP) {
        this.intP = intP;
        this.integerP = integerP;
        this.stringP = stringP;
        this.dateP = dateP;
    }

    public int getIntP() {
        return intP;
    }

    public void setIntP(int intP) {
        this.intP = intP;
    }

    public Integer getIntegerP() {
        return integerP;
    }

    public void setIntegerP(Integer integerP) {
        this.integerP = integerP;
    }

    public String getStringP() {
        return stringP;
    }

    public void setStringP(String stringP) {
        this.stringP = stringP;
    }

    public Date getDateP() {
        return dateP;
    }

    public void setDateP(Date dateP) {
        this.dateP = dateP;
    }
}
