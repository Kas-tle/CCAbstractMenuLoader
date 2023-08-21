package dev.kastle.ccabstractmenuloader.catalog;

import dev.kastle.ccabstractmenuloader.extractor.ConBoothExtractor;
import dev.kastle.ccabstractmenuloader.type.ConBooth;
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
public class ConBoothCatalog implements Catalog<ConBooth> {
    private Collection<ConBooth> conBooths;

    @Override
    public Collection<ConBooth> snapshot(Player player, Menu menu) {
        return this.conBooths;
    }

    @Override
    public ValueExtractor extractor() {
        return new ConBoothExtractor();
    }

    @AllArgsConstructor
    public static class Serializer implements NodeSerializer<ConBoothCatalog> {
        private Collection<ConBooth> conBooths;

        @Override
        public ConBoothCatalog deserialize(Class<ConBoothCatalog> type, ConfigNode node) throws NodeSerializeException {
            return new ConBoothCatalog(this.conBooths);
        }
    }
}
