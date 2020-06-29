package com.craftablescience.amytherstpingutility;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.AnnotatedEventManager;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;

public class AmytherstPingUtility {

    public static void main(String[] args) throws LoginException {

        ConfigReader configReader = new ConfigReader();

        ArrayList<GatewayIntent> intents = new ArrayList<>();
        intents.add(GatewayIntent.GUILD_MESSAGES);
        intents.add(GatewayIntent.DIRECT_MESSAGES);

        JDABuilder bot = JDABuilder.create(configReader.getToken(), intents)
                .setEventManager(new AnnotatedEventManager())
                .addEventListeners(new Commands());
        bot.build();
    }
}