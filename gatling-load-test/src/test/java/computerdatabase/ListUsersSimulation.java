package computerdatabase;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class ListUsersSimulation extends Simulation {

  HttpProtocolBuilder httpProtocol = http
    .baseUrl("http://192.168.1.96:8080/api") // Reemplaza con tu URL base
    .acceptHeader("application/json");

  ScenarioBuilder scn = scenario("List Users Scenario")
    .exec(
      http("List Users")
        .get("/list-users")
    );

  {
    setUp(
      scn.injectOpen(constantUsersPerSec(600).during(5)) // Ajusta la carga según tus necesidades
    ).protocols(httpProtocol);
  }
}