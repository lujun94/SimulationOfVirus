import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.PriorityQueue;
import java.lang.Comparable;
import java.util.Hashtable;

class Pair{
	public int s1;
	public int s2;
	
	public Pair( int n1, int n2){
		s1=n1;
		s2=n2;
	}
	
	public int getF(){
		return s1;
	}

	public int getS(){
		return s2;
	}
	
}

class tuple{
	public int s1;
	public int s2;
	public int c;
	
	public tuple( int n1, int n2, int n3){
		s1=n1;
		s2=n2;
		c =n3;
	}
	
	public int getF(){
		return s1;
	}

	public int getS(){
		return s2;
	}
	public int getT(){
		return c;
	}
	
	public void setT(int n){
		this.c =n;
	}
}

class event implements Comparable{
	public int studentId;
	public int time;
	public int action;
	
	public event( int s, int t, int a){
		studentId = s;
		time = t;
		action = a;
	}
	public int getstudentId(){
		return studentId;
	}
	
	public int getTime() {
	    return time;
	}
	
	public int getAction() {
	    return action;
	}
	
	public String toString(){
		return String.format("%d, %d, %d",studentId, time, action);
	}
	
	public int compareTo(Object otherEvent) throws ClassCastException {
	    int otherEventTime = ((event) otherEvent).getTime();
	    return this.time- otherEventTime;
	}
}

public class Stimulation {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    
    
    final private String host = "xxxxxxxxx";
    final private String user = "xxxxxxxxx";
    final private String passwd = "xxxxxxxxx";
    final private String database = "xxxxxxxxx";
    
    
    public ArrayList<ArrayList> MWFs = new ArrayList<ArrayList>(2400);
    public ArrayList<ArrayList> TTs = new ArrayList<ArrayList>(2400);
    public ArrayList<ArrayList> SSs = new ArrayList<ArrayList>(2400);

    public void connectToDB() throws Exception {
            try {
                    // This will load the MySQL driver, each DB has its own driver
                    Class.forName("com.mysql.jdbc.Driver");

                    // Setup the connection with the DB
                    connect = DriverManager.getConnection("jdbc:mysql://" + host + "/"
                                    + database + "?" + "user=" + user + "&password=" + passwd);

            } catch (Exception e) {
                    throw e;
            }
    }
    
    public void arryGen() throws Exception{
    	
    	for(int s=0; s<2400; s++){// each student 8354- 10753
    		int studentId = s+8354;
    		ArrayList<Integer> SInClassMWF = new ArrayList<Integer>();// List of places the student has
    		ArrayList<Integer> SInClassTT = new ArrayList<Integer>();
    		ArrayList<Integer> SInClassSS = new ArrayList<Integer>();
    		//MWF
    		statement = connect.createStatement(); 
	        resultSet = statement
	        		.executeQuery("select `place`, `hour` from `Schedule` where `student id`=" + studentId + " and day= 'MWF'") ;
            ArrayList<ArrayList> placeBeenMWF = new ArrayList<ArrayList>();// List of places the student has been in the day
            while (resultSet.next()) {
            	int Pid = resultSet.getInt("place");
            	int Hour = resultSet.getInt("hour");
            	ArrayList<Integer> Pair = new ArrayList<Integer>(2);
            	Pair.add(Pid);
            	Pair.add(Hour);
            	placeBeenMWF.add(Pair);
            }
            for(int i1=0; i1< placeBeenMWF.size(); i1++){ 
            	//System.out.println("Place Work");
            	int placeInf =  (Integer) placeBeenMWF.get(i1).get(0);
            	int hourInf = (Integer) placeBeenMWF.get(i1).get(1);           	
        		statement = connect.createStatement();
        		resultSet = statement
                            .executeQuery("select `student id` from `Schedule` where `hour`=" + hourInf+ " and `place`=" + placeInf + " and day= 'MWF' ");
                while (resultSet.next()) {
                	int Sid1 = resultSet.getInt("student id");
                	SInClassMWF.add(Sid1); 
                }
            }
            
            //TT
            statement = connect.createStatement(); 
	        resultSet = statement
	        		.executeQuery("select `place`, `hour` from `Schedule` where `student id`=" + studentId + " and day= 'TT'") ;
            ArrayList<ArrayList> placeBeenTT = new ArrayList<ArrayList>();// List of places the student has been in the day
            while (resultSet.next()) {
            	int Pid = resultSet.getInt("place");
            	int Hour = resultSet.getInt("hour");
            	ArrayList<Integer> Pair = new ArrayList<Integer>(2);
            	Pair.add(Pid);
            	Pair.add(Hour);
            	placeBeenTT.add(Pair);
            }
            for(int i1=0; i1< placeBeenTT.size(); i1++){ 
            	//System.out.println("Place Work");
            	int placeInf =  (Integer) placeBeenTT.get(i1).get(0);
            	int hourInf = (Integer) placeBeenTT.get(i1).get(1);           	
        		statement = connect.createStatement();
        		resultSet = statement
                            .executeQuery("select `student id` from `Schedule` where `hour`=" + hourInf+ " and `place`=" + placeInf + " and day= 'TT' ");
                while (resultSet.next()) {
                	int Sid1 = resultSet.getInt("student id");
                	SInClassTT.add(Sid1); 
                }
            }
            
            //SS
	        resultSet = statement
	        		.executeQuery("select `place`, `hour` from `Schedule` where `student id`=" + studentId + " and day= 'SS'") ;
            ArrayList<ArrayList> placeBeenSS = new ArrayList<ArrayList>();// List of places the student has been in the day
            while (resultSet.next()) {
            	int Pid = resultSet.getInt("place");
            	int Hour = resultSet.getInt("hour");
            	ArrayList<Integer> Pair = new ArrayList<Integer>(2);
            	Pair.add(Pid);
            	Pair.add(Hour);
            	placeBeenSS.add(Pair);
            }
            for(int i1=0; i1< placeBeenSS.size(); i1++){ 
            	//System.out.println("Place Work");
            	int placeInf =  (Integer) placeBeenSS.get(i1).get(0);
            	int hourInf = (Integer) placeBeenSS.get(i1).get(1);           	
        		statement = connect.createStatement();
        		resultSet = statement
                            .executeQuery("select `student id` from `Schedule` where `hour`=" + hourInf+ " and `place`=" + placeInf + " and day= 'SS' ");
                while (resultSet.next()) {
                	int Sid1 = resultSet.getInt("student id");
                	SInClassSS.add(Sid1); 
                }
            }
            
            ArrayList<Integer> Em = new ArrayList<Integer>(0);
            MWFs.add(Em);
            TTs.add(Em);
            SSs.add(Em);
            MWFs.set(s, SInClassMWF);
            TTs.set(s, SInClassTT);
            SSs.set(s, SInClassSS);
    	}
            
    	
    }
    
    public void StimulationGen(int num) throws Exception{
    	for(int i=1; i<num+1; i++){
    		OneStimulation(i);
    	}
    }
    
    
    
    
    public void OneStimulation(int stimulationId) throws Exception {


        try {
        	
        	ArrayList<Integer> stateList = new ArrayList<Integer>(Collections.nCopies(2400, 0));// check track with states
        	statement = connect.createStatement();
        	PriorityQueue<event> eQueue = new PriorityQueue();// event Queue
        	

        	int FirstS =randInt(8354,10753);
        	stateList.set(FirstS-8354,1);

        	//in order to test, set FirstS to what we know first, deleted later
        	//int FirstS = 8354;
        	
        	//first infected student
    		String query11 = "UPDATE `" + database + "`.`student state` SET  `state` = 1 WHERE  `id`="+ FirstS;
            statement.executeUpdate(query11);
            
    		//add to dictionary
            
    		// insert event 1 in the queue 1-2 become contagious
            event event01= new event(FirstS, 0, 1);
            eQueue.add(event01);
    		// insert event 2 in the queue 2-3 not contagious but not recovery
            event event02= new event(FirstS, 8, 2);
            eQueue.add(event02);
            // inset event 3 in the queue 3-4 recovery!
            event event03= new event(FirstS, 11, 3);
            eQueue.add(event03);
        	
        	//Hashtable<Integer, Integer> Dic = new Hashtable(); //record the infecting network
        	
        	int StimId = stimulationId;
        	int gTime;// the time at Smith, measure by day(s)
        	String dayInWeek = null; // MWF or TT or SS
        	
        	
        	// loop for the whole semester
        	for(gTime = 0; gTime < 98; gTime++){
        		//look into the queue and change the state accordingly
        		//System.out.println(eQueue.size());
        		if(eQueue.size() != 0){
        			//System.out.println("Check Queue work!");
        			//System.out.println(eQueue.peek());
        			//System.out.println(gTime);
	        		int timeFirstEvent = eQueue.peek().getTime();	        			
		        	while(timeFirstEvent == gTime){
		        			event event1 = eQueue.poll();
		        				
		        			//System.out.println(event1);
		        			int studentId1 = event1.getstudentId();
		        			int actionNum = event1.getAction();
		        			if(actionNum == 1){ 
		        				//update state from 1-2
		                		String query01 = "UPDATE `" + database + "`.`student state` SET  `state` = 2 WHERE  `id`="+studentId1;
		                        statement.executeUpdate(query01);
		                        //counter1++;
		        			}else if(actionNum == 2){
		        				//update state from 2-3
		                		String query02 = "UPDATE `" + database + "`.`student state` SET  `state` = 3 WHERE  `id`="+studentId1;
		                        statement.executeUpdate(query02);
		                       // counter2++;
		        			}else if(actionNum == 3){
		        				//update state from 3-4
		                		String query03 = "UPDATE `" + database + "`.`student state` SET  `state` = 4 WHERE  `id`="+studentId1;
		                        statement.executeUpdate(query03);
		                        //counter3++;
		        			}
		        			if(eQueue.size() != 0){
		        				timeFirstEvent = eQueue.peek().getTime();
		        			}else{
		        				break;
		        			}
		        			
		        	}       		
        		}
        		
        		// to see if is MWF or TT or SS
        		if( gTime%7==0 || gTime%7 == 2 || gTime%7== 4){
        			dayInWeek = "MWF"; 			
        		}else if( gTime%7== 1 || gTime%7 == 3 ){
        			dayInWeek = "TT";
        		}else if(gTime%7== 5 || gTime%7 == 6){
        			dayInWeek = "SS";
        		}
        		//System.out.println("Check day work!"+ dayInWeek);
        		
        		int healthyNum = -1;
                statement = connect.createStatement();
                resultSet = statement
                        .executeQuery("SELECT COUNT(*) FROM `student state` WHERE `state`= 0" );
                //counter4++;
                while (resultSet.next()) {
                	healthyNum = resultSet.getInt("COUNT(*)");                	
                }
                ArrayList<Integer> infectS = new ArrayList<Integer>();// List of infectious Students
                if(healthyNum != 0){
            		//get all the students who are infectious/contagious at this time
            		statement = connect.createStatement();
                    resultSet = statement
                            .executeQuery("select `id` from `student state` where `state`="+ 2);
                    //counter5++;
                    while (resultSet.next()) {
                    	int Sid = resultSet.getInt("id");
                    	infectS.add(Sid);   // get the list of the infectious students	              	
                    }                	
                }
        		          
                // then look into each student's schedule
                for(int i=0; i< infectS.size(); i++){
                	int infectId = infectS.get(i);
                	/*
            		statement = connect.createStatement(); 
            		if(dayInWeek.equals("MWF")){
	                resultSet = statement
	                		
	                		.executeQuery("SELECT distinct( id2 ) FROM `DT_play` WHERE id1 =" + infectId+ " and day = 'MWF'") ;
	                	//counter7++;
            		}else if(dayInWeek.equals("TT")){
            			resultSet = statement
    	                		.executeQuery("SELECT distinct( id2 ) FROM `DT_play` WHERE id1 =" + infectId+ " and day = 'TT'") ;
            			//counter8++;
            		}else if(dayInWeek.equals("SS")){
	            		resultSet = statement
		                		.executeQuery("SELECT distinct( id2 ) FROM `DT_play` WHERE id1 =" + infectId+ " and day = 'SS'") ;
	            		//counter9++;
            		}
	                ArrayList<Integer> SInClass = new ArrayList<Integer>();// List of places the student has been in the day
	                while (resultSet.next()) {
	                    int Sid1 = resultSet.getInt("id2");
	                    SInClass.add(Sid1);  // get the students in the class which infectious student in. dangerous
	                                        	
	                }
	                */   
                	ArrayList<Integer> SInClass = new ArrayList<Integer>();// List of places the student has been in the day
            		if(dayInWeek.equals("MWF")){
            			SInClass = MWFs.get(infectId-8354);                
            		}else if(dayInWeek.equals("TT")){
            			SInClass = TTs.get(infectId-8354);
            		}else if(dayInWeek.equals("SS")){
            			SInClass =SSs.get(infectId-8354);
            		}
	                

	                // infect other
	                for(int i2=0; i2< SInClass.size(); i2++){
	                    //System.out.println("Get in Class Work");
	                    int SinCId = SInClass.get(i2);
	                    int pos = randInt(0,99); // check if this way would be valid
	                    int state = -1;
	                    if(pos==0){
	                    	state = stateList.get(SinCId-8354);
	                    }
	                    /*
	                    if(pos==0){
		                	statement = connect.createStatement();
		                    resultSet = statement
		                              .executeQuery("select `state` from `student state` where `id`=" + SinCId);
		                    //counter13++;
		                    while (resultSet.next()) {
		                        state = resultSet.getInt("state");              	
		                    }
	                    }
						*/
	                    if( pos==0 && state == 0 ){ // infected sad
	                    		//System.out.println("Infect Work");                		
	                    		//record that who the students get infected from 
	                    		//System.out.println("Infected it");
	                    	//Dic.put(infectId, SinCId);
	                    		
	                    		// update student from 0 to 1
	                    	String query1 = "UPDATE `" + database + "`.`student state` SET  `state` = 1 WHERE  `id`="+SinCId;
	                        statement.executeUpdate(query1);
	                        stateList.set(SinCId-8354,1);
	                            //counter14++;
	                    		//add to dictionary
	                            
	                    		// insert event 1 in the queue 1-2 become contagious
	                        event event1= new event(SinCId, gTime+10, 1);
	                        eQueue.add(event1);
	                    		// insert event 2 in the queue 2-3 not contagious but not recovery
	                        event event2= new event(SinCId, gTime+18, 2);
	                        eQueue.add(event2);
	                            // inset event 3 in the queue 3-4 recovery!
	                        event event3= new event(SinCId, gTime+21, 3);
	                        eQueue.add(event3);
	                            /*
	                            String query35 = "INSERT INTO `infectLo`(`id`, `day`, `location`) "
	                            		+ "VALUES (null, ?, ?)";
	                 
	                                preparedStatement = connect.prepareStatement( query35 );
	                                preparedStatement.setInt(1, gTime );
	                                preparedStatement.setInt(2, placeInf );
	                                preparedStatement.executeUpdate();
	                                */
	                    }	
	                }
                }
                
                
                //record the different number of the categories in the database
                int healthy = -1 ;
                int infected = -1;
                int contag = -1;
                int notR= -1 ;
                int recover= -1;
                
                statement = connect.createStatement();
                resultSet = statement
                        .executeQuery("SELECT COUNT(*) FROM `student state` WHERE `state`= 0" );
                //counter15++;
                while (resultSet.next()) {
                	healthy = resultSet.getInt("COUNT(*)");                	
                }
                resultSet = statement
                        .executeQuery("SELECT COUNT(*) FROM `student state` WHERE `state`= 1" );
                //counter16++;
                while (resultSet.next()) {
                	infected = resultSet.getInt("COUNT(*)");                	
                }
                resultSet = statement
                        .executeQuery("SELECT COUNT(*) FROM `student state` WHERE `state`= 2" );
                //counter17++;
                while (resultSet.next()) {
                	contag = resultSet.getInt("COUNT(*)");                	
                }
                resultSet = statement
                        .executeQuery("SELECT COUNT(*) FROM `student state` WHERE `state`= 3" );
                //counter18++;
                while (resultSet.next()) {
                	notR = resultSet.getInt("COUNT(*)");                	
                }
                resultSet = statement
                        .executeQuery("SELECT COUNT(*) FROM `student state` WHERE `state`= 4" );
                //counter19++;
                while (resultSet.next()) {
                	recover = resultSet.getInt("COUNT(*)");                	
                }
                
                String query05 = "INSERT INTO `Stimulations`(`Id`, `stimulationNum`, "
                		+ "`time`, `healthyNum`, `infectedNum`, `contagiousNum`, `notRecoverNum`, `recoverNum`) "
                		+ "VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
                //counter20++;
                try {
                    preparedStatement = connect.prepareStatement( query05 );
                    preparedStatement.setInt(1, StimId );
                    preparedStatement.setInt(2, gTime );
                    preparedStatement.setInt(3, healthy );
                    preparedStatement.setInt(4, infected );
                    preparedStatement.setInt(5, contag );
                    preparedStatement.setInt(6, notR );
                    preparedStatement.setInt(7, recover );
                    preparedStatement.executeUpdate();

	            } catch ( Exception e) {
	                    throw e;
	            }
        	
            
            //clear the student state
                        
        	}
        	//System.out.println(Dic);
            String query06 = "UPDATE `student state` SET `state`=0 WHERE 1";
            statement.executeUpdate(query06); 

	
        } catch (Exception e) {
                throw e;
        }
    }
    
    
    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    
    public void close() {
        try {
                if (resultSet != null) {
                        resultSet.close();
                }

                if (statement != null) {
                        statement.close();
                }

                if (connect != null) {
                        connect.close();
                }
        } catch (Exception e) {

        }
    }

}

