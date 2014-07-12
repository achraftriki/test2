package test.java.gnu.trove.map.hash;


import java.io.Serializable;
import java.util.Arrays;

import main.java.gnu.trove.strategy.HashingStrategy;


/**
*
*/
public class ArrayHashingStrategy
	implements HashingStrategy<char[]>, Serializable {

	public int computeHashCode( char[] o ) {
		return Arrays.hashCode( o );
	}

	public boolean equals( char[] o1, char[] o2 ) {
		return Arrays.equals( o1, o2 );
	}
}
