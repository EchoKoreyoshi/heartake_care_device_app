package com.cjyun.heartakecare.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 创建者: vee
 * 时 间: 2016/9/27 0027
 * 描 述： TODO
 */
@Entity
public class RecordDB {
    @Id
    private Long id;
    @Unique
    private String name;
    private String date;
    private String projectName;
    private String consultValue;//參考值
    private String checkResult;//檢查結果
    private String symptom;//症狀
    private String clinical;//臨床
    @Generated(hash = 1604883156)
    public RecordDB(Long id, String name, String date, String projectName,
            String consultValue, String checkResult, String symptom, String clinical) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.projectName = projectName;
        this.consultValue = consultValue;
        this.checkResult = checkResult;
        this.symptom = symptom;
        this.clinical = clinical;
    }
    @Generated(hash = 1946513995)
    public RecordDB() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getProjectName() {
        return this.projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String getConsultValue() {
        return this.consultValue;
    }
    public void setConsultValue(String consultValue) {
        this.consultValue = consultValue;
    }
    public String getCheckResult() {
        return this.checkResult;
    }
    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }
    public String getSymptom() {
        return this.symptom;
    }
    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
    public String getClinical() {
        return this.clinical;
    }
    public void setClinical(String clinical) {
        this.clinical = clinical;
    }
}
