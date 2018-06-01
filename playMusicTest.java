package RandomMusic;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/*
 * Test Random song in Playlist.txt. Read input Playlist and output Target2. 
 * Copy all song from input Playlist to array[]
 *   
 */

public class playMusicTest {

	@Test
	public void playMusictest() throws IOException
	{
		
		File file = new File("src\\RandomMusic\\Playlist.txt");
		File file1 = new File("src\\RandomMusic\\Target2.txt");
		// read input playlist
		BufferedReader in = new BufferedReader(new FileReader(file));
		// read output target
		BufferedReader out = new BufferedReader(new FileReader(file1));
		
		String[] playList =  new String[459];  // create an array
		int i=0;	// element of array
		String str; 
		
		// read content of Playlist.txt then copy the content to array
		while((str = in.readLine())!=null)
		{
			playList[i] = str;
			i++;
		}
		
		// random number
		Random rand = new Random(0);
		rand.setSeed(20);
		
		// swap the chosing song.
		for(int j = playList.length - 1;j>0;j--)
		{
			int index = rand.nextInt(j);
			String tmp;
			tmp = playList[index];
			playList[index] = playList[j];
			playList[j]= tmp;
		}
		
		// compare output of playlist = content of target file
		for(int k=0; k<playList.length;k++)
		{
			String actualLine = out.readLine();
			assertEquals(playList[k],actualLine);
			
		}
		
	}

}
