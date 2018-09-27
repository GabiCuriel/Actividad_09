package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ModelCyD {
    private String path;
    public String message;
    
    public String getPath(){
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public void readFileDecrypted(String path){
        try{
            String row;
            int ascii;
            char caracter; 
            char decifrado; 
            String mensaje="";
            String x="";
            try (FileReader file = new FileReader(path)){
                BufferedReader bufferedReader;
                bufferedReader= new BufferedReader (file);
                while((row = bufferedReader.readLine()) != null){
                    for(int i=0;i<row.length();i++){
                        caracter = row.charAt(i);
                        ascii=(int)caracter;
                        ascii-= 19;
                        decifrado=(char)ascii;
                        mensaje+=decifrado;
                    }
                    mensaje+="\n";
                }
                this.setMessage(mensaje);
                bufferedReader.close();
        }catch (FileNotFoundException err){
            System.out.println("File not found:" +err.getMessage());
        }
        }catch (IOException err){
            System.err.println("Error on I/O operation" +err.getMessage());
        }
    }
    public void writeFileEncrypted(String path, String message){ 
        try {
            char caracter;
            String cifrado = "";
            int ascii; 
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, false); 
            try (PrintWriter printWriter = new PrintWriter(fileWriter)){
                for(int x=0;x<message.length();x++){
                    caracter=message.charAt(x);
                    ascii=(int)caracter;
                    ascii+=19;
                    cifrado+=(char)ascii;
                }
                printWriter.println(cifrado);
                printWriter.close();
            }
        }catch (FileNotFoundException err){
            System.out.println("File not found:" +err.getMessage());
        }catch (IOException err){
            System.err.println("Error on I/O operation" +err.getMessage());
        } 
    } 
    public void readFile(String path){
        try {
            String row;
            String x="";
            try (FileReader file = new FileReader(path)){
                BufferedReader bufferedReader = new BufferedReader (file);
                while((row = bufferedReader.readLine()) != null){
                    x=x+row+"\n";
                    this.setMessage(x);
                    System.out.println(row);
                }
                this.setMessage(x);
                bufferedReader.close();
            }
        }catch (FileNotFoundException err){
            System.out.println("File not found:" +err.getMessage());
        }catch (IOException err){
            System.err.println("Error on I/O operation" +err.getMessage());
        }
    }
    public void writeFile(String path, String message){ 
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, false); 
            try (PrintWriter printWriter = new PrintWriter(fileWriter)){
                printWriter.println(message);
                printWriter.close();
            }
        }catch (FileNotFoundException err){
            System.out.println("File not found:" +err.getMessage());
        }catch (IOException err){
            System.err.println("Error on I/O operation" +err.getMessage());
        } 
    }
}

