/**
 * 
 */
package Challengeapi.src.test;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author nilesh
 *
 */
public class SpringRestTestClient {

	 public static final String REST_SERVICE_URI = "http://localhost:8080/Challengeapi";
	/**
	 * 
	 */
	public SpringRestTestClient() {
		// TODO Auto-generated constructor stub
	}

	 /* GET */
	  
	private static void getrandomnum() {
	
	RestTemplate restTemplate = new RestTemplate();
    	String returndata= 	restTemplate.getForObject(REST_SERVICE_URI+"/v1/generate_number.json", String.class);
	if(returndata!=null){
		System.out.println("via Resttemplate"+returndata);
		
    }else{
        System.out.println("No returndata exist- in getrandomnum---------");
    }
	
	
	

}

	 /* POST */
    private static void postrandomnum() {
    	 System.out.println("Testing postrandomnum----------");
    	 RestTemplate restTemplate=null;
    	 restTemplate = new RestTemplate();
   	 MultiValueMap<String, Integer> map = new LinkedMultiValueMap<String, Integer>();
    	 map.add("max", 19);
    	 map.add("min", 0);
    	
    	 HttpHeaders headers = new HttpHeaders();
    	 headers.setContentType(MediaType.APPLICATION_JSON);

    	 final HttpEntity<MultiValueMap<String, Integer>> entity = new HttpEntity<MultiValueMap<String, Integer>>(map , headers);
  
    	 try {
    	      restTemplate = new RestTemplate();
    	    
    	     ResponseEntity<String> responseEntity = restTemplate.exchange(
     	    		REST_SERVICE_URI+"/v1/generate_number", HttpMethod.POST, entity,String.class);
      	     System.out.println(responseEntity.getClass());
    	     System.out.println(responseEntity.getStatusCode());
    
    	  }	catch(Exception ex) {
    		  
       	   System.out.println(ex.getMessage());
       	 
    	  }
     /*  	URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/v1/generate_number/", map, String.class);
        System.out.println("Location : "+uri.toASCIIString());
 */      	   
       	   
       	    }
    
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		getrandomnum();
    	postrandomnum();

	}

}
