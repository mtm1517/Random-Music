package RandomMusic;

import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;

import org.junit.Test;

// Check playlist file is exists
public class openFileTest {

	@Test
	public void openFiletest() throws IOException
	{
		File file = new File("src\\RandomMusic\\Playlist.txt");
		assertTrue(file.exists());
	}

	
}
