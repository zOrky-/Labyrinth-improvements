package telerik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


public class HighScoreBoard {
	ArrayList<Player> list = new ArrayList<Player>();
	public final int boardSize = 5;
	public HighScoreBoard(){
		list = new ArrayList<Player>();
	}
	
	public boolean addPlayerToChart(Player player){
	list.add(player);
	
	list.sort(new Comparator<Player> () { 
		public int compare(Player p1, Player p2) { 
			if(p1.movesCount > p2.movesCount) 
				return 1;
			else if(p1.movesCount < p2.movesCount) {
				return -1;
			}
			return 0;
		} 
	});
	int lastEle = list.size();
	if(lastEle > boardSize ) {
		list.remove(lastEle-1);
	}
	
	return list.contains(player);
	
	}
	void printBoard(ArrayList<Player> list){
		System.out.println("Score :");
		for(int i=0;i<list.size();i++){
			Player p = (Player) list.get(i);
			System.out.print((i+1)+". Name - "+p.name+" ");
			System.out.print("Escaped in "+p.movesCount+" moves");
			System.out.println();
		}
	}
}
