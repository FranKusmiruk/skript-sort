package me.frankusmiruk.skriptsort;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class SkriptSort extends JavaPlugin {

	private static SkriptSort instance;
	private static SkriptAddon addonInstance;

	public SkriptSort() {
		if (instance == null)
			instance = this;
		else
			throw new IllegalStateException();
	}

	@Override
	public void onEnable() {
		try {
			getAddonInstance().loadClasses("skript");
		} catch (IOException ignored) {}
	}

	public static SkriptAddon getAddonInstance() {
		if (addonInstance == null)
			addonInstance = Skript.registerAddon(getInstance());
		return addonInstance;
	}

	public static SkriptSort getInstance() {
		if (instance == null)
			throw new IllegalStateException();
		else
			return instance;
	}
}
