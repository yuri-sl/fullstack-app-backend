package io.gith;


import io.gith.quarkussocial.domain.module.User;
import io.gith.quarkussocial.domain.repository.UserRepository;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import static io.restassured.RestAssured.given;
//import static org.assert.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
public class UserServiceTest {
    @Inject
    UserRepository userRepository;

    @Test
    @DisplayName("Deve criar um novo usuário e retornar 201")
    void post_createUser_returns_201_withEntity(){
        var id =
                given()
                        .contentType("apllication/json")
                        .body("{\"name\":\"Yoru\",\"age\":21}")
                .when()
                        .post()
                .then()
                        .statusCode(201)
                        .body("id",notNullValue())
                        .body("name",equalTo("Yoru"))
                        .body("age",equalTo(21))
                .extract()
                        .jsonPath().getLong("id");
        User u = userRepository.findById(id);
        assert(u.getName()).equals("Yoru");
        assert(u.getAge()).equals(21);

    }


}
