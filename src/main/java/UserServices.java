import java.util.ArrayList;
import java.util.List;

public class UserServices {
	private List<User> users = new ArrayList<User>();
			UserServices(){
		users.add(new User("761","SYSTEM ADMISNISTRATOR"));
		users.add(new User("276","DBA"));
			users.add(new User("776","WEB-DEVELOPER"));
				users.add(new User("976","register-Nurse"));
					users.add(new User("278","REGIONAL-MANAGER "));
	}


	  // returns a list of all stocks
	  public List<User> getAllUsers() {
		  return users;
	  }

	  // returns a single stock by id
	  public User getUser(String id) {
		  for(int i = 0; i<users.size();i++){
			  if(users.get(i).getId()==id){
				  return users.get(i);
			  }
		  }
		  return null;
	  }
}
