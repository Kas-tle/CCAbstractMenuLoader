package dev.kastle.ccabstractmenuloader.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Getter
@AllArgsConstructor
public class ConBooth {
    private String community;
    private String communityName;
    private String location;
    private String id;
    private int customModelData;
}
