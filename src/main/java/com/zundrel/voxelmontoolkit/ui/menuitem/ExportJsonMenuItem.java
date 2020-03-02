package com.zundrel.voxelmontoolkit.ui.menuitem;

import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zundrel.voxelmontoolkit.Main;
import com.zundrel.voxelmontoolkit.ui.HTMLCharacterEscapes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ExportJsonMenuItem extends JMenuItem {
	private final JFrame frame;
	private final JFileChooser fileChooser;

	public ExportJsonMenuItem(JFrame frame, JFileChooser fileChooser) {
		super("Export JSON");
		this.frame = frame;
		this.fileChooser = fileChooser;
	}

	@Override
	protected void fireActionPerformed(ActionEvent event) {
		int returnVal = fileChooser.showOpenDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			Main.voxelmonPane.save();

			MappingJsonFactory factory = new MappingJsonFactory();
			factory.setCharacterEscapes(new HTMLCharacterEscapes());

			ObjectMapper mapper = new ObjectMapper(factory).setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE).enable(SerializationFeature.INDENT_OUTPUT);
			DefaultPrettyPrinter.Indenter indenter = new DefaultIndenter("    ", DefaultIndenter.SYS_LF);
			mapper.setDefaultPrettyPrinter(new DefaultPrettyPrinter().withObjectIndenter(indenter).withArrayIndenter(indenter));

			try {
				mapper.writeValue(file, Main.voxelmonObject);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
