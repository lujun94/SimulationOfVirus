
public class MainGenerateRan {
	  public static void main(String[] args) throws Exception {
		  //GenerateRan db = new GenerateRan();
          //db.connectToDB();
          //db.addNewStudentState1(); 
          //db.addNewP1(); 
          //db.addNewS1();
          //db.RanUpdate();
          //db.readSchedule();
          //db.close();
          
		  
          Stimulation st = new Stimulation();
          st.connectToDB();
          st.arryGen();
          st.StimulationGen(1);
          st.close();
          
		  /*
          tranLo st = new tranLo();
          st.connectToDB();
          st.tranNum();
          st.close();
		  */
  }

}
