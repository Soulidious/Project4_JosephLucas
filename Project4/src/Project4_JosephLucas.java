/*
 * @author Joseph Lucas
 * This program calculates cost of food for a restaurant
 */
import java.util.Scanner;

public class Project4_JosephLucas {
	//NOTE: These are globally accessible to be used outside the main() method.
	// Setup prices are in cents
	// Initial value in int[] lists represent a price of $0.00
	public static final int enchilada = 1275;
	public static final int burrito = 1050;
	public static final int quesadilla = 875;
	public static int[] entreeCost = {0, enchilada, burrito, quesadilla};
	public static String[] entreeName = {"", "Enchilada:\t", "Burrito:\t", "Quesadilla:\t"};
	public static final int beans = 200;
	public static final int rice = 175;
	public static final int tortilla = 100;
	public static int[] sideCost = {0, beans, rice, tortilla};
	public static String[] sideName = {"", "Beans:\t\t", "Rice:\t\t", "Tortilla:\t"};
	public static final int coffee = 450;
	public static final int iceTea = 275;
	public static final int soda = 225;
	public static int[] drinkCost = {0, coffee, iceTea, soda};
	public static String[] drinkName = {"", "Coffee:\t\t", "Iced Tea:\t", "Soda:\t\t"};
	public static final int sopapillas = 500;
	public static final int churro = 575;
	public static final int tresLeches = 650;
	public static int[] dessertCost = {0, sopapillas, churro, tresLeches};
	public static String[] dessertName = {"", "Sopapillas:\t", "Churro:\t\t", "Tres Leches Cake:"};
	public static final double taxRate = 0.0875;
	public static final double tipAmt = 0.175;
	
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		final String restaurantName = "Mexi-Tex";
		
		
		//Welcome message and Menu prompt
		System.out.println("Welcome to " + restaurantName + "!\n");
		System.out.println("What entree item would you like?");
		System.out.println("Please enter: \n" +
							"0 for no entree \n" +
							"1 for enchilada \n" +
							"2 for burrito \n" +
							"3 for quesadilla \n");
		
		int opt1 = checkInput(stdin.nextInt());
		
		System.out.println("What side dish would you like?");
		System.out.println("Please enter: \n" +
							"0 for no side \n" +
							"1 for beans \n" +
							"2 for rice \n" +
							"3 for tortilla \n");
		
		int opt2 = checkInput(stdin.nextInt());
		
		System.out.println("What dessert item would you like?");
		System.out.println("Please enter: \n" +
							"0 for no dessert \n" +
							"1 for sopapillas \n" +
							"2 for churro \n" +
							"3 for tres leches cake \n");
		
		int opt3 = checkInput(stdin.nextInt());
		
		System.out.println("What drink would you like?");
		System.out.println("Please enter: \n" +
							"0 for no drink \n" +
							"1 for coffee \n" +
							"2 for iced tea \n" +
							"3 for soda \n");
		
		int opt4 = checkInput(stdin.nextInt());
		
		//Calculates subtotal, tip, tax, and total
		int subTotal = entreeCost[opt1] + sideCost[opt2] + dessertCost[opt3] + drinkCost[opt4];
		int tax = (int)(subTotal * taxRate);
		int tip = (int)(subTotal * tipAmt);
		int grandTotal = (int)(subTotal + tax + tip);
		
		//Receipt print out.
		hyphenBreak();
		System.out.println(restaurantName);
		System.out.println("Your order was:");
		if (opt1 != 0) {
		System.out.println(callEntree(opt1));
		}
		if (opt2 != 0) {
		System.out.println(callSide(opt2));
		}
		if (opt3 != 0) {
		System.out.println(callDessert(opt3));
		}
		if (opt4 != 0) {
		System.out.println(callDrink(opt4));
		}
		hyphenBreak();
		System.out.println('\t' + "Subtotal: " + "\t\t" + "$" + makeDollars(subTotal) + "." + makeCents(subTotal));
		System.out.println('\t' + "Tax: " + "\t\t\t" + "$" + makeDollars(tax) + "." + makeCents(tax));
		System.out.println('\t' + "Tip: " + "\t\t\t" + "$" + makeDollars(tip) + "." + makeCents(tip));
		hyphenBreak();
		System.out.println('\t' + "Grand Total: " + "\t\t" + "$" + makeDollars(grandTotal) + "." + makeCents(grandTotal));
		System.out.println("Thank you for visiting " + restaurantName + "!");
		
	}
	
	public static String callEntree(int option) {
		String line = "\t" + entreeName[option] + "\t" + "$" + makeDollars(entreeCost[option]) + "." + makeCents(entreeCost[option]);
		return line;
	}
	
	public static String callSide(int option) {
		String line = "\t" + sideName[option] + "\t" + "$" + makeDollars(sideCost[option]) + "." + makeCents(sideCost[option]);
		return line;
	}
	
	public static String callDessert(int option) {
		String line = "\t" + dessertName[option] + "\t" + "$" + makeDollars(dessertCost[option]) + "." + makeCents(dessertCost[option]);
		return line;
	}

	public static String callDrink(int option) {
		String line = "\t" + drinkName[option] + "\t" + "$" + makeDollars(drinkCost[option]) + "." + makeCents(drinkCost[option]);
		return line;
	}
	
	public static int makeDollars(int d) {
		int dollars = d / 100;
		return dollars;
	}
	
	public static String makeCents(int c) {
		int cents = c % 100;
		String cent = "" + cents;
		//Makes sure the cents are double digits
		if (cents == 0) {
			cent = "00";
		}
		else if (cents < 10) {
			cent = "0" + cents;
		}
		return cent;
	}
	
	//Check user input for numerical values within 0-3 range
	public static int checkInput(int x) {
		int temp = x;
		Scanner input = new Scanner(System.in);
		while (!(temp <= 3 && temp >= 0)) {
			System.out.println("Invalid input: Please select a number from 0 - 1");
			temp = input.nextInt();
		}
		return temp;
	}
	
	//Series of hyphens that are used on the receipt
	public static void hyphenBreak() {
		char hyphen = '-';
		for (int i = 0; i < 50; ++i) {
			System.out.print(hyphen);
		}
		System.out.println();
	}

}
