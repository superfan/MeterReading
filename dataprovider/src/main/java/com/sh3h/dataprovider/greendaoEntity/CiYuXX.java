package com.sh3h.dataprovider.greendaoEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table CY_CiYuXX.
 */
public class CiYuXX {

    private int ID;
    private int WORDSID;
    /** Not-null value. */
    private String WORDSCONTENT;
    /** Not-null value. */
    private String WORDSVALUE;
    private String WORDSREMARK;
    private int BELONGID;
    private int SORTID;
    private int ISACTIVE;

    public CiYuXX() {
    }

    public CiYuXX(int ID, int WORDSID, String WORDSCONTENT, String WORDSVALUE, String WORDSREMARK, int BELONGID, int SORTID, int ISACTIVE) {
        this.ID = ID;
        this.WORDSID = WORDSID;
        this.WORDSCONTENT = WORDSCONTENT;
        this.WORDSVALUE = WORDSVALUE;
        this.WORDSREMARK = WORDSREMARK;
        this.BELONGID = BELONGID;
        this.SORTID = SORTID;
        this.ISACTIVE = ISACTIVE;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getWORDSID() {
        return WORDSID;
    }

    public void setWORDSID(int WORDSID) {
        this.WORDSID = WORDSID;
    }

    /** Not-null value. */
    public String getWORDSCONTENT() {
        return WORDSCONTENT;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setWORDSCONTENT(String WORDSCONTENT) {
        this.WORDSCONTENT = WORDSCONTENT;
    }

    /** Not-null value. */
    public String getWORDSVALUE() {
        return WORDSVALUE;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setWORDSVALUE(String WORDSVALUE) {
        this.WORDSVALUE = WORDSVALUE;
    }

    public String getWORDSREMARK() {
        return WORDSREMARK;
    }

    public void setWORDSREMARK(String WORDSREMARK) {
        this.WORDSREMARK = WORDSREMARK;
    }

    public int getBELONGID() {
        return BELONGID;
    }

    public void setBELONGID(int BELONGID) {
        this.BELONGID = BELONGID;
    }

    public int getSORTID() {
        return SORTID;
    }

    public void setSORTID(int SORTID) {
        this.SORTID = SORTID;
    }

    public int getISACTIVE() {
        return ISACTIVE;
    }

    public void setISACTIVE(int ISACTIVE) {
        this.ISACTIVE = ISACTIVE;
    }

    public String toString() {
        return this.WORDSCONTENT;
    }

}
