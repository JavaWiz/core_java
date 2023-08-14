package com.javawiz.interview;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Sample {
    private List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        List<String> copy = new ArrayList<>();
        for (int i = 0 ; i< list.size(); i++) {
            copy.add(i+"/"+list.size()+" "+list.get(i));
        }
        this.list = copy;
    }
}
