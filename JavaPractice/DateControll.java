//현재 날짜, 시각 문자열로 가져오기
LocalDateTime now = LocalDateTime.now();
String strDT = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));

long ct = System.currentTimeMillis();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
String strCT = sdf.format(ct);

//문자열 날짜, 시각 → Date 타입으로 변경
String strTime = "2022-03-31 21:40:15";
SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date dt = transFormat.parse(strTime);

//Date 타입 → LocalDateTime 타입으로 변경
LocalDateTime dt = dt.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

//시간 차이 계산
String start = "20220331142310";
String end = "20220331142420";
SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
Date dd1 = sf.parse(start);
Date dd2 = sf.parse(end);
long diff = dd2.getTime() - dd1.getTime();
System.out.println(diff / 1000); // Sec Difference 