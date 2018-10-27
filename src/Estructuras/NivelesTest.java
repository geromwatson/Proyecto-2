package Estructuras;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NivelesTest {


	void testNivel1() {
		Niveles n = new Niveles();
		Linked_List m = n.Nivel1();
		int j = m.getLenght();
		assertEquals(15, j);
	}
	

}
