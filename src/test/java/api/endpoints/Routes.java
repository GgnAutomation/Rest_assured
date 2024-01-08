package api.endpoints;

/* get-https://petstore.swagger.io/v2/user/{username}
   post-https://petstore.swagger.io/v2/user
   put-get-https://petstore.swagger.io/v2/user/{username}
   delete-get-https://petstore.swagger.io/v2/user/{username}
*/
public class Routes {

	public static String base_url ="https://petstore.swagger.io/v2/";
	public static String Base_url ="https://hero-one-app-uat.azurewebsites.net/api/cloudware_prod?ORG_ID=ONEAPP";
	public static String post_url =base_url + "user";
	public static String common_url = base_url+"user/{username}";  

	
}
