package net.fantasticfantasy.engine3d;

import net.fantasticfantasy.engine3d.util.CollectionUtil;

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
		
		public final int major;
		public final int minor;
		public final int revision;
		
		public Version(int major, int minor, int revision, int... more) {
			this.major = major;
			this.minor = minor;
			this.revision = revision;
		}
	}
}
