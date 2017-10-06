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
package net.fantasticfantasy.oolwre.math;

import java.io.Serializable;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.FloatBuffer;
import net.fantasticfantasy.oolwre.OOLWRE;

/**A <code>Matrix4f</code> represents a 4x4 matrix of floats.<br><br>
 * Passing a <code>null</code> value to any method will result in a
 * {@link NullPointerException} unless otherwise noted.
 */
public class Matrix4f implements Serializable {
	
	private static final long serialVersionUID = OOLWRE.CURRENT_SERIAL_VERSION_UID;
	
	/**Fields*/
	public float f00, f01, f02, f03,
				f10, f11, f12, f13,
				f20, f21, f22, f23,
				f30, f31, f32, f33;
	
	/**Constructs a new {@link Matrix4f}.
	 */
	public Matrix4f() {}
	
	/**Constructs a new {@link Matrix4f} and {@link #load(Matrix4f) load}
	 * <code>src</code>.
	 * 
	 * @param src The source {@link Matrix4f}
	 */
	public Matrix4f(Matrix4f src) {
		this.load(src);
	}
	
	/**Loads the identity matrix on <code>this</code>.
	 * 
	 * @return <code>this</code>
	 */
	public Matrix4f loadIdentity() {
		this.f00 = 1;
		this.f01 = 0;
		this.f02 = 0;
		this.f03 = 0;
		
		this.f10 = 0;
		this.f11 = 1;
		this.f12 = 0;
		this.f13 = 0;
		
		this.f20 = 0;
		this.f21 = 0;
		this.f22 = 1;
		this.f23 = 0;
		
		this.f30 = 0;
		this.f31 = 0;
		this.f32 = 0;
		this.f33 = 1;
		
		return this;
	}
	
	/**Sets all the fields of <code>this</code> to 0.
	 * 
	 * @return <code>this</code>
	 */
	public Matrix4f reset() {
		this.f00 = 0;
		this.f01 = 0;
		this.f02 = 0;
		this.f03 = 0;
		
		this.f10 = 0;
		this.f11 = 0;
		this.f12 = 0;
		this.f13 = 0;
		
		this.f20 = 0;
		this.f21 = 0;
		this.f22 = 0;
		this.f23 = 0;
		
		this.f30 = 0;
		this.f31 = 0;
		this.f32 = 0;
		this.f33 = 0;
		
		return this;
	}
	
	/**Sets all the values from <code>this</code> to the ones from
	 * <code>src</code>, so that {@link #equals(Object) this.equals(src)}
	 * returns <code>true</code>.
	 * 
	 * @param src The source {@link Matrix4f}
	 * 
	 * @return <code>this</code>
	 */
	public Matrix4f load(Matrix4f src) {
		this.f00 = src.f00;
		this.f01 = src.f01;
		this.f02 = src.f02;
		this.f03 = src.f03;

		this.f10 = src.f10;
		this.f11 = src.f11;
		this.f12 = src.f12;
		this.f13 = src.f13;

		this.f20 = src.f20;
		this.f21 = src.f21;
		this.f22 = src.f22;
		this.f23 = src.f23;

		this.f30 = src.f30;
		this.f31 = src.f31;
		this.f32 = src.f32;
		this.f33 = src.f33;
		
		return this;
	}
	
	/**Loads a {@link Matrix4f} from <code>in</code> to <code>this</code>.
	 * 
	 * @param in The input {@link FloatBuffer}
	 * 
	 * @throws BufferUnderflowException If there was not enough data remaining
	 * from <code>in</code>
	 * 
	 * @return <code>this</code>
	 */
	public Matrix4f load(FloatBuffer in) {
		this.f00 = in.get();
		this.f01 = in.get();
		this.f02 = in.get();
		this.f03 = in.get();

		this.f10 = in.get();
		this.f11 = in.get();
		this.f12 = in.get();
		this.f13 = in.get();

		this.f20 = in.get();
		this.f21 = in.get();
		this.f22 = in.get();
		this.f23 = in.get();

		this.f30 = in.get();
		this.f31 = in.get();
		this.f32 = in.get();
		this.f33 = in.get();
		
		return this;
	}
	
	/**Loads a transposed {@link Matrix4f} from <code>in</code> to
	 * <code>this</code>.
	 * 
	 * @param in The input {@link FloatBuffer}
	 * 
	 * @throws BufferUnderflowException If there was not enough data remaining
	 * from <code>in</code>
	 * 
	 * @return <code>this</code>
	 */
	public Matrix4f loadTransposed(FloatBuffer in) {
		(this.load(in)).transpose(this);
		return this;
	}
	
	/**Stores this {@link Matrix4f} in <code>out</code>.
	 * 
	 * @param out The output {@link FloatBuffer}
	 * 
	 * @throws BufferOverflowException If there was not enough space remaining
	 * in <code>out</code>
	 * 
	 * @return <code>this</code>
	 */
	public Matrix4f store(FloatBuffer out) {
		out.put(this.f00);
		out.put(this.f01);
		out.put(this.f02);
		out.put(this.f03);
		
		out.put(this.f10);
		out.put(this.f11);
		out.put(this.f12);
		out.put(this.f13);
		
		out.put(this.f20);
		out.put(this.f21);
		out.put(this.f22);
		out.put(this.f23);
		
		out.put(this.f30);
		out.put(this.f31);
		out.put(this.f32);
		out.put(this.f33);
		
		return this;
	}
	
	/**Store this {@link Matrix4f} transposed to <code>out</code>.
	 * 
	 * @param out The output {@link FloatBuffer}
	 * 
	 * @throws BufferOverflowException If there was not enough space remaining
	 * in <code>out</code>
	 * 
	 * @return <code>this</code>
	 */
	public Matrix4f storeTranspose(FloatBuffer out) {
		(this.transpose()).store(out);
		return this;
	}
	
	/**Negates this {@link Matrix4f} and store the result to a newly created
	 * matrix.
	 * 
	 * @return The result
	 */
	public Matrix4f negate() {
		return this.negate(null);
	}
	
	/**Negates this {@link Matrix4f} and store the result in <code>dest</code>.
	 * 
	 * @param dest The destination {@link Matrix4f}, or <code>null</code> if
	 * a new matrix is to be created.
	 * 
	 * @return The result
	 */
	public Matrix4f negate(Matrix4f dest) {
		if (dest == null) {
			dest = new Matrix4f();
		}
		dest.f00 = -this.f00;
		dest.f01 = -this.f01;
		dest.f02 = -this.f02;
		dest.f03 = -this.f03;

		dest.f10 = -this.f10;
		dest.f11 = -this.f11;
		dest.f12 = -this.f12;
		dest.f13 = -this.f13;

		dest.f20 = -this.f20;
		dest.f21 = -this.f21;
		dest.f22 = -this.f22;
		dest.f23 = -this.f23;

		dest.f03 = -this.f30;
		dest.f31 = -this.f31;
		dest.f32 = -this.f32;
		dest.f33 = -this.f33;
		
		return dest;
	}
	
	/**Transposes this {@link Matrix4f} and stores the result in a newly
	 * created matrix.
	 * 
	 * @return The result
	 */
	public Matrix4f transpose() {
		return this.transpose(null);
	}
	
	/**Transposes this {@link Matrix4f} and stores the result in
	 * <code>dest</code>.
	 * 
	 * @param dest The destination {@link Matrix4f}, or <code>null</code> if a
	 * new matrix is to be created
	 * 
	 * @return The result
	 */
	public Matrix4f transpose(Matrix4f dest) {
		if (dest == null) {
			dest = new Matrix4f();
		}
		dest.f00 = this.f00;
		dest.f01 = this.f10;
		dest.f02 = this.f20;
		dest.f03 = this.f30;

		dest.f10 = this.f01;
		dest.f11 = this.f11;
		dest.f12 = this.f21;
		dest.f13 = this.f31;

		dest.f20 = this.f02;
		dest.f21 = this.f12;
		dest.f22 = this.f22;
		dest.f23 = this.f32;
		
		dest.f30 = this.f03;
		dest.f31 = this.f13;
		dest.f32 = this.f23;
		dest.f33 = this.f33;
		
		return dest;
	}
	
	/**Adds <code>this</code> and <code>mat</code> and stores the result
	 * to a newly created matrix.
	 * 
	 * @param mat The right {@link Matrix4f}
	 * 
	 * @return The result
	 */
	public Matrix4f add(Matrix4f mat) {
		return add(this, mat, null);
	}
	
	/**Adds <code>this</code> and <code>mat</code> and stores the result
	 * in <code>dest</code>.
	 * 
	 * @param mat The right {@link Matrix4f}
	 * @param dest The destination {@link Matrix4f}, or <code>null</code> if
	 * a new matrix is to be created
	 * 
	 * @return The result
	 */
	public Matrix4f add(Matrix4f mat, Matrix4f dest) {
		return add(this, mat, dest);
	}
	
	/**Subtracts <code>mat</code> from <code>this</code> and stores the result
	 * to a newly created matrix.
	 * 
	 * @param mat The right {@link Matrix4f}
	 * 
	 * @return The result
	 */
	public Matrix4f sub(Matrix4f mat) {
		return sub(this, mat, null);
	}
	
	/**Subtracts <code>mat</code> from <code>this</code> and stores the result
	 * in <code>dest</code>.
	 * 
	 * @param mat The right {@link Matrix4f}
	 * @param dest The destination {@link Matrix4f}, or <code>null</code> if
	 * a new matrix is to be created
	 * 
	 * @return The result
	 */
	public Matrix4f sub(Matrix4f mat, Matrix4f dest) {
		return sub(this, mat, dest);
	}
	
	/**Multiplies <code>this</code> by <code>mat</code> and stores the result
	 * to a newly created matrix.
	 * 
	 * @param mat The right {@link Matrix4f}
	 * 
	 * @return The result
	 */
	public Matrix4f mul(Matrix4f mat) {
		return mul(this, mat, null);
	}
	
	/**Multiplies <code>this</code> by <code>mat</code> and stores the result
	 * in <code>dest</code>.
	 * 
	 * @param mat The right {@link Matrix4f}
	 * @param dest The destination {@link Matrix4f}, or <code>null</code> if
	 * a new matrix is to be created
	 * 
	 * @return The result
	 */
	public Matrix4f mul(Matrix4f mat, Matrix4f dest) {
		return mul(this, mat, dest);
	}
	
	/**Divides <code>this</code> by <code>mat</code> and stores the result
	 * to a newly created {@link Matrix4f}.
	 * 
	 * @param mat The right {@link Matrix4f}
	 * 
	 * @return The result
	 */
	public Matrix4f div(Matrix4f mat) {
		return div(this, mat, null);
	}
	
	/**Divides <code>this</code> by <code>mat</code> and stores the result
	 * in <code>dest</code>.
	 * 
	 * @param mat The right {@link Matrix4f}
	 * @param dest The destination {@link Matrix4f}, or <code>null</code> if
	 * a new matrix is to be created
	 * 
	 * @return The result
	 */
	public Matrix4f div(Matrix4f mat, Matrix4f dest) {
		return div(this, mat, dest);
	}
	
	/**Translates this {@link Matrix4f} by <code>translation</code> and stores
	 * the result to a newly created matrix.
	 * 
	 * @param translation The translation {@link Vector3f}
	 * 
	 * @return The result
	 */
	public Matrix4f translate(Vector3f translation) {
		return translate(this, translation, null);
	}
	
	/**Translates this {@link Matrix4f} by <code>translation</code> and stores
	 * the result in <code>dest</code>.
	 * 
	 * @param translation The translation {@link Vector3f}
	 * @param dest The destination {@link Matrix4f}, or <code>null</code> if
	 * a new matrix is to be created
	 * 
	 * @return The result
	 */
	public Matrix4f translate(Vector3f translation, Matrix4f dest) {
		return translate(this, translation, dest);
	}
	
	/**Scales this {@link Matrix4f} by <code>scale</code> and stores
	 * the result to a newly created matrix.
	 * 
	 * @param scale The scaling {@link Vector3f}
	 * 
	 * @return The result
	 */
	public Matrix4f scale(Vector3f scale) {
		return scale(this, scale, null);
	}
	
	/**Scales this {@link Matrix4f} by <code>scale</code> and stores
	 * the result in <code>dest</code>.
	 * 
	 * @param scale The scaling {@link Vector3f}
	 * @param dest The destination {@link Matrix4f}, or <code>null</code> if
	 * a new matrix is to be created
	 * 
	 * @return The result
	 */
	public Matrix4f scale(Vector3f scale, Matrix4f dest) {
		return scale(this, scale, null);
	}
	
	/**Rotates this {@link Matrix4f} by <code>angle</code> on <code>axis</code>
	 * and stores the result to a newly created matrix.
	 * 
	 * @param angle The rotation angle, in radians
	 * @param axis The rotation axis {@link Vector3f}
	 * 
	 * @return The result
	 */
	public Matrix4f rotate(float angle, Vector3f axis) {
		return rotate(this, angle, axis, null);
	}
	
	/**Rotates this {@link Matrix4f} by <code>angle</code> on <code>axis</code>
	 * and stores the result in <code>dest</code>.
	 * 
	 * @param angle The rotation angle, in radians
	 * @param axis The rotation axis {@link Vector3f}
	 * @param dest The destination {@link Matrix4f}, or <code>null</code> if a
	 * new matrix is to be created
	 * 
	 * @return The result
	 */
	public Matrix4f rotate(float angle, Vector3f axis, Matrix4f dest) {
		return rotate(this, angle, axis, dest);
	}
	
	/**Rotates this {@link Matrix4f} by <code>rotation</code> and stores
	 * the result to a newly created matrix. If <code>radians</code> is
	 * <code>false</code>, fields of <code>rotation</code> are converted
	 * to radians.
	 * 
	 * @param rotation The scaling {@link Vector3f}
	 * @param radians Whether or not <code>rotation</code> is in radians
	 * 
	 * @return The result
	 */
	public Matrix4f rotateAllAxes(Vector3f rotation, boolean radians) {
		return rotateAllAxes(this, rotation, radians, null);
	}
	
	/**Rotates this {@link Matrix4f} by <code>rotation</code> and stores
	 * the result in <code>dest</code>. If <code>radians</code> is
	 * <code>false</code>, fields of <code>rotation</code> are converted
	 * to radians.
	 * 
	 * @param rotation The scaling {@link Vector3f}
	 * @param radians Whether or not <code>rotation</code> is in radians
	 * @param dest The destination {@link Matrix4f}, or <code>null</code> if a
	 * new matrix is to be created
	 * 
	 * @return The result
	 */
	public Matrix4f rotateAllAxes(Vector3f rotation, boolean radians, Matrix4f dest) {
		return rotateAllAxes(this, rotation, radians, null);
	}
	
	/**Transforms <code>left</code> by this {@link Matrix4f} and stores the result
	 * to a newly created matrix.
	 * 
	 * @param left The left {@link Vector4f}
	 * 
	 * @return The result
	 */
	public Vector4f transform(Vector4f left) {
		return transform(left, this, null);
	}
	
	/**Transforms <code>left</code> by this {@link Matrix4f} and stores the result
	 * in <code>dest</code>.
	 * 
	 * @param left The left {@link Vector4f}
	 * @param dest The destination {@link Vector4f}, or <code>null</code> if a
	 * new vector is to be created
	 * 
	 * @return The result
	 */
	public Vector4f transform(Vector4f left, Vector4f dest) {
		return transform(left, this, dest);
	}
	
	/**Adds <code>left</code> and <code>right</code> and stores the result
	 * in <code>dest</code>.
	 * 
	 * @param left The left {@link Matrix4f}
	 * @param right The right {@link Matrix4f}
	 * @param dest The destination {@link Matrix4f}, or <code>null</code> if
	 * a new matrix is to be created
	 * 
	 * @return The result
	 */
	public static Matrix4f add(Matrix4f left, Matrix4f right, Matrix4f dest) {
		if (dest == null) {
			dest = new Matrix4f();
		}
		dest.f00 = left.f00 + right.f00;
		dest.f01 = left.f01 + right.f01;
		dest.f02 = left.f02 + right.f02;
		dest.f03 = left.f03 + right.f03;

		dest.f10 = left.f10 + right.f10;
		dest.f11 = left.f11 + right.f11;
		dest.f12 = left.f12 + right.f12;
		dest.f13 = left.f13 + right.f13;

		dest.f20 = left.f20 + right.f20;
		dest.f21 = left.f21 + right.f21;
		dest.f22 = left.f22 + right.f22;
		dest.f23 = left.f23 + right.f23;

		dest.f30 = left.f30 + right.f30;
		dest.f31 = left.f31 + right.f31;
		dest.f32 = left.f32 + right.f32;
		dest.f33 = left.f33 + right.f33;
		
		return dest;
	}
	
	/**Subtracts <code>right</code> from <code>left</code> and stores the result
	 * in <code>dest</code>.
	 * 
	 * @param left The left {@link Matrix4f}
	 * @param right The right {@link Matrix4f}
	 * @param dest The destination {@link Matrix4f}, or <code>null</code> if
	 * a new matrix is to be created
	 * 
	 * @return The result
	 */
	public static Matrix4f sub(Matrix4f left, Matrix4f right, Matrix4f dest) {
		if (dest == null) {
			dest = new Matrix4f();
		}
		dest.f00 = left.f00 - right.f00;
		dest.f01 = left.f01 - right.f01;
		dest.f02 = left.f02 - right.f02;
		dest.f03 = left.f03 - right.f03;

		dest.f10 = left.f10 - right.f10;
		dest.f11 = left.f11 - right.f11;
		dest.f12 = left.f12 - right.f12;
		dest.f13 = left.f13 - right.f13;

		dest.f20 = left.f20 - right.f20;
		dest.f21 = left.f21 - right.f21;
		dest.f22 = left.f22 - right.f22;
		dest.f23 = left.f23 - right.f23;

		dest.f30 = left.f30 - right.f30;
		dest.f31 = left.f31 - right.f31;
		dest.f32 = left.f32 - right.f32;
		dest.f33 = left.f33 - right.f33;
		
		return dest;
	}
	
	/**Multiplies <code>left</code> by <code>right</code> and stores the result
	 * in <code>dest</code>.
	 * 
	 * @param left The left {@link Matrix4f}
	 * @param right The right {@link Matrix4f}
	 * @param dest The destination {@link Matrix4f}, or <code>null</code> if
	 * a new matrix is to be created
	 * 
	 * @return The result
	 */
	public static Matrix4f mul(Matrix4f left, Matrix4f right, Matrix4f dest) {
		if (dest == null) {
			dest = new Matrix4f();
		}
		dest.f00 = left.f00 * right.f00;
		dest.f01 = left.f01 * right.f01;
		dest.f02 = left.f02 * right.f02;
		dest.f03 = left.f03 * right.f03;

		dest.f10 = left.f10 * right.f10;
		dest.f11 = left.f11 * right.f11;
		dest.f12 = left.f12 * right.f12;
		dest.f13 = left.f13 * right.f13;

		dest.f20 = left.f20 * right.f20;
		dest.f21 = left.f21 * right.f21;
		dest.f22 = left.f22 * right.f22;
		dest.f23 = left.f23 * right.f23;

		dest.f30 = left.f30 * right.f30;
		dest.f31 = left.f31 * right.f31;
		dest.f32 = left.f32 * right.f32;
		dest.f33 = left.f33 * right.f33;
		
		return dest;
	}
	
	/**Divides <code>left</code> by <code>right</code> and stores the result
	 * in <code>dest</code>.
	 * 
	 * @param left The left {@link Matrix4f}
	 * @param right The right {@link Matrix4f}
	 * @param dest The destination {@link Matrix4f}, or <code>null</code> if
	 * a new matrix is to be created
	 * 
	 * @return The result
	 */
	public static Matrix4f div(Matrix4f left, Matrix4f right, Matrix4f dest) {
		if (dest == null) {
			dest = new Matrix4f();
		}
		dest.f00 = left.f00 / right.f00;
		dest.f01 = left.f01 / right.f01;
		dest.f02 = left.f02 / right.f02;
		dest.f03 = left.f03 / right.f03;

		dest.f10 = left.f10 / right.f10;
		dest.f11 = left.f11 / right.f11;
		dest.f12 = left.f12 / right.f12;
		dest.f13 = left.f13 / right.f13;

		dest.f20 = left.f20 / right.f20;
		dest.f21 = left.f21 / right.f21;
		dest.f22 = left.f22 / right.f22;
		dest.f23 = left.f23 / right.f23;

		dest.f30 = left.f30 / right.f30;
		dest.f31 = left.f31 / right.f31;
		dest.f32 = left.f32 / right.f32;
		dest.f33 = left.f33 / right.f33;
		
		return dest;
	}
	
	/**Translates <code>src</code> by <code>translation</code> and stores
	 * the result in <code>dest</code>.
	 * 
	 * @param src The {@link Matrix4f} to be translated
	 * @param translation The translation {@link Vector3f}
	 * @param dest The destination {@link Matrix4f}, or <code>null</code> if a
	 * new matrix is to be created
	 * 
	 * @return The result
	 */
	public static Matrix4f translate(Matrix4f src, Vector3f translation, Matrix4f dest) {
		if (dest == null) {
			dest = new Matrix4f();
		}
		dest.f30 += (src.f00 * translation.x) + (src.f10 * translation.y) + (src.f20 * translation.z);
		dest.f31 += (src.f01 * translation.x) + (src.f11 * translation.y) + (src.f21 * translation.z);
		dest.f32 += (src.f02 * translation.x) + (src.f12 * translation.y) + (src.f22 * translation.z);
		dest.f33 += (src.f03 * translation.x) + (src.f13 * translation.y) + (src.f23 * translation.z);
		return dest;
	}
	
	/**Scales <code>src</code> by <code>scale</code> and stores
	 * the result in <code>dest</code>.
	 * 
	 * @param src The {@link Matrix4f} to be scaled
	 * @param scale The scaling {@link Vector3f}
	 * @param dest The destination {@link Matrix4f}, or <code>null</code> if a
	 * new matrix is to be created
	 * 
	 * @return The result
	 */
	public static Matrix4f scale(Matrix4f src, Vector3f scale, Matrix4f dest) {
		if (dest == null) {
			dest = new Matrix4f();
		}
		dest.f00 = src.f00 * scale.x;
		dest.f01 = src.f01 * scale.x;
		dest.f02 = src.f02 * scale.x;
		dest.f03 = src.f03 * scale.x;
		
		dest.f10 = src.f10 * scale.y;
		dest.f11 = src.f11 * scale.y;
		dest.f12 = src.f12 * scale.y;
		dest.f13 = src.f13 * scale.y;
		
		dest.f20 = src.f20 * scale.z;
		dest.f21 = src.f21 * scale.z;
		dest.f22 = src.f22 * scale.z;
		dest.f23 = src.f23 * scale.z;
		
		return dest;
	}
	
	/**Rotates <code>src</code> by <code>angle</code> on <code>axis</code> and
	 * stores the result in <code>dest</code>.
	 * 
	 * @param src The {@link Matrix4f} to be rotated
	 * @param angle The rotation angle, in radians
	 * @param axis The rotation axis {@link Vector3f}
	 * @param dest The destination {@link Matrix4f}, or <code>null</code> if a
	 * new matrix is to be created
	 * 
	 * @return The result
	 */
	public static Matrix4f rotate(Matrix4f src, float angle, Vector3f axis, Matrix4f dest) {
		if (dest == null) {
			dest = new Matrix4f();
		}
		float x = axis.x;
		float y = axis.y; 
		float z = axis.z;
		
		float cos = (float) Math.cos(angle);
		float sin = (float) Math.sin(angle);
		float ncos = 1 - cos;
		float xy = x * y;
		float xz = x * z;
		float yz = y * z;
		float xsin = x * sin;
		float ysin = y * sin;
		float zsin = z * sin;
		
		float r00 = ((x * x) * ncos) + cos;
		float r01 = (xy * ncos) + zsin;
		float r02 = (xz * ncos) - ysin;
		float r10 = (xy * ncos) - zsin;
		float r11 = ((y * y) * ncos) + cos;
		float r12 = (yz * ncos) + xsin;
		float r20 = (xz * ncos) + ysin;
		float r21 = (yz * ncos) - xsin;
		float r22 = ((z * z) * ncos) + cos;
		
		float t00 = (src.f00 * r00) + (src.f10 * r01) + (src.f20 * r02);
		float t01 = (src.f01 * r00) + (src.f11 * r01) + (src.f21 * r02);
		float t02 = (src.f02 * r00) + (src.f12 * r01) + (src.f22 * r02);
		float t03 = (src.f03 * r00) + (src.f13 * r01) + (src.f23 * r02);
		float t10 = (src.f00 * r10) + (src.f10 * r11) + (src.f20 * r12);
		float t11 = (src.f01 * r10) + (src.f11 * r11) + (src.f21 * r12);
		float t12 = (src.f02 * r10) + (src.f12 * r11) + (src.f22 * r12);
		float t13 = (src.f03 * r10) + (src.f13 * r11) + (src.f23 * r12);
		
		dest.f20 = (src.f00 * r20) + (src.f10 * r21) + (src.f20 * r22);
		dest.f21 = (src.f01 * r20) + (src.f11 * r21) + (src.f21 * r22);
		dest.f22 = (src.f02 * r20) + (src.f12 * r21) + (src.f22 * r22);
		dest.f23 = (src.f03 * r20) + (src.f13 * r21) + (src.f23 * r22);
		
		dest.f00 = t00;
		dest.f01 = t01;
		dest.f02 = t02;
		dest.f03 = t03;
		dest.f10 = t10;
		dest.f11 = t11;
		dest.f12 = t12;
		dest.f13 = t13;
		
		return dest;
	}
	
	/**Rotates <code>src</code> by <code>rotation</code> and stores
	 * the result in <code>dest</code>. If <code>radians</code> is
	 * <code>false</code>, fields of <code>rotation</code> are converted
	 * to radians.
	 * 
	 * @param src The {@link Matrix4f} to be scaled
	 * @param rotation The scaling {@link Vector3f}
	 * @param radians Whether or not <code>rotation</code> is in radians
	 * @param dest The destination {@link Matrix4f}, or <code>null</code> if a
	 * new matrix is to be created
	 * 
	 * @return The result
	 */
	public static Matrix4f rotateAllAxes(Matrix4f src, Vector3f rotation, boolean radians, Matrix4f dest) {
		if (dest == null) {
			dest = new Matrix4f();
		}
		float x = rotation.x;
		float y = rotation.y;
		float z = rotation.z;
		
		if (!radians) {
			x = (float) Math.toRadians(x);
			y = (float) Math.toRadians(y);
			z = (float) Math.toRadians(z);
		}
		
		rotate(src, x, new Vector3f(1, 0, 0), dest);
		rotate(src, y, new Vector3f(0, 1, 0), dest);
		rotate(src, z, new Vector3f(0, 0, 1), dest);
		
		return dest;
	}
	
	/**Transforms <code>left</code> by <code>right</code> and stores the result
	 * in <code>dest</code>.
	 * 
	 * @param left The left {@link Vector4f}
	 * @param right The right {@link Matrix4f}
	 * @param dest The destination {@link Vector4f}, or <code>null</code> if a
	 * new vector is to be created
	 * 
	 * @return The result
	 */
	public static Vector4f transform(Vector4f left, Matrix4f right, Vector4f dest) {
		if (dest == null) {
			dest = new Vector4f();
		}
		dest.x = (right.f00 * left.x) + (right.f01 * left.x) + (right.f02 * left.x) + (right.f03 * left.x);
		dest.y = (right.f00 * left.y) + (right.f01 * left.y) + (right.f02 * left.y) + (right.f03 * left.y);
		dest.z = (right.f00 * left.z) + (right.f01 * left.z) + (right.f02 * left.z) + (right.f03 * left.z);
		dest.w = (right.f00 * left.w) + (right.f01 * left.w) + (right.f02 * left.w) + (right.f03 * left.w);
		
		return dest;
	}
	
	/**Creates a new identity {@link Matrix4f}.
	 * 
	 * @return A newly created {@link Matrix4f}
	 */
	public static Matrix4f newIdentity() {
		return (new Matrix4f()).loadIdentity();
	}
	
	/**Returns whether or not <code>obj</code> equals <code>this</code>.
	 * 
	 * @param obj The {@link Matrix4f} to be compared
	 * 
	 * @return The result of the comparison
	 */
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (!(obj instanceof Matrix4f)) {
			return false;
		}
		Matrix4f m = (Matrix4f) obj;
		if (m.f00 != this.f00 || m.f01 != this.f01 || m.f02 != this.f02 || m.f03 != this.f03) {
			return false;
		}
		if (m.f10 != this.f10 || m.f11 != this.f11 || m.f12 != this.f12 || m.f13 != this.f13) {
			return false;
		}
		if (m.f20 != this.f20 || m.f21 != this.f21 || m.f22 != this.f22 || m.f23 != this.f23) {
			return false;
		}
		if (m.f30 != this.f30 || m.f31 != this.f31 || m.f32 != this.f32 || m.f33 != this.f33) {
			return false;
		}
		return true;
	}
	
	/**Returns a {@link String} representation of this {@link Matrix4f}.
	 * 
	 * @return A {@link String} representation
	 */
	public String toString() {
		return this.getClass().getName() + "[" + this.f00 + "," + this.f01 + "," +
				this.f02 + "," + this.f03 + "," + this.f10 + "," + this.f11 + "," +
				this.f12 + "," + this.f13 + "," + this.f20 + "," + this.f21 + "," +
				this.f22 + "," + this.f23 + "," + this.f30 + "," + this.f31 + "," +
				this.f32 + "," + this.f33 + "]";
	}
}
