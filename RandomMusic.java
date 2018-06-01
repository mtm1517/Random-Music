package RandomMusic;

/* 
 * MyVu - 011950276
 * CS146
 * Project 1A
 * March 9, 2018
 */

/* 
 * This project is small program to play random song title in a playlist 
 * if the song was played, the program choose a random song in the playlist except the song that chose. 
 */

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.io.*;


public class RandomMusic {
	
	String[] playList =  new String[459]; // String of playList
	int i = 0;  
	Random rand;  // random
	BufferedReader in;  // read file
	
	
	// Open a Text File
	public void openFile() throws IOException
	{
		try {
			File file = new File("src\\RandomMusic\\Playlist.txt");
			in = new BufferedReader(new FileReader(file));
			String str;
			while((str = in.readLine())!=null)
			{
				playList[i] = str;
				i++;
			}
			
		} catch(Exception e) {
			System.out.println("Could not find the data file!");
		}
		
	}
	
	// close File
	public void closeFile() throws IOException
	{
		in.close();
		
	}

	// Swap song in playlist
	public void swap(int index, int j)
	{
		String tmp;
		tmp = playList[index];
		playList[index] = playList[j];
		playList[j]= tmp;
	}
	
	// Random song in playlist then swap if the song chose
	public void playMusic()
	{
		rand = new Random();
		for(int j = playList.length - 1;j>0;j--)
		{
			int index = rand.nextInt(j);
			swap(index,j);
		}
	}
	
	// print out playlist
	public void printOut()
	{
		for(int j=0; j<playList.length;j++)
		{
			System.out.println(playList[j]);
		}
	}
	
// Main program	
	public static void main(String[] args) throws IOException
	{
		RandomMusic favorMusic = new RandomMusic(); // create RandomMusic
		favorMusic.openFile();	 // read file
		favorMusic.playMusic();  // random music
		favorMusic.printOut();   // print out playlist 
		favorMusic.closeFile();  // close file
	}

}
