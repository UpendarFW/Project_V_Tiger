package generic_Utilities;

import java.util.Date;
import java.util.Random;

public class Java_Utility {

	public int getRandomNumber() {
		Random r=new Random();
		int rand=r.nextInt(10000);
		return rand;
	}
	
	public String getSystemDate() {
		Date d=new Date();
		String date = d.toString();
		return date;
	}
	
	public String getSystemDateIn_Format() {
		Date d=new Date();
		String []dArray=d.toString().split(" ");
		String date=dArray[2];
		String month=dArray[1];
		String year=dArray[5];
		String day=dArray[0];
		String time=dArray[3].replace(":","-");
		
		String dateFormat=date+"-"+month+"-"+year+"-"+day+"-"+time;
		
		return dateFormat;
	}
	
	
}
