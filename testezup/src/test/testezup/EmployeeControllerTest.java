package testezup;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.zup.testeselecao.controller.EmployeeController;
import com.zup.testeselecao.dao.EmployeeDAO;
import com.zup.testeselecao.model.Employee;


/**
 * 
 * @author Emerson Oliveira
 *
 */

public class EmployeeControllerTest  {

	private MockMvc mockMvc;

	@Autowired
	private EmployeeController employeeController;

	@Autowired
	EmployeeDAO employeeDAO;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
	}

	@Test
	public void testPOSTSaveController() throws Exception {

		
		Employee emp = new Employee();
		emp.setNome("João");
		emp.setCpf("99999999999");
		emp.setEndereco("Avenida Paulista");
		emp.setDataNascimento(new Date());

		emp = employeeDAO.save(emp);

		this.mockMvc.perform(MockMvcRequestBuilders.get("/company/employees/" + emp.getId()))
				.andExpect(MockMvcResultMatchers.status().isOk());

		this.mockMvc.perform(MockMvcRequestBuilders.delete("/company/employees/" + emp.getId()))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/company/employees/" + emp.getId()))
		.andExpect(MockMvcResultMatchers.status().isNoContent());

	}

}
