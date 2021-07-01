package com.springlec.one.command;

import org.springframework.ui.Model;

public interface Command {
	void execute(Model model);
}
