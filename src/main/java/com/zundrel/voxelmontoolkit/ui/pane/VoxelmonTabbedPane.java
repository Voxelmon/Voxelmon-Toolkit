package com.zundrel.voxelmontoolkit.ui.pane;

import com.zundrel.voxelmontoolkit.Main;
import com.zundrel.voxelmontoolkit.ui.panel.*;
import com.zundrel.voxelmontoolkit.voxelmon.*;
import com.zundrel.voxelmontoolkit.voxelmon.stats.VoxelmonStats;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class VoxelmonTabbedPane extends JTabbedPane {
	private static BasicInfoPanel infoPanel;
	private static BreedingInfoPanel breedingPanel;
	private static StatInfoPanel statPanel;
	private static MoveInfoPanel movePanel;
	private static PokedexInfoPanel pokedexPanel;

	public VoxelmonTabbedPane() {
		infoPanel = new BasicInfoPanel();
		addTab("Basic Info", infoPanel);
		setMnemonicAt(0, KeyEvent.VK_1);

		breedingPanel = new BreedingInfoPanel();
		addTab("Breeding Info", breedingPanel);
		setMnemonicAt(1, KeyEvent.VK_2);

		statPanel = new StatInfoPanel();
		addTab("Stat Info", statPanel);
		setMnemonicAt(2, KeyEvent.VK_3);

		movePanel = new MoveInfoPanel();
		addTab("Moves Info", movePanel);
		setMnemonicAt(3, KeyEvent.VK_4);

		pokedexPanel = new PokedexInfoPanel();
		addTab("Pokedex Info", pokedexPanel);
		setMnemonicAt(4, KeyEvent.VK_5);

		setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	public void save() {
		Main.voxelmonObject = new VoxelmonObject();

		VoxelmonInfo info = infoPanel.save();
		VoxelmonBreeding breeding = breedingPanel.save();
		VoxelmonStats stats = statPanel.save();
		VoxelmonMoves moves = movePanel.save();
		VoxelmonPokedex pokedex = pokedexPanel.save();

		Main.voxelmonObject.setAll(info, breeding, stats, moves, pokedex);
		Main.voxelmonObject.setRegion(Main.region.getText());
	}

	public void load() {
		infoPanel.load(Main.voxelmonObject);
		breedingPanel.load(Main.voxelmonObject);
		statPanel.load(Main.voxelmonObject);
		movePanel.load(Main.voxelmonObject);
		pokedexPanel.load(Main.voxelmonObject);

		Main.region.setText(Main.voxelmonObject.getRegion());
	}
}
