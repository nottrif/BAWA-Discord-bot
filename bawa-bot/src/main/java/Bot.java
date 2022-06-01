import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class Bot extends ListenerAdapter
{
    public static void main(String[] args) throws LoginException
    {
        JDA bob = JDABuilder.createDefault("token").build(); //Login to discord with bot
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) //To find ping of the bot.
    {
        super.onMessageReceived(event);
        if (event.getAuthor().isBot())
        {
            return;
        }
        Message msg = event.getMessage();
        if (msg.getContentRaw().equals("!ping") || msg.getContentRaw().equals("!Ping"))
        {
            long time = System.currentTimeMillis();
            MessageChannel channel = event.getChannel();
            channel.sendMessage("pong!")
                    .queue(response ->
                    {
                        response.editMessageFormat("Ping %d ms", System.currentTimeMillis() - time).queue();
                    });

        }

    }
}


