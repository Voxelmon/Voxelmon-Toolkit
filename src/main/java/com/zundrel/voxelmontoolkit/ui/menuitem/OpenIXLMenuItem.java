package com.zundrel.voxelmontoolkit.ui.menuitem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zundrel.voxelmontoolkit.Main;
import com.zundrel.voxelmontoolkit.voxelmon.VoxelmonObject;
import org.msgpack.jackson.dataformat.MessagePackFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class OpenIXLMenuItem extends JMenuItem {
	private final JFrame frame;
	private final JFileChooser fileChooser;

	public OpenIXLMenuItem(JFrame frame, JFileChooser fileChooser) {
		super("Open");
		this.frame = frame;
		this.fileChooser = fileChooser;
	}

	@Override
	protected void fireActionPerformed(ActionEvent event) {
		int returnVal = fileChooser.showOpenDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			ObjectMapper mapper = new ObjectMapper(new MessagePackFactory());

			try {
				Main.voxelmonObject = mapper.readValue(file, VoxelmonObject.class);
			} catch (IOException e) {
				e.printStackTrace();
			}

			Main.voxelmonPane.load();
		}
	}
}
