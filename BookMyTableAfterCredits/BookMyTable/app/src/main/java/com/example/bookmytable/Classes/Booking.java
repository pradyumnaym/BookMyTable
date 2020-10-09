package com.example.bookmytable.Classes;

public class Booking {
    private String uid,rid,t1h,t1m,t2h,t2m,y,m,d,tableNo;

    public Booking(){}
    public Booking(String uid, String rid, String t1h,String t1m,String t2h,String t2m,String y,String m,String d,String tableNo) {
        this.uid = uid;
        this.rid = rid;
        this.t1h=t1h;
        this.t1m=t1m;
        this.t2h=t2h;
        this.t2m=t2m;
        this.y=y;
        this.m=m;
        this.d=d;
        this.tableNo=tableNo;
    }


    public String getT1h() {
        return t1h;
    }

    public void setT1h(String t1h) {
        this.t1h = t1h;
    }

    public String getT1m() {
        return t1m;
    }

    public void setT1m(String t1m) {
        this.t1m = t1m;
    }

    public String getT2h() {
        return t2h;
    }

    public void setT2h(String t2h) {
        this.t2h = t2h;
    }

    public String getT2m() {
        return t2m;
    }

    public void setT2m(String t2m) {
        this.t2m = t2m;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getUid() {
        return uid;
    }

    public String getTableNo() {
        return tableNo;
    }

    public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }


}
