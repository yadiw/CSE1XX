public class ExamReview5{
   public static void main(String[] args) {
      //System.out.println(sameDashes("1st-has-less", "2nd-has-more-characters"));
      //System.out.println(undouble("aa"));
      //System.out.println(weave(111,222));
   }
   
   public static boolean sameDashes(String str1, String str2) {
      String longS;
      String shortS;
      if (str1.length() > str2.length()) {
         longS = str1;
         shortS = str2;
      } else {
         longS = str2;
         shortS = str1;
      }
      for(int i = 0; i < shortS.length(); i++) {
         if((longS.charAt(i) == '-' && longS.charAt(i) != '-') || (longS.charAt(i) != '-' && longS.charAt(i) == '-')) {
            return false;
         }
      }
      if(longS.length() != shortS.length() && longS.substring(shortS.length()).contains("-")) {
         return false;
      }
      return true;
   }
   
   public static String undouble(String str) {
      String result = "";
      int index = 0;
      while (index < str.length() - 1) {
         char left = str.charAt(index);
         char right = str.charAt(index + 1);
         result += left;
         if (left != right) {
            index++;
         } else {
            index += 2; 
         }
      }
      if (str.length() != 0 && str.charAt(str.length() - 2) != str.charAt(str.length() - 1)) {
         result += str.charAt(str.length() - 1);
      }
      return result;   
   }
   
   public static int weave(int num1, int num2) {
      int exp = 0;
      int result = 0;
      while (num1 > 0 || num2 > 0) {
         int mod1 = num1 % 10;
         int mod2 = num2 % 10;            
         result += (mod1 * 10 + mod2) * Math.pow(100, exp);
         exp++;
         num1 /= 10;
         num2 /= 10;
      }
      return result;
   
   }

}