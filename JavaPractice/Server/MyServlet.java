package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.*;

public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Request : "+ req.getRequestURL());
		
		res.setStatus(200);
		res.getWriter().write(new Date().toString());
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Request : "+ req.getRequestURL());
		////////////////////////////////////////////////
		File destFolder = new File("./OUTPUT");
		if(!destFolder.exists()) {
		    destFolder.mkdirs(); 
		}
		
		LocalTime currentTime = LocalTime.now();
		String fname = String.format("./OUTPUT/%02d%02d%02d.json", currentTime.getHour(), currentTime.getMinute(), currentTime.getSecond());
	    PrintWriter printWriter = new PrintWriter(new FileWriter(new File(fname)));
	    
        BufferedReader input = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String buffer;
        while ((buffer = input.readLine()) != null) {
        	printWriter.print(buffer);
        }        
		input.close();		
		printWriter.close();
		/////////////////////////////////////////////////
		
		res.setStatus(200);
		res.getWriter().write(fname + " saved!");
	}

	void doPostSample2(){
	String requestString = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
	CommandRequest requestData = this.gson.fromJson(requestString, CommandRequest.class);
	switch (request.getPathInfo()) {
	case "/fromServer":
		List<String> result = new ArrayList<>();
			for (String targetDevice : requestData.getTargetDevice()) {
			DeviceInfo deviceInfo = this.deviceInfoMap.get(targetDevice);
			String forwardCommand = this.serverCommandInfoMap.get(requestData.getCommand()).getForwardCommand();
				String commandResponse = null;
			try {
				commandResponse = sendPostRequest(
						String.format("http://%s:%d/fromEdge", deviceInfo.getHostname(), deviceInfo.getPort()),
						new CommandRequest(forwardCommand, null, requestData.getParam()).toJson(gson));
			} catch (Exception e) {
				e.printStackTrace();
			}
			CommandResponse responseFromDevice = gson.fromJson(commandResponse, CommandResponse.class);
			result.addAll(responseFromDevice.getResult());
		}
		response.setStatus(200);
		response.getWriter().write(new CommandResponse(result).toJson(gson));
			break;
		}
	}


	private String sendPostRequest(String url, String content) throws Exception {
	HttpClient httpClient = new HttpClient();
	httpClient.start();
	try {
		org.eclipse.jetty.client.api.Request request = httpClient.POST(url);
		request.header(HttpHeader.CONTENT_TYPE, "application/json");
		request.content(new StringContentProvider(content, "utf-8"));
		ContentResponse response = request.send();
		return new String(response.getContent());
	} catch (ExecutionException executionException) {
		executionException.printStackTrace();
	} finally {
		httpClient.stop();
	}
	return null;
	}
}
