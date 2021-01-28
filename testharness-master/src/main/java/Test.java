import java.text.SimpleDateFormat;

public class Test {

	public static void main(String args[]) {
		
	  long time = System.currentTimeMillis();
	  java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
	  String date = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(timestamp);
      System.out.println(date);
		  
	}
}
