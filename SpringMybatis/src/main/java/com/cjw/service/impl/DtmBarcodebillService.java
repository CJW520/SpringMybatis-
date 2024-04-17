package com.cjw.service.impl;

import com.cjw.dao.dtm_barcodebillMapper;
import com.cjw.model.dtm_barcodebill;
import com.cjw.service.IDtmBarcodebillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DtmBarcodebillService implements IDtmBarcodebillService {




    @Autowired
    private dtm_barcodebillMapper dtmMapper;


    @Override
    public List<dtm_barcodebill> geDtmList() {
        List<dtm_barcodebill> dtm = dtmMapper.Dtmlist();
        return dtm;

    }

    @Override
    public dtm_barcodebill geDtmById(int id) {
        dtm_barcodebill dtm = dtmMapper.DtmbyId(id);
        return dtm;

    }

    @Override
    public Map<String, Object> AddDtm(dtm_barcodebill dtm) {
        int a = dtmMapper.AddDtm(dtm);
        Map<String, Object> m = new HashMap<>();
        if (a > 0) {
            m.put("code", 0);
            m.put("msg", "保存成功");
        } else {
            m.put("code", 200);
            m.put("msg", "保存失败");
        }
        System.out.println(m);
        return m;

    }


    @Override
    public Map<String, Object> UpdDtm(dtm_barcodebill dtm) {
        int a = dtmMapper.UpdDtmbyId(dtm);
        Map<String, Object> m = new HashMap<>();
        if (a > 0) {
            m.put("code", 0);
            m.put("msg", "保存成功");
        } else {
            m.put("code", 200);
            m.put("msg", "保存失败");
        }
        return m;
    }


}
