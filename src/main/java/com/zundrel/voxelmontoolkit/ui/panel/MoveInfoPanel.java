package com.zundrel.voxelmontoolkit.ui.panel;

import com.zundrel.voxelmontoolkit.voxelmon.VoxelmonMoves;
import com.zundrel.voxelmontoolkit.voxelmon.VoxelmonObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MoveInfoPanel extends JPanel {
	private LearnableMovesPanel learnableMoves;
	private LevelMovesPanel levelMoves;
	private EggMovesPanel eggMoves;
	private EvolutionMovesPanel evolutionMoves;

	public MoveInfoPanel() {
		JTabbedPane tabbedPane = new JTabbedPane();

		learnableMoves = new LearnableMovesPanel();
		tabbedPane.addTab("Learnable Moves", learnableMoves);

		levelMoves = new LevelMovesPanel();
		tabbedPane.addTab("Level Moves", levelMoves);

		eggMoves = new EggMovesPanel();
		tabbedPane.addTab("Egg Moves", eggMoves);

		evolutionMoves = new EvolutionMovesPanel();
		tabbedPane.addTab("Evolution Moves", evolutionMoves);

		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		setLayout(new GridLayout(1, 1));
		add(tabbedPane);
	}

	public VoxelmonMoves save() {
		VoxelmonMoves moves = new VoxelmonMoves();
		ArrayList<String> learnableMoves = this.learnableMoves.save();
		HashMap<Integer, ArrayList<String>> levelMoves = this.levelMoves.save();
		ArrayList<String> eggMoves = this.eggMoves.save();
		ArrayList<String> evolutionMoves = this.evolutionMoves.save();

		moves.setLearnableMoves(learnableMoves);
		moves.setLevelMoves(levelMoves);
		moves.setEggMoves(eggMoves);
		moves.setEvolutionMoves(evolutionMoves);

		return moves;
	}

	public void load(VoxelmonObject object) {
		learnableMoves.load(object);
		levelMoves.load(object);
		eggMoves.load(object);
		evolutionMoves.load(object);
	}
}
