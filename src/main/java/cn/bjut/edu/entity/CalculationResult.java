package cn.bjut.edu.entity;

import java.io.Serializable;

/**
 * @author zhengtianqi and wangkai
 */
public class CalculationResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private double CI;
    private double RI;
    private double CR;
    private double lmax;

    public double getCI() {
        return CI;
    }

    public void setCI(double CI) {
        this.CI = CI;
    }

    public double getRI() {
        return RI;
    }

    public void setRI(double RI) {
        this.RI = RI;
    }

    public double getCR() {
        return CR;
    }

    public void setCR(double CR) {
        this.CR = CR;
    }

    public double getLmax() {
        return lmax;
    }

    public void setLmax(double lmax) {
        this.lmax = lmax;
    }
}
