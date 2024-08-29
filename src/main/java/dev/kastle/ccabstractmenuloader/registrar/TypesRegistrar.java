package dev.kastle.ccabstractmenuloader.registrar;

import com.fasterxml.jackson.databind.JsonNode;
import dev.kastle.ccabstractmenuloader.CCAbstractMenuLoader;
import dev.kastle.ccabstractmenuloader.catalog.ConBoothCatalog;
import dev.kastle.ccabstractmenuloader.catalog.ConShopCatalog;
import dev.kastle.ccabstractmenuloader.catalog.ConWorldCatalog;
import dev.kastle.ccabstractmenuloader.type.ConBooth;
import dev.kastle.ccabstractmenuloader.type.ConShop;
import dev.kastle.ccabstractmenuloader.type.ConWorld;
import dev.kastle.ccabstractmenuloader.util.PocketBaseFetcher;
import ru.abstractmenus.api.Types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TypesRegistrar {
    private CCAbstractMenuLoader plugin;
    private PocketBaseFetcher pocketBaseFetcher;
    private JsonNode conBoothsJson;
    // private JsonNode conShopsJson;    
    private JsonNode conBoothMapJson;
    // private JsonNode conShopsMapJson;


    // private JsonNode conWorldsJson;
    private Map<String, Integer> communityIdMap = new HashMap<>();

    public TypesRegistrar(CCAbstractMenuLoader plugin) {
        this.plugin = plugin;
        this.pocketBaseFetcher = plugin.pocketBaseFetcher();
    }

    public void registerTypes() {
        initJson();
        initCommunityIdMap();
        Types.registerCatalog("con_booth", ConBoothCatalog.class, new ConBoothCatalog.Serializer(conBooths()));
        // Types.registerCatalog("con_shop", ConShopCatalog.class, new ConShopCatalog.Serializer(conShops()));
        // Types.registerCatalog("con_world", ConWorldCatalog.class, new ConWorldCatalog.Serializer(conWorlds()));
        plugin.logger().info("Registered abstract menu types");
    }

    private void initJson() {
        conBoothsJson = pocketBaseFetcher.getPocketBaseJson("con_booths");
        conBoothMapJson = pocketBaseFetcher.getPocketBaseJson("con_booth_map");
        // conShopsJson = pocketBaseFetcher.getPocketBaseJson("con_shops");
        // conShopsMapJson = pocketBaseFetcher.getPocketBaseJson("con_shop_map");
        // conWorldsJson = pocketBaseFetcher.getPocketBaseJson("con_worlds");        
    }

    private void initCommunityIdMap() {
        Set<String> communityIds = new HashSet<>();

        // conShopsJson.get("items").forEach(conShop -> {
        //     communityIds.add(conShop.get("community").asText());
        // });
        conBoothsJson.get("items").forEach(conBooth -> {
            communityIds.add(conBooth.get("community").asText());
        });
        // conWorldsJson.get("items").forEach(conWorld -> {
        //     communityIds.add(conWorld.get("community").asText());
        // });

        List<String> communityIdList = new ArrayList<>(communityIds);
        Collections.sort(communityIdList);

        for (int i = 0; i < communityIdList.size(); i++) {
            communityIdMap.put(communityIdList.get(i), i + 1);
        }

        plugin.logger().info("Initialized community ID map with " + communityIdMap.size() + " entries");
    }

    private Collection<ConBooth> conBooths() {
        Collection<ConBooth> conBooths = new ArrayList<>();

        conBoothsJson.get("items").forEach(conBooth -> {
            JsonNode map = findBoothMap(conBooth.get("id").asText());
            
            conBooths.add(new ConBooth(
                    conBooth.get("community").asText(),
                    conBooth.get("expand").get("community").get("name").asText(),
                    map != null ? map.get("id").asText() : "",
                    conBooth.get("id").asText(),
                    communityIdMap.get(conBooth.get("community").asText())
            ));
        });

        return conBooths;
    }

    private JsonNode findBoothMap(String booth) {
        JsonNode node = null;
        for (JsonNode conMap : conBoothMapJson.get("items")) {
            if (conMap.get("booth") == null) continue;
            if (conMap.get("booth").asText() == "") continue;

            if (conMap.get("booth").asText().equals(booth)) {
                node = conMap;
                break;
            }
        }

        return node;
    }

    // private Collection<ConShop> conShops() {
    //     Collection<ConShop> conShops = new ArrayList<>();

    //     conShopsJson.get("items").forEach(conShop -> {
    //         JsonNode map = findShopMap(conShop.get("id").asText());

    //         conShops.add(new ConShop(
    //                 conShop.get("community").asText(),
    //                 conShop.get("expand").get("community").get("name").asText(),
    //                 conShop.get("id").asText(),
    //                 map != null ? map.get("id").asText() : "",
    //                 communityIdMap.get(conShop.get("community").asText())
    //         ));
    //     });

    //     return conShops;
    // }

    // private JsonNode findShopMap(String shop) {
    //     JsonNode node = null;
    //     for (JsonNode conMap : conShopsMapJson.get("items")) {
    //         if (conMap.get("shop") == null) continue;
    //         if (conMap.get("shop").asText() == "") continue;

    //         if (conMap.get("shop").asText().equals(shop)) {
    //             node = conMap;
    //             break;
    //         }
    //     }

    //     return node;
    // }

    // private Collection<ConWorld> conWorlds() {
    //     Collection<ConWorld> conWorlds = new ArrayList<>();

    //     conWorldsJson.get("items").forEach(conWorld -> {
    //         conWorlds.add(new ConWorld(
    //                 conWorld.get("community").asText(),
    //                 conWorld.get("expand").get("community").get("name").asText(),
    //                 conWorld.get("id").asText(),
    //                 communityIdMap.get(conWorld.get("community").asText())
    //         ));
    //     });

    //     return conWorlds;
    // }
}
