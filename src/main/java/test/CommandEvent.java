package test;

import java.io.Serializable;

public abstract class CommandEvent<C extends Enum<C>, D extends Serializable> {
	private final C _command;
	private final D _data;

	public CommandEvent(C command, D data) {
		_command = command;
		_data = data;
	}

	/**
	 * @return the command
	 */
	public final C getCommand() {
		return _command;
	}

	/**
	 * @return the data
	 */
	public final D getData() {
		return _data;
	}
}
