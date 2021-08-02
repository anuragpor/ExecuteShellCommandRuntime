import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecuteShellCommandRuntimeExec {

	public static void main(String[] args) {

		try {
			Process process = Runtime.getRuntime().exec(
			        new String[]{"cmd", "/c", "dir"},
			        null, 
			        new File("C:\\Users\\anura\\Desktop\\"));
			StringBuilder output = new StringBuilder(); 
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			String line;
			
			while((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
			
			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("Success");
				System.out.println(output);
				System.exit(0);
			} else {
				System.out.println("Something abnormal has haapened :( ");
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

