package zohointership;

import java.util.ArrayList;
import java.util.List;

public class Browser{
	private String name;
	private String version;
	private List<String> urls;
	
	Browser(){
		
	}
	
	Browser(String name, String version){
		this.name = name;
		this.version = version;
		this.urls = new ArrayList<String>();
		
	}
	
	Browser(String name, String version, String[] urls){
		this.name = name;
		this.version = version;
		this.urls = new ArrayList<String>();
		for(String url : urls) {
			this.urls.add(url);
		}
	}
	
	void addUrl(String name) {
		urls.add(name);
	}
	
	String getName() {
		return name;
	}
	
	void show() {
		System.out.println("Name :" + name);
		System.out.println("Version :" + version);
		System.out.println("History");
		for (String url : urls) {
			System.out.println(url);
		}
	}
	
	void showHistory() {
		for(int idx = 0; idx < urls.size(); idx ++) {
			System.out.println((idx + 1) + ". " + urls.get(idx));
		}
	}
	
	void deleteUrl(int index) {
		urls.remove(index);
	}
	
	void resetHistory() {
		urls.clear();
	}
}