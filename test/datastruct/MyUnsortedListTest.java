package datastruct;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyUnsortedListTest {

	@Test 
	public void testSize() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		assertEquals(0, list.size());
		list = MyUnsortedList.of(1,2,3);
		assertEquals(3, list.size());
	}
	
	@Test
	public void testToString() {
		UnsortedList<Integer> list = MyUnsortedList.of(4,9,2,6);
		assertEquals("MyUnsortedList { size = 4, [4, 9, 2, 6] }",list.toString());
		list = MyUnsortedList.of();
		assertEquals("MyUnsortedList { size = 0, [] }", list.toString());
	}
	
	@Test
	public void testIsEmpty() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		list = MyUnsortedList.of(4,9,3);
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void appendEmptyList() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.append(5);
		assertEquals(1, list.size());
		assertEquals(MyUnsortedList.of(5), list);
	}
	
	@Test
	public void appendNonEmptyList() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,7,9);
		list.append(5);
		assertEquals(4, list.size());
		assertEquals(MyUnsortedList.of(1,7,9,5), list);
	}
	
	@Test
	public void prependEmptyList() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.prepend(5);
		assertEquals(1, list.size());
		assertEquals(MyUnsortedList.of(5), list);
	}
	
	@Test
	public void prependNonEmptyList() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,7,9);
		list.prepend(5);
		assertEquals(4, list.size());
		assertEquals(MyUnsortedList.of(5,1,7,9), list);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void insertOutOfBounds() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.insert(5,7);
	}
	
	@Test
	public void insertEmptyList() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.insert(5,0);
		assertEquals(1, list.size());
		assertEquals(MyUnsortedList.of(5), list);
	}
	
	@Test
	public void insertNonEmptyList() {
		UnsortedList<Integer> list = MyUnsortedList.of(4,9,2,6);
		list.insert(1,3);
		assertEquals(5, list.size());
		assertEquals(MyUnsortedList.of(4,9,2,1,6), list);
		
		list = MyUnsortedList.of(4,2,6);
		list.insert(8,0);
		assertEquals(4, list.size());
		assertEquals(MyUnsortedList.of(8,4,2,6), list);

		list.insert(5,4);
		assertEquals(5, list.size());
		assertEquals(MyUnsortedList.of(8,4,2,6,5), list);
	}
	
	@Test(expected = EmptyListException.class)
	public void popEmptyList() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.pop();
	}
	
	@Test
	public void popSingleElemList() {
		UnsortedList<Integer> list = MyUnsortedList.of(1);
		int popped = list.pop();
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		assertEquals(MyUnsortedList.of(), list);
		assertEquals(1, popped);
	}
	
	@Test
	public void popMultiElemList() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4);
		int popped = list.pop();
		assertEquals(1, popped);
		assertEquals(3, list.size());
		assertEquals(MyUnsortedList.of(2,3,4), list);
		
		popped = list.pop();
		assertEquals(2, popped);
		assertEquals(2, list.size());
		assertEquals(MyUnsortedList.of(3,4), list);
	}
	
	@Test(expected = EmptyListException.class)
	public void popLastEmptyList() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.popLast();
	}
	
	@Test
	public void popLastSingleElemList() {
		UnsortedList<Integer> list = MyUnsortedList.of(1);
		int popped = list.popLast();
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		assertEquals(MyUnsortedList.of(), list);
		assertEquals(1, popped);
	}
	
	@Test
	public void popLastMultiElemList() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4);
		int popped = list.popLast();
		assertEquals(4, popped);
		assertEquals(3, list.size());
		assertEquals(MyUnsortedList.of(1,2,3), list);
		
		popped = list.popLast();
		assertEquals(3, popped);
		assertEquals(2, list.size());
		assertEquals(MyUnsortedList.of(1,2), list);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeEmptyListUnder() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.remove(-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeEmptyListOver() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.remove(10);
	}
	
	@Test
	public void removeSingleElemList() {
		UnsortedList<Integer> list = MyUnsortedList.of(1);
		int popped = list.remove(0);
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		assertEquals(MyUnsortedList.of(), list);
		assertEquals(1, popped);
	}
	
	@Test
	public void removeMultiElemListEnd() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4);
		int popped = list.remove(3);
		assertEquals(4, popped);
		assertEquals(3, list.size());
		assertEquals(MyUnsortedList.of(1,2,3), list);
		
		popped = list.remove(2);
		assertEquals(3, popped);
		assertEquals(2, list.size());
		assertEquals(MyUnsortedList.of(1,2), list);
	}
	
	@Test
	public void removeMultiElemListMiddle() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4);
		int popped = list.remove(2);
		assertEquals(3, popped);
		assertEquals(3, list.size());
		assertEquals(MyUnsortedList.of(1,2,4), list);
		
		popped = list.remove(1);
		assertEquals(2, popped);
		assertEquals(2, list.size());
		assertEquals(MyUnsortedList.of(1,4), list);
	}
	
	@Test
	public void removeMultiElemListStart() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4);
		int popped = list.remove(0);
		assertEquals(1, popped);
		assertEquals(3, list.size());
		assertEquals(MyUnsortedList.of(2,3,4), list);
		
		popped = list.remove(0);
		assertEquals(2, popped);
		assertEquals(2, list.size());
		assertEquals(MyUnsortedList.of(3,4), list);
	}
	
	@Test
	public void testEquals() {
		UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4);
		assertFalse(list.equals(14));
		assertFalse(list.equals(MyUnsortedList.of(1,2)));
		assertFalse(list.equals(MyUnsortedList.of(1,7,6,4,9)));
		assertFalse(list.equals(MyUnsortedList.of(1,null,3,4)));
		assertTrue(list.equals(MyUnsortedList.of(1,2,3,4)));
	}
}
