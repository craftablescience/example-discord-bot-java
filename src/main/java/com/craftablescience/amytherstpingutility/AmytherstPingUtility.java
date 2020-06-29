package com.craftablescience.amytherstpingutility;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.AnnotatedEventManager;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;

public class AmytherstPingUtility {

    public static void main(String[] args) throws LoginException {

        ConfigReader configReader = new ConfigReader();

        ArrayList<GatewayIntent> intents = new ArrayList<>();
        intents.add(GatewayIntent.GUILD_MESSAGES);
        intents.add(GatewayIntent.DIRECT_MESSAGES);

        JDABuilder bot = JDABuilder.create("", intents)
                .setToken(configReader.getToken())
                .disableCache(CacheFlag.ACTIVITY, CacheFlag.VOICE_STATE, CacheFlag.EMOTE, CacheFlag.CLIENT_STATUS)
                .setEventManager(new AnnotatedEventManager())
                .addEventListeners(new Commands());
        bot.build();
    }
}