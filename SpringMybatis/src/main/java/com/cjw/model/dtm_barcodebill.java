package com.cjw.model;

import java.io.Serializable;

public class dtm_barcodebill implements Serializable {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;
    private String patienttype;

    private String txmtemplate;
    
    private String hospitalid;

    private static final long serialVersionUID = 1L;

    public String getPatienttype() {
        return patienttype;
    }

    public void setPatienttype(String patienttype) {
        this.patienttype = patienttype == null ? null : patienttype.trim();
    }

    public String getTxmtemplate() {
        return txmtemplate;
    }

    public void setTxmtemplate(String txmtemplate) {
        this.txmtemplate = txmtemplate == null ? null : txmtemplate.trim();
    }

	public String getHospitalid() {
		return hospitalid;
	}

	public void setHospitalid(String hospitalid) {
		this.hospitalid = hospitalid;
	}

    @Override
    public String toString() {
        return "dtm_barcodebill{" +
                "patienttype='" + patienttype + '\'' +
                ", txmtemplate='" + txmtemplate + '\'' +
                ", hospitalid='" + hospitalid + '\'' +
                '}';
    }
}