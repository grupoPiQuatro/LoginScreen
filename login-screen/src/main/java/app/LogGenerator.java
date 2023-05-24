/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 *
 * @author lukas
 */
public class LogGenerator {
        public static String getDate(){
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            return dateFormat.format(date);
        }
	
	public static void generateLog(String message) throws IOException {
		Path path = Paths.get("./logs");
		
		if(!Files.exists(path)) {
			
			Files.createDirectory(path);
			
		}
                
		File log = new File("./logs/logs.txt");
		
		if(!log.exists()) {
			
			log.createNewFile();
		
		}
		
		FileWriter fw = new FileWriter(log, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("["+ getDate() + "] [INFO] " + message);
		bw.newLine();

		bw.close();
		fw.close();
		
	}
        
        public static void generateLogErro(String message) throws IOException {
		Path path = Paths.get("./logs");
		
		if(!Files.exists(path)) {
			
			Files.createDirectory(path);
			
		}
		
		File log = new File("./logs/logs.txt");
		
		if(!log.exists()) {
			
			log.createNewFile();
		
		}
		
		FileWriter fw = new FileWriter(log, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("["+ getDate() + "] [ERRO] " + message);
		bw.newLine();

		bw.close();
		fw.close();
        }
}