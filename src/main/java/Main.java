import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;
import com.google.gson.Gson;

import com.heroku.sdk.jdbc.DatabaseUrl;
import spark.Request;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    Gson gson = new Gson();
//get json
    new UserController(new UserServices());


//Using freemarker template
    get("/users", (req, res) -> {
                 ArrayList<String> users = new ArrayList<String>();
                 users.add("belowtenthousand");
                 users.add("abovetenthousand");
                 Map<String, Object> attributes = new HashMap<>();
                 attributes.put("users", users);
                 attributes.put("message", "The more you invest ,the less you pay for fees.");
                  return new ModelAndView(attributes, "users.ftl");
               }, new FreeMarkerEngine());
//get xml
       get("/about", (req, res) -> {

                       Connection connection = null;
                       // res.type("application/xml"); //Return as XML

                       Map<String, Object> attributes = new HashMap<>();
                       try {


                           String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
                           xml += "<About>";

                               xml += "<Branch>";
                               xml += "<FirstName>Jacob</FirstName>";
                               xml += "<LastName>McCarthy</LastName>";
                               xml += "<Street>35_Highland_Road</Street>";
                               xml += "<Country>United States</Country>";
                               xml += "<State>Pennsylvania</State>";
                               xml += "<City>Pittsburgh</City>";
                               xml += "<Status>Full-time</Status>";
                               xml += "<Phone>412-961-2098</Phone>";
                               xml += "<Email>VSS9@pitt.edu</Email>";
                               xml += "</Branch>";

                           xml += "</About>";
                           res.type("text/xml");
                           return xml;

                       } catch (Exception e) {
                           attributes.put("message", "There was an error: " + e);
                           return attributes;
                       } finally {
                           if (connection != null) try{connection.close();} catch(SQLException e){}
                       }
                   });
//post json
       post("/api/register", (req, res) -> {
                   Map<String, Object> data = new HashMap<>();
                   String firstname=req.queryParams("firstname");
                   String lastname = req.queryParams("lastname");
                   String username=req.queryParams("username");
                   String password = req.queryParams("password");
                   String confpassword=req.queryParams("confpassword");
                   String email = req.queryParams("email");
                   data.put("firstname", firstname);
                   data.put("lastname", lastname);
                   data.put("username", username);
                   data.put("password", password);
                   data.put("confpassword", confpassword);
                   data.put("email", email);

                         return data;
                     }, gson::toJson);
}
}
