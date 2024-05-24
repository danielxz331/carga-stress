package computerdatabase;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class FileUploadSimulation extends Simulation {

  HttpProtocolBuilder httpProtocol = http
    .baseUrl("http://localhost:8080/api")
    .acceptHeader("application/json")
    .contentTypeHeader("multipart/form-data");

  ScenarioBuilder scn = scenario("File Upload Scenario")
    .exec(
      http("Upload JSON File")
        .post("/uploadJson")
        .asMultipartForm()
        .bodyPart(RawFileBodyPart("file", "users.json").fileName("users.json"))
    );

  {
    setUp(
      scn.injectOpen(constantUsersPerSec(2).during(60))
    ).protocols(httpProtocol);
  }
}
