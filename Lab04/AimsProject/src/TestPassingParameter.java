/*
 After the call of swap(jungleDVD, cinderellaDVD) why does the title of these two
objects still remain?
	public static void swap(Object o1, Object o2) {
			Object tmp = o1;
			o1 = o2;
			o2 = tmp;
		}
*o1 point to jungleDVD, o2 point to cinderellaDVD. We create an object tmp, point to
*jugleDVD also (tmp = o1). And we change o1 point to cinderellaDVD (o1 = o2), o2 point
*to jungleDVD (o2 = tmp). After all, jungleDVD still point to the object has title 'jungle'
*an the same as cinderellaDVD. what we do is just to change o1 with o2 because JAVA always
*pass value. 

 After the call of changeTitle(jungleDVD, cinderellaDVD.getTitle()) why is
the title of the JungleDVD changed?
*When we pass jungleDVD to dvd, dvd would take value of jungle DVD. However 
*Object variables in Java always point to the real object in the memory heap.
*So if we change title of DVD by dvd.setTitle(), that means we ask the dvd to change 
*itself and it would affect to the JungleDVD object (pointed by dvd).
*if we call dvd = new DigitalVideoDisc(oldTitle), dvd will point to another new DVD 
*which has different id from jugleDVD so jungleDVD would not change anything. 
 */

public class TestPassingParameter {

	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: "+jungleDVD.getTitle());
		System.out.println("cinderella dvd title: "+cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: "+jungleDVD.getTitle());		

	}
	// create all setters in DigitalVideoDisc
	// another way to swap is to use DVDWrapper
	public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
		DigitalVideoDisc tmp = new DigitalVideoDisc();
		tmp.setTitle(o1.getTitle());
		tmp.setLength(o1.getLength());
		tmp.setCost(o1.getCost());
		tmp.setDirector(o1.getDirector());
		tmp.setCategory(o1.getCategory());
		
		o1.setTitle(o2.getTitle());
		o1.setLength(o2.getLength());
		o1.setCost(o2.getCost());
		o1.setDirector(o2.getDirector());
		o1.setCategory(o2.getCategory());
		
		o2.setTitle(tmp.getTitle());
		o2.setLength(tmp.getLength());
		o2.setCost(tmp.getCost());
		o2.setDirector(tmp.getDirector());
		o2.setCategory(tmp.getCategory());
	}
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}

}
