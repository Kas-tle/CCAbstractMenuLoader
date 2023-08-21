package dev.kastle.ccabstractmenuloader;

import dev.kastle.ccabstractmenuloader.registrar.TypesRegistrar;
import dev.kastle.ccabstractmenuloader.util.PaperLogger;
import dev.kastle.ccabstractmenuloader.util.PocketBaseFetcher;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.bukkit.plugin.java.JavaPlugin;

@Accessors(fluent = true)
@Getter
public class CCAbstractMenuLoader extends JavaPlugin {
    private PaperLogger logger;
    private PocketBaseFetcher pocketBaseFetcher;

    @Override
    public void onLoad() {
        this.logger = new PaperLogger(getLogger());
    }

    @Override
    public void onEnable() {
        try {
            this.pocketBaseFetcher = new PocketBaseFetcher(this);
            new TypesRegistrar(this).registerTypes();
        } catch (Exception e) {
            this.logger.error("Failed to enable CCAbstractMenuLoader", e);
        }
    }
}
