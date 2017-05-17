package gauravg.tasktriggerdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class TaskProcessor {

	@Autowired
	private Source source;

	public void publishRequest(String payload, String color) {

		//maven://[groupid]:[artifactid]:jar:[version]		
		String redUrl = "maven://gauravg.springclouddemo:springcloud-red-task:jar:0.0.1-SNAPSHOT";		
		String blueUrl = "maven://gauravg.springclouddemo:springcloud-blue-task:jar:0.0.1-SNAPSHOT";

		List<String> input = new ArrayList<String>(Arrays.asList(payload.split(",")));
		
		if(color.equals("red")) {
				TaskLaunchRequest request = new TaskLaunchRequest(redUrl, input, null, null);
				GenericMessage<TaskLaunchRequest> message = new GenericMessage<>(request);
				this.source.output().send(message);
			}
			
		if(color.equals("blue")) {
				TaskLaunchRequest request = new TaskLaunchRequest(blueUrl, input, null, null);
				GenericMessage<TaskLaunchRequest> message = new GenericMessage<>(request);
				this.source.output().send(message);
			}
//		System.out.println("created task launch request ...");
//		
//		GenericMessage<TaskLaunchRequest> message = new GenericMessage<>(request);
//		
//		this.source.output().send(message);
	}

}
