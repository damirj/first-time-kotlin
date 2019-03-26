package zadatak1;

public abstract class Person {
	public static String DEFAULT_NAME = "John Doe";
	public static String DEFAULT_COUNRTY = "Noland";
	public static int DEFAULT_EMOTION = 50;
	final private String name;

	final private String country;

	private int emotion = DEFAULT_EMOTION;

	public Person() {
		this.name = DEFAULT_NAME;
		this.country = DEFAULT_COUNRTY;
	}
	
	public Person(String name, String country, int emotion) {
		if(name == null || country == null || (emotion < 0 || emotion > 100)) {
			throw new IllegalArgumentException("nist ti nevalja buraz");
		}
		this.name = name;
		this.country = country;
		this.emotion = emotion;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) { 
            return true; 
        } 
		
		if (!(o instanceof Person)) { 
            return false; 
        }
		
		Person p = (Person) o; 
        
        return name.contentEquals(p.name) == true && country.contentEquals(p.country) == true;
	}

	public String getCountry() {
		return country;
	}
	
	public int getEmotion() {
		return emotion;
	}

	public void setEmotion(int emotion) {
		this.emotion = emotion;
	}
	
	public String getName() {
		return name;
	}	
}
