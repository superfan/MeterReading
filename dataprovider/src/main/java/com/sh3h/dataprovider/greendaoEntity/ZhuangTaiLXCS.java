package com.sh3h.dataprovider.greendaoEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table CB_ZhuangTaiLXCS.
 */
public class ZhuangTaiLXCS {

    /** Not-null value. */
    private String S_CID;
    private int D_ChaoBiaoRQ;
    private int I_CHAOBIAOZTBM;
    private int I_LIANGGAOLDYYBM;
    private int RANKNUM;

    public ZhuangTaiLXCS() {
    }

    public ZhuangTaiLXCS(String S_CID, int D_ChaoBiaoRQ, int I_CHAOBIAOZTBM, int I_LIANGGAOLDYYBM, int RANKNUM) {
        this.S_CID = S_CID;
        this.D_ChaoBiaoRQ = D_ChaoBiaoRQ;
        this.I_CHAOBIAOZTBM = I_CHAOBIAOZTBM;
        this.I_LIANGGAOLDYYBM = I_LIANGGAOLDYYBM;
        this.RANKNUM = RANKNUM;
    }

    /** Not-null value. */
    public String getS_CID() {
        return S_CID;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setS_CID(String S_CID) {
        this.S_CID = S_CID;
    }

    public int getD_ChaoBiaoRQ() {
        return D_ChaoBiaoRQ;
    }

    public void setD_ChaoBiaoRQ(int D_ChaoBiaoRQ) {
        this.D_ChaoBiaoRQ = D_ChaoBiaoRQ;
    }

    public int getI_CHAOBIAOZTBM() {
        return I_CHAOBIAOZTBM;
    }

    public void setI_CHAOBIAOZTBM(int I_CHAOBIAOZTBM) {
        this.I_CHAOBIAOZTBM = I_CHAOBIAOZTBM;
    }

    public int getI_LIANGGAOLDYYBM() {
        return I_LIANGGAOLDYYBM;
    }

    public void setI_LIANGGAOLDYYBM(int I_LIANGGAOLDYYBM) {
        this.I_LIANGGAOLDYYBM = I_LIANGGAOLDYYBM;
    }

    public int getRANKNUM() {
        return RANKNUM;
    }

    public void setRANKNUM(int RANKNUM) {
        this.RANKNUM = RANKNUM;
    }

}