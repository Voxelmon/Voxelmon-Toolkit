package com.zundrel.voxelmontoolkit.ui.panel;

import com.zundrel.voxelmontoolkit.Main;
import com.zundrel.voxelmontoolkit.ui.TextFieldIntFilter;
import com.zundrel.voxelmontoolkit.voxelmon.stats.VoxelmonBaseStats;
import com.zundrel.voxelmontoolkit.voxelmon.stats.VoxelmonStats;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.text.PlainDocument;

public class BaseStatsPanel extends JPanel {
	public static JTextField hp, atk, def, spatk, spdef, speed, friendship;

	public BaseStatsPanel() {
		setLayout(new MigLayout("ins 15"));

		hp = Main.createField(this, "HP", 20);
		PlainDocument doc = (PlainDocument) hp.getDocument();
		doc.setDocumentFilter(new TextFieldIntFilter());

		atk = Main.createField(this, "Attack", 20);
		doc = (PlainDocument) atk.getDocument();
		doc.setDocumentFilter(new TextFieldIntFilter());

		def = Main.createField(this, "Defense", 20);
		doc = (PlainDocument) def.getDocument();
		doc.setDocumentFilter(new TextFieldIntFilter());

		spatk = Main.createField(this, "Sp. Attack", 20);
		doc = (PlainDocument) spatk.getDocument();
		doc.setDocumentFilter(new TextFieldIntFilter());

		spdef = Main.createField(this, "Sp. Defense", 20);
		doc = (PlainDocument) spdef.getDocument();
		doc.setDocumentFilter(new TextFieldIntFilter());

		speed = Main.createField(this, "Speed", 20);
		doc = (PlainDocument) speed.getDocument();
		doc.setDocumentFilter(new TextFieldIntFilter());

		friendship = Main.createField(this, "Friendship", 20);
		doc = (PlainDocument) friendship.getDocument();
		doc.setDocumentFilter(new TextFieldIntFilter());
	}

	public VoxelmonBaseStats save() {
		int hp = Integer.parseInt(this.hp.getText());
		int atk = Integer.parseInt(this.atk.getText());
		int def = Integer.parseInt(this.def.getText());
		int spatk = Integer.parseInt(this.spatk.getText());
		int spdef = Integer.parseInt(this.spdef.getText());
		int speed = Integer.parseInt(this.speed.getText());
		int friendship = Integer.parseInt(this.friendship.getText());

		VoxelmonBaseStats baseStats = new VoxelmonBaseStats();
		baseStats.setStats(hp, atk, def, spatk, spdef, speed, friendship);

		return baseStats;
	}

	public void load(VoxelmonStats stats) {
		VoxelmonBaseStats baseStats = stats.getBase();

		hp.setText(baseStats.getHp() + "");
		atk.setText(baseStats.getAtk() + "");
		def.setText(baseStats.getDef() + "");
		spatk.setText(baseStats.getSpatk() + "");
		spdef.setText(baseStats.getSpdef() + "");
		speed.setText(baseStats.getSpeed() + "");
		friendship.setText(baseStats.getFriendship() + "");
	}
}
