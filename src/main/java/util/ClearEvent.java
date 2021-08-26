package util;

import java.awt.Color;
import java.util.List;
import dev.os.damon.gilbert.App;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ClearEvent extends ListenerAdapter {

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

		String args[] = event.getMessage().getContentRaw().toUpperCase().split("\\s+");

		if (!(args.length < 2 || args.length > 2)) {
			try {
				if(event.getMember().hasPermission(net.dv8tion.jda.api.Permission.MANAGE_CHANNEL)) {
					if (args[0].equalsIgnoreCase(App.SERVER_PREFIX + "CLEAR")) {
						List<Message> messageList = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
						event.getChannel().deleteMessages(messageList).queue();
						event.getChannel().sendMessage("Cleared").queue();
						event.getChannel().getLatestMessageIdLong();
						// event.getChannel().get
					}
				}
			}
			catch (java.lang.IllegalArgumentException e) {
				if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
					EmbedBuilder error = new EmbedBuilder();
					error.setColor(Color.red);
					error.setTitle("Too many messages selected");
					error.setDescription("Can delete only 100 messages at once.");
					event.getChannel().sendMessage(error.build()).queue();
				}
			}
		}
	}
}
