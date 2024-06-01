package computerdatabase;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class UsersToXlsxSimulation extends Simulation {

  HttpProtocolBuilder httpProtocol = http
    .baseUrl("http://192.168.1.96:8080/api")
    .acceptHeader("application/json");

  ScenarioBuilder scn = scenario("Users to XLSX Scenario")
    .exec(
      http("Users to XLSX")
        .get("/usersToXlsx")
    );

  {
    setUp(
      scn.injectOpen(constantUsersPerSec(5).during(60))
    ).protocols(httpProtocol);
  }
}
