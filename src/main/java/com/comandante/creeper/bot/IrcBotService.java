package com.comandante.creeper.bot;


import com.comandante.creeper.configuration.CreeperConfiguration;
import com.comandante.creeper.core_game.GameManager;
import com.google.common.util.concurrent.AbstractIdleService;
import org.pircbotx.MultiBotManager;
import org.pircbotx.PircBotX;

public class IrcBotService extends AbstractIdleService {

    private final CreeperConfiguration creeperConfiguration;
    private final GameManager gameManager;
    private PircBotX bot;
    private org.pircbotx.Configuration configuration;
    MultiBotManager manager;

    public IrcBotService(CreeperConfiguration creeperConfiguration, GameManager gameManager) {
        this.creeperConfiguration = creeperConfiguration;
        this.gameManager = gameManager;
    }

    @Override
    protected void startUp() throws Exception {
        manager = newBot();
        manager.start();
    }

    public MultiBotManager newBot() {
        manager = new MultiBotManager();
        configuration = new org.pircbotx.Configuration.Builder()
                .setName(creeperConfiguration.ircNickname)
                .setLogin(creeperConfiguration.ircUsername)
                .setServerHostname(creeperConfiguration.ircServer)
                .addAutoJoinChannel(creeperConfiguration.ircChannel)
                .addListener(new MyListener(gameManager, 376))
                .setVersion("Creeper MUD IRC But.")
                .setAutoReconnect(true)
                .buildConfiguration();
        bot = new PircBotX(configuration);
        // bot.startBot();
        manager.addBot(bot);
        return manager;
    }

    @Override
    protected void shutDown() throws Exception {
        bot.stopBotReconnect();
        manager.stopAndWait();
    }

    public PircBotX.State getState() {
        return bot.getState();
    }

    public PircBotX getBot() {
        return bot;
    }

    public MultiBotManager getManager() {
        return manager;
    }

    public void setManager(MultiBotManager manager) {
        this.manager = manager;
    }
}
