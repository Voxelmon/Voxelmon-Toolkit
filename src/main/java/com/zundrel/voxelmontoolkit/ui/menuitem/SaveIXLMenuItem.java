package com.zundrel.voxelmontoolkit.ui.menuitem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zundrel.voxelmontoolkit.Main;
import org.msgpack.jackson.dataformat.MessagePackFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class SaveIXLMenuItem extends JMenuItem {
	private final JFrame frame;
	private final JFileChooser fileChooser;

	public SaveIXLMenuItem(JFrame frame, JFileChooser fileChooser) {
		super("Save as");
		this.frame = frame;
		this.fileChooser = fileChooser;
	}

	@Override
	protected void fireActionPerformed(ActionEvent event) {
		int returnVal = fileChooser.showOpenDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			Main.voxelmonPane.save();
			File file = fileChooser.getSelectedFile();
			ObjectMapper mapper = new ObjectMapper(new MessagePackFactory());

			try {
				mapper.writeValue(file, Main.voxelmonObject);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
