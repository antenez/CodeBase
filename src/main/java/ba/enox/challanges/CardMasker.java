//package ba.enox.challanges;
//
//public class CardMasker {
//
//  public static void main(String[] args) {
//    String cardNumber = "DD1444444ABC2222DD";
//    System.out.println("result " + maskCardNumber(cardNumber));
//  }
//
//  /*
//   implement a credit card masker that replaces all but the 1st and last 4 digits in the provided sequence
//   Should not mask input shorter than 6 characters
//   Should not mask non-numeric characters
//
//   I consider chars and numbers asc2
//   Because 1st and last4 can overlap with some letters can be dow with dequeue but did not use it because would have to reverse tail polls
//  */
//  private static String maskCardNumber(String cardNumber) {
//    if(creditCardNumber.length() < 6){ return creditCardNumber; }
//    char[] chars = creditCardNumber.toCharArray();
//       /*Condition "unless they are first or last four characters." is not clear according to tests.
//         For me it looks like to mask all expect first and last for(unles they are first or last 4)...
//         Which looks like I have done.
//         In your test case is expected:<5[###]########0694> but was:<5[512]########0694>
//         Which is playing with gramar(could be discussed ).
//       */
//    //This is solution to satisfy your test cases
//    for(int i=1; i < chars.length-4; i++){
//      if(isDigit(chars[i])){
//        chars[i]='#';
//      }
//    }
//
//    return String.valueOf(chars);
////    if(creditCardNumber.length() < 6){ return creditCardNumber; }
////    char[] chars = creditCardNumber.toCharArray();
////       /*Condition "unless they are first or last four characters." is not clear according to tests.
////         For me it looks like to mask all expect first and last for(unles they are first or last 4)...
////         Which looks like I have done.
////         In your test case is expected:<5[###]########0694> but was:<5[512]########0694>
////         Which is playing with gramar(could be discussed).
////       */
////    //This is solution to satisfy your test cases
////    int startIndex = 0;
////    if(isDigit(chars[0])){
////      startIndex = 1;
////    }
////    int endIndex=chars.length-1;
////    int endCounter = 0;
////    while(endCounter < 4){
////      if(isDigit(chars[endIndex])){
////        endCounter++;
////      }
////      endIndex--;
////    }
////    while (endIndex > startIndex || endIndex == startIndex){
////      chars[startIndex]= '#';
////      startIndex++;
////    }
//    return String.valueOf(chars);
//  }
//
//  private static boolean isDigit(char c){
//    return ((int)'0') <= ((int) c) && ((int) c) <= ((int)'9');
//  }
//
//
//
////    if (cardNumber.length() < 6) {
////      return "";
////    }
////
////    char[] chars = cardNumber.toCharArray();
////
////    int replaceFrom = 0;
////    int replaceTo;
////
////    for (char c : chars) {
////      ++replaceFrom;
////      if (isDigit(c)) {
////        break;
////      }
////    }
////    System.out.println("replaceFrom " + replaceFrom);
////
////    int digitCounter = 0;
////    for (replaceTo = cardNumber.length() - 1;
////        (replaceTo > replaceFrom && digitCounter < 4);
////        replaceTo--) {
////      System.out.println(replaceTo);
////      if (isDigit(chars[replaceTo])) {
////        digitCounter++;
////      }
////    }
////
////    System.out.println("replaceTo " + replaceTo);
////
////    for (int i = replaceFrom; i <= replaceTo; i++) {
////      if (isDigit(chars[i])) {
////        chars[i] = '*';
////      }
////    }
////
////    System.out.println(chars);
////    return String.valueOf(chars);
//  }
//
//  private static boolean isDigit(char c) {
//    int zeroChar = '0';
//    int nineChar = '9';
//    int cInt = c;
//    if (c >= zeroChar && c <= nineChar) {
//      return true;
//    }
//    return false;
//  }
//}
//
//
//      while(front<=4 && front<chars.length)
//        if(isDigit(chars[i] && front<=4){
//        char[i]='#';
//       front++
//         }
//    }