package prob2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.math.*;

public class MartianManager {
	protected ArrayList <Martian> martians = new ArrayList<>();
	protected ArrayList <Teleporter> teleporters = new ArrayList<>();
	
	public MartianManager() {}
	
	public boolean addMartian(Martian m) {
//		for(Martian i: martians) {
//			if(martians.get(i.getId()) == martians.get(m.getId())) {
//				return false;
//			}	
//		}
		if(martians.contains(m)) {
			return false;
		}
		if(m instanceof GreenMartian) {
			GreenMartian added = (GreenMartian)m;
			teleporters.add(added);
		}
		martians.add(m);
		return true;
	}
	
	//loop through invaders
	//loop through martians
	//if invader power > martian power
	//remove from martian (and teleporter)
	//add to killed
	//return killed
	public ArrayList<Martian> battle(ArrayList<Martian> invaders){
		ArrayList<Martian> killed = new ArrayList<>();
		for(int i = 0; i < invaders.size(); i++) {
			for(int j = 0; j < martians.size(); j++) {
				Martian curr = martians.get(i);
				if(invaders.get(i).power() > curr.power()) {
					killed.add(curr);
					martians.add(curr);
					if(curr instanceof GreenMartian) {
						Martian m = (GreenMartian)curr;
						killed.add(m);
						martians.remove(m);
						teleporters.remove(m);
					}
				}
			}
			
		}
		return killed;
	}
	
	public boolean contains(int id) {
		for(int i = 0; i < martians.size(); i++) {
			if(martians.get(i).getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public Martian getMartianAt(int i) {
		if((0 <= i) && (i < martians.size())) {
			return martians.get(i);
		}
		else {
			return null;
		}
	}
	
	public Martian getMartianClosestTo(int id) {
		//int closest = -1;
		int diff = 10000;
		Martian m = null;
		for(int i = 0; i < martians.size(); i++) {
			if((martians.get(i).getId() > id) && 
					(martians.get(i).getId() - id < diff)) {
				diff = martians.get(i).getId() - id;
				m = martians.get(i);
			}
			if((martians.get(i).getId() < id) && 
					(id - martians.get(i).getId() < diff)) {
				diff = id - martians.get(i).getId();
				m = martians.get(i);
			}
		}
		return m;
	}
	
	public Martian getMartianClosestTo(Martian martian) {
		return getMartianClosestTo(martian.getId());
	}
	
	public Martian getMartianWithId(int id) {
		Martian m  = null;
		for(int i = 0; i < martians.size(); i++) {
			if(martians.contains(id)) {
				m = martians.get(i);
			}
			else {
				return null;
			}
		}
		return m;
	}
	
	public int getNumMartians() {
		return martians.size();
	}
	
	public int getNumTeleporters() {
		return teleporters.size();
	}
	
	public ArrayList<Martian> getSortedMartians(){
		ArrayList<Martian> sortedMartians = new ArrayList<>();
		sortedMartians.addAll(martians);
		Collections.sort(sortedMartians);
		return sortedMartians;
	}
	
	public Teleporter getTeleporterAt(int i) {
		if((0 <= i) && (i < teleporters.size())) {
			return teleporters.get(i);
		}
		return null;
	}
	
	public String groupSpeak() {
		String msg = "";
		for(int i = 0; i < martians.size(); i++) {
			msg += martians.get(i).speak();
			msg += "\n";
		}
		return msg;
	}
	
	public String groupTeleport(String dest) {
		String msg = "";
		for(int i = 0; i < teleporters.size(); i++) {
			msg += teleporters.get(i).teleport(dest);
			msg += "\n";
		}
		return msg;
	}
	
	public void obliterateTeleporters() {
		teleporters.clear();
		for(int i = 0; i < martians.size(); i++) {
			if(martians.get(i) instanceof GreenMartian) {
				Martian m = (GreenMartian)martians.get(i);
				martians.remove(m);
			}
		}
	}
	
	public Martian removeMartian(int id) {
		Martian m = null;
		if((0 <= id) && (id < martians.size())) {
			m = martians.get(id);
			for(int i = id + 1; i < martians.size(); i++) {
				Martian temp = martians.get(i - 1);
				temp = martians.get(i);
			}
		}
		return m;
	}
	
	public String toString() {
		String msg = "Martians:\n";
		for(int i = 0; i < martians.size(); i++) {
			msg += martians.get(i).toString();
			msg += "\n";
		}
		msg += "Teleporters:\n";
		for(int i = 0; i < teleporters.size(); i++) {
			msg += teleporters.get(i).toString();
			msg += "\n";
		}
		return msg;
	}

}
