package com.zundrel.voxelmontoolkit.ui.panel;

import com.zundrel.voxelmontoolkit.voxelmon.VoxelmonObject;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EggMovesPanel extends JPanel {
	public static JTextArea eggMoves;

	private Map<JLabel, JTextField> fieldMap = new HashMap<>();

	public EggMovesPanel() {
		setLayout(new MigLayout("ins 15"));

		eggMoves = new JTextArea(13, 20);
		JScrollPane scrollPane = new JScrollPane(eggMoves);
		add (new JLabel("Egg Moves: "));
		add(scrollPane, "pushx, growx, wrap");
	}

	public ArrayList<String> save() {
		return new ArrayList<>(Arrays.asList(this.eggMoves.getText().split("\\s+")));
	}

	public void load(VoxelmonObject object) {
		eggMoves.setText("");
		for (String group : object.getMoves().getEggMoves()) {
			eggMoves.setText(eggMoves.getText() + group + "\n");
		}
	}
}
