package com.cjw.service;

import com.cjw.model.dtm_barcodebill;

import java.util.List;
import java.util.Map;

public interface IDtmBarcodebillService {


    List<dtm_barcodebill> geDtmList();

     dtm_barcodebill  geDtmById(int id);

    Map<String, Object> AddDtm(dtm_barcodebill dtm);


    Map<String, Object> UpdDtm (dtm_barcodebill dtm);
}





