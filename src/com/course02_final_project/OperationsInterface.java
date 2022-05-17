package com.course02_final_project;

import java.io.IOException;
import java.util.ArrayList;

public interface OperationsInterface {

	public void addFile(String userInput, String url) throws IOException;

	public int deleteFile(String userInput, ArrayList<String> listOfFileNames, String deleteUrl);

	public int search(String userInput, ArrayList<String> listOfFileNames);

}
