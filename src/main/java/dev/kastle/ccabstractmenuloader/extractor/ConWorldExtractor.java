package dev.kastle.ccabstractmenuloader.extractor;

import dev.kastle.ccabstractmenuloader.type.ConWorld;
import ru.abstractmenus.api.ValueExtractor;

public class ConWorldExtractor implements ValueExtractor {
    @Override
    public String extract(Object obj, String placeholder) {
        if (obj instanceof ConWorld) {
            ConWorld conWorld = (ConWorld) obj;
            switch (placeholder) {
                case "community" -> { return conWorld.community(); }
                case "community_name" -> { return conWorld.communityName(); }
                case "id" -> { return conWorld.id(); }
                case "custom_model_data" ->  { return String.valueOf(conWorld.customModelData()); }
            }
        }
        return null;
    }
}
