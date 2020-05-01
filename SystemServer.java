

import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SystemServer extends Thread {
	public void run(){};
	 static Patient xmlParse(String xmlData){ //takes File outputs patient object
	        String pid, a, m, ts, in, nc, dm, b, bq, i, ct, rid, sip, rip; //declare variables
	        pid=a=m=ts=in=nc=dm=b=bq=i=ct=rid=sip=rip=""; //initialize variables
	        pid = getBetween(xmlData, "<patient patientID=\"", "\">");
	        a = getBetween(xmlData, "<age>", "</age>");
	        m = getBetween(xmlData, "<menopause>", "</menopause>");
	        ts = getBetween(xmlData, "<tumor-size>", "</tumor-size>");
	        in = getBetween(xmlData, "<inv-nodes>", "</inv-nodes>");
	        nc = getBetween(xmlData, "<node-caps>", "</node-caps>");
	        dm = getBetween(xmlData, "<deg-malig>", "</deg-malig>");
	        b = getBetween(xmlData, "<breast>", "</breast>");
	        bq = getBetween(xmlData, "<breast-quad>", "</breast-quad>");
	        i = getBetween(xmlData, "<irradiat>", "</irradiat>");
	        ct = getBetween(xmlData, "<Class>", "</Class>");
	        rid = getBetween(xmlData, "<request requestID=\"", "\"");
	        sip = getBetween(xmlData, "senderIPAddress=\"", "\"");
	        rip = getBetween(xmlData, "receiverIPAddress=\"", "\"");

	        Patient patient = new Patient(pid, a, m, ts, in, nc, dm, b, bq, i, ct, rid, sip, rip); //create patient using constructor
	        return patient;
	}
	    static String getBetween(String input, String starttoken, String endtoken)
	    {
	        String output = "";
	        String regexString = starttoken + "(.*?)" + endtoken; 
	        Pattern pattern = Pattern.compile(regexString);
	        Matcher matcher = pattern.matcher(input);
	        if (matcher.find()) {
	             output = matcher.group(1); 
	            }
	            return output;
	    }
	    static String generateResult()
	    {
	    	Random r = new Random();
	    	int random = r.nextInt(1000);
	    	if(random%2 == 1)
	    	{
	    		return "recurrence-events";
	    	}
	    	else
	    	{
	    		return "no-recurrence-events";
	    	}
	    	
	    }
	    /*public void startserver() throws IOException
	    {
	    	int port = 3030;
	    	 try (ServerSocket serverSocket = new ServerSocket(port)) {
	    		 
	             System.out.println("Server is listening on port " + port);
	  
	             while (true) {
	                 Socket socket = serverSocket.accept();
	                 System.out.println("New client connected");
	  
	                 InputStream input = socket.getInputStream();
	                 BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	  
	                 OutputStream output = socket.getOutputStream();
	                 PrintWriter writer = new PrintWriter(output, true);
	  
	  
	                 String text=""; int  count = 0;
	                 
	                	 count += 1;
	                	 //System.out.print(count);
	                	 
	                	 text = reader.readLine();
	                	// System.out.println(text);  
	                	 if (text != null)
	                	 {
	                         Patient newpatient = xmlParse(text);
	                         String result = generateResult();
	                         String outputtext = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	                         outputtext += "<response requestID=\"" +newpatient.requestID+"\"";
	                         outputtext += " responseID=\"Group8\" senderIPAddress=\""+newpatient.senderIPAddress+"\"";
	                         outputtext += " receiverIPAddress=\""+newpatient.receiverIPAddress+"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"";
	                         outputtext += " xsi:noNamespaceSchemaLocation=\"response.xsd\"><diagnosis patientID=\""+newpatient.patientid+"\">";
	                         outputtext += "<opinion>"+result+"</opinion></diagnosis></response>";//new StringBuilder(text).reverse().toString();
	                         writer.println(outputtext);
	                         writer.flush();
	                	 }
	                
	                    // writer.println(text);
	               
	  
	                 socket.close();
	             }
	  
	         } catch (IOException ex) {
	             System.out.println("Server exception: " + ex.getMessage());
	             ex.printStackTrace();
	         }
	    }*/
    public static void main(String[] args) throws IOException {
    	
    	int port = 1010;
    	 try (ServerSocket serverSocket = new ServerSocket(port)) {
    		 
             System.out.println("Server is listening on port " + port);
  
             while (true) {
                 Socket socket = serverSocket.accept();
                 System.out.println("New client connected");
  
                 InputStream input = socket.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(input));
  
                 OutputStream output = socket.getOutputStream();
                 PrintWriter writer = new PrintWriter(output, true);
  
  
                 String text=""; int  count = 0;
                 
                	 count += 1;
                	 //System.out.print(count);
                	 
                	 text = reader.readLine();
                	// System.out.println(text);  
                	 if (text != null)
                	 {
                         Patient newpatient = xmlParse(text);
                         String result = generateResult();
                         String outputtext = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
                         outputtext += "<response requestID=\"" +newpatient.requestID+"\"";
                         outputtext += " responseID=\"Group8\" senderIPAddress=\""+newpatient.senderIPAddress+"\"";
                         outputtext += " receiverIPAddress=\""+newpatient.receiverIPAddress+"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"";
                         outputtext += " xsi:noNamespaceSchemaLocation=\"response.xsd\"><diagnosis patientID=\""+newpatient.patientid+"\">";
                         outputtext += "<opinion>"+result+"</opinion></diagnosis></response>";//new StringBuilder(text).reverse().toString();
                         writer.println(outputtext);
                         writer.flush();
                	 }
                
                    // writer.println(text);
               
  
                 socket.close();
             }
  
         } catch (IOException ex) {
             System.out.println("Server exception: " + ex.getMessage());
             ex.printStackTrace();
         }
    }
}