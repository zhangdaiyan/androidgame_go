package com.cqd.chungo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.chunquedong.chungo.Board;
import com.chunquedong.chungo.sgf.SgfHelper;
import com.chunquedong.chungo.util.Coordinate;


public class BoardTest {
	Board board;
	
	@Before
	public void setUp(){
		board=new Board();
	}
	
	@Test
	public void testDaJie() {
		 board.put(3,3);
		 board.put(3,4);
		 board.put(4,4);
		 board.put(4,5);
		 board.put(4,2);
		 board.put(5,4);
		 board.put(5,3);
		 board.put(4,3);
		 boolean b=board.put(4,4);
		 assertFalse(b);
	}
	
	@Test
	public void testSgf() {
		 try {
			List<Coordinate> cs=SgfHelper.getCoordList("D:\\Temp\\Game3.sgf");
			for(Coordinate c:cs){
				board.put(c.x, c.y);
			}
			SgfHelper.save(board, "D:\\Temp\\Game3copy.sgf");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
