import static spark.Spark.*;
import spark.*;
import com.google.gson.Gson;

public class userUtil {

  public static String toJson(Object object) {
    return new Gson().toJson(object);
  }

  public static ResponseTransformer json() {
    return userUtil::toJson;
  }
}
