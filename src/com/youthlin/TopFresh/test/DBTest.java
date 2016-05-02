package com.youthlin.TopFresh.test;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

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
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getSet() {
        return setTest;
    }

    public void setSet(Set<String> set) {
        this.setTest = set;
    }

    @ElementCollection
    private Set<String> setTest;

    public String toString() {
        return "[id=" + id + ",name=" + name + "," + setTest + "]";
    }
}
