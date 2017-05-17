package gauravg.tasktriggerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskTriggerController {
	
	@Autowired
	private TaskProcessor t;
	
		//pass in POST payload values
		@RequestMapping(path = "/tasks/{color}", method = RequestMethod.POST)
		public @ResponseBody String launchTask(@RequestBody String s, @PathVariable String color) {
			
			System.out.println("request made done");
			
			t.publishRequest(s, color);
			
			System.out.println("request made");
			
			return "success";
		}
}
