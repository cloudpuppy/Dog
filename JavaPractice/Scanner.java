//Scanner사용
Scanner sc = new Scanner(System.in);
String input = sc.nextLine();
System.out.println("Output : " + input);

//Scanner 무한입력
Scanner sc = new Scanner(System.in);
while (sc.hasNextLine()) {
  System.out.println(sc.nextLine());
}
sc.close();

//BufferedReader 사용
InputStreamReader reader = new InputStreamReader(System.in);
BufferedReader br = new BufferedReader(reader);
String input = br.readLine();
System.out.println("Output : " + input);