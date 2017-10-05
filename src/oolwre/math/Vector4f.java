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

/**A <code>Vector4f</code> represents a 4D vector of floats.
 */
public class Vector4f implements Serializable {
	
	private static final long serialVersionUID = OOLWRE.CURRENT_SERIAL_VERSION_UID;
	
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
	 * 
	 * @return <code>this</code>
	 */
	public Vector4f set(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		return this;
	}
	
	/**Sets all the values from the {@link Vector4f} to 0.
	 * 
	 * @return <code>this</code>
	 */
	public Vector4f reset() {
		return this.set(0, 0, 0, 0);
	}
	
	/**Adds <code>this</code> to <code>other</code> and store
	 * the result to a newly created {@link Vector4f}.<br>
	 * <br>
	 * {@link #add(Vector4f, Vector4f, Vector4f) add(this, other, null);}
	 * 
	 * @param other - The {@link Vector4f} to be added to <code>this</code>
	 * 
	 * @return The result of the addition
	 */
	public Vector4f add(Vector4f other) {
		return add(this, other, null);
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
	 * the result to a newly created {@link Vector4f}.<br>
	 * <br>
	 * {@link #sub(Vector4f, Vector4f, Vector4f) sub(this, other, null);}
	 * 
	 * @param other - The {@link Vector4f} to subtract from <code>this</code>
	 * 
	 * @return The result of the subtraction
	 */
	public Vector4f sub(Vector4f other) {
		return sub(this, other, null);
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
	 * the result to a newly created {@link Vector4f}.<br>
	 * <br>
	 * {@link #mul(Vector4f, Vector4f, Vector4f) mul(this, other, null);}
	 * 
	 * @param other - The {@link Vector4f} to multiply <code>this</code>
	 * 
	 * @return The result of the multiplication
	 */
	public Vector4f mul(Vector4f other) {
		return mul(this, other, null);
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
	 * the result to a newly created {@link Vector4f}.<br>
	 * <br>
	 * {@link #div(Vector4f, Vector4f, Vector4f) div(this, other, null);}
	 * 
	 * @param other - The {@link Vector4f} to divide <code>this</code>
	 * 
	 * @return The result of the division
	 */
	public Vector4f div(Vector4f other) {
		return div(this, other, null);
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
	
	/**Negates this {@link Vector4f}.
	 * 
	 * @return The result
	 */
	public Vector4f negate() {
		return this.negate(null);
	}
	
	/**Negates this {@link Vector4f} and store the result
	 * in <code>dest</code>.
	 * 
	 * @param dest The destination {@link Vector4f}, or
	 * <code>null</code> if a new vector is to be created
	 * 
	 * @return <code>dest</code>
	 */
	public Vector4f negate(Vector4f dest) {
		if (dest == null) {
			dest = new Vector4f();
		}
		dest.x = -this.x;
		dest.y = -this.y;
		dest.z = -this.z;
		dest.w = -this.w;
		return dest;
	}
	
	/**Calculates the dot product of <code>this</code> and
	 * <code>other</code>.
	 * 
	 * @param other The right {@link Vector4f} of the operation
	 * 
	 * @return The dot product
	 */
	public float dot(Vector4f other) {
		return dot(this, other);
	}
	
	/**Calculates the angle between <code>this</code> and
	 * <code>other</code>, in radians.
	 * 
	 * @param other The right {@link Vector4f} of the operation
	 * 
	 * @return The angle between the two vectors
	 */
	public float angle(Vector4f other) {
		return angle(this, other);
	}
	
	/**Normalizes this {@link Vector3f}.
	 * 
	 * @return The result
	 */
	public Vector4f normalize() {
		return normalize(this, null);
	}
	
	/**Normalizes this {@link Vector4f} and store the result
	 * in <code>dest</code>.
	 * 
	 * @param dest The destination {@link Vector4f}, or
	 * <code>null</code> if a new vector is to be created
	 * 
	 * @return <code>dest</code>
	 */
	public Vector4f normalize(Vector4f dest) {
		return normalize(this, dest);
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
	
	/**Multiply <code>left</code> by <code>right</code> and
	 * store the result in <code>dest</code>.
	 * 
	 * @param left The left {@link Vector4f} of the multiplication
	 * @param right The right float value of the multiplication
	 * @param dest Where to store the result, or <code>null</code>
	 * if a new {@link Vector4f} is to be created
	 * 
	 * @return The result of the multiplication
	 */
	public static Vector4f mul(Vector4f left, float right, Vector4f dest) {
		if (dest == null) {
			dest = new Vector4f();
		}
		dest.x = left.x * right;
		dest.y = left.y * right;
		dest.z = left.z * right;
		dest.w = left.w * right;
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
	
	/**Divides <code>left</code> by <code>right</code> and
	 * store the result in <code>dest</code>.
	 * 
	 * @param left The left {@link Vector4f} of the division
	 * @param right The right float value of the division
	 * @param dest Where to store the result, or <code>null</code>
	 * if a new {@link Vector4f} is to be created
	 * 
	 * @return The result of the division
	 */
	public static Vector4f div(Vector4f left, float right, Vector4f dest) {
		if (dest == null) {
			dest = new Vector4f();
		}
		dest.x = left.x / right;
		dest.y = left.y / right;
		dest.z = left.z / right;
		dest.w = left.w / right;
		return dest;
	}
	
	/**Calculates the dot product of <code>left</code> and
	 * <code>right</code>.
	 * 
	 * @param left The left {@link Vector4f} of the operation
	 * @param right The right {@link Vector4f} of the operation
	 * 
	 * @return The dot product
	 */
	public static float dot(Vector4f left, Vector4f right) {
		return (left.x * right.x) + (left.y * right.y) + (left.z * right.z) + (left.w * right.w);
	}
	
	/**Calculates the angle between <code>left</code> and
	 * <code>right</code>, in radians.
	 * 
	 * @param left The left {@link Vector4f} of the operation
	 * @param right The right {@link Vector4f} of the operation
	 * 
	 * @return The angle between the two vectors
	 */
	public static float angle(Vector4f left, Vector4f right) {
		float ddl = dot(left, right) / (left.length() * right.length());
		ddl = OOLWREMath.clamp(-1, 1, ddl);
		return ddl;
	}
	
	/**Normalizes <code>src</code> and store the result in
	 * <code>dest</code>.
	 * 
	 * @param src The {@link Vector4f} to be normalized
	 * @param dest The destination {@link Vector4f}, or
	 * <code>null</code> if a new vector is to be created
	 * 
	 * @return <code>dest</code>
	 */
	public static Vector4f normalize(Vector4f src, Vector4f dest) {
		if (dest == null) {
			dest = new Vector4f();
		}
		float l = src.length();
		dest.x = src.x / l;
		dest.y = src.y / l;
		dest.z = src.z / l;
		dest.w = src.w / l;
		return dest;
	}
	
	/**Creates a new {@link Vector2f} with fields <code>x</code> and
	 * <code>y</code> set to this {@link Vector4f}'s 2D values.
	 * 
	 * @return A newly created {@link Vector2f}
	 */
	public Vector2f toVector2f() {
		return new Vector2f(this.x, this.y);
	}
	
	/**Creates a new {@link Vector3f} with fields <code>x</code>,
	 * <code>y</code> and <code>z</code> set to this {@link Vector4f}'s
	 * 3D values.
	 * 
	 * @return A newly created {@link Vector3f}
	 */
	public Vector3f toVector3f() {
		return new Vector3f(this.x, this.y, this.z);
	}
	
	/**Returns whether or not <code>obj</code> equals <code>this</code>.
	 * 
	 * @param obj The {@link Vector4f} to be compared
	 * 
	 * @return The result of the comparison
	 */
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (!(obj instanceof Vector4f)) {
			return false;
		}
		Vector4f v = (Vector4f) obj;
		if (v.x != this.x) {
			return false;
		}
		if (v.y != this.y) {
			return false;
		}
		if (v.z != this.z) {
			return false;
		}
		if (v.w != this.w) {
			return false;
		}
		return true;
	}
	
	/**Returns a {@link String} representation of this {@link Vector4f}.
	 * 
	 * @return A {@link String} representation
	 */
	public String toString() {
		return this.getClass().getName() + "[x=" + this.x + ",y=" + this.y + ",z=" + this.z +
				",w=" + this.w + "]";
	}
}
