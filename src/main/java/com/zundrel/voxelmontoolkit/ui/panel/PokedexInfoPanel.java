package com.zundrel.voxelmontoolkit.ui.panel;

import com.zundrel.voxelmontoolkit.Main;
import com.zundrel.voxelmontoolkit.ui.TextFieldDoubleFilter;
import com.zundrel.voxelmontoolkit.ui.TextFieldIntFilter;
import com.zundrel.voxelmontoolkit.voxelmon.VoxelmonObject;
import com.zundrel.voxelmontoolkit.voxelmon.VoxelmonPokedex;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.text.PlainDocument;

public class PokedexInfoPanel extends JPanel {
	public static JTextField regionalId;
	public static JTextField nationalId;
	public static JComboBox<String> bodyType;
	public static JTextField height;
	public static JTextField weight;

	private static String[] bodyTypes = { "head_only", "head_and_legs", "fins", "insectoid", "quadruped", "multiple_wing_pair", "multiple_bodies", "tentacles_or_multiped", "head_and_base", "bipedal_and_tailed", "bipedal_no_tail", "wing_pair", "serpentine", "head_and_arms" };

	public PokedexInfoPanel() {
		setLayout(new MigLayout("ins 15"));

		regionalId = Main.createField(this, "Regional Id", 20);
		PlainDocument doc = (PlainDocument) regionalId.getDocument();
		doc.setDocumentFilter(new TextFieldIntFilter());

		nationalId = Main.createField(this, "National Id", 20);
		doc = (PlainDocument) nationalId.getDocument();
		doc.setDocumentFilter(new TextFieldIntFilter());

		bodyType = new JComboBox<>(bodyTypes);
		add(new JLabel("Body Type: "));
		add(bodyType, "pushx, growx, wrap");

		height = Main.createField(this, "Height", 20);
		doc = (PlainDocument) height.getDocument();
		doc.setDocumentFilter(new TextFieldDoubleFilter());

		weight = Main.createField(this, "Weight", 20);
		doc = (PlainDocument) weight.getDocument();
		doc.setDocumentFilter(new TextFieldDoubleFilter());
	}

	public VoxelmonPokedex save() {
		VoxelmonPokedex pokedex = new VoxelmonPokedex();

		pokedex.setRegionalId(Integer.parseInt(regionalId.getText()));
		pokedex.setNationalId(Integer.parseInt(nationalId.getText()));
		pokedex.setBodyType((String) bodyType.getSelectedItem());
		pokedex.setHeight(Double.parseDouble(height.getText()));
		pokedex.setWeight(Double.parseDouble(weight.getText()));

		return pokedex;
	}

	public void load(VoxelmonObject voxelmonObject) {
		VoxelmonPokedex pokedex = voxelmonObject.getPokedex();

		regionalId.setText(pokedex.getRegionalId() + "");
		nationalId.setText(pokedex.getNationalId() + "");

		int index = find(bodyTypes, pokedex.getBodyType());
		bodyType.setSelectedIndex(index);

		height.setText(pokedex.getHeight() + "");
		weight.setText(pokedex.getWeight() + "");
	}

	public static<T> int find(T[] a, T target)
	{
		for (int i = 0; i < a.length; i++)
			if (target.equals(a[i]))
				return i;

		return -1;
	}
}
