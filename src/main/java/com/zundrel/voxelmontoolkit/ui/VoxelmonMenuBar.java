package com.zundrel.voxelmontoolkit.ui;

import com.zundrel.voxelmontoolkit.ui.menuitem.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class VoxelmonMenuBar extends JMenuBar {
	public VoxelmonMenuBar(final JFrame frame) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		final JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
		fileChooser.setFileFilter(new FileNameExtensionFilter(".ixl (Voxelmon Data File)", "ixl"));
		fileChooser.setSelectedFile(new File(".ixl"));

		final JFileChooser fileChooserJson = new JFileChooser(System.getProperty("user.dir"));
		fileChooserJson.setFileFilter(new FileNameExtensionFilter(".json (Voxelmon JSON File)", "json"));
		fileChooserJson.setSelectedFile(new File(".json"));

		JMenu fileMenu = new JMenu("File");

		NewMenuItem newVoxelmon = new NewMenuItem(frame);

		OpenIXLMenuItem open = new OpenIXLMenuItem(frame, fileChooser);
		SaveIXLMenuItem save = new SaveIXLMenuItem(frame, fileChooser);

		ImportJsonMenuItem importJson = new ImportJsonMenuItem(frame, fileChooserJson);
		ExportJsonMenuItem exportJson = new ExportJsonMenuItem(frame, fileChooserJson);

		fileMenu.add(newVoxelmon);

		fileMenu.add(open);
		fileMenu.add(save);

		fileMenu.add(importJson);
		fileMenu.add(exportJson);

		add(fileMenu);
	}
}
