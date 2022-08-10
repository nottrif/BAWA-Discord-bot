package com.Bawa.commands.Moderation;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class GuildMessageReceived extends ListenerAdapter {

    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

    event.getMessage().addReaction("\u274C").queue();
    }
}
