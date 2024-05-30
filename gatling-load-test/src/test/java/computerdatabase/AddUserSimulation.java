package computerdatabase;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class AddUserSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8080/api")
            .acceptHeader("application/json")
            .contentTypeHeader("application/json");

    ScenarioBuilder scn = scenario("Add User Scenario")
            .exec(
                    http("Add User")
                            .post("/addUser")
                            .body(StringBody("{ \"username\": \"testuser\", \"email\": \"testuser@example.com\", \"age\": 30, \"address\": \"123 Main St\", \"phone\": \"123-456-7890\" }")).asJson()
                            .check(status().is(200))
            );

    {
        setUp(
                scn.injectOpen(constantUsersPerSec(2).during(60))
        ).protocols(httpProtocol);
    }
}
