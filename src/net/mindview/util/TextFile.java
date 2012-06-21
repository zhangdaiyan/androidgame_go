package net.mindview.util;

import java.io.*;
import java.util.*;

public class TextFile extends ArrayList<String> {
	private static final long serialVersionUID = -7862048067122202787L;

	/**
	 * 文件读写的实用工具
	 * 
	 * @throws IOException
	 */
	// Read a file as a single String
	public static String read(String filename) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(
				new File(filename).getAbsoluteFile()));
		String s;
		while ((s = br.readLine()) != null) {
			sb.append(s + "\n");
		}
		br.close();
		return sb.toString();
	}

	// Write a single file in one method call
	public static void write(String filename, String text) throws IOException {
		File path = new File(filename).getAbsoluteFile();
		PrintWriter pw = new PrintWriter(path);
		pw.print(text);
		pw.close();
	}

	// Read a file,split by any regular expression
	public TextFile(String filename, String splitter) throws IOException {
		super(Arrays.asList(read(filename).split(splitter)));
		// System.out.println(get(0)+"======================");
		if (get(0).equals(""))
			System.out.println("++++++++++++++++");
		remove(0);
	}

	// Normally read by lines:
	public TextFile(String filename) throws IOException {
		this(filename, "\n");
	}
	
	public TextFile() {
		super();
	}

	public void write(String filename) throws IOException {
		File file=new File(filename);
		if(!file.exists()){
			file.createNewFile();
		}
		
		PrintWriter out = new PrintWriter(file.getAbsoluteFile());
		for (String item : this) {
			out.println(item);
		}
		out.close();
	}

	public static void main(String[] args) throws IOException {
		String file = read("src/net/mindview/util/TextFile.java");
		write("text.txt", file);
		// System.out.println(read("text.txt"));
		TextFile tf = new TextFile("text.txt");
		// System.out.println(read("text.txt"));
		tf.write("text2.txt");
		// System.out.println(read("text2.txt"));
		// 非词字符
		TreeSet<String> words = new TreeSet<String>(new TextFile(
				"src/net/mindview/util/TextFile.java", "\\W+"));
		System.out.println(words.toString());
		// headSet(E toElement)返回此 set 的部分视图，要求其元素严格小于 toElement。
		System.out.println(words.headSet("a"));
	}

}
