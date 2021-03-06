 
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
 
/**
 * This program demonstrates how to use JPanel in Swing.
 * @author www.codejava.net
 */
public class UserInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel age = new JLabel("Age: ");
    private JLabel menopause = new JLabel("Menopause: ");
    private JLabel tumor_size = new JLabel("Tumor-size: ");
    private JLabel inv_nodes = new JLabel("Inv-nodes: ");
    private JLabel node_caps = new JLabel("Node-caps: ");
    private JLabel deg_malig = new JLabel("Deg_malig: ");
    private JLabel breast = new JLabel("Breast: ");
    private JLabel breast_quad = new JLabel("Breast_quad: ");
    private JLabel irradiat = new JLabel("Irradiat: ");
    private JLabel Result = new JLabel("Result:  ");
    private JLabel Server1 = new JLabel("Server1(:1010):  ");
    private JLabel Server2 = new JLabel("Server2(:2020):  ");
    private JLabel Server3 = new JLabel("Server3(:3030):  ");
    private JLabel Server4 = new JLabel("Server4(:4040):  ");

    private JTextField resultvalue = new JTextField(20);    
    private JTextField servervalue1 = new JTextField(20);    
    private JTextField servervalue2 = new JTextField(20);    
    private JTextField servervalue3 = new JTextField(20);    
    private JTextField servervalue4 = new JTextField(20);    

    String[] ageoptions = { "","0-9", "10-19", "20-29", "30-39", "40-49","50-59","60-69",
    		"70-79","80-89","90-99"};
    String[] menopauseoptions = {"", "ge40","lt40", "premeno"};
    String[] tumor_sizeoptions = {"", "0-4", "5-9","10-14","15-19","20-24","25-29",
    		"30-34","35-39","40-44","45-49","50-54","55-59"};
    String[] inv_nodesoptions = { "","0-2", "3-5","6-8","9-11","12-14","15-17",
    		"18-20","21-23","24-26"};
    String[] deg_maligoptions = {"","1", "2", "3"};
    String[] breast_quadoptions = {"","left-up", "left-low","right-up","right-low","central"};
    String[] breastoptions = {"left", "right"};
    String[] irradiaitoptions = {"", "yes", "no"};
    String[] node_capsoptions = {"", "yes", "no"};

  //Create the combo box, select item at index 4.
  //Indices start at 0, so 4 specifies the pig.
  JComboBox ageList = new JComboBox(ageoptions);
  JComboBox menopauseList = new JComboBox(menopauseoptions);
  JComboBox tumor_sizeList = new JComboBox(tumor_sizeoptions);
  JComboBox deg_maligList = new JComboBox(deg_maligoptions);
  JComboBox inv_nodesList = new JComboBox(inv_nodesoptions);
  JComboBox breast_quadList = new JComboBox(breast_quadoptions);
  JComboBox breastList = new JComboBox(breastoptions);
  JComboBox irradiatList = new JComboBox(irradiaitoptions);
  JComboBox node_capsList = new JComboBox(node_capsoptions);

    private JButton buttonLogin = new JButton("Submit");

    public UserInterface() {
        super("Operation: Zero");
         
        // create a new panel with GridBagLayout manager
        JPanel newPanel = new JPanel(new GridBagLayout());
         
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
         
        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;     
        newPanel.add(age, constraints);
 
        constraints.gridx = 1;
        newPanel.add(ageList, constraints);
         
       constraints.gridx = 2;
        constraints.gridy = 0;     
        newPanel.add(menopause, constraints);
        constraints.gridx = 3;
        constraints.gridy = 0;
        newPanel.add(menopauseList, constraints);
       
        constraints.gridx = 4;
        constraints.gridy = 0;     
        newPanel.add(Server1, constraints);
        constraints.gridx = 5;
        constraints.gridy = 0;
        newPanel.add(servervalue1, constraints);
       
        
        constraints.gridx = 0;
        constraints.gridy = 1;     
        newPanel.add(tumor_size, constraints);
         
        constraints.gridx = 1;
        newPanel.add(tumor_sizeList, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 1;     
        newPanel.add(inv_nodes, constraints);
         
        constraints.gridx = 3;
        constraints.gridy = 1;   
        newPanel.add(inv_nodesList, constraints);
        

        constraints.gridx = 4;
        constraints.gridy = 1;     
        newPanel.add(Server2, constraints);
        constraints.gridx = 5;
        constraints.gridy = 1;
        newPanel.add(servervalue2, constraints);
       
        
        
        
        constraints.gridx = 0;
        constraints.gridy = 3;     
        newPanel.add(node_caps, constraints);
         
        constraints.gridx = 1;
        constraints.gridy = 3;   
        newPanel.add(node_capsList, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 3;     
        newPanel.add(deg_malig, constraints);
         
        constraints.gridx = 3;
        constraints.gridy = 3;   
        newPanel.add(deg_maligList, constraints);
        
        constraints.gridx = 4;
        constraints.gridy = 3;     
        newPanel.add(Server3, constraints);
        constraints.gridx = 5;
        constraints.gridy = 3;
        newPanel.add(servervalue3, constraints);
       
        
        
        constraints.gridx = 0;
        constraints.gridy = 4;     
        newPanel.add(breast, constraints);
         
        constraints.gridx = 1;
        constraints.gridy = 4;   
        newPanel.add(breastList, constraints);
       
        constraints.gridx = 2;
        constraints.gridy = 4;     
        newPanel.add(breast_quad, constraints);
         
        constraints.gridx = 3;
        constraints.gridy = 4;   
        newPanel.add(breast_quadList, constraints);
        
        constraints.gridx = 4;
        constraints.gridy = 3;     
        newPanel.add(Server3, constraints);
        constraints.gridx = 5;
        constraints.gridy = 3;
        newPanel.add(servervalue3, constraints);
       
        
        constraints.gridx = 0;
        constraints.gridy = 5;     
        newPanel.add(irradiat, constraints);
         
        constraints.gridx = 1;
        constraints.gridy = 5;   
        newPanel.add(irradiatList, constraints);
     
        constraints.gridx = 2;
        constraints.gridy = 5;     
        newPanel.add(Result, constraints);
         
        constraints.gridx = 4;
        constraints.gridy = 4;     
        newPanel.add(Server4, constraints);
        constraints.gridx = 5;
        constraints.gridy = 4;
        newPanel.add(servervalue4, constraints);
       
        
        constraints.gridx = 3;
        constraints.gridy = 5;   
        resultvalue.setEditable(false);
        newPanel.add(resultvalue, constraints);
         
        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(buttonLogin, constraints);
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            	String agedata = (String)ageList.getSelectedItem();
            	String menopausedata = (String)menopauseList.getSelectedItem();
            	String tumor_sizedata = (String)tumor_sizeList.getSelectedItem();
            	String inv_nodesdata = (String)inv_nodesList.getSelectedItem();
            	String node_capsdata = (String)node_capsList.getSelectedItem();
            	String deg_maligdata = (String)deg_maligList.getSelectedItem();
            	String breastdata = (String)breastList.getSelectedItem();
            	String breast_quaddata = (String)breast_quadList.getSelectedItem();
            	String irradiatdata = (String)irradiatList.getSelectedItem();
                String hostname;
                String result = "";
                String serverlistArray[] = {"localhost","localhost","localhost","localhost"};
                int portlist[] = {1010,2020,3030,4040};

                String serverResultArray[] = {"","","",""};
       	     for (int i =0;i<serverlistArray.length;i++)
             {
          
   				try {
   		
              	   

   					hostname = InetAddress.getLocalHost().getHostName();
   					Patient newpatient = new Patient("Patient0016X",agedata,menopausedata,tumor_sizedata,inv_nodesdata,node_capsdata,deg_maligdata,breastdata,breast_quaddata,irradiatdata,"","#0016","localhost", serverlistArray[i]);
   	            	//ServerObject server1= new ServerObject("localhost",2020,newpatient);
   	            	try (Socket socket = new Socket(serverlistArray[i], portlist[i])) {
   	                	 OutputStream output = socket.getOutputStream();
   	                     PrintWriter writer = new PrintWriter(output, true);

   	                    String text;
   	                    text = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><request requestID=\""+newpatient.requestID+"\"";
   	                    text += " senderIPAddress=\"" +"localhost"+"\" receiverIPAddress=\""+newpatient.receiverIPAddress+"\"  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"";
   	                    text+=" > <patient patientID=\""+newpatient.patientid+"\"> <age>"+newpatient.age+"</age> ";
   	                    text += "<menopause>" +newpatient.menopause+ "</menopause>";
   	                    text +="<tumor-size>"+newpatient.tumor_size+"</tumor-size>";
   	                    text += "<inv-nodes>"+newpatient.inv_nodes+"</inv-nodes>";
   	                    text += "<node-caps>" + newpatient.node_caps+ "</node-caps>";
   	                    text += " <deg-malig>" + newpatient.deg_malig+ "</deg-malig>";
   	                    text += "<breast>"+newpatient.breast+"</breast>";
   	                    text += "<breast-quad>" + newpatient.breast_quad + "</breast-quad>";
   	                    text += "<irradiat>" + newpatient.irradiat+ "</irradiat></patient></request>";	                    
   	                       writer.println(text);
   	                       InputStream input = socket.getInputStream();
   	                       BufferedReader reader = new BufferedReader(new InputStreamReader(input));
   	                       String x = "";
   	                  
   	                        result = getBetween(reader.readLine(),"<opinion>","</opinion>");
   	                     serverResultArray[i] = result;
   	                     setServerResult(i,result);
   	                    socket.close();
   	            	}
   	         
   	                
   				catch (UnknownHostException ex) {
   	         
   	                    System.out.println("Server not found: " + ex.getMessage());
     	                 serverResultArray[i] = "Server not found: " + ex.getMessage();
	                     setServerResult(i,serverResultArray[i] );

   	                 //	resultvalue.setText("Server not found: " + ex.getMessage());

   	         
   	                } catch (IOException ex) {
   	         
   	                    System.out.println("I/O error: " + ex.getMessage());
   	                 serverResultArray[i] = "I/O error: " + ex.getMessage();
	                     setServerResult(i,serverResultArray[i] );

   	                }
                 
   	         
   				} catch (UnknownHostException e) {
   					// TODO Auto-generated catch block
   					e.printStackTrace();
   				}
   				}
               
               int yescount = 0;
               int nocount = 0;
          /*   servervalue1.setText(serverResultArray[0]);
             servervalue2.setText(serverResultArray[1]);
             servervalue3.setText(serverResultArray[2]);
             servervalue4.setText(serverResultArray[3]);*/

               for(int j =0 ;j<serverlistArray.length;j++)
             {
            	 if(serverResultArray[j].equals("recurrence-events"))
            	 {
            		 yescount += 1;
            	 }
            	 else if(serverResultArray[j].equals("no-recurrence-events"))
            	 
            	 {
            		 nocount +=1;
            	 }	
             }
             System.out.println(yescount + " vs " + nocount);
             if (yescount > nocount)
             {
            	    resultvalue.setForeground(Color.red);

                    resultvalue.setText("recurrence-events");
             }
             else if(nocount > yescount)
             {
         	    resultvalue.setForeground(Color.green);

                 resultvalue.setText("no-recurrence-events");
             }
             else if(nocount == yescount && nocount > 0 )
             {
          	    resultvalue.setForeground(Color.blue);

                 resultvalue.setText("50% v.s. 50%");
             }
             else
             {
                 resultvalue.setText(serverResultArray[0]);
             }
                 	
              
            	// do everything here...
            }
        });
        // set border for the panel
        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Breast Cancer Diagnoser"));
         
        // add the panel to this frame
        add(newPanel);
         
        pack();
        setLocationRelativeTo(null);

    }
    void setServerResult(int i, String text)
    {
    	switch(i)
    	{
    	case 0:
    		servervalue1.setText(text);break;
    	case 1:
    		servervalue2.setText(text);break;
    	case 2:
    		servervalue3.setText(text);break;
    	case 3:
    		servervalue4.setText(text);break;
    		default:
    	}
    
    }

    String getBetween(String input, String starttoken, String endtoken)
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
    public static void main(String[] args) throws IOException  {           
    	SystemServer sserver = new SystemServer();            
        // set look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
           // sserver.startserver();

       	 Thread serverThread = new Thread(new Runnable() {
       		  @Override
       		  public void run() {
       			try {
					sserver.main(args);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
       		  }
       		});
       		
       		serverThread.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }

}