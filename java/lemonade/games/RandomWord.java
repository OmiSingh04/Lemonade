package lemonade.games;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import lemonade.runner.App;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RandomWord extends ListenerAdapter{
	
	private String word = "";
	
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String message = event.getMessage().getContentRaw().toUpperCase();

		if (message.startsWith(App.SERVER_PREFIX + "WORD")) {// if the player has just started the game

			int random = new Random().nextInt(2242);
			word = getWord("/txt/Words.txt", random);
			word = word.toLowerCase();
			if (word.equalsIgnoreCase("there-was-an-error")) {
				event.getChannel().sendMessage("Oops, I- I got an error b-baka Sandwich");
				return;
			}
			event.getChannel().sendMessage(word).queue();
		}
	}
	
	
	
	
	public String getWord(String path, int random) {
	URL url = WordGuess.class.getResource(path);
	BufferedReader reader;
	try {
		reader = new BufferedReader(new FileReader(new File(url.getPath())));

		for (int i = 1; i < random; i++) {
			reader.readLine();
		}
		String s = reader.readLine();
		reader.close();
		return s;

	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.print("FileNotFound");
		return "there was an error";
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.print("IOException");
		return "there was an error";
	}
}

}
