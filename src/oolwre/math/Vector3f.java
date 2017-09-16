package oolwre.math;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.FloatBuffer;

public class Vector3f {
	
	/**Values*/
	public float x, y, z;
	
	/**Constructs a {@link Vector3f} with no specified values.
	 */
	public Vector3f() {}
	
	/**Constructs a {@link Vector3f} with the specified parameters.
	 * 
	 * @param x - The {@link #x} value
	 * @param y - The {@link #y} value
	 * @param z - The {@link #z} value
	 */
	public Vector3f(float x, float y, float z) {
		this.set(x, y, z);
	}
	
	/**Sets all the values from the {@link Vector3f}.
	 * 
	 * @param x - The {@link #x} value
	 * @param y - The {@link #y} value
	 * @param z - The {@link #z} value
	 */
	public Vector3f set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}
	
	/**Adds <code>this</code> to <code>other</code> and store
	 * the result in <code>this</code>.<br>
	 * <br>
	 * {@link #add(Vector3f, Vector3f, Vector3f) add(this, other, this);}
	 * 
	 * @param other - The {@link Vector3f} to be added to <code>this</code>
	 * 
	 * @return <code>this</code>
	 */
	public Vector3f add(Vector3f other) {
		return add(this, other, this);
	}
	
	/**Adds <code>this</code> to <code>other</code> and store
	 * the result in <code>dest</code>.<br>
	 * <br>
	 * {@link #add(Vector3f, Vector3f, Vector3f) add(this, other, dest);}
	 * 
	 * @param other - The {@link Vector3f} to be added to <code>this</code>
	 * @param dest - Where to store the result, or <code>null</code> if
	 * a new {@link Vector3f} is to be created
	 * 
	 * @return The result of the addition
	 */
	public Vector3f add(Vector3f other, Vector3f dest) {
		return add(this, other, dest);
	}

	/**Subtracts <code>this</code> by <code>other</code> and store
	 * the result in <code>this</code>.<br>
	 * <br>
	 * {@link #sub(Vector3f, Vector3f, Vector3f) sub(this, other, this);}
	 * 
	 * @param other - The {@link Vector3f} to subtract from <code>this</code>
	 * 
	 * @return <code>this</code>
	 */
	public Vector3f sub(Vector3f other) {
		return sub(this, other, this);
	}

	/**Subtracts <code>this</code> by <code>other</code> and store
	 * the result in <code>dest</code>.<br>
	 * <br>
	 * {@link #sub(Vector3f, Vector3f, Vector3f) sub(this, other, dest);}
	 * 
	 * @param other - The {@link Vector3f} to subtract from <code>this</code>
	 * @param dest - Where to store the result, or <code>null</code> if
	 * a new {@link Vector3f} is to be created
	 * 
	 * @return The result of the subtraction
	 */
	public Vector3f sub(Vector3f other, Vector3f dest) {
		return sub(this, other, dest);
	}

	/**Multiplies <code>this</code> by <code>other</code> and store
	 * the result in <code>this</code>.<br>
	 * <br>
	 * {@link #mul(Vector3f, Vector3f, Vector3f) mul(this, other, this);}
	 * 
	 * @param other - The {@link Vector3f} to multiply <code>this</code>
	 * 
	 * @return <code>this</code>
	 */
	public Vector3f mul(Vector3f other) {
		return mul(this, other, this);
	}

	/**Multiplies <code>this</code> by <code>other</code> and store
	 * the result in <code>dest</code>.<br>
	 * <br>
	 * {@link #mul(Vector3f, Vector3f, Vector3f) mul(this, other, dest);}
	 * 
	 * @param other - The {@link Vector3f} to multiply <code>this</code>
	 * @param dest - Where to store the result, or <code>null</code> if
	 * a new {@link Vector3f} is to be created
	 * 
	 * @return The result of the multiplication
	 */
	public Vector3f mul(Vector3f other, Vector3f dest) {
		return mul(this, other, dest);
	}
	
	/**Divides <code>this</code> by <code>other</code> and store
	 * the result in <code>this</code>.<br>
	 * <br>
	 * {@link #div(Vector3f, Vector3f, Vector3f) div(this, other, this);}
	 * 
	 * @param other - The {@link Vector3f} to divide <code>this</code>
	 * 
	 * @return <code>this</code>
	 */
	public Vector3f div(Vector3f other) {
		return div(this, other, this);
	}

	/**Divides <code>this</code> by <code>other</code> and store
	 * the result in <code>dest</code>.<br>
	 * <br>
	 * {@link #div(Vector3f, Vector3f, Vector3f) div(this, other, dest);}
	 * 
	 * @param other - The {@link Vector3f} to divide <code>this</code>
	 * @param dest - Where to store the result, or <code>null</code> if
	 * a new {@link Vector3f} is to be created
	 * 
	 * @return The result of the division
	 */
	public Vector3f div(Vector3f other, Vector3f dest) {
		return div(this, other, dest);
	}
	
	/**Loads the values from <code>other</code>.
	 * 
	 * @param other - The {@link Vector3f}
	 * 
	 * @return <code>this</code>
	 */
	public Vector3f load(Vector3f other) {
		this.x = other.x;
		this.y = other.y;
		this.z = other.z;
		return this;
	}
	
	/**Loads three floats from <code>buffer</code>.
	 * 
	 * @param buffer - The {@link FloatBuffer}
	 * 
	 * @return <code>this</code>
	 * 
	 * @throws BufferUnderflowException If there was
	 * less than three available float
	 */
	public Vector3f load(FloatBuffer buffer) {
		this.x = buffer.get();
		this.y = buffer.get();
		this.z = buffer.get();
		return this;
	}
	
	/**Stores three floats to <code>buffer</code>.
	 * 
	 * @param buffer - The {@link FloatBuffer}
	 * 
	 * @return <code>this</code>
	 * 
	 * @throws BufferOverflowException If there was
	 * less than three remaining storage
	 */
	public Vector3f store(FloatBuffer buffer) {
		buffer.put(this.x);
		buffer.put(this.y);
		buffer.put(this.z);
		return this;
	}
	
	/**Calculates the length of the {@link Vector3f}.
	 * 
	 * @return The length
	 */
	public float length() {
		return (float) Math.sqrt((this.x * this.x) + (this.y * this.y) + (this.z * this.z));
	}
	
	/**Adds <code>left</code> and <code>right</code> and
	 * store the result in <code>dest</code>.
	 * 
	 * @param left - The left {@link Vector3f} of the addition
	 * @param right - The right {@link Vector3f} of the addition
	 * @param dest - Where to store the result, or <code>null</code>
	 * if a new {@link Vector3f} is to be created
	 * 
	 * @return The result of the addition
	 */
	public static Vector3f add(Vector3f left, Vector3f right, Vector3f dest) {
		if (dest == null) {
			dest = new Vector3f();
		}
		dest.x = left.x + right.x;
		dest.y = left.y + right.y;
		dest.z = left.z + right.z;
		return dest;
	}
	
	/**Subtracts <code>left</code> and <code>right</code> and
	 * store the result in <code>dest</code>.
	 * 
	 * @param left - The left {@link Vector3f} of the subtraction
	 * @param right - The right {@link Vector3f} of the subtraction
	 * @param dest - Where to store the result, or <code>null</code>
	 * if a new {@link Vector3f} is to be created
	 * 
	 * @return The result of the subtraction
	 */
	public static Vector3f sub(Vector3f left, Vector3f right, Vector3f dest) {
		if (dest == null) {
			dest = new Vector3f();
		}
		dest.x = left.x - right.x;
		dest.y = left.y - right.y;
		dest.z = left.z - right.z;
		return dest;
	}
	
	/**Multiply <code>left</code> by <code>right</code> and
	 * store the result in <code>dest</code>.
	 * 
	 * @param left - The left {@link Vector3f} of the multiplication
	 * @param right - The right {@link Vector3f} of the multiplication
	 * @param dest - Where to store the result, or <code>null</code>
	 * if a new {@link Vector3f} is to be created
	 * 
	 * @return The result of the multiplication
	 */
	public static Vector3f mul(Vector3f left, Vector3f right, Vector3f dest) {
		if (dest == null) {
			dest = new Vector3f();
		}
		dest.x = left.x * right.x;
		dest.y = left.y * right.y;
		dest.z = left.z * right.z;
		return dest;
	}
	
	/**Divides <code>left</code> by <code>right</code> and
	 * store the result in <code>dest</code>.
	 * 
	 * @param left - The left {@link Vector3f} of the division
	 * @param right - The right {@link Vector3f} of the division
	 * @param dest - Where to store the result, or <code>null</code>
	 * if a new {@link Vector3f} is to be created
	 * 
	 * @return The result of the division
	 */
	public static Vector3f div(Vector3f left, Vector3f right, Vector3f dest) {
		if (dest == null) {
			dest = new Vector3f();
		}
		dest.x = left.x / right.x;
		dest.y = left.y / right.y;
		dest.z = left.z / right.z;
		return dest;
	}
}
