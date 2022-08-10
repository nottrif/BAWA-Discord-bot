package com.Bawa.commands.Moderation;

import com.Bawa.BOT.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class Info extends ListenerAdapter {

    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        EmbedBuilder info = new EmbedBuilder();
        Message msg = event.getMessage();
        String[] args = msg.getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Bot.prefix + "info")) {
            info.setTitle("Bawa bot");
            info.setDescription("A fun bot that was made for personal use");
            info.setImage("https://img-cdn.tnwcdn.com/image?fit=1280%2C720&url=https%3A%2F%2Fcdn0.tnwcdn.com%2Fwp-content%2Fblogs.dir%2F1%2Ffiles%2F2021%2F07%2FDiscordhed.jpg&signature=257006462207519026282958af872e5c");
            info.setColor(0x62FD7B);
            info.setFooter("my discord - Trif#9575", event.getAuthor().getAvatarUrl());
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessageEmbeds(info.build())
                    .queue(message ->
                    {
                        message.delete().queueAfter(60, TimeUnit.SECONDS);
                    });

        }
    }
}
