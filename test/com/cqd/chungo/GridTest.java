package com.cqd.chungo;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.chunquedong.chungo.Board;
import com.chunquedong.chungo.Grid;
import com.chunquedong.chungo.PieceProcess;
import com.chunquedong.chungo.util.Coordinate;

public class GridTest {

	Grid grid;
	
	@Before
	public void setUp(){
		grid=new Grid();
	}
	
	@Test
	public void testSimplePutPiece() {
		
		Coordinate c=new Coordinate(3,3);
		int bw=Board.Black;
		
		PieceProcess p=new PieceProcess(bw,c);
		grid.putPiece(p);
		
		assertTrue(grid.getValue(c)==bw);
	}
	
	@Test
	public void testTwoPutPiece() {
		
		Coordinate c=new Coordinate(3,3);
		int bw=Board.Black;
		Coordinate c2=new Coordinate(3,2);
		int bw2=Board.White;
		
		grid.putPiece(new PieceProcess(bw,c));
		PieceProcess p=new PieceProcess(bw2,c2);
		grid.putPiece(p);
		
		assertTrue(grid.getValue(c)==bw);
		assertTrue(grid.getValue(c2)==bw2);
	}
	
	@Test
	public void testOverPutPiece() {
		
		Coordinate c=new Coordinate(3,3);
		int bw=Board.Black;
		int bw2=Board.White;
		
		grid.putPiece(new PieceProcess(bw,c));
		PieceProcess p=new PieceProcess(bw2,c);
		boolean b=grid.putPiece(p);
		
		assertTrue(!b);
		assertTrue(grid.getValue(c)==bw);
	}
	
	@Test
	public void testPictIt() {
		
		Coordinate c=new Coordinate(3,3);
		int bw=Board.Black;
		int bw2=Board.White;
		
		grid.putPiece(new PieceProcess(bw,c));
		
		
		for(int i=0;i<4;i++){
			Coordinate nc=c.getNear(i);
			grid.putPiece(new PieceProcess(bw2,nc));
		}
		
		assertTrue(grid.getValue(c)==Board.None);
	}
	
	@Test
	public void testPictSelf() {
		
		Coordinate c=new Coordinate(3,3);
		int bw=Board.Black;
		int bw2=Board.White;
		
		for(int i=0;i<4;i++){
			Coordinate nc=c.getNear(i);
			grid.putPiece(new PieceProcess(bw2,nc));
		}
		
		grid.putPiece(new PieceProcess(bw,c));
		
		assertTrue(grid.getValue(c)==Board.None);
	}
}
