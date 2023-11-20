package net.leaderos.velocity.modules.connect;


import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.leaderos.shared.helpers.Placeholder;
import net.leaderos.shared.modules.LeaderOSModule;
import net.leaderos.shared.modules.connect.socket.SocketClient;
import net.leaderos.velocity.Velocity;
import net.leaderos.velocity.helpers.ChatUtil;

import java.net.URISyntaxException;

/**
 * Connect module main class
 *
 * @author poyrazinan
 * @since 1.0
 */
@Getter
public class ConnectModule extends LeaderOSModule {

    private SocketClient socket;

    /**
     * onEnable method of module
     */
    public void onEnable() {
        try {
            socket = new SocketClient(Velocity.getInstance().getConfigFile().getSettings().getApiKey(),
                    Velocity.getInstance().getModulesFile().getConnect().getServerToken()) {
                /**
                 * Executes console command
                 * @param command command to execute
                 * @param username username of player
                 */
                @Override
                public void executeCommands(String command, String username) {
                    Velocity.getInstance().getCommandManager()
                            .executeImmediatelyAsync(Velocity.getInstance().getServer().getConsoleCommandSource(), command);
                    Component msg = ChatUtil.replacePlaceholders(Velocity.getInstance().getLangFile().getMessages().getConnect().getConnectExecutedCommand(),
                            new Placeholder("%command%", command));
                    ChatUtil.sendMessage(Velocity.getInstance().getServer().getConsoleCommandSource(), msg);

                }

                @Override
                public void joinedRoom() {
                    ChatUtil.sendMessage(Velocity.getInstance().getServer().getConsoleCommandSource(),
                            Velocity.getInstance().getLangFile().getMessages().getConnect().getJoinedSocketRoom());
                }
            };
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * onReload method of module
     */
    public void onReload() {
        socket.getSocket().close();
    }

    /**
     * Constructor of connect
     */
    public ConnectModule() {
    }
}