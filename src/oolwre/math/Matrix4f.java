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

/**A <code>Matrix4f</code> represents a 4x4 matrix of floats
 */
public class Matrix4f {
	
	/**Fields*/
	public float f00, f01, f02, f03,
				f10, f11, f12, f13,
				f20, f21, f22, f23,
				f30, f31, f32, f33;
	
	public Matrix4f() {}
	
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
