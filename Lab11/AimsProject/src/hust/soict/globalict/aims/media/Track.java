package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable,Comparable<Track> {
	private String title;
	private int length;
	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public Track(String title) {
		super();
		this.title = title;
	}

	public Track(int length) {
		super();
		this.length = length;
	}


	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

		public void play() throws PlayerException {
			if (this.getLength()>0) {
			System.out.println("Playing track: "+ this.getTitle());
			System.out.println("track Length: "+ this.getLength());
			}
			else 
				throw new PlayerException("ERROR: Track length is non-positive!");
	}
		public String playToString() {
			String str = "";
			str+= "Playing track: "+ this.getTitle()+"\n";
			str+="track Length: "+ this.getLength()+"\n";
			return str;
	
	}
	
	public void display() {
		System.out.println("	track Title: "+ this.getTitle());
		System.out.println("	track Length: "+ this.getLength());
	}
	public String toString() {
		String str="";
		str+= "	track Title: "+ this.getTitle()+"\n";
		str+= "	track Length: "+ this.getLength()+"\n";
		return str;
	}
	
	
	@Override 
	public boolean equals(Object obj) {
		if (obj instanceof Track) {
			return (this.title.equals(((Track)obj).getTitle())&&this.length==((Track)obj).getLength());
		}
		else return false;
	}

	@Override
	public int compareTo(Track o) {
		int r=this.getTitle().compareTo(o.getTitle());
		if (r==0) 
			return this.getLength() - o.getLength();
		else 
			return r;
	}
	
}
