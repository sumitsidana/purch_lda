package preProcess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConvertLDAOpTOTopicDistributions {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileName = args[0];
		try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
			String line;
			Map<Integer,Double>topicProbability = new LinkedHashMap<Integer,Double>();
			while ((line = br.readLine()) != null) {
				// TODO Auto-generated method stub
				topicProbability = new LinkedHashMap<Integer, Double>();
				for(int i = 0 ; i <= 100 ; i++){
					topicProbability.put(i, 0.0);
				}
				String [] array = line.split(" ");
				double numWords = array.length - 1;
				for(int i = 1 ; i < array.length ; i ++){
					String []topicArray = array[i].split(":");
					int topic = Integer.parseInt(topicArray[1]);
					double probaB = topicProbability.get(topic);
					probaB = probaB + 1.0/numWords;
					topicProbability.put(topic, probaB);
				}
				System.out.println(topicProbability);
			}
			br.close();
		}


	}
}

