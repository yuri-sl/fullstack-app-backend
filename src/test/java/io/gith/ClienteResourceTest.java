package io.gith;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class ClienteResourceTest {

    @Test
    void deveCriarCliente(){
        String email = "ana."+ java.util.UUID.randomUUID() +"@gmail.com";
        String cpf = "111.111." + (100 + (int)(Math.random()*800)) + "-23";

        String body = """
            {
              "nome_cliente":"Ana",
              "email_cliente":"%s",
              "senha_cliente":"arroz123",
              "cpf_cliente":"%s"
            }
        """.formatted(email, cpf);

        given()
                .contentType("application/json")
                .accept("application/json")
                .body(body)
                .when()
                .post("/cliente")
                .then()
                .statusCode(anyOf(is(200), is(201)));
    }

    @Test
    void deveRetornar404QuandoNaoExiste(){
        when()
                .get("/cliente/55555")
                .then()
                .statusCode(405);
    }
}
