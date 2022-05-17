package com.course02_final_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class VirtualKeyMain {

	public static void main(String[] args) throws InterruptedException {

		Operations operations = new Operations();
		ArrayList<String> listOfFileNames;

		try {
			parentLoop: while (true) {

				listOfFileNames = operations.getFileNames();
				Scanner scanner = new Scanner(System.in);
				
				Collections.sort(listOfFileNames);

				System.out.println(
						"*********************************** LoCkedMe.cOm ***********************************\n");

				System.out.println("Hello, Welcome to the Virtual Key App. Please choose one of the options below:\n");

				System.out.println("Press '1' To list all the files present in the current directory."
						+ "\nPress '2' If you would like to Add, Delete, or Search for a specific file."
						+ "\nPress '3' To Exit the application.");
				System.out.println("\nApp Details:" + "\nDeveloper         - Bongani Mdletshe"
						+ "\nEmployment        - Junior Java Developer at Simplilearn"
						+ "\nContact Details   - bongani.mdletshe@simplilearn.org" + "\nApp version       - v1.1.01\n");
				System.out.print("Enter your option here: ");

				int inputFromUser = scanner.nextInt();

				if (!(inputFromUser == 1 || inputFromUser == 2 || inputFromUser == 3)) {
					System.out.println("\nERROR: wrong selectiong...");
					System.out.println("\nPlease select one of the options below:");

					innerLoop: while (!(inputFromUser == 1 || inputFromUser == 2 || inputFromUser == 3)) {
						listOfFileNames = operations.getFileNames();

						System.out.println("\nPress '1' To list all the files present in the current directory."
								+ "\nPress '2' If you would like to Add, Delete, or Search for a specific file."
								+ "\nPress '3' to return to the main menue."
								+ "\nPress '4' to terminate the application.");
						int userInputTwo = scanner.nextInt();

						if (userInputTwo == 1) {

							if (listOfFileNames.isEmpty() == true) {
								System.out.println("The default directory is currently empty...");
							} else {
								System.out.println("Please see the list of file names below:\n");
								for (String fileName : listOfFileNames) {
									System.out.println(fileName);
								}
								System.out.println("\nReturning to menu. . .");
							}

							continue;

						} else if (userInputTwo == 2) {

							try {
								while (true) {

									Scanner scanner2 = new Scanner(System.in);
									listOfFileNames = operations.getFileNames();

									System.out.println("Hello there,\n\nPlease choose an option below:\n");
									System.out.println("Press '1' to List the names of the existing file.\n"
											+ "Press '2' to Add a new file to the existing directory.\n"
											+ "Press '3' to Delete a file from the existing directory.\n"
											+ "Press '4' to Search for a file in the existing directory.\n"
											+ "Press '5' to return to the main menu...");

									int userOption2 = scanner2.nextInt();

									if (userOption2 == 1) {
										System.out.println("List of file names:\n");
										if (listOfFileNames.isEmpty() == true) {
											System.out.println("The default directory is currently empty...");
										} else
											for (String fileName : listOfFileNames) {
												System.out.println(fileName);
											}
										System.out.println("\n");

									} else // add
									if (userOption2 == 2) {

										while (true) {

											System.out.print(
													"Please enter the name of the file you want to add or 'q' to quit:\n");
											String userInputAdd = scanner2.next();
											if (!(userInputAdd.toLowerCase().equals("q"))) {
												String urlAdd = "C:\\Users\\idol\\Desktop\\fileIO\\"
														+ userInputAdd.toLowerCase() + ".txt";
												operations.addFile(userInputAdd, urlAdd);
											} else {
												if (userInputAdd.toLowerCase().equals("q")) {
													System.out.println("Returning to menu. . . ");
													break;
												}

											}

										}

									} else // delete
									if (userOption2 == 3) {

										while (true) {
											listOfFileNames = operations.getFileNames();
											System.out.print(
													"Enter the name of the file you want to delete or press 'q' to quit:");
											String userInputDelete = scanner2.next();

											if (userInputDelete.toLowerCase() != "q") {
												String deleteUrl = "C:\\Users\\idol\\Desktop\\fileIO\\"
														+ userInputDelete.toLowerCase() + ".txt";

												int fileFound = operations.deleteFile(userInputDelete, listOfFileNames,
														deleteUrl);

												if (fileFound != 1) {
													continue;
												} else
													break;
											} else {
												if (userInputDelete.toLowerCase().equals("q")) {
													break;
												}
											}

										}

									} else
									// search
									if (userOption2 == 4) {

										searchLoop: while (true) {

											listOfFileNames = operations.getFileNames();

											System.out.print("Enter the name of the file to search or 'q' to quit:");
											String userInputSearch = scanner2.next();
											if (listOfFileNames.isEmpty() == true) {
												System.out.println(
														"\nThe default directory is currently empty.\n\nReturning to menu. . .");
												break;
											} else {
												if (userInputSearch.toLowerCase().equals("q")) {
													break;
												} else {
													int isFileAvailable = operations.search(userInputSearch,
															listOfFileNames);

													if (isFileAvailable == 1) {
														break searchLoop;
													} else {
														continue;
													}
												}
											}
										}

									} else if (userOption2 == 5) {

										break;
									} else {
										System.out.println("Sorry wrong input, please try again");
									}

								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						} else if (userInputTwo == 3) {

							break innerLoop;
						} else if (userInputTwo == 4) {
							System.out.println(
									"\nThank you for using the lockedMe app." + "\n\nTerminating Application. . .  ");

							Thread.sleep(2000);

							System.out.println("\nTerminated successfully!");
							break parentLoop;
						} else {
							System.out.println("Wrong selection...Please try again.");
						}

					}
				} else if (inputFromUser == 1) {

					if (listOfFileNames.isEmpty() == true) {
						System.out.println("\nThe default directory is currently empty.");
					} else
						System.out.println("\nPlease see list of file in the default directory:\n");
					for (String item : listOfFileNames) {
						System.out.println(item);
					}
					System.out.print("\nReturning to main menu. . .\n\n");
					continue;
				} else if (inputFromUser == 2) {

					// ************************code for option 2*********************************

					while (true) {
						System.out.println("\nPlease choose one of the options below:");

						Scanner scanner2 = new Scanner(System.in);
						listOfFileNames = operations.getFileNames();

						System.out.println("\nPress '1' to List the names of the existing file.\n"
								+ "Press '2' to Add a new file to the existing directory.\n"
								+ "Press '3' to Delete a file from the existing directory.\n"
								+ "Press '4' to Search for a file in the existing directory.\n"
								+ "Press '5' to return to the main menu...");

						int userOption2 = scanner2.nextInt();

						if (userOption2 == 1) {

							if (listOfFileNames.isEmpty() == true) {
								System.out.println("The default directory is currently empty.");
							} else {
								System.out.println("Please see list of file in the default directory:\n");
								for (String fileName : listOfFileNames) {
									System.out.println(fileName);
								}
								System.out.println("\nReturning to menu. . .");
							}

						} else // add
						if (userOption2 == 2) {
							while (true) {

								System.out.print("Please enter the name of the file you want to add or 'q' to quit:\n");
								String userInputAdd = scanner2.next();
								if (!(userInputAdd.toLowerCase().equals("q"))) {
									String urlAdd = "C:\\Users\\idol\\Desktop\\fileIO\\" + userInputAdd.toLowerCase()
											+ ".txt";
									operations.addFile(userInputAdd, urlAdd);
								} else {
									if (userInputAdd.toLowerCase().equals("q")) {
										System.out.println("Returning to menu. . . ");
										break;
									}
								}
							}

						} else // delete
						if (userOption2 == 3) {

							while (true) {
								listOfFileNames = operations.getFileNames();
								System.out.print("Enter the name of the file you want to delete or press 'q' to quit:");
								String userInputDelete = scanner2.next();

								if (userInputDelete.toLowerCase() != "q") {
									String deleteUrl = "C:\\Users\\idol\\Desktop\\fileIO\\"
											+ userInputDelete.toLowerCase() + ".txt";

									int fileFound = operations.deleteFile(userInputDelete, listOfFileNames, deleteUrl);

									if (fileFound != 1) {
										continue;
									} else
										break;
								} else {
									if (userInputDelete.toLowerCase().equals("q")) {
										break;
									}
								}
							}

						} else
						// search
						if (userOption2 == 4) {

							searchLoop: while (true) {

								listOfFileNames = operations.getFileNames();

								System.out.print("Enter the name of the file to search or 'q' to quit:");
								String userInputSearch = scanner2.next();
								if (listOfFileNames.isEmpty() == true) {
									System.out.println(
											"\nThe default directory is currently empty.\n\nReturning to menu. . .");
									break;
								} else {
									if (userInputSearch.toLowerCase().equals("q")) {
										break;
									} else {
										int isFileAvailable = operations.search(userInputSearch, listOfFileNames);

										if (isFileAvailable == 1) {
											break searchLoop;
										} else {
											continue;
										}
									}
								}
							}

						} else if (userOption2 == 5) {

							break;
						} else {
							System.out.println("Sorry wrong input, please try again.");
						}
					}

					// **************************end of code for option 2*************************

					continue;
				} else if (inputFromUser == 3) {
					System.out
							.println("\nThank you for using the lockedMe app." + "\n\nTerminating Application. . .  ");

					Thread.sleep(2000);

					System.out.println("\nTerminated successfully!");
					break;
				}

			}
		} catch (Exception e) {
			System.out.println("\nWrong input. Application terminating. . .");
			Thread.sleep(3000);
			System.out.println("\nTerminated successfully!");
		}

	}
}