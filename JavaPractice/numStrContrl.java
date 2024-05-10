//10진수 4자리로 출력
int a = 14;
System.out.println(String.format("%04d", a));

//16진수 출력
int a = 14;
System.out.println(String.format("%02X %02x", a, a));

//소수점 출력
double b = 12.345678;
System.out.println(String.format("%08.3f", b));

//위치로자르기
String strTest = "My book | Your pen | His desk";
System.out.println(strTest.substring(10));
//10자리부터 끝까지
System.out.println(strTest.substring(10, 18));
//10자리에서 18자리까지

//Delimiter 사용하여 자르기
String strTest = "My book | Your pen | His desk";
String[] words = strTest.split(" \\| ");
//파이프(|)문자는 이스케이프 처리(\\)가 필요함
for (String item: words)
  System.out.println(item);

//String → Byte Array
byte[] byteTest = new byte[80];
byteTest = strTest.getBytes("UTF-8");
for (byte b: byteTest)
  System.out.print(b + " ");

//Byte Array → String
String strTest2 = new String(byteTest);
System.out.println(strTest2);