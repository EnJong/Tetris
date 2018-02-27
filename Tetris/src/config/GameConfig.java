package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.*;
public class GameConfig<WindowLayoutsConfig> {

	private int width;
	
	private int height;
	
	private List<WindowLayoutConfig> windowLayoutsConfig = new ArrayList<WindowLayoutConfig>();

	public GameConfig() {
		SAXReader reader = new SAXReader();
		Document doc;
		try {
			doc = reader.read("config/cfg.xml");
			Element game = (Element) doc.getRootElement();
			Element frame = (Element) ((org.dom4j.Element) game).element("frame");
			this.width = Integer.parseInt(((org.dom4j.Element) frame).attributeValue("width"));
			this.height = Integer.parseInt(((org.dom4j.Element) frame).attributeValue("height"));
			
//			List<Element> windowLayouts = new ArrayList<Element>();
			List<org.dom4j.Element> windowLayouts = ((org.dom4j.Element) frame).elements();
			for(org.dom4j.Element windowLayout : windowLayouts) {
				WindowLayoutConfig wlc = new WindowLayoutConfig(
					windowLayout.attributeValue("className"),
					windowLayout.attributeValue("objectName"),					
					Integer.valueOf(windowLayout.attributeValue("axisX")), 
					Integer.valueOf(windowLayout.attributeValue("axisY"))
				);
				windowLayoutsConfig.add(wlc);
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public List<WindowLayoutConfig> getWindowLayoutsConfig() {
		return windowLayoutsConfig;
	}
//	public static void main(String[] args) {
//		GameConfig test = new GameConfig();
//	}
}