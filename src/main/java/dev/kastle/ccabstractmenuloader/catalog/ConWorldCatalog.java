package dev.kastle.ccabstractmenuloader.catalog;

import dev.kastle.ccabstractmenuloader.extractor.ConWorldExtractor;
import dev.kastle.ccabstractmenuloader.type.ConWorld;
import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;
import ru.abstractmenus.api.Catalog;
import ru.abstractmenus.api.ValueExtractor;
import ru.abstractmenus.api.inventory.Menu;
import ru.abstractmenus.hocon.api.ConfigNode;
import ru.abstractmenus.hocon.api.serialize.NodeSerializeException;
import ru.abstractmenus.hocon.api.serialize.NodeSerializer;

import java.util.Collection;

@AllArgsConstructor
public class ConWorldCatalog implements Catalog<ConWorld> {
    private Collection<ConWorld> conWorlds;

    @Override
    public Collection<ConWorld> snapshot(Player player, Menu menu) {
        return this.conWorlds;
    }

    @Override
    public ValueExtractor extractor() {
        return new ConWorldExtractor();
    }

    @AllArgsConstructor
    public static class Serializer implements NodeSerializer<ConWorldCatalog> {
        private Collection<ConWorld> conWorlds;

        @Override
        public ConWorldCatalog deserialize(Class<ConWorldCatalog> type, ConfigNode node) throws NodeSerializeException {
            return new ConWorldCatalog(this.conWorlds);
        }
    }
}