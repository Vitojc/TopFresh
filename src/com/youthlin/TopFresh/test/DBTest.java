package com.youthlin.TopFresh.test;

import javax.persistence.*;

/**
 * Created by lin on 2016-05-01-001.
 * 测试Hibernate
 * 实体类
 * 一定要在cfg里配置实体，否则
 * org.hibernate.MappingException: Unknown entity
 */
@Entity
@Table
public class DBTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String kkey;
    private String vvalue;

    public String toString() {
        return "DBTest[id=" + id + ",kkey=" + kkey + ",vvalur=" + vvalue + "]";
    }

    public String getKkey() {
        return kkey;
    }

    public void setKkey(String kkey) {
        this.kkey = kkey;
    }

    public String getVvalue() {
        return vvalue;
    }

    public void setVvalue(String vvalue) {
        this.vvalue = vvalue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
