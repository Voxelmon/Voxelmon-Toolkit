package com.zundrel.voxelmontoolkit.ui.panel;

import com.zundrel.voxelmontoolkit.voxelmon.VoxelmonObject;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LevelMovesPanel extends JPanel implements ActionListener {
	public static JTextArea levelMoves;

	private Map<JLabel, JTextField> fieldMap = new HashMap<>();

	public LevelMovesPanel() {
		setLayout(new MigLayout("ins 15"));

		levelMoves = new JTextArea(13, 20);
		JScrollPane scrollPane = new JScrollPane(levelMoves);
		add (new JLabel("Level Moves: "));
		add(scrollPane, "pushx, growx, wrap");
	}

	public HashMap<Integer, ArrayList<String>> save() {
		ArrayList<String> moves = new ArrayList<>(Arrays.asList(this.levelMoves.getText().split("\\s+")));
		HashMap<Integer, ArrayList<String>> moveArray = new HashMap<>();

		int index = -1;
		if (moves.size() > 1) {
			for (String string : moves) {
				if (string.matches("[0-9]+")) {
					index = Integer.parseInt(string);
				} else if (index < 0) {
					throw new Error("Cannot have an index of less than zero");
				} else if (moveArray.get(index) == null) {
					moveArray.put(index, new ArrayList<String>());
					moveArray.get(index).add(string);
				} else if (moveArray.get(index) != null) {
					moveArray.get(index).add(string);
				}
			}
		}

		return moveArray;
	}

	public void load(VoxelmonObject object) {
		HashMap<Integer, ArrayList<String>> moves = object.getMoves().getLevelMoves();

		levelMoves.setText("");
		for (int level : moves.keySet()) {
			levelMoves.setText(levelMoves.getText() + level + "\n");
			for (String move : moves.get(level)) {
				levelMoves.setText(levelMoves.getText() + move + "\n");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
