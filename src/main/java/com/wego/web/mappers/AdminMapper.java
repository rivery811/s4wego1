package com.wego.web.mappers;

import org.springframework.stereotype.Repository;

import com.wego.web.domains.AdminDTO;
import com.wego.web.domains.EmployeeDTO;
@Repository
public interface AdminMapper {
	
	public int countAdmins();
	
}
