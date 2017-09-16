package oolwre.math;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.FloatBuffer;

public class Vector4f {
	
	/**Values*/
	public float x, y, z, w;
	
	/**Constructs a {@link Vector4f} with no specified values.
	 */
	public Vector4f() {}
	
	/**Constructs a {@link Vector4f} with the specified parameters.
	 * 
	 * @param x - The {@link #x} value
	 * @param y - The {@link #y} value
	 * @param z - The {@link #z} value
	 * @param w - The {@link #w} value
	 */
	public Vector4f(float x, float y, float z, float w) {
		this.set(x, y, z, w);
	}
	
	/**Sets all the values from the {@link Vector4f}.
	 * 
	 * @param x - The {@link #x} value
	 * @param y - The {@link #y} value
	 * @param z - The {@link #z} value
	 * @param w - The {@link #w} value
	 */
	public Vector4f set(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		return this;
	}
	
	/**Adds <code>this</code> to <code>other</code> and store
	 * the result in <code>this</code>.<br>
	 * <br>
	 * {@link #add(Vector4f, Vector4f, Vector4f) add(this, other, this);}
	 * 
	 * @param other - The {@link Vector4f} to be added to <code>this</code>
	 * 
	 * @return <code>this</code>
	 */
	public Vector4f add(Vector4f other) {
		return add(this, other, this);
	}
	
	/**Adds <code>this</code> to <code>other</code> and store
	 * the result in <code>dest</code>.<br>
	 * <br>
	 * {@link #add(Vector4f, Vector4f, Vector4f) add(this, other, dest);}
	 * 
	 * @param other - The {@link Vector4f} to be added to <code>this</code>
	 * @param dest - Where to store the result, or <code>null</code> if
	 * a new {@link Vector4f} is to be created
	 * 
	 * @return The result of the addition
	 */
	public Vector4f add(Vector4f other, Vector4f dest) {
		return add(this, other, dest);
	}

	/**Subtracts <code>this</code> by <code>other</code> and store
	 * the result in <code>this</code>.<br>
	 * <br>
	 * {@link #sub(Vector4f, Vector4f, Vector4f) sub(this, other, this);}
	 * 
	 * @param other - The {@link Vector4f} to subtract from <code>this</code>
	 * 
	 * @return <code>this</code>
	 */
	public Vector4f sub(Vector4f other) {
		return sub(this, other, this);
	}

	/**Subtracts <code>this</code> by <code>other</code> and store
	 * the result in <code>dest</code>.<br>
	 * <br>
	 * {@link #sub(Vector4f, Vector4f, Vector4f) sub(this, other, dest);}
	 * 
	 * @param other - The {@link Vector4f} to subtract from <code>this</code>
	 * @param dest - Where to store the result, or <code>null</code> if
	 * a new {@link Vector4f} is to be created
	 * 
	 * @return The result of the subtraction
	 */
	public Vector4f sub(Vector4f other, Vector4f dest) {
		return sub(this, other, dest);
	}

	/**Multiplies <code>this</code> by <code>other</code> and store
	 * the result in <code>this</code>.<br>
	 * <br>
	 * {@link #mul(Vector4f, Vector4f, Vector4f) mul(this, other, this);}
	 * 
	 * @param other - The {@link Vector4f} to multiply <code>this</code>
	 * 
	 * @return <code>this</code>
	 */
	public Vector4f mul(Vector4f other) {
		return mul(this, other, this);
	}

	/**Multiplies <code>this</code> by <code>other</code> and store
	 * the result in <code>dest</code>.<br>
	 * <br>
	 * {@link #mul(Vector4f, Vector4f, Vector4f) mul(this, other, dest);}
	 * 
	 * @param other - The {@link Vector4f} to multiply <code>this</code>
	 * @param dest - Where to store the result, or <code>null</code> if
	 * a new {@link Vector4f} is to be created
	 * 
	 * @return The result of the multiplication
	 */
	public Vector4f mul(Vector4f other, Vector4f dest) {
		return mul(this, other, dest);
	}
	
	/**Divides <code>this</code> by <code>other</code> and store
	 * the result in <code>this</code>.<br>
	 * <br>
	 * {@link #div(Vector4f, Vector4f, Vector4f) div(this, other, this);}
	 * 
	 * @param other - The {@link Vector4f} to divide <code>this</code>
	 * 
	 * @return <code>this</code>
	 */
	public Vector4f div(Vector4f other) {
		return div(this, other, this);
	}

	/**Divides <code>this</code> by <code>other</code> and store
	 * the result in <code>dest</code>.<br>
	 * <br>
	 * {@link #div(Vector4f, Vector4f, Vector4f) div(this, other, dest);}
	 * 
	 * @param other - The {@link Vector4f} to divide <code>this</code>
	 * @param dest - Where to store the result, or <code>null</code> if
	 * a new {@link Vector4f} is to be created
	 * 
	 * @return The result of the division
	 */
	public Vector4f div(Vector4f other, Vector4f dest) {
		return div(this, other, dest);
	}
	
	/**Loads the values from <code>other</code>.
	 * 
	 * @param other - The {@link Vector4f}
	 * 
	 * @return <code>this</code>
	 */
	public Vector4f load(Vector4f other) {
		this.x = other.x;
		this.y = other.y;
		this.z = other.z;
		this.w = other.w;
		return this;
	}
	
	/**Loads four floats from <code>buffer</code>.
	 * 
	 * @param buffer - The {@link FloatBuffer}
	 * 
	 * @return <code>this</code>
	 * 
	 * @throws BufferUnderflowException If there was
	 * less than three available float
	 */
	public Vector4f load(FloatBuffer buffer) {
		this.x = buffer.get();
		this.y = buffer.get();
		this.z = buffer.get();
		this.w = buffer.get();
		return this;
	}
	
	/**Stores four floats to <code>buffer</code>.
	 * 
	 * @param buffer - The {@link FloatBuffer}
	 * 
	 * @return <code>this</code>
	 * 
	 * @throws BufferOverflowException If there was
	 * less than three remaining storage
	 */
	public Vector4f store(FloatBuffer buffer) {
		buffer.put(this.x);
		buffer.put(this.y);
		buffer.put(this.z);
		buffer.put(this.w);
		return this;
	}
	
	/**Calculates the length of the {@link Vector4f}.
	 * 
	 * @return The length
	 */
	public float length() {
		return (float) Math.sqrt((this.x * this.x) + (this.y * this.y) + (this.z * this.z) + (this.w * this.w));
	}
	
	/**Adds <code>left</code> and <code>right</code> and
	 * store the result in <code>dest</code>.
	 * 
	 * @param left - The left {@link Vector4f} of the addition
	 * @param right - The right {@link Vector4f} of the addition
	 * @param dest - Where to store the result, or <code>null</code>
	 * if a new {@link Vector4f} is to be created
	 * 
	 * @return The result of the addition
	 */
	public static Vector4f add(Vector4f left, Vector4f right, Vector4f dest) {
		if (dest == null) {
			dest = new Vector4f();
		}
		dest.x = left.x + right.x;
		dest.y = left.y + right.y;
		dest.z = left.z + right.z;
		dest.w = left.w + right.w;
		return dest;
	}
	
	/**Subtracts <code>left</code> and <code>right</code> and
	 * store the result in <code>dest</code>.
	 * 
	 * @param left - The left {@link Vector4f} of the subtraction
	 * @param right - The right {@link Vector4f} of the subtraction
	 * @param dest - Where to store the result, or <code>null</code>
	 * if a new {@link Vector4f} is to be created
	 * 
	 * @return The result of the subtraction
	 */
	public static Vector4f sub(Vector4f left, Vector4f right, Vector4f dest) {
		if (dest == null) {
			dest = new Vector4f();
		}
		dest.x = left.x - right.x;
		dest.y = left.y - right.y;
		dest.z = left.z - right.z;
		dest.w = left.w - right.w;
		return dest;
	}
	
	/**Multiply <code>left</code> by <code>right</code> and
	 * store the result in <code>dest</code>.
	 * 
	 * @param left - The left {@link Vector4f} of the multiplication
	 * @param right - The right {@link Vector4f} of the multiplication
	 * @param dest - Where to store the result, or <code>null</code>
	 * if a new {@link Vector4f} is to be created
	 * 
	 * @return The result of the multiplication
	 */
	public static Vector4f mul(Vector4f left, Vector4f right, Vector4f dest) {
		if (dest == null) {
			dest = new Vector4f();
		}
		dest.x = left.x * right.x;
		dest.y = left.y * right.y;
		dest.z = left.z * right.z;
		dest.w = left.w * right.w;
		return dest;
	}
	
	/**Divides <code>left</code> by <code>right</code> and
	 * store the result in <code>dest</code>.
	 * 
	 * @param left - The left {@link Vector4f} of the division
	 * @param right - The right {@link Vector4f} of the division
	 * @param dest - Where to store the result, or <code>null</code>
	 * if a new {@link Vector4f} is to be created
	 * 
	 * @return The result of the division
	 */
	public static Vector4f div(Vector4f left, Vector4f right, Vector4f dest) {
		if (dest == null) {
			dest = new Vector4f();
		}
		dest.x = left.x / right.x;
		dest.y = left.y / right.y;
		dest.z = left.z / right.z;
		dest.w = left.w / right.w;
		return dest;
	}
}
