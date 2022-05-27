package com.amol.kafka.springbootkafka.model;

import java.io.Serializable;

public class Department implements Serializable {

    private String deptId;
    private String deptName;

    public Department() {
    }
    public Department(String deptId, String deptName ) {

        this.deptId = deptId;
        this.deptName = deptName;

    }
    public String getdeptId()  {return this.deptId;}
    public String getdeptName() {return this.deptName;}

    public void setdeptId(String deptId ){this.deptId =deptId ;}
    public void setdeptName(String deptName){this.deptName =deptName ;}

}
