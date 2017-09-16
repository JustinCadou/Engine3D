package oolwre.math;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.FloatBuffer;

public class Vector2f {
	
	/**Values*/
	public float x, y;
	
	/**Constructs a {@link Vector2f} with no specified values.
	 */
	public Vector2f() {}
	
	/**Constructs a {@link Vector2f} with the specified parameters.
	 * 
	 * @param x - The {@link #x} value
	 * @param y - The {@link #y} value
	 */
	public Vector2f(float x, float y) {
		this.set(x, y);
	}
	
	/**Sets all the values from the {@link Vector2f}.
	 * 
	 * @param x - The {@link #x} value
	 * @param y - The {@link #y} value
	 */
	public Vector2f set(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	/**Adds <code>this</code> to <code>other</code> and store
	 * the result in <code>this</code>.<br>
	 * <br>
	 * {@link #add(Vector2f, Vector2f, Vector2f) add(this, other, this);}
	 * 
	 * @param other - The {@link Vector2f} to be added to <code>this</code>
	 * 
	 * @return <code>this</code>
	 */
	public Vector2f add(Vector2f other) {
		return add(this, other, this);
	}
	
	/**Adds <code>this</code> to <code>other</code> and store
	 * the result in <code>dest</code>.<br>
	 * <br>
	 * {@link #add(Vector2f, Vector2f, Vector2f) add(this, other, dest);}
	 * 
	 * @param other - The {@link Vector2f} to be added to <code>this</code>
	 * @param dest - Where to store the result, or <code>null</code> if
	 * a new {@link Vector2f} is to be created
	 * 
	 * @return The result of the addition
	 */
	public Vector2f add(Vector2f other, Vector2f dest) {
		return add(this, other, dest);
	}

	/**Subtracts <code>this</code> by <code>other</code> and store
	 * the result in <code>this</code>.<br>
	 * <br>
	 * {@link #sub(Vector2f, Vector2f, Vector2f) sub(this, other, this);}
	 * 
	 * @param other - The {@link Vector2f} to subtract from <code>this</code>
	 * 
	 * @return <code>this</code>
	 */
	public Vector2f sub(Vector2f other) {
		return sub(this, other, this);
	}

	/**Subtracts <code>this</code> by <code>other</code> and store
	 * the result in <code>dest</code>.<br>
	 * <br>
	 * {@link #sub(Vector2f, Vector2f, Vector2f) sub(this, other, dest);}
	 * 
	 * @param other - The {@link Vector2f} to subtract from <code>this</code>
	 * @param dest - Where to store the result, or <code>null</code> if
	 * a new {@link Vector2f} is to be created
	 * 
	 * @return The result of the subtraction
	 */
	public Vector2f sub(Vector2f other, Vector2f dest) {
		return sub(this, other, dest);
	}

	/**Multiplies <code>this</code> by <code>other</code> and store
	 * the result in <code>this</code>.<br>
	 * <br>
	 * {@link #mul(Vector2f, Vector2f, Vector2f) mul(this, other, this);}
	 * 
	 * @param other - The {@link Vector2f} to multiply <code>this</code>
	 * 
	 * @return <code>this</code>
	 */
	public Vector2f mul(Vector2f other) {
		return mul(this, other, this);
	}

	/**Multiplies <code>this</code> by <code>other</code> and store
	 * the result in <code>dest</code>.<br>
	 * <br>
	 * {@link #mul(Vector2f, Vector2f, Vector2f) mul(this, other, dest);}
	 * 
	 * @param other - The {@link Vector2f} to multiply <code>this</code>
	 * @param dest - Where to store the result, or <code>null</code> if
	 * a new {@link Vector2f} is to be created
	 * 
	 * @return The result of the multiplication
	 */
	public Vector2f mul(Vector2f other, Vector2f dest) {
		return mul(this, other, dest);
	}
	
	/**Divides <code>this</code> by <code>other</code> and store
	 * the result in <code>this</code>.<br>
	 * <br>
	 * {@link #div(Vector2f, Vector2f, Vector2f) div(this, other, this);}
	 * 
	 * @param other - The {@link Vector2f} to divide <code>this</code>
	 * 
	 * @return <code>this</code>
	 */
	public Vector2f div(Vector2f other) {
		return div(this, other, this);
	}

	/**Divides <code>this</code> by <code>other</code> and store
	 * the result in <code>dest</code>.<br>
	 * <br>
	 * {@link #div(Vector2f, Vector2f, Vector2f) div(this, other, dest);}
	 * 
	 * @param other - The {@link Vector2f} to divide <code>this</code>
	 * @param dest - Where to store the result, or <code>null</code> if
	 * a new {@link Vector2f} is to be created
	 * 
	 * @return The result of the division
	 */
	public Vector2f div(Vector2f other, Vector2f dest) {
		return div(this, other, dest);
	}
	
	/**Loads the values from <code>other</code>.
	 * 
	 * @param other - The {@link Vector2f}
	 * 
	 * @return <code>this</code>
	 */
	public Vector2f load(Vector2f other) {
		this.x = other.x;
		this.y = other.y;
		return this;
	}
	
	/**Loads two floats from <code>buffer</code>.
	 * 
	 * @param buffer - The {@link FloatBuffer}
	 * 
	 * @return <code>this</code>
	 * 
	 * @throws BufferUnderflowException If there was
	 * less than three available float
	 */
	public Vector2f load(FloatBuffer buffer) {
		this.x = buffer.get();
		this.y = buffer.get();
		return this;
	}
	
	/**Stores two floats to <code>buffer</code>.
	 * 
	 * @param buffer - The {@link FloatBuffer}
	 * 
	 * @return <code>this</code> 
	 * 
	 * @throws BufferOverflowException If there was
	 * less than three remaining storage
	 */
	public Vector2f store(FloatBuffer buffer) {
		buffer.put(this.x);
		buffer.put(this.y);
		return this;
	}
	
	/**Calculates the length of the {@link Vector2f}.
	 * 
	 * @return The length
	 */
	public float length() {
		return (float) Math.sqrt((this.x * this.x) + (this.y * this.y));
	}
	
	/**Adds <code>left</code> and <code>right</code> and
	 * store the result in <code>dest</code>.
	 * 
	 * @param left - The left {@link Vector2f} of the addition
	 * @param right - The right {@link Vector2f} of the addition
	 * @param dest - Where to store the result, or <code>null</code>
	 * if a new {@link Vector2f} is to be created
	 * 
	 * @return The result of the addition
	 */
	public static Vector2f add(Vector2f left, Vector2f right, Vector2f dest) {
		if (dest == null) {
			dest = new Vector2f();
		}
		dest.x = left.x + right.x;
		dest.y = left.y + right.y;
		return dest;
	}
	
	/**Subtracts <code>left</code> and <code>right</code> and
	 * store the result in <code>dest</code>.
	 * 
	 * @param left - The left {@link Vector2f} of the subtraction
	 * @param right - The right {@link Vector2f} of the subtraction
	 * @param dest - Where to store the result, or <code>null</code>
	 * if a new {@link Vector2f} is to be created
	 * 
	 * @return The result of the subtraction
	 */
	public static Vector2f sub(Vector2f left, Vector2f right, Vector2f dest) {
		if (dest == null) {
			dest = new Vector2f();
		}
		dest.x = left.x - right.x;
		dest.y = left.y - right.y;
		return dest;
	}
	
	/**Multiply <code>left</code> by <code>right</code> and
	 * store the result in <code>dest</code>.
	 * 
	 * @param left - The left {@link Vector2f} of the multiplication
	 * @param right - The right {@link Vector2f} of the multiplication
	 * @param dest - Where to store the result, or <code>null</code>
	 * if a new {@link Vector2f} is to be created
	 * 
	 * @return The result of the multiplication
	 */
	public static Vector2f mul(Vector2f left, Vector2f right, Vector2f dest) {
		if (dest == null) {
			dest = new Vector2f();
		}
		dest.x = left.x * right.x;
		dest.y = left.y * right.y;
		return dest;
	}
	
	/**Divides <code>left</code> by <code>right</code> and
	 * store the result in <code>dest</code>.
	 * 
	 * @param left - The left {@link Vector2f} of the division
	 * @param right - The right {@link Vector2f} of the division
	 * @param dest - Where to store the result, or <code>null</code>
	 * if a new {@link Vector2f} is to be created
	 * 
	 * @return The result of the division
	 */
	public static Vector2f div(Vector2f left, Vector2f right, Vector2f dest) {
		if (dest == null) {
			dest = new Vector2f();
		}
		dest.x = left.x / right.x;
		dest.y = left.y / right.y;
		return dest;
	}
}
