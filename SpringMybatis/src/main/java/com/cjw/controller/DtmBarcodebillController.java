package com.cjw.controller;

import com.cjw.model.dtm_barcodebill;
import com.cjw.service.IDtmBarcodebillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MSI
 */
@RestController
//@RequestMapping("/lis")
public class DtmBarcodebillController {

    @Autowired
    private IDtmBarcodebillService dtmBarcodebillService;


    //根据id获取数据
    @RequestMapping(value = "/getlodop", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getDtmById(HttpServletRequest request, @RequestParam Integer id) {
        dtm_barcodebill dtm = dtmBarcodebillService.geDtmById(id);
        Map<String, Object> m =new HashMap<>();
        m.put("data", dtm);
        m.put("code", 0);
        m.put("msg", "查询成功");
        return m;
    }

    //保存数据
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getUsers(HttpServletRequest request, @RequestParam String lodoptxt) {
        dtm_barcodebill dtms = dtmBarcodebillService.geDtmById(51);

        Map<String, Object> m ;
        dtm_barcodebill dtm = new dtm_barcodebill();
        if (dtms == null) {
            dtm.setHospitalid("666");
            dtm.setPatienttype("999");
            dtm.setTxmtemplate(lodoptxt);
            m = dtmBarcodebillService.AddDtm(dtm);
        } else {
            dtm.setId(51);
            dtm.setHospitalid("666");
            dtm.setPatienttype("999");
            dtm.setTxmtemplate(lodoptxt);
            m = dtmBarcodebillService.UpdDtm(dtm);
        }
        return m;
    }
}
