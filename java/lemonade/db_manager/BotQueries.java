package lemonade.db_manager;

import net.dv8tion.jda.api.entities.User;

public class BotQueries {

	private DatabaseManager manager;

	public BotQueries(String URLConnection, String userName, String password) {
		this.manager = new DatabaseManager(URLConnection, userName, password);
		System.out.println("Database connected");
	}

	public boolean registerUser(User user, String guildName) {
		// also have to check is the user already exists or not
		return manager.addUser(user.getName(), user.getIdLong(), guildName, 500);
	}

	public long getLemons(User user) {
		return manager.getLemons(user.getIdLong());
	}
	
	public boolean addLemons(User user, int lemons) {
		return manager.addLemons(user.getIdLong(), lemons);
	}
}