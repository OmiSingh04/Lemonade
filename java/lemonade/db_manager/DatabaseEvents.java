package lemonade.db_manager;

import java.util.Random;

import lemonade.runner.App;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DatabaseEvents extends ListenerAdapter {
	
	private String[] money_counting = {"https://media4.giphy.com/media/3o7aTFWIdZi4kRVijm/giphy.gif","https://media3.giphy.com/media/8cfGoOsdm3P6yxohRh/giphy.gif",
			"https://thumbs.gfycat.com/ConventionalUntriedJapanesebeetle-size_restricted.gif","https://us.v-cdn.net/6030983/uploads/editor/h1/e63eazyv9fab.gif",
			"https://2.bp.blogspot.com/-nYxPis4Ji7w/XKO4W3fGTfI/AAAAAAAAAKQ/iI4zoh--6UkuVoJKEkysuxyOnEkI0Q9kwCLcBGAs/s1600/tumblr_phtks0JNwN1v9enyp_540.gif",
			"https://i.pinimg.com/originals/32/65/b5/3265b5fa6d2d186eb997fef2f376e472.gif"
	};

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

		String message = event.getMessage().getContentRaw().toString().toUpperCase();

		if (message.startsWith(App.SERVER_PREFIX + "REGISTER")) {
			boolean x = App.BOT_QUERIES.registerUser(event.getAuthor(), event.getGuild().getName());
			if (x)
				event.getChannel().sendMessage("Registered!\nYou have 500 lemons").queue();
			else
				event.getChannel().sendMessage("You are probably registered already").queue();
		}

		if (message.startsWith(App.SERVER_PREFIX + "LEMONS") || message.startsWith(App.SERVER_PREFIX + "BAL")) {
			long x = App.BOT_QUERIES.getLemons(event.getAuthor());
			System.out.println(x);
			if (x != -1)
				event.getChannel().sendMessage("You have " + x + " lemons").queue();
			else
				event.getChannel().sendMessage("E-error, b-baka Sandwich!").queue();
		}

		if (message.startsWith(App.SERVER_PREFIX + "SPIN")) {
			int random = new Random().nextInt(1000);
			boolean x = App.BOT_QUERIES.addLemons(event.getMessage().getAuthor(), random);
			if (x) {
				event.getChannel().sendMessage("You won " + random + " lemons!").queue();
				int r = new Random().nextInt(money_counting.length);
				event.getChannel().sendMessage(money_counting[r]).queue();
			}
			if (!x)
				event.getChannel().sendMessage("Error Sandwich Kunnn TwT").queue();
		}

	}
}