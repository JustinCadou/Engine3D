package net.fantasticfantasy.tseyll;

import net.fantasticfantasy.tseyll.util.CollectionUtil;

public class LibraryInfo {
	
	private String name;
	private Version version;
	private String[] attributes;
	
	public LibraryInfo(String name, Version version, String... attributes) {
		this.name = name;
		this.version = version;
		this.attributes = attributes;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Version getVersion() {
		return this.version;
	}
	
	public String[] getAttributes() {
		return CollectionUtil.<String>duplicate(this.attributes);
	}
	
	public static class Version {
		
		/**The {@link Version} major*/
		public final int major;
		
		/**The {@link Version} minor*/
		public final int minor;
		
		public final int revision;
		private int[] more;
		
		public Version(int major, int minor, int revision, int... more) {
			this.major = major;
			this.minor = minor;
			this.revision = revision;
			this.more = more;
		}
		
		public Integer getSmallerVersionUpdate(int index) {
			if (index < 0) {
				throw new IndexOutOfBoundsException("index < 0");
			} else if (index >= this.more.length) {
				return null;
			} else {
				return this.more[index];
			}
		}
	}
}
