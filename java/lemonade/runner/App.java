package lemonade.runner;

import javax.security.auth.login.LoginException;

import lemonade.db_manager.BotQueries;
import lemonade.db_manager.DatabaseEvents;
import lemonade.emotes.HelloEvent;
import lemonade.emotes.LQuotes;
import lemonade.emotes.MoodEvent;
import lemonade.games.CoinFlip;
import lemonade.games.DiceRoll;
import lemonade.games.PokemonWordGuess;
import lemonade.games.RandomWord;
import lemonade.games.WordGuess;
import lemonade.util.AvatarEvent;
import lemonade.util.ClearEvent;
import lemonade.util.InfoEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

/**
 * Hello world!
 *
 */
public class App {

	public static final String SERVER_PREFIX = "LM.";
	public static BotQueries BOT_QUERIES;

	public static void main(String[] args) throws LoginException {
		JDABuilder builder = JDABuilder.createDefault("Nzg2ODMwMTI3ODE1NTg5OTM4.X9MGqQ.Ou9qvkaP5N67O5uWwoVSxuS9LZ4");

		// Disable parts of the cache
		builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
		// Enable the bulk delete event
		builder.setBulkDeleteSplittingEnabled(false);
		// Disable compression (not recommended)
		builder.setCompression(Compression.NONE);
		// builder.setStatus(OnlineStatus.IDLE).setActivity(Activity.watching("your
		// winstreaks..."));
		JDA jda = builder.build();
		BOT_QUERIES = new BotQueries("jdbc:mysql://localhost:3306/lemonade_db", "root", "pizza@eater");
		jda.addEventListener(new HelloEvent());
		jda.addEventListener(new PokemonWordGuess());
		jda.addEventListener(new MoodEvent());
		jda.addEventListener(new AvatarEvent());
		jda.addEventListener(new ClearEvent());
		jda.addEventListener(new InfoEvent());
		jda.addEventListener(new CoinFlip());
		jda.addEventListener(new LQuotes());
		jda.addEventListener(new DiceRoll());
		jda.addEventListener(new RandomWord());
		jda.addEventListener(new WordGuess());
		jda.addEventListener(new DatabaseEvents());
	}

}

/*
 * 
 * private String URLConnection = "jdbc:mysql://localhost:3306/lemonade_db";
 * private String userName = "root"; private String password = "pizza@eater";
 * 
 * 
 * 
 */