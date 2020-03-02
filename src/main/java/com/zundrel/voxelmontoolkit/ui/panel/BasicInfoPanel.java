package com.zundrel.voxelmontoolkit.ui.panel;

import com.zundrel.voxelmontoolkit.Main;
import com.zundrel.voxelmontoolkit.ui.TextFieldIntFilter;
import com.zundrel.voxelmontoolkit.voxelmon.VoxelmonInfo;
import com.zundrel.voxelmontoolkit.voxelmon.VoxelmonObject;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BasicInfoPanel extends JPanel {
	public static JTextField region;
	public static JTextField maleChance;
	public static JComboBox<String> levelRate;
	public static JTextField catchRate;
	public static JTextArea types;

	private static String[] levelRates = { "erratic", "fast", "medium_fast", "medium_slow", "slow", "fluctuating" };

	private Map<JLabel, JTextField> fieldMap = new HashMap<JLabel, JTextField>();

	public BasicInfoPanel() {
		setLayout(new MigLayout("ins 15"));

		maleChance = Main.createField(this, "Male Chance", 20);
		PlainDocument doc = (PlainDocument) maleChance.getDocument();
		doc.setDocumentFilter(new TextFieldIntFilter());

		levelRate = new JComboBox<>(levelRates);
		add(new JLabel("Level Rate: "));
		add(levelRate, "pushx, growx, wrap");

		catchRate = Main.createField(this, "Catch Rate", 20);
		doc = (PlainDocument) catchRate.getDocument();
		doc.setDocumentFilter(new TextFieldIntFilter());

		types = new JTextArea(5, 20);
		JScrollPane scrollPane = new JScrollPane(types);
		add (new JLabel("Types: "));
		add(scrollPane, "pushx, growx, wrap");
	}

	public VoxelmonInfo save() {
		VoxelmonInfo info = new VoxelmonInfo();

		info.setMaleChance(Integer.parseInt(maleChance.getText()));
		info.setLevelRate((String) levelRate.getSelectedItem());
		info.setCatchRate(Integer.parseInt(catchRate.getText()));

		ArrayList<String> types = new ArrayList<>(Arrays.asList(this.types.getText().split("\\s+")));

		info.setTypes(types);

		return info;
	}

	public void load(VoxelmonObject voxelmonObject) {
		VoxelmonInfo info = voxelmonObject.getInfo();

		maleChance.setText(info.getMaleChance() + "");

		int index = find(levelRates, info.getLevelRate());
		levelRate.setSelectedIndex(index);

		catchRate.setText(info.getCatchRate() + "");

		types.setText("");
		for (String group : info.getTypes()) {
			types.setText(types.getText() + group + "\n");
		}
	}

	public static<T> int find(T[] a, T target)
	{
		for (int i = 0; i < a.length; i++)
			if (target.equals(a[i]))
				return i;

		return -1;
	}
}
