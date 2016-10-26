package discordbot.command.creator;

import com.google.common.base.Joiner;
import discordbot.core.AbstractCommand;
import discordbot.main.DiscordBot;
import net.dv8tion.jda.entities.MessageChannel;
import net.dv8tion.jda.entities.User;

import java.io.File;

/**
 */
public class SendFileCommand extends AbstractCommand {
	public SendFileCommand() {
		super();
	}

	@Override
	public String getDescription() {
		return "executes commandline stuff";
	}

	@Override
	public String getCommand() {
		return "sendfile";
	}

	@Override
	public boolean isListed() {
		return true;
	}

	@Override
	public String[] getUsage() {
		return new String[]{};
	}

	@Override
	public String[] getAliases() {
		return new String[]{};
	}

	@Override
	public String execute(DiscordBot bot, String[] args, MessageChannel channel, User author) {
		if (!bot.isCreator(author)) {
			return ":upside_down: There's only one person who I trust enough to do that";
		}
		if (args.length == 0) {
			return ":face_palm: I expected you to know how to use it";
		}
		File f = new File(Joiner.on("").join(args));
		if (f.exists()) {
			channel.sendFileAsync(f, null, null);
			return "";
		}
		return "File doesn't exist";
	}
}