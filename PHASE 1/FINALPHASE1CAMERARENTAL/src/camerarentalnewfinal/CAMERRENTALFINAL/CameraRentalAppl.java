package camerarentalnewfinal;


	import java.util.ArrayList;
	import java.util.InputMismatchException;
	import java.util.List;
	import java.util.Scanner;
	public class CameraRentalAppl {

		private static List<Camera> cameraList = new ArrayList<>();
		private static Wallet wallet;
		private static String username;
		private static String password;
		private static int camID=0;
		
		public void start() {
			initializeApp();
			login();
		}

		private static void initializeApp() {
			
			cameraList.add(new Camera(++camID, "Chroma", "DS123", 500.0, true));
			cameraList.add(new Camera(++camID, "Sony", "HD214", 500.0, true));
			cameraList.add(new Camera(++camID, "Panasonic", "XC", 1000.0, true));
			cameraList.add(new Camera(++camID, "Nikon", "2030", 500.0, false));
			cameraList.add(new Camera(++camID, "Canon", "5050", 2500.0, true));
			cameraList.add(new Camera(++camID, "Samsung", "CT21", 750.0, false));
			cameraList.add(new Camera(++camID, "Olympus", "OM5", 1200.0, true));
			cameraList.add(new Camera(++camID, "Pentax", "PMX21", 1300.0, false));
			cameraList.add(new Camera(++camID, "Nikon", "Z50", 1500.0, true));
			cameraList.add(new Camera(++camID, "Sony", "A6100", 900.0, true));
			wallet = new Wallet(2500);
		}
		
		private static void login() {
			Scanner scanner = new Scanner(System.in);
			boolean loggedIn = false;
			
			System.out.println("+------------------------------+");
			System.out.println("| WELCOME TO CAMERA RENTAL APP |");
			System.out.println("+------------------------------+");
		
			while (!loggedIn) {
				System.out.println("PLEASE LOGIN TO CONTINUE");
				System.out.print("USERNAME :  ");
				username = scanner.nextLine();
				System.out.print("PASSWORD :  ");
				password = scanner.nextLine();

				if (isValidCredentials(username, password)) {
					loggedIn = true;
					System.out.println("LOGIN SUCCESSFUL!");
					handleMainMenu(scanner);
				} else {
					System.out.println("INVALID USERNAME/PASSWORD. PLEASE TRY AGAIN!");
				}
			}
		}
		
		private static boolean isValidCredentials(String username, String password) {
			return username.equals("admin") && password.equals("1234");
		}

		private static void handleMainMenu(Scanner scanner) {
			boolean exit = false;
			
			while (!exit) {
				System.out.println("\nOPTIONS:");
				System.out.println("1. MY CAMERAS");
				System.out.println("2. RENT A CAMERA");
				System.out.println("3. VIEW ALL CAMERAS");
				System.out.println("4. MY WALLET");
				System.out.println("5. EXIT");
				System.out.print("\nENTER OPTION: ");
				try {
					int option = Integer.parseInt(scanner.nextLine());

					switch (option) {
					case 1:
						handleMyCamera(scanner);
						break;
					case 2:
						handleRentCamera(scanner);
						break;
					case 3:
						displayCameraList(3);	
						break;
					case 4:
						handleMyWallet(scanner);
						break;
					case 5:
						exit = true;
						break;
					default:
						System.out.println("INVALID OPTION. PLEASE TRY AGAIN.");
					}
				} catch (NumberFormatException e) {
					System.out.println("INVALID OPTION. PLEASE TRY AGAIN.");
				}
			}

			System.out.println("EXITING THE APPLICATION. THANK YOU!");
		}

		//handleMyCamera() method - called when Option 1 is selected in Main menu
		private static void handleMyCamera(Scanner scanner) {
		
			boolean exit = false;
			while (!exit) {
				System.out.println("\nOPTIONS:");
				System.out.println("1. ADD");
				System.out.println("2. REMOVE");
				System.out.println("3. VIEW MY CAMERAS");
				System.out.println("4. GO TO PREVIOUS MENU");
				System.out.print("\nENTER OPTION: ");
				try {
					int option = Integer.parseInt(scanner.nextLine());

					switch (option) {
					case 1:
						addCamera(scanner);
						break;
					case 2:
						removeCamera(scanner);
						break;
					case 3:
						viewMyCameras();
						break;
					case 4:
						exit = true;
						break;
					default:
						System.out.println("INVALID OPTION. PLEASE TRY AGAIN.");
					}
				} catch (NumberFormatException e) {
					System.out.println("INVALID OPTION. PLEASE TRY AGAIN.");
				}
			}
		}

		private static void addCamera(Scanner scanner) {
			System.out.print("\nENTER CAMERA BRAND -  ");
			String brand = scanner.nextLine();
			System.out.print("ENTER MODEL - ");
			String model = scanner.nextLine();
			double pricePerDay = 0;
			boolean validInput = false;
			//Handling to check if the user enters a non-number amount
			while (!validInput) {
				try {
					System.out.print("ENTER THE PER DAY PRICE (INR): ");
					pricePerDay = Double.parseDouble(scanner.nextLine());
					validInput = true;
				} catch (NumberFormatException e) {
					System.out.println("INVALID INPUT. PLEASE ENTER A VALID AMOUNT.");
				}
			}

			Camera camera = new Camera(++camID, brand, model, pricePerDay, true);
			cameraList.add(camera);

			System.out.println("\nYOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST.");
		}
		
		private static void removeCamera(Scanner scanner) {
			displayCameraList(3);

			int id = 0;
			boolean validId = false;
			//Handling to check if the user enters a non-integer ID 
			while (!validId) {
				try {
					System.out.print("\nENTER CAMERA ID TO REMOVE - ");
					id = scanner.nextInt();
					scanner.nextLine();
					validId = true;
				} catch (InputMismatchException e) {
					System.out.println("INVALID INPUT. PLEASE ENTER A VALID CAMERA ID (INTEGER).");
					scanner.nextLine(); 
				}
			}

			boolean cameraFound = false;
			for (Camera camera : cameraList) {
				if (camera.getId() == id) {
					cameraList.remove(camera);
					cameraFound = true;
					break;
				}
			}

			if (cameraFound) {
				System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE LIST.");
			} else {
				System.out.println("CAMERA WITH ID " + id + " NOT FOUND.");
			}
		}
		// 2 - sent to show rented cameras
		private static void viewMyCameras() {
			System.out.println("\nYOUR RENTED CAMERAS:");
			displayCameraList(2);
		}
		// 1 - sent to show available cameras
		private static void handleRentCamera(Scanner scanner) {
			System.out.println("\nFOLLOWING IS THE LIST OF AVAILABLE CAMERAS:");
			displayCameraList(1);

			int id = 0;
			boolean validId = false;
		
			while (!validId) {
				try {
					System.out.print("\nENTER CAMERA ID TO RENT - ");
					id = scanner.nextInt();
					scanner.nextLine();
					validId = true;
				} catch (InputMismatchException e) {
					System.out.println("INVALID INPUT, PLEASE ENTER A VALID CAMERA ID!");
					scanner.nextLine(); 
				}
			}

			Camera selectedCamera = null;
			for (Camera camera : cameraList) {
				if (camera.getId() == id) {
					selectedCamera = camera;
					break;
				}
			}
			
			if (selectedCamera != null) {
				if (selectedCamera.isAvailable()) {
					double rentalAmount = selectedCamera.getPricePerDay();

					if (wallet.getBalance() >= rentalAmount) {
						wallet.deduct(rentalAmount);
						selectedCamera.setAvailable(false);
						System.out.println("\nYOUR TRANSACTION FOR CAMERA - "+selectedCamera.getBrand()+" "
								+selectedCamera.getModel()+ " WITH RENT INR. "+selectedCamera.getPricePerDay()+ " HAS SUCCESSFULLY COMPLETED!");
						System.out.println("Your remainning wallet Balance is:" + wallet.getBalance());
					} else {
						System.out.println("\nTRANSACTION FAILED DUE TO INSUFFICIENT BALANCE. DEPOSIT AMOUNT IN WALLET");
					}
				} else {
					System.out.println("\nCAMERA IS NOT AVAILABLE FOR RENT.");
				}
			} else {
				System.out.println("\nCAMERA WITH ID " + id + " NOT FOUND.");
			}
		}
		
		private static void handleMyWallet(Scanner scanner) {
			System.out.println("\nYOUR CURRENT WALLET BALANCE IS - INR. " + wallet.getBalance());
			System.out.print("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET? (1. YES 2. NO) - ");

			int choice = 0;
			boolean validChoice = false;
			
			while (!validChoice) {
				try {
					choice = scanner.nextInt();
					scanner.nextLine();
					validChoice = true;
				} catch (InputMismatchException e) {
					System.out.print("INVALID INPUT. PLEASE ENTER A VALID CHOICE - ");
					scanner.nextLine(); 
				}
			}

			if (choice == 1) {
				double amount = 0;
				boolean validAmount = false;
			
				while (!validAmount) {
					try {
						System.out.print("ENTER THE AMOUNT (INR) - ");
						amount = scanner.nextDouble();
						scanner.nextLine();
						validAmount = true;
					} catch (InputMismatchException e) {
						System.out.println("INVALID INPUT. PLEASE ENTER A VALID AMOUNT.");
						scanner.nextLine(); 
					}
				}

				wallet.deposit(amount);
			}
		}


		private static void displayCameraList(int rentedOrAvail) {
			if (cameraList.isEmpty()) {
				System.out.println("NO DATA PRESENT AT THIS MOMENT.");
			} else {
				System.out.println("======================================================================");
				System.out.println(" CAMERA ID     BRAND       MODEL        PRICE (PER DAY)      STATUS     ");
				System.out.println("======================================================================");

				for (Camera camera : cameraList) {
					if ((rentedOrAvail == 1 && camera.isAvailable()) || (rentedOrAvail == 2 && !camera.isAvailable()) || rentedOrAvail == 3) {
						System.out.printf(" %-10s   %-10s   %-10s    Rs %-13s   %-15s \n",
								camera.getId(), camera.getBrand(), camera.getModel(),
								camera.getPricePerDay(), camera.isAvailable() ? "Available" : "Rented");
					}
				}
				System.out.println("======================================================================");
			}
		}
	}

