import com.google.gson.Gson;

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

import static javax.measure.unit.SI.KILOGRAM;
import javax.measure.quantity.Mass;
import org.jscience.physics.model.RelativisticModel;
import org.jscience.physics.amount.Amount;

import static javax.measure.unit.SI.KILOGRAM;
import javax.measure.quantity.Mass;
import org.jscience.physics.model.RelativisticModel;
import org.jscience.physics.amount.Amount;

import com.heroku.sdk.jdbc.DatabaseUrl;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    Gson gson = new Gson();

    get("/hello", (req, res) -> "Hello World");

    get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

    get("/db", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB: " + rs.getTimestamp("tick"));
        }

        attributes.put("results", output);
        return new ModelAndView(attributes, "db.ftl");
      } catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
    }, new FreeMarkerEngine());


    post("/adduser",(req,res)->

        {

          Connection connection = null;
          Map<String, Object> attributes = new HashMap<>();
          try{
          connection = DatabaseUrl.extract().getConnection();

          JSONObject obj = new JSONObject(req.body());


          String firstname = obj.getString("register-fname");
          String lastname = obj.getString("register-lastname");
          String address = obj.getString("register-address");
          String city = obj.getString("register-city");
          String state = obj.getString("register-state");
          String zipcode = obj.getString("register-zipcode");
          String employeeid = obj.getString("register-employeeid");
          String email = obj.getString("register-email");
          String pass = obj.getString("register-password");


         Statement stmt = connection.createStatement();
         stmt.executeUpdate("CREATE TABLE IF NOT EXISTS userdata (user_fname varchar(100),  user_lname  varchar(30),  user_address  varchar(100), user_city varchar(30), user_state varchar(30), user_zipcode varchar(10), user_employeeid varchar(5), user_email varchar(100), user_pass varchar(30) )");

         stmt.executeUpdate("INSERT INTO userdata(user_fname, user_lname, user_address, user_city, user_state, user_zipcode, user_employeeid, user_email, user_pass)" +
                  "VALUES('" + firstname+ "', '" + lastname + "','" + address + "','" + city + "','" + state + "','" + zipcode + "','" + employeeid + "','" + email + "' ,'" + pass+"')");
         return req.body();
         } catch (Exception e) {
           System.err.println("Exception: "+ e);
            return e.getMessage();
         } finally {
          if (connection != null) try{connection.close();} catch(SQLException e){}
        }});



        get("/api/salary", (req, res) -> {

                   Map<String, Object> data = new HashMap<>();
                   data.put("experience","salary estimate");
                   data.put("from3to5yrs", "6k-7k");
                   data.put("from0to1yrs", "1k-2k");
                   data.put("from4to10yrs ", "8k-10k");
                   return data;
               }, gson::toJson);


               get("/api/info", (req, res ) ->
                   {
                     Map<String, Object> data = new HashMap<>();
                     data.put("username","Smith");
                     String xml= "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                                 "<customer>"+
                                 "<user_profile>" +
                                         "<ProductName>Air Froce 1</ProductName>"+
                                         "<January>100</January>"+
                                         "<Febuary>200</Febuary>"+
                                         "<March>300</March>"+
                                 "</user_profile>"+
                                 "<user_profile>" +
                                         "<ProductName>KOBE XI</ProductName>"+
                                         "<January>312</January>"+
                                         "<Febuary>1333</Febuary>"+
                                         "<March>433</March>"+
                                 "</user_profile>"+
                                 "<user_profile>" +
                                         "<ProductName>Lebron XIII</ProductName>"+
                                         "<January>4324</January>"+
                                         "<Febuary>41</Febuary>"+
                                         "<March>5454</March>"+
                                 "</user_profile>"+
                                 "</customer>";
                     res.type("text/xml");
                     return xml;
                   });

  }

}

    //ftl
    /* get("/index1", (req, res) -> {
            Map<String, Object> attributes = new HashMap<>();


            ArrayList<String> technology= new ArrayList<String>();
            technology.add("DBA");
            technology.add("web developer");
            technology.add("network admin");
            technology.add("data analyst");

            ArrayList<String> healthworker= new ArrayList<String>();
            healthworker.add("CNA");
            healthworker.add("Register Nurse");
            healthworker.add("house keeping");
            healthworker.add("health assistant");

            ArrayList<String> admin= new ArrayList<String>();
            admin.add("HR manager");
            admin.add("accountant");
            admin.add("branch manager");
            admin.add("tech manager");

            //SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
          //  String jobAtIdeal = formatter.format();

            System.out.println(jobAtIdeal);
            System.out.println(admin);


            attributes.put("technology", technology);
            attributes.put("healthworker", healthworker);
            attributes.put("admin", admin);
            attributes.put("jobAtIdeal", jobAtIdeal);

            return new ModelAndView(attributes, "index1.ftl");
    } , new FreeMarkerEngine());

   Gson gson = new Gson();
    //GET JSON
    get("api/find", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
        //stmt.executeUpdate("CREATE TABLE IF NOT EXISTS employeedata");
         //stmt.executeUpdate("INSERT INTO employeedata (firstname,id,salary,increment,bonus)
         	//	 VALUES('john','e555','10 k','10%', '5k'));
        ResultSet rs = stmt.executeQuery("SELECT firstname, id, salary, increment, bonus FROM employeedata");

        //Map<String, Object> data = new HashMap<>();
        //ArrayList<String> output = new ArrayList<String>();
        List<Object> data = new ArrayList<>();
        while (rs.next()) {
          Map<String, Object> member = new HashMap<>();
          member.put("firstname", rs.getString("firsrname"));
          member.put("employeeid", rs.getString("employeeid"));
          member.put("salary", rs.getString("salary"));
          member.put("increment", rs.getString("increment"));
          member.put("bonus", rs.getString("bonus"));
          //data.put(rs.getString("username"), member);
          data.add(member);
        }
        return data;
        //attributes.put("results", output);
        //return new ModelAndView(attributes, "db.ftl");
      } catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
    },  gson::toJson);


  //POST JSON
    post("/register", (req, res) -> {
          Connection connection = null;
          //Testing
          System.out.println(req.body());
        try {
          connection = DatabaseUrl.extract().getConnection();
         JSONObject obj = new JSONObject(req.body());
          String firstname = obj.getString("firstname");
          String lastname = obj.getString("lastname");
          String address = obj.getString("address");
          String city = obj.getString("city");
          String state = obj.getString("state");
          String zipcode = obj.getString("zipcode");

          String employeeid = obj.getString("employeeid");
          String email = obj.getString("email");
          String pass = obj.getString("pass");
          String sql = "INSERT INTO employeedata VALUES ('"+ firstname + "','" + lastname + "','"
          + address + "','" + city + "','"+ state + "','" + zipcode + "','"+ employeeid + "','" + email + "',' "+ pass +" ')";

          connection = DatabaseUrl.extract().getConnection();
          Statement stmt = connection.createStatement();
          stmt.executeUpdate(sql);

          ResultSet rs = stmt.executeQuery("SELECT * FROM employeedata where firstname ='" + firstname + "'");
          Map<String, Object> currentuser = new HashMap<>();

					currentuser.put("firstname", rs.getString("firstname"));
					currentuser.put("email", rs.getString("email"));

          return currentuser;
        //  return req.body();
        } catch (Exception e) {
          return e.getMessage();
        } finally {
          if (connection != null) try{connection.close();} catch(SQLException e){}
        }
      });



  //GET XML
    get("api/forum", (req, res) -> {

        Connection connection = null;
        res.type("application/xml"); //Return as XML

        Map<String, Object> attributes = new HashMap<>();
        try {
            //Connect to Database and execute SQL Query
            connection = DatabaseUrl.extract().getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT firstname,lastname,threads.address,threads.employeeid,country FROM employeedata,threads WHERE employeedata.email=threads.email");


            String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
            xml += "<form xmlns:xsi=\"http://www.w3.org/2001/XMLSchema\" xsi:SchemaLocation=\"form.xsd\">";
            while (rs.next()) {
            xml += "<thread>";
						  xml += "<firstname>"+rs.getString("firstname")+"</firstname>";
						  xml += "<lastname>"+rs.getString("lastname")+"</lastname>";
						  xml += "<address>"+rs.getString("address")+"</address>";
						  xml += "<employeeid>"+rs.getString("employeeid")+"</employeeid>";

					    xml += "</thread>";
            }
            xml += "</form>";
            res.type("text/xml");
            return xml;

        } catch (Exception e) {
            attributes.put("message", "There was an error: " + e);
            return attributes;
        } finally {
            if (connection != null) try{connection.close();} catch(SQLException e){}
        }
      });//End /form
*/
