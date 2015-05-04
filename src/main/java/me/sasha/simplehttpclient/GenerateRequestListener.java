package me.sasha.simplehttpclient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Создание пакета для низкоуровневого HTTP-запроса из элементов: URL, метода, заголовков и тела
 * @author aleksandr
 */
public class GenerateRequestListener implements ActionListener {
	JTextField urlInputField, hostInputField, portInputField;
	JTextArea headersTextArea, bodyTextArea, requestTextArea;
	JComboBox<String> methodSelect;
	
	GenerateRequestListener(
			JTextField urlInputField,
			JTextField hostInputField,
			JTextField portInputField,
			JComboBox<String> methodSelect,
			JTextArea headersTextArea,
			JTextArea bodyTextArea,
			JTextArea requestTextArea) {
		this.urlInputField = urlInputField;
		this.hostInputField = hostInputField;
		this.portInputField = portInputField;
		this.methodSelect = methodSelect;
		this.headersTextArea = headersTextArea;
		this.bodyTextArea = bodyTextArea;
		this.requestTextArea = requestTextArea;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			URL url = new URL(urlInputField.getText());//парсинг URL стандартными средствами
			int port = url.getPort(); //извлечение порта из URL (по умолчанию 80)
			if (port <= 0) {
				port = 80;
			}
			portInputField.setText(""+port);
			String host = url.getHost();//хост (IP или домен) из URL
			hostInputField.setText(host);
			//HTTP-метод из списка
			String method = methodSelect.getItemAt(methodSelect.getSelectedIndex());
			//формирование первой строки запроса вида  METHOD /path/to/load HTTP/1.1
			requestTextArea.setText("");
			requestTextArea.append(method);
			requestTextArea.append(" ");
			String path = url.getPath();
			if (path.isEmpty()) {
				path = "/";
			}
			requestTextArea.append(path);
			String query = url.getQuery();
			if (query != null) {
				requestTextArea.append("?");
				requestTextArea.append(query);
			}
			String ref = url.getRef();
			if (ref != null) {
				requestTextArea.append("#");
				requestTextArea.append(ref);
			}
			requestTextArea.append(" HTTP/1.1");
			requestTextArea.append("\n");
			//Берём заголовки, разбиваем на массив строк
			String headersStr = headersTextArea.getText();
			String[] headers = headersStr.split("\n");
			//Берём тело запроса
			String body = bodyTextArea.getText();
			//Ключевые заголовки: Host (перенос домена из URL в запрос --
			//для работы нескольких сайтов на одном сервере)
			//и Content-Length (объём тела POST или PUT-запроса в байтах)
			boolean hostWasSet = false, contentLengthWasSet = false;
			for (String header: headers) {
				if (header.toLowerCase().startsWith("host:")) {
					header = "Host: " + host;
					hostWasSet = true;
				}
				if (header.toLowerCase().startsWith("content-length:")) {
					header = "Content-Length: " + body.getBytes("UTF-8").length;
				}
				//Перенос заголовков в формируемый пакет. Host и Content-Length
				//выставляются в соответствии с URL и объёмом тела, остальные просто копируются
				if (!header.isEmpty()) {
					requestTextArea.append(header);
					requestTextArea.append("\n");
				}
			}
			//Добавление Host и Content-Length, если они не были вставлены ранее
			if (!hostWasSet) {
				requestTextArea.append("Host: " + host + "\n");
			}
			if ((method.equals("POST") || method.equals("PUT")) && !contentLengthWasSet) {
				requestTextArea.append("Content-Length: " + body.getBytes("UTF-8").length + "\n");
			}
			requestTextArea.append("\n");//пустая строка между заголовками и телом
			if ((method.equals("POST") || method.equals("PUT"))) {
				requestTextArea.append(body);
			}
			
		} catch (MalformedURLException | UnsupportedEncodingException ex) {
			Logger.getLogger(GenerateRequestListener.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
}
