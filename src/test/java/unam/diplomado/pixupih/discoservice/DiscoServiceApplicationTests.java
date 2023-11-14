package unam.diplomado.pixupih.discoservice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalManagementPort;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class DiscoServiceApplicationTests {
	
	@LocalServerPort
	private static int serverPort = 8083;
	
	@LocalManagementPort
	private static int managementPort = 8084;
	
	//MOCK VALUES
	
	//private static String DISQUERA_MOCKS = "/tests/disqueraMocks.json";
	
	// TEST
	
	@Autowired
	private static String DISQUERA_URL = "http://localhost:"+ String.valueOf(serverPort) +"/api/disqueras";
	

	@Test
	void contextLoads() {
	}
	
	@Test
    public void getDisquerasTest() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<Iterable> response = testRestTemplate.getForEntity(DISQUERA_URL, Iterable.class);
        
        // Verificar que la solicitud fue exitosa (código de estado 200 OK)
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        
        // Obtener la lista de disqueras desde la respuesta
        //Iterable<Disquera> disqueras = response.getBody();
        
        // Realizar las aserciones adicionales según tus requisitos
        // Por ejemplo, puedes verificar que la lista no esté vacía, etc.
        //Assert.assertNotNull(disqueras);
    }

}