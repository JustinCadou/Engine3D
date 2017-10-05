/*Copyright (c) 2017 Fantastic Fantasy All rights reserved.
 *
 * Permission to use, copy, modify and/or redistribute in source or binary form
 * is hereby granted, free of charge, subject to the following conditions:
 *
 * - Redistribution of source code shall include the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *
 * - Redistribution in binary form shall include the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 *
 * - Neither the name Object Oriented Lightweight Render Engine nor the names
 *  of its contributors may be used to endorse or promote products derived
 *  from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package oolwre.math;

import java.io.Serializable;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.FloatBuffer;
import oolwre.OOLWRE;

/**A <code>Vector2f</code> represents a 2D vector of floats.
 */
public class Vector2f implements Serializable {
	
	private static final long serialVersionUID = OOLWRE.CURRENT_SERIAL_VERSION_UID;
	
	/**Values*/
	public float x, y;
	
	/**Constructs a {@link Vector2f} with no specified values.
	 */
	public Vector2f() {}
	
	/**Constructs a {@link Vector2f} with the specified parameters.
	 * 
	 * @param x The {@link #x} value
	 * @param y The {@link #y} value
	 */
	public Vector2f(float x, float y) {
		this.set(x, y);
	}
	
	/**Sets all the values from the {@link Vector2f}.
	 * 
	 * @param x The {@link #x} value
	 * @param y The {@link #y} value
	 * 
	 * @return <code>this</code>
	 */
	public final Vector2f set(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	/**Sets all the values from the {@link Vector2f} to 0.
	 * 
	 * @return <code>this</code>
	 */
	public Vector2f reset() {
		return this.set(0, 0);
	}
	
	/**Adds <code>this</code> to <code>other</code> and store
	 * the result to a newly created {@link Vector2f}.<br>
	 * <br>
	 * {@link #add(Vector2f, Vector2f, Vector2f) add(this, other, null);}
	 * 
	 * @param other The {@link Vector2f} to be added to <code>this</code>
	 * 
	 * @return The result of the addition
	 */
	public Vector2f add(Vector2f other) {
		return add(this, other, null);
	}
	
	/**Adds <code>this</code> to <code>other</code> and store
	 * the result in <code>dest</code>.<br>
	 * <br>
	 * {@link #add(Vector2f, Vector2f, Vector2f) add(this, other, dest);}
	 * 
	 * @param other The {@link Vector2f} to be added to <code>this</code>
	 * @param dest Where to store the result, or <code>null</code> if
	 * a new {@link Vector2f} is to be created
	 * 
	 * @return The result of the addition
	 */
	public Vector2f add(Vector2f other, Vector2f dest) {
		return add(this, other, dest);
	}

	/**Subtracts <code>this</code> by <code>other</code> and store
	 * the result to a newly created {@link Vector2f}.<br>
	 * <br>
	 * {@link #sub(Vector2f, Vector2f, Vector2f) sub(this, other, null);}
	 * 
	 * @param other The {@link Vector2f} to subtract from <code>this</code>
	 * 
	 * @return The result of the subtraction
	 */
	public Vector2f sub(Vector2f other) {
		return sub(this, other, null);
	}

	/**Subtracts <code>this</code> by <code>other</code> and store
	 * the result in <code>dest</code>.<br>
	 * <br>
	 * {@link #sub(Vector2f, Vector2f, Vector2f) sub(this, other, dest);}
	 * 
	 * @param other The {@link Vector2f} to subtract from <code>this</code>
	 * @param dest Where to store the result, or <code>null</code> if
	 * a new {@link Vector2f} is to be created
	 * 
	 * @return The result of the subtraction
	 */
	public Vector2f sub(Vector2f other, Vector2f dest) {
		return sub(this, other, dest);
	}

	/**Multiplies <code>this</code> by <code>other</code> and store
	 * the result to a newly created {@link Vector2f}.<br>
	 * <br>
	 * {@link #mul(Vector2f, Vector2f, Vector2f) mul(this, other, null);}
	 * 
	 * @param other The {@link Vector2f} to multiply <code>this</code>
	 * 
	 * @return The result of the multiplication
	 */
	public Vector2f mul(Vector2f other) {
		return mul(this, other, null);
	}

	/**Multiplies <code>this</code> by <code>other</code> and store
	 * the result in <code>dest</code>.<br>
	 * <br>
	 * {@link #mul(Vector2f, Vector2f, Vector2f) mul(this, other, dest);}
	 * 
	 * @param other The {@link Vector2f} to multiply <code>this</code>
	 * @param dest Where to store the result, or <code>null</code> if
	 * a new {@link Vector2f} is to be created
	 * 
	 * @return The result of the multiplication
	 */
	public Vector2f mul(Vector2f other, Vector2f dest) {
		return mul(this, other, dest);
	}
	
	/**Divides <code>this</code> by <code>other</code> and store
	 * the result to a newly created {@link Vector2f}.<br>
	 * <br>
	 * {@link #div(Vector2f, Vector2f, Vector2f) div(this, other, null);}
	 * 
	 * @param other The {@link Vector2f} to divide <code>this</code>
	 * 
	 * @return The result of the division
	 */
	public Vector2f div(Vector2f other) {
		return div(this, other, null);
	}

	/**Divides <code>this</code> by <code>other</code> and store
	 * the result in <code>dest</code>.<br>
	 * <br>
	 * {@link #div(Vector2f, Vector2f, Vector2f) div(this, other, dest);}
	 * 
	 * @param other The {@link Vector2f} to divide <code>this</code>
	 * @param dest Where to store the result, or <code>null</code> if
	 * a new {@link Vector2f} is to be created
	 * 
	 * @return The result of the division
	 */
	public Vector2f div(Vector2f other, Vector2f dest) {
		return div(this, other, dest);
	}
	
	/**Loads the values from <code>other</code>.
	 * 
	 * @param other The source {@link Vector2f}
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
	 * @param buffer The source {@link FloatBuffer}
	 * 
	 * @return <code>this</code>
	 * 
	 * @throws BufferUnderflowException If there was
	 * less than two available floats
	 */
	public Vector2f load(FloatBuffer buffer) {
		this.x = buffer.get();
		this.y = buffer.get();
		return this;
	}
	
	/**Stores two floats to <code>buffer</code>.
	 * 
	 * @param buffer The destination {@link FloatBuffer}
	 * 
	 * @return <code>this</code> 
	 * 
	 * @throws BufferOverflowException If the
	 * remaining capacity was less than two
	 */
	public Vector2f store(FloatBuffer buffer) {
		buffer.put(this.x);
		buffer.put(this.y);
		return this;
	}
	
	/**Negates this {@link Vector2f}.
	 * 
	 * @return The result
	 */
	public Vector2f negate() {
		return this.negate(null);
	}
	
	/**Negates this {@link Vector2f} and store the result
	 * in <code>dest</code>.
	 * 
	 * @param dest The destination {@link Vector2f}, or
	 * <code>null</code> if a new vector is to be created
	 * 
	 * @return <code>dest</code>
	 */
	public Vector2f negate(Vector2f dest) {
		if (dest == null) {
			dest = new Vector2f();
		}
		dest.x = -this.x;
		dest.y = -this.y;
		return dest;
	}
	
	/**Calculates the length of the {@link Vector2f}.
	 * 
	 * @return The length
	 */
	public float length() {
		return (float) Math.sqrt((this.x * this.x) + (this.y * this.y));
	}
	
	/**Calculates the dot product of <code>this</code> and
	 * <code>other</code>.
	 * 
	 * @param other The right {@link Vector2f} of the operation
	 * 
	 * @return The dot product
	 */
	public float dot(Vector2f other) {
		return dot(this, other);
	}
	
	/**Normalizes this {@link Vector2f}.
	 * 
	 * @return The result
	 */
	public Vector2f normalize() {
		return normalize(this, null);
	}
	
	/**Normalizes this {@link Vector2f} and store the result
	 * in <code>dest</code>.
	 * 
	 * @param dest The destination {@link Vector2f}, or
	 * <code>null</code> if a new vector is to be created
	 * 
	 * @return <code>dest</code>
	 */
	public Vector2f normalize(Vector2f dest) {
		return normalize(this, dest);
	}
	
	/**Calculates the angle between <code>this</code> and
	 * <code>other</code>, in radians.
	 * 
	 * @param other The right {@link Vector2f} of the operation
	 * 
	 * @return The angle between the two vectors
	 */
	public float angle(Vector2f other) {
		return angle(this, other);
	}
	
	/**Adds <code>left</code> and <code>right</code> and
	 * store the result in <code>dest</code>.
	 * 
	 * @param left The left {@link Vector2f} of the addition
	 * @param right The right {@link Vector2f} of the addition
	 * @param dest Where to store the result, or <code>null</code>
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
	 * @param left The left {@link Vector2f} of the subtraction
	 * @param right The right {@link Vector2f} of the subtraction
	 * @param dest Where to store the result, or <code>null</code>
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
	 * @param left The left {@link Vector2f} of the multiplication
	 * @param right The right {@link Vector2f} of the multiplication
	 * @param dest Where to store the result, or <code>null</code>
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
	
	/**Multiply <code>left</code> by <code>right</code> and
	 * store the result in <code>dest</code>.
	 * 
	 * @param left The left {@link Vector2f} of the multiplication
	 * @param right The right float value of the multiplication
	 * @param dest Where to store the result, or <code>null</code>
	 * if a new {@link Vector2f} is to be created
	 * 
	 * @return The result of the multiplication
	 */
	public static Vector2f mul(Vector2f left, float right, Vector2f dest) {
		if (dest == null) {
			dest = new Vector2f();
		}
		dest.x = left.x * right;
		dest.y = left.y * right;
		return dest;
	}
	
	/**Divides <code>left</code> by <code>right</code> and
	 * store the result in <code>dest</code>.
	 * 
	 * @param left The left {@link Vector2f} of the division
	 * @param right The right {@link Vector2f} of the division
	 * @param dest Where to store the result, or <code>null</code>
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
	
	/**Divides <code>left</code> by <code>right</code> and
	 * store the result in <code>dest</code>.
	 * 
	 * @param left The left {@link Vector2f} of the division
	 * @param right The right float value of the division
	 * @param dest Where to store the result, or <code>null</code>
	 * if a new {@link Vector2f} is to be created
	 * 
	 * @return The result of the division
	 */
	public static Vector2f div(Vector2f left, float right, Vector2f dest) {
		if (dest == null) {
			dest = new Vector2f();
		}
		dest.x = left.x / right;
		dest.y = left.y / right;
		return dest;
	}
	
	/**Calculates the dot product of <code>left</code> and
	 * <code>right</code>.
	 * 
	 * @param left The left {@link Vector2f} of the operation
	 * @param right The right {@link Vector2f} of the operation
	 * 
	 * @return The dot product
	 */
	public static float dot(Vector2f left, Vector2f right) {
		return (left.x * right.x) + (left.y * right.y);
	}
	
	/**Calculates the angle between <code>left</code> and
	 * <code>right</code>, in radians.
	 * 
	 * @param left The left {@link Vector2f} of the operation
	 * @param right The right {@link Vector2f} of the operation
	 * 
	 * @return The angle between the two vectors
	 */
	public static float angle(Vector2f left, Vector2f right) {
		float ddl = dot(left, right) / (left.length() * right.length());
		ddl = OOLWREMath.clamp(-1, 1, ddl);
		return (float) Math.acos(ddl);
	}
	
	/**Normalizes <code>src</code> and store the result in
	 * <code>dest</code>.
	 * 
	 * @param src The {@link Vector2f} to be normalized
	 * @param dest The destination {@link Vector2f}, or
	 * <code>null</code> if a new vector is to be created
	 * 
	 * @return <code>dest</code>
	 */
	public static Vector2f normalize(Vector2f src, Vector2f dest) {
		if (dest == null) {
			dest = new Vector2f();
		}
		float l = src.length();
		dest.x = src.x / l;
		dest.y = src.y / l;
		return dest;
	}
	
	/**Creates a new {@link Vector3f} with fields <code>x</code>
	 * and <code>y</code> set to this {@link Vector2f}'s values
	 * and <code>z</code> to 1;
	 * 
	 * @return A newly created {@link Vector3f}
	 */
	public Vector3f toVector3f() {
		return this.toVector3f(1);
	}
	
	/**Creates a new {@link Vector3f} with fields <code>x</code>
	 * and <code>y</code> set to this {@link Vector2f}'s values
	 * and <code>z</code> to the specified value.
	 * 
	 * @param z The value of the {@link Vector3f#z z} component
	 * of the {@link Vector3f}
	 * 
	 * @return A newly created {@link Vector3f}
	 */
	public Vector3f toVector3f(float z) {
		return new Vector3f(this.x, this.y, z);
	}
	
	/**Creates a new {@link Vector4f} with fields <code>x</code>
	 * and <code>y</code> set to this {@link Vector2f}'s values,
	 * <code>z</code> set to 1 and <code>w</code> set to 0.
	 * 
	 * @return A newly created {@link Vector4f}
	 */
	public Vector4f toVector4f() {
		return this.toVector4f(1, 0);
	}
	
	/**Creates a new {@link Vector4f} with fields <code>x</code>
	 * and <code>y</code> set to this {@link Vector2f}'s values,
	 * <code>z</code> to the specified value and <code>w</code>
	 * to 0.
	 * 
	 * @param z The value of the {@link Vector4f#z z} component
	 * of the {@link Vector4f}
	 * 
	 * @return A newly created {@link Vector4f}
	 */
	public Vector4f toVector4f(float z) {
		return this.toVector4f(z, 0);
	}
	
	/**Creates a new {@link Vector4f} with fields <code>x</code>
	 * and <code>y</code> set to this {@link Vector2f}'s values.
	 * <code>z</code> and <code>w</code> are set to the specified
	 * values.
	 * 
	 * @param z The value of the {@link Vector4f#z z} component
	 * of the {@link Vector4f}
	 * @param w The value of the {@link Vector4f#w w} component
	 * of the {@link Vector4f}
	 * 
	 * @return A newly created {@link Vector4f}
	 */
	public Vector4f toVector4f(float z, float w) {
		return new Vector4f(this.x, this.y, z, w);
	}
	
	/**Returns whether or not <code>obj</code> equals
	 * <code>this</code>.
	 * 
	 * @param obj The {@link Vector2f} to be compared
	 * 
	 * @return The comparison result
	 */
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (!(obj instanceof Vector2f)) {
			return false;
		}
		Vector2f v = (Vector2f) obj;
		if (v.x != this.x) {
			return false;
		}
		if (v.y != this.y) {
			return false;
		}
		return true;
	}
	
	/**Returns a {@link String} representation of this
	 * {@link Vector2f}.
	 * 
	 * @return A {@link String} representation
	 */
	public String toString() {
		return this.getClass().getName() + "[x=" + this.x + ",y=" + this.y + "]";
	}
}
