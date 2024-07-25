import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test1 {
	public static void main(String[] args) {
		
		String shinyaBirthday = "1998/03/19";
		String minamiBirthday = "2000/02/14";
		String furuyamaBirthday = "1998/09/12";
		//改行
		System.out.println("問１");
		//問題1:現在の時刻を出力してください
		Date date = new Date();
		System.out.println(date.toString());
		//改行
		System.out.println("問２");
		//問題2:shinyaBirthdayとminamiBirthdayを日付型に変更し条件式で誕生日を比較し早い方の日付を文字列型で出力しなさい。
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		 
	try {
		 Date shinyaDate = dateFormat.parse(shinyaBirthday);
		 Date minamiDate = dateFormat.parse(minamiBirthday);
			 
		Date earlierBirthday = (shinyaDate.before(minamiDate)) ?shinyaDate : minamiDate;
			 
		String earlierBirthdayString = dateFormat.format(earlierBirthday);
		System.out.println(earlierBirthdayString);

	} catch (ParseException e) {
	            e.printStackTrace();
	     }
	         
		//改行
		System.out.println("問３");
		//問題3:furuyamaBirthdayに５年2ヶ月追加した値を文字列型で表示しなさい
         SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");
         Calendar calendar = Calendar.getInstance();
        
      try {
            Date furuyamaDate = dateFormat1.parse(furuyamaBirthday);

            calendar.setTime(furuyamaDate);

            calendar.add(Calendar.YEAR, 5);
            calendar.add(Calendar.MONTH, 2);

            Date newDate = calendar.getTime();

            String newDateString = dateFormat1.format(newDate);
            System.out.println(newDateString);

            } catch (ParseException e) {
            e.printStackTrace();
            }
       }
}

