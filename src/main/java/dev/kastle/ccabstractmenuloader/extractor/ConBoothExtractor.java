package dev.kastle.ccabstractmenuloader.extractor;

import dev.kastle.ccabstractmenuloader.type.ConBooth;
import ru.abstractmenus.api.ValueExtractor;

public class ConBoothExtractor implements ValueExtractor {
    @Override
    public String  extract(Object obj, String placeholder) {
        if (obj instanceof ConBooth) {
            ConBooth conBooth = (ConBooth) obj;
            switch (placeholder) {
                case "community" -> { return conBooth.community(); }
                case "community_name" -> { return conBooth.communityName(); }
                case "location" -> { return conBooth.location(); }
                case "id" -> { return conBooth.id(); }
                case "custom_model_data" ->  { return String.valueOf(conBooth.customModelData()); }
            }
        }
        return null;
    }
}
