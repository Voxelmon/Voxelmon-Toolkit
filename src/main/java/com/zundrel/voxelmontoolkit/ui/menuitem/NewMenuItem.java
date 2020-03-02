package com.zundrel.voxelmontoolkit.ui.menuitem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.zundrel.voxelmontoolkit.Main;
import com.zundrel.voxelmontoolkit.voxelmon.VoxelmonObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class NewMenuItem extends JMenuItem {
	private final JFrame frame;

	public NewMenuItem(JFrame frame) {
		super("New");
		this.frame = frame;
	}

	@Override
	protected void fireActionPerformed(ActionEvent event) {
		int returnVal = JOptionPane.showConfirmDialog(frame, "Are you sure you want to create a new file? This will overwrite your existing progress.", "Create New File", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (returnVal == JOptionPane.YES_OPTION) {
			ObjectMapper mapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

			try {
				Main.voxelmonObject = mapper.readValue(Main.empty, VoxelmonObject.class);
			} catch (IOException e) {
				Main.LOGGER.error("Could not read this IXL file.", e);
			}
			Main.voxelmonPane.load();
		}
	}
}
