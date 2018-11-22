package com.wp.project.myapplication;

import java.io.Serializable;
import java.util.List;

/**
 * Created by WangPan on 2018/9/29.
 */
public class ABean implements Serializable {


    private List<Object> list;
    private List<Integer> list1;
    private List<Integer> list2;

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public List<Integer> getList1() {
        return list1;
    }

    public void setList1(List<Integer> list1) {
        this.list1 = list1;
    }

    public List<Integer> getList2() {
        return list2;
    }

    public void setList2(List<Integer> list2) {
        this.list2 = list2;
    }
}
