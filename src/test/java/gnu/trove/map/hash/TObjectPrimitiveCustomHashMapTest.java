package test.java.gnu.trove.map.hash;

import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

import main.java.gnu.trove.map.TObjectIntMap;
import main.java.gnu.trove.map.custom_hash.TObjectIntCustomHashMap;
import main.java.gnu.trove.strategy.HashingStrategy;


/**
 *
 */
public class TObjectPrimitiveCustomHashMapTest extends TestCase {
	// Example from Trove overview doc
	public void testArray() {
		char[] foo = new char[] { 'a', 'b', 'c' };
		char[] bar = new char[] { 'a', 'b', 'c' };

		assertFalse( foo.hashCode() == bar.hashCode() );
		//noinspection ArrayEquals
		assertFalse( foo.equals( bar ) );

		HashingStrategy<char[]> strategy = new ArrayHashingStrategy();
		assertTrue( strategy.computeHashCode( foo ) ==
			strategy.computeHashCode( bar ) );
		assertTrue( strategy.equals( foo, bar ) );

		TObjectIntMap<char[]> map = new TObjectIntCustomHashMap<char[]>( strategy );
		map.put( foo, 12 );
		assertTrue( map.containsKey( foo ) );
		assertTrue( map.containsKey( bar ) );
		assertEquals( 12, map.get( foo ) );
		assertEquals( 12, map.get( bar ) );

		Set<char[]> keys = map.keySet();
		assertTrue( keys.contains( foo ) );
		assertTrue( keys.contains( bar ) );
	}


	public void testSerialization() throws Exception {
		char[] foo = new char[] { 'a', 'b', 'c' };
		char[] bar = new char[] { 'a', 'b', 'c' };

		HashingStrategy<char[]> strategy = new ArrayHashingStrategy();
		TObjectIntMap<char[]> map = new TObjectIntCustomHashMap<char[]>( strategy );

		map.put( foo, 33 );

		// Make sure it still works after being serialized
		ObjectOutputStream oout = null;
		ByteArrayOutputStream bout = null;
		ObjectInputStream oin = null;
		ByteArrayInputStream bin = null;
		try {
			bout = new ByteArrayOutputStream();
			oout = new ObjectOutputStream( bout );

			oout.writeObject( map );

			bin = new ByteArrayInputStream( bout.toByteArray() );
			oin = new ObjectInputStream( bin );

			map = ( TObjectIntMap<char[]> ) oin.readObject();
		}
		finally {
			if ( oin != null ) oin.close();
			if ( bin != null ) bin.close();
			if ( oout != null ) oout.close();
			if ( bout != null ) bout.close();
		}

		assertTrue( map.containsKey( foo ) );
		assertTrue( map.containsKey( bar ) );
		assertEquals( 33, map.get( foo ) );
		assertEquals( 33, map.get( bar ) );

		Set<char[]> keys = map.keySet();
		assertTrue( keys.contains( foo ) );
		assertTrue( keys.contains( bar ) );
	}
}
