package dev.os.damon.gilbert;

import javax.security.auth.login.LoginException;

import emotes.HelloEvent;
import games.CoinFlip;
import games.DiceRoll;
import lemonade.util.InfoEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import util.AvatarEvent;
import util.ClearEvent;

/**
 * Hello world!
 *
 */
public class App {

	public static final String SERVER_PREFIX = "LM.";

	public static void main(String[] args) throws LoginException {
		JDABuilder builder = JDABuilder.createDefault(Constants.BOT_TOKEN);

		// Disable parts of the cache
		builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
		// Enable the bulk delete event
		builder.setBulkDeleteSplittingEnabled(false);
		builder.setStatus(OnlineStatus.IDLE).setActivity(Activity.watching("Vampire Diaries"));
		// winstreaks..."));
		JDA jda = builder.build();
		jda.addEventListener(new HelloEvent());
		jda.addEventListener(new AvatarEvent());
		jda.addEventListener(new ClearEvent());	
		jda.addEventListener(new InfoEvent());
		jda.addEventListener(new CoinFlip());
		jda.addEventListener(new DiceRoll());
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