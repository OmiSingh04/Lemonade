package com.dev.os.lemonade.runner;

import javax.security.auth.login.LoginException;

import com.dev.os.lemonade.db_manager.BotQueries;
import com.dev.os.lemonade.db_manager.DatabaseEvents;
import com.dev.os.lemonade.emotes.HelloEvent;
import com.dev.os.lemonade.emotes.ImageSend;
import com.dev.os.lemonade.emotes.MoodEvent;
import com.dev.os.lemonade.games.CoinFlip;
import com.dev.os.lemonade.games.DiceRoll;
import com.dev.os.lemonade.games.WordGuess;
import com.dev.os.lemonade.util.AvatarEvent;
import com.dev.os.lemonade.util.ClearEvent;
import com.dev.os.lemonade.util.InfoEvent;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class App 
{
	
	public static final String SERVER_PREFIX = "LM.";
	public static BotQueries BOT_QUERIES;
	
	public static void main(String[] args) throws LoginException {
	    JDABuilder builder = JDABuilder.createDefault("GetYourOwnToken :)");
	    
	    // Disable parts of the cache
	    builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
	    // Enable the bulk delete event
	    builder.setBulkDeleteSplittingEnabled(false);
	    // Disable compression (not recommended)
	    builder.setCompression(Compression.NONE);
	    //builder.setStatus(OnlineStatus.IDLE).setActivity(Activity.watching("your winstreaks..."));
	    JDA jda = builder.build();
	    BOT_QUERIES = new BotQueries("connectionURL", "user", "password");
	    jda.addEventListener(new HelloEvent());
	    jda.addEventListener(new MoodEvent());
	    jda.addEventListener(new AvatarEvent());
	    jda.addEventListener(new ClearEvent());
	    jda.addEventListener(new ImageSend());
	    jda.addEventListener(new InfoEvent());
	    jda.addEventListener(new CoinFlip());
	    jda.addEventListener(new DiceRoll());
	    jda.addEventListener(new WordGuess());
	    jda.addEventListener(new DatabaseEvents());
	}
	
	
}
