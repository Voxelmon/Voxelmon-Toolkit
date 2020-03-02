package com.zundrel.voxelmontoolkit.ui.panel;

import com.zundrel.voxelmontoolkit.voxelmon.VoxelmonObject;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LearnableMovesPanel extends JPanel {
	public static JTextArea learnableMoves;

	private Map<JLabel, JTextField> fieldMap = new HashMap<>();

	public LearnableMovesPanel() {
		setLayout(new MigLayout("ins 15"));

		learnableMoves = new JTextArea(13, 20);
		JScrollPane scrollPane = new JScrollPane(learnableMoves);
		add (new JLabel("Learnable Moves: "));
		add(scrollPane, "pushx, growx, wrap");
	}

	public ArrayList<String> save() {
		return new ArrayList<>(Arrays.asList(this.learnableMoves.getText().split("\\s+")));
	}

	public void load(VoxelmonObject object) {
		learnableMoves.setText("");
		for (String group : object.getMoves().getLearnableMoves()) {
			learnableMoves.setText(learnableMoves.getText() + group + "\n");
		}
	}
}
