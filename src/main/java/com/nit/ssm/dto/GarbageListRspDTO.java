package com.nit.ssm.dto;

import java.util.List;

public class GarbageListRspDTO {
    private  List ListGarbage;

    public GarbageListRspDTO(){

    }

    public GarbageListRspDTO(List listGarbage) {
        ListGarbage = listGarbage;
    }

    public List getListGarbage() {
        return ListGarbage;
    }

    public void setListGarbage(List listGarbage) {
        ListGarbage = listGarbage;
    }
}
