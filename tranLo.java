import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;


public class tranLo {
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
    
    public void tranNum( ) throws Exception{
    	try {
    		ArrayList<Pair> olist = new ArrayList<Pair>(2410);
    		statement = connect.createStatement(); 
            resultSet = statement
            		.executeQuery("SELECT  `healthyNum` FROM `Stimulations` WHERE time=28") ;
            while (resultSet.next()) {
            	int day = resultSet.getInt("healthyNum");
            	System.out.println(2400-day);
            	}
            	
            
        } catch (Exception e) {
            throw e;
        }
    }
    public void tranLoS( ) throws Exception {
    	try {
    		ArrayList<Pair> olist = new ArrayList<Pair>(2410);
    		statement = connect.createStatement(); 
            resultSet = statement
            		.executeQuery("select `day`, `location` from `infectLo` where 1") ;
            while (resultSet.next()) {
            	int day = resultSet.getInt("day");
            	int locationNum = resultSet.getInt("location");
            	if(day <= 30 && day>=29){
            		Pair pair0 = new Pair(day,locationNum);
            		olist.add(pair0);
            	}
            	
            }

            for(int i=0; i< olist.size(); i++){
            	
            	int day0 = olist.get(i).getF();
            	int num0 = olist.get(i).getS();
            	// JMG 
            	if(num0 == 1540){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3194, -72.6381));
            	}
            	// CC WriGHT Hall film
            	else if(num0 == 1539){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3184, -72.6388));
            	}
            	// CC party
            	else if(num0 == 1538){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3196, -72.6388));
            	}
            	
            	//dinnng session
            	
            	//chapin dinning hall
            	else if(num0 == 1537){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.319, -72.6394));
            	}
            	// chase ducket dinning hall 
            	else if(num0 == 1536){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.319484, -72.636307));
            	}
            	//cushing/emmerson dinning
            	else if(num0 == 1535){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.319948, -72.643724));
            	}
            	//Cutter-Z dinning
            	else if(num0 == 1534 || num0==1533){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.320683, -72.638290));
            	}
            	//hubbard dinning
            	else if(num0 == 1532){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3172, -72.637));
            	}
            	// king scale dinning
            	else if(num0 == 1531){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.321191, -72.642799));
            	}            	
            	//lamont dinning
            	else if(num0 == 1530){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.320390, -72.636412));
            	}            	
            	//gillet dinning
            	else if(num0 == 1539){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3172, -72.637));
            	}
            	//comtock wilder dinning
            	else if(num0 == 1538){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.319750, -72.644930));
            	}
            	//tyler dinning
            	else if(num0 == 1537){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.316767, -72.639748));
            	}
            	
            	//library seesion
            	// cc 3
            	else if(num0 >=114 && num0 <=116){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3196, -72.6388));
            	}
            	//nelison
            	else if(num0 >=111 && num0 <=113){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.318, -72.6381));
            	}
            	//performance art lib
            	else if(num0 >=109 && num0 <=110){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.315849, -72.638671));
            	}
            	//bass lib
            	else if(num0 >=106 && num0 <=108){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3172, -72.6387));
            	}
            	//archieve 
            	else if(num0 >=103 && num0 <=105){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3172, -72.6381));
            	}
            	//art lib
            	else if(num0 >=100 && num0 <=102){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.318328, -72.636393));
            	}
            	
            	//classroom and conference room session
            	// bass 9class 1 con
            	else if((num0 >=91 && num0 <=99) || num0 == 126){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3172,-72.6387));
            	}
            	//burton 12+1
            	else if((num0 >=79 && num0 <=90) || num0 == 125){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3177, -72.6395));
            	}
            	//MCconell 6+1
            	else if((num0 >=73 && num0 <=78) || num0 == 124){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3172, -72.6394));
            	}
            	//sage 5+1
            	else if((num0 >=68 && num0 <=72) || num0 == 123){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3157, -72.6397));
            	}
            	//ford 14+1
            	else if((num0 >=54 && num0 <=67) || (num0 >= 119 &&num0 <= 122)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.316, -72.6379));
            	}
            	//theater 3+1
            	else if((num0 >= 51 && num0 <=53) || num0 == 118){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3161, -72.6393));
            	}
            	//hilley 4+1
            	else if((num0 >=47 && num0 <=50) || num0 == 117){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3184,-72.6363));
            	}
            	//seelye 23
            	else if(num0 >=24 && num0 <=46){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3177,-72.6369));
            	}
            	//ITT 1
            	else if(num0 ==23){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.31416, -72.639283));
            	}
            	//gym 6
            	else if(num0 >=17 && num0 <=32){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3148,-72.6396));
            	}
            	//Dewey House 2
            	else if(num0 >=15 && num0 <=16){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3189, -72.6376));
            	}
            	// sabin - read 4
            	else if(num0 >=11 && num0 <=14){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3178, -72.6398));
            	}
            	//wright hall 3
            	else if(num0 >=8 && num0 <=10){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3184, -72.6388));
            	}
            	//hatfield 8 
            	else if(num0 >=0 && num0 <=7){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3188, -72.6379));
            	}

            	// room seesion
            	//Parsion  +30
            	else if(num0 >= 1497 && num0 <= 1526){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3212, -72.639));
            	}
            	//Sessions Annex + 20 
            	else if(num0 >=1477 && num0 <=1496){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3205, -72.6392));
            	}
            	//Albright House +30         	
            	else if(num0 >=1447 && num0 <=1476){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),",42.3194,-72.6354));
            	}
            	//Lawrence +30
            	else if((num0 >=1417 && num0 <=1446) || (num0 >= 119 &&num0 <= 122)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3168, -72.6384));
            	}
            	// Chapin 4+30
            	else if((num0 >= 523 && num0 <=526 ) || (num0 >= 1387 &&num0 <= 1416)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.319, -72.6394));
            	}
            	//Duckett +20
            	else if(num0 >= 1367 &&num0 <= 1386){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3194, -72.6362));
            	}
            	// Lamont +45
            	else if(num0 >= 1322 &&num0 <= 1366){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3204, -72.6366));
            	}
            	//Dawes House 8+5
            	else if((num0 >=515 && num0 <=522) || (num0 >= 1317 &&num0 <= 1321)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3199, -72.6356));
            	}
            	// Haven +35
            	else if(num0 >= 1282 &&num0 <= 1316){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3197, -72.6393));
            	}

            	// Wesley +35
            	else if(num0 >=1247 && num0 <=1281){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3195, -72.6396));
            	}
            	//Ziskind 30+35
            	else if((num0 >=485 && num0 <=514) || (num0 >= 1212 &&num0 <= 1246)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3206, -72.6385));
            	}
            	//cushing 30+20
            	else if((num0 >=455 && num0 <=484) || (num0 >= 1192 &&num0 <= 1216)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.32, -72.6439));
            	}
            	//king 30+35
            	else if((num0 >=425 && num0 <=454) || (num0 >= 1157 &&num0 <= 1186)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3213, -72.6431));
            	}
            	//wilson  20+30
            	else if((num0 >= 405 && num0 <= 424) || (num0 >= 1127 &&num0 <= 1151)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.321,-72.6444));
            	}
            	// Tyler 20+30
            	else if((num0 >= 385 && num0 <= 404) || (num0 >= 1097 &&num0 <= 1126)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3167, -72.6396));
            	}

            	//Wilder 20+30
            	else if((num0 >= 365 && num0 <= 384) || (num0 >= 1067 &&num0 <= 1096)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),",42.3199, -72.6449));
            	}
            	//Morris 10+25
            	else if((num0 >= 355 && num0 <= 364) || (num0 >= 1042 &&num0 <= 1066)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3167, -72.639));
            	}
            	//cutter 25+30
            	else if((num0 >= 330 && num0 <= 354) || (num0 >= 1012 &&num0 <= 1041)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3205, -72.6381));
            	}
            	//Park 10+20
            	else if((num0 >= 320 && num0 <= 329) || (num0 >= 992 &&num0 <= 1011)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),",42.3202, -72.641));
            	}
            	// Capen +35
            	else if(num0 >= 957 &&num0 <= 991){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3213, -72.6371));
            	}

            	//Talbot +35
            	else if(num0 >= 922 &&num0 <= 956){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3208, -72.6362));
            	}

            	//Gillett 25+30
            	else if((num0 >= 295 && num0 <= 319) || (num0 >= 892 &&num0 <= 921)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3198, -72.6369));
            	}
            	// Emmerson 20 +35
            	else if((num0 >= 275 && num0 <= 294) || (num0 >= 857 &&num0 <= 891)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3202,-72.6433));
            	}

            	//Jordan  20+30
            	else if((num0 >= 255 && num0 <= 274) || (num0 >= 827 &&num0 <= 856)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3206, -72.6431));
            	}
            	//Morrow 20+30
            	else if((num0 >= 235 && num0 <= 254) || (num0 >= 797 &&num0 <= 826)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3205, -72.6445));
            	}
            	//Gardiner 20+30
            	else if((num0 >= 215 && num0 <= 234) || (num0 >= 767 &&num0 <= 796)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.321, -72.6437));
            	}
            	//Comstock 20+30
            	else if((num0 >= 195 && num0 <= 214) || (num0 >= 737 &&num0 <= 766)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3198, -72.6445));
            	}
            	//Scales 30+30
            	else if((num0 >= 165 && num0 <= 194) || (num0 >= 707 &&num0 <= 736)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3209, -72.6427));
            	}
            	//Northrop 15+30
            	else if((num0 >= 150 && num0 <= 164) || (num0 >= 677 &&num0 <= 716)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.32, -72.6373));
            	}
            	//chase 10+25
            	else if((num0 >= 140 && num0 <= 149) || (num0 >= 652 &&num0 <= 676)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3196, -72.6364));
            	}
            	//hopkins 3+25
            	else if((num0 >= 137 && num0 <= 139) || (num0 >= 627 &&num0 <= 651)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3198, -72.6398));
            	}
            	//baldwin 10+30
            	else if((num0 >= 127 && num0 <= 136) || (num0 >= 697 &&num0 <= 626)){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3196, -72.635));
            	}
            	//washburn 25
            	else if(num0 >= 572 &&num0 <= 596){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3175, -72.6375));
            	}
            	//session 20
            	else if(num0 >= 552 &&num0 <= 571){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3205, -72.6395));
            	}
            	//hubbard 25
            	else if(num0 >= 527 &&num0 <= 547){
            		System.out.println(String.format("new google.maps.LatLng(%f, %f),", 42.3172, -72.637));
            	}
            	
            }
            
            
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
