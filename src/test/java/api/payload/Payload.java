package api.payload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Payload {
	
	static String body;
	
	public static String getCountryCode()
	{
	     body ="{\r\n"
	    		+ "  \"PWSESSIONRS\": {\r\n"
	    		+ "    \"PWPROCESSRS\": {\r\n"
	    		+ "      \"PWHEADER\": {\r\n"
	    		+ "        \"IN_PROCESS_ID\": \"1\",\r\n"
	    		+ "        \"APP_ID\": \"ONEAPP\",\r\n"
	    		+ "        \"ORG_ID\": \"ONEAPP\",\r\n"
	    		+ "        \"OUT_PROCESS_ID\": \"oa_getCountryCode\",\r\n"
	    		+ "        \"LOGIN_ID\": \"\"\r\n"
	    		+ "      },\r\n"
	    		+ "      \"PWDATA\": {\r\n"
	    		+ "        \"oa_getCountryCode\": {\r\n"
	    		+ "          \"Row\": [\r\n"
	    		+ "            {\r\n"
	    		+ "              \"0\":\"IOS\"\r\n"
	    		+ "            }\r\n"
	    		+ "          ]\r\n"
	    		+ "        }\r\n"
	    		+ "      },\r\n"
	    		+ "      \"PWERROR\": \"\"\r\n"
	    		+ "    }\r\n"
	    		+ "  }\r\n"
	    		+ "}";
	    
	    return body;
	}
public static String Verify_dms()
{
		body ="{\r\n"
			+ "  \"PWSESSIONRS\": {\r\n"
			+ "    \"PWPROCESSRS\": {\r\n"
			+ "      \"PWHEADER\": {\r\n"
			+ "        \"IN_PROCESS_ID\": \"2\",\r\n"
			+ "        \"APP_ID\": \"ONEAPP\",\r\n"
			+ "        \"ORG_ID\": \"ONEAPP\",\r\n"
			+ "        \"OUT_PROCESS_ID\": \"oa_verifyDMS\",\r\n"
			+ "        \"LOGIN_ID\": \"\"\r\n"
			+ "      },\r\n"
			+ "      \"PWDATA\": {\r\n"
			+ "        \"oa_verifyDMS\": {\r\n"
			+ "          \"Row\": [\r\n"
			+ "            {\r\n"
			+ "            \"0\": \"7073711241\"\r\n"
			+ "            }\r\n"
			+ "          ]\r\n"
			+ "        }\r\n"
			+ "      },\r\n"
			+ "      \"PWERROR\": \"\"\r\n"
			+ "    }\r\n"
			+ "  }\r\n"
			+ "}";
	return body;
}
public static String Send_otp()
{
	body ="{\r\n"
			+ "  \"PWSESSIONRS\": {\r\n"
			+ "    \"PWPROCESSRS\": {\r\n"
			+ "      \"PWHEADER\": {\r\n"
			+ "        \"IN_PROCESS_ID\": \"1\",\r\n"
			+ "        \"APP_ID\": \"ONEAPP\",\r\n"
			+ "        \"ORG_ID\": \"ONEAPP\",\r\n"
			+ "        \"OUT_PROCESS_ID\": \"oa_sendOTP\",\r\n"
			+ "        \"LOGIN_ID\": \"\"\r\n"
			+ "      },\r\n"
			+ "      \"PWDATA\": {\r\n"
			+ "        \"oa_sendOTP\": {\r\n"
			+ "          \"Row\": [\r\n"
			+ "            {\r\n"
			+ "              \"0\":\"+91\",\r\n"
			+ "              \"1\":\"7073711241\"\r\n"
			+ "            }\r\n"
			+ "          ]\r\n"
			+ "        }\r\n"
			+ "      },\r\n"
			+ "      \"PWERROR\": \"\"\r\n"
			+ "    }\r\n"
			+ "  }\r\n"
			+ "}";
	return body;
	
}
public static String get_APIList(String path) throws FileNotFoundException
{

	File f = new File(path);
	FileReader fi = new FileReader(f);
	JSONTokener jt = new JSONTokener(fi);
	JSONObject data = new JSONObject(jt);
	String Stringdata = data.toString();
	return Stringdata;
}
}
