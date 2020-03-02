package com.zundrel.voxelmontoolkit.ui.panel;

import com.zundrel.voxelmontoolkit.Main;
import com.zundrel.voxelmontoolkit.ui.TextFieldIntFilter;
import com.zundrel.voxelmontoolkit.voxelmon.VoxelmonBreeding;
import com.zundrel.voxelmontoolkit.voxelmon.VoxelmonObject;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.util.ArrayList;
import java.util.Arrays;

public class BreedingInfoPanel extends JPanel {
	public static JTextField hatchTimeMax;
	public static JTextField hatchTimeMin;
	public static JTextArea eggGroups;

	public BreedingInfoPanel() {
		setLayout(new MigLayout("ins 15"));

		hatchTimeMax = Main.createField(this, "Hatch Time (Max)", 20);
		PlainDocument doc = (PlainDocument) hatchTimeMax.getDocument();
		doc.setDocumentFilter(new TextFieldIntFilter());

		hatchTimeMin = Main.createField(this, "Hatch Time (Min)", 20);
		doc = (PlainDocument) hatchTimeMin.getDocument();
		doc.setDocumentFilter(new TextFieldIntFilter());

		eggGroups = new JTextArea(5, 20);
		JScrollPane scrollPane = new JScrollPane(eggGroups);
		add (new JLabel("Egg Groups: "));
		add(scrollPane, "pushx, growx, wrap");
	}

	public VoxelmonBreeding save() {
		VoxelmonBreeding breeding = new VoxelmonBreeding();

		breeding.setHatchTimeMax(Integer.parseInt(hatchTimeMax.getText()));
		breeding.setHatchTimeMin(Integer.parseInt(hatchTimeMin.getText()));

		ArrayList<String> eggGroups = new ArrayList<>(Arrays.asList(this.eggGroups.getText().split("\\s+")));

		breeding.setEggGroups(eggGroups);

		return breeding;
	}

	public void load(VoxelmonObject voxelmonObject) {
		VoxelmonBreeding breeding = voxelmonObject.getBreeding();

		hatchTimeMax.setText(breeding.getHatchTimeMax() + "");
		hatchTimeMin.setText(breeding.getHatchTimeMin() + "");

		eggGroups.setText("");
		for (String group : breeding.getEggGroups()) {
			eggGroups.setText(eggGroups.getText() + group + "\n");
		}
	}
}
