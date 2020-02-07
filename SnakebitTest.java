package ap_assign6;

import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.Test;

class SnakebitTest {

	@Test
	void test() {
		TileGameVersion_2 t = new TileGameVersion_2();
		
		assertThrows(SnakebiteException.class, () -> t.SnakeexceptionTest(1));
	}

}
