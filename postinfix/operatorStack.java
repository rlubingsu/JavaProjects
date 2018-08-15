import java.util.*;
import java.io.*;
import java.util.*;
public class operatorStack 
{
 LinkedList<String> n;
 
 private operatorStack(){
	 n = new LinkedList();
 }
private String topOfStack(){
	String valExp = getValExp();
	push(valExp);
	return valExp;
}
private void push(String valExp) {
	 pushiIn(valExp);
	
}
private void pushIn(String o){
	n.addFirst(o);
}
private String getValExp() {
	// TODO Auto-generated method stub
	return 0;
}

} 