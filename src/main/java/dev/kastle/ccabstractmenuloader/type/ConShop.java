package dev.kastle.ccabstractmenuloader.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Getter
@SuppressWarnings("unused")
@AllArgsConstructor
public class ConShop {
    private String community;
    private String communityName;
    private String id;
    private int customModelData;
}
