
package com.Vicarious.Controller;

import com.Vicarious.DataModel.MaxMinValue;
import com.Vicarious.Service.VicariousServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/v1")
public class MyRESTController {

	 @Autowired
     //Service which will do all data retrieval/manipulation work
VicariousServiceI  vicariousService;
	
	
	@RequestMapping(value = "web/generate_number", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> putMyData(@ModelAttribute("maxMinValue")MaxMinValue maxMinValue
			) {
		
		int randomvalue=0;
		try {
		randomvalue=	vicariousService.getRandomInteger(maxMinValue.getMin(),maxMinValue.getMax());
		return new ResponseEntity<String>("{retval:"+randomvalue+"}", HttpStatus.OK);
		} catch (Exception ex) {
    		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND	

		}
		
		
		}
	
	@ModelAttribute("MaxMinValue")
	@RequestMapping(value = "generate_number", method = { RequestMethod.POST,  RequestMethod.GET })
	
	public ResponseEntity<String> test(@RequestParam(value = "maxMinValue",required = false) MaxMinValue maxMinValue,Model model) {
  //  public ResponseEntity<String> test(@RequestBody(required=false) MaxMinValue maxMinValue) {	
	
		int randomvalue=0;
    	try {
    	if(maxMinValue==null) {randomvalue=vicariousService.getRandomInteger();
    	return new ResponseEntity<String>("{retval:"+randomvalue+"}", HttpStatus.OK);
    	}
    	else { randomvalue=	vicariousService.getRandomInteger(maxMinValue.getMin(),maxMinValue.getMax());
    	return new ResponseEntity<String>("{retval:"+randomvalue+"}", HttpStatus.OK);
    	}
    	}catch (Exception ex) {
    		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND	
    	}
    	
  
    }
	
	
	
}