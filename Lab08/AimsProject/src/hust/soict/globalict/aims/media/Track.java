package hust.soict.globalict.aims.media;

public class Track implements Playable {
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

		public void play() {
			System.out.println("Playing track: "+ this.getTitle());
			System.out.println("track Length: "+ this.getLength());
	
	}
	
	public void display() {
		System.out.println("	track Title: "+ this.getTitle());
		System.out.println("	track Length: "+ this.getLength());
	}
	
	@Override 
	public boolean equals(Object track) {
		if (track instanceof Track) {
			return (this.title==((Track)track).title&&this.length==((Track)track).length);
		}
		else return false;
	}
	
}
