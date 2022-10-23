package com.tix.vista;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class EmptyPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public EmptyPanel() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		setSize(new Dimension(910, 700));
	}
}
