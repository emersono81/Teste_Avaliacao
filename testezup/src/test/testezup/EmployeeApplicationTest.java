package testezup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.zup.testeselecao.EmployeeApplication;

/**
 * 
 * @author Emerson Oliveira
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeeApplication.class)
@TestPropertySource(locations="classpath:application.properties")
public class EmployeeApplicationTest {

	@Test
	public void contextLoads() {
	}

}