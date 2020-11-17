package com.github.kopilov.simplehttpclient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Выполнение HTTP-запроса. Отправка подготовленного пакета данных на сервер
 * и получение ответа.
 * @author aleksandr
 */
public class ExecuteQueryListener implements ActionListener {
	JTextField hostInputField, portInputField;
	JTextArea requestTextArea, responseTextAreas[];
	JButton[] listeningButtons;
	
	public ExecuteQueryListener(
			JTextField hostInputField,
			JTextField portInputField,
			JTextArea requestTextArea,
			JTextArea[] responseTextAreas,
			JButton[] listeningButtons) {
		this.hostInputField = hostInputField;
		this.portInputField = portInputField;
		this.requestTextArea = requestTextArea;
		this.responseTextAreas = responseTextAreas;
		this.listeningButtons = listeningButtons;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (JButton listeningButton: listeningButtons) {
			listeningButton.setEnabled(false);
		}
		for (JTextArea responseTextArea: responseTextAreas) {
			responseTextArea.setText("");
		}
		new Thread(new QueryExecuter()).start();
	}
	
	private class QueryExecuter implements Runnable {
		@Override
		public void run() {
			try (Socket socket = new Socket(hostInputField.getText(), Integer.valueOf(portInputField.getText()))) {
				OutputStream outputStream = socket.getOutputStream();
				PrintStream printStream = new PrintStream(outputStream);
				printStream.print(requestTextArea.getText());
				printStream.println();
				InputStream inputStream = socket.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String readingLine = bufferedReader.readLine();
				while (readingLine != null) {
					for (JTextArea responseTextArea: responseTextAreas) {
						responseTextArea.append(readingLine);
						responseTextArea.append("\n");
						responseTextArea.repaint();
					}
					readingLine = bufferedReader.readLine();
				}
			} catch (IOException ex) {
				Logger.getLogger(ExecuteQueryListener.class.getName()).log(Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(null, ex.getMessage());
			} finally {
				for (JButton listeningButton: listeningButtons) {
					listeningButton.setEnabled(true);
				}
			}
		}
	}

}
