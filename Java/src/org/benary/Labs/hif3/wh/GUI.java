/*
 * The MIT License
 *
 * Copyright 2014 benaryorg.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.benary.Labs.hif3.wh;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author benaryorg
 */
public class GUI
{

	public static void main(String... args)
	{
		SwingUtilities.invokeLater(()->
		{
			JFrame win=new JFrame("Datentraeger");
			win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			win.setPreferredSize(new Dimension(640,400));

			win.setLayout(new BorderLayout());

			final JTextField field=new JTextField();
			win.add(field,BorderLayout.NORTH);

			final JTextArea area=new JTextArea();
			area.setEditable(false);
			win.add(area,BorderLayout.CENTER);

			JPanel panel=new JPanel();
			panel.setLayout(new FlowLayout());

			ActionListener al=(ActionEvent e)->
			{
				switch(e.getActionCommand())
				{
					case "ok":
						String[] strs=field.getText().split(":");
						try
						{
							switch(strs.length)
							{
								case 4:
									area.append(new CD(strs[0],Double.parseDouble(strs[1]),Integer.parseInt(strs[2]),Boolean.parseBoolean(strs[3])).toString()+"\n");
									break;
								case 5:
									if(strs[4].length()!=1)
									{
										throw new NumberFormatException("plusOderMinus hat falsche Zeichenanzahl");
									}
									area.append(new DVD(strs[0],Double.parseDouble(strs[1]),Integer.parseInt(strs[2]),Boolean.parseBoolean(strs[3]),strs[4].charAt(0)).toString()+"\n");
									break;
								default:
									throw new NumberFormatException("Falsche Parameteranzahl");
							}
						}
						catch(NumberFormatException|WertNegativException ex)
						{
							area.append("Falsches Format("+ex.getMessage()+")!\n");
						}
					case "cancel":
						field.setText("");
						break;
					default:
						throw new RuntimeException("IMPOSSIBRUUUUUUUUUUU!!!!!!!!!!!!1111einself");
				}
			};

			JButton ok=new JButton("OK");
			ok.setActionCommand("ok");
			ok.addActionListener(al);
			panel.add(ok);

			JButton cancel=new JButton("Abbruch");
			cancel.setActionCommand("cancel");
			cancel.addActionListener(al);
			panel.add(cancel);

			win.add(panel,BorderLayout.SOUTH);

			win.pack();
			win.setVisible(true);
		});
	}
}
