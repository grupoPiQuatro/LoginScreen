/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginscreen;

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
//      Main para testes
//	public static void main(String[] args) throws IOException {
//            String data = getDate();
//            generateLog(data + " o Log está funcionando");
//	}
        
        public static String getDate(){
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            return dateFormat.format(date);
        }
	
	public static void generateLog(String message) throws IOException {
		
//		Path path = Paths.get("C:\\Users\\lukas\\OneDrive\\Área de Trabalho\\logs
		Path path = Paths.get("~/logs");
		
		if(!Files.exists(path)) {
			
			Files.createDirectory(path);
			
		}
		
//		File log = new File("C:\\Users\\lukas\\OneDrive\\Área de Trabalho\\logs\\logs.txt");
		File log = new File("~/logs/logs.txt");
		
		if(!log.exists()) {
			
			log.createNewFile();
		
		}
		
		FileWriter fw = new FileWriter(log, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(getDate() + " " + message);
		bw.newLine();

		bw.close();
		fw.close();
		
	}
}