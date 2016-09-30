package test;

import java.io.Serializable;

public abstract class CommandEvent<C extends Enum<C>> {
	private C _command;
	private Serializable _data;

	public CommandEvent(C command, Serializable data) {
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
	public final Serializable getData() {
		return _data;
	}
}
