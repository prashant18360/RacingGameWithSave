package ap_assign6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TrampolineTest {

	@Test
	void test() {
		TileGameVersion_2 t = new TileGameVersion_2();
		assertThrows(TrampolineException.class, () -> t.TrampolexceptionTest(4));
		
	}

}
