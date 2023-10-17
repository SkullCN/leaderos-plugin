package net.leaderos.bungee.configuration.lang;

import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.annotation.NameModifier;
import eu.okaeri.configs.annotation.NameStrategy;
import eu.okaeri.configs.annotation.Names;
import lombok.Getter;
import lombok.Setter;
import net.leaderos.bungee.configuration.Language;

import java.util.Arrays;
import java.util.List;

/**
 * @author poyrazinan
 * @since 1.0
 */
@Getter @Setter
@Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
public class tr extends Language {

    /**
     * Settings menu of config
     */
    @Comment("Main settings")
    private Messages messages = new Messages();

    /**
     * Messages of plugin
     * @author poyrazinan
     * @since 1.0
     */
    @Getter
    @Setter
    public static class Messages extends Language.Messages {

        @Comment("Prefix of messages")
        private String prefix = "&3LeaderOS &8»";

        private String playerNotOnline = "{prefix} &cOyuncu çevrimiçi değil.";

        private String playerNotAvailable = "{prefix} &cOyuncu mevcut değil.";

        private String targetPlayerNotAvailable = "{prefix} &cBu oyuncu mevcut değil.";

        /**
         * Help commands message
         */
        @Comment("Help commands message")
        private List<String> help = Arrays.asList(
                "&6&l  LEADEROS EKLENTI KOMUTLARI",
                "",
                "&8 ▪ &e/auth &8» &fHesap eşleme bağlantısı verir.",
                "&8 ▪ &e/discord-sync &8» &fDiscord eşleme bağlantısı verir.",
                "",
                "&8 ▪ &e/credits &8» &fKredi miktarını görüntüler.",
                "&8 ▪ &e/credits see <oyuncu> &8» &fOyuncunun kredi miktarını görüntüler.",
                "&8 ▪ &e/credits send <oyuncu> <miktar> &8» &fOyuncuya kredi gönderir.",
                "&8 ▪ &e/credits set <oyuncu> <miktar> &8» &fOyuncunun kredisini ayarlar.",
                "&8 ▪ &e/credits remove <oyuncu> <miktar> &8» &fOyuncunun kredisini siler.",
                "&8 ▪ &e/credits add <oyuncu> <miktar> &8» &fOyuncuya kredi ekler.",
                "",
                "&8 ▪ &e/leaderos reload &8» &fEklenti dosyalarını yeniler."
        );

        /**
         * Info messages
         */
        private Info info = new Info();

        /**
         * Info messages of plugin
         *
         * @author poyrazinan
         * @since 1.0
         */
        @Getter
        @Setter
        public static class Info extends Language.Messages.Info {

            /**
             * Module enabled message
             */
            private String moduleEnabled = "{prefix} &e%module_name% &amodülü aktif edildi.";

            /**
             * Module closed message
             */
            private String moduleClosed = "{prefix} &e%module_name% &cmodülü kapandı.";

            /**
             * Module disabled message
             */
            private String moduleDisabled = "{prefix} &e%module_name% &cmodülü devre dışı bırakıldı.";

            /**
             * Missing dependency message
             */
            private String missingDependency = "{prefix} &e%module_name% &cmodülü gereksinimleri karşılayamadığı için başlatılamadı. Gereksinim: &8[&c%dependencies%&8]";
        }

        /**
         * Command object
         */
        private Command command = new Command();

        /**
         * Command arguments class
         */
        @Getter @Setter
        public static class Command extends Language.Messages.Command {

            /**
             * Invalid argument message
             */
            private String invalidArgument = "{prefix} &cBilinmeyen argüman girdiniz!";

            /**
             * Unknown command message
             */
            private String unknownCommand = "{prefix} &cBilinmeyen komut girdiniz!";

            /**
             * Not enough arguments message
             */
            private String notEnoughArguments = "{prefix} &cYetersiz argüman girdiniz!";

            /**
             * too many arguments message
             */
            private String tooManyArguments = "{prefix} &cÇok fazla argüman girdiniz!";

            /**
             * no perm message
             */
            private String noPerm = "{prefix} &cBu işlemi yapabilmek için yeterli yetkiye sahip değilsin!";

        }

        /**
         * Auth messages
         */
        private Auth auth = new Auth();

        /**
         * Auth messages of plugin
         */
        @Getter @Setter
        public static class Auth extends Language.Messages.Auth {

            /**
             * Command Message
             */
            private String commandMessage = "{prefix} <&aHesabını eşlemek için &e&ntıkla!&r{&eTıkla!}(open_url:%link%)>";

            /**
             * Module error message
             */
            private String moduleError = "{prefix} <&cSistem siteye girişi gerektirmektedir. Giriş yapmak için &e&ntıkla!&r{&eTıkla!}(open_url:%link%)>";

            /**
             * error on auth link
             */
            private String noLink = "{prefix} &cSunucuya bağlanırken hata oluştu.";
        }

        /**
         * Discord messages
         */
        private Discord discord = new Discord();

        /**
         * Discord messages of plugin
         */
        @Getter @Setter
        public static class Discord extends Language.Messages.Discord {

            /**
             * Command Message
             */
            private String commandMessage = "{prefix} <&aHesabını Discord ile eşlemek için &e&ntıkla!&r{&eTıkla!}(open_url:%link%)>";

            /**
             * error on DiscordSync link
             */
            private String noLink = "{prefix} &cSunucuya bağlanırken hata oluştu.";
        }

        /**
         * Credit messages
         */
        private Credit credit = new Credit();

        /**
         * Credit messages of plugin
         */
        @Getter @Setter
        public static class Credit extends Language.Messages.Credit {

            private String creditInfo = "{prefix} &e{amount} &akrediye sahipsin.";

            private String creditInfoOther = "{prefix} &b{target} &aadlı oyuncunun &e{amount} &akredisi bulunuyor.";

            private String cannotSendCreditYourself = "{prefix} &cKendine kredi gönderemezsin.";

            private String cannotSendCreditNegative = "{prefix} &cLütfen geçerli bir miktar giriniz.";

            private String cannotSendCreditNotEnough = "{prefix} &cYeterli miktarda krediye sahip değilsin. Gereken: &e{amount} kredi";

            private String successfullySentCredit = "{prefix} &b{target} &aadlı oyuncuya başarıyla &e{amount} kredi &agönderildi.";

            private String successfullySetCredit = "{prefix} &b{target} &aadlı oyuncunun kredisi başarıyla &e{amount} olarak ayarlandı.";

            private String successfullyAddedCredit = "{prefix} &b{target} &aadlı oyuncuya başarıyla &e{amount} kredi &aeklendi.";

            private String successfullyRemovedCredit = "{prefix} &b{target} adlı oyuncunun &e{amount} kredisi &abaşarıyla silindi.";

            private String receivedCredit = "{prefix} &b{player} &aadlı oyuncudan &e{amount} kredi &aaldın.";
        }

        /**
         * Connect messages
         */
        private Connect connect = new Connect();

        /**
         * Connect messages of plugin
         */
        @Getter @Setter
        public static class Connect extends Language.Messages.Connect {

            private String connectExecutedCommand = "{prefix} &aConnect modülü tarafından komut çalıştırıldı: &e%command%";

            private String joinedSocketRoom = "{prefix} &aConnect modülü başarıyla odaya bağlandı.";
        }
    }
}
