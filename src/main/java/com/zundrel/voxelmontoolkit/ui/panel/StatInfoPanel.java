package com.zundrel.voxelmontoolkit.ui.panel;

import com.zundrel.voxelmontoolkit.voxelmon.VoxelmonObject;
import com.zundrel.voxelmontoolkit.voxelmon.stats.VoxelmonStats;

import javax.swing.*;
import java.awt.*;

public class StatInfoPanel extends JPanel {
	private BaseStatsPanel baseStats;
	private EVYieldPanel yield;

	public StatInfoPanel() {
		JTabbedPane tabbedPane = new JTabbedPane();

		baseStats = new BaseStatsPanel();
		tabbedPane.addTab("Base Stats", baseStats);

		yield = new EVYieldPanel();
		tabbedPane.addTab("EV Yield", yield);

		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		setLayout(new GridLayout(1, 1));
		add(tabbedPane);
	}

	public VoxelmonStats save() {
		VoxelmonStats stats = new VoxelmonStats();
		stats.setBase(baseStats.save());
		stats.setYield(yield.save());

		return stats;
	}

	public void load(VoxelmonObject voxelmonObject) {
		VoxelmonStats stats = voxelmonObject.getStats();

		baseStats.load(stats);
		yield.load(stats);
	}
}
