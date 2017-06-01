package controller;

import configuration.NasaConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NasaConfiguration.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NasaConfigurationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void acceptanceTesting() throws Exception {
        ResponseEntity<Map> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/rest/mars/MMM", Map.class);
        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
