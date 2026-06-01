package stepdefinition;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class DataTableStepDefinition2 {
	
	@Given("I have usernames")
	public void i_have_usernames(DataTable dataTable) {

	   List<String> table = dataTable.asList();
	   
	 
	   
	   for(String table1 : table)
	   {
		   System.out.println(table1);
	   }
	   
	   List<String> users = dataTable.asList(String.class);

	   for(int i=1;i<users.size();i++) {
	       System.out.println(users.get(i));
	   }
	   
	}
	
	
	@Given("I have user data")
	public void i_have_user_data(DataTable dataTable) {

	    List<List<String>> data = dataTable.asLists();

	    for(List<String> row : data) {
	        System.out.println(row);
	    }
	    
	    System.out.println(data.get(1).get(0)); // Amar
	    System.out.println(data.get(2).get(2)); // Delhi
	}
	
	@Given("user details")
	public void user_details(DataTable dataTable) {

	    Map<String, String> map =
	            dataTable.asMap(String.class, String.class);

	    System.out.println(map.get("Username"));
	    System.out.println(map.get("Password"));
	    System.out.println(map.get("Role"));
	}
	
	@Given("user records")
	public void user_records(DataTable dataTable) {

	    List<Map<String, String>> users =
	            dataTable.asMaps(String.class, String.class);

	    for(Map<String, String> user : users) {

	        System.out.println("Username: " +
	                user.get("Username"));

	        System.out.println("Password: " +
	                user.get("Password"));

	        System.out.println("Role: " +
	                user.get("Role"));

	        System.out.println("----------------");
	    }
	}
	
	

}
