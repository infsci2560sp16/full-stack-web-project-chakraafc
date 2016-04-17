import java.util.ArrayList;
import java.util.List;

public class UserServices {
	private List<User> users = new ArrayList<User>();
			UserServices(){
		users.add(new User("1","Vanguard U.S. Total Stock Market Index ETF (VTI)"));
		users.add(new User("2","Vanguard US Large-Cap Value Index ETF (VTV)"));
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
