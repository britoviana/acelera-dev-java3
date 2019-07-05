package challenge;

public class Player {

	private String full_name;
	private String club;
	private int age;
	private String birth_date;
	private String nationality;
	private Double eur_release_clause;
	private Double eur_wage;


	public Player(String full_name, String club, int age, String birth_date, String nationality, Double eur_release_clause, Double eur_wage) {
		super();
		this.full_name = full_name;
		this.club = club;
		this.age = age;
		this.birth_date = birth_date;
		this.nationality = nationality;
		this.eur_release_clause = eur_release_clause;
		this.eur_wage = eur_wage;
	}

	//Getters, setters

	public String getName() {
		return full_name;
	}

	public String getClub() {
		return club;
	}

	public int getAge() {
		return age;
	}

	public String getBirthDate() {
		return birth_date;
	}

	public String getNationality() {
		return nationality;
	}

	public Double getReleaseClause() {
		return eur_release_clause;
	}

	public Double getWage() {
		return eur_wage;
	}

        @Override
        public String toString() {
            return "Player [name= " + full_name + ", age= " + age + ", birth date= " + birth_date + ", nationationlity= " + nationality + ", release clause= " + String.format("EUR %.1f M", eur_release_clause / 1000000.0) + " EUR, wage= " + eur_wage + " EUR]";
	}
}