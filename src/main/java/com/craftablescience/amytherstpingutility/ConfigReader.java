package com.craftablescience.amytherstpingutility;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.util.Hashtable;
import java.util.Map;

public class ConfigReader {

    private final String token;
    private final String prefix;
    private final String pingCommand;
    private final String helpCommand;

    public ConfigReader() {

        Hashtable<String, String> cfgDict = this.readConfigFile();

        assert cfgDict != null;
        this.token = cfgDict.get("token");
        this.prefix = cfgDict.get("prefix");
        this.pingCommand = cfgDict.get("pingCommand");
        this.helpCommand = cfgDict.get("helpCommand");
    }

    private Hashtable<String, String> readConfigFile() {

        Hashtable<String, String> output = new Hashtable<>();
        File file = new File("config.yml");

        try {
            YamlReader reader = new YamlReader(new FileReader(file));
            @SuppressWarnings("unchecked")
            Map<String, String> map = (Map<String, String>) reader.read();

            output.put("token", map.get("Token"));
            output.put("prefix", map.get("Command Prefix"));
            output.put("pingCommand", map.get("Ping"));
            output.put("helpCommand", map.get("Help"));

        } catch (FileNotFoundException | YamlException e) {
            e.printStackTrace();
            return null;
        }
        return output;
    }

    public String getToken() {
        return this.token;
    }
    public String getPrefix() {
        return this.prefix;
    }
    public String getPingCommand() {
        return this.pingCommand;
    }
    public String getHelpCommand() {
        return this.helpCommand;
    }
}