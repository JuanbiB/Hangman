// Juan Bautista Berretta
// just do a while loop instead of a method
// while hangman is not complete, keep asking for guesses. If guess is already in list, break and ask for input again.
package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

	static ArrayList<String> used_letters = new ArrayList<String>();


	public static void main(String[] args) {

		System.out.println("******************************************");
		System.out.println("*                                                                  *");
		System.out.println("*                                                                  *");
		System.out.println("*                     Welcome!                          *");
		System.out.println("*                                                                  *");
		System.out.println("*                     Hangman                         *");
		System.out.println("*                                                                  *");
		System.out.println("*         By: Juan Bautista Berrettta    *");
		System.out.println("*                                                                  *");
		System.out.println("*                                                                  *");
		System.out.println("******************************************");
		System.out.println("Tip: type 'used' to see the letters you've already guessed.");
		System.out.println("Enjoy!");
		System.out.println();

		File filey = new File("big-wordlist.txt");
		ArrayList<String> words = new ArrayList<String>();

		try {
			Scanner sc = new Scanner(filey);

			while (sc.hasNext()){
				words.add(sc.next());
			}
		}

		catch (FileNotFoundException e){
			e.printStackTrace();
			System.exit(0);
		}

		// selecting a random word from the word list
		Random generate = new Random();
		int i = generate.nextInt(words.size());

		String the_word = words.get(i);

		// what's going to keep track of the guessed string
		String g = "";

		// the counter that keeps track of how many body parts are being used
		int hangman = 0; 

		// what keeps track the successful guesses
		int winner_count = 0;

		ArrayList<String> used_letters = new ArrayList<String>();

		for (int j = 0; j < the_word.length(); j++){
			System.out.print("_" + " ");
			g += "_";
		}

		System.out.println();
		System.out.println("The word has" + " " + the_word.length() + " " + "letters.");

		// putting each letter of the word into an Array List
		String[] word = the_word.split("");
		ArrayList<String> wordy = new ArrayList<String>(Arrays.asList(word));
		wordy.remove(0);
		System.out.println(wordy.toString());


		boolean inf = false;
		// just an infinite loop to keep things interesting 
		while (inf == false){
			// getting the user input
			System.out.println();
			System.out.println("Please input your guess (one letter): ");
			Scanner input = new Scanner(System.in);
			String guess = input.nextLine();
			boolean works = true;

			if (guess.equals("used")){
				System.out.println("These are the words you've used so far: " + used_letters.toString());
				continue;
			}

			// if the word has been used before, either as a successful guess or an unsuccessful one it's off the table.
			if (used_letters.contains(guess)){
				System.out.println("You've already tried that letter!");
				continue;
			}

			int counter1 = 0;
			
			// loops through 
			for (int j = 0; j < wordy.size() ; j++){
				
				if (guess.equals(wordy.get(j))){
					g = g.substring(0, j) + wordy.get(j) + g.substring(j+1);
					winner_count++;
				}
				else{	
					counter1++;
				} 
			}
			used_letters.add(guess);



			if (counter1 == wordy.size()){
				System.out.println("That letter is not in the word.");
				hangman++;
				works = false;


				if (hangman == 1){
					System.out.println("Drew the head.");
					System.out.println   ("     ______");
					System.out.println ("    |            |" );
					System.out.println ("    |            |" );
					System.out.println   ("     ______");

				}

				if (hangman == 2){
					System.out.println("Drew the torso.");
					System.out.println   ("     ______");
					System.out.println ("    |            |" );
					System.out.println ("    |            |" );
					System.out.println   ("     ______");
					System.out.println   ("           |");
					System.out.println   ("           |");
					System.out.println   ("           |");
				}

				if (hangman == 3){
					System.out.println("Drew the left hand.");
					System.out.println   ("     ______");
					System.out.println ("    |            |" );
					System.out.println ("    |            |" );
					System.out.println   ("     ______");
					System.out.println   ("           |");
					System.out.println   ("         / |");
					System.out.println   ("       /   |");
				}

				if (hangman == 4){
					System.out.println("Drew the right hand.");
					System.out.println   ("     ______");
					System.out.println ("    |            |" );
					System.out.println ("    |            |" );
					System.out.println   ("     ______");
					System.out.println   ("           |");
					System.out.println   ("         / |\\");
					System.out.println   ("       /   |  \\");
				}

				if (hangman == 5){
					System.out.println("Drew the left leg.");
					System.out.println   ("     ______");
					System.out.println ("    |            |" );
					System.out.println ("    |            |" );
					System.out.println   ("     ______");
					System.out.println   ("           |");
					System.out.println   ("         / |\\");
					System.out.println   ("       /   |  \\");
					System.out.println   ("       	   /");
					System.out.println   ("         /");
					System.out.println   ("       /");

				}

				if (hangman == 6){
					System.out.println("Drew the right leg.");
					System.out.println   ("     ______");
					System.out.println ("    |            |" );
					System.out.println ("    |            |" );
					System.out.println   ("     ______");
					System.out.println   ("           |");
					System.out.println   ("         / |\\");
					System.out.println   ("       /   |  \\");
					System.out.println   ("       	   /\\");
					System.out.println   ("         /    \\");
					System.out.println   ("       /        \\");
				}

			}

			if (winner_count == wordy.size()){
				System.out.println("Congratulations, you've guessed the word!");
				System.out.println("//////////////////////////////////////////////");
				System.out.println("/                  --------------                \\");
				System.out.println("/                 |  Winner!  |                \\");
				System.out.println("/                  --------------                \\");
				System.out.println("//////////////////////////////////////////////");
				
				
				System.out.println("It's " + g + "!");
				break;
			}

			if(hangman == 6){
				System.out.println("Oh well, the hangman's dead!");
				System.out.println("It was: " + the_word);
				break;
			}

			if (works == true){
				System.out.println("Yep, that works!");
				System.out.println(g);
			}


		}

	}

}





