package com.cjw.model;

import java.io.Serializable;
import lombok.Data;

/**
 * 操作模块表
 * pub_menu
 */
@Data
public class PubMenu implements Serializable {
    private Long id;

    private String menucode;

    private String menuname;

    private String parentcode;

    private String url;

    private String imageurl;

    private String memo;

    private Integer isreport;

    private Integer sortno;

    private String actionname;

    private String parenticon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenucode() {
        return menucode;
    }

    public void setMenucode(String menucode) {
        this.menucode = menucode;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getParentcode() {
        return parentcode;
    }

    public void setParentcode(String parentcode) {
        this.parentcode = parentcode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getIsreport() {
        return isreport;
    }

    public void setIsreport(Integer isreport) {
        this.isreport = isreport;
    }

    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    public String getActionname() {
        return actionname;
    }

    public void setActionname(String actionname) {
        this.actionname = actionname;
    }

    public String getParenticon() {
        return parenticon;
    }

    public void setParenticon(String parenticon) {
        this.parenticon = parenticon;
    }
}