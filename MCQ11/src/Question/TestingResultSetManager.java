package Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.sun.rowset.CachedRowSetImpl;

public class TestingResultSetManager {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		/*
		//Testing with no keys or values specified
		SQLiteQuestionDatabaseManager test = new SQLiteQuestionDatabaseManager("QuestionDB");
		ResultSet testRes = test.getQuestions(2);
		
		HashMap<Integer,Object> output = new HashMap<Integer,Object>();
		output = ResultSetManager.resultSetToMap(testRes);
		
		for (int i : output.keySet()) {
			Object[] valuesArray = (Object[]) output.get(i);
			
			//QuestionID
			System.out.println(valuesArray[0]);
			
			//Question text
			System.out.println(valuesArray[1]);
			
			//Question Image
			System.out.println(valuesArray[2]);
			
			//Option1
			System.out.println(valuesArray[3]);
			
			//Option2
			System.out.println(valuesArray[4]);
			
			//Option3
			System.out.println(valuesArray[5]);
			
			//Option4
			System.out.println(valuesArray[6]);
			
			//Correct Answer
			System.out.println(valuesArray[7]);
		}
		*/
		
		//Testing with key and values specified. This example will make a HashMap with the 
		//QuestionID as the Key and an array of QuestionText, QuestionImage, and Option1 as values
		SQLiteQuestionDatabaseManager test = new SQLiteQuestionDatabaseManager("QuestionDB");
		CachedRowSetImpl testRes = test.getQuestions(2);
		
		CachedRowSetImpl testRes2 = test.getTopics();
		
		int[] values = {2, 3, 4};
		
		HashMap<Integer, String[]> output = new HashMap<Integer, String[]>();
		output = ResultSetUtils.CachedRowSetImplToMap(testRes, 1, values);		
		
		Object[] valuesArray = (Object[]) output.get(1);
		
		
		System.out.println(valuesArray[0]);
		System.out.println(valuesArray[1]);
		System.out.println(valuesArray[2]);
		
	}

}
