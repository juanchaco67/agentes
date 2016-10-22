package logic;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Genero {
	MACHO,
	HEMBRA;
	private static final List<Genero> VALUES =
			Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	public static Genero aleatorioGenero()  {

		return VALUES.get(RANDOM.nextInt(SIZE));
		
	}
	
}
