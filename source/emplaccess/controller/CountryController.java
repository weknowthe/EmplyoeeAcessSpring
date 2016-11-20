package com.emplaccess.controller;

import java.util.List;

import com.emplaccess.domain.Employee;
import com.emplaccess.domain.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
	public class CountryController {


	@Autowired
	EntityManagerFactory entityManagerFactory ;

	@RequestMapping(value="/list",method= RequestMethod.GET)
	public
	@ResponseBody
	boolean verifyAccess(HttpServletRequest request)  {

		  int mch_id=Integer.valueOf(request.getHeader("mch_id"));
		  int emp_rfid=Integer.valueOf(request.getHeader("emp_rfid"));
          int floor_number=  Integer.valueOf(request.getHeader("floor_number"));





		EntityManager em = entityManagerFactory.createEntityManager();
		Query queryemp = entityManagerFactory.createEntityManager()
				.createQuery("SELECT DISTINCT e FROM Employee AS e where e.emp_rfid=:emp_rfid", Employee.class);

        queryemp.setParameter("emp_rfid",emp_rfid);
        List<Employee> emplList;
        emplList=queryemp.getResultList();



       Query querymch=entityManagerFactory.createEntityManager()
                .createQuery("SELECT DISTINCT m FROM Machine AS m where m.mch_id=:mch_id and m.emp_rfid=:emp_rfid", Machine.class);
        querymch.setParameter("mch_id",mch_id);
        querymch.setParameter("emp_rfid",emp_rfid);


        List<Machine> mchList ;
        mchList =querymch.getResultList();


        boolean m=mchList.isEmpty();
        boolean e =emplList.isEmpty();


       if((emplList.isEmpty()) || (mchList.isEmpty()))
       {
           return false;

       }
       else if((emplList.get(0).getEmp_active())!=1 ){return  false;}

       else
      		return  true;

	}
}
