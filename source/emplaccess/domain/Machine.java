
package com.emplaccess.domain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by JDCOM on 11/6/2016.
 */

@Entity
@Table(name="tbl_mch")

public class Machine  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String floor_number;
   // public int emp_active;
    public int mch_id;
    public int emp_rfid;

    public Machine() {
    }

    public Machine(String floor_number, int mch_id, int emp_rfid, Employee empl) {
        this.floor_number = floor_number;
        this.mch_id = mch_id;
        this.emp_rfid = emp_rfid;
       ///  this.empl = empl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFloor_number() {
        return floor_number;
    }

    public void setFloor_number(String floor_number) {
        this.floor_number = floor_number;
    }

    public int getMch_id() {
        return mch_id;
    }

    public void setMch_id(int mch_id) {
        this.mch_id = mch_id;
    }

    public int getEmp_rfid() {
        return emp_rfid;
    }

    public void setEmp_rfid(int emp_rfid) {
        this.emp_rfid = emp_rfid;
    }


    /*//*//*
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="emp_rfid",nullable = true)
    private  Employee empl; */
}

