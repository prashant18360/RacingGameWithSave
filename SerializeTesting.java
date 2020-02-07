package ap_assign6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SerializeTesting {

	@Test
	void test() {
		TileGameVersion_2 temp = new TileGameVersion_2();
		GameDataHandling gobj = new GameDataHandling();
		temp.setMaxpath(100);
		temp.usernameset("john");
		temp.setPosition(0);
		temp.setCount_crick(0);
		temp.setCount_snak(0);
		temp.setCount_tramp(0);
		temp.setCount_vul(0);
		temp.setRollcount(0);
		temp.setE25(false);
		temp.setE50(false);
		temp.setE75(false);
		gobj.serialize(temp);
		TileGameVersion_2 obj2 = gobj.Deserialize();
		assertEquals(obj2.getUsername(), temp.getUsername());
		assertEquals(obj2.getMaxpath(), temp.getMaxpath());
		assertEquals(obj2.getPosition(), temp.getPosition());
		assertEquals(obj2.getCount_crick(), temp.getCount_crick());
		assertEquals(obj2.getCount_snak(), temp.getCount_snak());
		assertEquals(obj2.getCount_tramp(), temp.getCount_tramp());
		assertEquals(obj2.getCount_vul(), temp.getCount_vul());
		assertEquals(obj2.getRollcount(), temp.getRollcount());
		assertEquals(obj2.isE25(), temp.isE25());
		assertEquals(obj2.isE50(), temp.isE50());
		assertEquals(obj2.isE75(), temp.isE75());
		
	}

}
