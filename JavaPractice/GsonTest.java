import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

public class GsonTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		solve1();
		solve2();
		solve3();
		solve4();
	}

	static void solve1() {
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("name", "spiderman");
		jsonObj.addProperty("age", 45);
		jsonObj.addProperty("married", true);
		
		JsonArray jsonArr = new JsonArray();
		jsonArr.add("martial art");
		jsonArr.add("gun");
		jsonObj.add("specialty", jsonArr);
		
		JsonObject jsonObj2 = new JsonObject();
		jsonObj2.addProperty("1st", "done");
		jsonObj2.addProperty("2nd", "expected");
		jsonObj2.add("3rd", null);		
		jsonObj.add("vaccine", jsonObj2);
	
		JsonArray jsonArr2 = new JsonArray();
		jsonObj2 = new JsonObject();
		jsonObj2.addProperty("name", "spiderboy");
		jsonObj2.addProperty("age", 10);
		jsonArr2.add(jsonObj2);
	
		jsonObj2 = new JsonObject();
		jsonObj2.addProperty("name", "spidergirl");
		jsonObj2.addProperty("age", 8);
		jsonArr2.add(jsonObj2);

		jsonObj.add("children", jsonArr2);
		jsonObj.add("address", null);
		
		try (Writer writer = new FileWriter("sample.json")) {
		    Gson gson = new GsonBuilder().serializeNulls().create();
		    gson.toJson(jsonObj, writer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	static void solve2() {
		String filePath = "sample.json";
		try {
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new FileReader(filePath));
			JsonObject jsonObj = gson.fromJson(reader, JsonObject.class);

			String name = jsonObj.get("name").getAsString();
			int age = jsonObj.get("age").getAsInt();
			System.out.println("name:"+name + "("+age+")");
			
			JsonArray jsonArr = jsonObj.get("children").getAsJsonArray();
			JsonObject jsonObj2 = jsonArr.get(1).getAsJsonObject();
			name = jsonObj2.get("name").getAsString();
			age = jsonObj2.get("age").getAsInt();
			System.out.println("name:"+name + "("+age+")");
					
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	static void solve3() {
		String filePath = "sample.json";
		Path jsonFilePath = Paths.get(filePath);
		try {
			String wholeData = new String(Files.readAllBytes(jsonFilePath));
			Gson gson = new Gson();
			JsonObject jsonObj = gson.fromJson(wholeData, JsonObject.class);
			
			for (String key : jsonObj.keySet()) {
				System.out.print("Key : "+key+" / Value Type : ");
				JsonElement je = jsonObj.get(key);
				if (je.isJsonPrimitive()) {
					if (je.getAsJsonPrimitive().isString()) {
						System.out.println("String"); 
					}
					else if (je.getAsJsonPrimitive().isNumber())
					{
						System.out.println("Number");
					}
					else if (je.getAsJsonPrimitive().isBoolean()) {
						System.out.println("Boolean");
					}
					else if (je.getAsJsonPrimitive().isJsonNull()) {
						System.out.println("null");
					}
				}
				else if (je.isJsonArray()) {
					System.out.println("Array");
				}
				else if (je.isJsonObject()) {
					System.out.println("Object");					
				}
				else if (je.isJsonNull()) {
					System.out.println("null");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	static void solve4() throws IOException {
		String filePath = "sample.json";
		Path jsonFilePath = Paths.get(filePath);
		String wholeData = new String(Files.readAllBytes(jsonFilePath));
		Gson gson = new Gson();
		JsonTest jTest = gson.fromJson(wholeData, JsonTest.class);
		System.out.println(jTest.name + " " + jTest.age);
	}

	static void readFromFile() throws IOException {
		CommandInfoData commandInfoData = gson.fromJson(
				String.join("", Files.readAllLines(Paths.get("INFO/COMMAND.JSON"))),
				CommandInfoData.class);
		commandInfoMap = new HashMap<>();
		for (CommandInfo commandInfo : commandInfoData.getServerCommandInfoList()) {
			this.commandInfoMap.put(commandInfo.getCommand(), commandInfo);
		}
	}
}
