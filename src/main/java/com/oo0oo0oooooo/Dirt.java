package com.oo0oo0oooooo;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import com.projectkorra.projectkorra.ProjectKorra;
import com.projectkorra.projectkorra.ability.AddonAbility;
import com.projectkorra.projectkorra.ability.EarthAbility;
import com.projectkorra.projectkorra.configuration.ConfigManager;

public class Dirt extends EarthAbility implements AddonAbility {

    private static final long COOLDOWN = 0;
    private Listener _dirtListener;

    public Dirt(Player player) {
        super(player);

        if (bPlayer.canBend(this)) {
            return;
        }

        // setField();
        // start();
    }

    @Override
    public void progress() {
        if (bPlayer.canBend(this)) {
            remove();
            return;
        }
    }

    public void setField() {
        // COOLDOWN = ConfigManager.getConfig().getLong("ExtraAbilities.Jahko.Earth.EarthThrow.Cooldown");
    }

    public void onClick() {
    }

    @Override
    public boolean isSneakAbility() {
        return true;
    }

    @Override
    public boolean isHarmlessAbility() {
        return false;
    }

    @Override
    public long getCooldown() {
        return COOLDOWN;
    }

    @Override
    public String getName() {
        return "Dirt";
    }

    @Override
    public Location getLocation() {
        return player.getLocation();
    }

    @Override
    public void load() {
        _dirtListener = new DirtListener();
        ProjectKorra.plugin.getServer().getPluginManager().registerEvents(_dirtListener, ProjectKorra.plugin);

        // ConfigManager.getConfig().addDefault("ExtraAbilities.Jahko.Earth.EarthThrow.Cooldown", 1000);
    }

    @Override
    public void stop() {
        HandlerList.unregisterAll(_dirtListener);
        super.remove();
    }

    @Override
    public String getAuthor() {
        return "Jahko";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }
}