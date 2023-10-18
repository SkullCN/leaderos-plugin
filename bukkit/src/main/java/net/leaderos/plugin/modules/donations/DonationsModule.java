package net.leaderos.plugin.modules.donations;

import com.cryptomorin.xseries.SkullUtils;
import com.cryptomorin.xseries.XMaterial;
import net.leaderos.plugin.Bukkit;
import net.leaderos.plugin.helpers.ChatUtil;
import net.leaderos.plugin.helpers.ItemUtils;
import net.leaderos.plugin.modules.donations.commands.DonationsCommand;
import net.leaderos.plugin.modules.donations.model.Donation;
import net.leaderos.plugin.modules.donations.timer.Timer;
import net.leaderos.shared.helpers.Placeholder;
import net.leaderos.shared.module.LeaderOSModule;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

/**
 * Donations module main class
 * @author poyrazinan
 * @since 1.0
 */
public class DonationsModule extends LeaderOSModule {

    /**
     * onEnable method of module
     */
    public void onEnable() {
        Bukkit.getCommandManager().registerCommand(new DonationsCommand());
        Timer.run();
        if( org.bukkit.Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI"))
            new Placeholders().register();
    }

    /**
     * onDisable method of module
     */
    public void onDisable() {
        Bukkit.getCommandManager().unregisterCommand(new DonationsCommand());
        Timer.taskid.cancel();
        if( org.bukkit.Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI"))
            new Placeholders().unregister();
    }

    /**
     * Constructor of Donation
     */
    public DonationsModule() {}

    /**
     * Donations gui item
     *
     * @param donation donation data of player
     * @return ItemStack of user head
     */
    public static @NotNull ItemStack getDonationHead(@NotNull Donation donation) {
        // Player head collector
        ItemStack item = XMaterial.PLAYER_HEAD.parseItem();
        assert item != null;
        OfflinePlayer player = org.bukkit.Bukkit.getOfflinePlayer(donation.getUsername());
        UUID playerUUID = player.getUniqueId();
        SkullMeta meta = SkullUtils.applySkin(Objects.requireNonNull(item.getItemMeta()), playerUUID);
        meta.setDisplayName(ChatUtil.replacePlaceholders(
                Bukkit.getInstance().getLangFile().getGui().getDonationsGui().getDisplayName(),
                new Placeholder("%i%", String.valueOf(donation.getRank())),
                new Placeholder("%player%", donation.getUsername()),
                new Placeholder("%amount%", String.valueOf(donation.getAmount())),
                new Placeholder("%symbol%", donation.getSymbol())
        ));
        meta.setLore(ChatUtil.replacePlaceholders(
                Bukkit.getInstance().getLangFile().getGui().getDonationsGui().getLore(),
                new Placeholder("%i%", String.valueOf(donation.getRank())),
                new Placeholder("%player%", donation.getUsername()),
                new Placeholder("%amount%", String.valueOf(donation.getAmount())),
                new Placeholder("%symbol%", donation.getSymbol())
        ));
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Donation Info item
     *
     * @param materialName Material
     * @param displayName Display Name
     * @return ItemStack of info
     */
    public static @NotNull ItemStack getDonationInfoItem(String materialName, String displayName) {
        XMaterial material = XMaterial.matchXMaterial(materialName).orElse(XMaterial.PAPER);

        return ItemUtils.getItem(material, displayName);
    }
}
