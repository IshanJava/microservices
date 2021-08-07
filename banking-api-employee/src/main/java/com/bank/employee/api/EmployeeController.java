package com.bank.employee.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
@CrossOrigin(origins = "*") //this can be acceed by other domain
public class EmployeeController {
	@GetMapping("/employees/{eid}")
	public EmployeeVO findEmployee(@PathVariable int eid) {
		EmployeeVO employeeVO=new EmployeeVO();
		employeeVO.setName("Mr. Nagendra Kumar");
		employeeVO.setEmail("technohunk100@gmail.com");
		employeeVO.setBalance(122);
		employeeVO.setPhone(1233);
		employeeVO.setEid(eid);
		return employeeVO;
	}
	
	@GetMapping("/employees")
	public List<EmployeeVO> findEmployee() {
		EmployeeVO employeeVO=new EmployeeVO();
		employeeVO.setName("Nagendra Kumar");
		employeeVO.setEmail("technohunk100@gmail.com");
		employeeVO.setBalance(122);
		employeeVO.setPhone(1233);
		List<EmployeeVO> employeeVOs=new ArrayList<EmployeeVO>();
		employeeVOs.add(employeeVO);
		return employeeVOs;
	}

}
