package com.zundrel.voxelmontoolkit.ui.panel;

import com.zundrel.voxelmontoolkit.voxelmon.VoxelmonObject;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EvolutionMovesPanel extends JPanel {
	public static JTextArea evolutionMoves;

	private Map<JLabel, JTextField> fieldMap = new HashMap<>();

	public EvolutionMovesPanel() {
		setLayout(new MigLayout("ins 15"));

		evolutionMoves = new JTextArea(13, 20);
		JScrollPane scrollPane = new JScrollPane(evolutionMoves);
		add (new JLabel("Evolution Moves: "));
		add(scrollPane, "pushx, growx, wrap");
	}

	public ArrayList<String> save() {
		return new ArrayList<>(Arrays.asList(this.evolutionMoves.getText().split("\\s+")));
	}

	public void load(VoxelmonObject object) {
		evolutionMoves.setText("");
		for (String group : object.getMoves().getEvolutionMoves()) {
			evolutionMoves.setText(evolutionMoves.getText() + group + "\n");
		}
	}
}
