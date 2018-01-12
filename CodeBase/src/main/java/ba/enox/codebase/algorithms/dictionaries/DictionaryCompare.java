package ba.enox.codebase.algorithms.dictionaries;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


	/**
	 * Our program is going do process the dictionary attached (wordlist.txt), looking for
		all six letter words which are composed of two concatenated smaller words (also
		from the dictionary).
	 * @author eno.ahmedspahic
	 * Dictionary Java simple working case
	 */
	public class DictionaryCompare {
		
		public static String DICTIONARY_SEPARATOR = " ";

		public static void main(String[] args) throws IOException {
					
			//read file and prepare dictionary
			String filePath = "C:\\Development\\workspaces\\eclipse\\DemoDictionary\\dictionaries\\src\\main\\resources\\ba\\enox\\javapractice\\collections\\dictionaries\\wordlist.txt";
			Set<String> dictionary= new HashSet<String>();
			Set<String> filtered= new HashSet<String>();
			
			
			FileReader fileReader =null;;
			try {
				fileReader = new FileReader(filePath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			BufferedReader reader = new BufferedReader(fileReader);
		
			System.out.println("++++++++++++READiNG LINES++++++++++++");
			String line =null;
			try {
				while((line=reader.readLine())!=null){
					//question2
					System.out.println("+++ new line : "+line);
					String[] splittedLineWords = line.split(DICTIONARY_SEPARATOR);
					for(String word:splittedLineWords){
						dictionary.add(word);
					}		
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("+++IOE can not read file");
				e.printStackTrace();
				throw e;
			}
			
			Long t1,t2;
			t1 = System.currentTimeMillis();
			//go trough dictionary 3x loops will be time consuming on large amount of records
			Iterator<String> iterator = dictionary.iterator();
			while(iterator.hasNext()){
				String currentValue = iterator.next();
				//when word length 6
				if(currentValue.length()==6){
					//check is word in dictionary combination of others
					for(String firstArgToCompare: dictionary){
						if (firstArgToCompare.length()<6){
							for(String secondToCompare : dictionary){
								if(secondToCompare.length()==(6-firstArgToCompare.length())){
									if (currentValue.equals(firstArgToCompare+secondToCompare) && !filtered.contains(currentValue))
										filtered.add(currentValue);
								}
							}	
						}				
					}
				}
			}
			t2 = System.currentTimeMillis();			

			System.out.println("Execution time "+((t2-t1)/1000) +"seconds" );
			System.out.println("+++ Filtered "+ filtered.size());	
			for(String s :filtered){
				System.out.println("+++ "+s);
			}
			
		}
		

	


	/*
	 * 
	 * question1 - what is word separator in dictionary - created constant
	 * question1 - what can be content of dictionary? empty lines, special characters, encoding
	 * 
	 * 
	 * 
	 * Notes from implementation
	 * 	this approach loops trough set and then is doing compare of all values between each other.
	 * 
	 * 	
	 * 	Find optimised presentation for dictionary purposes.
	 * 	It should support unique values and be handy for searching content.
	 *  Here I start to consider map presentation
	 *  And aproach of filtering while reading...to prevent additional loops.
	 * 	
	 */


}
