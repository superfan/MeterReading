package com.sh3h.dataprovider.greendaoEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table JG_FeiYongZC.
 */
public class FeiYongZC {

    private int ID;
    private int I_TIAOJIAH;
    private int I_FEIYONGID;
    /** Not-null value. */
    private String S_FEIYONGMC;
    private double N_JIAGE;
    private int I_FEIYONGDLID;
    private double N_XISHU;

    public FeiYongZC() {
    }

    public FeiYongZC(int ID, int I_TIAOJIAH, int I_FEIYONGID, String S_FEIYONGMC, double N_JIAGE, int I_FEIYONGDLID, double N_XISHU) {
        this.ID = ID;
        this.I_TIAOJIAH = I_TIAOJIAH;
        this.I_FEIYONGID = I_FEIYONGID;
        this.S_FEIYONGMC = S_FEIYONGMC;
        this.N_JIAGE = N_JIAGE;
        this.I_FEIYONGDLID = I_FEIYONGDLID;
        this.N_XISHU = N_XISHU;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getI_TIAOJIAH() {
        return I_TIAOJIAH;
    }

    public void setI_TIAOJIAH(int I_TIAOJIAH) {
        this.I_TIAOJIAH = I_TIAOJIAH;
    }

    public int getI_FEIYONGID() {
        return I_FEIYONGID;
    }

    public void setI_FEIYONGID(int I_FEIYONGID) {
        this.I_FEIYONGID = I_FEIYONGID;
    }

    /** Not-null value. */
    public String getS_FEIYONGMC() {
        return S_FEIYONGMC;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setS_FEIYONGMC(String S_FEIYONGMC) {
        this.S_FEIYONGMC = S_FEIYONGMC;
    }

    public double getN_JIAGE() {
        return N_JIAGE;
    }

    public void setN_JIAGE(double N_JIAGE) {
        this.N_JIAGE = N_JIAGE;
    }

    public int getI_FEIYONGDLID() {
        return I_FEIYONGDLID;
    }

    public void setI_FEIYONGDLID(int I_FEIYONGDLID) {
        this.I_FEIYONGDLID = I_FEIYONGDLID;
    }

    public Double getN_XISHU() {
        return N_XISHU;
    }

    public void setN_XISHU(Double N_XISHU) {
        this.N_XISHU = N_XISHU;
    }

}