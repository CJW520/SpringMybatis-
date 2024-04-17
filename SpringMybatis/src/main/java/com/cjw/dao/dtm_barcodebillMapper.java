package com.cjw.dao;

import com.cjw.model.dtm_barcodebill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface dtm_barcodebillMapper {

    dtm_barcodebill  DtmbyId(@Param("id") int id);

    List<dtm_barcodebill> Dtmlist();

    Integer AddDtm(dtm_barcodebill  dtm);


    Integer UpdDtmbyId(dtm_barcodebill  dtm);


}
