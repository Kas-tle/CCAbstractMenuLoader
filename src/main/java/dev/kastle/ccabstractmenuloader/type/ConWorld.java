package dev.kastle.ccabstractmenuloader.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Getter
@AllArgsConstructor
public class ConWorld {
    private String community;
    private String communityName;
    private String id;
    private int customModelData;
}
