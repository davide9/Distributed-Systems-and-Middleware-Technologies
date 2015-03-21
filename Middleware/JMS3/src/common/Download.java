package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Download {
	
	public static File downloadHtml(BufferedReader reader, String name) {
		File file = null;
		try {
			file = File.createTempFile(name, ".html");
		} catch (IOException e) {
			e.printStackTrace();
		}
        file.deleteOnExit();
        
        String line = "", all = "";
        
        try {
			while ((line = reader.readLine()) != null) {
			    all += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        PrintWriter writer = null;
		try {
			writer = new PrintWriter(file,"UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		writer.write(all) ;
		writer.flush();
		writer.close();

        //start downloading the source
        /*
        try {
        	
			Writer writer = new OutputStreamWriter(new FileOutputStream(file));
			
			while (true) {
	            String line = null;
	            
	            //READ LINE
				try {
					line = reader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
	            if (line == null) break;
	            
	            //WRITE LINE
	            try {
					writer.write(line);
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		*/
		return file;
	}

}
