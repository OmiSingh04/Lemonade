package com.dev.os.lemonade.games;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import com.dev.os.lemonade.runner.App;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class PokemonWordGuess extends ListenerAdapter{
	

	private String guess = "";
	private boolean isInGame = false;
	private long memberID = -1;
	private String word = new String("");
	private TextChannel channel;
	private int chances= 5;
	
	
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String message = event.getMessage().getContentRaw().toUpperCase();
		
		if(message.startsWith(App.SERVER_PREFIX + "POKEMON")) {//if the player has just started the game
			
			int random = new Random().nextInt(705);
			word = getWord("/txt/pokemon.txt",random);
			word = word.toLowerCase();
			System.out.println(word);
			if(word.equalsIgnoreCase("there-was-an-error")) {
				event.getChannel().sendMessage("Oops, I- I got an error b-baka Sandwich");
				return;
			}
			
			this.channel = event.getChannel();
			isInGame = true;
			memberID = event.getAuthor().getIdLong();
			
			guess = new String(Character.toString(word.charAt(0)));
			
			for(int i = 0; i < word.length() - 2; i++)
				guess = guess.concat("-");
			
			guess = guess.concat(Character.toString(word.charAt(word.length()-1)));
						
			event.getChannel().sendMessage(guess).queue();
			chances = 5;
			
		}//
		
		
		
		if(isInGame && event.getAuthor().getIdLong()==memberID && this.channel == event.getChannel()) {//the same person and the same game
			
			if(message.length()==1) {
				message = message.toLowerCase();
				char ch = message.charAt(0);
				boolean check = false;
				for(int i = 0; i < word.length(); i++) {
					
					if(word.charAt(i) == ch) {
						check = true;
						guess = guess.substring(0,i) + ch + guess.substring(i+1);
					}
					
				}
				if(check) {
					event.getChannel().sendMessage(guess).queue();
				}
				if(!check) {
					chances--;
					event.getChannel().sendMessage("Didnt match :sob:").queue();
					if(chances > 0)
					event.getChannel().sendMessage(chances + " chances left!").queue();
				}
			}
			
			if(chances == 0) {
				isInGame = false;
				memberID = -1;
				guess = "";
				event.getChannel().sendMessage("Aww :sob: No more chances :pensive:").queue();
				event.getChannel().sendMessage("Word was \"" + word + "\"").queue();
				chances = 5;
				word = guess = "";
			}
			
			if(word.equalsIgnoreCase(guess) && guess.length() > 0) {
				event.getChannel().sendMessage("Guessed it!").queue();
				isInGame = false;
				memberID = -1;
				guess = "";
				word = "";
				chances = 5;
			}
		}
		
		
	}
	
	public String getWord(String path, int random){
		URL url = WordGuess.class.getResource(path);
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(new File(url.getPath())));
			
				for(int i = 1; i < random; i++) {
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
