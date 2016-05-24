package maven_test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class DataFileInput 
{
	public static ArrayList<String[]> dataList = new ArrayList<String[]>();	
	// ������� ArrayList ��� ����������

	public ArrayList<String[]> getFileData(String fileName)	// �����: ������ ������ �� ����� � ArrayList     
	{
		String str1;		// ���������� ��� ������ ������ 
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader("dataFile.txt"));
			while ((str1 = reader.readLine()) != null) 
			{
				dataList.add(str1.split(";"));			// ��������� � ArrayList ����������� ������
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
