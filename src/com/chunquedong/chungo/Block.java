package com.chunquedong.chungo;

import java.util.ArrayList;
import java.util.List;

import com.chunquedong.chungo.util.Coordinate;
import com.chunquedong.chungo.util.Function;

/**
 * Æå¿é
 * @author yangjiandong
 *
 */
public class Block {
	private List<Coordinate> block=new ArrayList<Coordinate>();
	private int airCount=0;//ÆøÊý
	private int bw;//ÑÕÉ«
	
	public Block(int bw){
		this.bw=bw;
	}
	
	public int getBw(){
		return bw;
	}
	
	public void add(Coordinate c){
		block.add(c);
	}
	
	public void addAir(int air){
		airCount+=air;
	}
	
	public boolean isLive(){
		if(airCount>0 && block.size()>0)return true;
		return false;
	}
	
	public void each(Function f){
		for(Coordinate c:block){
			f.apply(c);
		}
	}
}
