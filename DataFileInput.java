package maven_test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class DataFileInput 
{
	public static ArrayList<String[]> dataList = new ArrayList<String[]>();	
	// создаем ArrayList для результата

	public ArrayList<String[]> getFileData(String fileName)	// метод: читает данные из файла в ArrayList     
	{
		String str1;		// переменная для строки данных 
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader("dataFile.txt"));
			while ((str1 = reader.readLine()) != null) 
			{
				dataList.add(str1.split(";"));			// добавляем в ArrayList разделенные строки
			}
			System.out.println("...File reading successful... \n");
		} 
		catch (IOException e) 
		{
			System.err.format("IOExc:", e);
		}

		return dataList;
	}
}
