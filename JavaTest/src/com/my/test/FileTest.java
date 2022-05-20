package com.my.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileTest {
	private static final String ArrayList = null;
	static String fileRootPath = "./TESTIN";
	
	public static void main(String[] args) {
		
		//현재 작업 디렉토리 가져오기 
		String path = System.getProperty("user.dir");
		System.out.println("Working Directory = " + path);
		
		//상대경로에서 절대경로로 변환하기
		Path relativePath = Paths.get("");
		String currentPath = relativePath.toAbsolutePath().toString();
		System.out.println("currnt Path = " + currentPath);
		
		//1. 파일 찾아서 복사하기 
		/*
		SearchAllFiles(fileRootPath);
		*/
		
		//2. 파일 읽기
		String fileName = "./TESTIN/DOC/PROJECT/inputText.txt";		
		ArrayList<Score> result = new ArrayList<>();
		result = readFiles(fileName);
		
		printResult(result);
		
		//3.Sort
		Collections.sort(result, new Comparator<Score>() {
			@Override
			public int compare(Score o1, Score o2) {
				if(o1.total != o2.total) return o2.total - o1.total;
				if(o1.score1 != o2.score1) return o2.score1 - o1.score1;
				else return o1.testNum - o2.testNum;
			}
		});
		
		printResult(result);
		//3.파일 쓰기
		writeFiles(result);
		
	}

	private static void printResult(java.util.ArrayList<Score> result) {
		for (Score score : result) {
			System.out.println("Name : " + score.name + " Total : " +score.total);
		}
		
	}

	private static ArrayList<Score>  readFiles(String fileName) {
		
		ArrayList<Score> result = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line;
			while ((line = br.readLine()) != null) {
				if("Q".equals(line)) break;
				result.add(Score.parseResult(line));			
			}
		} catch (Exception e) {
		}
		return result;
	}

	private static void writeFiles(ArrayList<Score> result) {
		String outFileName = "./TESTIN/DOC/PROJECT/outputText.txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFileName))){
			for (Score score : result) {
				bw.write(score.name + "#"+ score.score1 + "#" + score.scroe2 + "#" + score.total + "\n");
			}
			bw.flush();
			bw.close();
		}catch (Exception e) {
		}
	
	}



	/**
	 * Wearch All File in Directory
	 * @param path
	 */
	private static void SearchAllFiles(String path) {
		File directory = new File(path);
		File[] fList = directory.listFiles();
		
		for(File file : fList) {
			if(file.isDirectory()) {
				SearchAllFiles(file.getPath());
			}
			else {
				String partPath = path.substring(fileRootPath.length());
			//	System.out.println("." + partPath + "\\" + file.getName());
				if(file.getName().startsWith("1")) {
					copyFile(partPath, file.getName());
				}
			}
		}
		
	}

	/*
	 * File Copy 
	 */
	private static void copyFile(String partPath, String name) {
		final int BUFFER_SIZE = 512;
		int readLen;
		try {
			File destFolder = new File("./TESTOUT" + partPath);
			if(!destFolder.exists()) {
				destFolder.mkdirs();
			}
			
			InputStream inputStr = new FileInputStream("./TESTIN" + partPath + "/" + name);
			OutputStream outputStr = new FileOutputStream("./TESTOUT" + partPath + "/" + name);
			
			byte[] buffer = new byte[BUFFER_SIZE];
			while((readLen = inputStr.read(buffer)) != -1) {
				outputStr.write(buffer,0,readLen);
			}
			inputStr.close();
			outputStr.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
