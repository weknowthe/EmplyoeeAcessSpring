 package com.emplaccess.domain;

import javax.persistence.*;
import java.io.Serializable;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by JDCOM on 11/6/2016.
 */


//java.io.Serializable

@Entity
@Table(name ="tbl_emp")
public class Employee implements Serializable {

     @Id
     public int emp_rfid;

    public String emp_name;
    public int emp_active;

    public Employee(int emp_rfid, String emp_name, int emp_active) {
        this.emp_rfid = emp_rfid;
        this.emp_name = emp_name;
        this.emp_active = emp_active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", emp_rfid=" + emp_rfid +
                ", emp_name='" + emp_name + '\'' +
                ", emp_active=" + emp_active +
                '}';
    }

    public Employee() {
    }



    public int getEmp_rfid() {
        return emp_rfid;
    }

    public void setEmp_rfid(int emp_rfid) {
        this.emp_rfid = emp_rfid;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public int getEmp_active() {
        return emp_active;
    }

    public void setEmp_active(int emp_active) {
        this.emp_active = emp_active;
    }
}
/*public int id;
    public String first_name;
    public String last_name;
    public String email;
    public String phone;


    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

*/