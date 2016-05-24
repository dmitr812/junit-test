package maven_test;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import junit.framework.TestCase;


@RunWith(Parameterized.class)
public class DataFileInput_test 
	extends TestCase 
{	
	private static DataFileInput fileData = new DataFileInput();		// объявление объекта класса DataFileInput
    private static int a1;			// переменная для operand1
    private static int a2;			// переменная для operand2
    private static String op;		// переменная для operation
    private static int res;			// переменная для result
        
   
    public DataFileInput_test(String operand1, String operand2, String operation, String result)  
    {	// конструктор класса:
    	// параметры передается в конструктор класса для инициализации полей класса, 
    	// 									которые будут содержать значения параметров
        this.a1 = Integer.parseInt(operand1);		
        this.a2 = Integer.parseInt(operand2);
        this.op = operation;
        this.res = Integer.parseInt(result);
    }
    
	
    @Parameterized.Parameters(name = "{index}: {0} {2} {1} = {3}")		// передаем параметры из файла данных
    public static ArrayList<String[]> params()					
    {
    	ArrayList<String[]> resultList = new ArrayList<String[]>();	// создаем ArrayList для результата
    	resultList = fileData.getFileData("dataFile.txt");			// читаем данные из файла в ArrayList
    	return resultList;											// возвращаемый тип метода должен быть List[]	
    }										// значения из resultList передаются в конструктор в качестве аргументов
    

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	 public void testRunning() 
    {
        switch (op) 
        { 
        	case "+":
        		System.out.println(a1 + op + a2 + "=" + res + "   #expected: " + (a1 + a2));
        		Assert.assertEquals(res, a1 + a2);
        		break; 
        		
        	case "-":
        		System.out.println(a1 + op + a2 + "=" + res + "   #expected: " + (a1 - a2));
        		Assert.assertEquals(res, a1 - a2);
                break;

        	case "*":
        		System.out.println(a1 + op + a2 + "=" + res + "   #expected: " + (a1 * a2));
        		Assert.assertEquals(res, a1 * a2);
            	break;
                
            case "/":
            	System.out.println(a1 + op + a2 + "=" + res + "   #expected: " + (a1 / a2));
            	Assert.assertEquals(res, a1 / a2, 1);
            	break;
            
            default:
                Assert.fail("Error in operation");
                break;
        }
        
    }

}
