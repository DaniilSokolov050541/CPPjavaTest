package javaApi.timeToTravel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("api")
//http://localhost:8080/api/time-to-travel?distance=50&speed=10
public class timeToTravelController {
	@RequestMapping(value = "/time-to-travel", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> calculate(@RequestParam(value="distance", required=true) int distance,
		    @RequestParam(value="speed", required=true) int speed) {
		//String result = "{\"Result\": ";
		String result = "Result";
		JsonObject jsonResult = new JsonObject();
		if(distance < 1 || speed < 1) {
			jsonResult.addProperty(result, "Input parameters are set incorrectly");
			return new ResponseEntity<>(jsonResult.toString(), HttpStatus.BAD_REQUEST); 
		}
		jsonResult.addProperty(result, "Time to travel a given distance at a given speed");	
		jsonResult.addProperty("Value", (distance/speed));
		return ResponseEntity.ok(jsonResult.toString());
		/*return distance < 1 || speed < 1
				? new ResponseEntity<>(result + "\"Input parameters are set incorrectly\"}", HttpStatus.BAD_REQUEST)
				: ResponseEntity.ok(result + "\"Time to travel a given distance at a given speed\", \"Value\": " + (distance/speed) + "}");*/
	}
}
