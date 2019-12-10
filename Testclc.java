  
package Test; 
import org.junit.Test; 
import junit.framework.Assert; 
import qwe.calculator; 
public class Testclc { 
@Test 
public void testing(){ 
calculator k = new calculator(); 
float A=k.Result(100000,10,4); 
if(A!=27500)Assert.fail(); 
} 
}