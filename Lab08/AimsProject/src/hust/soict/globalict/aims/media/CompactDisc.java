package hust.soict.globalict.aims.media;
import java.time.LocalDate;
import java.util.ArrayList;


public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}

	public CompactDisc() {
		super();
	}


	public CompactDisc(String artist, ArrayList<Track> tracks ,String title, String category, String director, float cost) {
		super(title, category, director, cost);
		this.artist = artist;
		this.tracks = tracks;
	}

	public CompactDisc(String artist, ArrayList<Track> tracks ,String title) {
		super(title);
		this.artist = artist;
		this.tracks = tracks;
		
	}
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("This track is already in the list!");
		}
		else {
			tracks.add(track);
			System.out.println("This track's been added to the list!");
		}
	}
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("This track's been removed!");
		}
		else {
			System.out.println("This strack is not in the list!");
		}
	}
	public int getLength() {
		int sum=0;
		for (Track temp: tracks) {
			sum+=temp.getLength();
		}
		return sum;
	}

	@Override
	public void play() {
		System.out.println("Playing CD: "+ this.getTitle());
		System.out.println("CD Length: "+ this.getLength());
		for (Track temp: tracks) {
			temp.play();
		}
	}
	public void display() {
		System.out.println("CD - " + this.getTitle()+" - " + this.getCategory()+" - "+ this.getDirector()+" - " + this.getLength()+": "+ this.getCost()+"$"+"(id="+this.getId()+")"+"(dateAdded="+this.getDateAdded()+")");
		System.out.println(" Artist: "+this.getArtist());
		int i=1;
		for (Track temp: tracks) {
			System.out.println(" Track "+i+":");
			i+=1;
			temp.display();
		}
	}

	
	
	
}
