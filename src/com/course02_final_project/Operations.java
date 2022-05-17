package com.course02_final_project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Operations implements OperationsInterface {

	private String dirPath = "C:\\Users\\idol\\Desktop\\fileIO";

	private File file = new File(dirPath);

	public ArrayList<String> getFileNames() {
		ArrayList<String> myList = new ArrayList<String>();

		try {
			String[] readList = file.list();
			Collections.addAll(myList, readList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return myList;

	}

	@Override
	public void addFile(String userDefinedFile, String url) throws IOException {

		FileOutputStream file = new FileOutputStream(url);
		String data = new String("File:" + userDefinedFile + " created from Virtual Key App");
		byte[] arrayOfBytes = data.getBytes();
		file.write(arrayOfBytes);
		file.close();
		System.out.println("File created successfuly!\n");

	}

	@Override
	public int deleteFile(String userInputDelete, ArrayList<String> listOfFileNames, String deleteUrl) {

		File fileToDelete = new File(deleteUrl);
		if (listOfFileNames.contains((userInputDelete.toLowerCase()) + ".txt") == true) {
			fileToDelete.delete();
			System.out.println("\nFile Deleted Succesfully!\n\nReturning to menu. . .");
			return 1;
		} else {
			while (true) {
				System.out.println("\nError: File not found.\n");
				return 0;
			}

		}
	}

	@Override
	public int search(String userInputSearch, ArrayList<String> listOfFileNames) {

		boolean isElementFound = listOfFileNames.contains(userInputSearch.toLowerCase() + ".txt");

		if (isElementFound == true) {
			System.out.println("\nFile found!\n");
			return 1;

		} else {
			System.out.println("\nError: File not found.\n");
			return 0;
		}

	}

}
