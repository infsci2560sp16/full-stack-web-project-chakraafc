import static spark.Spark.*;
import spark.*;
import com.google.gson.Gson;

public class UserController {

  public UserController(final UserServices userService) {

    get("/users", new Route() {
      @Override
      public Object handle(Request request, Response response) {
        // process request
        return new Gson().toJson(userService.getAllUsers());
      }
    });

    // more routes
  }
}
