package me.frankusmiruk.skriptsort.skript;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.Variable;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import java.util.Map;
import java.util.Set;

public class EffSort extends Effect {

	static {
		Skript.registerEffect(EffSort.class, "sort %~objects% [in (descending|1¦ascending) order]");
	}

	private Variable<?> objects;
	private boolean ascending;
	private boolean  sorted;

	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
		if (!(exprs[0] instanceof Variable)) {
			Skript.error("The sort effect must only be used with variables.");
			return false;
		}
		objects = (Variable<?>) exprs[0];

		if (!objects.isList()) {
			Skript.error("Can't sort a single value.");
		}

		if (!objects.isLocal()) {
			if (!sort((Map<String, Object>) objects.getRaw(null))) {
				Skript.error("Cannot sort non-comparable objects.");
				return false;
			}
		}
		return true;
	}

	private boolean sort(Map<String, Object> objs) {
		Object prior
		for (Map.Entry<String, Object> obj : objs.entrySet()) {
			Object value = obj.getValue();
			if (!(value instanceof Comparable))
				return false;
			Comparable comp = (Comparable) value;

			if (comp.compareTo())
		}
		return true;
	}

	@Override
	protected void execute(Event e) {
	}

	@Override
	public String toString(@Nullable Event e, boolean debug) {
		return null;
	}
}
