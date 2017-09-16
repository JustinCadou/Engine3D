package oolwre;

import oolwre.util.CollectionUtil;

/**A {@link LibraryInfo} is an immutable object that contains
 * abstract informations about a certain library.
 */
public class LibraryInfo {
	
	private String name;
	private Version version;
	
	/**Just an abstract bunch of additional informations*/
	private String[] attributes;
	
	/**Creates a {@link LibraryInfo} with the specified parameters.
	 * 
	 * @param name - The library name
	 * @param version - The library {@link Version}
	 * @param attributes - The attributes of the library; can be <code>null</code>
	 */
	public LibraryInfo(String name, Version version, String... attributes) {
		if (name == null) {
			throw new NullPointerException("'name' is null");
		}
		this.name = name;
		if (version == null) {
			throw new NullPointerException("'version' is null");
		}
		this.version = version;
		this.attributes = attributes;
	}
	
	/**The {@link LibraryInfo} name.
	 * 
	 * @return The library name
	 */
	public String getName() {
		return this.name;
	}
	
	/**The {@link LibraryInfo} {@link Version}.
	 * 
	 * @return The library version
	 */
	public Version getVersion() {
		return this.version;
	}
	
	/**The {@link LibraryInfo} attributes. Can be <code>null</code>.
	 * 
	 * @return The library attributes
	 */
	public String[] getAttributes() {
		return CollectionUtil.<String>duplicate(this.attributes);
	}
	
	/**Returns a {@link String} representation of this {@link LibraryInfo}.*/
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.name);
		sb.append(' ');
		sb.append(this.version);
		if (this.attributes != null) {
			if (this.attributes.length > 0) {
				sb.append(" (");
				for (String attribute : this.attributes) {
					sb.append(attribute).append(' ');
				}
				sb.deleteCharAt(sb.length() - 1);
				sb.append(")");
			}
		}
		return sb.toString();
	}
	
	/**A <code>Version</code> is an immutable object that contains data
	 * about which version is a {@link LibraryInfo}.
	 */
	public static class Version {
		
		/**The {@link Version} major*/
		public final int major;
		
		/**The {@link Version} minor*/
		public final int minor;
		
		/**The {@link Version} revision*/
		public final int revision;
		
		/**Used if the {@link Version} needs even more precision*/
		private int[] more;
		
		/**Constructs a {@link Version} object with the specified values.
		 * 
		 * @param major - The {@link Version} major
		 * @param minor - The {@link Version} minor
		 * @param revision - The {@link Version} revision
		 * @param more - Used for even more {@link Version} precision
		 */
		public Version(int major, int minor, int revision, int... more) {
			this.major = major;
			this.minor = minor;
			this.revision = revision;
			int traillingZeros = 0;
			for (int i = 0; i < more.length; i++) {
				if (more[i] == 0) {
					traillingZeros++;
				} else {
					traillingZeros = 0;
				}
			}
			this.more = new int[more.length - traillingZeros];
			for (int i = 0; i < this.more.length; i++) {
				this.more[i] = more[i];
			}
		}		
		
		/**Returns the {@link Version} update at <code>index + 3</code>
		 * or <code>null</code> if none specified.
		 * 
		 * @param index - The small {@link Version} update index
		 * 
		 * @return The small {@link Version} update at <code>index</code>
		 * 
		 * @throws IndexOutOfBoundsException If <code>index</code> < 0
		 */
		public Integer getSmallerVersionUpdate(int index) {
			if (index < 0) {
				throw new IndexOutOfBoundsException("index < 0");
			} else if (index >= this.more.length) {
				return null;
			} else {
				return this.more[index];
			}
		}
		
		/**Returns whether or not <code>this</code> is less than <code>that</code>.
		 * 
		 * @param that - The {@link Version} to be compared to <code>this</code>
		 * 
		 * @return Whether or not <code>this</code> is less than <code>that</code>
		 */
		public boolean isLessThan(Version that) {
			if (that == null) {
				return false;
			} else if (that.equals(this)) {
				return false;
			}
			if (that.major < this.major) {
				return false;
			} else if (that.minor < this.minor) {
				return false;
			} else if (that.revision < this.revision) {
				return false;
			}
			int min = Math.min(that.more.length, this.more.length);
			for (int i = 0; i < min; i++) {
				if (that.more[i] < this.more[i]) {
					return false;
				} else if (that.more[i] > this.more[i]) {
					return true;
				}
			}
			if (that.more.length < this.more.length) {
				return false;
			}
 			return true;
		}
		
		/**Returns whether or not <code>this</code> is more than <code>that</code>.
		 * 
		 * @param that - The {@link Version} to be compared to <code>this</code>
		 * 
		 * @return Whether or not <code>this</code> is more than <code>that</code>
		 */
		public boolean isMoreThan(Version that) {
			return !that.equals(this) && !that.isLessThan(this);
		}
		
		/**Returns whether or not <code>this</code> equals <code>that</code>.
		 * 
		 * @param The {@link Version} to be compared to <code>this</code>
		 * 
		 * @return Whether or not <code>this</code> equals <code>that</code>
		 */
		public boolean equals(Version that) {
			if (that == null) {
				return false;
			} else if (that.major != this.major) {
				return false;
			} else if (that.minor != this.minor) {
				return false;
			} else if (that.revision != this.revision) {
				return false;
			} else if (that.more.length != this.more.length) {
				return false;
			}
			for (int i = 0; i < this.more.length; i++) {
				if (that.more[i] != this.more[i]) {
					return false;
				}
			}
			return true;
		}
		
		/**Returns whether or not <code>obj</code> equals <code>this</code>.
		 * 
		 * @param The {@link Version} to be compared to <code>this</code>
		 * 
		 * @return Whether or not <code>obj</code> equals <code>this</code>
		 */
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (obj == null) {
				return false;
			} else if (!(obj instanceof Version)) {
				return false;
			}
			Version ver = (Version) obj;
			return ver.equals(this);
		}
		
		/**Returns the {@link Version} like<br>
		 * <p><code>&nbsp;&nbsp;&nbsp;&nbsp;
		 * {@link #major}.{@link #minor}.{@link #revision}</code></p>
		 * and may add more data if smaller values exists.<br>&nbsp;
		 * 
		 * @return {@link #major} + {@link #minor} + {@link #revision}
		 */
		public String toString() {
			StringBuilder version = new StringBuilder();
			version.append(this.major).append('.');
			version.append(this.minor).append('.');
			version.append(this.revision);
			for (int small : this.more) {
				version.append('.').append(small);
			}
			return version.toString();
		}
	}
}
