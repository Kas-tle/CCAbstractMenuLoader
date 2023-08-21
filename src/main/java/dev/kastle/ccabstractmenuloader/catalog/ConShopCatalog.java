package dev.kastle.ccabstractmenuloader.catalog;

import dev.kastle.ccabstractmenuloader.extractor.ConShopExtractor;
import dev.kastle.ccabstractmenuloader.type.ConShop;
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
public class ConShopCatalog implements Catalog<ConShop> {
    Collection<ConShop> conShops;

    @Override
    public Collection<ConShop> snapshot(Player player, Menu menu) {
        return this.conShops;
    }

    @Override
    public ValueExtractor extractor() {
        return new ConShopExtractor();
    }

    @AllArgsConstructor
    public static class Serializer implements NodeSerializer<ConShopCatalog> {
        Collection<ConShop> conShops;

        @Override
        public ConShopCatalog deserialize(Class<ConShopCatalog> type, ConfigNode node) throws NodeSerializeException {
            return new ConShopCatalog(this.conShops);
        }
    }
}