import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class GenerateRan {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    final private String host = "xxxxxxxxx";
    final private String user = "xxxxxxxxx";
    final private String passwd = "xxxxxxxxx";
    final private String database = "xxxxxxxxx";

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

    public void readSchedule() throws Exception {
            try {
                    statement = connect.createStatement();
                    resultSet = statement
                                    .executeQuery("select * from " + database + ".Schedule");
                    while (resultSet.next()) {
                            int Id = resultSet.getInt("id");
                            int SId = resultSet.getInt("student id");
                            int place = resultSet.getInt("place");
                            String day = resultSet.getString("day");
                            int hour = resultSet.getInt("hour");

                            System.out.println(String.format(
                                            "Id: %d student ID: %d place: %d day: %5s hour: %d", Id, SId, place, day, hour));
                    }
            } catch (Exception e) {
                    throw e;
            }
    }
    
    public void readState() throws Exception {
        try {
                statement = connect.createStatement();
                resultSet = statement
                                .executeQuery("select * from " + database + ".student state");
                while (resultSet.next()) {
                        int Id = resultSet.getInt("id");
                        int room = resultSet.getInt("house room");
                        int state = resultSet.getInt("state");


                        System.out.println(String.format(
                                        "student Id: %d  room: %d state: %d", Id, room, state));
                }
        } catch (Exception e) {
                throw e;
        }
    }
    
    public void readPlace() throws Exception {
        try {
                statement = connect.createStatement();
                resultSet = statement
                                .executeQuery("select * from " + database + ".place");
                while (resultSet.next()) {
                        int Id = resultSet.getInt("id");
                        int place = resultSet.getInt("place");
                        int day = resultSet.getInt("day");
                        int hour = resultSet.getInt("hour");
                        int count = resultSet.getInt("count");
                        int max = resultSet.getInt("max");

                        System.out.println(String.format(
                                        "Id: %d place: %d day: %5s hour: %d count: %d max: %d", Id, place, day, hour,count, max));
                }
        } catch (Exception e) {
                throw e;
        }
    }
/*
    public void readCalls() throws Exception {
        try {
                statement = connect.createStatement();
                resultSet = statement
                                .executeQuery("select * from " + database + ".calls");
                while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        int time = resultSet.getInt("time");
                        int id1 = resultSet.getInt("id1");
                        int id2 = resultSet.getInt("id2");
                        int length = resultSet.getInt("length");
                        

                        System.out.println(String.format(
                                        "id: %d time: %d id1: %d  id2: %d length: %d", id, time, id1, id2, length));
                }
        } catch (Exception e) {
                throw e;
        }
    }
*/
    
    public void addNewS(int studentID, int place, String day, int hour  ) throws Exception  {
    	String query = "INSERT INTO `" + database + "`.`Schedule` (`id`, `student id`, `place`, `day`, `hour`)"
                              + "VALUES (null, ?, ?, ?, ? )";
        try {
                preparedStatement = connect.prepareStatement( query );
                preparedStatement.setInt(1, studentID );
                preparedStatement.setInt(2, place );
                preparedStatement.setString(3, day );
                preparedStatement.setInt(4, hour );
                preparedStatement.executeUpdate();

        } catch ( Exception e) {
                throw e;
        }
    }

    public void addNewS1( ) throws Exception  {
    	try{
    		statement = connect.createStatement();
    		for(int i=8354; i<10754; i++){
    			for(int m=0; m<14; m++){
    				if(m ==13){    	                
    	                resultSet = statement
    	                                .executeQuery("select `id`, `house room`, `state` from `student state` where `id`="+i);
    	                resultSet.next();
                        int Id = resultSet.getInt("id");
                        int room = resultSet.getInt("house room");
                        int state = resultSet.getInt("state");
                        addNewS(i,room,"MWF",m);
    				}else{
    					addNewS(i,-1,"MWF",m);
    				}
    			}

    			for(int t=0; t<10; t++){
    				if(t==9){
    	                resultSet = statement
                                .executeQuery("select `id`, `house room`, `state` from `student state` where `id`="+i);
    	                resultSet.next();
		                int Id = resultSet.getInt("id");
		                int room = resultSet.getInt("house room");
		                int state = resultSet.getInt("state");
		                addNewS(i,room,"TT",t);	
		                
    				}else{
    					addNewS(i,-1,"TT",t); 
    				}
    			}
    			
    			for(int s=0; s<7; s++){
    				if(s==6){
    	                resultSet = statement
                                .executeQuery("select `id`, `house room`, `state` from `student state` where `id`="+i);
    	                resultSet.next();
		                int Id = resultSet.getInt("id");
		                int room = resultSet.getInt("house room");
		                int state = resultSet.getInt("state");
		                addNewS(i,room,"SS",s);	
		                
    				}else{
    					addNewS(i,-1,"SS",s); 
    				}
    			}
    		}
    	}catch( Exception e ){
    		throw e;
    	
    	}
    	
    }

    public void addNewP(int placeId, String day, int hour, int count, int max  ) throws Exception  {
        
        String query = "INSERT INTO `" + database + "`.`place` (`id`, `place`, `day`, `hour`, `count`,`max`)"
                              + "VALUES (null, ?, ?, ?, ?, ? )";
        try {
                preparedStatement = connect.prepareStatement( query );
                preparedStatement.setInt(1, placeId );
                preparedStatement.setString(2, day );
                preparedStatement.setInt(3, hour );
                preparedStatement.setInt(4, count );
                preparedStatement.setInt(5, max );
                preparedStatement.executeUpdate();

        } catch ( Exception e) {
                throw e;
        }
    }

    public void addNewP1() throws Exception  {
    	try{
    		//100 classrooms. 30 max people
    		for(int i=0; i<100; i++){
    			for(int m=0; m<14; m++){
    				addNewP(i,"MWF",m,0,30);
    			}
    			for(int t=0; t<10; t++){
    				addNewP(i,"TT",t,0,30); 			
    			}
    			if(i >= 70){
        			for(int s=0; s<7;s++){
        				addNewP(i,"SS",s,0,10);   	
        			}
    			}
    		}
    		//5 libraries and campus center. 50 max people
    		for(int l=100; l<117; l++){
    			for(int m=0; m<14; m++){
    				addNewP(l,"MWF",m,0,50);
    			}
    			for(int t=0; t<10; t++){
    				addNewP(l,"TT",t,0,50); 			
    			}
    			for(int s=0; s<7;s++){
    				addNewP(l,"SS",s,0,50); 
    			}
    		}
    		//10 conference room for group study
    		for(int l=117; l<127; l++){
    			for(int m=0; m<14; m++){
    				addNewP(l,"MWF",m,0,10);
    			}
    			for(int t=0; t<10; t++){
    				addNewP(l,"TT",t,0,10); 			
    			}
    			for(int s=0; s<7;s++){
    				addNewP(l,"SS",s,0,10); 
    			}
    		}
    		//house rooms. 400 singles and 1000 doubles.
    		for(int s=127; s<527; s++){
    			for(int m=0; m<14; m++){
    				if(m<13){
    					addNewP(s,"MWF",m,0,1);
    				}else{
    					addNewP(s,"MWF",m,1,1);
    				}
    			}
    			for(int t=0; t<10; t++){
    				if(t<9){
    					addNewP(s,"TT",t,0,1);
    				}else{
    					addNewP(s,"TT",t,1,1);
    				}		
    			}
    			for(int s1=0; s1<7;s1++){
    				if(s1<6){
    					addNewP(s,"SS",s1,0,1); 
    				}else{
    					addNewP(s,"SS",s1,1,1); 
    				}
    			}
    		
    		}
    		for(int d=527; d<1527; d++){
    			for(int m=0; m<14; m++){
    				if(m<13){
    					addNewP(d,"MWF",m,0,2);
    				}else{
    					addNewP(d,"MWF",m,2,2);
    				}
    			}
    			for(int t=0; t<10; t++){
    				if(t<9){
    					addNewP(d,"TT",t,0,2);
    				}else{
    					addNewP(d,"TT",t,2,2);
    				}
    			}
    			for(int s1=0; s1<7;s1++){
    				if(s1<6){
    					addNewP(d,"SS",s1,0,1); 
    				}else{
    					addNewP(d,"SS",s1,2,2); 
    				}
    			}
    		}
    		
    		//11 dinning hall.
    		for(int d1= 1527; d1<1538; d1++){
    			for(int m=0; m<14; m++){
    				addNewP(d1,"MWF",m,0,220);
    			}
    			for(int t=0; t<10; t++){
    				addNewP(d1,"TT",t,0,220); 			
    			}
    			for(int s1=0; s1<7;s1++){
    					addNewP(d1,"SS",s1,0,220); 
    			}
    		}
    		//2 event places during the weekend 60 max in the evening
    		for(int e= 1538; e<1540; e++){
    				addNewP(e,"SS",5,0,60); 
    		}
    		//1 event places during the weekend 60 max in the afternoon

			addNewP(1540,"SS",3,0,60); 
    		
    	}catch( Exception e ){
    		throw e;	
    	}
    	
    
    }
    public void addNewStudentState(int room, int state  ) throws Exception  {
    	String query = "INSERT INTO `" + database + "`.`student state` (`id`,`house room`, `state`)"
                              + "VALUES (null, ?, ? )";
        try {
                preparedStatement = connect.prepareStatement( query );
                preparedStatement.setInt(1, room );
                preparedStatement.setInt(2, state );
                preparedStatement.executeUpdate();

        } catch ( Exception e) {
                throw e;
        }
    }
    
    public void addNewStudentState1() throws Exception  {
    	try{
    		//100 classrooms. 30 max people
    		for(int i=0; i<400; i++){
    			addNewStudentState(127+i,0);
    			}
    		
    		for(int i=0; i<2000; i++){
    			addNewStudentState(527+(i-i%2)/2,0);
    		}
    		
    	}catch( Exception e ){
    		throw e;	
    	}
    	
    }

	//UPDATE  `lujunPlay`.`Schedule` SET  `place` =  '1' WHERE  `Schedule`.`student id` =4550;
    // consider lunch and dinner
   public void RanUpdate() throws Exception{
    	for(int i= 8354; i<10754; i++){
    		statement = connect.createStatement();
            resultSet = statement
                    .executeQuery("select `house room` from `student state` where `id`="+i);
		    resultSet.next();
		    int roomNum = resultSet.getInt("house room");
		    
    		
    		//lunch on MWF
    		int randDinningL = randInt(1527,1537);
        	String query10 = "UPDATE place SET  count = count +1 WHERE place= "+randDinningL+" and day= 'MWF' and hour= 3";
        	statement.executeUpdate(query10);
        	String query20 ="UPDATE Schedule SET place="+randDinningL+"  WHERE  `student id`="+i+" and day= 'MWF' and hour= 3";
        	statement.executeUpdate(query20);
        	
        	//lunch on TT
    		int randDinningL2 = randInt(1527,1537);
        	String query30 = "UPDATE place SET  count = count +1 WHERE  place= "+randDinningL2+" and day= 'TT' and hour= 2";
        	statement.executeUpdate(query30);
        	String query40 ="UPDATE Schedule SET place="+randDinningL2+"  WHERE  `student id` ="+i+" and day= 'TT' and hour= 2";
        	statement.executeUpdate(query40);
        	
        	//dinner on MWF
    		int randDinningD = randInt(1527,1537);
        	String query50 = "UPDATE place SET  count = count +1 WHERE  place= "+randDinningD+" and day= 'MWF' and hour= 9";
        	statement.executeUpdate(query50);
        	String query60 ="UPDATE Schedule SET place="+randDinningD+" WHERE `student id`="+i+" and day= 'MWF' and hour= 9";
        	statement.executeUpdate(query60);
        	
        	//dinner on TT
    		int randDinningD2 = randInt(1527,1537);
        	String query70 = "UPDATE place SET count = count +1 WHERE  place= "+randDinningD2+" and day= 'TT' and hour = 6";
        	statement.executeUpdate(query70);
        	String query80 ="UPDATE Schedule SET place= "+randDinningD2+" WHERE `student id`= "+i+" and day= 'TT' and hour= 6 ";
        	statement.executeUpdate(query80);
        	
        	//brunch on SS
    		int randBrunch = randInt(1527,1537);
        	String query1a = "UPDATE place SET  count = count +1 WHERE place= "+randBrunch+" and day= 'SS' and hour= 0";
        	statement.executeUpdate(query1a);
        	String query2a ="UPDATE Schedule SET place="+randBrunch+"  WHERE  `student id`="+i+" and day= 'SS' and hour= 0";
        	statement.executeUpdate(query2a);
        	
        	//dinner on SS
    		int randDinningD3 = randInt(1527,1537);
        	String query7a = "UPDATE place SET count = count +1 WHERE  place= "+randDinningD3+" and day= 'SS' and hour = 4";
        	statement.executeUpdate(query7a);
        	String query8a ="UPDATE Schedule SET place= "+randDinningD3+" WHERE `student id`= "+i+" and day= 'SS' and hour= 4 ";
        	statement.executeUpdate(query8a);
        	
        	//flip coin where decide whether the student have 3 classes on MWF (represent by 1)or have 3 classes on TT(represent by 2)
    		int classOnDay =  randInt(1,2);
    		//if 3 classes on MWF{    		
    		if(classOnDay == 1){
    			ArrayList<Integer> WhatLeftMWF = new ArrayList<Integer>(Arrays.asList(0,1,2,4,5,6,7,8,10,11,12));
    			int counterMWF = 0;
    			//randomly sign three classes in the time slots
    			while(counterMWF < 3){
    				Integer randHour = randInt(0,8);
    				while(randHour == 3){
    					randHour = randInt(0,8); // time slots before 5pm
    				}
    				int randClassroom = randInt(0,99); // random class room
    				//SELECT `count`,`max` FROM `place` WHERE `place`=randClassroom and `day`="MWF" and `hour`= randHour
                    try {
            			statement = connect.createStatement();
                        resultSet = statement
                                        .executeQuery("select `count`,`max` from " + database + ".place where `place`="+randClassroom+" and `day`= 'MWF' and `hour`="+ randHour);	                    
                        resultSet.next();
                        int count1 = resultSet.getInt("count");
                        int max1 = resultSet.getInt("max");
		               
		                if(count1 < max1){
	                    	//UPDATE  `place` SET  `count` = `count` +1 WHERE  `place`=0 and `day`="MWF" and `hour`=0
	                    	String query1 = "UPDATE place SET  count = count +1 WHERE place = "+randClassroom+" and day= 'MWF' and hour="+randHour;
	                    	statement.executeUpdate(query1);
	                    	String query2 ="UPDATE Schedule SET place="+randClassroom+"  WHERE  `student id`="+i+" and day='MWF' and hour="+randHour;
	                    	statement.executeUpdate(query2);
	                    	WhatLeftMWF.remove(randHour);
	                    	counterMWF+=1;
	                    }
                    } catch (Exception e) {
                        throw e;
                    }
    			}
                for(int l = 0; l<WhatLeftMWF.size();l++){
                	int curHour = WhatLeftMWF.get(l);
                	//100-126 public study place 127-154 room
                	int pickPlace = randInt(100,154);
                	if(pickPlace >= 127){
                		pickPlace = roomNum;
                	}else{
						statement = connect.createStatement();
	                    resultSet = statement
	                                    .executeQuery("select `count`,`max` from " + database + ".place where `place`="+pickPlace+" and `day`='MWF' and `hour`="+ curHour);	                    
	                    resultSet.next();
	                    int count3 = resultSet.getInt("count");
		                int max3 = resultSet.getInt("max");
		                if(count3 >= max3){
		                	pickPlace = roomNum;
		                }
                	}
                	//the hour is continuous  
                	if(l !=0 && curHour == (WhatLeftMWF.get(l-1)+1) ){
                        try {
    						statement = connect.createStatement();
    	                    resultSet = statement
    	                                    .executeQuery("select `place` from `Schedule` where `student id`="+i+" and `day`= 'MWF' and `hour`="+ WhatLeftMWF.get(l-1));	                    
    	                    resultSet.next();
    	                    int preplace = resultSet.getInt("place");
	                    	String query3 = "UPDATE `" + database + "`.`place` SET  `count` = `count` +1 WHERE  `place`="+preplace+" and `day`='MWF' and `hour`="+curHour;
	                    	statement.executeUpdate(query3);
	                    	String query4 ="UPDATE `"+database+"`.`Schedule` SET `place`="+preplace+"  WHERE  `student id`="+i+" and `day`='MWF' and `hour`="+curHour;
	                    	statement.executeUpdate(query4);	                    	
                        } catch (Exception e) {
                            throw e;
                        }
                    //otherwise pick rand place 
                	}else{
                    	String query5 = "UPDATE `" + database + "`.`place` SET  `count` = `count` +1 WHERE  `place`="+pickPlace+" and `day`='MWF' and `hour`="+ curHour;
                    	statement.executeUpdate(query5);
                    	String query6 ="UPDATE `"+database+"`.`Schedule` SET `place`="+pickPlace+"  WHERE  `student id`="+i+" and `day`='MWF' and `hour`="+curHour;
                    	statement.executeUpdate(query6);
                		
                	}
                               	
                }
                
                //GENERATE TWO RANDOM CLASS ON TUESDAY
                ArrayList<Integer> WhatLeftTT = new ArrayList<Integer>(Arrays.asList(0,1,3,4,5,7,8));
    			int counterTT = 0;
    			//randomly sign three classes in the time slots
    			while(counterTT < 2){
    				Integer randHour2 = randInt(0,5); // time slots before 5pm
    				while(randHour2 == 2){
    					randHour2 = randInt(0,5); // time slots before 5pm
    				}
    				int randClassroom2 = randInt(0,99); // random class room
    				//SELECT `count`,`max` FROM `place` WHERE `place`=randClassroom and `day`="MWF" and `hour`= randHour
                    try {
						statement = connect.createStatement();
	                    resultSet = statement
	                                    .executeQuery("select `count`,`max` from " + database + ".place where `place`="+randClassroom2+" and `day`='TT' and `hour`="+ randHour2);	                    
	                    resultSet.next();
	                    int count2 = resultSet.getInt("count");
		                int max2 = resultSet.getInt("max");

	                    if(count2 < max2){
	                    	//UPDATE  `place` SET  `count` = `count` +1 WHERE  `place`=0 and `day`="MWF" and `hour`=0
	                    	String query7 = "UPDATE `" + database + "`.`place` SET  `count` = `count` +1 WHERE  `place`="+randClassroom2+" and `day`='TT' and `hour`="+randHour2;
	                    	statement.executeUpdate(query7);
	                    	String query8 ="UPDATE `"+database+"`.`Schedule` SET `place`="+randClassroom2+"  WHERE  `student id`="+i+" and `day`='TT' and `hour`="+randHour2;
	                    	statement.executeUpdate(query8);
	                    	WhatLeftTT.remove(randHour2);
	                    	counterTT+=1;
	                    }
                    } catch (Exception e) {
                        throw e;
                    }
    			}
                for(int l = 0; l<WhatLeftTT.size();l++){
                	int curHour2 = WhatLeftTT.get(l);
                	//100-126 public study place 127-154 room
                	int pickPlace2 = randInt(100,154);
                	if(pickPlace2 >= 127){
                		pickPlace2 = roomNum;
                	}else{
						statement = connect.createStatement();
	                    resultSet = statement
	                                    .executeQuery("select `count`,`max` from " + database + ".place where `place`="+pickPlace2+" and `day`='TT' and `hour`="+ curHour2);	                    
	                    resultSet.next();
	                    int count3 = resultSet.getInt("count");
		                int max3 = resultSet.getInt("max");
		                if(count3 >= max3){
		                	pickPlace2 = roomNum;
		                }
                	}
                	//the hour is continuous  
                	if(l !=0 && curHour2 == (WhatLeftTT.get(l-1)+1) ){
                        try {
    						statement = connect.createStatement();
    	                    resultSet = statement
    	                                    .executeQuery("select `place` from `Schedule` where `student id`="+i+" and `day`='TT' and `hour`="+ WhatLeftTT.get(l-1));	                    
    	                    resultSet.next();
    	                    int preplace2 = resultSet.getInt("place");
	                    	String query9 = "UPDATE `" + database + "`.`place` SET  `count` = `count` +1 WHERE  `place`="+preplace2+" and `day`='TT' and `hour`="+curHour2;
	                    	statement.executeUpdate(query9);
	                    	String query10l ="UPDATE `"+database+"`.`Schedule` SET `place`="+preplace2+"  WHERE  `student id`="+i+" and `day`='TT' and `hour`="+curHour2;
	                    	statement.executeUpdate(query10l);	                    	
                        } catch (Exception e) {
                            throw e;
                        }
                    //otherwise pick rand place 
                	}else{
                    	String query11 = "UPDATE `" + database + "`.`place` SET  `count` = `count` +1 WHERE  `place`="+pickPlace2+" and `day`='TT' and `hour`="+curHour2;
                    	statement.executeUpdate(query11);
                    	String query12 ="UPDATE `"+database+"`.`Schedule` SET `place`="+pickPlace2+"  WHERE  `student id`="+i+" and `day`='TT' and `hour`="+curHour2;
                    	statement.executeUpdate(query12);
                		
                	}
                               	
                }
    			
                
            // another case   
    		//3 classes on TT
    		}else{
    			ArrayList<Integer> WhatLeftMWF3 = new ArrayList<Integer>(Arrays.asList(0,1,2,4,5,6,7,8,10,11,12));
    			int counterMWF3 = 0;
    			//randomly sign two classes in the time slots
    			while(counterMWF3 <2){
    				Integer randHour3 = randInt(0,8); // time slots before 5pm
    				while(randHour3 == 3){
    					randHour3 = randInt(0,8); // time slots before 5pm
    				}
    				int randClassroom3 = randInt(0,99); // random class room
    				//SELECT `count`,`max` FROM `place` WHERE `place`=randClassroom and `day`="MWF" and `hour`= randHour
                    try {
						statement = connect.createStatement();
	                    resultSet = statement
	                                    .executeQuery("select `count`,`max` from " + database + ".place where `place`="+randClassroom3+" and `day`= 'MWF' and `hour`="+ randHour3);	                    
	                    resultSet.next();
	                    int count3 = resultSet.getInt("count");
		                int max3 = resultSet.getInt("max");

	                    if(count3 < max3){
	                    	//UPDATE  `place` SET  `count` = `count` +1 WHERE  `place`=0 and `day`="MWF" and `hour`=0
	                    	String query13 = "UPDATE `" + database + "`.`place` SET  `count` = `count` +1 WHERE  `place`="+randClassroom3+" and `day`='MWF' and `hour`="+randHour3;
	                    	statement.executeUpdate(query13);
	                    	String query14 ="UPDATE `"+database+"`.`Schedule` SET `place`="+randClassroom3+"  WHERE  `student id`="+i+" and `day`='MWF' and `hour`="+randHour3;
	                    	statement.executeUpdate(query14);
	                    	WhatLeftMWF3.remove(randHour3);
	                    	counterMWF3 +=1;
	                    }
                    } catch (Exception e) {
                        throw e;
                    }
    			}
                for(int l = 0; l<WhatLeftMWF3.size();l++){
                	int curHour = WhatLeftMWF3.get(l);
                	//100-126 public study place 127-154 room
                	int pickPlace = randInt(100,154);
                	if(pickPlace >= 127){
                		pickPlace = roomNum;
                	}else{
						statement = connect.createStatement();
	                    resultSet = statement
	                                    .executeQuery("select `count`,`max` from " + database + ".place where `place`="+pickPlace+" and `day`='MWF' and `hour`="+ curHour);	                    
	                    resultSet.next();
	                    int count3 = resultSet.getInt("count");
		                int max3 = resultSet.getInt("max");
		                if(count3 >= max3){
		                	pickPlace = roomNum;
		                }
                	}
                	//the hour is continuous  
                	if(l !=0 && curHour == (WhatLeftMWF3.get(l-1)+1) ){
                        try {
    						statement = connect.createStatement();
    	                    resultSet = statement
    	                                    .executeQuery("select `place` from `Schedule` where `student id`="+i+" and `day`='MWF' and `hour`="+ WhatLeftMWF3.get(l-1));	                    
    	                    resultSet.next();
    	                    int preplace = resultSet.getInt("place");
	                    	String query15 = "UPDATE `" + database + "`.`place` SET  `count` = `count` +1 WHERE  `place`="+preplace+" and `day`='MWF' and `hour`="+curHour;
	                    	statement.executeUpdate(query15);
	                    	String query16 ="UPDATE `"+database+"`.`Schedule` SET `place`="+preplace+"  WHERE  `student id`="+i+" and `day`='MWF' and `hour`="+curHour;
	                    	statement.executeUpdate(query16);	                    	
                        } catch (Exception e) {
                            throw e;
                        }
                    //otherwise pick rand place 
                	}else{
                    	String query17 = "UPDATE `" + database + "`.`place` SET  `count` = `count` +1 WHERE  `place`="+pickPlace+" and `day`='MWF' and `hour`="+curHour;
                    	statement.executeUpdate(query17);
                    	String query18 ="UPDATE `"+database+"`.`Schedule` SET `place`="+pickPlace+"  WHERE  `student id`="+i+" and `day`='MWF' and `hour`="+curHour;
                    	statement.executeUpdate(query18);
                		
                	}
                               	
                }
                
                //GENERATE three RANDOM CLASS ON TUESDAY
                ArrayList<Integer> WhatLeftTT = new ArrayList<Integer>(Arrays.asList(0,1,3,4,5,7,8));
    			int counterTT = 0;
    			//randomly sign three classes in the time slots
    			while(counterTT <3){
    				Integer randHour2 = randInt(0,5); // time slots before 5pm
    				while(randHour2 == 2){
    					randHour2 = randInt(0,5); // time slots before 5pm
    				}
    				int randClassroom2 = randInt(0,99); // random class room
    				//SELECT `count`,`max` FROM `place` WHERE `place`=randClassroom and `day`="MWF" and `hour`= randHour
                    try {
						statement = connect.createStatement();
	                    resultSet = statement
	                                    .executeQuery("select `count`,`max` from " + database + ".place where `place`="+randClassroom2+" and `day`='TT' and `hour`="+ randHour2);	                    
	                    resultSet.next();
	                    int count2 = resultSet.getInt("count");
		                int max2 = resultSet.getInt("max");

	                    if(count2 < max2){
	                    	//UPDATE  `place` SET  `count` = `count` +1 WHERE  `place`=0 and `day`="MWF" and `hour`=0
	                    	String query19 = "UPDATE `" + database + "`.`place` SET  `count` = `count` +1 WHERE  `place`="+randClassroom2+" and `day`='TT' and `hour`="+randHour2;
	                    	statement.executeUpdate(query19);
	                    	String query20l ="UPDATE `"+database+"`.`Schedule` SET `place`="+randClassroom2+"  WHERE  `student id`="+i+" and `day`='TT' and `hour`="+randHour2;
	                    	statement.executeUpdate(query20l);
	                    	WhatLeftTT.remove(randHour2);
	                    	counterTT+=1;
	                    }
                    } catch (Exception e) {
                        throw e;
                    }
    			}
                for(int l = 0; l<WhatLeftTT.size();l++){
                	int curHour2 = WhatLeftTT.get(l);
                	//100-126 public study place 127-154 room
                	int pickPlace2 = randInt(100,154);
                	if(pickPlace2 >= 127){
                		pickPlace2 = roomNum;
                	}else{
						statement = connect.createStatement();
	                    resultSet = statement
	                                    .executeQuery("select `count`,`max` from " + database + ".place where `place`="+pickPlace2+" and `day`='TT' and `hour`="+ curHour2);	                    
	                    resultSet.next();
	                    int count3 = resultSet.getInt("count");
		                int max3 = resultSet.getInt("max");
		                if(count3 >= max3){
		                	pickPlace2 = roomNum;
		                }
                	}
                	//the hour is continuous  
                	if(l !=0 && curHour2 == (WhatLeftTT.get(l-1)+1) ){
                        try {
    						statement = connect.createStatement();
    	                    resultSet = statement
    	                                    .executeQuery("select `place` from `Schedule` where `student id`="+i+" and `day`='TT' and `hour`="+ WhatLeftTT.get(l-1));	                    
    	                    resultSet.next();
    	                    int preplace2 = resultSet.getInt("place");
	                    	String query21 = "UPDATE `" + database + "`.`place` SET  `count` = `count` +1 WHERE  `place`="+preplace2+" and `day`='TT' and `hour`="+curHour2;
	                    	statement.executeUpdate(query21);
	                    	String query22 ="UPDATE `"+database+"`.`Schedule` SET `place`="+preplace2+"  WHERE  `student id`="+i+" and `day`='TT' and `hour`="+curHour2;
	                    	statement.executeUpdate(query22);	                    	
                        } catch (Exception e) {
                            throw e;
                        }
                    //otherwise pick rand place 
                	}else{
                    	String query11 = "UPDATE `" + database + "`.`place` SET  `count` = `count` +1 WHERE  `place`="+pickPlace2+" and `day`='TT' and `hour`="+curHour2;
                    	statement.executeUpdate(query11);
                    	String query12 ="UPDATE `"+database+"`.`Schedule` SET `place`="+pickPlace2+"  WHERE  `student id`="+i+" and `day`='TT' and `hour`="+curHour2;
                    	statement.executeUpdate(query12);
                		
                	}
                               	
                }
    		}
    		
    		// schedule on SS
    		//join event in afternoon?
    		ArrayList<Integer> WhatLeftSS = new ArrayList<Integer>(Arrays.asList(1,2,3,5));
    		for(int l = 0; l<WhatLeftSS.size();l++){
            	int curHour = WhatLeftSS.get(l);
            	//70-99 open classroom for lab or TA hour 100-126 public study place 127-154 room if during 3 or 5 155-157 event
            	int pickPlace = randInt(70,157);
            	if(pickPlace >= 127 && pickPlace < 155){
            		pickPlace = roomNum;
            	}else if(WhatLeftSS.get(l) == 3 && pickPlace >= 155){
            		pickPlace = 1540;           			
            		
    			}else if(WhatLeftSS.get(l) == 5 && pickPlace >= 155){
            		if (randInt(1,2) ==1){
            			pickPlace = 1538;
            		}else{
            			pickPlace = 1539;
            		}
            	}
				statement = connect.createStatement();
                resultSet = statement
                                .executeQuery("select `count`,`max` from " + database + ".place where `place`="+pickPlace+" and `day`='SS' and `hour`="+ curHour);	                    
                resultSet.next();
                int count3 = resultSet.getInt("count");
                int max3 = resultSet.getInt("max");
                if(count3 >= max3){
                	pickPlace = roomNum;
                }
            	
                //otherwise pick rand place 
                String query17 = "UPDATE `" + database + "`.`place` SET  `count` = `count` +1 WHERE  `place`="+pickPlace+" and `day`='SS' and `hour`="+curHour;
                statement.executeUpdate(query17);
                String query18 ="UPDATE `"+database+"`.`Schedule` SET `place`="+pickPlace+"  WHERE  `student id`="+i+" and `day`='SS' and `hour`="+curHour;
                statement.executeUpdate(query18);       	
                           	
            }
        	
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


    // You need to close the resultSet
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
