package com.sh3h.dataprovider.greendaoEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table LG_DengLuLS.
 */
public class DengLuLS {

    private Integer UserID;
    private String S_YUANGONGZH;
    private Integer D_DengLuSJ;
    private Integer I_DengLuFS;
    private Integer I_YanZhengFS;
    private String S_MiMa;

    public DengLuLS() {
    }

    public DengLuLS(Integer UserID, String S_YUANGONGZH, Integer D_DengLuSJ, Integer I_DengLuFS, Integer I_YanZhengFS, String S_MiMa) {
        this.UserID = UserID;
        this.S_YUANGONGZH = S_YUANGONGZH;
        this.D_DengLuSJ = D_DengLuSJ;
        this.I_DengLuFS = I_DengLuFS;
        this.I_YanZhengFS = I_YanZhengFS;
        this.S_MiMa = S_MiMa;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer UserID) {
        this.UserID = UserID;
    }

    public String getS_YUANGONGZH() {
        return S_YUANGONGZH;
    }

    public void setS_YUANGONGZH(String S_YUANGONGZH) {
        this.S_YUANGONGZH = S_YUANGONGZH;
    }

    public Integer getD_DengLuSJ() {
        return D_DengLuSJ;
    }

    public void setD_DengLuSJ(Integer D_DengLuSJ) {
        this.D_DengLuSJ = D_DengLuSJ;
    }

    public Integer getI_DengLuFS() {
        return I_DengLuFS;
    }

    public void setI_DengLuFS(Integer I_DengLuFS) {
        this.I_DengLuFS = I_DengLuFS;
    }

    public Integer getI_YanZhengFS() {
        return I_YanZhengFS;
    }

    public void setI_YanZhengFS(Integer I_YanZhengFS) {
        this.I_YanZhengFS = I_YanZhengFS;
    }

    public String getS_MiMa() {
        return S_MiMa;
    }

    public void setS_MiMa(String S_MiMa) {
        this.S_MiMa = S_MiMa;
    }

}
