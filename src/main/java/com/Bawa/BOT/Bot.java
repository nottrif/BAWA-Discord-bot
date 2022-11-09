package com.Bawa.BOT;

import com.Bawa.commands.Moderation.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Bot {
    public static String prefix = "!";

    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA bob = JDABuilder.createDefault("Enter your bot token here").build(); //Login to discord with bot
        bob.getPresence().setStatus(OnlineStatus.ONLINE);
        bob.getPresence().setActivity(Activity.watching("a movie with my wolf"));
        bob.awaitReady();
        bob.addEventListener(new Ping());
        bob.addEventListener(new Info());
        bob.addEventListener(new Clear());
        bob.addEventListener(new GuildMemberLeave());
        bob.addEventListener(new GuildMemberJoin());
        bob.addEventListener(new GuildMessageReactionAdd());
    }
}


