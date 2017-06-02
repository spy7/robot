package configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NasaConfiguration.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NasaConfigurationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void acceptanceTesting() throws Exception {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        ResponseEntity<String> entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/rest/mars/MMM", params, String.class);

        assertEquals("invalid status code", HttpStatus.OK, entity.getStatusCode());
        assertEquals("invalid result", "(0, 3, N)", entity.getBody());
    }
}
