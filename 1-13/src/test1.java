	        
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

	public class test1 {
	    public static void main(String[] args) {
	    	System.out.println("問１");
	        List<String> strArray1 = new ArrayList<>(Arrays.asList("f", "u", "k", "u", "d", "a", "k", "a", "n", "e", "k", "o"));
	        List<String> strArray2 = new ArrayList<>();
	        List<String> strArray3 = new ArrayList<>();
	        List<String> strArray4 = new ArrayList<>();

	        for (int i = 0; i < strArray1.size(); i++) {
	            for (int j = 0; j < strArray1.size(); j++) {
	                for (int k = 0; k < strArray1.size(); k++) {
	                    if (i >= 2) {

	                        if (j == i && k == 0) {
	                            strArray2.add(strArray1.get(i));
	                        }
	                    }
	                }
	            }
	        }

	        for (int i = 0; i < strArray2.size(); i++) {
	            for (int j = 0; j < strArray2.size(); j++) {
	                for (int k = 0; k < strArray2.size(); k++) {
	                    String s = strArray2.get(i);
	                    if (s.equals("k") || s.equals("a") || s.equals("o")) {
	                        if (j == i && k == 0) {
	                            strArray3.add(s);
	                        }
	                    }
	                }
	            }
	        }
	        for (int i = 0; i < strArray3.size(); i++) {
	            for (int j = 0; j < strArray3.size(); j++) {
	                for (int k = 0; k < strArray3.size(); k++) {
	                    if (strArray3.size() >= 5) {
	                        if (i == 0 && j == 1 && k == 2) {
	                            strArray4.add(strArray3.get(i));
	                            strArray4.add(strArray3.get(j));
	                            strArray4.add(strArray3.get(k));
	                            strArray4.add("a");
	                            strArray4.add("o");
	                        }
	                    }
	                }
	            }
	        }

	        System.out.println("Result: " + String.join("", strArray4));
	    }
	}
	


