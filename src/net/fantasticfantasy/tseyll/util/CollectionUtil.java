package net.fantasticfantasy.tseyll.util;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**The <code>CollectionUtil</code> class offers many methods
 * useful when dealing with the Java Collection Framework and
 * the Native I/O, such as conversions, storing and loading from
 * buffers, concatenating and getting non-null elements from
 * collections that allows them. 
 */
public class CollectionUtil {
	
	/**Specifies which element is to be returned
	 * on {@link #getNonNull(T[]) getNonNull()} methods. */
	public static final int ORDER_FIRST = 0,
							ORDER_LAST = 1;
	
	/**@STATIC_MODULE_CLASS*/
	private CollectionUtil() {}
	
	/**Appends the elements contained in src to dest.
	 * 
	 * @param <T> The element type of the source and destination
	 * 
	 * @param src - The source array
	 * @param dest - The destination {@link List}
	 */
	public static <T> void putArrayOnList(T[] src, List<T> dest) {
		for (int i = 0; i < src.length; i++) {
			dest.add(src[i]);
		}
	}
	
	/**Appends the elements, from srcoff to srcsize, contained in src to dest.
	 * 
	 * @param <T> The element type of the source and destination
	 * 
	 * @param src - The source array
	 * @param srcoff - The source elements offset
	 * @param srcsize - The source element count minus the offset
	 * @param dest - The destination {@link List}
	 */
	public static <T> void putArrayOnList(T[] src, int srcoff, int srcsize, List<T> dest) {
		for (int i = srcoff; i < srcsize; i++) {
			dest.add(src[i]);
		}
	}

	/**Appends the elements contained in src to dest.
	 * 
	 * @param <T> The element type of the source and destination
	 * 
	 * @param src - The source array
	 * @param dest - The destination {@link Set}
	 */
	public static <T> void putArrayOnSet(T[] src, Set<T> dest) {
		for (int i = 0; i < src.length; i++) {
			dest.add(src[i]);
		}
	}

	/**Appends the elements, from srcoff to srcsize, contained in src to dest.
	 * 
	 * @param <T> The element type of the source and destination
	 * 
	 * @param src - The source array
	 * @param srcoff - The source elements offset
	 * @param srcsize - The source element count minus the offset
	 * @param dest - The destination {@link Set}
	 */
	public static <T> void putArrayOnSet(T[] src, int srcoff, int srcsize, Set<T> dest) {
		for (int i = srcoff; i < srcsize; i++) {
			dest.add(src[i]);
		}
	}
	
	/**Creates a new {@link List} containing the array's elements
	 * 
	 * @param <T> The elements type
	 * 
	 * @param src - The source array
	 * 
	 * @return The newly created {@link List} containing the array's elements
	 */
	public static <T> List<T> arrayToList(T[] src) {
		List<T> list = new ArrayList<>();
		putArrayOnList(src, list);
		return list;
	}
	
	/**Creates a new array of type < T > containing the {@link List}'s elements.
	 * 
	 * @param <T> The elements type
	 * 
	 * @param src - The source {@link List}
	 * 
	 * @return A newly created array containing the {@link List}'s elements
	 * 
	 * @throws NullPointerException If no non-null element was found in the {@link List}
	 */
	public static <T> T[] listToArray(List<T> src) {
		if (src.size() == 0) return null;
		T ins = getNonNull(src);
		@SuppressWarnings("unchecked")
		T[] t = (T[]) Array.newInstance(ins.getClass(), src.size());
		for (int i = 0; i < src.size(); i++) {
			t[i] = src.get((int) i);
		}
		return t;
	}
	
	/**Creates a new {@link List} containing the {@link Set}'s elements.
	 * 
	 * @param src - The source {@link Set}
	 * 
	 * @return A newly created {@link List} containing the {@link Set}'s elements
	 */
	public static <T> List<T> setToList(Set<T> src) {
		List<T> dest = new ArrayList<>();
		dest.addAll(src);
		return dest;
	}
	
	public static <T> Set<T> listToSet(List<T> src) {
		Set<T> dest = new LinkedHashSet<>();
		dest.addAll(src);
		return dest;
	}
	
	public static <T> T[] setToArray(Set<T> src) {
		if (src.size() == 0) return null;
		T ins = getNonNull(src);
		@SuppressWarnings("unchecked")
		T[] t = (T[]) Array.newInstance(ins.getClass(), src.size());
		int p = 0;
		for (T e : src) {
			t[p++] = e;
		}
		return t;
	}
	
	public static <T> Set<T> arrayToSet(T[] src) {
		Set<T> set = new LinkedHashSet<>();
		for (T t : src) {
			set.add(t);
		}
		return set;
	}
	
	public static <T> T[] collectionToArray(Collection<T> collection) {
		return listToArray(collectionToList(collection));
	}
	
	public static <T> List<T> collectionToList(Collection<T> collection) {
		List<T> list = new ArrayList<>();
		list.addAll(collection);
		return list;
	}
	
	public static <T> Set<T> collectionToSet(Collection<T> collection) {
		Set<T> set = new LinkedHashSet<>();
		set.addAll(collection);
		return set;
	}
	
	public static <T, U> Map<T, U> createMap(Set<T> keys, List<U> values, U fill) {
		Map<T, U> map = new LinkedHashMap<>();
		int p = 0;
		for (T key : keys) {
			U value = p >= values.size() ? fill : values.get(p++);
			map.put(key, value);
		}
		return map;
	}
	
	public static <T, U> Map<T, U> createMap(Set<T> keys, List<U> values) {
		return createMap(keys, values, null);
	}
	
	public static <T, U> Map<T, U> setToMap(Set<T> set, U fill) {
		Map<T, U> map = new LinkedHashMap<>();
		for (T t : set) {
			map.put(t, fill);
		}
		return map;
	}
	
	public static <T, U> Map<T, U> setToMap(Set<T> set) {
		return setToMap(set, null);
	}
	
	public static <T> T[] mapKeysToArray(Map<T, ?> map) {
		return setToArray(map.keySet());
	}
	
	public static <T> T[] mapValuesToArray(Map<?, T> map) {
		return listToArray(collectionToList(map.values()));
	}
	
	public static <T> List<T> mapKeysToList(Map<T, ?> map) {
		return setToList(map.keySet());
	}
	
	public static <T> List<T> mapValuesToList(Map<?, T> map) {
		return collectionToList(map.values());
	}
	
	public static <T> Set<T> mapKeysToSet(Map<T, ?> map) {
		return map.keySet();
	}
	
	@SafeVarargs
	public static <T> List<T> concat(List<T>... lists) {
		if (lists.length == 0) {
			return new ArrayList<>();
		}
		List<T> dest = new ArrayList<>();
		for (List<T> list : lists) {
			dest.addAll(list);
		}
		return dest;
	}
	
	@SafeVarargs
	public static <T> T[] concat(T[]... arrays) {
		int size = totalSizeOf(arrays);
		T[] t = Arrays.copyOf(arrays[0], size);
		int p = 0;
		for (T[] array : arrays) {
			put(array, t, p);
			p += array.length;
		}
		return t;
	}
	
	public static <T> T[] concat(T[] left, T[] right) {
		T[] t = Arrays.copyOf(left, left.length + right.length);
		put(left, t);
		put(right, t, left.length);
		return t;
	}
	
	@SafeVarargs
	public static <T> Set<T> concat(Set<T>... sets) {
		if (sets.length == 0) {
			return new HashSet<>();
		}
		Set<T> dest = new HashSet<>();
		for (Set<T> set : sets) {
			dest.addAll(set);
		}
		return dest;
	}
	
	@SafeVarargs
	public static <T, U> Map<T, U> concat(Map<T, U>... maps) {
		if (maps.length <= 0) {
			return new HashMap<>();
		}
		Map<T, U> dest = new HashMap<>();
		for (Map<T, U> map : maps) {
			dest.putAll(map);
		}
		return dest;
	}
	
	public static <T> T[] duplicate(T[] array) {
		return Arrays.copyOf(array, array.length);
	}
	
	public static <T> List<T> duplicate(List<T> list) {
		List<T> copy = new ArrayList<>();
		copy.addAll(list);
		return copy;
	}
	
	public static <T> Set<T> duplicate(Set<T> set) {
		Set<T> copy = new HashSet<>();
		copy.addAll(set);
		return copy;
	}
	
	public static <T, U> Map<T, U> duplicate(Map<T, U> map) {
		Map<T, U> copy = new HashMap<>();
		copy.putAll(map);
		return copy;
	}
	
	public static <T> T[] trim(T[] array) {
		int newsize = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				newsize = i;
			}
		}
		return Arrays.copyOf(array, newsize);
	}
	
	public static <T> T[] removeDoubles(T[] array) {
		Set<T> set = new HashSet<>();
		for (T t : array) {
			set.add(t);
		}
		return setToArray(set);
	}
	
	public static <T> List<T> removeDoubles(List<T> list) {
		Set<T> set = new HashSet<T>();
		for (T t : list) {
			set.add(t);
		}
		return setToList(set);
	}
	
	public static <T> void put(T[] src, int srcoff, int srcsize, T[] dest, int destoff) {
		for (int i = 0; i < srcsize; i++) {
			dest[i + destoff] = src[i + srcoff];
		}
	}
	
	public static <T> void put(T[] src, int srcsize, T[] dest, int destoff) {
		put(src, 0, srcsize, dest, destoff);
	}
	
	public static <T> void put(T[] src, int srcsize, T[] dest) {
		put(src, 0, srcsize, dest, 0);
	}
	
	public static <T> void put(T[] src, T[] dest, int destoff) {
		put(src, 0, src.length, dest, destoff);
	}
	
	public static <T> void put(T[] src, T[] dest) {
		put(src, 0, src.length, dest, 0);
	}
	
	public static Byte[] toByteObjArray(byte[] array) {
		Byte[] objarray = new Byte[array.length];
		int p = 0;
		for (byte b : array) {
			objarray[p++] = b;
		}
		return objarray;
	}
	
	public static Short[] toShortObjArray(short[] array) {
		Short[] objarray = new Short[array.length];
		int p = 0;
		for (short s : array) {
			objarray[p++] = s;
		}
		return objarray;
	}
	
	public static Integer[] toIntObjArray(int[] array) {
		Integer[] objarray = new Integer[array.length];
		int p = 0;
		for (int i : array) {
			objarray[p++] = i;
		}
		return objarray;
	}
	
	public static Long[] toLongObjArray(long[] array) {
		Long[] objarray = new Long[array.length];
		int p = 0;
		for (long l : array) {
			objarray[p++] = l;
		}
		return objarray;
	}
	
	public static Float[] toFloatObjArray(float[] array) {
		Float[] objarray = new Float[array.length];
		int p = 0;
		for (float f : array) {
			objarray[p++] = f;
		}
		return objarray;
	}
	
	public static Double[] toDoubleObjArray(double[] array) {
		Double[] objarray = new Double[array.length];
		int p = 0;
		for (double d : array) {
			objarray[p++] = d;
		}
		return objarray;
	}
	
	public static Boolean[] toBooleanObjArray(boolean[] array) {
		Boolean[] objarray = new Boolean[array.length];
		int p = 0;
		for (boolean b : array) {
			objarray[p++] = b;
		}
		return objarray;
	}
	
	public static Character[] toCharObjArray(char[] array) {
		Character[] objarray = new Character[array.length];
		int p = 0;
		for (char c : array) {
			objarray[p++] = c;
		}
		return objarray;
	}
	
	public static byte[] toByteArray(Byte[] objarray) {
		byte[] array = new byte[objarray.length];
		int p = 0;
		for (byte b : objarray) {
			array[p++] = b;
		}
		return array;
	}
	
	public static short[] toShortArray(Short[] objarray) {
		short[] array = new short[objarray.length];
		int p = 0;
		for (short s : objarray) {
			array[p++] = s;
		}
		return array;
	}
	
	public static int[] toIntArray(Integer[] objarray) {
		int[] array = new int[objarray.length];
		int p = 0;
		for (int i : objarray) {
			array[p++] = i;
		}
		return array;
	}
	
	public static long[] toLongArray(Long[] objarray) {
		long[] array = new long[objarray.length];
		int p = 0;
		for (long l : objarray) {
			array[p++] = l;
		}
		return array;
	}
	
	public static float[] toFloatArray(Float[] objarray) {
		float[] array = new float[objarray.length];
		int p = 0;
		for (float f : objarray) {
			array[p++] = f;
		}
		return array;
	}
	
	public static double[] toDoubleArray(Double[] objarray) {
		double[] array = new double[objarray.length];
		int p = 0;
		for (double d : objarray) {
			array[p++] = d;
		}
		return array;
	}
	
	public static boolean[] toBooleanArray(Boolean[] objarray) {
		boolean[] array = new boolean[objarray.length];
		int p = 0;
		for (boolean b : objarray) {
			array[p++] = b;
		}
		return array;
	}
	
	public static char[] toCharArray(Character[] objarray) {
		char[] array = new char[objarray.length];
		int p = 0;
		for (char c : objarray) {
			array[p++] = c;
		}
		return array;
	}
	
	public static String charArrayToString(Character[] array) {
		StringBuilder sb = new StringBuilder();
		for (char c : array) {
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static byte[] toByteArray(short[] array) {
		byte[] narray = new byte[array.length];
		int p = 0;
		for (short e : array) {
			narray[p++] = (byte) e;
		}
		return narray;
	}
	
	public static byte[] toByteArray(int[] array) {
		byte[] narray = new byte[array.length];
		int p = 0;
		for (int e : array) {
			narray[p++] = (byte) e;
		}
		return narray;
	}
	
	public static byte[] toByteArray(long[] array) {
		byte[] narray = new byte[array.length];
		int p = 0;
		for (long e : array) {
			narray[p++] = (byte) e;
		}
		return narray;
	}
	
	public static byte[] toByteArray(float[] array) {
		byte[] narray = new byte[array.length];
		int p = 0;
		for (float e : array) {
			narray[p++] = (byte) e;
		}
		return narray;
	}
	
	public static byte[] toByteArray(double[] array) {
		byte[] narray = new byte[array.length];
		int p = 0;
		for (double e : array) {
			narray[p++] = (byte) e;
		}
		return narray;
	}
	
	public static byte[] toByteArray(char[] array) {
		byte[] narray = new byte[array.length];
		int p = 0;
		for (char e : array) {
			narray[p++] = (byte) e;
		}
		return narray;
	}
	
	public static byte[] toByteArray(boolean[] array) {
		byte[] narray = new byte[array.length];
		int p = 0;
		for (boolean e : array) {
			narray[p++] = (byte) (e ? 1 : 0);
		}
		return narray;
	}
	
	public static short[] toShortArray(byte[] array) {
		short[] narray = new short[array.length];
		int p = 0;
		for (byte e : array) {
			narray[p++] = e;
		}
		return narray;
	}
	
	public static short[] toShortArray(int[] array) {
		short[] narray = new short[array.length];
		int p = 0;
		for (int e : array) {
			narray[p++] = (short) e;
		}
		return narray;
	}
	
	public static short[] toShortArray(long[] array) {
		short[] narray = new short[array.length];
		int p = 0;
		for (long e : array) {
			narray[p++] = (short) e;
		}
		return narray;
	}
	
	public static short[] toShortArray(float[] array) {
		short[] narray = new short[array.length];
		int p = 0;
		for (float e : array) {
			narray[p++] = (short) e;
		}
		return narray;
	}
	
	public static short[] toShortArray(double[] array) {
		short[] narray = new short[array.length];
		int p = 0;
		for (double e : array) {
			narray[p++] = (short) e;
		}
		return narray;
	}
	
	public static short[] toShortArray(char[] array) {
		short[] narray = new short[array.length];
		int p = 0;
		for (char e : array) {
			narray[p++] = (short) e;
		}
		return narray;
	}
	
	public static short[] toShortArray(boolean[] array) {
		short[] narray = new short[array.length];
		int p = 0;
		for (boolean e : array) {
			narray[p++] = (short) (e ? 1 : 0);
		}
		return narray;
	}
	
	public static int[] toIntArray(byte[] array) {
		int[] narray = new int[array.length];
		int p = 0;
		for (byte e : array) {
			narray[p++] = e;
		}
		return narray;
	}
	
	public static int[] toIntArray(short[] array) {
		int[] narray = new int[array.length];
		int p = 0;
		for (short e : array) {
			narray[p++] = e;
		}
		return narray;
	}
	
	public static int[] toIntArray(long[] array) {
		int[] narray = new int[array.length];
		int p = 0;
		for (long e : array) {
			narray[p++] = (int) e;
		}
		return narray;
	}
	
	public static int[] toIntArray(float[] array) {
		int[] narray = new int[array.length];
		int p = 0;
		for (float e : array) {
			narray[p++] = (int) e;
		}
		return narray;
	}
	
	public static int[] toIntArray(double[] array) {
		int[] narray = new int[array.length];
		int p = 0;
		for (double e : array) {
			narray[p++] = (int) e;
		}
		return narray;
	}
	
	public static int[] toIntArray(char[] array) {
		int[] narray = new int[array.length];
		int p = 0;
		for (char e : array) {
			narray[p++] = e;
		}
		return narray;
	}
	
	public static int[] toIntArray(boolean[] array) {
		int[] narray = new int[array.length];
		int p = 0;
		for (boolean e : array) {
			narray[p++] = e ? 1 : 0;
		}
		return narray;
	}
	
	public static long[] toLongArray(byte[] array) {
		long[] narray = new long[array.length];
		int p = 0;
		for (byte e : array) {
			narray[p++] = e;
		}
		return narray;
	}
	
	public static long[] toLongArray(short[] array) {
		long[] narray = new long[array.length];
		int p = 0;
		for (short e : array) {
			narray[p++] = e;
		}
		return narray;
	}
	
	public static long[] toLongArray(int[] array) {
		long[] narray = new long[array.length];
		int p = 0;
		for (int e : array) {
			narray[p++] = e;
		}
		return narray;
	}
	
	public static long[] toLongArray(float[] array) {
		long[] narray = new long[array.length];
		int p = 0;
		for (float e : array) {
			narray[p++] = (long) e;
		}
		return narray;
	}
	
	public static long[] toLongArray(double[] array) {
		long[] narray = new long[array.length];
		int p = 0;
		for (double e : array) {
			narray[p++] = (long) e;
		}
		return narray;
	}
	
	public static long[] toLongArray(char[] array) {
		long[] narray = new long[array.length];
		int p = 0;
		for (char e : array) {
			narray[p++] = e;
		}
		return narray;
	}
	
	public static long[] toLongArray(boolean[] array) {
		long[] narray = new long[array.length];
		int p = 0;
		for (boolean e : array) {
			narray[p++] = e ? 1 : 0;
		}
		return narray;
	}
	
	public static float[] toFloatArray(byte[] array) {
		float[] narray = new float[array.length];
		int p = 0;
		for (byte e : array) {
			narray[p++] = (float) e;
		}
		return narray;
	}
	
	public static float[] toFloatArray(short[] array) {
		float[] narray = new float[array.length];
		int p = 0;
		for (short e : array) {
			narray[p++] = (float) e;
		}
		return narray;
	}
	
	public static float[] toFloatArray(int[] array) {
		float[] narray = new float[array.length];
		int p = 0;
		for (int e : array) {
			narray[p++] = (float) e;
		}
		return narray;
	}
	
	public static float[] toFloatArray(long[] array) {
		float[] narray = new float[array.length];
		int p = 0;
		for (long e : array) {
			narray[p++] = (float) e;
		}
		return narray;
	}
	
	public static float[] toFloatArray(double[] array) {
		float[] narray = new float[array.length];
		int p = 0;
		for (double e : array) {
			narray[p++] = (float) e;
		}
		return narray;
	}
	
	public static float[] toFloatArray(char[] array) {
		float[] narray = new float[array.length];
		int p = 0;
		for (char e : array) {
			narray[p++] = (float) e;
		}
		return narray;
	}
	
	public static float[] toFloatArray(boolean[] array) {
		float[] narray = new float[array.length];
		int p = 0;
		for (boolean e : array) {
			narray[p++] = (float) (e ? 1 : 0);
		}
		return narray;
	}
	
	public static double[] toDoubleArray(byte[] array) {
		double[] narray = new double[array.length];
		int p = 0;
		for (byte e : array) {
			narray[p++] = (double) e;
		}
		return narray;
	}
	
	public static double[] toDoubleArray(short[] array) {
		double[] narray = new double[array.length];
		int p = 0;
		for (short e : array) {
			narray[p++] = (double) e;
		}
		return narray;
	}
	
	public static double[] toDoubleArray(int[] array) {
		double[] narray = new double[array.length];
		int p = 0;
		for (int e : array) {
			narray[p++] = (double) e;
		}
		return narray;
	}
	
	public static double[] toDoubleArray(long[] array) {
		double[] narray = new double[array.length];
		int p = 0;
		for (long e : array) {
			narray[p++] = (double) e;
		}
		return narray;
	}
	
	public static double[] toDoubleArray(float[] array) {
		double[] narray = new double[array.length];
		int p = 0;
		for (float e : array) {
			narray[p++] = (double) e;
		}
		return narray;
	}
	
	public static double[] toDoubleArray(char[] array) {
		double[] narray = new double[array.length];
		int p = 0;
		for (char e : array) {
			narray[p++] = (double) e;
		}
		return narray;
	}
	
	public static double[] toDoubleArray(boolean[] array) {
		double[] narray = new double[array.length];
		int p = 0;
		for (boolean e : array) {
			narray[p++] = (double) (e ? 1 : 0);
		}
		return narray;
	}
	
	public static char[] toCharArray(byte[] array) {
		char[] narray = new char[array.length];
		int p = 0;
		for (byte e : array) {
			narray[p++] = (char) e;
		}
		return narray;
	}
	
	public static char[] toCharArray(short[] array) {
		char[] narray = new char[array.length];
		int p = 0;
		for (short e : array) {
			narray[p++] = (char) e;
		}
		return narray;
	}
	
	public static char[] toCharArray(int[] array) {
		char[] narray = new char[array.length];
		int p = 0;
		for (int e : array) {
			narray[p++] = (char) e;
		}
		return narray;
	}
	
	public static char[] toCharArray(long[] array) {
		char[] narray = new char[array.length];
		int p = 0;
		for (long e : array) {
			narray[p++] = (char) e;
		}
		return narray;
	}
	
	public static char[] toCharArray(float[] array) {
		char[] narray = new char[array.length];
		int p = 0;
		for (float e : array) {
			narray[p++] = (char) e;
		}
		return narray;
	}
	
	public static char[] toCharArray(double[] array) {
		char[] narray = new char[array.length];
		int p = 0;
		for (double e : array) {
			narray[p++] = (char) e;
		}
		return narray;
	}
	
	public static char[] toCharArray(boolean[] array) {
		char[] narray = new char[array.length];
		int p = 0;
		for (boolean e : array) {
			narray[p++] = (char) (e ? 1 : 0);
		}
		return narray;
	}
	
	public static boolean[] toBooleanArray(byte[] array) {
		boolean[] narray = new boolean[array.length];
		int p = 0;
		for (byte e : array) {
			narray[p++] = e > 0;
		}
		return narray;
	}
	
	public static boolean[] toBooleanArray(short[] array) {
		boolean[] narray = new boolean[array.length];
		int p = 0;
		for (short e : array) {
			narray[p++] = e > 0;
		}
		return narray;
	}
	
	public static boolean[] toBooleanArray(int[] array) {
		boolean[] narray = new boolean[array.length];
		int p = 0;
		for (int e : array) {
			narray[p++] = e > 0;
		}
		return narray;
	}
	
	public static boolean[] toBooleanArray(long[] array) {
		boolean[] narray = new boolean[array.length];
		int p = 0;
		for (long e : array) {
			narray[p++] = e > 0;
		}
		return narray;
	}
	
	public static boolean[] toBooleanArray(float[] array) {
		boolean[] narray = new boolean[array.length];
		int p = 0;
		for (float e : array) {
			narray[p++] = e > 0;
		}
		return narray;
	}
	
	public static boolean[] toBooleanArray(double[] array) {
		boolean[] narray = new boolean[array.length];
		int p = 0;
		for (double e : array) {
			narray[p++] = e > 0;
		}
		return narray;
	}
	
	public static boolean[] toBooleanArray(char[] array) {
		boolean[] narray = new boolean[array.length];
		int p = 0;
		for (char e : array) {
			narray[p++] = e > (char) 0;
		}
		return narray;
	}
	
	public static void store(Byte[] src, ByteBuffer dest) {
		for (byte b : src) {
			dest.put(b);
		}
	}
	
	public static void store(Byte[] src, int srcoff, int srcsize, ByteBuffer dest) {
		for (int i = srcoff; i < srcsize; i++) {
			dest.put(src[i]);
		}
	}
	
	public static void store(Short[] src, ShortBuffer dest) {
		for (short s : src) {
			dest.put(s);
		}
	}
	
	public static void store(Short[] src, int srcoff, int srcsize, ShortBuffer dest) {
		for (int i = srcoff; i < srcsize; i++) {
			dest.put(src[i]);
		}
	}
	
	public static void store(Integer[] src, IntBuffer dest) {
		for (int i : src) {
			dest.put(i);
		}
	}
	
	public static void store(Integer[] src, int srcoff, int srcsize, IntBuffer dest) {
		for (int i = srcoff; i < srcsize; i++) {
			dest.put(src[i]);
		}
	}
	
	public static void store(Long[] src, LongBuffer dest) {
		for (long l : src) {
			dest.put(l);
		}
	}
	
	public static void store(Long[] src, int srcoff, int srcsize, LongBuffer dest) {
		for (int i = srcoff; i < srcsize; i++) {
			dest.put(src[i]);
		}
	}
	
	public static void store(Float[] src, FloatBuffer dest) {
		for (float f : src) {
			dest.put(f);
		}
	}
	
	public static void store(Float[] src, int srcoff, int srcsize, FloatBuffer dest) {
		for (int i = srcoff; i < srcsize; i++) {
			dest.put(src[i]);
		}
	}
	
	public static void store(Double[] src, DoubleBuffer dest) {
		for (double d : src) {
			dest.put(d);
		}
	}
	
	public static void store(Double[] src, int srcoff, int srcsize, DoubleBuffer dest) {
		for (int i = srcoff; i < srcsize; i++) {
			dest.put(src[i]);
		}
	}
	
	public static void store(Character[] src, CharBuffer dest) {
		for (char c : src) {
			dest.put(c);
		}
	}
	
	public static void store(Character[] src, int srcoff, int srcsize, CharBuffer dest) {
		for (int i = srcoff; i < srcsize; i++) {
			dest.put(src[i]);
		}
	}
	
	public static void store(List<Byte> src, ByteBuffer dest) {
		for (byte b : src) {
			dest.put(b);
		}
	}
	
	public static void store(List<Byte> src, int srcoff, int srcsize, ByteBuffer dest) {
		for (int i = srcoff; i < srcsize; i++) {
			dest.put(src.get(i));
		}
	}
	
	public static void store(List<Short> src, ShortBuffer dest) {
		for (short s : src) {
			dest.put(s);
		}
	}
	
	public static void store(List<Short> src, int srcoff, int srcsize, ShortBuffer dest) {
		for (int i = srcoff; i < srcsize; i++) {
			dest.put(src.get(i));
		}
	}
	
	public static void store(List<Integer> src, IntBuffer dest) {
		for (int i : src) {
			dest.put(i);
		}
	}
	
	public static void store(List<Integer> src, int srcoff, int srcsize, IntBuffer dest) {
		for (int i = srcoff; i < srcsize; i++) {
			dest.put(src.get(i));
		}
	}
	
	public static void store(List<Long> src, LongBuffer dest) {
		for (long l : src) {
			dest.put(l);
		}
	}
	
	public static void store(List<Long> src, int srcoff, int srcsize, LongBuffer dest) {
		for (int i = srcoff; i < srcsize; i++) {
			dest.put(src.get(i));
		}
	}
	
	public static void store(List<Float> src, FloatBuffer dest) {
		for (float f : src) {
			dest.put(f);
		}
	}
	
	public static void store(List<Float> src, int srcoff, int srcsize, FloatBuffer dest) {
		for (int i = srcoff; i < srcsize; i++) {
			dest.put(src.get(i));
		}
	}
	
	public static void store(List<Double> src, DoubleBuffer dest) {
		for (double d : src) {
			dest.put(d);
		}
	}
	
	public static void store(List<Double> src, int srcoff, int srcsize, DoubleBuffer dest) {
		for (int i = srcoff; i < srcsize; i++) {
			dest.put(src.get(i));
		}
	}
	
	public static void store(List<Character> src, CharBuffer dest) {
		for (char c : src) {
			dest.put(c);
		}
	}
	
	public static void store(List<Character> src, int srcoff, int srcsize, CharBuffer dest) {
		for (int i = srcoff; i < srcsize; i++) {
			dest.put(src.get(i));
		}
	}
	
	public static void store(Set<Byte> src, ByteBuffer dest) {
		for (byte b : src) {
			dest.put(b);
		}
	}
	
	public static void store(Set<Short> src, ShortBuffer dest) {
		for (short s : src) {
			dest.put(s);
		}
	}
	
	public static void store(Set<Integer> src, IntBuffer dest) {
		for (int i : src) {
			dest.put(i);
		}
	}
	
	public static void store(Set<Long> src, LongBuffer dest) {
		for (long l : src) {
			dest.put(l);
		}
	}
	
	public static void store(Set<Float> src, FloatBuffer dest) {
		for (float f : src) {
			dest.put(f);
		}
	}
	
	public static void store(Set<Double> src, DoubleBuffer dest) {
		for (double d : src) {
			dest.put(d);
		}
	}
	
	public static void store(Set<Character> src, CharBuffer dest) {
		for (char c : src) {
			dest.put(c);
		}
	}
	
	public static void load(ByteBuffer src, Byte[] dest) {
		for (int i = 0; i < dest.length; i++) {
			if (!src.hasRemaining()) {
				break;
			}
			dest[i] = src.get();
		}
	}
	
	public static void load(ShortBuffer src, Short[] dest) {
		for (int i = 0; i < dest.length; i++) {
			if (!src.hasRemaining()) {
				break;
			}
			dest[i] = src.get();
		}
	}
	
	public static void load(IntBuffer src, Integer[] dest) {
		for (int i = 0; i < dest.length; i++) {
			if (!src.hasRemaining()) {
				break;
			}
			dest[i] = src.get();
		}
	}
	
	public static void load(LongBuffer src, Long[] dest) {
		for (int i = 0; i < dest.length; i++) {
			if (!src.hasRemaining()) {
				break;
			}
			dest[i] = src.get();
		}
	}
	
	public static void load(FloatBuffer src, Float[] dest) {
		for (int i = 0; i < dest.length; i++) {
			if (!src.hasRemaining()) {
				break;
			}
			dest[i] = src.get();
		}
	}
	
	public static void load(DoubleBuffer src, Double[] dest) {
		for (int i = 0; i < dest.length; i++) {
			if (!src.hasRemaining()) {
				break;
			}
			dest[i] = src.get();
		}
	}
	
	public static void load(CharBuffer src, Character[] dest) {
		for (int i = 0; i < dest.length; i++) {
			if (!src.hasRemaining()) {
				break;
			}
			dest[i] = src.get();
		}
	}
	
	public static void load(ByteBuffer src, List<Byte> dest) {
		while (src.hasRemaining()) {
			dest.add(src.get());
		}
	}
	
	public static void load(ShortBuffer src, List<Short> dest) {
		while (src.hasRemaining()) {
			dest.add(src.get());
		}
	}
	
	public static void load(IntBuffer src, List<Integer> dest) {
		while (src.hasRemaining()) {
			dest.add(src.get());
		}
	}
	
	public static void load(LongBuffer src, List<Long> dest) {
		while (src.hasRemaining()) {
			dest.add(src.get());
		}
	}
	
	public static void load(FloatBuffer src, List<Float> dest) {
		while (src.hasRemaining()) {
			dest.add(src.get());
		}
	}
	
	public static void load(DoubleBuffer src, List<Double> dest) {
		while (src.hasRemaining()) {
			dest.add(src.get());
		}
	}
	
	public static void load(CharBuffer src, List<Character> dest) {
		while (src.hasRemaining()) {
			dest.add(src.get());
		}
	}
	
	public static void load(ByteBuffer src, Set<Byte> dest) {
		while (src.hasRemaining()) {
			dest.add(src.get());
		}
	}
	
	public static void load(ShortBuffer src, Set<Short> dest) {
		while (src.hasRemaining()) {
			dest.add(src.get());
		}
	}
	
	public static void load(IntBuffer src, Set<Integer> dest) {
		while (src.hasRemaining()) {
			dest.add(src.get());
		}
	}
	
	public static void load(LongBuffer src, Set<Long> dest) {
		while (src.hasRemaining()) {
			dest.add(src.get());
		}
	}
	
	public static void load(FloatBuffer src, Set<Float> dest) {
		while (src.hasRemaining()) {
			dest.add(src.get());
		}
	}
	
	public static void load(DoubleBuffer src, Set<Double> dest) {
		while (src.hasRemaining()) {
			dest.add(src.get());
		}
	}
	
	public static void load(CharBuffer src, Set<Character> dest) {
		while (src.hasRemaining()) {
			dest.add(src.get());
		}
	}
	
	public static <T> int totalSizeOf(T[][] mdarray) {
		int size = 0;
		for (T[] array : mdarray) {
			size += array.length;
		}
		return size;
	}
	
	public static <T> T getNonNull(T[] array, int order) {
		T t = null;
		for (T e : array) {
			if (order == ORDER_FIRST && t == null && e != null) {
				t = e;
			} else if (order == ORDER_LAST && e != null) {
				t = e;
			}
		}
		return t;
	}
	
	public static <T> T getNonNull(T[] array) {
		for (T t : array) {
			if (t != null) {
				return t;
			}
		}
		return null;
	}
	
	public static <T> T[] getAllNonNull(T[] array) {
		T[] t = Arrays.copyOf(array, array.length);
		int p = 0;
		for (T e : array) {
			if (e != null) {
				t[p++] = e;
			}
		}
		return Arrays.copyOf(t, p);
	}
	
	public static <T> T getNonNull(List<T> list, int order) {
		T t = null;
		for (T e : list) {
			if (order == ORDER_FIRST && t == null && e != null) {
				t = e;
			} else if (order == ORDER_LAST && e != null) {
				t = e;
			}
		}
		return t;
	}
	
	public static <T> T getNonNull(List<T> list) {
		for (T t : list) {
			if (t != null) {
				return t;
			}
		}
		return null;
	}
	
	public static <T> List<T> getAllNonNull(List<T> list) {
		List<T> l = new ArrayList<>();
		for (T t : list) {
			if (t != null) {
				l.add(t);
			}
		}
		return l;
	}
	
	public static <T> T getNonNull(Set<T> set, int order) {
		T t = null;
		for (T e : set) {
			if (order == ORDER_FIRST && t == null && e != null) {
				t = e;
			} else if (order == ORDER_LAST && e != null) {
				t = e;
			}
		}
		return t;
	}
	
	public static <T> List<T> getAllNonNull(Set<T> set) {
		List<T> l = new ArrayList<>();
		for (T t : set) {
			if (t != null) {
				l.add(t);
			}
		}
		return l;
	}
	
	public static <T> T getNonNull(Set<T> set) {
		for (T t : set) {
			if (t != null) {
				return t;
			}
		}
		return null;
	}
	
	public static <T> String toString(T[] array) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (T t : array) {
			if (sb.length() > 1) {
				sb.append(", ");
			}
			sb.append(t);
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static String toString(List<?> list) {
		return toString(listToArray(list));
	}
	
	public static String toString(Set<?> set) {
		return toString(setToArray(set));
	}
}

