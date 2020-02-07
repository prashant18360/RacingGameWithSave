package ap_assign6;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.FileReader;


class DangerTile implements java.io.Serializable{
	
	
	private Randomgenerate robj = new Randomgenerate();
	private final int move_T = this.getRobj().randomnumber();
	private int tilecounter;
	
	public int getTilecounter() {
		return tilecounter;
	}
	public void setTilecounter(int tilecounter) {
		this.tilecounter = tilecounter;
	}
	public Randomgenerate getRobj() {
		return robj;
	}
	public int getMove_T() {
		return move_T;
	}
	

	public DangerTile() {
		this.setTilecounter(0);
	}
	
	public int movestep(int pos) {
		int tpos = pos - this.getMove_T();
		if(tpos <= 0)
			tpos = 1;
		return tpos;
	}
}

class Snake extends DangerTile {
	
	private final int move_s = super.getMove_T();
	
	public Snake() {
		
	}
	
	public int getmove_s() {
		return move_s;
	}
}

class Vulture extends DangerTile {
	
	private final int move_v = super.getMove_T();
	
	public int getmove_v() {
		return move_v;
	}
}

class Cricket extends DangerTile {
	
	private final int move_c = super.getMove_T();
	
	public int getmove_c() {
		return move_c;
	}
	
}

class Trampoline implements java.io.Serializable{
	
	//private static final long serialversionUID = 12938938L;
	
	private Randomgenerate robjt = new Randomgenerate();
	private final int move_t =this.getRobjt().randomnumber();
	private int tilecounter;
	
	public int getTilecounter() {
		return tilecounter;
	}
	public void setTilecounter(int tilecounter) {
		this.tilecounter = tilecounter;
	}
	public Randomgenerate getRobjt() {
		return robjt;
	}
	public int getmove_t() {
		return move_t;
	}
	
	public Trampoline() {
		this.setTilecounter(0);
	}
	
	public int moveahead(int pos,int n) {
		int temp=pos;
		if(pos + this.getmove_t() <= n) {
			temp =  pos + this.getmove_t();
		}
		return temp;
	}
}

class Randomgenerate implements java.io.Serializable{
	//private static final long serialversionUID = 19348938L;
	public Randomgenerate() {}
	public int randomnumber() {
		Random rd = new Random();
		return rd.nextInt(10) + 1;
	}
}



class Dice implements java.io.Serializable{
	//private static final long serialversionUID = 29348938L;
	public Dice() {}
	public int diceroll() {
		Random ran = new Random();
		return ran.nextInt(6) + 1;
	}
}


class GamewinnerException extends Exception {
	public GamewinnerException(String message) {
		super(message);
	}
}

class SnakebiteException extends Exception {
	public SnakebiteException(String message) {
		super(message);
	}
}

class CricketbiteException extends Exception {
	public CricketbiteException(String message) {
		super(message);
	}
}

class VulturebiteException extends Exception {
	public VulturebiteException(String message) {
		super(message);
	}
}

class TrampolineException extends Exception {
	public TrampolineException(String message) {
		super(message);
	}
}

class WinnerwinnerException extends Exception {
	public WinnerwinnerException(String message) {
		super(message);
	}
}

class GameDataHandling {
	
	private TileGameVersion_2 store = new TileGameVersion_2();
	
	public TileGameVersion_2 getStore() {
		return store;
	}
	public void setStore(TileGameVersion_2 store) {
		this.store = store;
	}
	
	private String filename = "Data.txt";
	
	public void serialize(TileGameVersion_2 obj) {
		obj.setSdata(true);
		this.setStore(obj);
		try {
			
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(obj);

			
			out.close();
			file.close();
			
		}catch(IOException ex) {
			System.out.println("IOException is caught");
		}
		
	}
	public void deserialize(String name) {
		
		ObjectInputStream in = null;
		TileGameVersion_2 ob = null;
	
		
		try {
			FileInputStream file = new FileInputStream(filename);
			in = new ObjectInputStream(file);
			
			
				ob = (TileGameVersion_2)in.readObject();
				if(ob.getUsername().compareTo(name) == 0) {
					System.out.println("User Found");
					
				}
				
				else {
					System.out.println("User not Found");
					
				}
				
			
			
			in.close();
			file.close();	
			
			if(ob.getUsername().compareTo(name) == 0) {
				System.out.println("Welcome back " + name);
				
				this.Playagain(ob);
				
			}
		}
		catch(IOException ex) {
			System.out.println("IOException is caught");
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println("ClassNotFoundException is caught");
		}
		
	}
	
	public void Playagain(TileGameVersion_2 ob) {
		ob.GamePlay(this);
	}
	
	public TileGameVersion_2 Deserialize() {
		ObjectInputStream in = null;
		TileGameVersion_2 ob = null;
	
		
		try {
			FileInputStream file = new FileInputStream(filename);
			in = new ObjectInputStream(file);
			
			
				ob = (TileGameVersion_2)in.readObject();
			
			
			in.close();
			file.close();	
			
		}
		catch(IOException ex) {
			System.out.println("IOException is caught");
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println("ClassNotFoundException is caught");
		}
		
		return ob;
	}
	
	public void cleanthetrash() {
		TileGameVersion_2 T_obj = new TileGameVersion_2();
		T_obj.setUsername("SampleText");
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(T_obj);

		
			out.close();
			file.close();
		}
		catch(IOException ex) {
			System.out.println("IOException is caught");
		}
	}
}

class User implements java.io.Serializable{
	//private static final long serialversionUID = 12934898L;
	private final String name;
	public String getName() {
		return name;
	}
	public User(String str) {
		name = str;
	}
	
}

public class TileGameVersion_2 implements java.io.Serializable{
	
	private static final long serialversionUID = 129348938L;
	

	private User u;
	private DangerTile sn = new Snake();
	private DangerTile vl = new Vulture();
	private DangerTile ck = new Cricket();
	private Trampoline tp = new Trampoline();
	
	private Hashtable<Integer, Integer> tilemap = new Hashtable<Integer, Integer>();
	private int position;
	
	private int count_snak;
	private int count_vul;
	private int count_crick;
	private int count_tramp;
	
	private Randomgenerate rob = new Randomgenerate();
	private Dice d = new Dice();
	private String username; 
	private int rollcount;
	private int maxpath;
	

	private boolean E25;
	private boolean E50;
	private boolean E75;
	private int snakecounter;
	private int vulturecounter;
	private int cricketcounter;
	private int trampolinecounter;
	private boolean sdata;
	
	public boolean isSdata() {
		return sdata;
	}
	public void setSdata(boolean sdata) {
		this.sdata = sdata;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public DangerTile getSn() {
		return sn;
	}
	public void setSn(DangerTile sn) {
		this.sn = sn;
	}
	public DangerTile getVl() {
		return vl;
	}
	public void setVl(DangerTile vl) {
		this.vl = vl;
	}
	public DangerTile getCk() {
		return ck;
	}
	public void setCk(DangerTile ck) {
		this.ck = ck;
	}
	public Trampoline getTp() {
		return tp;
	}
	public void setTp(Trampoline tp) {
		this.tp = tp;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getSnakecounter() {
		return snakecounter;
	}
	public void setSnakecounter(int snakecounter) {
		this.snakecounter = snakecounter;
	}
	public int getVulturecounter() {
		return vulturecounter;
	}
	public void setVulturecounter(int vulturecounter) {
		this.vulturecounter = vulturecounter;
	}
	public int getCricketcounter() {
		return cricketcounter;
	}
	public void setCricketcounter(int cricketcounter) {
		this.cricketcounter = cricketcounter;
	}
	public int getTrampolinecounter() {
		return trampolinecounter;
	}
	public void setTrampolinecounter(int trampolinecounter) {
		this.trampolinecounter = trampolinecounter;
	}
	
	public Hashtable<Integer, Integer> getTilemap() {
		return tilemap;
	}
	public void setTilemap(Hashtable<Integer, Integer> tilemap) {
		this.tilemap = tilemap;
	}
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public int getCount_snak() {
		return count_snak;
	}
	public void setCount_snak(int count_snak) {
		this.count_snak = count_snak;
	}
	public int getCount_vul() {
		return count_vul;
	}
	public void setCount_vul(int count_vul) {
		this.count_vul = count_vul;
	}
	public int getCount_crick() {
		return count_crick;
	}
	public void setCount_crick(int count_crick) {
		this.count_crick = count_crick;
	}
	public int getCount_tramp() {
		return count_tramp;
	}
	public void setCount_tramp(int count_tramp) {
		this.count_tramp = count_tramp;
	}
	
	public Randomgenerate getRob() {
		return rob;
	}
	public Dice getD() {
		return d;
	}
	
	public int getRollcount() {
		return rollcount;
	}
	public void setRollcount(int rollcount) {
		this.rollcount = rollcount;
	}
	public int getMaxpath() {
		return maxpath;
	}
	public void setMaxpath(int maxpath) {
		this.maxpath = maxpath;
	}
	public boolean isE25() {
		return E25;
	}
	public void setE25(boolean e25) {
		E25 = e25;
	}
	public boolean isE50() {
		return E50;
	}
	public void setE50(boolean e50) {
		E50 = e50;
	}
	public boolean isE75() {
		return E75;
	}
	public void setE75(boolean e75) {
		E75 = e75;
	}
	
	public TileGameVersion_2() {
		this.setPosition(1);
		this.setRollcount(1);
		this.setE25(true);
		this.setE50(true);
		this.setE75(true);
		this.setSnakecounter(0);
		this.setVulturecounter(0);
		this.setCricketcounter(0);
		this.setTrampolinecounter(0);
		this.setSdata(false);
	}
	
	public void Gamewinnermessage() throws GamewinnerException {
		
		throw new GamewinnerException(" win the race in " + this.getRollcount() + " rolls  \n Total snake bite = " + this.getSn().getTilecounter()  + "\n Total Vulture bite = " + this.getVl().getTilecounter() + "\n Total Cricket bite = " + this.getCk().getTilecounter() + "\n Total Trampoline = " + this.getTp().getTilecounter());
	}
	
	public void checkmessagesnk()  throws SnakebiteException {
		throw new SnakebiteException("Hiss...! I am a Snake, ");
	}
	
	public void checkmessagevul() throws VulturebiteException {
		throw new VulturebiteException("Yapping...! I am Vulture, ");
	}
	
	public void checkmessagecric() throws CricketbiteException {
		throw new CricketbiteException("Chirp...! I am a Cricket, ");
	}
	
	public void checkmessagetramp() throws TrampolineException {
		throw new TrampolineException("Ping Pong ! I am Trampoline, ");
	}
	
	public void usernameset(String name) {
		this.setU(new User(name));
		this.setUsername(name);
	}
	
	public void SnakeexceptionTest(int p) throws SnakebiteException {
		if(p ==1)
			throw new SnakebiteException("Hiss...! I am a Snake, ");
	}
	
	public void VultureexceptionTest(int p) throws VulturebiteException {
		if(p == 2)
			throw new VulturebiteException("Yapping...! I am Vulture, ");
	}
	
	public void CricketexceptionTest(int p) throws CricketbiteException {
		if(p ==3)
			throw new CricketbiteException("Chirp...! I am a Cricket, ");
	}
	
	public void TrampolexceptionTest(int p) throws TrampolineException {
		if(p == 4)
			throw new TrampolineException("Ping Pong ! I am Trampoline, ");
	}
	
	public void WinnerwinnerexceptionTest(int pos) throws WinnerwinnerException {
		if(pos == 100)
			throw new WinnerwinnerException("=====Winner=====Winner=======");
	}
	
	
	
	public void Shaking(GameDataHandling gh) {
			int n = this.getMaxpath();
			System.out.println("Trying to shake the Tile-" + this.getPosition());
			Hashtable<Integer, Integer> trackmap = this.getTilemap();
			if(trackmap.get(this.getPosition()) == 1) {
				DangerTile s = this.getSn();
				s.setTilecounter(s.getTilecounter() + 1);
				this.setSnakecounter(this.getSnakecounter() + 1);
				this.setSn(s);
				try {
					this.checkmessagesnk();
				}
				catch(SnakebiteException e) {
					System.out.print(e.getMessage());
				}
				System.out.println("you go back " + sn.getMove_T() + " tiles!");
				this.setPosition(sn.movestep(this.getPosition()));
				System.out.println(this.getUsername() + " moved to Tile " + this.getPosition());
			}
			else if(trackmap.get(this.getPosition()) == 2) {
				DangerTile vul = this.getVl();
				vul.setTilecounter(vul.getTilecounter() + 1);
				this.setVulturecounter(this.getVulturecounter() + 1);
				this.setVl(vul);
				try {
					this.checkmessagevul();
				}
				catch(VulturebiteException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("you go back " + vl.getMove_T() + " tiles!");
				this.setPosition(vl.movestep(this.getPosition()));
				System.out.println(this.getUsername() + " moved to Tile " + this.getPosition());
			}
			else if(trackmap.get(this.getPosition()) == 3) {
				DangerTile cric = this.getCk();
				cric.setTilecounter(cric.getTilecounter() + 1);
				this.setCricketcounter(this.getCricketcounter() + 1);
				this.setCk(cric);
				try {
					this.checkmessagecric();
				}
				catch(CricketbiteException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("you go back " + ck.getMove_T() + " tiles!");
				this.setPosition(ck.movestep(this.getPosition()));
				System.out.println(this.getUsername() + " moved to Tile " + this.getPosition());
			}
			else if(trackmap.get(this.getPosition()) == 4) {
				Trampoline tram = this.getTp();
				tram.setTilecounter(tram.getTilecounter() + 1);
				this.setTrampolinecounter(this.getTrampolinecounter() + 1);
				this.setTp(tram);
				try {
					this.checkmessagetramp();
				}
				catch(TrampolineException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("you advance " + tp.getmove_t() + " tiles!");
				this.setPosition(tp.moveahead(this.getPosition(), n));
				System.out.println(this.getUsername() + " moved to Tile " + this.getPosition());
				if(this.getPosition() == n) {
					System.out.println("=====Winner=====Winner=======");
					if(this.isSdata()) {
						gh.cleanthetrash();
					}
					System.out.print(this.getUsername());
					try {
						Gamewinnermessage();
					}
					catch(GamewinnerException e) {
						System.out.println(e.getMessage());
					}
				}
				
			}
			else {
				System.out.println("I am a White tile !");
				System.out.println(this.getUsername() + " moved to Tile- " + this.getPosition());
			}
	}
	
	public void updatesettings() {
		int n = this.getMaxpath();
		Hashtable<Integer, Integer> tmap = this.getTilemap();
		int c=0;
		for(int i=1;i<=n-(n%6);i=i+6) {
			c=0;
			for(int j=0;j<6;j++) {
				if(5 <= tmap.get(i+j)) {
					c++;
				}
			}
			if(c == 0) {
				if(tmap.get(i+3) == 1) {
					tmap.put(i+3 , 8);
					this.setCount_snak(this.getCount_snak() - 1);
				}
				else if(tmap.get(i+3) == 2) {
					tmap.put(i+3 , 8);
					this.setCount_vul(this.getCount_vul() - 1);
				}
				else if(tmap.get(i+3) == 3) {
					tmap.put(i+3 , 8);
					this.setCount_crick(this.getCount_crick() - 1);
				}
				else if(tmap.get(i+3) == 4) {
					tmap.put(i+3 , 8);
					this.setCount_tramp(this.getCount_tramp() - 1);
				}
			}
			
		}
		this.setTilemap(tmap);
	}
	
	
	public void Runsetting() {
			int n = this.getMaxpath();
			System.out.println("Setting up the race track");
			Hashtable<Integer, Integer> tmap = this.getTilemap();
			tmap.put(1, 8);
			tmap.put(n, 8);
			for(int i=2;i<n;i++) {
				int temp = this.getRob().randomnumber();
				if(temp == 1) {
					tmap.put(i, 1);
					this.setCount_snak(this.getCount_snak() + 1);
				}
				else if(temp == 2) {
					tmap.put(i, 2);
					this.setCount_crick(this.getCount_crick() + 1);
				}
				else if(temp == 3) {
					tmap.put(i, 3);
					this.setCount_vul(this.getCount_vul() + 1);
				}
				else if(temp == 4) {
					tmap.put(i, 4);
					this.setCount_tramp(this.getCount_tramp() + 1);
				}
				else {
					tmap.put(i, temp);
				}
			}
			this.setTilemap(tmap);
			this.updatesettings();
			
			System.out.println("Danger : There are " + this.getCount_snak() + " , " + this.getCount_crick() + " , " + this.getCount_vul() + " number of snakes , cricket , vulture respectively on your track");
			
			System.out.println("Danger : Each Snake, Cricket and Vulture can throw you back by " + sn.getMove_T() + " , " + vl.getMove_T() + " , " + ck.getMove_T());
			
			System.out.println("Good News : There are " + this.getCount_tramp() + " number of Trampolines on your track!");
			
			System.out.println("Good News : Each Trampoline can help you by " + tp.getmove_t() + " number of Tiles");
			
		
	}
	
	public void GamePlay(GameDataHandling gh) {
			int n = this.getMaxpath();
			System.out.println("Game started ===================>");
			int temp;
			while(this.getPosition() < n) {
				if(this.getPosition() >= n/4 && this.isE25()) {
					this.setE25(false);
					System.out.println(this.getUsername() + " you at the Checkpoint of the Game. Enter your choice");
					System.out.println("1. For Continue the Game");
					System.out.println("2. For Save the Game");
					
					Scanner in1 = new Scanner(System.in);
					int tpch = in1.nextInt();
					if(tpch == 2) {
						gh.serialize(this);
						return ;
					}		
				}
				else if(this.getPosition() >= n/2 && this.isE50()) {
					this.setE50(false);
					System.out.println(this.getUsername() + " you at the Checkpoint of the Game. Enter your choice");
					System.out.println("1. For Continue the Game");
					System.out.println("2. For Save the Game");
					
					Scanner in1 = new Scanner(System.in);
					int tpch = in1.nextInt();
					if(tpch == 2) {
						gh.serialize(this);
						return ;
					}
				}
				else if(this.getPosition() >= (n/4)*3 && this.isE75()) {
					this.setE75(false);
					System.out.println(this.getUsername() + " you at the Checkpoint of the Game. Enter your choice");
					System.out.println("1. For Continue the Game");
					System.out.println("2. For Save the Game");
					
					Scanner in1 = new Scanner(System.in);
					int tpch = in1.nextInt();
					if(tpch == 2) {
						gh.serialize(this);
						return ;
					}
				}
				
				temp = this.getD().diceroll();
				System.out.print("[Roll-" + this.getRollcount() + "]: " + this.getUsername() + " rolled " + temp + " at Tile- " + this.getPosition() + ", ");
				if(this.getPosition() == 1) {
					if(temp == 6) {
						System.out.println("You are out of the cage ! You get a free roll");
						this.setRollcount(this.getRollcount() + 1);
						int temp2 = this.getD().diceroll();
						System.out.print("[Roll-" + this.getRollcount() + "]: " + this.getUsername() + " rolled " + temp2 + " at Tile- " + this.getPosition() + ", ");
						this.setPosition(1 + temp2);
						System.out.println("landed on Tile " + this.getPosition());
				
						this.Shaking(gh);
				
					}
					else {
						System.out.println("OOPs you need 6 to start");
					}
				}
				else if(this.getPosition() != 1) {
					if(this.getPosition() + temp > n) {
						System.out.println(" landed on Tile " + this.getPosition());
					}
					else if(this.getPosition() + temp == n) {
						this.setPosition(this.getPosition() + temp);
						System.out.println(" landed on Tile " + this.getPosition());
						System.out.println("=====Winner=====Winner=======");
						if(this.isSdata()) {
							gh.cleanthetrash();
						}
						System.out.print(this.getUsername());
						try {
							Gamewinnermessage();
						}
						catch(GamewinnerException e) {
							System.out.println(e.getMessage());
						}
				
					}
					else {
						this.setPosition(this.getPosition() + temp);
						System.out.println(" landed on Tile " + this.getPosition());
						this.Shaking(gh);
					}
				}
				this.setRollcount(this.getRollcount() + 1);
				
				
			}
			
	}


	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		GameDataHandling gh = new GameDataHandling();
		SnakebitTest st = new SnakebitTest();
		int choice;
		do {
			System.out.println("1. New User");
			System.out.println("2. Existing User");
			System.out.println("3. Exit");
			System.out.println("Enter your choice");
			InputStreamReader isr = new InputStreamReader(System.in);
		    BufferedReader br = new BufferedReader(isr);
		    choice = Integer.parseInt(br.readLine()); 
			
			
			switch(choice)
			{

			
		
				case 1 :	TileGameVersion_2 T = new TileGameVersion_2();
		
							boolean done = false;
							int total=0;
							while(!done) {
								System.out.println("Enter total number of tiles on the race track(length)");
								try {
									
									InputStreamReader istr = new InputStreamReader(System.in);
								    BufferedReader bfr = new BufferedReader(istr);
								    total = Integer.parseInt(bfr.readLine()); 
									
									
									T.setMaxpath(total);
									T.Runsetting();
				
									boolean done2 = false;
									while(!done2) {
										System.out.println("Enter the Player Name ");
										try {
											
											
											InputStreamReader isr_1 = new InputStreamReader(System.in);
										    BufferedReader br1 = new BufferedReader(isr_1);
										    String name = br1.readLine(); 
						
						
											System.out.println("Starting the game with " + name + " at Tile-" + T.getPosition());
											System.out.println("Control transferred to Computer for rolling the Dice for " + name);
											
											T.usernameset(name);
											
											T.GamePlay(gh);
											done2 = true;
						
										}
										catch(InputMismatchException inp1) {
											System.out.println("Wrong input ");
											System.out.println("this input should be string type ");
										}
					
									}
									done = true;
				
								}
			
								catch(InputMismatchException inp) {
									System.out.println("Wrong input ");
									System.out.println("This input should be Integer type ");
								}
							}
							break;
							
				case 2 :	Scanner sc = new Scanner(System.in);
							System.out.println("Enter Existing Username login");
						 
							String ename =  sc.next();
							gh.deserialize(ename);
							
							break;
							
				case 3 :	break;
				default :	System.out.println("Wrong Input");
			}
			
		
		}while(choice != 3);
		
		

	}

}
