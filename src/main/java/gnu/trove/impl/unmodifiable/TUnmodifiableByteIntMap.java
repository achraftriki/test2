///////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2008, Robert D. Eden All Rights Reserved.
// Copyright (c) 2009, Jeff Randall All Rights Reserved.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
///////////////////////////////////////////////////////////////////////////////

package main.java.gnu.trove.impl.unmodifiable;


//////////////////////////////////////////////////
// THIS IS A GENERATED CLASS. DO NOT HAND EDIT! //
//////////////////////////////////////////////////

////////////////////////////////////////////////////////////
// THIS IS AN IMPLEMENTATION CLASS. DO NOT USE DIRECTLY!  //
// Access to these methods should be through TCollections //
////////////////////////////////////////////////////////////



import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Random;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.IOException;

import main.java.gnu.trove.*;
import main.java.gnu.trove.function.*;
import main.java.gnu.trove.iterator.*;
import main.java.gnu.trove.list.*;
import main.java.gnu.trove.map.*;
import main.java.gnu.trove.procedure.*;
import main.java.gnu.trove.set.*;


public class TUnmodifiableByteIntMap implements TByteIntMap, Serializable {
	private static final long serialVersionUID = -1034234728574286014L;

	private final TByteIntMap m;

	public TUnmodifiableByteIntMap( TByteIntMap m ) {
		if ( m == null )
			throw new NullPointerException();
		this.m = m;
	}

	public int size()                       { return m.size(); }
	public boolean isEmpty()                { return m.isEmpty(); }
	public boolean containsKey( byte key )   { return m.containsKey( key ); }
	public boolean containsValue( int val ) { return m.containsValue( val ); }
	public int get( byte key)                { return m.get( key ); }

	public int put( byte key, int value ) { throw new UnsupportedOperationException(); }
	public int remove( byte key ) { throw new UnsupportedOperationException(); }
	public void putAll( TByteIntMap m ) { throw new UnsupportedOperationException(); }
	public void putAll( Map<? extends Byte, ? extends Integer> map ) { throw new UnsupportedOperationException(); }
	public void clear() { throw new UnsupportedOperationException(); }

	private transient TByteSet keySet = null;
	private transient TIntCollection values = null;

	public TByteSet keySet() {
		if ( keySet == null )
			keySet = TCollections.unmodifiableSet( m.keySet() );
		return keySet;
	}
	public byte[] keys() { return m.keys(); }
	public byte[] keys( byte[] array ) { return m.keys( array ); }

	public TIntCollection valueCollection() {
		if ( values == null )
			values = TCollections.unmodifiableCollection( m.valueCollection() );
		return values;
	}
	public int[] values() { return m.values(); }
	public int[] values( int[] array ) { return m.values( array ); }

	public boolean equals(Object o) { return o == this || m.equals(o); }
	public int hashCode()           { return m.hashCode(); }
	public String toString()        { return m.toString(); }
	public byte getNoEntryKey()      { return m.getNoEntryKey(); }
	public int getNoEntryValue()    { return m.getNoEntryValue(); }

	public boolean forEachKey( TByteProcedure procedure ) {
		return m.forEachKey( procedure );
	}
	public boolean forEachValue( TIntProcedure procedure ) {
		return m.forEachValue( procedure );
	}
	public boolean forEachEntry( TByteIntProcedure procedure ) {
		return m.forEachEntry( procedure );
	}

	public TByteIntIterator iterator() {
		return new TByteIntIterator() {
			TByteIntIterator iter = m.iterator();

			public byte key() { return iter.key(); }
			public int value() { return iter.value(); }
			public void advance() { iter.advance(); }
			public boolean hasNext() { return iter.hasNext(); }
			public int setValue( int val ) { throw new UnsupportedOperationException(); }
			public void remove() { throw new UnsupportedOperationException(); }
		};
	}

	public int putIfAbsent( byte key, int value ) { throw new UnsupportedOperationException(); }
	public void transformValues( TIntFunction function ) { throw new UnsupportedOperationException(); }
	public boolean retainEntries( TByteIntProcedure procedure ) { throw new UnsupportedOperationException(); }
	public boolean increment( byte key ) { throw new UnsupportedOperationException(); }
	public boolean adjustValue( byte key, int amount ) { throw new UnsupportedOperationException(); }
	public int adjustOrPutValue( byte key, int adjust_amount, int put_amount ) { throw new UnsupportedOperationException(); }
}
