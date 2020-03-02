package com.zundrel.voxelmontoolkit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.zundrel.voxelmontoolkit.ui.VoxelmonMenuBar;
import com.zundrel.voxelmontoolkit.ui.pane.VoxelmonTabbedPane;
import com.zundrel.voxelmontoolkit.voxelmon.VoxelmonObject;
import net.miginfocom.swing.MigLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
	public static final Logger LOGGER = Logger.getLogger("Voxelmon Toolkit");

	public static final String empty = "{\"region\":\"\",\"info\":{\"male_chance\":0,\"level_rate\":\"erratic\",\"catch_rate\":0,\"types\":[\"\"]},\"breeding\":{\"hatch_time_max\":0,\"hatch_time_min\":0,\"egg_groups\":[\"\"]},\"stats\":{\"base\":{\"hp\":0,\"atk\":0,\"def\":0,\"spatk\":0,\"spdef\":0,\"speed\":0,\"friendship\":0},\"yield\":{\"hp\":0,\"atk\":0,\"def\":0,\"spatk\":0,\"spdef\":0,\"speed\":0}},\"moves\":{\"learnable_moves\":[\"\"],\"level_moves\":{},\"egg_moves\":[\"\"],\"evolution_moves\":[\"\"]},\"pokedex\":{\"regional_id\":0,\"national_id\":0,\"body_type\":\"head_only\",\"height\":0.0,\"weight\":0.0}}";

	public static JTextField region;
    public static VoxelmonObject voxelmonObject = new VoxelmonObject();
    public static VoxelmonTabbedPane voxelmonPane;

    public static void main(String[] args) throws IOException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
    	BasicConfigurator.configure();

		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        JFrame frame = new JFrame("Voxelmon Toolkit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("ins 15"));
        region = createField(panel, "Region");

        voxelmonPane = new VoxelmonTabbedPane();

        frame.getContentPane().add(BorderLayout.NORTH, new VoxelmonMenuBar(frame));
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(voxelmonPane);

		ObjectMapper mapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

		try {
			Main.voxelmonObject = mapper.readValue(Main.empty, VoxelmonObject.class);
		} catch (IOException e) {
			Main.LOGGER.error("Could not read this IXL file.", e);
		}
		voxelmonPane.load();

        frame.setVisible(true);
    }

    public static JTextField createField(JPanel panel, String labelText) {
        return createField(panel, labelText, 10);
    }

    public static JTextField createField(JPanel panel, String labelText, int size) {
        JLabel label = new JLabel(labelText + ": ");
        JTextField field = new JTextField(size);

        label.setLabelFor(field);

        panel.add(label);
        panel.add(field, "pushx, growx, wrap");

        return field;
    }
}
