# CCAbstractMenuLoader

Made to register menu catalogs for the [AbstractMenu](https://www.spigotmc.org/resources/abstract-menus-an-advanced-gui-plugin.75107/) plugin for [Coaster Con 2023](https://coastercon.net/).

## Usage

The plugin will register its types automatically. Download the latest [release](https://github.com/Kas-tle/CCAbstractMenuLoader/releases/latest/download/CCAbstractMenuLoader.jar).

### Catalogs

#### `con_booth`
- `community`: The unique hash of the community the booth belongs to
- `community_name`: The name of the community the booth belongs to
- `location`: The location of the booth
- `id`: The unique id hash of the booth
- `custom_model_data`: The custom model data of community icon associated with the booth

#### `con_shop`
- `community`: The unique hash of the community the shop belongs to
- `community_name`: The name of the community the shop belongs to
- `location`: The location of the shop
- `custom_model_data`: The custom model data of community icon associated with the shop

#### `con_world`
- `community`: The unique hash of the community the world belongs to
- `community_name`: The name of the community the world belongs to
- `id`: The unique id hash of the world
- `custom_model_data`: The custom model data of community icon associated with the world

## Compiling
```bash
git clone https://github.com/Kas-tle/CCAbstractMenuLoader.git
cd CCAbstractMenuLoader
./gradlew build
```
