package com.zundrel.voxelmontoolkit.ui.menuitem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.zundrel.voxelmontoolkit.Main;
import com.zundrel.voxelmontoolkit.voxelmon.VoxelmonObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ImportJsonMenuItem extends JMenuItem {
	private final JFrame frame;
	private final JFileChooser fileChooser;

	public ImportJsonMenuItem(JFrame frame, JFileChooser fileChooser) {
		super("Import JSON");
		this.frame = frame;
		this.fileChooser = fileChooser;
	}

	@Override
	protected void fireActionPerformed(ActionEvent event) {
		int returnVal = fileChooser.showOpenDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			ObjectMapper mapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

			try {
				Main.voxelmonObject = mapper.readValue(file, VoxelmonObject.class);
			} catch (IOException e) {
				Main.LOGGER.error("Could not read this IXL file.", e);
			}

			Main.voxelmonPane.load();
		}
	}
}
