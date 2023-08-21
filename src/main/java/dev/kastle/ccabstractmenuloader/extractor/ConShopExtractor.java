package dev.kastle.ccabstractmenuloader.extractor;

import dev.kastle.ccabstractmenuloader.type.ConShop;
import ru.abstractmenus.api.ValueExtractor;

public class ConShopExtractor implements ValueExtractor {
    @Override
    public String  extract(Object obj, String placeholder) {
        if (obj instanceof ConShop) {
            ConShop conShop = (ConShop) obj;
            switch (placeholder) {
                case "community" -> { return conShop.community(); }
                case "community_name" -> { return conShop.communityName(); }
                case "id" -> { return conShop.id(); }
                case "custom_model_data" -> { return String.valueOf(conShop.customModelData()); }
            }
        }
        return null;
    }
}
