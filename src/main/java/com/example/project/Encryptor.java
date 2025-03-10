package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {
    public static void main(String[] args) {
        System.out.println(Encryptor.encryptMessage("Hello World!", 3));
        System.out.println(decryptMessage(" ose=wtic!o  iehutnd oi ioy ysl ?rtleyeueravoHad  ", 6));
    }
    public static int determineColumns(int messageLen, int rows){
        return messageLen == 0 ? 1 : (int) Math.ceil((double) messageLen/rows);
    }
    
    public static String[][] generateEncryptArray(String message, int rows) {
        String[][] result = new String[rows][determineColumns(message.length(), rows)];
        int count = 0;
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                if(count < message.length()){
                result[i][j] = message.substring(count, count+1);
                count++;
                } else{
                    result[i][j] = "=";
                }
            }
        }
        return result;
    }

    public static String encryptMessage(String message, int rows){
        String[][] result = generateEncryptArray(message, rows);
        String encrypted = "";
        for(int i = result[0].length - 1; i >= 0; i--){
            for(int j = 0; j < result.length; j++){
                encrypted+= result[j][i];
            }
        }
        return encrypted;
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
        String[][] array = new String[rows][determineColumns(encryptedMessage.length(), rows)];
        String result = "";
        int count = 0;
        for(int i = array[0].length - 1; i >= 0; i--){
            for(int j = 0; j < array.length; j ++){
                if(count < encryptedMessage.length()){
                    array[j][i] = encryptedMessage.substring(count, count+1);
                    count++;
                } else{
                    array[j][i] = "=";
                }
            }
        }

        for(String[] row : array){
            for(String str : row){
                if(!str.equals("=")){
                    result+= str; 
                }
            }
        }
        return result;
    }
}