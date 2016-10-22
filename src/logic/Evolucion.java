package logic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Evolucion {
	NACE,
	INFANCIA,
	ADOLECENCIA,
	ADULTOS,
	VEJEZ,
	MUERE;
	
	private static final List<Evolucion> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = 4;
	private static final Random RANDOM = new Random();
	public static Evolucion aleatorioEvolucion()  {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
