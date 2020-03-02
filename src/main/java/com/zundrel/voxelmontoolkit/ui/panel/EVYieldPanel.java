package com.zundrel.voxelmontoolkit.ui.panel;

import com.zundrel.voxelmontoolkit.Main;
import com.zundrel.voxelmontoolkit.ui.TextFieldIntFilter;
import com.zundrel.voxelmontoolkit.voxelmon.stats.VoxelmonEVYield;
import com.zundrel.voxelmontoolkit.voxelmon.stats.VoxelmonStats;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.text.PlainDocument;

public class EVYieldPanel extends JPanel {
	public static JTextField hp, atk, def, spatk, spdef, speed;

	public EVYieldPanel() {
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
	}

	public VoxelmonEVYield save() {
		int hp = Integer.parseInt(this.hp.getText());
		int atk = Integer.parseInt(this.atk.getText());
		int def = Integer.parseInt(this.def.getText());
		int spatk = Integer.parseInt(this.spatk.getText());
		int spdef = Integer.parseInt(this.spdef.getText());
		int speed = Integer.parseInt(this.speed.getText());

		VoxelmonEVYield evYield = new VoxelmonEVYield();
		evYield.setStats(hp, atk, def, spatk, spdef, speed);

		return evYield;
	}

	public void load(VoxelmonStats stats) {
		VoxelmonEVYield evYield = stats.getYield();

		hp.setText(evYield.getHp() + "");
		atk.setText(evYield.getAtk() + "");
		def.setText(evYield.getDef() + "");
		spatk.setText(evYield.getSpatk() + "");
		spdef.setText(evYield.getSpdef() + "");
		speed.setText(evYield.getSpeed() + "");
	}
}
