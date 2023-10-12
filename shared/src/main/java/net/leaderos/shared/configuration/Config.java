package net.leaderos.shared.configuration;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.annotation.NameModifier;
import eu.okaeri.configs.annotation.NameStrategy;
import eu.okaeri.configs.annotation.Names;
import lombok.Getter;
import lombok.Setter;

/**
 * Main config file
 * @author poyrazinan, hyperion
 * @since 1.0
 */
@Getter @Setter
@Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
public class Config extends OkaeriConfig {

    /**
     * Settings menu of config
     */
    @Comment("Main settings")
    private Settings settings = new Settings();

    /**
     * Settings configuration of config
     *
     * @author poyrazinan
     * @since 1.0
     */
    @Getter
    @Setter
    public static class Settings extends OkaeriConfig {
        @Comment("Language of plugin")
        private String lang = "en";

        @Comment("Url of your website")
        private String url = "https://beta.leaderos.net";

        @Comment("API Key for request")
        private String apiKey = "2d8676260ffc79145cfb0ea736ac6a27";

        @Comment("Time format for plugin")
        private String timeFormat= "yyyy-MM-dd HH:mm:ss";
    }
}